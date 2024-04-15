package com.example.sports_news_and_info_app.models


class User(
    val email: String,
    val fullName: String,
    val password: String,
    val imageUrl: String
)

object UserData {
    val userList = mutableListOf(
        User("ramesh@gmail.com", "Ramesh Thapa", "pass123", "https://media.licdn.com/dms/image/D5603AQEk7NcoWm1Z8w/profile-displayphoto-shrink_400_400/0/1695663500379?e=1718236800&v=beta&t=7scP4pdeUTuhYDMTHHrTRdHK_4Jr-PkOGBdtSGCkMHM"),
        User("jane@gmail.com", "Jane Smith", "pass456", "")
    )

    private var loggedInUser: User? = null

    fun addUser(user: User) {
        userList.add(user)
    }

    fun find(predicate: (User) -> Boolean): User? {
        return userList.find(predicate)
    }

    fun setLoggedInUser(user: User) {
        this.loggedInUser = user;
    }
    fun getLoggedInUser(): User?  {
        return this.loggedInUser;
    }
}
