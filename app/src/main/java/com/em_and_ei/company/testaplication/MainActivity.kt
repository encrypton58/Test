package com.em_and_ei.company.testaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.em_and_ei.company.testaplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnVerifyNumber.setOnClickListener {
            val builder = AlertDialog.Builder(this)
                .setTitle( if (checkPrimeNumber()) "Es primo" else "No es Primo")
                .setPositiveButton("Aceptar") { dialogInterface, _ ->
                    dialogInterface.dismiss()
                }
            builder.create().show()
            checkPrimeNumber()
        }
    }

    private fun checkPrimeNumber(): Boolean{
        val number = binding.itInputNumber.text.toString().toInt()
        var m = 2
        var flag = true
        while (flag  && (m < number)){
            if(number % m == 0){
                flag = false
            }else{
                m += 1
            }
        }
       return flag
    }
}