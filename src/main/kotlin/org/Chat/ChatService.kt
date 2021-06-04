package org.Chat


class ChatService {

    var chats: MutableList<Chat> = mutableListOf()
    var messages: MutableList<Message> = mutableListOf()

    fun add(chat: Chat, message: Message) {
        if (chats.isEmpty()) {
            val chatNew = chat.copy(idUser = 1)
            val messageNew = message.copy(idMessage = 1)
            messages.plusAssign(messageNew)
            chat.messages.plusAssign(messages.last())
            chats.plusAssign(chatNew)
        } else {
            var id: Int = 0
            for ((index, chat) in chats.withIndex()) {
                if (chats[index].idUser == message.idUser) {
                    id = message.idUser
                    print("idUser ")
                    println(id)
                    break
                }
            }
            when {
                id == message.idUser -> {
                    println(message)
                    val messageNew = message.copy(idMessage = messages.last().idMessage + 1)
                    println(messageNew)
                    messages.plusAssign(messageNew)
                    chats[id - 1].messages.plusAssign(messages.last())
                }
                id != message.idUser -> {
                    val chatNew = chat.copy(idUser = chats.last().idUser + 1)
                    val messageNew = message.copy(idMessage = 1)
                    messages.plusAssign(messageNew)
                    chat.messages.plusAssign(messageNew)
                    chats.plusAssign(chatNew)
                }
            }
        }
    }

    fun deleteChat(id: Int): String {
        for ((index, chat) in chats.withIndex()) {
            if (chats[index].idUser == id) {
                chats.removeAt(index)
                return "Chat with this ID deleted"
            }
        }
        return "Chat with the given ID was not found"
    }

    fun deleteMessage(id: Int, idU: Int): String {
        for ((index, message) in messages.withIndex()) {
            if (messages[index].idUser == idU && messages[index].idMessage == id) {
                messages.removeAt(index)
                println(messages[index].idMessage)
                return ("Chat with this ID deleted")
            }
        }
        return ("Chat with the given ID was not found")
    }
}
