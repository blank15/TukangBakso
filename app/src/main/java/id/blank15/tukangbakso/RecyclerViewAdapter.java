package id.blank15.tukangbakso;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blank15 on 07/04/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
//    ArrayList<Drawable> img;
//    ArrayList<String> nama;
//    ArrayList<String> harga;
    List<Menu> menuList=new ArrayList<>();
    DbHelper dbHelper;

    public RecyclerViewAdapter(Context context, List<Menu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    //    public RecyclerViewAdapter(Context context, ArrayList<Drawable> img, ArrayList<String> nama, ArrayList<String> harga) {
//        this.context = context;
//        this.img = img;
//        this.nama = nama;
//        this.harga = harga;
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_makanan,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        dbHelper=DbHelper.getInstance(context);

        Menu menu=menuList.get(position);

        holder.textViewHarga.setText(menu.getHarga());
        holder.textViewNama.setText(menu.getNamaMenu());
    }


    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewNama;
        TextView textViewHarga;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgMakanan);
            textViewNama = itemView.findViewById(R.id.textNama);
            textViewHarga = itemView.findViewById(R.id.textHarga);
        }
    }
}
