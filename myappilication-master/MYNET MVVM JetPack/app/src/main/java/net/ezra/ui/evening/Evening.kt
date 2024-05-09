package net.ezra.ui.evening


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_EVENING
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_PRODUCTSCREEN
import net.ezra.navigation.ROUTE_SIGNUP
import androidx.compose.ui.tooling.preview.Preview as Preview1

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EveningScreen(navController: NavHostController) {
    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {

                    Text(text = "MYNET",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )



                    // Text(text = stringResource(id = R.string.apen))
                },
                navigationIcon = @Composable {
                    if (!isDrawerOpen) {
                        androidx.compose.material3.IconButton(onClick = { isDrawerOpen = true }) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }
                    }
                },

                actions = {
                    androidx.compose.material3.IconButton(onClick = {
                        navController.navigate(ROUTE_SIGNUP) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,


                    )

            )
        },

        content = @Composable {

            Box(

                modifier = Modifier
                    .padding(top = 70.dp)
                    .fillMaxSize()
                    .background(color = Color.LightGray)

                    .clickable {
                        if (isDrawerOpen) {
                            isDrawerOpen = false
                        }
                    }
            )

            {
                Card (modifier = Modifier
                    .height(200.dp)
                    .width(500.dp)
                    .padding(10.dp),
                    colors = CardDefaults.cardColors(Color(0Xffe7351b )),
                    elevation = CardDefaults.cardElevation(10.dp)


                ){
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.mo),
                            contentDescription = "germany",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "favorite",
                            tint = Color.Red,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(10.dp)
                        )

                        Text(text = "NAIROBI", color = Color.Yellow, fontSize = 30.sp, textAlign = TextAlign.End)




                    }
                }





            }











        })


    net.ezra.ui.evening.AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false })









}

@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }

    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    @Composable
    fun SocialMediaIcon() {

    }
    androidx.compose.material3.Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp),
        color = Color.White,
        // color = Color.LightGray,
//        elevation = 16.dp
    ) {


        val mContext = LocalContext.current
        val navController: NavHostController
        Column {
//            Text(
//                text = "Drawer Item 1"
//
//            )
//            Text(
//                text = "Drawer Item 2"
//            )
//            Text(
//                text = "Drawer Item 3",
//                modifier = Modifier.clickable {  }
//            )


            Spacer(modifier = Modifier.height(16.dp))






            OutlinedButton(
                onClick = {

                    val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Icon(imageVector = Icons.Default.Send, "", tint = Color.White)
                Text(text = "Mpesa", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    if (cameraIntent.resolveActivity(mContext.packageManager) != null) {
                        mContext.startActivity(cameraIntent)
                    } else {
                        println("Camera app is not available")
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Icon(imageVector = Icons.Default.AddCircle, "", tint = Color.White)
                Text(text = "Camera", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val smsIntent = Intent(Intent.ACTION_SENDTO)
                    smsIntent.data = "smsto:0769184414".toUri()
                    smsIntent.putExtra("sms_body", "Hello Madul,how was your day?")
                    mContext.startActivity(smsIntent)


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {

                Icon(imageVector = Icons.Default.MailOutline, "", tint = Color.Black)
                //Text(text = "Sms", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val callIntent = Intent(Intent.ACTION_DIAL)
                    callIntent.data = "tel:0769184414".toUri()
                    mContext.startActivity(callIntent)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {

                Icon(imageVector = Icons.Default.Call, "", tint = Color.Black)
                //Text(text = "Call", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("maxkuol38@gmail.com"))
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Welcome to the Business email address")
                    mContext.startActivity(shareIntent)


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {

                Icon(imageVector = Icons.Default.Email, "", tint = Color.Black)
                //Text(text = "email", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {

                Icon(imageVector = Icons.Default.Share, "dd", tint = Color.Black)
                //Text(text = "Share", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = stringResource(id = androidx.compose.ui.R.string.range_end))

        }

    }
}











@Preview1(showBackground = true)
@Composable
fun PreviewLight() {
    EveningScreen(rememberNavController())
}

