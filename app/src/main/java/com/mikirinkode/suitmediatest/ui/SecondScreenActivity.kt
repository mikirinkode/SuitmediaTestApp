package com.mikirinkode.suitmediatest.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikirinkode.suitmediatest.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {

    private val binding: ActivitySecondScreenBinding by lazy {
        ActivitySecondScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            tvUserName.text = "Muhammad Wafa Al Ausath"

            btnChooseUser.setOnClickListener {
                startActivity(Intent(this@SecondScreenActivity, ThirdScreenActivity::class.java))
            }

            btnBack.setOnClickListener {
                onBackPressed()
            }
        }
    }


}