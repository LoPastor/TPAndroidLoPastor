package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ArticleAdapter
import com.example.myapplication.adapter.ArticlesFragment
import com.example.myapplication.network.ArticleService


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //créer une instance du fragment
        val fragment = ArticlesFragment ()
        //créer un transaction sur le fragment manager
        supportFragmentManager.beginTransaction().apply {
            //replacer le précédent fragment, s'il existe
            replace(R.id.fragment_container, fragment)
            //ajouter la transaction dans la stack
            addToBackStack(null)
        }.commit()
        //finalement, on valide la transaction
    }
        }


