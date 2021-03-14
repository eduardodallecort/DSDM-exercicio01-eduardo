package br.edu.unisep.exercicio01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.unisep.exercicio01.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            binding.btnCalcular.setOnClickListener { calculate() }
            binding.btnLimpar.setOnClickListener { restart() }
        }

    }

    private fun calculate() {

        var kmAnterior = binding.etkmAnterior.text.toString().toDouble()
        var kmAtual = binding.etKmAtual.text.toString().toDouble()
        var qtdeAbastecida = binding.etQtdeAbastecida.text.toString().toDouble()

        var media = (kmAtual - kmAnterior) / (50 - qtdeAbastecida)

        val formatter = DecimalFormat("0#.0")
        binding.tvResultadoKm.text = formatter.format(media)

    }

    private fun restart() {

        binding.tvResultadoKm.setText("00.0")
        binding.etKmAtual.setText("")
        binding.etkmAnterior.setText("")
        binding.etQtdeAbastecida.setText("")


    }

}