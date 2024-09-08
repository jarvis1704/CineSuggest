package com.biprangshu.cinesuggest.onboarding

import androidx.annotation.DrawableRes
import com.biprangshu.cinesuggest.R

data class Page(
    val Title: String,
    val description: String,
    @DrawableRes val Image: Int
)

val pages= listOf(
    Page(Title = "Lorem Ipsum1", description = "Lorem Ipsum dolor sit emet", Image= R.drawable.ic_splash),
    Page(Title = "Lorem Ipsum2", description = "Lorem Ipsum dolor sit emet", Image= R.drawable.ic_splash),
    Page(Title = "Lorem Ipsum3", description = "Lorem Ipsum dolor sit emet", Image= R.drawable.ic_splash)
)
