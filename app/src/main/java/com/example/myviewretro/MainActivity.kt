package com.example.myviewretro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    // Retrofit is a type-safe HTTP client for kotlin and Android
    // First steps..
    // 1. Add dependencies in Gradle
    // 2. Add permission to access the internet in Manifest
    // 3. Create retrofit instance
    // 4. Create retrofit interface
    // 5. Consume Rest API endpoints (response --> success, error)
    // 6. Process and attach it to recyclerview

    lateinit var vm: BookViewModel
    var bookList: List<Books> = listOf<Books>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var adapter = BookAdapter(bookList)
        recyclerView.adapter = adapter

        val inter = RetroApiInterface.create()
        val repo = BookRepository(inter)
        vm = BookViewModel(repo)

        vm.getAllBooks()

        vm.bookList.observe(this) {
            //bookList -> bookList
            adapter.setItems(it)
            //println(it)
        }

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener() {
            var intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        /*val api = RetroApiInterface.create().getAllBooks()

        api.enqueue(object: Callback<List<Books>>{
            override fun onResponse(call: Call<List<Books>>, response: Response<List<Books>>) {
                println(response.body())
                bookList = response.body()!!
                //adapter.notifyDataSetChanged()
                adapter = BookAdapter(bookList)
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Books>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })*/
    }

    /*fun getBooks(studentList: List<Books>) {
        this.bookList.clear()
        this.bookList.addAll(studentList)
        adapter.notifyDataSetChanged()
    }*/
}