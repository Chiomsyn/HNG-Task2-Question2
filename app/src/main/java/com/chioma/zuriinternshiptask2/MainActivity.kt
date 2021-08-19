package com.chioma.zuriinternshiptask2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     @SuppressLint("SetTextI18n")
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         onBtnClick()

         onLinkClick()

     }

    private fun onLinkClick() {
        link.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://zuri.team"))
            startActivity(intent)
        }
    }

    private fun onBtnClick() {
        clickMeBtn.setOnClickListener {

            hideSoftKeyboard()

            if (enterTxt.text.toString().isNullOrEmpty()) {

                Toast.makeText(this, "Please Enter Any Text", Toast.LENGTH_SHORT).show()
            } else {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Hello the Text you typed is: ")
                builder.setMessage(enterTxt.text.toString())

                builder.setNegativeButton("CLOSE") { dialogInterface: DialogInterface, _: Int ->
                    dialogInterface.cancel()
                }

                builder.show()

            }
        }
    }

    private fun hideSoftKeyboard() {
        val inputMethodManager: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

}