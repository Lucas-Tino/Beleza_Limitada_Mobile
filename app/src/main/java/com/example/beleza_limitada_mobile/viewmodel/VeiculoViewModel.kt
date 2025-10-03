package com.example.beleza_limitada_mobile.viewmodel

import com.example.beleza_limitada_mobile.model.Veiculo
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

abstract class VeiculoViewModel {
    abstract var veiculoList: MutableList<Veiculo>

    val db = FirebaseFirestore.getInstance()

    fun addVeiculo(veiculo: HashMap<String, String>) {
        db.collection("veiculos")
            .add(veiculo)
    }

    fun getVeiculo(idVeiculo: String): Task<DocumentSnapshot?> {
        return db.collection("veiculos").document(idVeiculo)
            .get()
            .addOnSuccessListener { document ->
                Veiculo(
                    idVeiculo = document.id.toLong(),
                    Placa = document.getString("placa") ?: "",
                    Modelo = document.getString("modelo") ?: "",
                    Ano = document.getString("ano")!!.toInt(),
                    Cor = document.getString("cor") ?: "",
                    Status = document.getString("status") ?: ""
                )
            }
        // provavelmente tem coisa pra alterar, eu confiro dps (read é ironicamente o mais chato do crud com firestore
    }

    fun getAllVeiculos() {
        db.collection("veiculo")
            .get()
            .addOnSuccessListener { documents ->
                veiculoList = documents.map { document ->
                    Veiculo(
                        idVeiculo = document.id.toLong(),
                        Placa = document.getString("placa") ?: "",
                        Modelo = document.getString("modelo") ?: "",
                        Ano = document.getString("ano")!!.toInt(),
                        Cor = document.getString("cor") ?: "",
                        Status = document.getString("status") ?: ""
                    )
                } as MutableList<Veiculo>
            }
        // lembrete: tentar fazer essa função retornar a lista ao invés de salvar em uma variável desta mesma classe
    }

    fun updateVeiculo(veiculo: HashMap<String, String>, idVeiculo: String) {
        db.collection("veiculos").document(idVeiculo)
            .set(veiculo)
            // funções a mais para erro ou sucesso
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->

            }
    }

    fun deleteVeiculo(idVeiculo: String) {
        db.collection("veiculos").document(idVeiculo)
            .delete()
            // funções a mais para erro ou sucesso
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->

            }
    }
}