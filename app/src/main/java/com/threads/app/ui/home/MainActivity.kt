package com.threads.app.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.threads.app.R
import com.threads.app.utils.Utils

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home" // Set the title of the Toolbar

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val posts = Utils().generateDummyPosts()
        postAdapter = PostAdapter(posts) { post ->
//            val intent = Intent(this, Details::class.java).apply {
//                putExtra("post", post)
//            }
//            startActivity(intent)
        }

        recyclerView.adapter = postAdapter
        recyclerView.addItemDecoration(ItemSpacingDecoration(horizontal = 4, vertical = 16))
        recyclerView.setPadding(0, 0, 0, 80)
        recyclerView.clipToPadding = false // Ensure that padding is applied correctly
    }
}