package com.yuli.diffutilrvkmm.repo

import com.yuli.diffutilrvkmm.models.Employee


interface EmployeeRepository {
    fun getEmployeeList() : MutableList<Employee>
    fun employeeListSortedByRole(): List<Employee>
    fun employeeListSortedByName(): List<Employee>
}