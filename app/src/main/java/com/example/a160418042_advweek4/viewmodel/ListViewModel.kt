package com.example.a160418042_advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418042_advweek4.model.Student

class ListViewModel:ViewModel() {
    val studentsLD = MutableLiveData<List<Student>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh() {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778","https://st2.depositphotos.com/1006318/5909/v/600/depositphotos_59095493-stock-illustration-profile-icon-male-avatar.jpg")
        val student2 = Student("13312","Rich","1994/12/14","3925444073","https://st2.depositphotos.com/1006318/5909/v/600/depositphotos_59095493-stock-illustration-profile-icon-male-avatar.jpg")
        val student3 = Student("11204","Dinny","1994/10/07","6827808747","https://st2.depositphotos.com/1006318/5909/v/600/depositphotos_59095493-stock-illustration-profile-icon-male-avatar.jpg")

        val studentList:ArrayList<Student> = arrayListOf<Student>(student1, student2, student3)
        studentsLD.value = studentList
        loadingErrorLD.value = false
        loadingDoneLD.value = false
    }

}


