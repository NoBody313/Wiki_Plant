package com.studydicoding.submission_aplikasi_sederhana.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.constraintlayout.widget.StateSet
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.studydicoding.submission_aplikasi_sederhana.adapter.PlantAdapter
import com.studydicoding.submission_aplikasi_sederhana.data.DataPlant
import com.studydicoding.submission_aplikasi_sederhana.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        // CardView
        binding.rvListPlant.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 1)
            adapter = PlantAdapter(DataPlant.listPlant)
        }
        onCallBack()
        return binding.root
    }

    private fun onCallBack(): OnBackPressedCallback {
        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            fun handleOnBackPressed() {
                Log.d(StateSet.TAG, "Fragment back pressed invoke")

                if (isEnabled) {
                    isEnabled = false
                    requireActivity().onBackPressed()
                    activity?.finishAffinity()
                }
            }
            handleOnBackPressed()
        }
        return callback
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
