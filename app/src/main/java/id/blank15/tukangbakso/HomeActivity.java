package id.blank15.tukangbakso;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button;
//    ArrayList<Drawable> img = new ArrayList<>();
//    ArrayList<String> nama = new ArrayList<>();
//    ArrayList<String> harga = new ArrayList<>();

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView)findViewById(R.id.rview);
        button=(Button)findViewById(R.id.btn_input);

        dbHelper=DbHelper.getInstance(getApplicationContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(HomeActivity.this, dbHelper.getMenu());
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
