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
import com.example.sports_news_and_info_app.models.News

class NewsDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_dialog)
    }

    fun showDialog(context: Context, callback: (News) -> Unit) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_news_dialog)

        val txtImageUrl = dialog.findViewById<EditText>(R.id.txtImageUrl)
        val txtTitle = dialog.findViewById<EditText>(R.id.txtTitle)
        val txtNewsDescription = dialog.findViewById<EditText>(R.id.txtNewsDescription)
        val addButton = dialog.findViewById<Button>(R.id.addButton)
        val cancelButton = dialog.findViewById<Button>(R.id.cancelButton)

        addButton.setOnClickListener {
            val imageUrl = txtImageUrl.text.toString().trim()
            val title = txtTitle.text.toString().trim()
            val description = txtNewsDescription.text.toString().trim()

            if (imageUrl.isNullOrBlank() || title.isNullOrBlank() || description.isNullOrBlank()) {
                Toast.makeText(context, "Enter all the fields.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "News added successfully.", Toast.LENGTH_SHORT).show()
                callback(News(imageUrl, title, description));
                dialog.dismiss()
            }
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


}