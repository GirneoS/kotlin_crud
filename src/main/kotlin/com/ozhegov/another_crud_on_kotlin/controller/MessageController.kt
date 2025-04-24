package com.ozhegov.another_crud_on_kotlin.controller

import com.ozhegov.another_crud_on_kotlin.model.Message
import com.ozhegov.another_crud_on_kotlin.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class MessageController(private val service: MessageService) {

    @GetMapping("/messages")
    fun getAll() = ResponseEntity.ok(service.findMessages())

    @PostMapping("/message")
    fun save(@RequestBody message: Message): ResponseEntity<Message> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @GetMapping("/message/{id}")
    fun getMessageById(@PathVariable id: String): ResponseEntity<Message> {
        return service.findMessageById(id).toResponseEntity()
    }

    private fun Message?.toResponseEntity() = this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}