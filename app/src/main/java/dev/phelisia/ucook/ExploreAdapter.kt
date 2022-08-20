package dev.phelisia.ucook

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.phelisia.ucook.databinding.ExploreListItemBinding
import dev.phelisia.ucook.databinding.HomeImagesListBinding

class ExploreAdapter(var imageList: List<ExploreItem>) : RecyclerView.Adapter<ImageViewerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewerHolder {
        var binding = ExploreListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        var imageViewHolder = ImageViewerHolder(binding)
        return imageViewHolder

    }

    override fun onBindViewHolder(holder: ImageViewerHolder, position: Int) {
        var currentimages = imageList.get(position)
        holder.binding.tvexploreinfo.text = currentimages.name

        Picasso.get().load(currentimages.image)
            .placeholder(R.drawable.ic_baseline_food_bank_24)
            .error(R.drawable.ic_baseline_food_bank_24)
            .resize(350, 350)
            .centerCrop()
            .into(holder.binding.ivexplorefood)
        val context = holder.itemView.context
        holder.binding.ivexplorefood.setOnClickListener {
            Toast.makeText(
                context,
                "you have clicked on ${currentimages}the image",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}
class  ImageViewerHolder(var binding: ExploreListItemBinding):RecyclerView.ViewHolder(binding.root)

