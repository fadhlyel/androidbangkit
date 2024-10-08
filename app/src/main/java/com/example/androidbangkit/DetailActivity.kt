package com.example.androidbangkit

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_HERO="extra_hero"
    }

    private lateinit var imgDetail:ImageView
    private lateinit var description:TextView
    private lateinit var title:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imgDetail=findViewById(R.id.img_item_photo_detail)
        description=findViewById(R.id.tv_item_description_detail)
        title=findViewById(R.id.tv_title_detail)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(EXTRA_HERO, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(EXTRA_HERO)
        }

        if (dataHero !=null) {
            imgDetail.setImageResource(dataHero.photo)
            description.text=dataHero.description
            title.text=dataHero.name
        }
    }
}