package com.james54.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.item_note.view.*

class addNoteActivity : AppCompatActivity() {
    lateinit var viewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
    }

    fun submitNote(view: View) {
        val text:String = input.editableText.toString()
        if(text.isNotEmpty()){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("text",text)
            Log.d("foram", "submitNote: $text")
            viewModel.insertNote(Note(text))
            finish()
        }
    }
}