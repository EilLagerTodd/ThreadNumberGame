package com.example.a4_week_third

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.a4_week_third.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit private var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()
    }

    override fun onStart() {
        super.onStart()

        val intent = Intent(this, GameActivity::class.java)

        binding.start.setOnClickListener{
            //Toast.makeText(this@MainActivity, "토스트 메세지 띄우기 입니다.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        binding.infoma.setOnClickListener {
            val dialog = CustomDialogFregment()
            dialog.show(supportFragmentManager, dialog.tag)
        }

        binding.EXIT.setOnClickListener {
            System.exit(0)
        }
    }
}