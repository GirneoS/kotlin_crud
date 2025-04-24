package com.ozhegov.another_crud_on_kotlin.service

import com.ozhegov.another_crud_on_kotlin.model.Message
import com.ozhegov.another_crud_on_kotlin.repository.MessageRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(private val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()
    fun save(message: Message): Message = db.save(message)
    fun findMessageById(id: String): Message? = db.findByIdOrNull(id)
}