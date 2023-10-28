package com.example.travail_a_faire

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar


class MainActivity : ComponentActivity() ,AdapterView.OnItemSelectedListener {
    lateinit var nom :EditText
    lateinit var email: EditText
    lateinit var clas: EditText
    lateinit var  date_naissance:EditText
    lateinit var  btn : TextView
    lateinit var classe:Spinner
    lateinit var mylayout:LinearLayout
    lateinit var dateString: String
    private val dateNaissance = Calendar.getInstance()
    lateinit var inputLayouNom:TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nom = findViewById(R.id.nom)
        email=findViewById(R.id.email)
        date_naissance =findViewById(R.id.date_naissance)
        btn = findViewById(R.id.btn)
        classe = findViewById(R.id.classe);
        mylayout = findViewById(R.id.mylayout)
        inputLayouNom = findViewById(R.id.input_layout_nom)



        var arrayAdapter=ArrayAdapter.createFromResource(
            this,
            R.array.classe,
            android.R.layout.simple_spinner_dropdown_item) //use R.layout.customspinner for customising
        classe.adapter = arrayAdapter
        classe.onItemSelectedListener=this
        date_naissance.setOnClickListener {
            showDatePickerDialog()
        }

    btn.setOnClickListener {
        val nomePrenom: String = nom.getText().toString()
        val Email: String = email.getText().toString()
        val className: String = classe.selectedItem.toString()
     if (nomePrenom.isBlank()){
         inputLayouNom.error = "nom et prenom vide" ;
     }
        if (Email.isBlank()){
            val mySnackbar = Snackbar.make(mylayout, "Email vide", Snackbar.LENGTH_INDEFINITE)
            mySnackbar.setAction("Close") {
                mySnackbar.dismiss()
            }
            mySnackbar.show()  }

        if (className.isBlank()){
            Toast.makeText(this,"nom et prenom vide" ,Toast.LENGTH_LONG).show() ;
        }
else if(nomePrenom.isNotBlank() && Email.isNotBlank() && className.isNotBlank()) {
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


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    private fun showDatePickerDialog() {
        val year = dateNaissance.get(Calendar.YEAR)
        val month = dateNaissance.get(Calendar.MONTH)
        val day = dateNaissance.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _,year,month, day ->

                 dateString= "$year-$month-$day"

            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
}






