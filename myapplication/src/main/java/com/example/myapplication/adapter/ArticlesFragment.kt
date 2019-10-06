package com.example.myapplication.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.network.repository.ArticlepReository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArticlesFragment : Fragment() {

    private lateinit var root: View
    private val repository = ArticlepReository()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root = view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch {
            getData()
        }
    }
    //S'execute dans un thread secondeaire
    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            bindData(result)
        }
    }
    //S'execute sur le thread principal
    private suspend fun bindData(result: List<ArticleAdapter.Article>) {
        withContext(Dispatchers.Main) {

            var planetes = resources.getStringArray(R.array.planetes)


            //afficherles données dans le recycler
            var spinner: Spinner = root.findViewById(R.id.spinner)
//instancier l'adapteur
            val adapter = ArrayAdapter(root.context, android.R.layout.simple_spinner_item, planetes)
//associer l'adapter au spinner *$
            spinner.adapter = adapter
//Listener quand l'utilisateur selectionne un élément
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    Toast.makeText(root.context, "Vous n'avez rien selectionné", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onItemSelected(
                    adapter: AdapterView<*>?,
                    View: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        root.context,
                        "Vous avez selectionné ${planetes[position]}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            var recyclerView = root.findViewById(R.id.recycler_view) as RecyclerView
            //créer une liste d'articles




//créer une instance de l'adapteur
            var adapterRecycler = ArticleAdapter(result)
//définir l'orientation des élements (vertical)
            recyclerView.layoutManager = LinearLayoutManager(root.context)
//associer l'adapter à la recyclerview
            recyclerView.adapter = adapterRecycler
        }
    }
}


