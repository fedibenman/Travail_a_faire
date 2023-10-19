package com.example.travail_a_faire

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : ComponentActivity() {
    lateinit var nom :EditText
    lateinit var email: EditText
    lateinit var clas: EditText
    lateinit var  date_naissance:EditText
    lateinit var  btn : TextView
    lateinit var classe:EditText
    lateinit var mylayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nom = findViewById(R.id.nom)
        email=findViewById(R.id.email)
        date_naissance =findViewById(R.id.date)
        btn = findViewById(R.id.btn)
        classe = findViewById(R.id.classe);
        mylayout = findViewById(R.id.mylayout)

    btn.setOnClickListener {
        val nomePrenom: String = nom.getText().toString()
        val dateNaissance:String = date_naissance.getText().toString()
        val Email: String = email.getText().toString()
        val className: String = classe.getText().toString()
     if (nomePrenom.isBlank()){
         Toast.makeText(this,"nom et prenom vide" ,Toast.LENGTH_LONG).show() ;
     }
        if (Email.isBlank()){
            val mySnackbar = Snackbar.make(mylayout, "Email vide", Snackbar.LENGTH_INDEFINITE)
            mySnackbar.setAction("Close") {
                mySnackbar.dismiss()
            }
            mySnackbar.show()  }
        if(dateNaissance.isBlank()){
            val mySnackbar = Snackbar.make(mylayout, "date vide", Snackbar.LENGTH_INDEFINITE)
            mySnackbar.setAction("Close") {
                mySnackbar.dismiss()
            }
            mySnackbar.show()}
        if (className.isBlank()){
            Toast.makeText(this,"nom et prenom vide" ,Toast.LENGTH_LONG).show() ;
        }
else if(nomePrenom.isNotBlank() && Email.isNotBlank() && className.isNotBlank() && dateNaissance.isNotBlank()) {
    val intent = Intent(this, DisplayInfoActivity::class.java)
    intent.putExtra("NOME_ET_PRENOM", nomePrenom)
    intent.putExtra("EMAIL", Email)
    intent.putExtra("CLASS", className)

    val ad: AlertDialog.Builder
    ad = AlertDialog.Builder(this)
    ad.setMessage("confirm")
    ad.setTitle("Confirm")
    ad.setPositiveButton(
        "yes"
    ){dialogInterface, i -> run {  startActivity(intent)}}
    val a = ad.create()
    a.show()

}
    }
    }


}



