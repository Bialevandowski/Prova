package br.unipar.prova

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

class AgendaAdapter {

    private val context: Context,
    private val AplicativodeViagens: MutableList<AgendaAdapter>
    ) : ArrayAdapter<Agenda>(context, 0, AplicativodeViagens)




    //Pega os campos do layout escolhido
    val descricao = view.findViewById<TextView>(R.id.txtDescricao)
    val data = view.findViewById<TextView>(R.id.txtData)
    val concluido = view.findViewById<CheckBox>(R.id.cbTarefaConcluida)


    //Joga o valor da tarefa para o campo da tela
    descricao.setText(agenda.descricao)
    data.setText(agenda.data)
    concluido.isChecked = agenda.concluida


    concluido.setOnCheckedChangeListener { _, isChecked ->
        agenda.concluida = isChecked
    }


    return view
}
}


