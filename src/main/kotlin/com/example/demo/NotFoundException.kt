package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * TODO include class javadoc here
 * @author JB Nizet
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException: RuntimeException("Phone Not found")
