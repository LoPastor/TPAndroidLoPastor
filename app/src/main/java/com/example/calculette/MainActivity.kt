package com.example.calculette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.resultat)
    }

    fun doDelete(): String{
        val res = result.text.toString().dropLast(1)
        val fin: String = res.toString()
        return fin
    }

    fun doMaths(): String{
        var mot = result.text.toString()
        var somme: String = "0"
        var chiffr: String = "0"
        var addit: String = "0"
        var tot: Long = 0
        var continuer = true
        var tail =mot.length
        var limite = 0
        for (i in 1..tail){
            when (mot[i-1].toString()){

                "+"->{var j=i
                    for (j in i..tail-1){
                        if (mot[j].toString()!="+" && mot[j].toString()!="-" && mot[j].toString()!="*"&& mot[j].toString()!="/" && continuer == true){
                            chiffr+=mot[j]}
                        else{
                            if (continuer == true) {
                                continuer = false
                                limite = j
                            }
                        }

                    }

                    //tot = tot + doPlus(somme, chiffr)
                    tot = tot + doPlus(addit, chiffr)
                    somme = tot.toString()
                    chiffr="0"
                    addit="0"
                    // pour enlever les char déjà utilisé, mais cela ne marche pas
                    /*
                    if (continuer == false) {
                        mot = mot.substring(limite, tail )
                        tail = mot.length
                        i=1
                    }

                     */
                    continuer = true
                }
                "-"-> {var j=i
                    for (j in i..tail-1){
                        if (mot[j].toString()!="+" && mot[j].toString()!="-" && mot[j].toString()!="*"&& mot[j].toString()!="/" && continuer == true){
                            chiffr+=mot[j]}
                        else{
                            if (continuer == true) {
                                continuer = false
                                limite = j
                            }
                        }

                    }

                    //tot = tot + doPlus(somme, chiffr)
                    tot = tot + doMoins(addit, chiffr)
                    somme = tot.toString()
                    chiffr="0"
                    addit="0"

                }
                "*"->{var j=i
                    for (j in i..tail-1){
                        if (mot[j].toString()!="+" && mot[j].toString()!="-" && mot[j].toString()!="*"&& mot[j].toString()!="/" && continuer == true){
                            chiffr+=mot[j]}
                        else{
                            if (continuer == true) {
                                continuer = false
                                limite = j
                            }
                        }

                    }

                    //tot = tot + doPlus(somme, chiffr)
                    tot = tot + doMulti(addit, chiffr)
                    somme = tot.toString()
                    chiffr="0"
                    addit="0"

                }
                "/"->{var j=i
                    for (j in i..tail-1){
                        if (mot[j].toString()!="+" && mot[j].toString()!="-" && mot[j].toString()!="*"&& mot[j].toString()!="/" && continuer == true){
                            chiffr+=mot[j]}
                        else{
                            if (continuer == true) {
                                continuer = false
                                limite = j
                            }
                        }

                    }

                    //tot = tot + doPlus(somme, chiffr)
                    tot = tot + doDivis(addit, chiffr)
                    somme = tot.toString()
                    chiffr="0"
                    addit="0"

                }
                //else-> somme+=mot[i-1]
                else-> addit+=mot[i-1]
            }
        }
        //somme = somme.toString().dropLast(1)
        return somme
    }
    fun doPlus (addit1:String, addit2: String): Long{
        val total = (addit1.toLong()) + (addit2.toLong())
        return total
    }
    fun doMoins(addit1:String, addit2: String): Long{
        val total = addit1.toLong() - addit2.toLong()
        return total
    }
    fun doMulti(addit1:String, addit2: String): Long{
        val total = addit1.toLong() * addit2.toLong()
        return total
    }
    fun doDivis(addit1:String, addit2: String): Long{
        val total = addit1.toLong() / addit2.toLong()
        return total
    }



    fun onClick(view: View) {
        val c = view as? Button ?: return run {
            Toast.makeText(
                view.context,
                "Vous n'avez pas sélectionné de bouton !",
                Toast.LENGTH_LONG
            ).show()
        }
        var nb : ArrayList<String> = ArrayList()
        var op : ArrayList<String> = ArrayList()
        // var valeur :String? = result.text.toString()
        // si c'est un bouton ça continue, sinon on arrête l'exécution

        // if (view is Button){
        /* Toast.makeText(view.context, "Vous n'avez pas sélectionné de bouton !", Toast.LENGTH_LONG)
             .show()*/

        if (result.text == "Ici s'affichera le résultat"){
            result.text=c.text
        }
        else {
            when (c.text){
                "D"-> result.text = doDelete()
                "C"->result.text = ""
                // "X"->Toast.makeText(view.context, result.text.toString().toInt(), Toast.LENGTH_LONG).show()
                "="-> result.text = doMaths()
                /*"+"->{ op.add("+")
                result.append(c.text)}
                "-"-> {op.add("-")
                result.append(c.text)}
                "*"-> {op.add("*")
                 result.append(c.text)}
                "/"-> {op.add("/")
             result.append(c.text)}*/
                else ->result.append(c.text)
            }
        }
    }

}


