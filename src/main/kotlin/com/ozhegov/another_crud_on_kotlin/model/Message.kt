package com.ozhegov.another_crud_on_kotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("messages")
data class Message(val text: String, @Id val id: String?)