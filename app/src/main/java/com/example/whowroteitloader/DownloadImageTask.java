package com.example.whowroteitloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadImageTask  extends AsyncTask<String,Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... strings) {
        String s1 = strings[0];
        InputStream in;

        try {
            URL myUrl = new URL(s1);
            HttpURLConnection myCom = (HttpURLConnection) myUrl.openConnection();
            myCom.setConnectTimeout(20000);
            myCom.setReadTimeout(10000);
            myCom.setRequestMethod("GET");
            myCom.connect();

            in = myCom.getInputStream();

            Bitmap myMap = BitmapFactory.decodeStream(in);

            return myMap;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        MainActivity.myImage.setImageBitmap(bitmap);
    }
}
