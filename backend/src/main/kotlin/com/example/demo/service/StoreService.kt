package com.example.demo.service

import com.example.demo.Exception.ResponseErrorhandler
import com.example.demo.entity.Store
import com.example.demo.entity.StoreSeasonRel
import com.example.demo.repository.StoreRepository
import com.example.demo.repository.StoreSessionRespository
import org.springframework.stereotype.Service

@Service
class StoreService(
    private val repository: StoreRepository,
    private val storeSessionrepository: StoreSessionRespository
) {

    fun getAllStores(data: List<Store>): List<Store> {
        repository.saveAll(data)
        return data
    }

    fun getAllStoresAndSession(data: List<StoreSeasonRel>): List<StoreSeasonRel> {
        storeSessionrepository.saveAll(data)
        return data
    }

}