package com.example.test_10.presentation.screen.bottom_sheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_10.data.model.AccountDto
import com.example.test_10.databinding.ItemBottomSheetFromBinding

class FromAccountAdapter : ListAdapter<AccountDto, FromAccountAdapter.AccountViewHolder>(AccountDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBottomSheetFromBinding.inflate(layoutInflater, parent, false)
        return AccountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val account = getItem(position)
        holder.bind(account)
    }

    class AccountViewHolder(private val binding: ItemBottomSheetFromBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(account: AccountDto) {
            binding.accountName.text = account.accountName
            binding.accountNumber.text = account.accountNumber
            binding.valuteType.text = account.valuteType.displayName
            binding.cardType.text = account.cardType.displayName
            binding.balance.text = account.balance.toString()
        }
    }

    class AccountDiffCallback : DiffUtil.ItemCallback<AccountDto>() {
        override fun areItemsTheSame(oldItem: AccountDto, newItem: AccountDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AccountDto, newItem: AccountDto): Boolean {
            return oldItem == newItem
        }
    }
}