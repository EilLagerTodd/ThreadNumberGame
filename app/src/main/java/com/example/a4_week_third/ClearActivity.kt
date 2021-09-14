package com.example.a4_week_third

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.a4_week_third.databinding.ActivityClearBinding

class ClearActivity : AppCompatActivity() {

    lateinit private var binding:ActivityClearBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityClearBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()

        var finish_time_c = intent.getStringExtra("c_time")
        var finish_score_c = intent.getStringExtra("c_score")


        Toast.makeText(this, "시간: $finish_time_c"+ "초" + "점수: $finish_score_c", Toast.LENGTH_SHORT).show()

        binding.clearTime.text = "시간 : "+finish_time_c.toString() +"초"
        binding.clearScore.text ="Score :"+finish_score_c.toString()
    }

    override fun onResume() {
        super.onResume()

        val intent_H = Intent(this, MainActivity::class.java)
        val intent_R = Intent(this, GameActivity::class.java)

        binding.clearExit.setOnClickListener {
            ActivityCompat.finishAffinity(this);
            System.runFinalization()
            System.exit(0)
        }

        binding.clearHome.setOnClickListener {

            startActivity(intent_H)

        }

        binding.clearReplay.setOnClickListener {

            startActivity(intent_R)

        }

    }
}