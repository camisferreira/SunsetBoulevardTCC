package com.example.sunsetboulevard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sunsetboulevard.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btnLoginEntrar.setOnClickListener {
            val email = binding.edtLoginEmail.text.toString().trim().lowercase()
            val senha = binding.edtLoginSenha.text.toString().trim()

            if (email.isEmpty()) {
                binding.edtLoginEmail.error = "Campo Obrigatório!"
                binding.edtLoginEmail.requestFocus()
            } else if (senha.isEmpty()) {
                binding.edtLoginSenha.error = "Campo Obrigatório!"
                binding.edtLoginSenha.requestFocus()
            } else {
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)


                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")

                if (email == emailPrefs && senha == senhaPrefs) {
                    Toast.makeText(this, "Usuário logado com sucesso!", Toast.LENGTH_LONG).show()

                    val mIntent = Intent(this, AvisoActivity::class.java)

                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()

                } else {
                    Toast.makeText(this, "Email ou senha inválido!", Toast.LENGTH_LONG).show()

                }
            }
        }

        binding.btnLoginCadastrar.setOnClickListener {
            val mIntent = Intent(this, ActivityCadastro::class.java)
            startActivity(mIntent)
        }

        setContentView(view)
    }
}