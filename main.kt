import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())

        measureButton.setOnClickListener {
            val pulseValue = pulseEditText.text.toString().toIntOrNull()

            if (pulseValue != null) {
                val populatedPlace = populatedPlaceEditText.text.toString()
                val pulseEntry = "Pulse: $pulseValue bpm\nTime: $currentTime\nPlace: $populatedPlace"

                pulseLogTextView.append("\n$pulseEntry")
                pulseEditText.text.clear()
                populatedPlaceEditText.text.clear()
            } else {
                // Handle invalid pulse value
                pulseEditText.error = "Enter a valid pulse value"
            }
        }
    }
}
