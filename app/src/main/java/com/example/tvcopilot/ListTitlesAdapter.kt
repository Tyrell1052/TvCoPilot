package com.example.tvcopilot

import android.content.IntentFilter.create
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
//import kotlinx.android.synthetic.main.layout_title_list_item.view.*
import kotlin.collections.ArrayList
import com.example.tvcopilot.TitlesBO



class ListTitlesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<TitlesBO> = ArrayList()

    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return TitlesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_title_list_item, parent, false)
        )
//        return ListTitlesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is TitlesViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size

    }

    fun submitList(mediaTitles: List<TitlesBO>){
        items = mediaTitles
    }

//    companion object {
//        private val CONTACT_DIFFUTIL_CALLBACK = object: DiffUtil.ItemCallback<TitlesBO>() {
//            override fun areItemsTheSame(oldItem: TitlesBO, newItem: TitlesBO): Boolean {
//                return oldItem.id == newItem.id
//            }
//
//            override fun areContentsTheSame(oldItem: TitlesBO, newItem: TitlesBO): Boolean {
//                return oldItem.titles == newItem.titles
//            }
//        }
//    }

    class TitlesViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
         private val mediaTitle = itemView.titleView
        private val mediaYear = itemView.yearView
        private val mediaType = itemView.typeView

        fun bind(media: TitlesBO){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(media.image)
                .into(mediaTitle)
            mediaTitle.setText(media.title)
            mediaYear.setText(media.year)
            mediaType.setText(media.type)

        }
    }

}