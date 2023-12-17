package dev.bogibek.testing.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import dev.bogibek.testing.R
import dev.bogibek.testing.data.email
import dev.bogibek.testing.data.password
import dev.bogibek.testing.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.apply {

            etEmail.addTextChangedListener {
                bLogin.isEnabled = it!!.isNotEmpty() && etPassword.text!!.isNotEmpty()
            }

            etPassword.addTextChangedListener {
                bLogin.isEnabled = it!!.isNotEmpty() && etEmail.text!!.isNotEmpty()
            }

            bLogin.setOnClickListener {
                loginUserToApp()
            }
        }
    }

    private fun loginUserToApp() {
        binding.apply {
            if (etEmail.text.toString() == email && etPassword.text.toString() == password) {
                tvAbout.text = getString(R.string.str_success)
            } else {
                tvAbout.text = getString(R.string.str_error)
            }
        }
    }
}