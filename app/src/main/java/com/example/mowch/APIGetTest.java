package com.example.mowch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.*;
import com.android.volley.toolbox.*;




public class APIGetTest extends AppCompatActivity {

    //final TextView textView = new TextView(this);
    // ...


    public void getTestRequest(String url) {
        RequestQueue requestQueue;

        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);

        // Start the queue
        requestQueue.start();

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       System.out.println("THIS IS GOOGLE YEET " + response.substring(0, 100));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error error you're dumb");
                        System.out.println(error.toString());
                    }
                });

        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);

    }

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getTestRequest("http://www.google.com");
    }
}
