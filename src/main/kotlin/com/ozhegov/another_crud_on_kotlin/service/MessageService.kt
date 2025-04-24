package com.ozhegov.another_crud_on_kotlin.service

import com.ozhegov.another_crud_on_kotlin.model.Message
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(private val db: JdbcTemplate) {
    fun findMessages(): List<Message> = db.query("select * from messages") {
        responce, _ -> Message(responce.getString("id"),
           responce.getString("text"))
    }
    fun save(message: Message): Message{
        val id = message.id ?: UUID.randomUUID().toString()
        db.update("insert into messages values(?,?)",
            id, message.text)
        return message.copy(id = id)
    }
    fun findMessageById(id: String): Message? = db.query("select * from messages where id = ?", id) {response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }.singleOrNull()
}