package com.creative.athletes.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBar;
import com.bumptech.glide.Glide;
import com.creative.athletes.R;

public class AthleteDetailsActivity extends AppCompatActivity {


    private TextView NameView, BriefView;
    private ImageView ImgView;

    private static String Name, Image, Brief;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        initViews();
        NameView.setText(Name);
        if (!Image.equals("") && Image != null) {
            ImgView.setVisibility(View.VISIBLE);
            Glide.with(this).load(Image)
                    .into(ImgView);
        } else
            ImgView.setVisibility(View.GONE);

        BriefView.setText(Brief);

    }


    private void initViews() {
        NameView = (TextView) findViewById(R.id.tv_name);
        ImgView = (ImageView) findViewById(R.id.iv_image);
        BriefView = (TextView) findViewById(R.id.tv_brief);

    }


    public static void start(Context context, String name, String image, String brief) {

        Name = name;
        Image = image;
        Brief = brief;

        Intent starter = new Intent(context, AthleteDetailsActivity.class);
        context.startActivity(starter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
