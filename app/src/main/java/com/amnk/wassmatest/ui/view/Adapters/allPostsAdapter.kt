package com.amnk.wassmatest.ui.view.Adapters

import android.app.Application
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amnk.wassmatest.R
import com.amnk.wassmatest.data.model.getAllPostsResponse
import com.amnk.wassmatest.ui.viewmodel.postViewModel
import kotlinx.coroutines.NonDisposableHandle.parent
import com.amnk.wassmatest.app.inflate
import com.amnk.wassmatest.data.model.getAllPostsResponseItem
import kotlinx.android.synthetic.main.custom_getallposts_view.view.*


class allPostsAdapter (private var posts : List<getAllPostsResponseItem>,
                       var clickListener : onPostClickListener,
                       postViewModelObj : postViewModel
                      ) : RecyclerView.Adapter<allPostsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(parent.inflate(R.layout.custom_getallposts_view)
       )
    }
    fun updatepost(list : List<getAllPostsResponseItem>)
    {
        posts = list
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: allPostsAdapter.ViewHolder, position: Int) {
        holder.bind(posts[position], clickListener)
    }

    override fun getItemCount(): Int {
      return posts.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        private lateinit var posts: getAllPostsResponseItem
        fun bind(posts: getAllPostsResponseItem, action:onPostClickListener) {
            val postViewModelObj = postViewModel(applicationView = Application())
            this.posts = posts
              itemView.bodycontent.text = posts.body
              itemView.titlecontent.text = posts.title
//            itemView.setOnClickListener{
//                action.onItemClick(posts, adapterPosition, itemView)
//            }

        }

    }


}

interface onPostClickListener
{
    fun onClick(posts : getAllPostsResponse, position : Int,view : View)
}