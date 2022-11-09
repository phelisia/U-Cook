package dev.phelisia.ucook.ui
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.squareup.picasso.Picasso
import dev.phelisia.ucook.HomeItem
import dev.phelisia.ucook.R
import dev.phelisia.ucook.databinding.ActivityFoundItemBinding

class FoundItemActivity : AppCompatActivity() {
    lateinit var binding : ActivityFoundItemBinding
    val homeItem : HomeItem by lazy {  requireNotNull( intent.getParcelableExtra(HOME_ITEM_KEY)) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFoundItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStartCooking.setOnClickListener {
            startActivity(IngredientsActivity.getIntent(this))
        }

        Picasso.get().load(homeItem.image)
            .placeholder(R.drawable.ic_baseline_food_bank_24)
            .error(R.drawable.ic_baseline_food_bank_24)
            .resize(350, 350)
            .centerCrop()
            .into(binding.imgItem)

        val textView:TextView=binding.tvabout
        textView.text=homeItem.name
        val text:TextView=binding.tvIngredients
        text.text=homeItem.description




    }

    companion object{
        val HOME_ITEM_KEY = "home_item"
        fun getIntent(context: Context,homeItem: HomeItem): Intent {


            return  Intent(context, FoundItemActivity::class.java).apply {
                putExtra(HOME_ITEM_KEY,homeItem)
            }
        }

    }

}






