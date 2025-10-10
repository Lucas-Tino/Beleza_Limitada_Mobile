package com.example.beleza_limitada_mobile.viewmodel

import com.example.beleza_limitada_mobile.model.Manutencao
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

abstract class ManutencaoViewModel {
    abstract var manutencaoList: MutableList<Manutencao>

    val db = FirebaseFirestore.getInstance()

    fun addManutencao(manutencao: HashMap<String, String>) {
        db.collection("manutencao")
            .add(manutencao)
    }

    fun getManutencao(idManutencao: String): Task<DocumentSnapshot?> {
        return db.collection("manutencao").document(idManutencao)
            .get()
            .addOnSuccessListener { document ->
                Manutencao(
                    idManut = document.id.toLong(),
                    VeiculoId = document.getString("veiculoId")!!.toLong(),
                    Data = document.getString("data") ?: "",
                    Tipo = document.getString("tipo") ?: "",
                    Descricao = document.getString("descricao") ?: "",
                    responsavel = document.getString("responsavel") ?: ""
                )
            }
        // provavelmente tem coisa pra alterar, eu confiro dps (read é ironicamente o mais chato do crud com firestore
    }

    fun getAllManutencao() {
        db.collection("manutencao")
            .get()
            .addOnSuccessListener { documents ->
                manutencaoList = documents.map { document ->
                    Manutencao(
                        idManut = document.id.toLong(),
                        VeiculoId = document.getString("veiculoId")!!.toLong(),
                        Data = document.getString("data") ?: "",
                        Tipo = document.getString("tipo") ?: "",
                        Descricao = document.getString("descricao") ?: "",
                        responsavel = document.getString("responsavel") ?: ""
                    )
                } as MutableList<Manutencao>
            }
        // lembrete: tentar fazer essa função retornar a lista ao invés de salvar em uma variável desta mesma classe
    }

    fun updateManutencao(manutencao: HashMap<String, String>, idManutencao: String) {
        db.collection("manutencao").document(idManutencao)
            .set(manutencao)
            // funções a mais para erro ou sucesso
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->

            }
    }

    fun deleteManutencao(idManutencao: String) {
        db.collection("manutencao").document(idManutencao)
            .delete()
            // funções a mais para erro ou sucesso
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->

            }
    }
}