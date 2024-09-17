package com.biprangshu.cinesuggest.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.biprangshu.cinesuggest.data.remote.MovieApi
import com.biprangshu.cinesuggest.domain.model.Movie
import com.biprangshu.cinesuggest.utils.RatingBar
import com.biprangshu.cinesuggest.utils.Screen
import com.biprangshu.cinesuggest.utils.getAverageColor

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    navHostController: NavHostController
    ) {
    val imageState= rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(MovieApi.IMAGE_BASE_URL + movie.backdrop_path).size(Size.ORIGINAL).build()
    ).state

    val defaultColor= MaterialTheme.colorScheme.secondaryContainer
    var dominantColor by remember {
        mutableStateOf(defaultColor)
    }

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .width(200.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.secondaryContainer,
                        dominantColor
                    )
                )
            )
            .clickable {
                navHostController.navigate(Screen.Details.rout + "/${movie.id}")
            }
    ) {
        if(imageState is AsyncImagePainter.State.Error){
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(250.dp)
                .clip(
                    RoundedCornerShape(22.dp)
                )
                .background(MaterialTheme.colorScheme.primaryContainer)){
                Icon(imageVector = Icons.Rounded.ImageNotSupported, contentDescription = movie.title)
            }
        }

        if(imageState is AsyncImagePainter.State.Success){
            dominantColor= getAverageColor(
                imageBitmap = imageState.result.drawable.toBitmap().asImageBitmap()
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(6.dp)
                    .clip(
                        RoundedCornerShape(22.dp)
                    ),
                painter = imageState.painter,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop
            )
        }
        
        Spacer(modifier = Modifier.height(6.dp))
        
        Text(text = movie.title, modifier = Modifier.padding(start = 26.dp, end = 8.dp), color = Color.White, fontSize = 22.sp, maxLines = 1)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 12.dp, top = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            RatingBar(
                starsModifier = Modifier.size(18.dp),
                rating = movie.vote_average/2
            )

            Text(text = movie.vote_average.toString().take(3), modifier = Modifier.padding(start = 4.dp), color = Color.LightGray, fontSize = 22.sp, maxLines = 1)
        }
    }
}
