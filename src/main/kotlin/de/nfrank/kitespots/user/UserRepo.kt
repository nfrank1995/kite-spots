package de.nfrank.kitespots.user

import org.springframework.stereotype.Service

@Service
class UserRepo {
    private val users = mutableListOf(
        User("user001", "Pete1987", "peter.baker@gmail.com"),
        User("user002", "BigAirJosh92", "josh.bigair@gmail.com"),
        User("userXXX", "Anonym", ""),
    )

    fun getById(id: String) = users.find { it.id == id }
}
