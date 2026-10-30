package com.example.profildeveloppeur

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilDeveloppeurTheme {
                ProfilDevelopeurEcran(
                    nom = "Beff Jezos",
                    metier = "Développeur C++",
                    specialite = "Spécialiste Gameplay",
                    email = "beff.jezos@example.com",
                    disponible = true,
                    description = "Développeur de jeu vidéo spécialisé dans le gameplay avec quatre années d'expérience."
                )
            }
        }
    }
}

@Composable
fun ProfilDevelopeurEcran(
    nom: String,
    metier: String,
    specialite: String,
    email: String,
    disponible: Boolean,
    description: String,
    modifier: Modifier = Modifier
) {

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Surface(
            color = Color(0xFFFCE4EC),
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxWidth()
        ) {

            Column(modifier = Modifier.padding(20.dp)) {
                Titre(nom = nom, metier = metier)

                Specialite(nom = specialite, modifier = Modifier.padding(top = 10.dp))

                Text(text = description, modifier = Modifier.padding(top = 10.dp))

                Disponibilite(
                    disponible = disponible,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(text = email, modifier = Modifier.padding(top = 10.dp))

                BoutonContact(
                    // J'envoie un log dans le terminal quand il y a un clic sur le bouton
                    onClick = { Log.d("Profil", "Bonjour, je suis $nom") },
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Titre(nom: String, metier: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = nom,
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF388E3C)
        )
        Text(text = metier)
    }
}

@Composable
fun Specialite(nom: String, modifier: Modifier = Modifier) {
    Text(text = "$nom", modifier = modifier)
}

@Composable
fun Disponibilite(disponible: Boolean, modifier: Modifier = Modifier) {
    val texte = if (disponible) "Disponible" else "Indisponible"
    Text(
        text = texte,
        modifier = modifier
    )
}

@Composable
fun BoutonContact(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = "Me contacter")
    }
}

@Preview(showBackground = true)
@Composable
fun ApercuJeuVideo() {
    ProfilDeveloppeurTheme {
        ProfilDevelopeurEcran(
            nom = "Beff Jezos",
            metier = "Développeur C++",
            specialite = "Spécialiste Gameplay",
            email = "beff.jezos@example.com",
            disponible = true,
            description = "Développeur de jeu vidéo spécialisé dans le gameplay avec quatre années d'expérience."
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ApercuGo() {
    ProfilDeveloppeurTheme {
        ProfilDevelopeurEcran(
            nom = "Melon Usk",
            metier = "Développeur Go",
            specialite = "Spécialiste Backend",
            email = "melon.usk@example.com",
            disponible = false,
            description = "Développeur Go spécialisé en backend avec deux années d'expérience."
        )
    }
}