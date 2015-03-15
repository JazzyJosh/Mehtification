package net.speakerdocks.mehtification;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class RetrieveDealService extends Service {
    
    private NotificationManager notificationManager;
    private RequestQueue requestQueue;
    
    private static final String MEH_API_URL = "https://api.meh.com/1/current.json?apikey=";
    
    public class RetrieveDealServiceBinder extends Binder {
        RetrieveDealService getService() {
            return RetrieveDealService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder() {
        };
    }
    
    @Override
    public void onCreate() {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        requestQueue = Volley.newRequestQueue(this);
        //TODO: Logic to tell if same day as current deal
        //TODO: This probably shouldn't be in onCreate
        JsonObjectRequest dealRequest = new JsonObjectRequest(Request.Method.GET, MEH_API_URL + getString(R.string.apiKey), null,
                //TODO: Refactor these listeners
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject deal) {
                        try {
                            Log.i(this.getClass().toString(), "Title: " + deal.getJSONObject("deal").getString("title"));
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
            
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(this.getClass().toString(), "Something went terribly wrong");
                    Log.e(this.getClass().toString(), error.getMessage());
                }
            });
        
        requestQueue.add(dealRequest);
    }

}
