package com.yuli.diffutilrvkmm

import com.yuli.diffutilrvkmm.repo.EmployeeRepository
import com.yuli.diffutilrvkmm.repo.EmployeeRepositoryImpl
import com.yuli.diffutilrvkmm.models.Employee




class EmployeeUseCase {

    private val mEmployeeRepository: EmployeeRepository by lazy { EmployeeRepositoryImpl() }

    fun getEmployeeListSortedByRole(): List<Employee> {
        return mEmployeeRepository.employeeListSortedByRole()
    }

    fun getEmployeeListSortedByName(): List<Employee> {
        return mEmployeeRepository.employeeListSortedByName()
    }
}