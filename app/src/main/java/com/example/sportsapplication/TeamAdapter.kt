package com.example.sportsapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TeamAdapter(val context: Context) : ListAdapter<Team, TeamAdapter.ViewHolder>(DiffCallBack) {
    lateinit var onItemClickListener: (Team) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val clubName: TextView = view.findViewById(R.id.textViewClubName)
        private val clubYear: TextView = view.findViewById(R.id.textViewYear)
        private val clubCups: TextView = view.findViewById(R.id.textViewChampions)
        private val clubImage: ImageView = view.findViewById(R.id.imageClubImage)
        private val clubCountry: ImageView = view.findViewById(R.id.imageCountryImage)

        fun bind(team: Team) {
            clubName.text = team.teamName
            clubCups.text = "Cups " + team.cups.toString()
            clubYear.text = "Year " + team.teamYear.toString()

            val image = when (team.country) {
                Country.Argentina -> R.drawable.argentina
                Country.England -> R.drawable.england
                Country.France -> R.drawable.france
                Country.Italia -> R.drawable.italia
                Country.Spain -> R.drawable.spain
            }

            clubCountry.setImageResource(image)

            Glide.with(context)
                .load(team.url)
                .into(clubImage)

            view.setOnClickListener {
                onItemClickListener(team)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamAdapter.ViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(team)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Team>() {
        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem == newItem
        }
    }
}