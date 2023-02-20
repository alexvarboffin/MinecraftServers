package com.mine.minecraftservers.fragment.serverDescriptionOne

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerDescriptionOneBinding


class ServerDescriptionOneFragment : BaseFragment<FragmentServerDescriptionOneBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerDescriptionOneBinding =
        FragmentServerDescriptionOneBinding.inflate(inflater, container, false)


    override fun FragmentServerDescriptionOneBinding.onBindView(saveInstanceState: Bundle?) {
        backToServerOne.setOnClickListener {
            navController.navigate(ServerDescriptionOneFragmentDirections.actionServerDescriptionOneFragmentToServerOneFragment())
        }
        buttonToServerOne.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("minecraft:://?addExternalServer= BloodMine|bmpe.pw:19132")
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