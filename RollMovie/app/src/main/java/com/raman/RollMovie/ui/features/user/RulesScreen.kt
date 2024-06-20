package com.raman.RollMovie.ui.features.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.raman.RollMovie.R
import com.raman.RollMovie.ui.component.detail.UseFulButton
import com.raman.RollMovie.ui.theme.primaryColor

@Composable
fun RulesScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.White)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(top = 10.dp)
        ) {

            Spacer(modifier = Modifier.width(4.dp))

            UseFulButton(image = R.drawable.ic_arrow_back) {
                navController.popBackStack()
            }

            Text(
                text = "Rules of RollMovie",
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

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Text(
                text = "هموطن گرامی با سلام\n ما در تیم رول فیلم قصد داریم به شما خدماتی جهت سرگرمی ارائه دهیم.\n پس لزا هیچ نیتی جهت دزدیده شدن اطلاعات شما نیست و به شما قول می دهیم اطلاعاتتان در امنیت کامل باشد \n .و شما هم اجازه کپی رایت و سوء استفاده از این برنامه را نخواهید داشت \n .چنانچه هرگونه سوءاستفاده ای از این برنامه شود پیگرد قانونی داشته و شکایت خواهد شد \n در این برنامه هیچ اطلاعاتی نطیر کدملی و شماره تلفن ذخیره نمی شود و درخواستی برای گرفتن این اطلاعات از شما نخواهیم گرفت\n امیدواریم با رضایت هرچه تمام تر شما در جهت بهبود برنامه گام برداریم\n  با احترام برنامه رول فیلم 🙌",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 2.dp, end = 2.dp)
            )
        }

    }

}