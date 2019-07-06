package com.example.devintensive.models

import com.example.devintensive.utils.Utils
import java.util.*

class User (
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    var lastVisit:Date? = null,
    var isOnline:Boolean? = false
    ) {

    constructor(id:String, firstName: String?, lastName: String?): this(
        id=id,
        firstName=firstName,
        lastName=lastName,
        avatar=null
    )

    constructor(id: String) : this(id, "John", "Doo")

    init {
    }

    companion object Factory {
        private var lastId : Int = -1
        fun makeUser(fullName:String?) : User {
            lastId++

            var (firstName, lastName) = Utils.parseFullName(fullName)

            if(firstName == null || lastName == null) {
                return User(id = "$lastId")
            }
            else {
                return User(id = "$lastId", firstName = firstName, lastName = lastName)
            }
        }
    }

}