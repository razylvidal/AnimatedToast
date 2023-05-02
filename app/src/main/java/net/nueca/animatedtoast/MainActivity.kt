package net.nueca.animatedtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.nueca.animatedtoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            AnimatedToast.showToast(
                this,
                "Congratulations!",
                "You have successfully completed the course",
                R.drawable.badge
            )
        }
    }
}