package com.ydh.androiddesignstyle.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.ydh.androiddesignstyle.R
import com.ydh.androiddesignstyle.model.ProductModel

class ThirdProductAdapter (private val context: Context, private val items: List<ProductModel>, private val  itemListener: PostItemListener): RecyclerView.Adapter<ThirdProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.third_item, parent, false)
        return ProductViewHolder(view, this.itemListener)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = items[position]
        holder.title?.text = product.title
        holder.price?.text = product.price.toString()
        holder.image?.let { Glide.with(context).load(product.imageUrl).override(
            Target.SIZE_ORIGINAL,
            Target.SIZE_ORIGINAL
        ).into(it) }
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
        var price: TextView? = null
        var image: ImageView? = null

        init {
            title = view.findViewById(R.id.tv_third_item_title)
            price = view.findViewById(R.id.tv_third_item_price)
            image = view.findViewById(R.id.image_third_item)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val product = getItem(adapterPosition)
            this.itemListener.onPostClick(product)
            this@ThirdProductAdapter.notifyDataSetChanged()

        }

    }

}