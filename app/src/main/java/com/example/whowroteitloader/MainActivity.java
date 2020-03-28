package com.example.whowroteitloader;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whowrote.R;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    DownloadImageTask downloadImage;
    static TextView myText;
    static ImageView myImage;

    ConnectivityManager myConnectivityManager;
    NetworkInfo myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView)findViewById(R.id.myResult);
        myImage = (ImageView)findViewById(R.id.myImageResult);

        myConnectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnectivityManager.getActiveNetworkInfo();
    }

    public void doSomething(View view) {
        c1 = new ConnectInternetTask(this);
        c1.execute("https://www.google.com");
    }

    public void downloadImage(View view) {
        if (myInfo != null && myInfo.isConnected()){
            downloadImage = new DownloadImageTask();
            downloadImage.execute("http://www.pixelstalk.net/wp-content/uploads/2016/08/Android-Backgrounds-Cool-HD-Free-Download.jpg");


        }else {
            Toast.makeText(this,"Internet Not Connected",Toast.LENGTH_SHORT);
        }
    }
}
