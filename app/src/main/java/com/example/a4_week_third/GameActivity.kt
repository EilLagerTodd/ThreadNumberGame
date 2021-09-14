package com.example.a4_week_third

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a4_week_third.databinding.ActivityGameBinding
import kotlin.concurrent.thread


class GameActivity : AppCompatActivity() {

    lateinit private var binding: ActivityGameBinding
    private var mediaPlayer : MediaPlayer? = null

    var arr = mutableListOf<Int>()
    var total = 0
    var started = false

    val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val minute = String.format("%02d", total / 60)
            val second = String.format("%02d", total % 60)
            binding.textTimer.text = "$minute:$second"
        }

    }

    var scroe_numbr = 0

    val score_handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            binding.score.text = "score : $scroe_numbr"
        }
    }

    var hp = 3

    val hp_handler = object  : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {

            if (hp == 3) {
                binding.heart1.setVisibility(View.VISIBLE);
                binding.heart2.setVisibility(View.VISIBLE);
                binding.heart3.setVisibility(View.VISIBLE);
            } else if (hp == 2) {
                binding.heart1.setVisibility(View.VISIBLE);
                binding.heart2.setVisibility(View.VISIBLE);
                binding.heart3.setVisibility(View.INVISIBLE);
            } else if (hp == 1) {
                binding.heart1.setVisibility(View.VISIBLE);
                binding.heart2.setVisibility(View.INVISIBLE);
                binding.heart3.setVisibility(View.INVISIBLE);
            } else if (hp == 0) {
                binding.heart1.setVisibility(View.INVISIBLE);
                binding.heart2.setVisibility(View.INVISIBLE);
                binding.heart3.setVisibility(View.INVISIBLE);
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        var i = 0

        mediaPlayer = MediaPlayer.create(this,R.raw.bgm)

        Thread() {

            for (i in 0..24) {
                arr.add(i + 1)
            }
            arr.shuffle()

        }.start()

        binding.check.setOnClickListener {
            started = true
            binding.check.setVisibility(View.INVISIBLE);
            binding.score.setVisibility(View.VISIBLE);
            binding.heart1.setVisibility(View.VISIBLE);
            binding.heart2.setVisibility(View.VISIBLE);
            binding.heart3.setVisibility(View.VISIBLE);

            mediaPlayer?.start()

            thread(start = true) {
                while (started) {
                    Thread.sleep(1000)
                    if (started) {
                        total = total + 1
                        handler?.sendEmptyMessage(0)
                        score_handler?.sendEmptyMessage(0)
                        hp_handler?.sendEmptyMessage(0)
                    }
                }
            }
        }


    }

    override fun onStart() {
        super.onStart()

            binding.bt1.setText(arr[0].toString()); binding.bt2.setText(arr[1].toString());
            binding.bt3.setText(arr[2].toString());binding.bt4.setText(arr[3].toString());
            binding.bt5.setText(arr[4].toString()); binding.bt6.setText(arr[5].toString());
            binding.bt7.setText(arr[6].toString()); binding.bt8.setText(arr[7].toString());
            binding.bt9.setText(arr[8].toString()); binding.bt10.setText(arr[9].toString());
            binding.bt11.setText(arr[10].toString()); binding.bt12.setText(arr[11].toString());
            binding.bt13.setText(arr[12].toString()); binding.bt14.setText(arr[13].toString());
            binding.bt15.setText(arr[14].toString());binding.bt16.setText(arr[15].toString());
            binding.bt17.setText(arr[16].toString()); binding.bt18.setText(arr[17].toString());
            binding.bt19.setText(arr[18].toString()); binding.bt20.setText(arr[19].toString());
            binding.bt21.setText(arr[20].toString()); binding.bt22.setText(arr[21].toString());
            binding.bt23.setText(arr[22].toString()); binding.bt24.setText(arr[23].toString());
            binding.bt25.setText(arr[24].toString())

        var check_count = 1
        var CCount = 10
        var score_check = false

        Thread() {
            while (true) {
                Thread.sleep(1000)
                if (CCount <= 0) {
                    CCount = 1
                }
                CCount -= 1
            }
        }.start()

        Thread() {
            while (true) {
                if (score_check == true) {
                    scroe_numbr += CCount * check_count
                    score_check = false
                    println(scroe_numbr)
                }
            }
        }.start()

        Thread() {

            binding.bt1.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt1.text.toString() == check_count.toString()) {
                    binding.bt1.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt1.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            };

            binding.bt2.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (binding.bt2.text.toString() == check_count.toString()) {
                    binding.bt2.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt2.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt3.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt3.text.toString() == check_count.toString()) {
                    binding.bt3.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt3.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt4.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt4.text.toString() == check_count.toString()) {
                    binding.bt4.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt4.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt5.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt5.text.toString() == check_count.toString()) {
                    binding.bt5.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt5.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt6.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt6.text.toString() == check_count.toString()) {
                    binding.bt6.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt6.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt7.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt7.text.toString() == check_count.toString()) {
                    binding.bt7.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt7.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt8.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt8.text.toString() == check_count.toString()) {
                    binding.bt8.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt8.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt9.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt9.text.toString() == check_count.toString()) {
                    binding.bt9.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt9.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt10.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt10.text.toString() == check_count.toString()) {
                    binding.bt10.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt10.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt11.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt11.text.toString() == check_count.toString()) {
                    binding.bt11.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt11.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt12.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt12.text.toString() == check_count.toString()) {
                    binding.bt12.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt12.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt13.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt13.text.toString() == check_count.toString()) {
                    binding.bt13.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt13.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt14.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt14.text.toString() == check_count.toString()) {
                    binding.bt14.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt14.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt15.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt15.text.toString() == check_count.toString()) {
                    binding.bt15.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt15.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt16.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt16.text.toString() == check_count.toString()) {
                    binding.bt16.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt16.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt17.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt17.text.toString() == check_count.toString()) {
                    binding.bt17.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt17.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt18.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt18.text.toString() == check_count.toString()) {
                    binding.bt18.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt18.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt19.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt19.text.toString() == check_count.toString()) {
                    binding.bt19.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt19.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt20.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt20.text.toString() == check_count.toString()) {
                    binding.bt20.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt20.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt21.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt21.text.toString() == check_count.toString()) {
                    binding.bt21.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt21.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt22.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt22.text.toString() == check_count.toString()) {
                    binding.bt22.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt22.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt23.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt23.text.toString() == check_count.toString()) {
                    binding.bt23.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt23.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt24.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt24.text.toString() == check_count.toString()) {
                    binding.bt24.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt24.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
            binding.bt25.setOnClickListener {
                if (started == false) {
                    Toast.makeText(this, "타이머를 시작해주세요", Toast.LENGTH_SHORT).show()
                } else if (started == true && binding.bt25.text.toString() == check_count.toString()) {
                    binding.bt25.setVisibility(View.INVISIBLE);
                    check_count++
                    CCount += 10
                    score_check = true
                } else if (started == true && binding.bt25.text.toString() != check_count.toString()) {
                    hp--
                    Toast.makeText(this, "남은 채력 : $hp", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()

        val intent_C = Intent(this, ClearActivity::class.java)
        val intent_F = Intent(this, FailActivity::class.java)
        var while_check_clear = true
        var while_check_fail = true


        Thread() {
            while (while_check_clear)
            {
                if(check_count == 26)
                {
                    intent_C.putExtra("c_time",total.toString())
                    intent_C.putExtra("c_score",scroe_numbr.toString())
                    startActivity(intent_C)
                    while_check_clear = false
                    while_check_fail = false
                    mediaPlayer?.stop()
                    mediaPlayer = null
                    finish()

                }
            }
        }.start()

        Thread() {
            while (while_check_fail)
            {
                if(hp <= 0)
                {
                    intent_F.putExtra("f_time",total.toString())
                    intent_F.putExtra("f_score",scroe_numbr.toString())
                    startActivity(intent_F)
                    while_check_clear = false
                    while_check_fail = false
                    mediaPlayer?.stop()
                    mediaPlayer = null
                    finish()

                }
            }
        }.start()

    }

}










