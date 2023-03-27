package com.mine.minecraftservers.fragment.serverGames

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.play.core.review.ReviewManagerFactory
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerGamesBinding
import com.mine.minecraftservers.list.ServerGamesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class ServerGamesFragment : BaseFragment<FragmentServerGamesBinding>() {
    private val viewModel by viewModel<ServerGamesViewModel>()
    private val serverGamesAdapter = ServerGamesAdapter()
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerGamesBinding = FragmentServerGamesBinding.inflate(inflater, container, false)


    override fun FragmentServerGamesBinding.onBindView(saveInstanceState: Bundle?) {
        activity?.let { requestReviewFlow(it) }
        buttonBackToHome.setOnClickListener {
            navController.navigate(ServerGamesFragmentDirections.actionServerGamesFragmentToHomeFragment())
        }
        viewModel.getServers()
        recyclerViewGames.adapter = serverGamesAdapter
        viewModel.gamesLiveData.observe(viewLifecycleOwner) { servers ->
            serverGamesAdapter.submitList(servers)
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
