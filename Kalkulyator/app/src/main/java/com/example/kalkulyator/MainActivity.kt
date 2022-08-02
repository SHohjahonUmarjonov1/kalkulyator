package com.example.kalkulyator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.kalkulyator.databinding.ActivityMainBinding
import java.io.File
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val file = File(filesDir, "kalkulyator.txt")
        binding.input.text = if (file.canRead()) {
            file.readText()
        } else {
            val firsText = 0
            firsText.toString()
        }
        if (file.exists().not()) {
            file.createNewFile()
        }
        with(binding) {
            one.setOnClickListener {
                val one = 1
                file.appendText(one.toString())
                input.text = file.readText()
            }
            two.setOnClickListener {
                val two = 2
                file.appendText(two.toString())
                input.text = file.readText()
            }
            three.setOnClickListener {
                val three = 3
                file.appendText(three.toString())
                input.text = file.readText()
            }
            four.setOnClickListener {
                val four = 4
                file.appendText(four.toString())
                input.text = file.readText()
            }
            five.setOnClickListener {
                val five = 5
                file.appendText(five.toString())
                input.text = file.readText()
            }
            six.setOnClickListener {
                val six = 6
                file.appendText(six.toString())
                input.text = file.readText()
            }
            seven.setOnClickListener {
                val seven = 7
                file.appendText(seven.toString())
                input.text = file.readText()
            }
            eight.setOnClickListener {
                val eight = 8
                file.appendText(eight.toString())
                input.text = file.readText()
            }
            nine.setOnClickListener {
                val nine = 9
                file.appendText(nine.toString())
                input.text = file.readText()
            }
            zero.setOnClickListener {
                val zero = 0
                file.appendText(zero.toString())
                input.text = file.readText()
            }
            comma.setOnClickListener {
                val comma ="."
                file.appendText(comma)
                input.text = file.readText()
            }
            percent.setOnClickListener {
                val percent = "%"
                var string:String=file.readText()
                if (string.last() in arrayOf('+','-','x','/')) {
                    string=string
                }else{
                    file.appendText(percent)
                }
                input.text = file.readText()
            }
            plus.setOnClickListener {
                val plus = "+"
                var string:String=file.readText()
                if (string.last() in arrayOf('+','-','x','/')) {
                    string=string.dropLast(1)+plus
                    file.delete()
                    file.writeText(string)
                }else{
                    file.appendText(plus)
                }
                input.text = file.readText()
            }

            tobe.setOnClickListener {
                val tobe = "/"
                var string:String=file.readText()
                if (string.last() in arrayOf('+','-','x','/')) {
                    string=string.dropLast(1)+tobe
                    file.delete()
                    file.writeText(string)
                }else{
                    file.appendText(tobe)
                }
                input.text = file.readText()
            }

            increase.setOnClickListener {
                val increase = "x"
                var string:String=file.readText()
                if (string.last() in arrayOf('+','-','x','/')) {
                    string=string.dropLast(1)+increase
                    file.delete()
                    file.writeText(string)
                }else{
                    file.appendText(increase)
                }
                input.text = file.readText()
            }

            subtraction.setOnClickListener {
                val subtraction = "-"
                var string:String=file.readText()
                if (string.last() in arrayOf('+','-','x','/')) {
                    string=string.dropLast(1)+subtraction
                    file.delete()
                    file.writeText(string)
                }else{
                    file.appendText(subtraction)
                }
                input.text = file.readText()
            }

            back.setOnClickListener {
                val string: String = file.readText()
                val result = string.dropLast(1)
                file.delete()
                file.writeText(result)
                input.text = result
            }

            equality.setOnClickListener {
                if (file.exists().not()) {
                    val zero=0
                    input.text=zero.toString()
                    return@setOnClickListener
                }
                var string=file.readText()
                val result=try {
                    main1(string)
                }catch (e:Exception){
                    "Xatolik yuz berdi !!!"
                }
                input.text=string+"\n="+result
            }

            clear.setOnClickListener {
                file.delete()
                input.text = null
            }
        }
    }
}