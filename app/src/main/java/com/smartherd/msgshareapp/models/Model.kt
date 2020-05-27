package com.smartherd.msgshareapp.models

/*
* #3.3 This is a model class where element of Hobbies is defined
* */

data class Hobby(var title: String)

object Supplier{

    // A list of hobbies is declared
    val hobbies = listOf<Hobby>(
        Hobby("swimming"),
        Hobby("Reading"),
        Hobby("Walking"),
        Hobby("Sleeping"),
        Hobby("Gaming"),
        Hobby("Programming"),
        Hobby("Talking"),
        Hobby("swimming"),
        Hobby("Reading"),
        Hobby("Walking"),
        Hobby("Sleeping"),
        Hobby("Gaming"),
        Hobby("Programming"),
        Hobby("Talking"),
        Hobby("swimming"),
        Hobby("Reading"),
        Hobby("Walking"),
        Hobby("Sleeping"),
        Hobby("Gaming"),
        Hobby("Programming"),
        Hobby("Talking")
    )
}