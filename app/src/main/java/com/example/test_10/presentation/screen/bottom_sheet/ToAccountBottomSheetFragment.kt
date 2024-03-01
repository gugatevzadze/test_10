package com.example.test_10.presentation.screen.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test_10.databinding.FragmentBottomSheetFromBinding
import com.example.test_10.databinding.FragmentBottomSheetToBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToAccountBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomSheetToBinding? = null
    val binding: FragmentBottomSheetToBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetToBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}