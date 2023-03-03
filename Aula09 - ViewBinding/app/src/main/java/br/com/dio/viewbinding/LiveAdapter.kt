package br.com.dio.viewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.viewbinding.databinding.ActivityRecyclerViewViewBindingExampleBinding
import br.com.dio.viewbinding.models.Live
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class LiveAdapter(private val onItemClicked: (Live) -> Unit, private val binding: ActivityRecyclerViewViewBindingExampleBinding) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LiveViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_live, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is LiveViewHolder -> {
                holder.bind(items[position], onItemClicked)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(liveList: List<Live>) {
        this.items = liveList
    }

    class LiveViewHolder constructor(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {

        private val liveTitle = itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        fun bind(live: Live, onItemClicked: (Live) -> Unit) {

            liveTitle.text = live.title
            liveAuthor.text = live.author

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(live.thumbnailUrl)
                .into(liveThumbnail)

            itemView.setOnClickListener {
                onItemClicked(live)
            }

        }

    }

}
