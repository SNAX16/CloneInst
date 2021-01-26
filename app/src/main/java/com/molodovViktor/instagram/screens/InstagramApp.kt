package com.molodovViktor.instagram.screens

import android.app.Application
import com.molodovViktor.instagram.common.firebase.FirebaseAuthManager
import com.molodovViktor.instagram.data.firebase.FirebaseFeedPostsRepository
import com.molodovViktor.instagram.data.firebase.FirebaseNotificationsRepository
import com.molodovViktor.instagram.data.firebase.FirebaseSearchRepository
import com.molodovViktor.instagram.data.firebase.FirebaseUsersRepository
import com.molodovViktor.instagram.screens.notifications.NotificationsCreator
import com.molodovViktor.instagram.screens.search.SearchPostsCreator

class InstagramApp : Application() {
    val usersRepo by lazy { FirebaseUsersRepository() }
    val feedPostsRepo by lazy { FirebaseFeedPostsRepository() }
    val notificationsRepo by lazy { FirebaseNotificationsRepository() }
    val authManager by lazy { FirebaseAuthManager() }
    val searchRepo by lazy { FirebaseSearchRepository() }

    override fun onCreate() {
        super.onCreate()
        NotificationsCreator(notificationsRepo, usersRepo, feedPostsRepo)
        SearchPostsCreator(searchRepo)
    }
}