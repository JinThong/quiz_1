package edu.singaporetech.sitcoin

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import java.math.BigDecimal

/**
 * Lab Quiz 1
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var password = "yoquierodinero"
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val inputStudentNumber = findViewById<EditText>(R.id.editTextStudentNumber)

        //When user clicks login button, check if student ID is 7 numeric characters
        buttonLogin.setOnClickListener(){
            isStudentNumberValid(inputStudentNumber.text.toString())
        }

    }

    fun isStudentNumberValid (studentNumber: String): Boolean {


        //Check if the entire String is made up of Numeric,return error if try-catch fail
        try {
            parseDouble(studentNumber)
        } catch (e: NumberFormatException) {
            val toast = Toast.makeText(applicationContext, "Invalid Login", Toast.LENGTH_LONG)
            toast.show()
            return false
        }

        //Check if the student ID is made up of exactly 7 numerics
        var num = parseInt(studentNumber)
        var counter = 0
        while (num != 0) {
            num /= 10
            ++counter
        }
        if (counter > 7){
            val toast = Toast.makeText(applicationContext, "Invalid Login", Toast.LENGTH_LONG)
            toast.show()
            return false
        }
        return true
    }


}

