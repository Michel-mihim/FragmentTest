package com.example.fragmenttest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), RadioStorage {

    val radio = "Radio 7"
    var _radio = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA.newInstance(radio))
                .commit()
        }

    }

    override fun setRadio(radio: String) {
        this._radio = radio
    }

    override fun getRadio(): String {
        return _radio
    }

}