package co.edu.uan.simpsonsdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.edu.uan.simpsonsdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnBart.setOnClickListener {
            goToCharacterInfo((it as Button).text.toString())
        }
        binding.btnHomer.setOnClickListener {
            goToCharacterInfo((it as Button).text.toString())
        }
    }

    fun goToCharacterInfo(characterName: String) {
        val intent = Intent(this, CharacterInfoActivity::class.java)
        intent.putExtra("characterName", characterName)
        startActivity(intent)
    }

}