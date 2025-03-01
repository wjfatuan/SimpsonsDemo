package co.edu.uan.simpsonsdemo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.edu.uan.simpsonsdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val characters = mutableListOf("Bart", "Homer", "Maggie")

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

        binding.btnBart.setOnClickListener { it ->
            goToCharacterInfo((it as Button).text.toString())
        }
        binding.btnHomer.setOnClickListener { it ->
            goToCharacterInfo((it as Button).text.toString())
        }

        val adapter = CharactersAdapter(this, characters)
        binding.charactersList.adapter = adapter
        binding.charactersList.setOnItemClickListener { parent, view, position, id ->
            println("parent: $parent\n view: $view\n position: $position\n id: $id")
            val characterName = parent.getItemAtPosition(position) as String
            goToCharacterInfo(characterName)
            addCharacter()
            adapter.notifyDataSetChanged()
        }
    }

    fun goToCharacterInfo(characterName: String) {
        val intent = Intent(this, CharacterInfoActivity::class.java)
        intent.putExtra("characterName", characterName)
        startActivity(intent)
    }

    fun addCharacter() {
        characters.add("Lisa")
    }

}
