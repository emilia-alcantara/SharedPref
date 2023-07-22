package cl.individual.viernes21072

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.individual.viernes21072.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var saveSharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saveSharedPref = getSharedPreferences("Ejercicio18", Context.MODE_PRIVATE)
        initListeners()

    }

    private fun initListeners() {
        binding.btnGuardar.setOnClickListener{
            val textoIngresado = binding.editTextoIngresado.text.toString()
            val enteroIngresado = binding.editNumEntero.text.toString().toInt()
            val decimalIngresado = binding.editNumDecimal.text.toString().toFloat()
            val switch = binding.switch1.isChecked

            guardarDatos(textoIngresado, enteroIngresado, decimalIngresado, switch)

        }

        binding.btnMostrar.setOnClickListener{
            mostrarDatos()
        }

        binding.btnBorrar.setOnClickListener{
            borrarDatos()
        }
    }

    private fun borrarDatos() {
        binding.txtValorEntero.text = ""
        binding.txtTextoIngresado.text = ""
        binding.txtDecimalIngresado.text = ""
        binding.txtSwitch.text = ""

        binding.editNumEntero.text?.clear()
        binding.editTextoIngresado.text?.clear()
        binding.editNumDecimal.text?.clear()
        binding.switch1.isChecked = false

        saveSharedPref.edit().clear()
    }

    private fun guardarDatos(texto: String, entero: Int, decimal: Float, switchValue : Boolean ) {
        saveSharedPref.edit().putString("texto ingresado", texto).apply()
        saveSharedPref.edit().putInt("entero ingresado", entero).apply()
        saveSharedPref.edit().putFloat("decimal ingresado", decimal).apply()
        saveSharedPref.edit().putBoolean("valor switch", switchValue).apply()

        Toast.makeText(this, "Datos guardados exitosamente", Toast.LENGTH_LONG).show()
    }

    private fun mostrarDatos() {
        val texto = saveSharedPref.getString("texto ingresado", "")
        val entero = saveSharedPref.getInt("entero ingresado", 0)
        val decimal = saveSharedPref.getFloat("decimal ingresado", 0.0F)
        val switch = saveSharedPref.getBoolean("valor switch", false)

        binding.txtTextoIngresado.text = "El texto guardado es: $texto"
        binding.txtDecimalIngresado.text = "El decimal guardado es: ${decimal.toString()}"
        binding.txtValorEntero.text = "El número entero guardado es:  ${entero.toString()}"
        binding.txtSwitch.text = "El estado del switch: ${switch.toString()}"

    }




}