package ca.gbc.comp3074_assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            calculatePay()
        }
        val btnAbout = findViewById<Button>(R.id.btnAbout)

        btnAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }


    private fun calculatePay() {
        val etHours = findViewById<EditText>(R.id.etHours)
        val etHourlyRate = findViewById<EditText>(R.id.etHourlyRate)
        val etTaxRate = findViewById<EditText>(R.id.etTaxRate)

        val tvPay = findViewById<TextView>(R.id.tvPay)
        val tvOvertime = findViewById<TextView>(R.id.tvOvertime)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val tvTax = findViewById<TextView>(R.id.tvTax)

        val hours = etHours.text.toString().toDoubleOrNull()
        val hourlyRate = etHourlyRate.text.toString().toDoubleOrNull()
        val taxRate = etTaxRate.text.toString().toDoubleOrNull()

        if (hours == null || hourlyRate == null || taxRate == null ||
            !hours.isFinite() || !hourlyRate.isFinite() || !taxRate.isFinite() ||
            hours < 0 || hourlyRate < 0 || taxRate < 0 || taxRate > 1
        ) {

            Toast.makeText(
                this,
                "Enter valid values (tax rate between 0 and 1)",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val pay: Double
        val overtimePay: Double

        if (hours <= 40) {
            pay = hours * hourlyRate
            overtimePay = 0.0
        } else {
            pay = 40 * hourlyRate
            overtimePay = (hours - 40) * (hourlyRate * 1.5)
        }

        val totalPay = pay + overtimePay
        val tax = pay * taxRate

        tvPay.text = "Pay: $%.2f".format(pay)
        tvOvertime.text = "Overtime Pay: $%.2f".format(overtimePay)
        tvTotal.text = "Total Pay: $%.2f".format(totalPay)
        tvTax.text = "Tax: $%.2f".format(tax)

    }
}