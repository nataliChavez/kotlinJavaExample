package com.example.morpheus.kotlinjavaexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtPass: EditText
    lateinit var edtNombre: EditText
    lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPass = findViewById(R.id.edtLoginPass)
        edtNombre = findViewById(R.id.edtLoginUsuario)
        btnLogin = findViewById(R.id.btnLogin)

        val sharedPreferences = getSharedPreferences("kotlinpre", Context.MODE_PRIVATE)

        val isLogged = sharedPreferences.getBoolean("loggeado",false)
        if(isLogged)
        {
            startActivity(Intent(this@MainActivity, ListadoActivity::class.java))
            finish()
        }

        btnLogin.setOnClickListener {
            val isValid = edtPass.passwordValida()
            Log.i("OnClick", isValid.toString())
            if (isValid) {
                //iniciar vista
                //startActivity(Intent(this@MainActivity, ListadoActivity::class.java))
                val intent = Intent(this@MainActivity, ListadoActivity::class.java)
                intent.putExtra("usuario",edtNombre.text.toString())
                startActivity(intent)
                sharedPreferences.edit {
                    putBoolean("loggeado",true)
                }
            } else {
                Toast.makeText(this@MainActivity, "Password Invalida", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
