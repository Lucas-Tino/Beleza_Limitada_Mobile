package com.example.beleza_limitada_mobile.viewmodel

import com.example.beleza_limitada_mobile.model.Vendedor
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

abstract class VendedorViewModel {
    abstract var vendedorList: MutableList<Vendedor>

    val db = FirebaseFirestore.getInstance()

    fun addVendedor(vendedor: HashMap<String, String>) {
        db.collection("vendedor")
            .add(vendedor)
    }

    fun getVendedor(idVendedor: String): Task<DocumentSnapshot?> {
        return db.collection("vendedor").document(idVendedor)
            .get()
            .addOnSuccessListener { document ->
                Vendedor(
                    idVendedor = document.id.toLong(),
                    Nome = document.getString("nome") ?: "",
                    Identificacao = document.getString("identificacao") ?: "",
                    RegiaoVenda = document.getString("regiaoVenda") ?: "",
                    VendedorId = document.getString("vendedorId")!!.toLong(),
                    Status = document.getString("status") ?: ""
                )
            }
        // provavelmente tem coisa pra alterar, eu confiro dps (read é ironicamente o mais chato do crud com firestore
    }

    fun getAllVendedor() {
        db.collection("vendedor")
            .get()
            .addOnSuccessListener { documents ->
                vendedorList = documents.map { document ->
                    Vendedor(
                        idVendedor = document.id.toLong(),
                        Nome = document.getString("nome") ?: "",
                        Identificacao = document.getString("identificacao") ?: "",
                        RegiaoVenda = document.getString("regiaoVenda") ?: "",
                        VendedorId = document.getString("vendedorId")!!.toLong(),
                        Status = document.getString("status") ?: ""
                    )
                } as MutableList<Vendedor>
            }
        // lembrete: tentar fazer essa função retornar a lista ao invés de salvar em uma variável desta mesma classe
    }

    fun updateVendedor(vendedor: HashMap<String, String>, idVendedor: String) {
        db.collection("vendedor").document(idVendedor)
            .set(vendedor)
            // funções a mais para erro ou sucesso
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->

            }
    }

    fun deleteVendedor(idVendedor: String) {
        db.collection("vendedor").document(idVendedor)
            .delete()
            // funções a mais para erro ou sucesso
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->

            }
    }
}