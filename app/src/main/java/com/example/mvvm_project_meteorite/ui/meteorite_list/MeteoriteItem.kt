package com.example.mvvm_project_meteorite.ui.meteorite_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BlurCircular
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_project_meteorite.data.Meteorite

@Composable
fun MeteoriteItem(
    meteorite: Meteorite, modifier: Modifier = Modifier
) {
    Card(
            backgroundColor = Color.White,
            elevation = 5.dp,
            shape = RoundedCornerShape(20),
            modifier = Modifier.padding(10.dp)
    ) {
        Row(
                modifier = modifier, verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
            ) {
                Row() {
                  Box(contentAlignment = Alignment.Center ,modifier = Modifier.weight(0.33f))  {
                      Icon(imageVector = Icons.Default.BlurCircular,
                              contentDescription = "Blur Meteorite Icon",
                      modifier = Modifier.size(70.dp))
                  }
                    Box(contentAlignment = Alignment.CenterStart ,modifier = Modifier.weight(0.67f).fillMaxSize()) {
                        Text(
                                text = meteorite.name,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))

//                Text(
//                        text = "Id: ${meteorite.id}",
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(vertical = 16.dp)
//                )
//
//                Spacer(modifier = Modifier.width(16.dp))
//
//                Text(
//                        text = "Mass: ${meteorite.mass}",
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(vertical = 16.dp)
//                )
//
//                Spacer(modifier = Modifier.width(10.dp))
//
//                Text(
//                        text = "Fall: ${meteorite.fall}",
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(vertical = 16.dp)
//                )

            }
        }

    }
    Spacer(modifier = Modifier.height(10.dp))
}