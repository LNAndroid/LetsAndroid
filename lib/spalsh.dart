import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_myapp/main.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: "Demo",
      theme: ThemeData(
        brightness: Brightness.light,
        primaryColor: Colors.lightBlue[800],
        accentColor: Colors.cyan[600],
      ),
      home: new SplashScreen(),
      routes: <String, WidgetBuilder>{
        '/MyHomePage': (BuildContext context) => new MyHomePage()
      }
    );
  }
}


class SplashScreen extends StatefulWidget{
  @override
  createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {

  startTime() async {
    var _duration = new Duration(seconds: 3);
    return new Timer(_duration, navigationPage);
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Scaffold(
      /*body: new Center(
        child: new Image.asset('images/ic_splash_screen.jpg',fit: BoxFit.fill),
      ),*/
      body: new Container(
        decoration: new BoxDecoration(
          image: new DecorationImage(
              image: new AssetImage('images/ln_splash.jpg'),
              fit: BoxFit.fill
          )
        ),
      ),
    );
  }

  @override
  void initState(){
    super.initState();
    startTime();
  }

  void navigationPage() {
    Navigator
        .of(context)
        .pushReplacementNamed('/MyHomePage');
  }
}