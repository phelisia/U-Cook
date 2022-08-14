package dev.phelisia.ucook

 sealed class HomeRecyclerViewItems {
  object CategoriesHeader:HomeRecyclerViewItems()
  data class CategoriesList( val categories:List<HomeItem>):HomeRecyclerViewItems()
 }


