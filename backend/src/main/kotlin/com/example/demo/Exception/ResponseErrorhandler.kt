package com.example.demo.Exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResponseErrorhandler(message: String) : Exception(message)