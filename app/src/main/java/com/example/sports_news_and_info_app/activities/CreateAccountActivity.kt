package com.example.sports_news_and_info_app.activities
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.models.User
import com.example.sports_news_and_info_app.models.UserData

class CreateAccountActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createaccount)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextMobileOrEmail = findViewById<EditText>(R.id.editTextMobileOrEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextReenterPassword = findViewById<EditText>(R.id.editTextReenterPassword)
        val editTextImageUrl = findViewById<EditText>(R.id.editTextImageUrl)
        val buttonContinue = findViewById<Button>(R.id.buttonContinue)
        val buttonBack = findViewById<Button>(R.id.buttonLogin)

        buttonContinue.setOnClickListener {
            val name = editTextName.text.toString()
            val mobileOrEmail = editTextMobileOrEmail.text.toString()
            val password = editTextPassword.text.toString()
            val reenteredPassword = editTextReenterPassword.text.toString()
            val imageUrl = editTextImageUrl.text.toString()

            if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != reenteredPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newUser = User(email = mobileOrEmail, fullName = name, password = password, imageUrl = imageUrl)
            UserData.addUser(newUser)

            Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()
            finish()
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}


