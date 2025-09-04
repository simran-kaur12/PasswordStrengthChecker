package com.app.passwordchecker

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.app.passwordchecker.databinding.ActivityMainBinding
import com.app.passwordchecker.model.PasswordStrength
import com.app.passwordchecker.viewModel.PasswordViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: PasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.strength.observe(this) { strength ->
            binding.strengthTextView.text = when (strength) {
                PasswordStrength.WEAK -> "Weak 🔴"
                PasswordStrength.MEDIUM -> "Medium 🟠"
                PasswordStrength.STRONG -> "Strong 🟢"
            }
        }
    }
}