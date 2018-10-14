package com.example.josephtessier.gphyexam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         preferences = getPreferences(Context.MODE_PRIVATE);


        int prefMedIndex = preferences.getInt("Medicine", -1);
        if (prefMedIndex != -1) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("ICON", preferences.getInt("MedIcon", -1));
            intent.putExtra("INDEX", prefMedIndex);
            startActivity(intent);
        }

        setContentView(R.layout.activity_main);

        Toast.makeText(this, R.string.welcome_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_webIcon){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.univ-poitiers.fr"))); // bitch i'm a one-liner !
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onIconClick(View view){
        int index;
        int id;
        switch (view.getId()){
            case R.id.iv_medic1: {
                index = 1;
                id = R.drawable.medicament1;
                break;
            }
            case R.id.iv_medic2: {
                index = 2;
                id = R.drawable.medicament2;
                break;
            }
            case R.id.iv_medic3: {
                index = 3;
                id = R.drawable.medicament3;
                break;
            }
            case R.id.iv_medic4: {
                index = 4;
                id = R.drawable.medicament4;
                break;
            }
            case R.id.iv_medic5: {
                index = 5;
                id = R.drawable.medicament5;
                break;
            }
            case R.id.iv_medic6: {
                index = 6;
                id = R.drawable.medicament6;
                break;
            }
            case R.id.iv_medic7: {
                index = 7;
                id = R.drawable.medicament7;
                break;
            }
            default:{
                index = 0;
                id = 0;
                break;
            }
        }

        preferences.edit().putInt("Medicine", index).apply();
        preferences.edit().putInt("MedIcon", id).apply();

        Intent intent = new Intent(this, DetailActivity.class);


        intent.putExtra("ICON", id);
        intent.putExtra("INDEX", index);
        startActivity(intent);
    }
}
