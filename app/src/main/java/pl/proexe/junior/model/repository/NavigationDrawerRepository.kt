package pl.proexe.junior.model.repository

import pl.proexe.junior.R
import pl.proexe.junior.model.data.AccountInfo
import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.model.data.NavigationDrawerItem
import pl.proexe.junior.model.data.NavigationDrawerModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationDrawerRepository @Inject constructor(){

    fun getNavigationDrawerItem(): NavigationDrawerModel{
        val accountInfo = AccountInfo("Jakub Zając", 12345000)
        val navDrawerItemList = listOf(
            NavigationDrawerItem(R.string.main_page_nav_drawer_title, true),
            NavigationDrawerItem(R.string.tv_programme_nav_drawer_title, false),
            NavigationDrawerItem(R.string.channel_nav_drawer_title, false),
            NavigationDrawerItem(R.string.favourite_nav_drawer_title, false),
            NavigationDrawerItem(R.string.recording_nav_drawer_title, false)
        )

        return NavigationDrawerModel(accountInfo = accountInfo, drawerItem = navDrawerItemList)

    }
}