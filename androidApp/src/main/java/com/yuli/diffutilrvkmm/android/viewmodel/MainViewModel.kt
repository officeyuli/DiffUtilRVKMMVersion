package com.yuli.diffutilrvkmm.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yuli.diffutilrvkmm.models.Employee
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.yuli.diffutilrvkmm.EmployeeUseCase


class MainViewModel : ViewModel() {
    private val mEmployeeUseCase :EmployeeUseCase by lazy { EmployeeUseCase() }

    private val mEmployeeSortTypeLiveData: MutableLiveData<EmployeeSortType> by lazy {
        MutableLiveData<EmployeeSortType>(EmployeeSortType.ROLE)
    }

    fun getUsersWithNameLiveData(): LiveData<List<Employee>> {
        return Transformations.map(mEmployeeSortTypeLiveData) { employeeSortType: EmployeeSortType ->
            when (employeeSortType) {
                EmployeeSortType.ROLE -> mEmployeeUseCase.getEmployeeListSortedByRole()
                EmployeeSortType.NAME -> mEmployeeUseCase.getEmployeeListSortedByName()
            }
        }
    }

    fun updateSortType(employeeSortType: EmployeeSortType){
        this.mEmployeeSortTypeLiveData.value = employeeSortType
    }

}