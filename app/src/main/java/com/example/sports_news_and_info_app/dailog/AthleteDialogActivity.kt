package com.example.sports_news_and_info_app.dailog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.models.Athlete
import com.example.sports_news_and_info_app.models.News

class AthleteDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_athlete_dialog)
    }

    fun showDialog(context: Context, callback: (Athlete) -> Unit) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_athlete_dialog)

        val txtName = dialog.findViewById<EditText>(R.id.txtName)
        val txtSports = dialog.findViewById<EditText>(R.id.txtSports)
        val txtCountry = dialog.findViewById<EditText>(R.id.txtCountry)
        val txtBestPerformance = dialog.findViewById<EditText>(R.id.txtBestPerformance)
        val txtMedals = dialog.findViewById<EditText>(R.id.txtMedals)
        val txtFacts = dialog.findViewById<EditText>(R.id.txtFacts)
        val addButton = dialog.findViewById<Button>(R.id.addButton)
        val cancelButton = dialog.findViewById<Button>(R.id.cancelButton)

        addButton.setOnClickListener {
            val name = txtName.text.toString().trim()
            val sports = txtSports.text.toString().trim()
            val country = txtCountry.text.toString().trim()
            val bestPerformance = txtBestPerformance.text.toString().trim()
            val medals = txtMedals.text.toString().trim()
            val facts = txtFacts.text.toString().trim()

            if (name.isNullOrBlank() || sports.isNullOrBlank() || country.isNullOrBlank()||bestPerformance.isNullOrBlank() || medals.isNullOrBlank() || facts.isNullOrBlank()) {
                Toast.makeText(context, "Enter all the fields.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Athlete added successfully.", Toast.LENGTH_SHORT).show()
                callback(
                    Athlete(name, sports, bestPerformance, country, medals, facts));
                dialog.dismiss()
            }
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


}