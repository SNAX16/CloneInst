package com.molodovViktor.instagram.screens.search

import android.arch.lifecycle.Observer
import android.util.Log
import com.molodovViktor.instagram.common.BaseEventListener
import com.molodovViktor.instagram.common.Event
import com.molodovViktor.instagram.common.EventBus
import com.molodovViktor.instagram.data.SearchRepository
import com.molodovViktor.instagram.models.SearchPost

class SearchPostsCreator(searchRepo: SearchRepository) : BaseEventListener() {
    init {
        EventBus.events.observe(this, Observer {
            it?.let { event ->
                when (event) {
                    is Event.CreateFeedPost -> {
                        val searchPost = with(event.post) {
                            SearchPost(
                                    image = image,
                                    caption = caption,
                                    postId = id)
                        }
                        searchRepo.createPost(searchPost).addOnFailureListener {
                            Log.d(TAG, "Failed to create search post for event: $event", it)
                        }
                    }
                    else -> {
                    }
                }
            }
        })
    }

    companion object {
        const val TAG = "SearchPostsCreator"
    }
}