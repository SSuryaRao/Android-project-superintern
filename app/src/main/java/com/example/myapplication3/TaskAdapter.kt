package com.example.myapplication3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.databinding.ItemTaskBinding // This is auto-generated

class TaskAdapter(private val taskList: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // This class holds the views for a single list item.
    // It uses View Binding to avoid findViewById.
    inner class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.textViewTaskTitle.text = task.title
            binding.textViewTaskDescription.text = task.description
            binding.textViewTaskPoints.text = "+${task.points} Points"
        }
    }

    // This is called when RecyclerView needs a new ViewHolder (a new item to show).
    // It inflates our item_task.xml layout.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    // This is called to display the data at a specific position.
    // It gets a task from our list and uses the ViewHolder to show it.
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = taskList[position]
        holder.bind(currentTask)
    }

    // This tells the RecyclerView how many items are in our list.
    override fun getItemCount(): Int {
        return taskList.size
    }
}