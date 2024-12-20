package com.example.grawkosci

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rzuc_koscmi_btn : Button = findViewById(R.id.rzuc_koscmi_btn)
        val resetuj_wynik_btn : Button = findViewById(R.id.resetuj_wynik_btn)

        val kosc_1 : ImageView = findViewById(R.id.kosc_pierwsza)
        val kosc_2 : ImageView = findViewById(R.id.kosc_druga)
        val kosc_3 : ImageView = findViewById(R.id.kosc_trzecia)
        val kosc_4 : ImageView = findViewById(R.id.kosc_czwarta)
        val kosc_5 : ImageView = findViewById(R.id.kosc_piata)

        val wynik_losowania_text : TextView = findViewById(R.id.wynik_losowania)
        val wynik_gry_text : TextView = findViewById(R.id.wynik_gry)

        var wynik_losowania : Int = 0
        var wynik_gry : Int = 0

        val mapaObrazow = mapOf(
            1 to R.drawable.one,
            2 to R.drawable.two,
            3 to R.drawable.three,
            4 to R.drawable.four,
            5 to R.drawable.five,
            6 to R.drawable.six
        )

        rzuc_koscmi_btn.setOnClickListener {
            val wylosowaneLiczby = mutableListOf<Int>()

            repeat(5) {
                val losujLiczbe = (1..6).random()
                wylosowaneLiczby.add(losujLiczbe)
            }

            val obrazy = wylosowaneLiczby.map { liczba ->
                mapaObrazow[liczba] ?: R.drawable.question
            }

            kosc_1.setImageResource(obrazy[0])
            kosc_2.setImageResource(obrazy[1])
            kosc_3.setImageResource(obrazy[2])
            kosc_4.setImageResource(obrazy[3])
            kosc_5.setImageResource(obrazy[4])

            val listaPodwojonychLiczb = wylosowaneLiczby.filter { liczba -> wylosowaneLiczby.count{ it == liczba } >=2 }

            wynik_losowania = listaPodwojonychLiczb.sum()

            wynik_gry+=wynik_losowania

            wynik_losowania_text.text = "Wynik losowania : ${wynik_losowania}"
            wynik_gry_text.text = "Wynik gry : ${wynik_gry}"
        }
        /*
        ************************************************
        nazwa: rzuc_koscmi_btn.setOnClickListener
        opis: symuluje losowanie 5 losowych rzutow koscia , zlicza punkty wedlug danej zasady i wyswietla wynik gry
        parametry: brak
        zwracany typ i opis: brak
        autor: 2137
        *************************************************
         */

        resetuj_wynik_btn.setOnClickListener{
            wynik_losowania = 0
            wynik_gry = 0
            wynik_losowania_text.text = "Wynik losowania : ${wynik_losowania}"
            wynik_gry_text.text = "Wynik gry : ${wynik_gry}"

            kosc_1.setImageResource(R.drawable.question)
            kosc_2.setImageResource(R.drawable.question)
            kosc_3.setImageResource(R.drawable.question)
            kosc_4.setImageResource(R.drawable.question)
            kosc_5.setImageResource(R.drawable.question)
        }

        /*
        ************************************************
        nazwa: resetuj_wynik_btn.setOnClickListener
        opis: resetuje wszystkie kosci oraz wynik gry
        parametry: brak
        zwracany typ i opis: brak
        autor: 2137
        *************************************************
         */

    }
}