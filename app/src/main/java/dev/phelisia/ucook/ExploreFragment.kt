package dev.phelisia.ucook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.phelisia.ucook.databinding.FragmentExploreBinding
import dev.phelisia.ucook.databinding.FragmentHomeBinding

class ExploreFragment : Fragment() {
    private lateinit var binding : FragmentExploreBinding
    private lateinit var linearLayout: LinearLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HeadExploreAdapter
    private val listOfRecipes = ExploreRecipe.get()
    private val listOfFilter =
        listOf(ExploreFilter.ALL, ExploreFilter.CATEGORY, ExploreFilter.CUISINE, ExploreFilter.TIME)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentExploreBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setuptoolbar()
        displayexploreImages()

       binding.linearLayout.exploreContainer
        recyclerView .exploreRecyclerView
        createExploreItem()
        setAdapter()

}
    fun displayexploreImages(){
        binding.rvexplore.layoutManager= GridLayoutManager(requireContext(),2)
        binding.rvexplore.adapter=ExploreAdapter(exploreImageList())

    }



    fun exploreImageList():List<ExploreItem>{
        var imageone=ExploreItem("Main course","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUwZNU2pblGn2qeL4U7BKE8UdhK_zxwU60Iw&usqp=CAU")
        var imagetwo=ExploreItem("Appetizers","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXAnSE511fBrs2pp15-PjrUq7pTmMvYzJPAg&usqp=CAU")
        var imagethree=ExploreItem("Soup","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_1JO264qmoP0SGWUEXtRmZYxK66f8EgbsMw&usqp=CAU")
        var imagefour=ExploreItem("Veggies","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtBakBx6FMm2Q7cbdk0ZPMBuYjcawQV4PKLQ&usqp=CAU")
        var imagefive=ExploreItem("Breakfast","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5RmuIHjsxiZ3sti1I8WtrWgUybJOf8yhy_w&usqp=CAU")
        var imagesix=ExploreItem("Lunch","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrXBoAU6HnKr0NFXs-UT9BzJzbZjtNdKmbvg&usqp=CAU")
        var imageseven=ExploreItem("Dessert","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReIY6JlHVtVcJxBKL9XkF-Li9VXHVSCLoW-w&usqp=CAU")
        var imageeight=ExploreItem("Starter","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzgTClKq-gj8FG4-W8IfVCS7xd6MQflMzoyQ&usqp=CAU")
        var imagenine=ExploreItem("African Food","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg_PGCWKZyycBAEX5-bvBQpXTtGa7wbu4UIg&usqp=CAU")
        var imageten=ExploreItem("Italian Food","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyiq7c2hBa_W6YjCDVO_4YhuNU0jdqNjALfw&usqp=CAU")


        var allimage= listOf(imageone,imagetwo,imagethree,imagefour,imagefive,imagesix,imageseven,imageeight,imagenine,imageten)
        return allimage
    }




    private fun setAdapter() {
        adapter = HeadExploreAdapter()
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter
        adapter.setData(listOfRecipes, ExploreFilter.ALL)

    }

    private fun createExploreItem() {
        listOfFilter.forEach {
            val container = ExploreFilterItem(it, requireContext(),this)
            linearLayout.addView(container)
        }
    }

    override fun onClick(filter: ExploreFilter) {
        adapter.setData(listOfRecipes, filter)
    }




//
//    fun setuptoolbar(){
//        setSupportActionBar(binding.tbexplore)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowTitleEnabled(false)
//    }




    companion object {

    }
}