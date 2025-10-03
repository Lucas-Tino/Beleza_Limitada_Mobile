package com.example.beleza_limitada_mobile.model

data class Manutencao(
    val idManut: Long,
    val VeiculoId: Long,
    val Data: String,
    val Tipo: String,
    val Descricao: String,
    val responsavel: String
)
