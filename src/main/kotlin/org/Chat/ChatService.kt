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
                for ((chatIndex, chat) in chats.withIndex()) {
                    for ((chatMessageIndex, chatMessage) in chat.messages.withIndex()) {
                        if (chat.messages[chatMessageIndex].idUser == idU && chat.messages[chatMessageIndex].idMessage == id) {
                            chat.messages.removeAt(chatMessageIndex)
                            break
                        }
                    }
                }
                return ("Chat with this ID deleted")
            }
        }
        return ("Chat with the given ID was not found")
    }

    fun edit(id: Int, idU: Int, messageEdit: String): String {
        for ((chatIndex, chat) in chats.withIndex()) {
            for ((chatMessageIndex, chatMessage) in chat.messages.withIndex()) {
                if (chat.messages[chatMessageIndex].idUser == idU && chat.messages[chatMessageIndex].idMessage == id) {
                    val chatNew = chat.copy()
                    chat.messages[chatMessageIndex].messageUser = messageEdit
                    return ("Message with this ID edited")
                    break
                }
            }
        }
        return ("Message with the given ID was not found")
    }

    fun listUnreadChat(): Int {
        var unreadMessage: Int = 0
        for ((chatIndex, chat) in chats.withIndex()) {
            for ((chatMessageIndex, chatMessage) in chat.messages.withIndex()) {
                if (chat.messages[chatMessageIndex].readMessage == false) {
                    unreadMessage += 1
                    break
                }
            }
        }
        return unreadMessage
    }

    fun getChat(): MutableList<Chat> {
        val listChat: MutableList<Chat> = arrayListOf()
        for ((index, chat) in chats.withIndex()) {
            if (!chats[index].messages.isEmpty()) listChat.add(chat)
        }
        if (listChat.isEmpty()) println("You do not have a messages!")
        else return listChat
        return listChat
    }
}
