package com.example.sunsetboulevard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.sunsetboulevard.databinding.ActivityCadastroBinding

class ActivityCadastro : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btnCadastrar.setOnClickListener() {
            val nome = binding.edtCadastroNome.text.toString().trim()
            val sobrenome = binding.edtCadastroSobrenome.text.toString().trim()
            val email = binding.edtCadastroEmail.text.toString().trim().lowercase()
            val senha = binding.edtCadastroSenha.text.toString().trim()

            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preeencha todos os campos!", Toast.LENGTH_SHORT).show()

            } else {
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                val editPrefs = sharedPrefs.edit()

                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)

                editPrefs.apply()

                val mIntent = Intent(this, LoginActivity::class.java)

                mIntent.putExtra("INTENT_EMAIL", email)
                startActivity(mIntent)

                finishAffinity()
            }
        }

        binding.btnVoltar.setOnClickListener {
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
        }

        setContentView(view)

    }
}