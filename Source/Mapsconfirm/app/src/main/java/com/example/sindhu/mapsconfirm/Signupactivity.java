package com.example.sindhu.mapsconfirm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class Signupactivity extends Activity {
    Button button;
    ImageView imageview;
static final int CAM_REQUEST =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        button = (Button) findViewById(R.id.button);
        imageview = (ImageView)findViewById(R.id.ad_image_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
              startActivityForResult(camera_intent,CAM_REQUEST);
            }


        });
    }
    private File getFile()
    {
        File folder = new File("sdcard/camera_app");
        if (!folder.exists())
        {
            folder.mkdir();
        }
        File image_file = new File(folder,"cam_image.jpg");
        return image_file;
    }
    @Override
    protected void onActivityResult(int requestcode, int resultCode, Intent code){
     String path = "sdcard/camera_app/cam_image.jpg";
        imageview.setImageDrawable(Drawable.createFromPath(path));
    }
}


