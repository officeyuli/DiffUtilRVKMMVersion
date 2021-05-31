package com.yuli.diffutilrvkmm.android.view

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.yuli.diffutilrvkmm.models.Employee


class EmployeeDiffItemCallbackImpl : DiffUtil.ItemCallback<Employee>() {

    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.name.equals(newItem.name)
    }

    @Nullable
    override fun getChangePayload(oldItem: Employee, newItem: Employee): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}