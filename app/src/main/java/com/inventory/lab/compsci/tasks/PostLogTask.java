package com.inventory.lab.compsci.tasks;

import android.os.AsyncTask;

import android.util.Log;
import android.widget.Toast;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by peoplesoft on 2/26/2016.
 */
public class PostLogTask extends AsyncTask<String, Void ,Boolean> {
    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public final static String ITEM= "entry_878709107";
    public final static  String ROW = "entry_1996982599";
    public final static String TEST_PERIOD = "entry_449710859";
    public final static String STATUS = "entry_1946499204";
    public final static String COMMENTS = "entry_2135324869";
    public final static String USER = "entry_1008306626";
    public final static String url ="https://docs.google.com/forms/d/134W4LgPQD8P51Nud4_55K5UwuiXIndxFYBotTEe-StI/formResponse";

    AsyncResultMessage callback;
    public PostLogTask(AsyncResultMessage callback) {
        this.callback = callback;
    }


    @Override
    protected Boolean doInBackground(String... data) {
        Boolean result = true;
        String item =data[0];
        String row = data[1];
        String test_period = data[2];
        String status = data[3];
        String comments = data[4];
        String user = data[5];
        String postBody="";

        try {
            //all values must be URL encoded to make sure that special characters like & | ",etc.
            //do not cause problems
            postBody = ITEM+"=" + URLEncoder.encode(item, "UTF-8") +
                    "&" + ROW + "=" + URLEncoder.encode(row,"UTF-8") +
                    "&" + TEST_PERIOD + "=" + URLEncoder.encode(test_period,"UTF-8")+
            "&" + STATUS + "=" + URLEncoder.encode(status,"UTF-8") +
                    "&" + COMMENTS + "=" + URLEncoder.encode(comments,"UTF-8")+
            "&" + USER + "=" + URLEncoder.encode(user,"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            result=false;
        }
        try {
            //Create OkHttpClient for sending request
            OkHttpClient client = new OkHttpClient();
            //Create the request body with the help of Media Type
            RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            //Send the request
            Response response = client.newCall(request).execute();
        }catch (IOException exception){
            result=false;
        }
        return result;
    //}
    }


    @Override
    protected void onPostExecute(Boolean result) {
        //Print Success or failure message accordingly
        Log.d("Posting Result", result ? "Message successfully sent!" : "There was some error in sending message. Please try again after some time.");
        callback.onResult(result ? "Message successfully sent!" : "There was some error in sending message. Please try again after some time.");
        super.onPostExecute(result);
    }
}
