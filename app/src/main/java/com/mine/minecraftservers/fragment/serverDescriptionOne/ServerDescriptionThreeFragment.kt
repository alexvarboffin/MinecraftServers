package com.mine.minecraftservers.fragment.serverDescriptionOne

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerDescriptionThreeBinding


class ServerDescriptionThreeFragment : BaseFragment<FragmentServerDescriptionThreeBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerDescriptionThreeBinding =
        FragmentServerDescriptionThreeBinding.inflate(inflater, container, false)


    override fun FragmentServerDescriptionThreeBinding.onBindView(saveInstanceState: Bundle?) {
        backToServerThree.setOnClickListener {
            navController.navigate(ServerDescriptionThreeFragmentDirections.actionServerDescriptionThreeFragmentToServerOneFragment())
        }
        buttonToServerThree.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer=FitoCraft|fitocraft.ru:19132")
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




