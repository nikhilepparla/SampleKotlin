package com.example.myapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    final val TAG = "Nikhil";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.network.setOnClickListener {

            var isInternetConnectedBool: Boolean = this.isConnected(this);
            val internetStatusToast: String;
            if (isInternetConnectedBool) {
                internetStatusToast = "Internet Connected"
                Log.d("Nikhil", internetStatusToast)
            } else {
                internetStatusToast = "Internet is Dis-Connected"
                Log.d("Nikhil", internetStatusToast)
            }
            if (!internetStatusToast.isNullOrBlank()) {
                Toast.makeText(this, internetStatusToast, Toast.LENGTH_SHORT).show()
            }

        }
    }


    fun isConnected(context: Context): Boolean {
        var connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || capabilities.hasTransport(
                        NetworkCapabilities.TRANSPORT_WIFI
                    )
                ) {
                    return true;
                }
            }
        }
        return false
    }
}


