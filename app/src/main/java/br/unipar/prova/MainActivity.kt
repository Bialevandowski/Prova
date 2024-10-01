package br.unipar.prova

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listadeViagens = mutableListOf<AgendaAdapter>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edViagem = findViewById<EditText>(R.id.edViagem);
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar);
        val listViewTarefas = findViewById<ListView>(R.id.listViewTarefas);

        //Criando uma ponte e usando o layout do android
        /* adapter = ArrayAdapter(this,
             android.R.layout.simple_list_item_1,listadeTarefas)*/

        val adapter = AgendaAdapter(this,listadeViagens)

        //vinculando o meu adaptar com a minha view
        listViewTarefas.adapter = adapter;
        btnCadastrar.setOnClickListener{

            val descricaoTarefa = edViagem.text.toString();
            val dataAtual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            if (descricaoTarefa.isNotEmpty()){

                val  novaTarefa = AgendaAdapter(descricaoTarefa, dataAtual, false)

                listadeViagens.add(novaTarefa)
                adapter.notifyDataSetChanged()
                Toast.makeText( this,  "Tarefa ${descricaoTarefa}",
                    Toast.LENGTH_LONG).show()

                edViagem.text.clear()

            }
        }

        listViewTarefas.setOnItemLongClickListener{ _,_,position,_ ->
            val removeTarefa  = listadeViagens.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this,"Viagem removida", Toast.LENGTH_LONG).show()
            true
        }

    }
}