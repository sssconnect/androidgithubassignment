package com.example.shailendra.githublogin.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.shailendra.githublogin.Model.RepositraryDetails;
import com.example.shailendra.githublogin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String url;
    String userName;
    EditText edt_userName;
    Button btn_submit;
    RequestQueue mRequestQueue;

    RepositraryDetails repositraryDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_userName = (EditText) findViewById(R.id.userName);
        btn_submit =(Button) findViewById(R.id.submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = edt_userName.getText().toString();
                if(userName.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please Enter the UserName",Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, RepositaryList.class);
                    intent.putExtra("userName", userName);
                    startActivity(intent);
                }



            }
        });


    }

}
