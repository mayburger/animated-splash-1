package com.example.animatedsplash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Transition
import android.view.LayoutInflater
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.animatedsplash.databinding.ActivityLoginBinding
import android.view.animation.DecelerateInterpolator
import com.example.animatedsplash.utils.ViewUtils.delay


class LoginActivity : AppCompatActivity() {

    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        window.sharedElementEnterTransition = enterTransition();
        window.sharedElementExitTransition = null
        binding.logo.setColorFilter(resources.getColor(R.color.colorPrimary))
        delay(500){
            binding.greetings.translationY = -100f
            binding.greetings.animate().translationY(0f).alpha(1f)
                .setDuration(1000)
                .start()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.logo.setColorFilter(resources.getColor(R.color.white))
    }

    private fun enterTransition(): Transition? {
        val bounds = ChangeBounds()
        bounds.interpolator = DecelerateInterpolator()
        bounds.duration = 1500
        return bounds
    }

}