package co.edu.uan.simpsonsdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.edu.uan.simpsonsdemo.databinding.ActivityCharacterInfoBinding

class CharacterInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityCharacterInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterInfoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val characterName = intent.getStringExtra("characterName")
        showCharacter(characterName!!)

    }

    fun showCharacter(name: String) {
        val id = resources.getIdentifier(name.lowercase(), "drawable", packageName)
        binding.characterImage.setImageResource(id)
        binding.characterName.text = name
    }
}