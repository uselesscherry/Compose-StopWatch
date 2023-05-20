# Compose-StopWatch


StopWatch is a simple app, built with Jetpack Compose. The goal of the sample is to
showcase implementing DI and async programming with Coroutines. Also UI State survives Config Changes (screen rotation).


<img src="screenshots/Stopwatch_thumb.png"/>


### What I used in this project:

- Jetpack Compose
- DI
- Coroutines

## Count animation based on a [`tutorial`](https://youtu.be/07ZdBCyh7sc)

<img src="screenshots/timer-animation.gif" height = "100" />


### Half-rounded buttons 

<img src="screenshots/buttons.png" height = "100" align = "end" />


``` kotlin
   
   StopwatchButton(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStartPercent = 100,
                        bottomStartPercent = 100
                    )
                ),
            icon = Icons.Rounded.PlayArrow
        )
   
```
