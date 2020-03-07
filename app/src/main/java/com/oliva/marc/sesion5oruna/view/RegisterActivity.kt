package com.oliva.marc.sesion5oruna.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oliva.marc.sesion5oruna.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    var valueRating: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        rating_ratingbar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            valueRating = fl
        }

        register_button.setOnClickListener {
            val intent = Intent()
            val extras = Bundle()
            extras.putString("name", name_edittext.text.toString())
            extras.putString("category", category_edittext.text.toString())
            extras.putFloat("rating", valueRating)
            extras.putString("picture", "")
            intent.putExtras(extras)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}
