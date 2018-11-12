package com.gainwise.mockdbapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helper = DBHelperShippedIn(this)
        val db = helper.readableDatabase

        val cursor = db.rawQuery("select * from MOCK_DATA", null)
        cursor.moveToFirst()
        val count = cursor.columnCount
        do{
            for (i in 0 until count){
                textView1.append(cursor.getColumnName(i))
                textView1.append("\n")
                textView1.append(cursor.getString(i))
                textView1.append("\n\n")
            }

        }while(cursor.moveToNext())


    }



}
