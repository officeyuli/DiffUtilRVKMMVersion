package com.yuli.diffutilrvkmm.repo

import com.yuli.diffutilrvkmm.models.Employee

class EmployeeRepositoryImpl : EmployeeRepository {

    override fun getEmployeeList(): MutableList<Employee> {
        val employees: MutableList<Employee> = ArrayList()

        employees.add(Employee(1, "Employee 1", "Developer"))
        employees.add(Employee(2, "Employee 2", "Tester"))
        employees.add(Employee(3, "Employee 3", "Support"))
        employees.add(Employee(4, "Employee 4", "Sales Manager"))
        employees.add(Employee(5, "Employee 5", "Manager"))
        employees.add(Employee(6, "Employee 6", "Team lead"))
        employees.add(Employee(7, "Employee 7", "Scrum Master"))
        employees.add(Employee(8, "Employee 8", "Sr. Tester"))
        employees.add(Employee(9, "Employee 9", "Sr. Developer"))
        return employees
    }

    override fun employeeListSortedByRole(): List<Employee> {
        val employeeList = getEmployeeList()
        employeeList.sortBy { it.role }
        return employeeList
    }

    override fun employeeListSortedByName(): List<Employee> {
        val employeeList = getEmployeeList()
        employeeList.sortBy { it.name }
        return employeeList
    }
}