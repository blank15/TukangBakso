package id.blank15.tukangbakso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    EditText editTextNama, editTextHarga;
    Button buttonSave;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        editTextNama=(EditText)findViewById(R.id.et_nama_menu);
        editTextHarga=(EditText)findViewById(R.id.et_harga);
        buttonSave=(Button)findViewById(R.id.btn_insert);
        dbHelper=DbHelper.getInstance(getApplicationContext());

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mendeklarasikan class menu
                Menu menu=new Menu();

                //mengatur value untuk harga dan nama menu bedasarkan inputan user
                menu.setNamaMenu(editTextNama.getText().toString());
                menu.setHarga(editTextHarga.getText().toString());

                //proses input ke database
                dbHelper.insertMenu(menu);

                //pindah ke activity home
                Intent intent=new Intent(InsertActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
