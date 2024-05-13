package com.example.jobmanagementapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.jobmanagementapp.models.Employee
import com.example.jobmanagementapp.navigation.ROUTE_REGISTER
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EmployeeViewModel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_REGISTER)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun deleteEmployee(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Employee/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Employee deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateEmployee(name: String, contact: String, email: String, id: String) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Employee/$id")
        progress.show()
        var updateData = Employee(name, contact, email, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun saveEmployee(employeeName: String, employeeContact: String, employeeEmail: String) {
        var id = System.currentTimeMillis().toString()
        var employeeData = Employee(employeeName, employeeContact, employeeEmail, id)
        var employeeRef = FirebaseDatabase.getInstance().getReference()
            .child("Employee/$id")
        progress.show()
        employeeRef.setValue(employeeData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewEmployee(
        employee: MutableState<Employee>,
        employees: SnapshotStateList<Employee>
    ): SnapshotStateList<Employee> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Employees")

        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //progress.dismiss()
                employees.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Employee::class.java)
                    employee.value = value!!
                    employees.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return employees
    }


}
