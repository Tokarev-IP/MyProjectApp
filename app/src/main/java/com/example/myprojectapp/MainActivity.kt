package com.example.myprojectapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myprojectapp.registration.RegCompose
import com.example.myprojectapp.registration.RegErrors
import com.example.myprojectapp.ui.theme.MyProjectAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProjectAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartUI()
                }
            }
        }
    }

//    fun getToken() {
//
//        auth.signInWithCustomToken("")
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithCustomToken:success")
//                    val user = auth.currentUser
//                    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "signInWithCustomToken:failure", task.exception)
//                    Toast.makeText(
//                        baseContext, "Authentication failed.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    updateUI(null)
//                }
//            }
//
//    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun StartUI(
        modifier: Modifier = Modifier,
        regViewModel: RegViewModel = viewModel(),
    ) {
        val state by regViewModel.state.collectAsState()

        RegCompose().FullRegCompose(
            onLogInAction = {
            },
            onRegAction = { email: String, password: String ->
                regViewModel.regByEmail(email, password)
            },
            error = false,
        )

        when (state) {
            is RegErrors.NoError -> {
            }
            is RegErrors.RegNewAccountError -> {

            }
            is RegErrors.LogInAccountError -> {
                (state as RegErrors.LogInAccountError).text
            }
        }

    }

    fun closeSoft() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyProjectAppTheme {
            StartUI()
        }
    }
}
