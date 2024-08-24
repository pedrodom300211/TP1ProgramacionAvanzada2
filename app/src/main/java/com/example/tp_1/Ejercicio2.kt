package com.example.tp_1

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.view.View
import android.util.Log

class Ejercicio2 : AppCompatActivity() {
    lateinit var tv_num: TextView

    var Primervalor: Double = 0.0
    var Segundovalor: Double = 0.0
    var res :Double= 0.0


    ///operacion 0=nada 1=suma 2=multiplicacion 3=dividir 4=resta 5=error
    var operacion: Int = 0
    var TextoPantalla: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn_Igual: Button = findViewById(R.id.btn_igual)
        val btn_borrar: Button = findViewById(R.id.btn_borrar)

        tv_num = findViewById(R.id.textView4)


        btn_Igual.setOnClickListener{
            Segundovalor= tv_num.text.toString().toDouble()

            when(operacion) {
                1 -> res = Primervalor + Segundovalor
                2 -> res = Primervalor - Segundovalor
                3 -> res = Primervalor * Segundovalor
                4 -> {
                    if(Segundovalor !=0.0)
                    res = Primervalor / Segundovalor
                    else{
                        tv_num.setTextColor(Color.parseColor("#FF0000"))
                        tv_num.setText("No se puede dividir por 0 ")
                        operacion=5
                        return@setOnClickListener
                    }
                }
            }
            tv_num.setText(res.toString())

            operacion=0
        }
        btn_borrar.setOnClickListener{
            tv_num.setText("")

            operacion = 0
        }

    }

    fun clickNumero(view: View) {
        tv_num.setTextColor(Color.parseColor("#8A8A8A"))
        if(operacion==5 ||operacion==0) tv_num.setText("")
        var num = tv_num.text.toString()

        when (view.id ) {
            R.id.btn_0 -> {

                tv_num.setText(num + "0")


            }
            R.id.btn_1 -> {
                    tv_num.setText(num + "1")
            }
            R.id.btn_2 -> {

                    tv_num.setText(num + "2")

            }
            R.id.btn_3 ->{

                    tv_num.setText(num + "3")

            }
            R.id.btn_4 -> {

                    tv_num.setText(num + "4")

            }
            R.id.btn_5 -> {

                    tv_num.setText(num + "5")

            }
            R.id.btn_6 -> {

                    tv_num.setText(num + "6")

            }
            R.id.btn_7 -> {

                    tv_num.setText(num + "7")


            }
            R.id.btn_8 ->{

                    tv_num.setText(num + "8")

            }
            R.id.btn_9 -> {

                    tv_num.setText(num + "9")

            }

        }

    }

    fun clickOperacion(view: View) {
        Primervalor = tv_num.text.toString().toDouble()
        TextoPantalla = tv_num.text.toString()
        when (view.id) {
            R.id.btn_mas -> {
                tv_num.setText("")
                operacion = 1
            }
            R.id.btn_menos -> {
                tv_num.setText("")
                operacion = 2
            }
            R.id.btn_multiplicacion -> {
                tv_num.setText("")
                operacion = 3
            }
            R.id.btn_dividir -> {
                tv_num.setText("")
                operacion = 4
            }
        }
    }

}