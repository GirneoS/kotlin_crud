package com.ozhegov.another_crud_on_kotlin.repository

import com.ozhegov.another_crud_on_kotlin.model.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository: CrudRepository<Message, String>