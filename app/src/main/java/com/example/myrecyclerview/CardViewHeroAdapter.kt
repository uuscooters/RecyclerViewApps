package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_cardview_hero.view.*
import kotlinx.android.synthetic.main.item_grid_hero.view.*
import kotlinx.android.synthetic.main.item_grid_hero.view.img_item_photo
import java.util.*

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(holder: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(holder.context).inflate(R.layout.item_cardview_hero, holder, false)
        return CardViewViewHolder(view)
    }


    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hero = listHero[position]


        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail

        holder.btnFavorite.setOnClickListener { Toast.makeText(holder.itemView.context, "Favorite " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
        holder.btnShare.setOnClickListener { Toast.makeText(holder.itemView.context, "Share " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()}

        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu Memilih " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
    }

    override fun getItemCount(): Int = listHero.size

  inner class CardViewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        val btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        val btnShare: Button = itemView.findViewById(R.id.btn_set_share)
  }
}