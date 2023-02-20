package com.mine.minecraftservers.fragment.serverTwoVersion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mine.domain.model.ServerDivider
import com.mine.domain.model.ServerItemType
import com.mine.minecraftservers.R
import com.mine.minecraftservers.base.BaseFragment
import com.mine.minecraftservers.databinding.FragmentServerTwoBinding
import com.mine.minecraftservers.list.ServerTwoAdapter


class ServerTwoFragment : BaseFragment<FragmentServerTwoBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentServerTwoBinding = FragmentServerTwoBinding.inflate(inflater, container, false)


    override fun FragmentServerTwoBinding.onBindView(saveInstanceState: Bundle?) {
        buttonBackToHomeTwo.setOnClickListener {
            navController.navigate(ServerTwoFragmentDirections.actionServerTwoFragmentToHomeFragment())
        }
        val adapterTwo = ServerTwoAdapter()
        adapterTwo.submitList(listOf(
            ServerItemType(
                "BloodMine", "IP BMPE.PW", "PORT 19132", image = R.drawable.bloodmine
            ) {
                navController.navigate(ServerTwoFragmentDirections.actionServerTwoFragmentToServerOneDescriptionFragment())
            },
            ServerDivider,
            ServerItemType(
                "BloodMine SkyWars",
                "IP BMPE.PW",
                "PORT 19131",
                image = R.drawable.skywars
            ) {
                navController.navigate(ServerTwoFragmentDirections.actionServerTwoFragmentToServerTwoDescriptionFragment())
            },
           ServerDivider,
         ServerItemType(
                "VANILLA PATINA",
                "vanillapatina.ru",
                "PORT 19132",
                image = R.drawable.vanilla_patina
            ) {
                navController.navigate(ServerTwoFragmentDirections.actionServerTwoFragmentToServerThreeDescriptionFragment())
            },
           ServerDivider,
           ServerItemType(
                "LimeDex",
                "be.lime-d.ru",
                "PORT 19132",
                R.drawable.limedex
            ) {
                navController.navigate(ServerTwoFragmentDirections.actionServerTwoFragmentToServerFourDescriptionFragment())
            }, ServerDivider
        ))

        with(binding) {
            recyclerViewServerTwo.adapter = adapterTwo
        }
    }
}


