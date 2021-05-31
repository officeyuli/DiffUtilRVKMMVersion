package com.yuli.diffutilrvkmm.android.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yuli.diffutilrvkmm.android.R
import com.yuli.diffutilrvkmm.models.Employee


class EmployeeRecyclerViewAdapter(diffCallback: DiffUtil.ItemCallback<Employee>) :
    ListAdapter<Employee, EmployeeRecyclerViewAdapter.ViewHolder>(diffCallback) {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val role: TextView = itemView.findViewById(R.id.employee_role)
        val name: TextView = itemView.findViewById(R.id.employee_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = getItem(position).name
        holder.role.text = getItem(position).role
    }
}