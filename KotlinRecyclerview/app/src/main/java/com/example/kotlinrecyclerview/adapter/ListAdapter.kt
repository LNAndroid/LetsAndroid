package com.example.kotlinrecyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlinrecyclerview.R
import kotlinx.android.synthetic.main.list_item_recyclerview.view.*

/**
 * Created by letsnurture on 20/2/18.
 */
class ListAdapter(private val string: String) :
        RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private val items: MutableList<Pair<String, Boolean>> = mutableListOf()

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            bindData(items[position])
        }
    }

    fun addNewItem(newString: String)
            = items.add(uniqueString(newString) to false).also {
        notifyItemInserted(itemCount - 1)
    }


    fun uniqueString(baseString: String) = "$baseString ${(Math.random() * 1000).toInt()}"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_recyclerview, parent, false)
                    .run {
                        MyViewHolder(this)
                    }


    inner class MyViewHolder(itemView: View,
                             private val textView1: TextView = itemView.findViewById(R.id.textViewListItemOne),
                             private val textView2: TextView = itemView.findViewById(R.id.textViewListItemTwo),
                             upButton: View = itemView.findViewById(R.id.imageViewUp),
                             downButton: View = itemView.findViewById(R.id.imageViewDown),
                             addButton: View = itemView.findViewById(R.id.imageViewAdd),
                             removeButton: View = itemView.findViewById(R.id.imageViewRemove)
    ) : RecyclerView.ViewHolder(itemView) {
        init {
            upButton.setOnClickListener(callMoveUp())
            downButton.setOnClickListener(callMoveDown())
            addButton.setOnClickListener(callAddValue())
            removeButton.setOnClickListener(callRemoveValues())
            textView1.setOnClickListener(callToggleText())
        }

        private fun callToggleText(): (View) -> Unit ={
            items[layoutPosition] = items[layoutPosition].let {
                it.first to !it.second
            }
            notifyItemChanged(layoutPosition)
        }

        private fun callRemoveValues(): (View) -> Unit = {
            layoutPosition.also { currentPosition ->
                items.removeAt(
                        currentPosition)
                notifyItemRemoved(currentPosition)
            }

        }

        private fun callAddValue(): (View) -> Unit = {
            layoutPosition.also { currentPosition ->
                items.add(
                        currentPosition, uniqueString(string) to false)
                notifyItemInserted(currentPosition)
            }

        }

        private fun callMoveDown(): (View) -> Unit = {
            layoutPosition.takeIf { it < items.size - 1 }?.also { currentPosition ->
                items.removeAt(currentPosition).also {
                    items.add(currentPosition + 1, it)
                }
                notifyItemMoved(currentPosition, currentPosition + 1)
            }
        }

        private fun callMoveUp(): (View) -> Unit = {
            layoutPosition.takeIf { it > 0 }?.also { currentPosition ->
                items.removeAt(currentPosition).also {
                    items.add(currentPosition - 1, it)
                }
                notifyItemMoved(currentPosition, currentPosition - 1)
            }
        }


        fun bindData(pair: Pair<String, Boolean>) {
            textView1.text = pair.first
            textView2.visibility = if (pair.second) View.VISIBLE else View.GONE
        }
    }
}