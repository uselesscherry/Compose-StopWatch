# Compose-StopWatch


StopWatch is a simple app, built with Jetpack Compose. The goal of the sample is to
showcase implementing DI and async programming with Coroutines. Also UI State survives Config Changes (screen rotation).

### YouTube tutorial 👉🏼  <a href="https://youtu.be/AJdvbqKNTxc" target="blank"><img  src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/YouTube_Logo_2017.svg/1920px-YouTube_Logo_2017.svg.png"  height="18" /></a>


<img src="screenshots/Stopwatch_thumb.png"/>


### What I used in this project:

- Jetpack Compose
- DI
- Coroutines

### Adaptivity that depends on screen orientation:

``` kotlin
    val config = LocalConfiguration.current
    val isPortrait by remember { mutableStateOf(config.orientation == Configuration.ORIENTATION_PORTRAIT) }

                Box {
                    Button(
                        modifier = Modifier.align(
                            if (isPortrait) Alignment.TopCenter
                            else Alignment.CenterStart
                        )
                    ) { Text(text = "Start") }

                    Button(
                        modifier = Modifier.align(Alignment.Center)
                    ) { Text(text = "Stop") }

                    Button(
                        modifier = Modifier.align(
                            if (isPortrait) Alignment.BottomCenter
                            else Alignment.CenterEnd
                        )
                    ) { Text(text = "Reset") }
                }
```
