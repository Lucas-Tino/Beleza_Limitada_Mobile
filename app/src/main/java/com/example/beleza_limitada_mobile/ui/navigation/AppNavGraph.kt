package com.example.beleza_limitada_mobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beleza_limitada_mobile.ui.screens.Home
import com.example.beleza_limitada_mobile.ui.screens.LoginScreen
import com.example.beleza_limitada_mobile.ui.screens.manutencao.CreateManutencaoScreen
import com.example.beleza_limitada_mobile.ui.screens.manutencao.DashboardManutencaoScreen
import com.example.beleza_limitada_mobile.ui.screens.percurso.CreatePercursoScreen
import com.example.beleza_limitada_mobile.ui.screens.percurso.DashboardPercursoScreen
import com.example.beleza_limitada_mobile.ui.screens.percurso.UpdatePercursoScreen
import com.example.beleza_limitada_mobile.ui.screens.veiculo.DashboardVeiculoScreen
import com.example.beleza_limitada_mobile.ui.screens.veiculo.UpdateVeiculoScreen
import com.example.beleza_limitada_mobile.ui.screens.vendedor.CreateVendedorScreen
import com.example.beleza_limitada_mobile.ui.screens.vendedor.DashboardVendedorScreen
import com.example.beleza_limitada_mobile.ui.screens.vendedor.UpdateVendedorScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            Home(navController)
        }
        composable(Routes.LOGIN_SCREEN) {
            LoginScreen(navController)
        }
        composable(Routes.DASHBOARD_MANUTENCAO_SCREEN) {
            DashboardManutencaoScreen(navController)
        }
        composable(Routes.CREATE_MANUTENCAO_SCREEN) {
            CreateManutencaoScreen(navController)
        }
        composable(Routes.UPDATE_MANUTENCAO_SCREEN) {
            UpdateVeiculoScreen(navController)
        }
        composable(Routes.DASHBOARD_PERCURSO_SCREEN) {
            DashboardPercursoScreen(navController)
        }
        composable(Routes.CREATE_PERCURSO_SCREEN) {
            CreateManutencaoScreen(navController)
        }
        composable(Routes.UPDATE_PERCURSO_SCREEN) {
            UpdateVeiculoScreen(navController)
        }
        composable(Routes.DASHBOARD_VEICULO_SCREEN) {
            DashboardVeiculoScreen(navController)
        }
        composable(Routes.CREATE_PERCURSO_SCREEN) {
            CreatePercursoScreen(navController)
        }
        composable(Routes.UPDATE_PERCURSO_SCREEN) {
            UpdatePercursoScreen(navController)
        }
        composable(Routes.DASHBOARD_VENDEDOR_SCREEN) {
            DashboardVendedorScreen(navController)
        }
        composable(Routes.CREATE_VENDEDOR_SCREEN) {
            CreateVendedorScreen(navController)
        }
        composable(Routes.UPDATE_VENDEDOR_SCREEN) {
            UpdateVendedorScreen(navController)
        }
    }
}