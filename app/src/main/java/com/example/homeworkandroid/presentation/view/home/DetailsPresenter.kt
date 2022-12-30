package com.example.homeworkandroid.presentation.view.home

import com.example.homeworkandroid.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val authInteractor: AuthInteractor

) {

    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment) {

        detailsView = detailsFragment


    }


    fun getArguments(
        title: String?,
        time: String?,
        description: String?,
        imageView: Int
    ) {

        detailsView.displayItemData(
            when (title.isNullOrEmpty()) {
                true -> "no data"
                false -> title

            },
            when (time.isNullOrEmpty()) {
                true -> "no data"
                false -> time
            },
            when (description.isNullOrEmpty()) {
                true -> "no data"
                false -> description
            },
            imageView
        )

    }

    fun logoutUser() {

        authInteractor.logoutUser()
        detailsView.userLoggedOut()

    }


}