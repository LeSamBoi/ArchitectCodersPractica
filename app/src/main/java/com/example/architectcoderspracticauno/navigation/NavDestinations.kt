package com.example.architectcoderspracticauno.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Detail(val wizardId: String)