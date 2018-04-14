package id.blank15.tukangbakso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joedhaalzelvin on 14/04/18.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = "DbHelper";

    private static final String DATABASE_NAME = "tukangbakso";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_INPUT = "tabel_menu";

    private static final String ID = "id";
    private static final String NAMA_MENU = "nama_menu";
    private static final String HARGA = "harga";

    private static DbHelper dbHelper;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateTabelJadwal = "create table " +
                TABLE_INPUT +
                " (" +
                ID + " integer primary key autoincrement not null," +
                NAMA_MENU + " text," +
                HARGA + " text" +
                ");";

        sqLiteDatabase.execSQL(queryCreateTabelJadwal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int lama, int baru) {
        if (lama != baru){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_INPUT);
            onCreate(sqLiteDatabase);
        }
    }

    public static synchronized DbHelper getInstance(Context context){
        if (dbHelper == null){
            dbHelper = new DbHelper(context.getApplicationContext());
        }
        return dbHelper;
    }

    private DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertMenu(Menu menu){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.beginTransaction();

        try {
            ContentValues values = new ContentValues();
            values.put(NAMA_MENU, menu.getNamaMenu());
            values.put(HARGA, menu.getHarga());

            sqLiteDatabase.insertOrThrow(TABLE_INPUT, null, values);
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e){
            e.printStackTrace();
            Log.d(TAG, "Gagal Untuk Menambah"+e);
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    public List<Menu> getMenu(){
        List<Menu> jadwalList = new ArrayList<>();
        String JADWAL_QUERY = " SELECT * FROM "+ TABLE_INPUT;

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(JADWAL_QUERY, null);

        try{
            if (cursor.moveToFirst()){
                do {
                    Menu menu = new Menu(
                            cursor.getString(cursor.getColumnIndex(ID)),
                            cursor.getString(cursor.getColumnIndex(NAMA_MENU)),
                            cursor.getString(cursor.getColumnIndex(HARGA)));

                    Log.d(ID, cursor.getString(cursor.getColumnIndex(ID)));
                    jadwalList.add(menu);
                }
                while (cursor.moveToNext());
            }
        } catch (SQLException e){
            Log.d(TAG, "Gagal Mendapat Data");
        } finally {
            if (cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }

        return jadwalList;
    }

    public void deleteJadwal(String id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        try{
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL("DELETE FROM " + TABLE_INPUT + " WHERE " + ID + " = '" + id + "'");
            sqLiteDatabase.setTransactionSuccessful();
            Log.d(TAG, "Berhasil Menghapus Data");
        } catch (SQLException e){
            e.printStackTrace();
            Log.d(TAG, "Gagal Menghapus Data");
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    public void updateData(Menu menu){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        try{
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL("UPDATE " + TABLE_INPUT + " SET " +
                    NAMA_MENU + " = '" + menu.getNamaMenu() + "', " +
                    HARGA + " = '" + menu.getHarga() + "' WHERE " +
                    ID + " = '" + menu.getId() + "'");
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e){
            e.printStackTrace();
            Log.d(TAG, "Gagal Update Data");
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }
}
