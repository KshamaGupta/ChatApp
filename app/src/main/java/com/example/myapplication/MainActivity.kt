package com.example.myapplication

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.DataSource
import com.example.myapplication.model.Course
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}
@Composable
fun CourseApp(){
    CourseListApp()
}

@Composable
fun CourseListApp(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = spacedBy(3.dp),
        horizontalArrangement = spacedBy(3.dp),
         modifier= Modifier
    ){
        items(DataSource.l) { topic ->
            CourseCard(topic)
        }
    }
}

@Composable
fun CourseCard(course:Course,modifier: Modifier=Modifier){
            Card(modifier= Modifier
                .background(color = Color.Gray).padding(8.dp)
                .border(2.dp, color = Color.Black), elevation = 2.dp) {
                Row() {
                    Image(painter = painterResource(id = course.drawbleId), contentDescription ="",
                        modifier= Modifier
                            .size(68.dp,68.dp).aspectRatio(1f), contentScale = ContentScale.Crop)
                    Column(Modifier.padding(3.dp)) {
                        Text(text = stringResource(id = course.titleID),modifier=Modifier.align(Alignment.CenterHorizontally))
                        Row() {
                            Icon(
                                painter = painterResource(id = course.iconId),
                                contentDescription = ""
                            )
                            Text(text = stringResource(id = course.ratingId),modifier=Modifier.padding(4.dp))
                        }
                    }
                }
            }
}

