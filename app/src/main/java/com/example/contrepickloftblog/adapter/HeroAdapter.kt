package com.example.contrepickloftblog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contrepickloftblog.R
import com.example.contrepickloftblog.model.Hero
import org.w3c.dom.Text
import java.util.*

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {


    private val mHeroList: MutableList<Hero> = LinkedList()

    fun setData(newHero: List<Hero>) {
        mHeroList.clear()
        mHeroList.addAll(newHero)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            itemView = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.cell_hero,
                viewGroup,
                false
            )
        )


    }

    override fun getItemCount(): Int {
        return mHeroList.count()
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(model = mHeroList[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle: TextView = itemView.findViewById(R.id.txt_hero_title)
        private val txtAttackType: TextView = itemView.findViewById(R.id.txt_attack_type)
        private val imgAvatar: ImageView = itemView.findViewById(R.id.img_avatar)

        fun bind(model: Hero) {
            txtTitle.text = model.title


            //piece of shit because you don`t remember what is 1 or 0
            if (model.attackType == 0) {
                txtAttackType.text = itemView.context.getString(R.string.attack_type_melee)
            } else {
                txtAttackType.text = itemView.context.getString(R.string.attack_type_ranged)
            }
        }
    }
}