package com.mine.minecraftservers.fragment.serverGames.serverDescriptionGames

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerGamesFourBinding

class ServerGamesFourFragment : BaseFragment<FragmentServerGamesFourBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerGamesFourBinding =
        FragmentServerGamesFourBinding.inflate(inflater, container, false)


    override fun FragmentServerGamesFourBinding.onBindView(saveInstanceState: Bundle?) {
        backToServerGamesFour.setOnClickListener {
            navController.navigate(ServerGamesFourFragmentDirections.actionServerGamesFourFragmentToServerGamesFragment())
        }
        buttonToServerGamesFour.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer=BloodMine|bmpe.pw:19131")
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


