package com.example.hm8x

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hm8x.databinding.ItemListBinding

class CharacterAdapter(
    private val characterList: ArrayList<CharacterModel>,
    private val clickListener: (Int) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from( parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
        holder.itemView.setOnClickListener {
            clickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    class CharacterViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterModel) {
            binding.apply {
                live.text = character.data
                personName.text = character.name
                Glide.with(binding.root)
                    .load(character.picture)
                    .into(binding.imgPicture)
            }
        }
    }
}
