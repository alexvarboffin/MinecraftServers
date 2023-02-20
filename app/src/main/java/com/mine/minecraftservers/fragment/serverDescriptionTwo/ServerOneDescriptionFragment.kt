package com.mine.minecraftservers.fragment.serverDescriptionTwo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerOneDescriptionBinding



class ServerOneDescriptionFragment : BaseFragment<FragmentServerOneDescriptionBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerOneDescriptionBinding =
        FragmentServerOneDescriptionBinding.inflate(inflater, container, false)


    override fun FragmentServerOneDescriptionBinding.onBindView(saveInstanceState: Bundle?) {
        backOneToServer.setOnClickListener {
            navController.navigate(ServerOneDescriptionFragmentDirections.actionServerOneDescriptionFragmentToServerTwoFragment())
        }
        buttonOneToServer.setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("minecraft:://?addExternalServer=BloodMine|bmpe.pw:19132")))
            } catch (e: Exception) {
                init()
                onPause()
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://bloodmine-pe.ru/howtoplay.html")))
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