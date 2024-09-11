package dnt.kotlin.bai1_basicandroid.customlistview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import dnt.kotlin.bai1_basicandroid.R

class Dialog : DialogFragment() {

    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var edtGender: EditText

    interface UserListener {
        fun onUserAdded(user: User)
    }

    private lateinit var userListener: UserListener

    fun setOnUserAddListener(listener: UserListener) {
        userListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog, container, false)

        edtName = view.findViewById(R.id.edtName)
        edtAge = view.findViewById(R.id.edtAge)
        edtGender = view.findViewById(R.id.edtGender)
        val btAdd = view.findViewById<Button>(R.id.btAdd)
        btAdd.setOnClickListener {
            addUser()
            dismiss()
        }

        return view
    }

    private fun addUser() {
        val name = edtName.text.toString()
        val age = edtAge.text.toString().toInt()
        val gender = edtGender.text.toString()
        if(name.isEmpty() || age == 0 || gender.isEmpty()) {
            Toast.makeText(requireContext(),"Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }
        else {
            userListener.onUserAdded(User(name, age, gender))
            Toast.makeText(requireContext(),"Thêm thành công", Toast.LENGTH_SHORT).show()
        }
    }
}