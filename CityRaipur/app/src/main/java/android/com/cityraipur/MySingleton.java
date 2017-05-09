package android.com.cityraipur;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by rizwan on 5/9/2017.
 */

public class MySingleton {
    private static MySingleton mySingleton;
    private  RequestQueue requestQueue;
    private static Context context;

    public MySingleton(Context context) {
        this.context = context;
        requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized MySingleton getInstance(Context context){
        if (mySingleton==null){
            mySingleton=new MySingleton(context);
        }
        return mySingleton;
    }
    public <T>void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
