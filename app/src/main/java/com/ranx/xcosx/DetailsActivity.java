package com.ranx.xcosx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;

public class DetailsActivity extends AppCompatActivity {

    public TextView textView;
    public String title;
    public ImageView imageView;
    public String subTitle;
    public TextView stvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textView=findViewById(R.id.textTitle);
        stvTitle=findViewById(R.id.subtitle);
        imageView=findViewById(R.id.image_view);

        Intent in = getIntent();

        title = in.getStringExtra("title");
        subTitle=in.getStringExtra("subTitle");
        //String picture = in.getStringExtra("image_draw");

       // Bundle extras = getIntent().getExtras();
        String fileName = in.getStringExtra("image_draw");

        Bitmap receivedimage =in.getParcelableExtra("image_draw");
        receivedimage = Bitmap.createScaledBitmap(receivedimage , 260, 260, false);
        //File filePath = getFileStreamPath(fileName);
      //  Drawable d = Drawable.createFromPath(filePath.toString());
        imageView.setImageBitmap(receivedimage);



        Toast.makeText(this, "Heljdlsd "+title, Toast.LENGTH_SHORT).show();

        textView.setText(title);
        stvTitle.setText(subTitle);

        /*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
}
