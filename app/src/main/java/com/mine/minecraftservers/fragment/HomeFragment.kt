package com.mine.minecraftservers.fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)


    override fun FragmentHomeBinding.onBindView(saveInstanceState: Bundle?) {
        textHomeServerOne.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToServerOneFragment())
        }
        textHomeServerTwo.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToServerTwoFragment())
        }
        buttonMiniGame.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToServerGamesFragment())
        }
        textPrivacy.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW, Uri.parse("https://bloodmine-pe.ru/privacy.html")
                    )
                )
            } catch (e: Exception) {
                (Toast.makeText(
                    requireContext(),
                    "Отсуствует интернет подключение",
                    Toast.LENGTH_SHORT
                )).show()
            }
        }
    }
}


// //textPrivacy.setOnClickListener {
//        //navController.navigate(HomeFragmentDirections.actionHomeFragmentToServersFragment())
//       // }