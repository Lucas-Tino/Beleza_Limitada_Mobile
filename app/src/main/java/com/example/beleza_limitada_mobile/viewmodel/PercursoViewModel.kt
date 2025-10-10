package com.example.beleza_limitada_mobile.viewmodel

import com.example.beleza_limitada_mobile.model.Percurso
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.getField

abstract class PercursoViewModel {
    abstract var percursoList: MutableList<Percurso>

    val db = FirebaseFirestore.getInstance()

    fun addPercurso(percurso: HashMap<String, String>) {
        db.collection("percurso")
            .add(percurso)
    }

    fun getPercurso(idPercurso: String): Task<DocumentSnapshot?> {
        return db.collection("percurso").document(idPercurso)
            .get()
            .addOnSuccessListener { document ->
                Percurso(
                    idPercurso = document.id.toLong(),
                    VendedorId = document.getString("vendedorId")!!.toLong(),
                    Pontos = document.get("pontos") as List<String>,
                    DataEntrega = document.getString("tipo") ?: ""
                )
            }
        // provavelmente tem coisa pra alterar, eu confiro dps (read é ironicamente o mais chato do crud com firestore
    }

    fun getAllPercurso() {
        db.collection("percurso")
            .get()
            .addOnSuccessListener { documents ->
                percursoList = documents.map { document ->
                    Percurso(
                        idPercurso = document.id.toLong(),
                        VendedorId = document.getString("vendedorId")!!.toLong(),
                        Pontos = document.get("pontos") as List<String>,
                        DataEntrega = document.getString("tipo") ?: ""
                    )
                } as MutableList<Percurso>
            }
        // lembrete: tentar fazer essa função retornar a lista ao invés de salvar em uma variável desta mesma classe
    }

    fun updatePercurso(percurso: HashMap<String, String>, idPercurso: String) {
        db.collection("percurso").document(idPercurso)
            .set(percurso)
            // funções a mais para erro ou sucesso
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->

            }
    }

    fun deletePercurso(idPercurso: String) {
        db.collection("percurso").document(idPercurso)
            .delete()
            // funções a mais para erro ou sucesso
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->

            }
    }
}