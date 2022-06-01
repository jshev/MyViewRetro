package com.example.myviewretro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var postButton = findViewById<Button>(R.id.postButton)
        postButton.setOnClickListener() {
            var editIsbn = findViewById<EditText>(R.id.editIsbn)
            var editTitle = findViewById<EditText>(R.id.editTitle)
            var editSubtitle = findViewById<EditText>(R.id.editSubtitle)
            var editAuthor = findViewById<EditText>(R.id.editAuthor)
            var editPublished = findViewById<EditText>(R.id.editPublished)
            var editPublisher = findViewById<EditText>(R.id.editPublisher)
            var editPages = findViewById<EditText>(R.id.editPages)
            var editDescription = findViewById<EditText>(R.id.editDescription)
            var editWebsite = findViewById<EditText>(R.id.editWebsite)

            var isbn:String = editIsbn.text.toString()
            var title:String = editTitle.text.toString()
            var subtitle:String = editSubtitle.text.toString()
            var author:String = editAuthor.text.toString()
            var published:String = editPublished.text.toString()
            var publisher:String = editPublisher.text.toString()
            var pages:Int = editPages.text.toString().toInt()
            var description:String = editDescription.text.toString()
            var website:String = editWebsite.text.toString()

            var myObj:JSONObject = returnObject(isbn, title, subtitle,
            author, published, publisher, pages, description, website)
            var myStr:String = myObj.toString()

            println(myStr)
        }
    }

    fun returnObject(isbn: String,
                     title: String,
                     subtitle: String,
                     author: String,
                     published: String,
                     publisher: String,
                     pages: Int,
                     description: String,
                     website: String): JSONObject {
        var jsonObj: JSONObject = JSONObject()
        jsonObj.put("isbn", isbn)
        jsonObj.put("title", title)
        jsonObj.put("subtitle", subtitle)
        jsonObj.put("author", author)
        jsonObj.put("published", published)
        jsonObj.put("publisher", publisher)
        jsonObj.put("pages", pages)
        jsonObj.put("description", description)
        jsonObj.put("website", website)
        return jsonObj
    }
}