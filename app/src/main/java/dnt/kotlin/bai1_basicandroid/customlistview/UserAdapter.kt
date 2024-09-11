package dnt.kotlin.bai1_basicandroid.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import dnt.kotlin.bai1_basicandroid.R

class UserAdapter(
    private val context: Context,
    private val userList: List<User>
) : BaseAdapter() {

    override fun getCount(): Int {
        return userList.size
    }

    override fun getItem(position: Int): Any {
        return userList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            // Inflate layout cho từng dòng trong ListView
            view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

            // Tạo ViewHolder để lưu trữ các View
            viewHolder = ViewHolder(
                view.findViewById(R.id.tvName),
                view.findViewById(R.id.tvAge),
                view.findViewById(R.id.tvGender)
            )

            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val user = userList[position]

        viewHolder.nameTextView.text = user.name
        viewHolder.ageTextView.text = "Age: ${user.age}"
        viewHolder.genderTextView.text = "Gender: ${user.gender}"

        return view
    }

    private data class ViewHolder(
        val nameTextView: TextView,
        val ageTextView: TextView,
        val genderTextView: TextView
    )
}
