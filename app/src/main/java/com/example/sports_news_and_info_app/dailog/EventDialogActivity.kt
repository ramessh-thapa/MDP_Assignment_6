package com.example.sports_news_and_info_app.dailog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.models.Event
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*


class EventDialogActivity : AppCompatActivity() {
    private lateinit var parentContext: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_dialog)

    }

    fun showDialog(parentFragmentManager: FragmentManager, context: Context, callback: (Event) -> Unit) {
        this.parentContext = parentFragmentManager
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_event_dialog)

        val txtName = dialog.findViewById<EditText>(R.id.txtName)
        val txtDate = dialog.findViewById<EditText>(R.id.txtDate)
        val txtDescription = dialog.findViewById<EditText>(R.id.txtDescription)
        val addButton = dialog.findViewById<Button>(R.id.addButton)
        val cancelButton = dialog.findViewById<Button>(R.id.cancelButton)

        addButton.setOnClickListener {
            val name = txtName.text.toString().trim()
            val date = txtDate.text.toString().trim()
            val description = txtDescription.text.toString().trim()

            if (name.isNullOrBlank() || date.isNullOrBlank() || description.isNullOrBlank()) {
                Toast.makeText(context, "Enter all the fields.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Event added successfully.", Toast.LENGTH_SHORT).show()
                callback(
                    Event(name, date, description)
                );
                dialog.dismiss()
            }
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        val calBuilder = MaterialDatePicker.Builder.datePicker()
        val picker = calBuilder.build()

        txtDate.setOnClickListener { v: View? ->
            picker.show(
                this.parentContext,
                picker.toString()
            )
        }
        picker.addOnPositiveButtonClickListener { selection: Long? ->
            txtDate.setText(
                picker.headerText
            )
        }

        dialog.show()
    }
}