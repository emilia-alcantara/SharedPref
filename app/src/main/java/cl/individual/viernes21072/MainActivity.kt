package cl.individual.viernes21072

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.individual.viernes21072.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.btnGuardar.setOnClickListener{
            val textoIngresado = binding.editTextoIngresado.text.toString()
            val enteroIngresado = binding.editNumEntero.text.toString().toInt()
            val decimalIngresado = binding.editNumDecimal.text.toString().toDouble()
            val switch = binding.switch1.isChecked
        }
    }
}