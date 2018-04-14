package id.blank15.tukangbakso;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Drawable> img = new ArrayList<>();
    ArrayList<String> nama = new ArrayList<>();
    ArrayList<String> harga = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView)findViewById(R.id.rview);

        img.add(getResources().getDrawable(R.drawable.beranak));
        img.add(getResources().getDrawable(R.drawable.esteh));
        img.add(getResources().getDrawable(R.drawable.jumbo));

        nama.add("Bakso Beranak");
        nama.add("Es teh");
        nama.add("Jumbo");

        harga.add("Rp.12.000");

        harga.add("Rp.5.000");
        harga.add("Rp.20.000");


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(HomeActivity.this,img,nama,harga);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        recyclerView.setAdapter(adapter);

    }
}
