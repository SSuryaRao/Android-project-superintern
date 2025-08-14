package com.example.myapplication3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication3.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val taskList = listOf(
            Task("UI/UX Design for a new feature", "Design a complete flow for the new chat feature", 50),
            Task("Write API Documentation", "Document all endpoints for the user profile service", 30),
            Task("Fix Login Button Bug", "The login button is not working on older Android versions", 75),
            Task("Create App Icon", "Design a new, modern icon for the application", 25),
            Task("Refactor User Repository", "Improve the code structure in the user data layer", 40)
        )
        taskAdapter = TaskAdapter(taskList)
        binding.recyclerViewTasks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = taskAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Important to avoid memory leaks
    }
}