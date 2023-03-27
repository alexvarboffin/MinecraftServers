package com.mine.minecraftservers.fragment.serverGames.serverDescriptionGames

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerGamesOneBinding


class ServerGamesOneFragment : BaseFragment<FragmentServerGamesOneBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerGamesOneBinding =
        FragmentServerGamesOneBinding.inflate(inflater, container, false)


    override fun FragmentServerGamesOneBinding.onBindView(saveInstanceState: Bundle?) {
        backToServerGamesOne.setOnClickListener {
            navController.navigate(ServerGamesOneFragmentDirections.actionServerGamesOneFragmentToServerGamesFragment())
        }
        buttonToServerGamesOne.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer=SunWix BedWars|sunwix.ru:19131")
                    )
                )
            } catch (e: Exception) {
                init()
                onPause()
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://bloodmine-pe.ru/howtoplay.html")
                    )
                )
            }
        }
    }
    private fun init() {
        Toast.makeText(
            requireContext(),
            "Приложение minecraft не установлено",
            Toast.LENGTH_LONG
        )
            .show()
        Thread.sleep(1000)
    }
}

