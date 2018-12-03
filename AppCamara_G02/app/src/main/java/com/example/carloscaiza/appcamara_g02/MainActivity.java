package com.example.carloscaiza.appcamara_g02;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE = 100;
    private static final int REQUEST_VIDEO = 100;
    Button captureButton, captureButton1;
    ImageView imageView;
    TextView text;
    File destination, destination1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        captureButton = (Button) findViewById(R.id.capture);
        captureButton.setOnClickListener(listener);
        imageView = (ImageView) findViewById(R.id.image);
        destination = new File(Environment.getExternalStorageDirectory(), "image.jpg");

        captureButton1 = (Button) findViewById(R.id.capture1);
        captureButton1.setOnClickListener(listener1);
        text = (TextView) findViewById(R.id.file);
        destination1 = new File(Environment.getExternalStorageDirectory(), "myVideo.mp4");


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE && resultCode == Activity.RESULT_OK) {
           /* Bitmap userImage = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(userImage);*/

            try {
                FileInputStream in = new FileInputStream(destination);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 10; //Downsample by 10x
                Bitmap userImage = BitmapFactory.decodeStream(in, null, options);

                imageView.setImageBitmap(userImage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (requestCode == REQUEST_VIDEO && resultCode == Activity.RESULT_OK) {
            String location = data.getData().toString();
            text.setText(location);
        }

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(intent, REQUEST_IMAGE);

                //Add extra to save full-image somewhere
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(destination));
                startActivityForResult(intent, REQUEST_IMAGE);

            } catch (ActivityNotFoundException e) {
//Handle if no application exists
            }
        }
    };

    private View.OnClickListener listener1 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//Add (optional) extra to save video to our file
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(destination1));
//Optional extra to set video quality
                        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
                        startActivityForResult(intent, REQUEST_VIDEO);

                    } catch (ActivityNotFoundException e) {
//Handle if no application exists
                    }
                }
            };
}


