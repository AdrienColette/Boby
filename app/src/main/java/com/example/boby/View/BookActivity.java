package com.example.boby.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.boby.R;

public class BookActivity extends AppCompatActivity {

    TextView tvtitle;
    TextView tvdesc;
    TextView tvstat;
    ImageView tvbookthumbnail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String Title = getIntent().getExtras().getString("Title");
        String LongDescription = getIntent().getExtras().getString("LongDescription");
        String Status = getIntent().getExtras().getString("Status");
        String ThumbnailUrl = getIntent().getExtras().getString("ThumbnailUrl");

        tvtitle = findViewById(R.id.txttitle);
        tvdesc = findViewById(R.id.txtdesc);
        tvstat = findViewById(R.id.txtstat);
        tvbookthumbnail = findViewById(R.id.bookthumbnail);


        tvtitle.setText(Title);
        tvdesc.setText(LongDescription);
        tvstat.setText(Status);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.color_ic_launcher).error(R.drawable.color_ic_launcher);

        Glide.with(this).load(ThumbnailUrl).apply(requestOptions).into(tvbookthumbnail);



    }
}
