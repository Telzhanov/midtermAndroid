package com.example.askhat.androidlab4.auth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.askhat.androidlab4.R
import kotlinx.android.synthetic.main.activity_auth.*
import org.koin.android.ext.android.inject

class AuthActivity : AppCompatActivity(), AuthContract.AuthView {
    override fun close() {
        finish()
    }
    override val presenter: AuthContract.AuthPresenter  by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        login.setOnClickListener {
            presenter.signUpUser(emailInput.text.toString(), passwordInput.text.toString() )
            finish()
        }
    }
}