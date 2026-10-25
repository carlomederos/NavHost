package com.carlo_mederos.nav.navigation

import kotlinx.serialization.Serializable

/**
 * Rutas disponibles en la app.
 * Agrega aquí las nuevas pantallas como objetos o clases serializables.
 */
@Serializable
data object HomeRoute

@Serializable
data class ProfileRoute(
    val userId: String,
    val userName: String
)
