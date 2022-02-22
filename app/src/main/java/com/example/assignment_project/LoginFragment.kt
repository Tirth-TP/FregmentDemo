package com.example.assignment_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view : View = inflater.inflate(R.layout.fragment_login,container,false)

        val context = activity as AppCompatActivity


        val username = view.findViewById<EditText>(R.id.username)
        val password = view.findViewById<EditText>(R.id.password)
        val login = view.findViewById<Button>(R.id.login)
        val forgot = view.findViewById<Button>(R.id.forgot)
        val signup = view.findViewById<Button>(R.id.signin)


      //  var fragment: Fragment? = null


        login.setOnClickListener {
            if (username.text.toString() != "" && password.text.toString() != "") {

                if (username.text.toString() == "TestUser" && password.text.toString() == "test123")
                {
                    Log.e("TEST", "we " + username.text.toString())

                    val intent = Intent(this@LoginFragment.context, MainActivity::class.java)
                    intent.putExtra("a","TestUser")
                    startActivity(intent)


                } else {
                    Toast.makeText(activity, "Invalid Details", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(activity,"Enter Details First",Toast.LENGTH_SHORT).show()
            }
        }
        forgot.setOnClickListener {
            context.addReplaceFragment(ForgotPasswordFragment(), addReplace = false, backAllow = true)
        }
        signup.setOnClickListener {
            context.addReplaceFragment(SingupFragment(), addReplace = false, backAllow = true)
        }
        return view


    }


}


