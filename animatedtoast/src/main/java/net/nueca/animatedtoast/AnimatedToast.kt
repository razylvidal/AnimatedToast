package net.nueca.animatedtoast

import android.app.Activity
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import net.nueca.animatedtoast.databinding.CustomToastMessageBinding

class AnimatedToast {
    companion object {

        private lateinit var layoutInflater: LayoutInflater

        fun showToast(
            context: Activity,
            title: String? = null,
            message: String,
            icon: Int
        ) {
            layoutInflater = LayoutInflater.from(context)
            val binding = CustomToastMessageBinding.inflate(layoutInflater)
            val layout = binding.root

            binding.icon.setImageDrawable(
                ContextCompat.getDrawable(context, icon)
            )

            startPulseAnimation(context, binding.icon)

            binding.title.text = title
            binding.message.text = message

            // Setting layout to toast
            val toast = Toast(context.applicationContext)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.show()
        }

        private fun startPulseAnimation(context: Activity, icon: AppCompatImageView) {
            val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
            icon.startAnimation(pulseAnimation)
        }
    }
}