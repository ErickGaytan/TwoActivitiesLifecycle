package com.example.user.twoactivitieslifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var MessageEditText: EditText? = null
    private var ReplyHeadTextView: TextView? = null
    private var ReplyTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "----------")
        Log.d(LOG_TAG, "onCreate")

        MessageEditText = findViewById<View>(R.id.editText_main) as EditText
        ReplyHeadTextView = findViewById<View>(R.id.text_header_reply) as TextView
        ReplyTextView = findViewById<View>(R.id.text_message_reply) as TextView

        if (savedInstanceState != null)
        {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if(isVisible)
            {
                ReplyTextView!!.visibility = View.VISIBLE
                ReplyTextView!!.text = savedInstanceState.getString("reply_text")
                ReplyTextView!!. visibility = View.VISIBLE
            }
        }

    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")

        val intent = Intent(this, SecondActivity::class.java)//activity_main2 Main2Activity
        val message = editText_main !!.text.toString()//editText_main

        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val reply = data!!.getStringExtra(SecondActivity.EXTRA_REPLY)

                ReplyHeadTextView!!.visibility = View.VISIBLE
                ReplyTextView!!.text = reply
                ReplyTextView!!.visibility = View.VISIBLE

               /* text_header_reply!!.visibility = View.VISIBLE

                text_message_reply!!.text = reply
                text_message_reply!!.visibility = View.VISIBLE*/
            }
        }
    }

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

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        if (ReplyHeadTextView!!.visibility == View.VISIBLE)
        {
            outState!!.putBoolean("reply_visible", true)
            outState.putString("reply_text", ReplyTextView!!.text.toString())
        }
    }




    companion object {
        private val LOG_TAG = MainActivity::class.java!!.simpleName
        val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        val TEXT_REQUEST = 1
    }
}