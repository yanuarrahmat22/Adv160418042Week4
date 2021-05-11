package com.example.a160418042_advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418042_advweek4.R
import com.example.a160418042_advweek4.databinding.FragmentStudentDetailBinding
import com.example.a160418042_advweek4.model.Student
import com.example.a160418042_advweek4.util.loadImage
import com.example.a160418042_advweek4.viewmodel.DetailViewModel
import com.example.a160418042_advweek4.viewmodel.ListViewModel
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.concurrent.TimeUnit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment(), ButtonSaveChangesClicklistener, ButtonNotifClicklistener {

    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
//            imageView.loadImage(it.photoUrl,progressBar)
//            txtID.setText(it.id)
//            txtName.setText(it.name)
//            txtBod.setText(it.bod)
//            txtPhone.setText(it.phone)

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail,container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var student_id = ""
        arguments?.let {
                student_id = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(student_id)

        dataBinding.listener = this
        dataBinding.notifier = this

        observeViewModel()
    }

    override fun ButtonSaveChangesClick(v: View, obj: Student) {
        Toast.makeText(v.context, "Just Toast For Button Update", Toast.LENGTH_SHORT).show()
    }

    override fun ButtonNotifClick(v: View, obj: Student) {
        btnNotif.setOnClickListener {
            Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    //Log.d("Messages", "five seconds")
                    MainActivity.showNotification(obj.name.toString(),
                        "A new notification created",R.drawable.ic_baseline_person_24)
                }
        }
    }
}