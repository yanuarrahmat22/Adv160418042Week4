package com.example.a160418042_advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418042_advweek4.R
import com.example.a160418042_advweek4.databinding.StudentListItemBinding
import com.example.a160418042_advweek4.model.Student
import com.example.a160418042_advweek4.util.loadImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studenList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener
{
    class StudentViewHolder(var view: StudentListItemBinding) : RecyclerView.ViewHolder(view.root)
    fun updateStudentList(newStudentList: List<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)

//        view.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudentDetail()
//            Navigation.findNavController(it).navigate(action)
//        }
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studenList[position]
        holder.view.listener = this
//        Picasso.get().load(studenList[position].photoUrl).into(holder.view.imageView)
//        var id_student = studenList[position].id
//        holder.view.txtID.text = studenList[position].id
//        holder.view.txtName.text = studenList[position].name
//        holder.view.imageView.loadImage(studenList[position].photoUrl,
//                holder.view.progressBar)
//        holder.view.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudentDetail(id_student.toString())
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    override fun getItemCount(): Int {
        return studenList.size
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}