package com.example.assignment_project

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setStatusBarColor(this, ContextCompat.getColor(this, R.color.startColor))
        setStatusBarColor(this, R.color.startColor)
        setContentView(R.layout.activity_second)
        addReplaceFragment(LoginFragment(), addReplace = true, backAllow = false)

    }
}

    fun AppCompatActivity.addReplaceFragment(fragment: Fragment, addReplace: Boolean,backAllow: Boolean) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
       transaction.setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
        if (addReplace) {
            transaction.add(R.id.fragmentContainer, fragment)
        } else {
            transaction.replace(R.id.fragmentContainer, fragment)
        }
        if(backAllow) {
            transaction.addToBackStack(LoginFragment().toString())
        }else{
            transaction.addToBackStack(null)
        }
        transaction.commit()

    }

fun setStatusBarColor (activity: AppCompatActivity, color: Int){
    val window: Window = activity.window
// clear FLAG_TRANSLUCENT_STATUS flag:
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
    window.statusBarColor = ContextCompat.getColor(activity, color)
}


