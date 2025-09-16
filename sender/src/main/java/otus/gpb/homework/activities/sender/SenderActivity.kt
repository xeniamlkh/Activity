package otus.gpb.homework.activities.sender

import android.content.Intent
import android.icu.util.ULocale
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import otus.gpb.homework.activities.receiver.R
import androidx.core.net.toUri
import java.util.Locale

class SenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sender)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val googleMapsBtn = findViewById<Button>(R.id.to_google_maps)
        val sendEmailBtn = findViewById<Button>(R.id.send_email)
        val openReceiver = findViewById<Button>(R.id.open_receiver)

        googleMapsBtn.setOnClickListener {
            val uriRestaurant = "geo:0,0?q=restaurants".toUri()
            val mapIntent =
                Intent(Intent.ACTION_VIEW, uriRestaurant)
                    .setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        sendEmailBtn.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "*/*"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "android@otus.ru")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Important email")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email text")
            startActivity(emailIntent)
        }

        openReceiver.setOnClickListener {
            val movie1 = Payload(
                title = "Славные парни",
                year = "2016",
                description = "Что бывает, когда напарником брутального костолома становится субтильный лопух? Наемный охранник Джексон Хили и частный детектив Холланд Марч вынуждены работать в паре, чтобы распутать плевое дело о пропавшей девушке, которое оборачивается преступлением века. Смогут ли парни разгадать сложный ребус, если у каждого из них – свои, весьма индивидуальные методы."
            )
            val movie2 = Payload(
                title = "Интерстеллар",
                year = "2014",
                description = "Когда засуха, пыльные бури и вымирание растений приводят человечество к продовольственному кризису, коллектив исследователей и учёных отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешествий человека и найти планету с подходящими для человечества условиями."
            )

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.addCategory(Intent.CATEGORY_DEFAULT)

            val bundle = Bundle()

            bundle.putString("title", movie1.title)
            bundle.putString("year", movie1.year)
            bundle.putString("description", movie1.description)

            intent.putExtra("movie_bundle", bundle)
        }
    }
}