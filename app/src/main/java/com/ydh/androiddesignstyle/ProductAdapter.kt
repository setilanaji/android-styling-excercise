package com.ydh.androiddesignstyle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL

//import com.squareup.picasso.Picasso

class ProductAdapter (private val context: Context, private val items: List<ProductModel>, private val  itemListener: PostItemListener): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view, this.itemListener)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = items[position]
        holder.title?.text = product.title
        holder.category?.text = product.category
        holder.image?.let { Glide.with(context).load(product.imageUrl).override(SIZE_ORIGINAL, SIZE_ORIGINAL).into(it) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): ProductModel {
        return items[position]
    }

    interface PostItemListener {
        fun onPostClick(postModel: ProductModel)
    }

    inner class ProductViewHolder(var view: View, var itemListener: PostItemListener) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        var title: TextView? = null
        var category: TextView? = null
        var image: ImageView? = null

        init {
            title = view.findViewById(R.id.tv_item_product_title)
            category = view.findViewById(R.id.tv_item_product_category)
            image = view.findViewById(R.id.img_item_product)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val post = getItem(adapterPosition)
            this.itemListener.onPostClick(post)
            this@ProductAdapter.notifyDataSetChanged()

        }

    }

}