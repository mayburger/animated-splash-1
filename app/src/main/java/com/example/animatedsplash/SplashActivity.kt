package com.example.animatedsplash

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.animatedsplash.databinding.ActivitySplashBinding
import com.example.animatedsplash.utils.ViewUtils.addTransitionListener
import com.example.animatedsplash.utils.ViewUtils.delay

class SplashActivity : AppCompatActivity() {

    lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.motion.addTransitionListener(onStart = { p0, p1, p2 ->
        }, onEnd = { motion, currentId ->
            when (currentId) {
                R.id.first -> binding.motion.transitionToState(R.id.second)
                R.id.second -> {
                    binding.logo.setOnClickListener {
                        openNextActivity()
                    }
                    delay(500){
                        openNextActivity()
                    }
                }
            }
        })
    }

    fun openNextActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        val options = ActivityOptions
            .makeSceneTransitionAnimation(this, Pair.create(binding.logo, "logo"))
        startActivity(intent, options.toBundle())
    }
}