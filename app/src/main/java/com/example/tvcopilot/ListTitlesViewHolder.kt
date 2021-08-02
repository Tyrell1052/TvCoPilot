package com.example.tvcopilot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListTitlesViewHolder (view: View): RecyclerView.ViewHolder(view) {
        private val TAG: String = "ListTitleViewHolder"

        private val name = view.findViewById<TextView>(R.id.contacts_name)// needs to be bind to view on xml

        fun bind (title: TitlesBO) {
            name.text = TitlesBO.name
        }

        companion object {
            fun create(parent: ViewGroup): ListTitlesViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_suggestions, parent, false)

                return ListTitlesViewHolder(view)
            }
        }
}