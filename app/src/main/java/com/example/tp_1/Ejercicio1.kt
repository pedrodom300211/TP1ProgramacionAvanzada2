package com.example.tp_1

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.view.View


class Ejercicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var edtNumero1 : EditText = findViewById(R.id.editTextText1)
        var edtNumero2 : EditText = findViewById(R.id.editTextText2)
        var btnSumar : Button = findViewById(R.id.button)
        var txtResultado : TextView = findViewById(R.id.txt_resultado)

        btnSumar.setOnClickListener{
            val primerValor = edtNumero1.text.toString().trim()
            val segundoValor = edtNumero2.text.toString().trim()
            if(primerValor.isEmpty()||segundoValor.isEmpty()){
                txtResultado.setText("Datos invalidos")
            }else{
            var n1=edtNumero1.text.toString().toInt()
            var n2=edtNumero2.text.toString().toInt()
            var res=n1+n2
            txtResultado.text=res.toString()}
        }
    }
}