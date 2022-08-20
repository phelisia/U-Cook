package dev.phelisia.ucook

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.phelisia.ucook.databinding.HomeImagesListBinding
import dev.phelisia.ucook.databinding.TrendingListBinding

class TrendingAdapter (var imageList: List<TrendingItem>): RecyclerView.Adapter<TrendingViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        var binding=TrendingListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var TrendingViewHolder=TrendingViewHolder(binding)
        return TrendingViewHolder
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        var currentimages=imageList.get(position)
        holder.binding.tvinfo.text=currentimages.name

        Picasso.get().load(currentimages.image)
            .placeholder(R.drawable.ic_baseline_food_bank_24)
            .error(R.drawable.ic_baseline_food_bank_24)
            .resize(350,350)
            .centerCrop()
            .into(holder.binding.ivfood)
        val context=holder.itemView.context
        holder.binding.ivfood.setOnClickListener {
            Toast.makeText(context,"you have clicked on ${currentimages}the image", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return  imageList.size
    }

}


class TrendingViewHolder(var binding: TrendingListBinding):RecyclerView.ViewHolder(binding.root){

}