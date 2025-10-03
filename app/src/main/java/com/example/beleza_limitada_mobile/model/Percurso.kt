package com.example.beleza_limitada_mobile.model

data class Percurso(
    val idPercurso: Long,
    val VendedorId: Long,
    val Pontos: List<String>,
    val DataEntrega: String
)
