package com.example.mindfulme.feature.signUp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mindfulme.feature.main.route.Screen
import com.example.mindfulme.feature.signIn.EmailField
import com.example.mindfulme.feature.signIn.GoogleSignInButton
import com.example.mindfulme.feature.signIn.PasswordField
import com.example.mindfulme.ui.theme.Black1
import com.example.mindfulme.ui.theme.Black10
import com.example.mindfulme.ui.theme.Black4
import com.example.mindfulme.ui.theme.Black5
import com.example.mindfulme.ui.theme.Black6
import com.example.mindfulme.ui.theme.Black7
import com.example.mindfulme.ui.theme.Purple10
import com.example.mindfulme.ui.theme.Purple6

@Composable
fun SignUp(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confPassword = remember { mutableStateOf("") }
    val isFormFilled = email.value.isNotEmpty() && password.value.isNotEmpty() && confPassword.value.isNotEmpty()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Purple6)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStartPercent = 15, topEndPercent = 15))
                .background(Color.White)
                .padding(bottom = 16.dp, top = 25.dp)
                .padding(horizontal = 16.dp)

        ) {
            Text(
                text = "Halo!",
                style = MaterialTheme.typography.displayMedium,
                color = Color.Black
            )
            Text(
                text = "Selamat Datang di",
                style = MaterialTheme.typography.displayMedium,
                color = Color.Black
            )
            Text(
                text = "MindfulMe",
                style = MaterialTheme.typography.displayMedium,
                color = Purple6
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Buat akun untuk menjelajahi dukungan kesehatan mental kami dan pantau kesejahteraan Anda dengan mudah.",
                style = MaterialTheme.typography.bodySmall,
                color = Black7
            )
            Spacer(modifier = Modifier.height(12.dp))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Black5)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Alamat Email",
                style = MaterialTheme.typography.bodyLarge,
                color = Black10
            )
            Spacer(modifier = Modifier.height(8.dp))
            EmailField(value = email.value, onValueChange = { email.value = it })
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Kata Sandi",
                style = MaterialTheme.typography.bodyLarge,
                color = Black10
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordField(value = password.value, onValueChange = { password.value = it })
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Kata Sandi",
                style = MaterialTheme.typography.bodyLarge,
                color = Black10
            )
            Spacer(modifier = Modifier.height(8.dp))
            ConfPasswordFIeld(value = confPassword.value, onValueChange = { confPassword.value = it })
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = if (isFormFilled) Purple6 else Black4,
                        shape = RoundedCornerShape(100)
                    )
                    .clickable(enabled = isFormFilled) {
                        if (isFormFilled) {
//                        navController.navigate(Screen.SignIn.route) {
//                           popUpTo(Screen.SignIn.route) { inclusive = true }
//                    }
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Buat Akun",
                    color = Black1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Black6)
                )
                Text(text = "Atau", style = MaterialTheme.typography.labelMedium, color = Black6, textAlign = TextAlign.Center, modifier = Modifier.weight(0.5f))
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Black6)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            GoogleSignInButton(
                text = "Buat akun dengan Google",
                onClick = {
                    // Aksi ketika tombol diklik
                    // Misalnya, memulai proses sign-in dengan Google
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(text = "Sudah punya akun?", color = Purple6, style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Masuk", style = MaterialTheme.typography.labelMedium, color = Purple10, modifier = Modifier.clickable {
                    navController.navigate(Screen.SignIn.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    } })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfPasswordFIeld(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    val visualTransformation = if (isPasswordVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp)),

        value = value,
        shape = RoundedCornerShape(20.dp),
        onValueChange = {
            onValueChange(it)
        },
        placeholder = { Text("Masukkan lagi kata sandi anda", color = Black6, style = MaterialTheme.typography.labelMedium) },
        textStyle = TextStyle(color = Black10),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Black5,
            focusedBorderColor = Purple6
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                val image = if (isPasswordVisible) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }
                Icon(imageVector = image, contentDescription = "Toggle password visibility", tint = Purple6)
            }
        }
    )
}