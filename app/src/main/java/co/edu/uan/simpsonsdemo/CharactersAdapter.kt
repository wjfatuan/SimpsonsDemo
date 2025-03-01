package co.edu.uan.simpsonsdemo

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CharactersAdapter(val ctx: MainActivity, val characters: Array<String>)
    : ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, characters) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = ctx.layoutInflater.inflate(R.layout.list_character,null)
        val characterName = view.findViewById<TextView>(R.id.characterName)
        characterName.text = characters[position]
//        val characterIcon = view.findViewById<ImageView>(R.id.characterIcon)
//        characterIcon.setImageResource(R.drawable.lisa)
        return view
    }

}