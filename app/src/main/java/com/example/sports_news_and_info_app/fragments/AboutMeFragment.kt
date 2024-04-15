package com.example.sports_news_and_info_app.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.activities.LoginActivity
import com.example.sports_news_and_info_app.adapters.BaseFragment
import com.example.sports_news_and_info_app.models.UserData


class AboutMeFragment : BaseFragment() {
    private lateinit var logout: Button
    override fun openDialog() {

    }

    override fun onDataReturned(data: Any) {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_about_me, container, false)
        logout = view.findViewById(R.id.logoutButton)
        if (container != null) {


            val loggedInUser = UserData.getLoggedInUser();
            val emailText = view.findViewById<TextView>(R.id.emailTextView)
            val usernameText = view.findViewById<TextView>(R.id.usernameTextView)
            val imageView = view.findViewById<ImageView>(R.id.profileImageView)

            emailText.setText(loggedInUser?.email)
            usernameText.setText(loggedInUser?.fullName)
            var imageUrl = loggedInUser?.imageUrl
            if(imageUrl == null || imageUrl == "")
            {
                imageUrl = "https://i.stack.imgur.com/l60Hf.png";
            }
            Glide.with(this)
                .load(imageUrl)
                .into(imageView)

            logout.setOnClickListener {
                val intent = Intent(container.context, LoginActivity::class.java)
                startActivity(intent)
            }

        }

        return view
    }
}