package com.example.test.gridview;

import android.content.Intent;
import android.content.IntentSender;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.country;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        if(intent != null){
            int imageId = intent.getIntExtra("countryImage",R.drawable.a);

            String countryname= intent.getStringExtra("countryName");
            ImageView myImage = (ImageView) findViewById(R.id.imageView2);
            myImage.setImageResource(imageId);
            TextView myText = (TextView) findViewById(R.id.textView);
            myText.setText("This flag belongs to "+ countryname);
        }
    }

    public void CloseDialog(View view) {
        finish();
    }
}
