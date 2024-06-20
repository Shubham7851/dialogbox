package com.vns.dialogbox
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        buttonReset = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {
            showAlertDialog()
        }

        buttonReset.setOnClickListener {
            editTextNumber.setText("0")
        }
    }

    private fun showAlertDialog() {
        val numberEntered = editTextNumber.text.toString().toIntOrNull()
        if (numberEntered != null) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Choose an operation")
                .setItems(arrayOf("Add $numberEntered", "Subtract $numberEntered")) { _, which ->
                    when (which) {
                        0 -> {
                            val result = numberEntered + numberEntered
                            editTextNumber.setText(result.toString())
                        }
                        1 -> {
                            val result = numberEntered - numberEntered
                            editTextNumber.setText(result.toString())
                        }
                    }
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
            builder.create().show()
        }
    }
}
