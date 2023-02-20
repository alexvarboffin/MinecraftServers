package com.mine.minecraftservers.fragment.serverDescriptionTwo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerTwoDescriptionBinding


class ServerTwoDescriptionFragment : BaseFragment<FragmentServerTwoDescriptionBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerTwoDescriptionBinding =
        FragmentServerTwoDescriptionBinding.inflate(inflater, container, false)


    override fun FragmentServerTwoDescriptionBinding.onBindView(saveInstanceState: Bundle?) {
        backTwoToServer.setOnClickListener {
            navController.navigate(ServerTwoDescriptionFragmentDirections.actionServerTwoDescriptionFragmentToServerTwoFragment())
        }
        buttonTwoToServer.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer= BloodMine SkyWars|bmpe.pw:19131")
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