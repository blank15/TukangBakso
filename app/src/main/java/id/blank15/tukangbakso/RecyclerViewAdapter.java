package id.blank15.tukangbakso;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by blank15 on 07/04/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Drawable> img;
    ArrayList<String> nama;
    ArrayList<String> harga;

    public RecyclerViewAdapter(Context context, ArrayList<Drawable> img, ArrayList<String> nama, ArrayList<String> harga) {
        this.context = context;
        this.img = img;
        this.nama = nama;
        this.harga = harga;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_makanan,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setBackground(img.get(position));
        holder.textViewHarga.setText(harga.get(position));
        holder.textViewNama.setText(nama.get(position));
    }


    @Override
    public int getItemCount() {
        return img.size();
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
