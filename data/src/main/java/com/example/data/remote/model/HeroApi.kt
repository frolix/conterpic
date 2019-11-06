package com.example.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class HeroApi(
    val id: Int,
    val name: String,
    val localized_name: String,
    val primary_attr: String,
    val attack_type: String,
    val roles: List<String>
)
