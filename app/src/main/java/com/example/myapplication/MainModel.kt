package com.example.myapplication

data class MainModel(
    val title: String,
    val subModels: MutableList<SubModel>,
    var isExpanded: Boolean = false
)