package vcmsa.ci.mealapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var edtSuggestion : EditText? = null
    var btnEnter : Button? = null
    var btnClear : Button? = null
    var Output : TextView? = null
    var suggested : TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtSuggestion = findViewById<View>(R.id.edtSuggestion) as EditText
        btnEnter = findViewById<View>(R.id.btnEnter) as Button
        btnClear = findViewById<View>(R.id.btnClear) as Button
        Output = findViewById<View>(R.id.Output) as TextView
        suggested = findViewById<View>(R.id.suggested) as TextView

        btnEnter!!.setOnClickListener{

            val timeOfDay = edtSuggestion!!.text.toString().lowercase()
            var suggested : String = "Empty"

            if (timeOfDay == "morning")
            {
                suggested = "there's eggs and toast "

            }
            else if (timeOfDay == "mid morning")
            {
                suggested = "Let's try having waffles or pancakes"

            }
            else if(timeOfDay == "afternoon")
            {
                suggested = "Now let's have some chips and russian"
            }
            else if (timeOfDay == "mid afternoon")
            {
                suggested = "Try some snacks e.g popcorn and biltong"
            }
            else if(timeOfDay == "dinner")
            {
                suggested = "How about Mash potato with stew beef"
            }
            Output!!.text = suggested
        }

        btnClear!!.setOnClickListener {
            edtSuggestion!!.text.clear()
            Output!!.text = ""


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}}