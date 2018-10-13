package com.example.josephtessier.gphyexam;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    int iconId;
    String name;
    String poso;

    NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int index = getIntent().getIntExtra("INDEX", 0);

        // Medication name
        name = getText(R.string.medication_name) + " " + index;
        TextView tv1 = findViewById(R.id.tv_medicName);
        tv1.setText(name);

        // Posology
        poso = getResources().getStringArray(R.array.posologies)[index - 1];
        TextView tv2 = findViewById(R.id.tv_posology);
        tv2.setText(poso);

        // icon
        iconId = getIntent().getIntExtra("ICON", 0);
        ImageView imageView = findViewById(R.id.iv_detailPanel);
        imageView.setImageResource(iconId);
    }

    /*
    public void onClick(View v) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(iconId);
        builder.setContentTitle(name);
        builder.setContentText(poso);

        notificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);

        notificationManager.notify(0, builder.build());
    }
    */

}
