package com.example.askhat.androidlab4.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.askhat.androidlab4.post.MainActivity
import com.example.askhat.androidlab4.R
import com.example.askhat.androidlab4.auth.AuthActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity() : AppCompatActivity(), LoginContract.LoginView{
    override val presenter: LoginContract.LoginPresenter by inject()
    override fun successfulLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun unSuccessfulLogin() {
        Toast.makeText(this,"Login or password not correct",Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.attachView(this)
        login.setOnClickListener {
            presenter.checkUser(emailInput.text.toString(),passwordInput.text.toString())
        }
        textView.setOnClickListener {
            val intent= Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }
}
