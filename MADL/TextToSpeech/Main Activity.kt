import android.app.ComponentCaller
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Photo
import android.provider.MediaStore
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateint var text:EditText
    private lateint var speech:Button
    private lateint var textToSpeech:TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        text=findViewById(R.id.text)
        speech=findViewById(R.id.speech)
        textToSpeech= TextToSpeech(this,this)
        speech.setOnClickListener {
            val text=text.text.toString();
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        }

    override fun onInit(p0: Int) {
        TODO("Not yet implemented")
        val result=textToSpeech.setLanguage(Locale.US)
        if(result== TextToSpeech.LANG_MISSING_DATA || result== TextToSpeech.LANG_NOT_SUPPORTED){
            Toast.makeText(this,"langauage is not suporrted",Toast.LENGTH_LONG).show()
        }
    }


}
