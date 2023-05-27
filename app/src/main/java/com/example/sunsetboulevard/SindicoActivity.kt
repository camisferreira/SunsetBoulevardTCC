package com.example.sunsetboulevard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sunsetboulevard.databinding.ActivitySindicoBinding

class SindicoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySindicoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySindicoBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btnEnviar.setOnClickListener {
            val mIntent = Intent(this, LoginActivity::class.java)
            // TODO: Implementar envio de mensagem
            Toast.makeText(this, "Mensagem enviada com sucesso!", Toast.LENGTH_LONG).show()
            startActivity(mIntent)
        }

        setContentView(view)
    }
}