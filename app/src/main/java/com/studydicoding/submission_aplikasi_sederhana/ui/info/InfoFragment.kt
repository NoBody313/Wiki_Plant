package com.studydicoding.submission_aplikasi_sederhana.ui.info

import android.os.Build
import android.os.Bundle
import android.service.controls.ControlsProviderService
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.studydicoding.submission_aplikasi_sederhana.databinding.FragmentInfoBinding

@Suppress("DEPRECATION")
class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInfoBinding.inflate(layoutInflater)
        onCallBack()
        return binding.root
    }

    private fun onCallBack(): OnBackPressedCallback {
        val callback =
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                @RequiresApi(Build.VERSION_CODES.R)
                fun handleOnBackPressed() {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        Log.d(ControlsProviderService.TAG, "Fragment back pressed invoke")
                    }

                    if (isEnabled) {
                        isEnabled = false
                        requireActivity().onBackPressed()
                    }
                }
                handleOnBackPressed()
            }
        return callback
    }
}