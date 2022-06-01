package com.example.myviewretro

class BookRepository(val inter : RetroApiInterface) {
    suspend fun getAllBooks() = inter.getAllBooks()
}