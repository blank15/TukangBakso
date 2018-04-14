package id.blank15.tukangbakso;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpashScreen extends AppCompatActivity {

    private static int intreval = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        final SharedPreference preference = new SharedPreference(SpashScreen.this);

        final String ket = preference.getLogin();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               if(ket.equalsIgnoreCase("tidak")){
                    Intent intent = new Intent(SpashScreen.this,MainActivity.class);
                    startActivity(intent);
                }else {
                   Intent intent = new Intent(SpashScreen.this,HomeActivity.class);
                   startActivity(intent);
               }
            }
        },intreval);
    }
}
