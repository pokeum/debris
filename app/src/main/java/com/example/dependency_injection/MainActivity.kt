package com.example.dependency_injection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.ab180.debris.dsl.module
import co.ab180.debris.dsl.startDebris
import com.example.dependency_injection.learnKoin.HelloSayer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val debrisModule = startDebris {
            val firstModule = module {
                single { HelloSayer() }
            }
            modules(firstModule)
        }
    }
}