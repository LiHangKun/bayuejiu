package com.senmass.bayuejiu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.senmass.bayuejiu.Utils.RequestCodeInfo;

public class MainActivity extends AppCompatActivity {
    private Button main_choose_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_choose_city = findViewById(R.id.main_choose_city);
        main_choose_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,CityPickerActivity.class), RequestCodeInfo.GETCITY);
            }
        });
    }

    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case RequestCodeInfo.GETCITY:
                    String city=data.getExtras().getString("city");
                    if(city!= null) {

                        main_choose_city.setText(city);
                    }
                    break;
            }
        }
    }
}
