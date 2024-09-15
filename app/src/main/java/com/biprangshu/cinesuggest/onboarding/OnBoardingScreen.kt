package com.biprangshu.cinesuggest.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
){
    Column(modifier = Modifier.fillMaxSize().navigationBarsPadding(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        val pagerState= rememberPagerState(initialPage = 0){
            pages.size
        }

        val buttonState= remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> "Next"
                    1 -> "Next"
                    2 -> "Dive In"
                    else -> ""
                }
            }
        }

        val scope= rememberCoroutineScope()

        HorizontalPager(state = pagerState) {
            index->
            OnBoardingTop(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        PageIndicator(pageSize = pages.size, selectedPage = pagerState.currentPage)
        Spacer(modifier = Modifier.height(16.dp))
        OnBoardingButton(text = buttonState.value, onClick = {
            scope.launch{
                if(pagerState.currentPage==2){
                    // TODO add event to save app entry
                }else{
                    pagerState.animateScrollToPage(page = pagerState.currentPage+1)
                }
            }
        })
        Spacer(modifier = Modifier.weight(0.3f))
    }

}