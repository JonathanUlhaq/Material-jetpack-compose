package com.belajar.materialjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belajar.materialjetpackcompose.data.DataSource
import com.belajar.materialjetpackcompose.model.DogModel
import com.belajar.materialjetpackcompose.ui.theme.MaterialJetpackComposeTheme
import com.belajar.materialjetpackcompose.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true,
        showSystemUi = true)
@Composable
fun MaterialJetpackComposePreview() {
    MaterialJetpackComposeTheme(darkTheme = false) {
        DogList(list = DataSource().loadData())
    }
}

@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.primary)) {
        Text(text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1,
            color = Color.Black,
            modifier = Modifier.padding(12.dp))
    }
}

@Composable
fun DogItem(model:DogModel,modifier:Modifier = Modifier) {

    var expand by remember {
        mutableStateOf(false)
    }

   Card(modifier = Modifier
       .padding(8.dp)
       .fillMaxWidth(),
        elevation = 4.dp,
        shape = Shapes.large){

      Column(
          modifier =  Modifier
              .animateContentSize(
                  animationSpec = spring(
                      dampingRatio = Spring.DampingRatioMediumBouncy,
                      stiffness = Spring.StiffnessLow
                  )
              )
      ) {

          Row(modifier = Modifier.padding(5.dp)) {
              Image(painter = painterResource(id = model.gambar),
                  contentDescription = stringResource(id = model.tulisan),
                  modifier = Modifier
                      .absolutePadding(0.dp, 0.dp, 20.dp, 0.dp)
                      .size(64.dp)
                      .clip(RoundedCornerShape(50)),
                  contentScale = ContentScale.Crop)
              DogDescription(dogName = model.tulisan, dogAge = model.umur )
              Spacer(modifier = Modifier.weight(1f))
              DogItemButton(
                  expand = expand,
                  onClick = {expand = !expand})

          }

          if(expand) {
              DeskripsiHobi(dogHobi = model.hobi)
          }

      }

   }
}

@Composable
fun DeskripsiHobi(@StringRes dogHobi:Int) {
    Column(modifier = Modifier.padding(
        start = 16.dp,
        bottom = 16.dp,
        top = 8.dp,
        end = 16.dp
    )) {
        Text(text = stringResource(id = R.string.about),
            style = MaterialTheme.typography.h3)

        Text(text = stringResource(id = dogHobi),
            style = MaterialTheme.typography.body1)
    }
}

@Composable
fun DogDescription(dogName:Int,dogAge:Int,modifier:Modifier = Modifier) {
    Column {
        Text(text = stringResource(id = dogName),
            modifier = modifier
                .absolutePadding(0.dp,0.dp,0.dp,5.dp),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h2)
        Text(text = stringResource(id = R.string.years_old,dogAge),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.body1)
        
    }
}

@Composable
fun DogItemButton(
    expand:Boolean,
    onClick:() -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(imageVector = if(expand) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(id = R.string.expand_button_content_description),
            tint = MaterialTheme.colors.secondary)
    }
}

@Composable
fun DogList(list:List<DogModel>) {
    Scaffold(topBar = {
        TopBar()
    }) {
        LazyColumn(content = {
            items(list) {
                DogItem(model = it)
            }
        }, modifier = Modifier
            .background(MaterialTheme.colors.background))
    }
}