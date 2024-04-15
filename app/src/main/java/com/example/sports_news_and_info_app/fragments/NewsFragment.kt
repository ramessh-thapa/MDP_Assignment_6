package com.example.sports_news_and_info_app.fragments
import android.content.Context




import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sports_news_and_info_app.R
import com.example.sports_news_and_info_app.adapters.BaseFragment
import com.example.sports_news_and_info_app.dailog.NewsDialogActivity
import com.example.sports_news_and_info_app.models.News
import com.example.sports_news_and_info_app.models.newsData

class NewsFragment: BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adaptor: MyAdapter

    override fun openDialog() {
        val dialoag = NewsDialogActivity()
        dialoag.showDialog(requireContext(), this::addNewNews);
    }

    override fun onDataReturned(data: Any) { }

    fun addNewNews(data: News){
        newsData.addNews(data)
        adaptor.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        recyclerView = view.findViewById(R.id.news_recycler_view)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
         recyclerView.layoutManager = layoutManager
        adaptor = MyAdapter(requireContext(), newsData.getAllNews())
        recyclerView.adapter = adaptor
    }

    inner class MyAdapter(private val context: Context, private val list: List<News>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_layout, parent, false)
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
            private val imgNews: ImageView = itemView.findViewById(R.id.imgNews)
            private val txtNewsTitle: TextView = itemView.findViewById(R.id.txtNewsTitle)
            private val txtNewsDescription: TextView = itemView.findViewById(R.id.txtNewsDescription)

            fun bind(item: News) {
                txtNewsTitle.text = item.newsName
                txtNewsDescription.text = item.description
                Glide.with(context)
                    .load(item.newsUrl)
                    .into(imgNews)
            }
        }
    }
}
