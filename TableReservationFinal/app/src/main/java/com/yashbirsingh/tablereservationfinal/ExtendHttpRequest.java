package com.yashbirsingh.tablereservationfinal;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yashbir on 27/10/15.
 */
public class ExtendHttpRequest extends AsyncTask<int [], Void, String> {
    private Exception exception;

    protected String doInBackground(int []... urls) {
        URL url = null;
        int length = 500;
        String response_api = "";
        int response = 0;
        try {
            String new_url = "http://192.168.1.104:3000/restaurants/"+urls[0][0]+"/2";
            url = new URL(new_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            response = conn.getResponseCode();
            Log.i("tag", "The response" + response);
            InputStream is = conn.getInputStream();
            return convertInputStreamToString(is, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response_api;
    }

    public String convertInputStreamToString(InputStream stream, int length) throws IOException, UnsupportedEncodingException {
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();

        String inputStr, outputStr = "";
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);
        try {
            JSONObject js = new JSONObject(responseStrBuilder.toString());
            return js.getString("restaurants");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return outputStr;
    }
}
