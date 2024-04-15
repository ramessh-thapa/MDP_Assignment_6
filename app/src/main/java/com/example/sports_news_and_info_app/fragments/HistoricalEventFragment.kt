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
import com.example.sports_news_and_info_app.dailog.HistoricalEventDialogActivity
import com.miu.mdp.sporty.Pages.HistoricalActivitys.Model.HistoricalActivity
import com.miu.mdp.sporty.Pages.HistoricalActivitys.Model.historicalEventData


class HistoricalEventFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun openDialog() {
        val dialoag = HistoricalEventDialogActivity()
        dialoag.showDialog(parentFragmentManager, requireContext(), this::addNewData);
    }

    override fun onDataReturned(data: Any) { }

    fun addNewData(data: HistoricalActivity){
        historicalEventData.add(data)
        adapter.notifyDataSetChanged()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_historical_activity, container, false)
        recyclerView = view.findViewById(R.id.historical_activity_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
         recyclerView.layoutManager = layoutManager
        adapter = MyAdapter(requireContext(), historicalEventData.getAll())
        recyclerView.adapter = adapter
    }

    inner class MyAdapter(private val context: Context, private val list: List<HistoricalActivity>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_historical_activity_layout, parent, false)
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
            private val historicalActivityNameTextView: TextView = itemView.findViewById(R.id.text_historical_activity_name)
            private val historicalActivityDescrptionTextView: TextView = itemView.findViewById(R.id.text_historical_activity_description)
            private val historicalActivityDateTextView: TextView = itemView.findViewById(R.id.text_historical_activity_date)
        
            fun bind(item: HistoricalActivity) {
                historicalActivityNameTextView.text = item.name
                historicalActivityDateTextView.text = item.date
                historicalActivityDescrptionTextView.text = item.description
            }
        }
    }
}
