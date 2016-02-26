package com.inventory.lab.compsci.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.activities.MainActivity;
import com.inventory.lab.compsci.tasks.AsyncResult;
import com.inventory.lab.compsci.tasks.DownloadWebPageTask;
import com.inventory.lab.compsci.tasks.UpdateDataTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class LoginFragment extends Fragment {
    Button mLogin;
    EditText mId,mpassword;
    ProgressBar progressBar;
    TextView minfo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.login_fragment,container,false);
        minfo = (TextView)v.findViewById(R.id.info);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar);
        mId = (EditText)v.findViewById(R.id.input_id);
        mpassword = (EditText)v.findViewById(R.id.input_password);
        mLogin = (Button)v.findViewById(R.id.btn_login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setIndeterminate(true);
                minfo.setText("Fetching Item List");
                minfo.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                new DownloadWebPageTask(new AsyncResult() {
                    @Override
                    public void onResult(JSONObject object) {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        minfo.refreshDrawableState();
                        minfo.setText("Updating Database");
                        new UpdateDataTask(object);
                        minfo.setText("Complete");
                        minfo.setVisibility(View.GONE);
                        progressBar.setVisibility(View.INVISIBLE);
                        startActivity(i);
                    }
                }).execute("https://spreadsheets.google.com/tq?key=18gKByXS6AOpC9Kt6Ua0wpTXOHlAdAQsYD0hdVgq4rGk");

            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


}
