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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.login_fragment,container,false);
        mId = (EditText)v.findViewById(R.id.input_id);
        mpassword = (EditText)v.findViewById(R.id.input_password);
        mLogin = (Button)v.findViewById(R.id.btn_login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadWebPageTask(new AsyncResult() {
                    @Override
                    public void onResult(JSONObject object) {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        startActivity(i);
                        new UpdateDataTask(object);
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
