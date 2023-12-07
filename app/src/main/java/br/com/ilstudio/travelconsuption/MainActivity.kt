package br.com.ilstudio.travelconsuption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.ilstudio.travelconsuption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button){
            calculate()
        }
    }

    private fun validateValues(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editGasoline.text.toString() != ""
                && binding.editAutonomy.text.toString() != "")
    }

    private fun isNotZero(): Boolean {
        return (binding.editAutonomy.text.toString().toFloat() == 0f).not()
    }

    private fun calculate() {
        if(validateValues()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val gasolinePrice = binding.editGasoline.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val totalValue = (gasolinePrice * distance)/autonomy

            if(isNotZero()) {
                binding.textValue.text = "R$ ${"%.2f".format(totalValue)}"
            } else {
                Toast.makeText(this, "Adicione um valor diferente de zero", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Preencha os campos", Toast.LENGTH_LONG).show()
        }
    }
}