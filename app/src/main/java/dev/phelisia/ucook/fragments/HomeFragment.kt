package dev.phelisia.ucook.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.phelisia.ucook.*
import dev.phelisia.ucook.adapters.TrendingAdapter
import dev.phelisia.ucook.adapters.HomeAdapter
import dev.phelisia.ucook.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
private lateinit var binding :FragmentHomeBinding
    private var listeners: ExploreListener?=null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listeners = try {
            context as ExploreListener

        } catch (exception: ClassCastException) {
            throw ClassCastException()
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayHomeImage()
        displayTrendingImage()
        favouriteontouch()

    }
    fun displayHomeImage(){
        binding.rvhomedisplay.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvhomedisplay.adapter= HomeAdapter(listeners,createHomeImageList())
    }
    fun displayTrendingImage(){
        binding.rvtrendingdisplay.layoutManager= GridLayoutManager(requireContext(),2)
        binding.rvtrendingdisplay.adapter= TrendingAdapter(trendingHomeImageList())
    }

    fun createHomeImageList():List<HomeItem>{
        var imageone= HomeItem("Main course","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUwZNU2pblGn2qeL4U7BKE8UdhK_zxwU60Iw&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imagetwo= HomeItem("Appetizers","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXAnSE511fBrs2pp15-PjrUq7pTmMvYzJPAg&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imagethree= HomeItem("Soup","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_1JO264qmoP0SGWUEXtRmZYxK66f8EgbsMw&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imagefour= HomeItem("Veggies","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtBakBx6FMm2Q7cbdk0ZPMBuYjcawQV4PKLQ&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imagefive= HomeItem("Breakfast","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5RmuIHjsxiZ3sti1I8WtrWgUybJOf8yhy_w&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imagesix= HomeItem("Lunch","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrXBoAU6HnKr0NFXs-UT9BzJzbZjtNdKmbvg&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imageseven= HomeItem("Dessert","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReIY6JlHVtVcJxBKL9XkF-Li9VXHVSCLoW-w&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imageeight= HomeItem("Starter","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzgTClKq-gj8FG4-W8IfVCS7xd6MQflMzoyQ&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imagenine= HomeItem("African Food","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg_PGCWKZyycBAEX5-bvBQpXTtGa7wbu4UIg&usqp=CAU","lorem ispum lorem ispum lorem ispum")
        var imageten= HomeItem("Italian Food","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyiq7c2hBa_W6YjCDVO_4YhuNU0jdqNjALfw&usqp=CAU","lorem ispum lorem ispum lorem ispum")


        var allimages= listOf(imageone,imagetwo,imagethree,imagefour,imagefive,imagesix,imageseven,imageeight,imagenine,imageten)
       return allimages
    }
    fun trendingHomeImageList():List<TrendingItem>{
        var imageone= TrendingItem("Main course","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUwZNU2pblGn2qeL4U7BKE8UdhK_zxwU60Iw&usqp=CAU")
        var imagetwo= TrendingItem("Appetizers","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXAnSE511fBrs2pp15-PjrUq7pTmMvYzJPAg&usqp=CAU")
        var imagethree= TrendingItem("Soup","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_1JO264qmoP0SGWUEXtRmZYxK66f8EgbsMw&usqp=CAU")
        var imagefour= TrendingItem("Veggies","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtBakBx6FMm2Q7cbdk0ZPMBuYjcawQV4PKLQ&usqp=CAU")
        var imagefive= TrendingItem("Breakfast","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5RmuIHjsxiZ3sti1I8WtrWgUybJOf8yhy_w&usqp=CAU")
        var imagesix= TrendingItem("Lunch","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrXBoAU6HnKr0NFXs-UT9BzJzbZjtNdKmbvg&usqp=CAU")
        var imageseven= TrendingItem("Dessert","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReIY6JlHVtVcJxBKL9XkF-Li9VXHVSCLoW-w&usqp=CAU")
        var imageeight= TrendingItem("Starter","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzgTClKq-gj8FG4-W8IfVCS7xd6MQflMzoyQ&usqp=CAU")
        var imagenine= TrendingItem("African Food","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg_PGCWKZyycBAEX5-bvBQpXTtGa7wbu4UIg&usqp=CAU")
        var imageten= TrendingItem("Italian Food","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyiq7c2hBa_W6YjCDVO_4YhuNU0jdqNjALfw&usqp=CAU")


        var allimage= listOf(imageone,imagetwo,imagethree,imagefour,imagefive,imagesix,imageseven,imageeight,imagenine,imageten)
        return allimage
    }

    fun favouriteontouch(){

    }




    companion object {

    }

}
