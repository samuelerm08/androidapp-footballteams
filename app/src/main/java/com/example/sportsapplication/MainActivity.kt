package com.example.sportsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TeamAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TeamAdapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(getTeamList())
        adapter.onItemClickListener = { team ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", team.teamName)
            intent.putExtra("url", team.url)
            startActivity(intent)
        }
    }

    private fun getTeamList(): MutableList<Team>? {
        return mutableListOf(
            Team(1, "AC Milan", 7, 1899, Country.Italia, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Logo_of_AC_Milan.svg/1200px-Logo_of_AC_Milan.svg.png"),
            Team(2, "Inter", 3,  1899, Country.Italia, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/FC_Internazionale_Milano_2021.svg/160px-FC_Internazionale_Milano_2021.svg.png"),
            Team(3, "Real Madrid", 14, 1899, Country.Spain, "https://upload.wikimedia.org/wikipedia/en/thumb/5/56/Real_Madrid_CF.svg/1200px-Real_Madrid_CF.svg.png"),
            Team(4, "Barcelona", 5, 1899, Country.Spain, "https://upload.wikimedia.org/wikipedia/en/thumb/4/47/FC_Barcelona_%28crest%29.svg/1200px-FC_Barcelona_%28crest%29.svg.png"),
            Team(5, "Boca Juniors", 6,1899, Country.Argentina, "https://upload.wikimedia.org/wikipedia/commons/c/c9/Boca_escudo.png"),
            Team(6, "River Plate", 4, 1899, Country.Argentina, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Escudo_del_C_A_River_Plate.svg/1200px-Escudo_del_C_A_River_Plate.svg.png"),
            Team(7, "Tottenham", 0, 1899, Country.England, "https://upload.wikimedia.org/wikipedia/en/thumb/b/b4/Tottenham_Hotspur.svg/1200px-Tottenham_Hotspur.svg.png"),
            Team(8, "Manchester United", 3, 1899, Country.England, "https://w7.pngwing.com/pngs/997/289/png-transparent-manchester-united-logo-food-text-sport.png"),
            Team(9, "PSG", 0, 1970, Country.France, "https://upload.wikimedia.org/wikipedia/en/thumb/a/a7/Paris_Saint-Germain_F.C..svg/1200px-Paris_Saint-Germain_F.C..svg.png"),
            Team(10, "Lyon", 0, 1899, Country.France, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Logo_Olympique_Lyonnais_-_2022.svg/640px-Logo_Olympique_Lyonnais_-_2022.svg.png")
        )
    }
}