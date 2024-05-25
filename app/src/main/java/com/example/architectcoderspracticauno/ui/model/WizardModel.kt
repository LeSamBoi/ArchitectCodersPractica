package com.example.architectcoderspracticauno.ui.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WizardModel(
    val actor: String,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val patronus: String,
    val wand: WandModel,
)

@Serializable
data class WandModel(
    val core: String,
    val length: Double?,
    val wood: String
)