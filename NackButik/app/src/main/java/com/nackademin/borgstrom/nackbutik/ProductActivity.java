package com.nackademin.borgstrom.nackbutik;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int productid = getIntent().getIntExtra("productid", 0);

        final TextView header = (TextView) findViewById(R.id.productheader);
        final TextView description = (TextView) findViewById(R.id.productdescription);
        final TextView price = (TextView) findViewById(R.id.productprice);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://nackbutik.azurewebsites.net/GetProduct?productid=" +productid;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Product product = new Product(response.getString("Name"), response.getString("Description"), response.getDouble("Price"));
                            header.setText(product.name);
                            description.setText(product.description);
                            price.setText(String.valueOf(product.price));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        queue.add(jsObjRequest);
    }

}
