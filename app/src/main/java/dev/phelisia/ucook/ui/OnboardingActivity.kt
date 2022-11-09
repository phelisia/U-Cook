package dev.phelisia.ucook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import dev.phelisia.ucook.OnboardingItem
import dev.phelisia.ucook.adapters.OnboardingItemsAdapter
import dev.phelisia.ucook.R
import dev.phelisia.ucook.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var adapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainerLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        indicatorsContainerLayout = binding.indicatorsContainer
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
        setViewPagerListener()
        setClickListeners()
    }

    private fun setOnboardingItems() = with(binding) {
        adapter = OnboardingItemsAdapter()
        adapter.setItems(
            listOf(
                OnboardingItem(
                    image = R.drawable.ladytwo,
                    title = "10,000+ Recipes",
                    description = "over ten thousan recipes for tasty, \n" +
                            "delicious and mouth watering meals you dont want to miss.\n."
                ),
                OnboardingItem(
                    image = R.drawable.ladyone,
                    title = "Browse Recipes",
                    description = "Explore recipes based on type of meal ,cuisines preparation methods,countries and more ......"
                ),
                OnboardingItem(
                    image = R.drawable.img_7,
                    title = "Cooking Made Easy",
                    description = "Cook easy with detailed step-by-step instructions, tips and how-to video tutorials   ."
                )
            )
        )
        onboardingViewPager.adapter = adapter
    }

    private fun setClickListeners() = with(binding) {
        tvSkip.setOnClickListener {
            navigateToWelcomePage()
        }
        btnGet.setOnClickListener {
            if (onboardingViewPager.currentItem + 1 < adapter.itemCount) {
                onboardingViewPager.currentItem += 1
            } else {
                navigateToWelcomePage()
            }
        }
    }

    private fun navigateToWelcomePage() {
        startActivity(welcomePage.getIntent(this@OnboardingActivity))
        finish()
    }

    private fun setViewPagerListener() = with(binding) {
        onboardingViewPager.adapter = adapter
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
    }

    //We will now iterate through the size of the adapter and create multiple inactive background states
    private fun setupIndicators() = with(binding) {
        indicatorsContainerLayout = indicatorsContainer
        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 8, 8, 0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.icon_outer_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainerLayout.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int) = with(binding) {
        val childCount = indicatorsContainerLayout.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorsContainerLayout.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}