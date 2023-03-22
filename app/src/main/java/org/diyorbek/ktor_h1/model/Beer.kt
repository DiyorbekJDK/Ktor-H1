package org.diyorbek.ktor_h1.model

@kotlinx.serialization.Serializable
data class Beer(
    val alcohol: String,
    val blg: String,
    val brand: String,
    val hop: String,
    val ibu: String,
    val id: Int,
    val malts: String,
    val name: String,
    val style: String,
    val uid: String,
    val yeast: String
)