package com.example.test_10.data.model

import com.squareup.moshi.Json

data class AccountDto(
    val id: Int,
    @Json(name = "account_name")
    val accountName: String,
    @Json(name = "account_number")
    val accountNumber: String,
    @Json(name = "valute_type")
    val valuteType: Currency,
    @Json(name = "card_type")
    val cardType: CardType,
    val balance: Int,
    @Json(name = "card_logo")
    val cardLogo: String?
)
enum class Currency(val displayName: String) {
    USD("United States Dollar"),
    GEL("Georgian Lari"),
    EUR("Euro")
}

enum class CardType(val displayName: String) {
    VISA("Visa Card"),
    MASTER_CARD("Master Card")
}