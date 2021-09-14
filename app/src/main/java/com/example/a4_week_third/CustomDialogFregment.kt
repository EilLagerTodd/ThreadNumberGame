package com.example.a4_week_third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.a4_week_third.databinding.LayoutDialogBinding

class CustomDialogFregment: DialogFragment() {
    lateinit private var binding: LayoutDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutDialogBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
            this.dismiss()
        }
        return binding.root
    }

}
