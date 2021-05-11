package com.example.a160418042_advweek4.view

import android.view.View
import com.example.a160418042_advweek4.model.Student

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v: View)
}

interface ButtonSaveChangesClicklistener {
    fun ButtonSaveChangesClick(v: View, obj: Student)
}

interface ButtonNotifClicklistener {
    fun ButtonNotifClick(v: View, obj: Student)
}