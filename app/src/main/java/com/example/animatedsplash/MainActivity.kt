package com.example.animatedsplash

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import com.example.animatedsplash.utils.ViewUtils.addTransitionListener
import com.example.animatedsplash.utils.ViewUtils.delay
import com.example.animatedsplash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.motion.addTransitionListener(onStart = { p0, p1, p2 ->
        }, onEnd = { motion, currentId ->
            when (currentId) {
                R.id.first -> binding.motion.transitionToState(R.id.second)
                R.id.second -> {
                    delay(500){
                        val intent = Intent(this, LoginActivity::class.java)
                        val options = ActivityOptions
                            .makeSceneTransitionAnimation(this, Pair.create(binding.logo, "logo"))
                        startActivity(intent, options.toBundle())
                        delay(1500){
                            finish()
                        }
                    }
                }
            }
        })
    }
}