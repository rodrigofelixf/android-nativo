package br.com.dio.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.recyclerview.databinding.ResItemLiveBinding
import br.com.dio.recyclerview.models.Live
import kotlinx.android.synthetic.main.res_item_live.view.*

class LiveAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ResItemLiveBinding
    private var item: List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LiveViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_live, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LiveViewHolder -> {
                holder.bind(item[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    class LiveViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val liveTitle = itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        fun bind(live: Live) {
            liveTitle.text = live.title
            liveAuthor.text = live.author

        }
    }

}