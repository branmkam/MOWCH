package com.example.mowch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class APIGetData extends AppCompatActivity {

    String token;
    JSONObject json1;
    final String server = "dev-fms18-01.soliantconsulting.com";
    final String file = "MealsOnWheels.fmp12";
    final String layout = "API_RCP";
    final String username = "dataapi";
    final String pw = "MOWSoliant";

    public APIGetData(String token)
    {
        this.token = token;
    }

    public void getJSONRequest(String url) {
        final JSONObject[] toReturn = {null};
        Cache cache2 = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network2 = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        RequestQueue requestQueue2 = new RequestQueue(cache2, network2);

        // Start the queue
        requestQueue2.start();
        // Formulate the request and handle the response.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        System.out.println(response.toString().substring(0,100));
//                        toReturn[0] = response;
                        json1 = response;
                        try {
                            JSONArray data = json1.getJSONArray("data");
                            for(int i = 0; i < data.length(); i++)
                            {
                                JSONObject fieldData = data.getJSONObject(i);
                                System.out.println(fieldData.getString("Name_Full_c"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                try {
                    String auth = "Bearer " + token;
                    headers.put("Authorization", auth);
                    headers.put("Content-type","application/json");
                    headers.put("Accept","application/json");
                    return headers;
                }
                catch (Exception e)
                {
                    System.out.println("Authentication Failure");
                    e.printStackTrace();
                }
                return headers;
            }
        };

        // Add the request to the RequestQueue.
        requestQueue2.add(jsonObjectRequest);
//        return toReturn[0];
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        APIGetTest apiGetTest = new APIGetTest();
        token = apiGetTest.token;
        getJSONRequest("https://" + server + "/fmi/data/vLatest/databases/" + file + "/layouts/" + layout + "/records");
    }
}
