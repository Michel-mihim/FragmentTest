package com.example.fragmenttest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), RadioStorage {

    private val radio = "Radio 7"
    private lateinit var radioName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA.getInstance(radio))
                .commit()
        }

    }

    override fun setRadio(radio: String?) {
        this.radioName = radio ?: ""
    }

    override fun getRadio(): String {
        return radioName ?: ""
    }

}