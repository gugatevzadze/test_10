package com.example.test_10.presentation.screen.main

import com.example.test_10.databinding.FragmentMainBinding
import com.example.test_10.presentation.base.BaseFragment
import com.example.test_10.presentation.screen.bottom_sheet.FromAccountBottomSheetFragment
import com.example.test_10.presentation.screen.bottom_sheet.ToAccountBottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    override fun bindSetup() {
    }

    override fun bindActionListeners() {
        buttonSetup()
    }

    override fun bindObservers() {
    }

    private fun buttonSetup() {
        binding.btnFrom.setOnClickListener {
            val bottomSheetFragmentFrom = FromAccountBottomSheetFragment()
            bottomSheetFragmentFrom.show(childFragmentManager, bottomSheetFragmentFrom.tag)
        }
        binding.btnTo.setOnClickListener {
            val bottomSheetFragmentTo = ToAccountBottomSheetFragment()
            bottomSheetFragmentTo.show(childFragmentManager, bottomSheetFragmentTo.tag)
        }
    }
}