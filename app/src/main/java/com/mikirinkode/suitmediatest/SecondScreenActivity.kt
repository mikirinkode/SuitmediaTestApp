package com.mikirinkode.suitmediatest

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

        }
    }


}