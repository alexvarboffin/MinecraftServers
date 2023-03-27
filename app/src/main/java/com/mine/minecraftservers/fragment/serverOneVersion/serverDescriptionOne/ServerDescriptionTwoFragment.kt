package com.mine.minecraftservers.fragment.serverOneVersion.serverDescriptionOne

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerDescriptionTwoBinding


class ServerDescriptionTwoFragment : BaseFragment<FragmentServerDescriptionTwoBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerDescriptionTwoBinding =
        FragmentServerDescriptionTwoBinding.inflate(inflater, container, false)


    override fun FragmentServerDescriptionTwoBinding.onBindView(saveInstanceState: Bundle?) {
        backToServerTwo.setOnClickListener {
            navController.navigate(ServerDescriptionTwoFragmentDirections.actionServerDescriptionTwoFragmentToServerOneFragment())
        }
        buttonToServerTwo.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer=BloodMine SkyWars|bmpe.pw:19130")
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


