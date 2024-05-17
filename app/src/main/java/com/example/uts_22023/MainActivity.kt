package com.example.uts_22023

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var edTitle: EditText
    lateinit var textWatch: String
    lateinit var textGenre: String
    lateinit var buttonOk: Button
    lateinit var radioButtonCheck: RadioButton
    lateinit var adult: RadioButton
    lateinit var kids: RadioButton
    lateinit var radioGroup: RadioGroup
    lateinit var thriller: CheckBox
    lateinit var romance: CheckBox
    lateinit var action: CheckBox
    lateinit var comedy: CheckBox
    lateinit var horror: CheckBox
    lateinit var fantasy: CheckBox
    lateinit var textYear : String
    lateinit var textHour: String
    lateinit var textMinutes: String
    lateinit var tahun: Spinner
    lateinit var menit: Spinner
    lateinit var jam: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edTitle = findViewById(R.id.editTitle)
        buttonOk = findViewById(R.id.btnOk)
        adult = findViewById(R.id.adult)
        kids = findViewById(R.id.kids)
        radioGroup = findViewById(R.id.usia)
        tahun = findViewById(R.id.pilihTahun)
        menit = findViewById(R.id.pilihMenit)
        jam = findViewById(R.id.pilihJam)
        thriller = findViewById(R.id.thriller)
        romance = findViewById(R.id.romance)
        horror = findViewById(R.id.horror)
        comedy = findViewById(R.id.comedy)
        fantasy = findViewById(R.id.fantasy)
        action = findViewById(R.id.action)

        buttonOk.setOnClickListener {
            val pilihanWatch = radioGroup!!.checkedRadioButtonId
            radioButtonCheck = findViewById(pilihanWatch)
            textWatch = radioButtonCheck.text.toString()

            val isiCheckBox = if (thriller.isChecked){
                "Thriller"
            }else if(action.isChecked){
                "Action"
            }else{
                "  "
            }

            textYear = tahun.selectedItem.toString()
            textHour = jam.selectedItem.toString()
            textMinutes = menit.selectedItem.toString()

            val moveIntent = Intent(this@MainActivity, MainActivity2::class.java)
            moveIntent.putExtra(MainActivity2.EXTRA_TITLE,  edTitle.text.toString())
            moveIntent.putExtra(MainActivity2.EXTRA_WATCH, textWatch)
            moveIntent.putExtra(MainActivity2.EXTRA_GENRE, isiCheckBox)
            moveIntent.putExtra(MainActivity2.EXTRA_YEAR, textYear)
            moveIntent.putExtra(MainActivity2.EXTRA_HOUR, textHour)
            moveIntent.putExtra(MainActivity2.EXTRA_MINUTE, textMinutes)
            startActivity(moveIntent)

        }


    }
}