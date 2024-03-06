package com.feature.home.recycler_adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.core.common.extension.loadImagesWithGlide
import com.feature.home.databinding.ItemHeaderSectionBinding
import com.feature.home.databinding.ItemLeaguesSectionBinding
import com.feature.home.model.League
import com.feature.home.model.Product
import com.feature.home.model.auth.Users
import com.feature.home.recycler_adapters.category.LeaguesAdapter

class MainRecyclerAdapter(
    private val categories: List<League>,
    private val model: Users?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onProductClick: ((Product) -> Unit)? = null

    var onAvatarClick: (() -> Unit)? = null

    inner class HeaderViewHolder(private val binding: ItemHeaderSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")

        fun bind(user: Users?) {
            binding.apply {
                tvUserName.text = "Welcome ${user?.userName}"

                ivAvatar.setOnClickListener {
                    onAvatarClick?.invoke()
                }
            }
        }
    }

    inner class CategoriesViewHolder(private val binding: ItemLeaguesSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindCategories(categories: List<League>) = binding.apply {
            val leagueAdapter = LeaguesAdapter()
            leagueAdapter.submitList(categories)
//            rvLeagues.adapter = leagueAdapter

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> {
                val headerBinding = ItemHeaderSectionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HeaderViewHolder(headerBinding)
            }

            else -> {
                val leagueBinding = ItemLeaguesSectionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CategoriesViewHolder(leagueBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(model)
            is CategoriesViewHolder -> holder.bindCategories(categories)
        }
    }

    override fun getItemCount(): Int = 2

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER
            else -> LEAGUES
        }
    }

    fun onPostClick(click: (Product) -> Unit) {
        this.onProductClick = click
    }

    companion object {
        private const val HEADER = 0
        private const val LEAGUES = 1
    }
}