package com.uam.incrementovm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.uam.incrementovm.ui.theme.IncrementoVMTheme
import com.uam.navegacionobject.navigacion.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IncrementoVMTheme {
                Surface {
                    Navigation()
                }
            }
        }
    }
}

