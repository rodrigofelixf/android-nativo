package br.com.dio.viewbinding

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dio.viewbinding.databinding.ActivityMainBinding
import br.com.dio.viewbinding.databinding.ActivityRecyclerViewViewBindingExampleBinding

class RecyclerViewViewBindingExampleActivity : AppCompatActivity() {

    private lateinit var liveAdapter: LiveAdapter
    private val binding by lazy {
        ActivityRecyclerViewViewBindingExampleBinding
            .inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        initRecyclerView()
        addDataSource()
    }

    private fun initRecyclerView() {

        liveAdapter = LiveAdapter( { live ->
            openLink(live.link)
        }, this.binding)

        recycleriew.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewViewBindingExampleActivity)
            adapter = liveAdapter
        }

    }

    private fun openLink(link: String) {

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)

    }

    private fun addDataSource() {

        val dataSource = DataSource.createDataSet()
        liveAdapter.setList(dataSource)

    }
}