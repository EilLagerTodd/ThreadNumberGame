package com.example.a4_week_third

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.a4_week_third.databinding.ActivityClearBinding
import com.example.a4_week_third.databinding.ActivityFailBinding

class FailActivity : AppCompatActivity() {

    lateinit private var binding:ActivityFailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()


        var finish_time_f = intent.getStringExtra("f_time")
        var finish_score_f = intent.getStringExtra("f_score")


        Toast.makeText(this, "시간: $finish_time_f"+ "초" + "점수: $finish_score_f", Toast.LENGTH_SHORT).show()

        binding.overTime.text = "시간 : "+finish_time_f.toString() +"초"
        binding.overScore.text ="Score : "+finish_score_f.toString()

    }

    override fun onResume() {
        super.onResume()

        val intent_H = Intent(this, MainActivity::class.java)
        val intent_R = Intent(this, GameActivity::class.java)

        binding.overExit.setOnClickListener {
            ActivityCompat.finishAffinity(this);
            System.runFinalization()
            System.exit(0)
        }

        binding.overHome.setOnClickListener {

            startActivity(intent_H)

        }

        binding.overReplay.setOnClickListener {

            startActivity(intent_R)

        }

    }
}