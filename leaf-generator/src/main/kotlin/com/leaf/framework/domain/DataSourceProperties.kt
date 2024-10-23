package com.leaf.framework.domain

import java.io.FileReader
import java.nio.file.Paths

data class DataSourceProperties(
    var url: String,
    var username: String,
    var password: String,
) {
    init {
        val file = Paths.get("leaf-generator/src/main/resources/database.properties").toFile()
        val fileReader = FileReader(file)
        fileReader.use {
            val lines = fileReader.readLines()
            lines.forEach {
                val lineArr = it.split("=")
                when (lineArr[0]) {
                    "url" -> this.url = lineArr[1]
                    "username" -> this.username = lineArr[1]
                    "password" -> this.password = lineArr[1]
                }
            }
        }
    }

    constructor() : this("", "", "")
}
