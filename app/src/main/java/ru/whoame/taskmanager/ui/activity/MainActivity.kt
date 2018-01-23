package ru.whoame.taskmanager.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.whoame.taskmanager.R
import ru.whoame.taskmanager.ui.fragment.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.main_container, LoginFragment()).commit()
    }
}
