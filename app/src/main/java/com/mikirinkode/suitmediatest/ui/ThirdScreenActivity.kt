package com.mikirinkode.suitmediatest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikirinkode.suitmediatest.databinding.ActivityThirdScreenBinding

class ThirdScreenActivity : AppCompatActivity() {

    private val binding: ActivityThirdScreenBinding by lazy {
        ActivityThirdScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            btnBack.setOnClickListener {
                onBackPressed()
            }
        }
    }

}