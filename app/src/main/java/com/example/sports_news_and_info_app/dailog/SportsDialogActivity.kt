package com.example.sports_news_and_info_app.dailog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.models.News
import com.example.sports_news_and_info_app.models.Sport

class SportsDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports_dialog)
    }

    fun showDialog(context: Context, callback: (Sport) -> Unit) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_sports_dialog)

        val spinnerMeasure = dialog.findViewById<Spinner>(R.id.spinnerMeasure)
        val txtSportsName = dialog.findViewById<EditText>(R.id.txtSportsName)
        val txtInstructions = dialog.findViewById<EditText>(R.id.txtInstructions)
        val addButton = dialog.findViewById<Button>(R.id.addButton)
        val cancelButton = dialog.findViewById<Button>(R.id.cancelButton)

        addButton.setOnClickListener {
            val measure = spinnerMeasure.selectedItem.toString().trim()
            val sportsName = txtSportsName.text.toString().trim()
            val instructions = txtInstructions.text.toString().trim()

            if (measure.isNullOrBlank() || sportsName.isNullOrBlank() || instructions.isNullOrBlank()) {
                Toast.makeText(context, "Enter all the fields.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Sports added successfully.", Toast.LENGTH_SHORT).show()
                callback(Sport(measure,sportsName, instructions));
                dialog.dismiss()
            }
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


}