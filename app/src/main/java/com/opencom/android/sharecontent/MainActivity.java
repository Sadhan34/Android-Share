package com.opencom.android.sharecontent;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    String email="titas156@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.shareText);
        b2=(Button)findViewById(R.id.shareImage);
        b1.setOnClickListener(myHandler);
        b2.setOnClickListener(myHandler);
    }
    View.OnClickListener myHandler=new View.OnClickListener(){
        public void onClick(View v){
            switch (v.getId()){
                case R.id.shareText:
                    shareTextUrl();
                    break;
                case R.id.shareImage:
                    shareImage();
                    break;
            }
        }
    };

    public void shareTextUrl(){
        String to="titas156@gmail.com";
        Intent share=new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, "I am gonna check it");
        share.putExtra(Intent.EXTRA_SUBJECT,"Subject is here");
        share.putExtra(Intent.EXTRA_EMAIL,to);
        share.putExtra(Intent.EXTRA_CC,"sayekat@gmail.com");
        startActivity(share);
        //Toast.makeText(getApplicationContext(),"Text Share",Toast.LENGTH_LONG).show();
    }
    public void shareImage(){
        Uri img=Uri.parse("android.resource://com.opencom.android.sharecontent/"+R.drawable.h); //Include JPEG image
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, img);
        intent.setType("image/jpeg");
        startActivity(Intent.createChooser(intent, "Share Image!"));
        //startActivity(Intent.createChooser(intent, getResources().getText(R.string.app_name)));
        Toast.makeText(getApplicationContext(),""+img,Toast.LENGTH_LONG).show();

    }
}
