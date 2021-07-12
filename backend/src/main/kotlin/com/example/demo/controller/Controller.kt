package com.example.demo.controller

import com.example.demo.Exception.ResponseErrorhandler
import com.example.demo.entity.Store
import com.example.demo.entity.StoreSeasonRel
import com.example.demo.repository.StoreRepository
import com.example.demo.service.StoreService
import com.google.gson.Gson
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import java.io.StringReader
import java.util.*

@RestController
@CrossOrigin(origins = arrayOf("http://localhost:8080"))
public class Controller(
    private val service: StoreService,
    private val repository: StoreRepository,
    private val restTemplate: RestTemplate,

) {
    public  final var key="apiKey"
    public  final var value="nxzAAC1EQAAU7AGY8gUQnev_99A"

    @GetMapping("/v1/stores")
    fun getAllStores(): List<Store> {
        var url = "http://134.209.29.209/v1/stores/?page=1"
        var headers: HttpHeaders = HttpHeaders();
        headers.add(key, value)
        headers.set("accept", "application/json")
        val request: HttpEntity<List<Store>> = HttpEntity<List<Store>>(headers)
        val response: ResponseEntity<String> =
            restTemplate.exchange(url, HttpMethod.GET, request)
        val body = response.body
        val gson = Gson()
        val storeList: List<Store> = gson.fromJson(StringReader(body), Array<Store>::class.java).toList()
        println(body)
        if (body != null) {
            return service.getAllStores(storeList)
        } else {
            throw ResponseErrorhandler("Unable to fetch the Stores Details ")
        }
    }

    @GetMapping("/other/stores_and_seasons")
    fun getAllStoresAndSeasons(): List<StoreSeasonRel> {
        var url = "http://134.209.29.209/other/stores_and_seasons/"
        var headers: HttpHeaders = HttpHeaders();
        headers.add(key, value)
        headers.set("accept", "application/json")
        val request: HttpEntity<List<StoreSeasonRel>> = HttpEntity<List<StoreSeasonRel>>(headers)
        val response: ResponseEntity<String> =
            restTemplate.exchange(url, HttpMethod.GET, request)
        val body = response.body
        val gson = Gson()
        val storeList: List<StoreSeasonRel> =
            gson.fromJson(StringReader(body), Array<StoreSeasonRel>::class.java).toList()
        println(body)
        if (body != null) {
            return service.getAllStoresAndSession(storeList)
        } else {
            throw ResponseErrorhandler("Unable to fetch the Stores and Seasons Details ")
        }
    }


    @GetMapping("/getStore/{id}")
    fun getStoreById(@PathVariable("id") Id: Long): Optional<Store> {
        try {
            return repository.findById(Id)
        } catch (e: Exception) {
            throw ResponseErrorhandler("Unable to fetch Store details with given Id")
        }
    }

    @PutMapping("/updateStore/{id}")
    fun updateStoreById1(@PathVariable("id") Id: Long, @RequestBody store: Store): ResponseEntity<Store> {
        return repository.findById(Id).map { existingUser ->
            val updatedUser: Store = existingUser
                .copy(
                    code = store.code,
                    description = store.description,
                    name = store.name,
                    openingDate = store.openingDate,
                    storeType = store.storeType
                )
            ResponseEntity.ok().body(repository.save(updatedUser))
        }.orElse(ResponseEntity.notFound().build())
    }
}




