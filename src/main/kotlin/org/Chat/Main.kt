package org.Chat


fun main() {

    val test = ChatService()
    test.add(Chat(userName = "Pavel"), Message(idUser = 1, messageUser = "Проверка 222"))
    test.add(Chat(userName = "Сергей"), Message(idUser = 2, messageUser = "Проверка 2221111"))
    test.add(Chat(userName = "Сергей"), Message(idUser = 1, messageUser = "Efe"))
    test.add(Chat(userName = "Yura"), Message(idUser = 3, messageUser = "Проверка у Юры"))
    test.add(Chat(userName = "11"), Message(idUser = 2, messageUser = "Проверка Прошла"))
    println(test.chats.toList())
   // test.deleteChat(2)
    println(test.chats.toList())
    println("________Delete message_______________")
    println(test.deleteMessage(1, 2))
    println(test.chats.toList())

}