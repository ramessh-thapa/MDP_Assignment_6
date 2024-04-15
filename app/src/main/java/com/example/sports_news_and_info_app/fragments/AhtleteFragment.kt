package com.example.sports_news_and_info_app.fragments
import android.content.Context


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.adapters.BaseFragment
import com.example.sports_news_and_info_app.dailog.AthleteDialogActivity
import com.example.sports_news_and_info_app.models.Athlete
import com.example.sports_news_and_info_app.models.athletesData


class AthleteFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun openDialog() {
        val dialoag = AthleteDialogActivity()
        dialoag.showDialog(requireContext(), this::addNewData);
    }

    override fun onDataReturned(data: Any) { }

    fun addNewData(data: Athlete){
        athletesData.add(data)
        adapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_athlete, container, false)
        recyclerView = view.findViewById(R.id.athlete_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
         recyclerView.layoutManager = layoutManager
        adapter = MyAdapter(requireContext(), athletesData.getAll())
        recyclerView.adapter = adapter
    }

    inner class MyAdapter(private val context: Context, private val list: List<Athlete>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_athlete_layout, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val item = list[position]
            holder.bind(item)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val athleteNameTextView: TextView = itemView.findViewById(R.id.text_athlete_name)
            private val athleteSportTextView: TextView = itemView.findViewById(R.id.text_athlete_sport)
            private val athleteCountryTextView: TextView = itemView.findViewById(R.id.text_athlete_country)
            private val athletePerformanceTextView: TextView = itemView.findViewById(R.id.text_athlete_performance)
            private val athleteMedalsNameView: TextView = itemView.findViewById(R.id.text_athlete_medals)
            private val athleteFactsTextView: TextView = itemView.findViewById(R.id.text_athlete_facts)

            fun bind(item: Athlete) {
                athleteNameTextView.text = "Name: " +item.name
                athleteCountryTextView.text = "Country: " + item.country
                athleteSportTextView.text = "Sport: " + item.sport
                athletePerformanceTextView.text = "Personal Best: " + item.performance
                athleteMedalsNameView.text = "Medals Awarded: " +item.medal
                athleteFactsTextView.text = "Facts: " +item.facts

            }
        }
    }


}
