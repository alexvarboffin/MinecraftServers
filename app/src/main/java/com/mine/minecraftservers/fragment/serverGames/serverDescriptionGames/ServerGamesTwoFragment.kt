package com.mine.minecraftservers.fragment.serverGames.serverDescriptionGames

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerGamesTwoBinding


class ServerGamesTwoFragment : BaseFragment<FragmentServerGamesTwoBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerGamesTwoBinding =
        FragmentServerGamesTwoBinding.inflate(inflater, container, false)


    override fun FragmentServerGamesTwoBinding.onBindView(saveInstanceState: Bundle?) {
        backToServerGamesTwo.setOnClickListener {
            navController.navigate(ServerGamesTwoFragmentDirections.actionServerGamesTwoFragmentToServerGamesFragment())
        }
        buttonToServerGamesTwo.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer=Greens MCPE|grpe.fun:19132")
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
