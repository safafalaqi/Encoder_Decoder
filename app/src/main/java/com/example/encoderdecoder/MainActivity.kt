package com.example.encoderdecoder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var myRv: RecyclerView
    private lateinit var rvAdapter: RVAdapter
    private lateinit var arrayTexts : ArrayList<ArrayList<String>>
    private lateinit var etEncode: EditText
    private lateinit var etDecode:EditText
    private lateinit var btEncode:Button
    private lateinit var btDecode:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRv=findViewById(R.id.rvText)
        arrayTexts= arrayListOf<ArrayList<String>>()

        etEncode= findViewById(R.id.etEncdode)
        etDecode= findViewById(R.id.etDecode)

        btEncode= findViewById(R.id.btEncode)
        btDecode= findViewById(R.id.btDecode)

        btEncode.setOnClickListener{encodeClicked()}
        btDecode.setOnClickListener{decodeClicked()}

        rvAdapter=RVAdapter(arrayTexts)
        myRv.adapter = rvAdapter
        myRv.layoutManager = LinearLayoutManager(applicationContext)


    }

    fun encodeClicked(){
        if(etEncode.text.isEmpty())
        Toast.makeText(this,"Enter a text",Toast.LENGTH_SHORT).show()
        else encode(etEncode.text.toString(),13)
        etEncode.text.clear()
    }
    fun decodeClicked(){

        if(etDecode.text.isEmpty())
            Toast.makeText(this,"Enter a text",Toast.LENGTH_SHORT).show()
        else decode(etDecode.text.toString(),13)
        etDecode.text.clear()
    }
    fun encode(text: String,shift:Int) {

            val offset = shift % 26
            if (offset == 0)
            {
                arrayTexts.add(arrayListOf(text,text))
            }
            var letter: Char
            val chars = CharArray(text.length)
            for ((index, c) in text.withIndex()) {
                if (c in 'A'..'Z') {
                    letter = c + offset
                    if (letter > 'Z') letter -= 26
                }
                else if (c in 'a'..'z') {
                    letter = c + offset
                    if (letter > 'z') letter -= 26
                }
                else
                    letter = c
                chars[index] = letter
            }
        arrayTexts.add(arrayListOf(text,chars.joinToString("")))

        }
    
    fun decode(text: String,shift: Int)
    {
       encode(text, 26 - shift)
    }
}