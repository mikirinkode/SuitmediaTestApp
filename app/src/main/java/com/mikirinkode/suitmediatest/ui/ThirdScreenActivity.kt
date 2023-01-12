package com.mikirinkode.suitmediatest.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikirinkode.suitmediatest.databinding.ActivityThirdScreenBinding

class ThirdScreenActivity : AppCompatActivity() {

    private val binding: ActivityThirdScreenBinding by lazy {
        ActivityThirdScreenBinding.inflate(layoutInflater)
    }

    private lateinit var userViewModel: UserViewModel
    private val adapter: UserAdapter by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val factory = ViewModelFactory.getInstance(this)
        userViewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]

        initView()
        collectUiState()

        binding.apply {
            adapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
                override fun onItemClicked(name: String) {
                    val intent = Intent()
                    intent.putExtra(SecondScreenActivity.EXTRA_SELECTED_NAME, name)
                    setResult(RESULT_OK, intent)
                    finish()
                }
            })

            btnBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun collectUiState() {
        binding.loadingIndicator.visibility = View.VISIBLE
        userViewModel.userList.observe(this) {
            adapter.submitData(lifecycle, it)
            binding.loadingIndicator.visibility = View.INVISIBLE
        }
    }

    private fun initView() {
        binding.apply {
            rvUser.layoutManager = LinearLayoutManager(this@ThirdScreenActivity)
            rvUser.setHasFixedSize(true)
            rvUser.adapter = adapter.withLoadStateFooter(
                footer = LoadingStateAdapter {
                    adapter.retry()
                }
            )

            swipeToRefresh.setOnRefreshListener {
                collectUiState()
                swipeToRefresh.isRefreshing = false
            }
        }
    }

}