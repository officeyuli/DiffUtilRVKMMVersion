package com.yuli.diffutilrvkmm.android.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yuli.diffutilrvkmm.android.R
import com.yuli.diffutilrvkmm.android.viewmodel.EmployeeSortType
import com.yuli.diffutilrvkmm.android.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val adapter: EmployeeRecyclerViewAdapter by lazy {
        EmployeeRecyclerViewAdapter(
            EmployeeDiffItemCallbackImpl()
        )
    }

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val employeeRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        employeeRecyclerView.adapter = adapter
        employeeRecyclerView.layoutManager = LinearLayoutManager(this)


        mainViewModel.getUsersWithNameLiveData().observe(this, {
            adapter.submitList(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sort_by_name -> mainViewModel.updateSortType(EmployeeSortType.NAME)
            R.id.sort_by_role -> mainViewModel.updateSortType(EmployeeSortType.ROLE)
        }
        return super.onOptionsItemSelected(item)
    }
}
