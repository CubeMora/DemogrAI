package com.movealonging.aidemographicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Act_RawDataTemp extends AppCompatActivity {

    public static List<Model_RawData> mData = new ArrayList<>();
    private RecyclerView rView_RawData;
    private Adapter_RawData adapter_RawData;
    Function_API_Calls API_Calls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_raw_data_temp);



        InitUi();

        API_Calls = new Function_API_Calls(this);
        ClearList();

        adapter_RawData = new Adapter_RawData(this, mData);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rView_RawData.setLayoutManager(layoutManager);

        rView_RawData.setAdapter(adapter_RawData);
        callAPI_RawData(API_Calls);


    }

    void InitUi(){
        rView_RawData = findViewById(R.id.rView_RawData);

    }
    public void ClearList(){
        mData.clear();

    }

    public void callAPI_RawData(Function_API_Calls API_Calls){
        mData.clear();
        API_Calls.getRawData(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        int id = jsonObject1.getInt("id");
                        String name = jsonObject1.getString("name");
                        String populationDate = jsonObject1.getString("populationDate");
                        String percentage = jsonObject1.getString("percentage");

                       mData.add(new Model_RawData(id, name, populationDate, percentage));

                    }
                    adapter_RawData.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Act_RawDataTemp.this, "Error al recuperar información: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}