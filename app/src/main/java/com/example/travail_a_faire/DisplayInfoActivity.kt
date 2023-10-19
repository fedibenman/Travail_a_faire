package com.example.travail_a_faire

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity


class DisplayInfoActivity : ComponentActivity() {
lateinit var sharebtn:TextView
    lateinit var EtudiantInfo: TextView
    lateinit var message:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)
        EtudiantInfo = findViewById(R.id.EtudaintInfo)
        sharebtn = findViewById(R.id.sharebtn)
        val intent = intent
        if (intent != null) {
            val nomePrenom = intent.getStringExtra ("NOME_ET_PRENOM");
            val dateNaissance = intent.getStringExtra ("DATE_DE_NAISSANCE");
            val email = intent . getStringExtra ("EMAIL");
            val className = intent.getStringExtra ("CLASS");
             message  ="Etudiant:"+nomePrenom +"-Classe:" +className+"-Email:"+email
EtudiantInfo.setText(message)
        }
        sharebtn.setOnClickListener{
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, message)
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
        }
}