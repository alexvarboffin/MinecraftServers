package com.mine.minecraftservers.fragment.serverGames

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.play.core.review.ReviewManagerFactory
import com.mine.domain.model.ServerDivider
import com.mine.domain.model.ServerGamesType
import com.mine.minecraftservers.R
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerGamesBinding
import com.mine.minecraftservers.list.ServerGamesAdapter


class ServerGamesFragment : BaseFragment<FragmentServerGamesBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerGamesBinding = FragmentServerGamesBinding.inflate(inflater, container, false)


    override fun FragmentServerGamesBinding.onBindView(saveInstanceState: Bundle?) {
        activity?.let { requestReviewFlow(it) }
        buttonBackToHome.setOnClickListener {
            navController.navigate(ServerGamesFragmentDirections.actionServerGamesFragmentToHomeFragment())
        }
        val adapterGames = ServerGamesAdapter()
        adapterGames.submitList(listOf(
            ServerGamesType(
                "SunWix BedWars",
                "IP sunwix.ru",
                "PORT 19131",
                " version 1.19",
                image = R.drawable.sunwix
            ) {
                navController.navigate(ServerGamesFragmentDirections.actionServerGamesFragmentToServerGamesOneFragment())
            },
            ServerDivider,
            ServerGamesType(
                "Greens MCPE",
                "IP grpe.fun",
                "PORT 19132",
                "version 1.1-1.19",
                image = R.drawable.greens_mcpe
            ) {
                navController.navigate(ServerGamesFragmentDirections.actionServerGamesFragmentToServerGamesTwoFragment())
            },
            ServerDivider,
            ServerGamesType(
                "Cristalix",
                "IP cristalix.pe",
                "PORT 19132",
                "version 1.17-1.19",
                image = R.drawable.cristalix
            ) {
                navController.navigate(ServerGamesFragmentDirections.actionServerGamesFragmentToServerGamesThreeFragment())
            },
            ServerDivider,
            ServerGamesType(
                "BloodMine",
                "IP BMPE.PW",
                "PORT 19131",
                "version 1.16-1.19", image = R.drawable.bloodmine
            ) {
                navController.navigate(ServerGamesFragmentDirections.actionServerGamesFragmentToServerGamesFourFragment())
            }
        ))
        with(binding) {
            recyclerViewGames.adapter = adapterGames
        }
    }

    private fun requestReviewFlow(activity: Activity) {

        val reviewManager = ReviewManagerFactory.create(activity)

        val requestReviewFlow = reviewManager.requestReviewFlow()

        requestReviewFlow.addOnCompleteListener { request ->

            if (request.isSuccessful) {

                val reviewInfo = request.result

                val flow = reviewManager.launchReviewFlow(activity, reviewInfo)

                flow.addOnCompleteListener {
                }
            } else {
                Toast.makeText(
                    requireContext(), "Не удалось запустить", Toast.LENGTH_LONG
                )
                    .show()
            }
        }
    }
}
