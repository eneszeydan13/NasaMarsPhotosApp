package com.example.nasaproject.viewholder

import android.annotation.SuppressLint
import android.app.Dialog
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import com.example.nasaproject.MainActivity
import com.example.nasaproject.R
import com.example.nasaproject.filterList
import com.example.nasaproject.model.Photo
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.feed_item.view.*


class FeedItem(val photo:Photo): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            Picasso.get()
                .load(photo.img_src)
                .into(viewHolder.itemView.feedImage)
    }

    override fun getLayout(): Int {
        return R.layout.feed_item
    }
}


