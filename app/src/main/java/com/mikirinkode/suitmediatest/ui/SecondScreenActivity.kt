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

        val extras = intent.extras



        binding.apply {
            if (extras != null){
                tvUserName.text = extras.getString(EXTRA_NAME)
            }

            btnChooseUser.setOnClickListener {
                val intent = Intent(this@SecondScreenActivity, ThirdScreenActivity::class.java)
                startActivityForResult(intent, SELECTED_NAME_CODE)
            }

            btnBack.setOnClickListener {
                onBackPressed()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SELECTED_NAME_CODE){
            if (resultCode == RESULT_OK){
                binding.tvSelectedUserName.text = data?.getStringExtra(EXTRA_SELECTED_NAME)
            }
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SELECTED_NAME = "extra_selected"
        const val SELECTED_NAME_CODE = 1
    }
}