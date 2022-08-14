package dev.phelisia.ucook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.phelisia.ucook.databinding.HomeCategoriesHeaderBinding
import dev.phelisia.ucook.databinding.HomeImagesListBinding

class HomeAdapter : RecyclerView.Adapter< HomeViewHolder >() {
    var items = mutableListOf<HomeRecyclerViewItems>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  HomeViewHolder  {
        return  when (viewType){
            VIEW_TYPE_CATEGORIES_HEADER ->{

            }
        }
        var binding =
            HomeImagesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        var imageViewHolder =  HomeViewHolder (binding)
        return imageViewHolder
    }

    override fun onBindViewHolder(holder:  HomeViewHolder , position: Int) {
        var currentimages = imageList.get(position)
        holder.binding.tvinfo.text = currentimages.name

        Picasso.get().load(currentimages.image)
            .placeholder(R.drawable.ic_baseline_food_bank_24)
            .error(R.drawable.ic_baseline_food_bank_24)
            .resize(350, 350)
            .centerCrop()
            .into(holder.binding.ivfood)
        val context = holder.itemView.context
        holder.binding.ivfood.setOnClickListener {
            Toast.makeText(
                context,
                "you have clicked on ${currentimages}the image",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HomeRecyclerViewItems.CategoriesHeader -> VIEW_TYPE_CATEGORIES_HEADER
            is HomeRecyclerViewItems.CategoriesList -> VIEW_TYPE_CATEGORIES_LIST
        }
    }
 inner class CategoriesViewHolder(private val binding:HomeCategoriesHeaderBinding):HomeViewHolder(binding.root){
     override fun bind(position: Int) {


     }

 }

    inner class CategoriesListViewHolder(private val binding:HomeImagesListBinding):HomeViewHolder(binding.root){
        override fun bind(position: Int) {

        }

    }

    companion object {
        private const val VIEW_TYPE_CATEGORIES_HEADER = 0
        private const val VIEW_TYPE_CATEGORIES_LIST = 1
    }
}

abstract class HomeViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
    abstract fun bind(position: Int)

}



