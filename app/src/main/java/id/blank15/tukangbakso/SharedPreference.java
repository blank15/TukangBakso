package id.blank15.tukangbakso;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by blank15 on 14/04/2018.
 */

public class SharedPreference {
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    public SharedPreference(Context context) {
        this.sharedPreferences = context.getSharedPreferences("bakso",Context.MODE_PRIVATE);
        this.editor = editor;
    }

    public String getLogin(){
        return sharedPreferences.getString("Login","tidak");
    }
}
