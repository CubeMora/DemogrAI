package com.movealonging.aidemographicapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class Function_API_Calls {
    private final String GET_RAW_DATA = "https://cubemora-forum.000webhostapp.com/carwash/ai_temp.php";


    private RequestQueue requestQueue;
    private Context context;

    public Function_API_Calls(Context context) {
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void getRawData(Response.Listener<String> responseListener, Response.ErrorListener errorListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, GET_RAW_DATA,
                responseListener, errorListener);

        requestQueue.add(stringRequest);
    }

}
