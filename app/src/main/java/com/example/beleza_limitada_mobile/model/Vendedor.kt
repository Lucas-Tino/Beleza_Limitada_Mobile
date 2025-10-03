package com.example.beleza_limitada_mobile.model

data class Vendedor(
    val idVendedor: Long,
    val Nome: String,
    val Identificacao: String,
    val RegiaoVenda: String,
    val VeiculoId: Long,
    val Status: String
)
