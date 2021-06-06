package org.Chat

import org.junit.Assert.*

class ChatServiceTest {

    @org.junit.Test
    fun add() {
        val c = ChatService()
        c.add(Chat(userName = "Pavel"), Message(idUser = 1, messageUser = "List"))
        val result = println(c.chats.toList())
        assertEquals("[Chat(idUser=1, userName=Pavel, messages=[Message(idMessage=1, idUser=1, messageUser=List, readMessage=false, idOwner=0)])]", result)
    }

    @org.junit.Test
    fun deleteChat() {
    }

    @org.junit.Test
    fun listUnreadChat() {
    }

    @org.junit.Test
    fun getChat() {
    }
}