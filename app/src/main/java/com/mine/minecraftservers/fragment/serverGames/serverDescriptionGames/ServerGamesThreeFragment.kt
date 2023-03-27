package com.mine.minecraftservers.fragment.serverGames.serverDescriptionGames

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerGamesThreeBinding


class ServerGamesThreeFragment : BaseFragment<FragmentServerGamesThreeBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerGamesThreeBinding =
        FragmentServerGamesThreeBinding.inflate(inflater, container, false)


    override fun FragmentServerGamesThreeBinding.onBindView(saveInstanceState: Bundle?) {
        backToServerGamesThree.setOnClickListener {
            navController.navigate(ServerGamesThreeFragmentDirections.actionServerGamesThreeFragmentToServerGamesFragment())
        }
        buttonToServerGamesThree.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer=Cristalix|cristalix.pe:19132")
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

