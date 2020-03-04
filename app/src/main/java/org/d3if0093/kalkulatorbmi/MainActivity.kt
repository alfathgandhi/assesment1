package org.d3if0093.kalkulatorbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.d3if0093.kalkulatorbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
