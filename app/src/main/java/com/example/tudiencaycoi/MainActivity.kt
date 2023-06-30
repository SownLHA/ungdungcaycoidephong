package com.example.tudiencaycoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tudiencaycoi.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // Kiểm tra xem activity đã được mở trước đó chưa
        val isFirstTime = sharedPreferences.getBoolean("isFirstTime", true)
        if (isFirstTime) {
            // Nếu là lần đầu tiên mở ứng dụng, ẩn thanh trạng thái và thanh hành động
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            supportActionBar?.hide()

            // Lưu trạng thái đã mở ứng dụng
            val editor = sharedPreferences.edit()
            editor.putBoolean("isFirstTime", false)
            editor.apply()
        } else {
            // Nếu không phải lần đầu tiên mở ứng dụng, chuyển đến activity SignInActivity
            val i = Intent(this, SignInActivity::class.java)
            startActivity(i)
            finish() // Đóng activity hiện tại để không quay lại khi nhấn nút back
        }


        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.pagerTest.adapter = adapter
        TabLayoutMediator(binding.tabDemo, binding.pagerTest) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab1"
                }
                1 -> {
                    tab.text = "Tab2"
                }
                2 -> {
                    tab.text = "Tab3"
                }
            }
        }.attach()
        binding.btnGo.setOnClickListener{
            val i = Intent(this,SignInActivity::class.java)
            startActivity(i)
        }
    }
}