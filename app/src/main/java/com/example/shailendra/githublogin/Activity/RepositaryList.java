package com.example.shailendra.githublogin.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.shailendra.githublogin.Adaptor.MyAdaptor;
import com.example.shailendra.githublogin.Model.RepositraryDetails;
import com.example.shailendra.githublogin.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class RepositaryList extends AppCompatActivity implements MyAdaptor.ListItemClickListener {
     Intent intent;
    String username,url;
    RequestQueue mRequestQueue;
    RepositraryDetails repositraryDetails;
    ArrayList<RepositraryDetails> result = new ArrayList<RepositraryDetails>();
    RecyclerView recyclerView;
    MyAdaptor myAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositary_list);
        recyclerView = (RecyclerView) findViewById(R.id.rc_view);
        myAdaptor = new MyAdaptor(getBaseContext(),result,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdaptor);
        intent = getIntent();
        username = intent.getStringExtra("userName");
        mRequestQueue = Volley.newRequestQueue(this);
        url = "https://api.github.com/users/"+username+"/repos";
        getResponse(url);
    }


    public void getResponse(String url)
    {
        Log.e("url",url);
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET,
                url,null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.e("response", response.toString());


                    try {
                        for (int i=0;i<response.length();i++) {
                            String full_name = response.getJSONObject(i).getString("full_name");
                            String html_url = response.getJSONObject(i).getString("html_url");
                            String desc = response.getJSONObject(i).getString("description");
                            Log.e("RESPONSE", full_name + " " + " " + html_url + " " + desc);
                            repositraryDetails = new RepositraryDetails(full_name, html_url, desc);
                            result.add(repositraryDetails);
                        }
                        myAdaptor.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("responseError", error.getMessage());

            }
        }
        );
        mRequestQueue.add(jsonObjReq);
    }

    @Override
    public void onItemClick(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
}
