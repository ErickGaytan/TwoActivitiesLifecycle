package com.example.user.twoactivitieslifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.user.twoactivitieslifecycle.MainActivity.Companion.EXTRA_MESSAGE
import kotlinx.android.synthetic.main.activity_second.*//Main2Activity activity_main2

class SecondActivity : AppCompatActivity() {

    private var Reply: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Reply = findViewById<View>(R.id.editText_second) as EditText

        val intent = intent
        var message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)

        val textView = findViewById<View>(R.id.text_message) as TextView

       /* if(savedInstanceState != null)
        {
            val reply = savedInstanceState.getString(EXTRA_REPLY)
            editText_second.setText(reply)
            message = savedInstanceState.getString(EXTRA_MESSAGE)
        }

        text_message.text = message*/

        if(textView != null){
            textView.text = message
        }

        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")

    }

    fun returnReply(view: View) {
        val reply = editText_second!!.text.toString()

        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "End Second Activity")
        finish()
    }

   /*
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            outState.putString(EXTRA_REPLY, editText_second.text.toString())
            outState.putString(EXTRA_MESSAGE, text_message.text.toString())
        }
    }*/

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    public override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    public override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    public override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    public override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    public override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }



    companion object {
        val EXTRA_REPLY = "EXTRA_REPLY"
        private val LOG_TAG = SecondActivity::class.java.simpleName
    }
}