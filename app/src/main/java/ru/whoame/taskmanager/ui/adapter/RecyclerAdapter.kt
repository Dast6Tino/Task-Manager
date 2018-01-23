package ru.whoame.taskmanager.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.whoame.taskmanager.R
import ru.whoame.taskmanager.model.TaskModel

class RecyclerAdapter(val onItemSelect: (Int) -> Unit, val onBottomScrolled: (Int) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_task, parent, false))

    private var onBottomScrolledCalled = false
    var showRoomId = false
    var items = ArrayList<TaskModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
            onBottomScrolledCalled = false
        }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(items[position], showRoomId)
        if (position > items.size - 4 && !onBottomScrolledCalled) {
            onBottomScrolled.invoke(items.size)
            onBottomScrolledCalled = true
        }

    }

    fun addItems(items: ArrayList<TaskModel>) {

        if (items.isNotEmpty()) {
            this.items = items
            notifyDataSetChanged()
            onBottomScrolledCalled = false
        }

    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        lateinit var item: TaskModel
        fun bind(item: TaskModel, showRoomId: Boolean) {
            this.item = item

            with(view) {
                //todo Добавление информации в итем

                setOnClickListener {
                    //onItemSelect.invoke(item.id!!)
                }
            }
        }
    }
}