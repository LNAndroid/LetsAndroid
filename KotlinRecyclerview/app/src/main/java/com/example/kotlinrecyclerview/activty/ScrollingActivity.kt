package com.example.kotlinrecyclerview.activty

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.example.kotlinrecyclerview.R
import com.example.kotlinrecyclerview.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    private val itemString: String by lazy(LazyThreadSafetyMode.NONE) {
        getString(R.string.item_string)
    }
    private val myAdapter: ListAdapter by lazy(LazyThreadSafetyMode.NONE)
    {
        ListAdapter(itemString)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        recyclerViewItems.setup()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings ->{
                addItem()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun RecyclerView.setup() {
        adapter = this@ScrollingActivity.myAdapter
        layoutManager = LinearLayoutManager(this@ScrollingActivity, LinearLayoutManager.VERTICAL, false)
    }

    private fun addItem() {
        myAdapter.addNewItem(itemString)
    }
}
