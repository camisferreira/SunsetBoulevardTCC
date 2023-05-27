package com.example.sunsetboulevard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sunsetboulevard.databinding.ActivityAvisoBinding

class AvisoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAvisoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvisoBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btnFaleSindico.setOnClickListener {
            val mIntent = Intent(this, SindicoActivity::class.java)
            startActivity(mIntent)
        }

        setContentView(view)
    }
}