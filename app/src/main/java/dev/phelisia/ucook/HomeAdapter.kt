package dev.phelisia.ucook

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.phelisia.ucook.databinding.HomeImagesListBinding
import kotlinx.android.synthetic.main.activity_found_item.view.*

class HomeAdapter(val listeners: ExploreListener?, var imageList: List<HomeItem>) : RecyclerView.Adapter<ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        var binding = HomeImagesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        var imageViewHolder = ImageViewHolder(binding)
        return imageViewHolder
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
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
            listeners?.onItemClicked(currentimages)

        }


    }


    override fun getItemCount(): Int {
        return imageList.size
    }
}

class ImageViewHolder(var binding: HomeImagesListBinding) : RecyclerView.ViewHolder(binding.root) {

}
