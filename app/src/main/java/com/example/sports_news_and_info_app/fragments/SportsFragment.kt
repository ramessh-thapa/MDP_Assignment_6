package com.example.sports_news_and_info_app.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.adapters.BaseFragment
import com.example.sports_news_and_info_app.dailog.NewsDialogActivity
import com.example.sports_news_and_info_app.dailog.SportsDialogActivity
import com.example.sports_news_and_info_app.models.News
import com.example.sports_news_and_info_app.models.Sport
import com.example.sports_news_and_info_app.models.SportsData

class SportsFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adaptor: MyAdapter

    override fun openDialog() {
        val dialoag = SportsDialogActivity()
        dialoag.showDialog(requireContext(), this::addNewSports);
    }

    override fun onDataReturned(data: Any) { }

    fun addNewSports(data: Sport){
        SportsData.add(data)
        adaptor.notifyDataSetChanged()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sports, container, false)
        recyclerView = view.findViewById(R.id.sport_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
         recyclerView.layoutManager = layoutManager
        adaptor = MyAdapter(requireContext(), SportsData.getAll())
        recyclerView.adapter = adaptor
    }

    inner class MyAdapter(private val context: Context, private val list: List<Sport>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport_layout, parent, false)
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
            private val sportTypeTextView: TextView = itemView.findViewById(R.id.text_sport_type)
            private val sportNameTextView: TextView = itemView.findViewById(R.id.text_sport_name)
            private val instructionTextView: TextView = itemView.findViewById(R.id.text_instruction)

            fun bind(item: Sport) {
                sportTypeTextView.text = item.sportType
                sportNameTextView.text = item.sportName
                instructionTextView.text = item.instruction
            }
        }
    }
}
