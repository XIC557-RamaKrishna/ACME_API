package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name="StoreSeasonRel")
public data class StoreSeasonRel(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val storeId: Int=0,
    val season: String=""

)

