package com.example.test_10.presentation.screen.bottom_sheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_10.data.model.AccountDto
import com.example.test_10.databinding.ItemBottomSheetFromBinding
import com.example.test_10.presentation.model.AccountModel

class FromAccountAdapter : ListAdapter<AccountModel, FromAccountAdapter.AccountViewHolder>(AccountDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBottomSheetFromBinding.inflate(layoutInflater, parent, false)
        return AccountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {

        holder.bind()
    }

    class AccountViewHolder(private val binding: ItemBottomSheetFromBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var account: AccountModel
        fun bind() {
            binding.accountName.text = account.accountName
            binding.accountNumber.text = account.accountNumber
            binding.valuteType.text = account.valuteType
            binding.cardType.text = account.cardType
            binding.balance.text = account.balance.toString()
        }
    }

    class AccountDiffCallback : DiffUtil.ItemCallback<AccountModel>() {
        override fun areItemsTheSame(oldItem: AccountModel, newItem: AccountModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AccountModel, newItem: AccountModel): Boolean {
            return oldItem == newItem
        }
    }
}