package com.docdate

import android.content.Intent
<<<<<<< HEAD
=======
import androidx.appcompat.app.AppCompatActivity
>>>>>>> 44f3d29e91ab9335aa4eb816d55171c9b36d0286
import android.os.Bundle

class MainActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
=======
        setContentView(R.layout.activity_main)

>>>>>>> 44f3d29e91ab9335aa4eb816d55171c9b36d0286
        startActivity(Intent(this, LoginActivity::class.java))
    }
}