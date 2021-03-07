package com.example.a160418042_advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418042_advweek4.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch() {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778","https://st2.depositphotos.com/1006318/5909/v/600/depositphotos_59095493-stock-illustration-profile-icon-male-avatar.jpg")
        studentLD.value = student1
    }
}
