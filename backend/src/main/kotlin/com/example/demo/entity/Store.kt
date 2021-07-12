package com.example.demo.entity

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.*

@Entity(name="store")

public data class Store (
    @Id
    var id : Long=0 ,
    val code: String="",
    @Column(columnDefinition = "TEXT")
    @Lob
    val description: String="",
    val name: String="",
    val openingDate:  Date = Date(),
    val storeType: String="",
)