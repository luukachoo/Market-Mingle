package com.feature.match.screen.live_matches.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.core.common.R
import com.core.common.extension.convertDate
import com.core.common.extension.loadImagesWithGlide
import com.feature.live_matches.databinding.ItemLiveBinding
import com.feature.match.extension.checkForPreview
import com.feature.match.model.match.MatchWrapper

class LivesRecyclerAdapter :
    ListAdapter<MatchWrapper.Match, LivesRecyclerAdapter.LivesViewHolder>(LivesDiffCallback) {

    private var onClick: ((MatchWrapper.Match) -> Unit)? = null

    inner class LivesViewHolder(private val binding: ItemLiveBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(match: MatchWrapper.Match) = with(binding) {
            ivPreview.loadImagesWithGlide(
                match.streamsList.checkForPreview(),
                placeHolder = R.drawable.img_stream_error
            )
            tvLeague.text = match.beginAt.convertDate()
            tvTitle.text = match.name

            if (match.status == "running") {
                lottieLiveNowAnimation.isAnimating
            } else {
                !lottieLiveNowAnimation.isAnimating
            }

            root.setOnClickListener { onClick?.invoke(match) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LivesViewHolder(
        ItemLiveBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: LivesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun onClick(click: (MatchWrapper.Match) -> Unit) {
        this.onClick = click
    }

    private object LivesDiffCallback : DiffUtil.ItemCallback<MatchWrapper.Match>() {
        override fun areItemsTheSame(
            oldItem: MatchWrapper.Match,
            newItem: MatchWrapper.Match
        ): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MatchWrapper.Match,
            newItem: MatchWrapper.Match
        ): Boolean =
            oldItem == newItem

    }
}