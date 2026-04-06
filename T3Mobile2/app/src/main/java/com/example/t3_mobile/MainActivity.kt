package com.example.t3_mobile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.text.Html

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val tvErrorNama = findViewById<TextView>(R.id.tvErrorNama)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val rbLaki = findViewById<RadioButton>(R.id.rbLaki)

        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)

        val btnTampil = findViewById<Button>(R.id.btnTampil)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampil.setOnClickListener {

            val nama = etNama.text.toString().trim()

            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong"
                tvErrorNama.visibility = TextView.VISIBLE
                Toast.makeText(applicationContext, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                tvErrorNama.visibility = TextView.GONE
            }

            if (rgGender.checkedRadioButtonId == -1) {
                Toast.makeText(applicationContext, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = if (rbLaki.isChecked) "Laki-laki" else "Perempuan"

            val hobiList = mutableListOf<String>()

            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbCoding.isChecked) hobiList.add("Coding")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")

            if (hobiList.size < 2) {
                Toast.makeText(applicationContext, "Pilih minimal 2 hobi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hobi = hobiList.joinToString(", ")

            val hasil = """
                <b>Nama</b> : $nama<br>
                <b>Kelamin</b> : $gender<br>
                <b>Hobi</b> : $hobi
            """.trimIndent()

            tvHasil.text = Html.fromHtml(hasil, Html.FROM_HTML_MODE_LEGACY)
        }
    }
}