package com.example.shiva.firebase;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



public class MyTokenService extends FirebaseInstanceIdService {
    public static  final String TAG = "MyTokenService";
    @Override
    public void onTokenRefresh() {
        Toast.makeText(this, "Going Inside", Toast.LENGTH_SHORT).show();
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
    }
}
