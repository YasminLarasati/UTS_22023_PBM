package com.example.uts_22023

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_WATCH = "extra_watch"
        const val EXTRA_GENRE = "extra_genre"
        const val EXTRA_YEAR = "extra_year"
        const val EXTRA_HOUR = "extra_hour"
        const val EXTRA_MINUTE = "extra_minute"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val judul: TextView = findViewById(R.id.isiJudul)
        val watch: TextView = findViewById(R.id.isiWatch)
        val genre: TextView = findViewById(R.id.isiGenre)
        val year: TextView = findViewById(R.id.isiTahun)
        val duration: TextView = findViewById(R.id.isiDuration)

        val isiJudul = intent.getStringExtra(EXTRA_TITLE)
        val isiWatch = intent.getStringExtra(EXTRA_WATCH)
//        val isiGenre = intent.getStringExtra(EXTRA_GENRE)
        val isiYear = intent.getStringExtra(EXTRA_YEAR)
        val isiHour = intent.getStringExtra(EXTRA_HOUR)
        val isiMinute = intent.getStringExtra(EXTRA_MINUTE)

        judul.text = "$isiJudul"
        watch.text = "$isiWatch"
//        genre.text = "$isiGenre"
        year.text = "$isiYear"
        duration.text = "$isiHour h $isiMinute m"

    }
}