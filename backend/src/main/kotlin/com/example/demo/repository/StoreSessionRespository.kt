package com.example.demo.repository

import com.example.demo.entity.Store
import com.example.demo.entity.StoreSeasonRel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreSessionRespository: JpaRepository<StoreSeasonRel, Long>