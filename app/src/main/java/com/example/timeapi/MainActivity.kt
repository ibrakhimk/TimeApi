package com.example.timeapi

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.timeapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val handler = Handler(Looper.getMainLooper())
    val delayMillis = 1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnGet.setOnClickListener {
            updateTime()
//        }

    }

    private fun updateTime() {
        ServiceTime().api.getTime().enqueue(object : Callback<ModelTime> {
            override fun onResponse(call: Call<ModelTime>, response: Response<ModelTime>) {
                if (response.isSuccessful) {
                    val datetime = response.body()?.datetime
                    val time = datetime?.substring(11, 19)
                    binding.tvText.text = time
                    handler.postDelayed(::updateTime, delayMillis)
                }
            }

            override fun onFailure(call: Call<ModelTime>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
