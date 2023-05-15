package com.example.kotlinproject_3.dto

import lombok.Data

@Data
data class PostRequest(
    var title: String = "",
    var content: String = ""
)
