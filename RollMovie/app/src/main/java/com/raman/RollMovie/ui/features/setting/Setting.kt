package com.raman.RollMovie.ui.features.setting

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.browser.browseractions.BrowserActionsIntent.BrowserActionsUrlType
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.component.detail.UseFulButton
import com.raman.RollMovie.ui.theme.Shapes
import com.raman.RollMovie.utils.remote.ApiConstants

@Composable
fun SettingScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val context = LocalContext.current
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(top = 10.dp)
        ) {

            Spacer(modifier = Modifier.width(6.dp))

            UseFulButton(image = R.drawable.ic_arrow_back) {
                navController.popBackStack()
            }

            Text(
                text = "Setting",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            )

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                .clip(Shapes.medium),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(4.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {

            SettingBar(title = "Source code of RollMovie", image = R.drawable.ic_github) {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(ApiConstants.Utils.SOURCE_CODE_URL))
                context.startActivities(arrayOf(intent))
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(start = 116.dp),
                thickness = 1.2.dp,
                color = Color.Gray
            )

            SettingBar(title = "Version : 1.0.0", image = R.drawable.ic_attention) {}

            Spacer(modifier = Modifier.height(10.dp))

        }

    }
}

@Composable
private fun SettingBar(
    title: String,
    image: Int,
    onItemClicked: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 10.dp, start = 14.dp, end = 6.dp)
            .clickable { onItemClicked.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(44.dp)
                .padding(start = 4.dp)
        )

        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 16.dp)
        )

    }

}