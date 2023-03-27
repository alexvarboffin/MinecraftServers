package com.mine.minecraftservers

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.mine.minecraftservers.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены,что хотите выйти?")

            setPositiveButton("Да") { _, _ ->
                super.onBackPressed()
                onPause()
                finish()
            }
            setNegativeButton("Нет") { _, _ ->
            }
            setCancelable(true)
        }.create().show()
        onResume()
    }
}


