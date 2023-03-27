package com.mine.minecraftservers.fragment.serverTwoVersion.serverDescriptionTwo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerThreeDescriptionBinding


class ServerThreeDescriptionFragment : BaseFragment<FragmentServerThreeDescriptionBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerThreeDescriptionBinding =
        FragmentServerThreeDescriptionBinding.inflate(inflater, container, false)


    override fun FragmentServerThreeDescriptionBinding.onBindView(saveInstanceState: Bundle?) {
        backThreeToServer.setOnClickListener {
            navController.navigate(ServerThreeDescriptionFragmentDirections.actionServerThreeDescriptionFragmentToServerTwoFragment())
        }
        buttonThreeToServer.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer=Vanilla Patina|vanillapatina.ru:19132")
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