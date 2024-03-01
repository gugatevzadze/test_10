package com.example.test_10.presentation.screen.bottom_sheet

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_10.databinding.FragmentBottomSheetFromBinding
import com.example.test_10.presentation.event.FromAccountEvent
import com.example.test_10.presentation.state.FromBottomSheetState
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FromAccountBottomSheetFragment: BottomSheetDialogFragment() {
    private var _binding: FragmentBottomSheetFromBinding? = null
    private val binding: FragmentBottomSheetFromBinding get() = _binding!!

    private val viewModel: FromAccountViewModel by viewModels()
    private lateinit var fromAccountAdapter: FromAccountAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetFromBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)
        bottomSheetBehavior.peekHeight = 500

        adapterSetup()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.accountsState.collect { state ->
                handleState(state)
            }
        }
    }

    private fun adapterSetup() {
        fromAccountAdapter = FromAccountAdapter()
        binding.rvAccounts.apply {
            adapter = fromAccountAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
        viewModel.onEvent(FromAccountEvent.FetchAccounts)
    }


    private fun handleState(state: FromBottomSheetState) {
        state.accounts.let { accounts ->
            fromAccountAdapter.submitList(accounts)
        }
        state.errorMessage?.let { errorMessage ->
            viewModel.onEvent(FromAccountEvent.Error(errorMessage))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}