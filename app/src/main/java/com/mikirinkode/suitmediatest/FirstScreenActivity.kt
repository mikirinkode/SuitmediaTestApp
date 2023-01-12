package com.mikirinkode.suitmediatest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mikirinkode.suitmediatest.databinding.ActivityFirstScreenBinding

class FirstScreenActivity : AppCompatActivity() {

    private val binding: ActivityFirstScreenBinding by lazy {
        ActivityFirstScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnCheck.setOnClickListener {
                val sentence = edtPalindrome.text.toString().trim()
                if (isPalindrome(sentence)) {
                    showMyDialog(this@FirstScreenActivity, "Result", "Is Palindrome")
                } else {
                    showMyDialog(this@FirstScreenActivity, "Result", "Not Palindrome")
                }
            }

            btnNext.setOnClickListener {
                startActivity(Intent(this@FirstScreenActivity, SecondScreenActivity::class.java))
            }
        }
    }

    private fun showMyDialog(context: Context, title: String, message: String) {
        val builder = MaterialAlertDialogBuilder(context)
        builder.setTitle(title)
        builder.setMessage(message)
            .setPositiveButton(getString(R.string.okay)) { dialogInterface, _ ->
                dialogInterface.dismiss()
            }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    private fun isPalindrome(text: String): Boolean {
        val str = text.filter { !it.isWhitespace() }
        val reversedString = str.reversed()
        return str == reversedString
    }
}