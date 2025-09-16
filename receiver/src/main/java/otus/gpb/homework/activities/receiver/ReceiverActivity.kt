package otus.gpb.homework.activities.receiver

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReceiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        val intent = intent.getBundleExtra("movie_bundle")

        val title = intent?.getString("title")
        val year = intent?.getString("year")
        val description = intent?.getString("description")

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val yearTextView = findViewById<TextView>(R.id.yearTextView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        val imageView = findViewById<ImageView>(R.id.posterImageView)

        titleTextView.text = title
        yearTextView.text = year
        descriptionTextView.text = description

        when (title) {
            "Славные парни" -> imageView.setImageResource(R.drawable.niceguys)
            "Интерстеллар" -> imageView.setImageResource(R.drawable.interstellar)
            else -> {}
        }
    }
}
