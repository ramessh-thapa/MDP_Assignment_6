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
import com.example.sports_news_and_info_app.dailog.EventDialogActivity
import com.example.sports_news_and_info_app.models.Event
import com.example.sports_news_and_info_app.models.eventData

class EventFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun openDialog() {
        val dialoag = EventDialogActivity()
        dialoag.showDialog(parentFragmentManager, requireContext(), this::addNewData);
    }

    override fun onDataReturned(data: Any) { }

    fun addNewData(data: Event){
        eventData.add(data)
        adapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        recyclerView = view.findViewById(R.id.event_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        adapter = MyAdapter(requireContext(), eventData.getAll())
        recyclerView.adapter = adapter
    }

 inner class MyAdapter(private val context: Context, private val list: List<Event>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event_layout, parent, false)
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
            private val eventNameTextView: TextView = itemView.findViewById(R.id.text_event_name)
            private val eventDescrptionTextView: TextView = itemView.findViewById(R.id.text_event_description)
            private val eventDateTextView: TextView = itemView.findViewById(R.id.text_event_date)
        
            fun bind(item: Event) {
                eventNameTextView.text = item.name
                eventDateTextView.text = item.date
                eventDescrptionTextView.text = item.description
            }
        }
    }
}
