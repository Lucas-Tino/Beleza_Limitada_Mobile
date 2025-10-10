package com.example.beleza_limitada_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.beleza_limitada_mobile.ui.navigation.AppNavGraph
import com.example.beleza_limitada_mobile.ui.theme.Beleza_Limitada_MobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Beleza_Limitada_MobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavGraph(navController = rememberNavController(), modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}