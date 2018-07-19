import 'package:flutter/material.dart';
import 'package:flutter_myapp/HomeFragment.dart';
import 'package:flutter_myapp/AboutFragment.dart';
import 'package:flutter_myapp/ContactFragment.dart';

class MyHomePage extends StatefulWidget {

  final drawerItems = [
    new DrawerItem("Home", Icons.home),
    new DrawerItem("About", Icons.info),
    new DrawerItem("Contact Us", Icons.contacts)
  ];

  @override
  _MyHomePageState createState() => new _MyHomePageState();

}

class _MyHomePageState extends State<MyHomePage> {

  int _selectedDrawerIndex = 0;

  @override
  Widget build(BuildContext context) {

    var drawerOptions = <Widget>[];
    for (var i = 0; i < widget.drawerItems.length; i++) {
      var d = widget.drawerItems[i];
      drawerOptions.add(
          new ListTile(
            leading: new Icon(d.icon),
            title: new Text(d.title),
            selected: i == _selectedDrawerIndex,
            onTap: () => _onSelectItem(i),
          )
      );
    }

    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Flutter'),
      ),
      floatingActionButton: buildFloatingActionMenu(context),
      drawer: new Drawer(
        child: new ListView(
          children: <Widget>[
            new UserAccountsDrawerHeader(
                accountName: new Text("Sophia"),
                accountEmail: new Text("sophia@letsnurture.com"),
                currentAccountPicture: CircleAvatar(
                  backgroundImage: AssetImage('images/ic_splash_screen.jpg'),
                  radius: 45.0,
                ),
            ),
            new Column(children: drawerOptions)
          ],
        ),
      ),
      body: _getMenuScreen(_selectedDrawerIndex),
    );
  }


  _onSelectItem(int index) {
    setState(() => _selectedDrawerIndex = index);
    Navigator.of(context).pop(); // close the drawer
  }

  _getMenuScreen(int pos) {
    switch(pos){
      case 0:
        return new HomeFragment();

      case 1:
        return new AboutFragment();

      case 2:
        return new ContactFragment();
    }
  }

}



class DrawerItem {
  String title;
  IconData icon;
  DrawerItem(this.title, this.icon);
}

Widget buildFloatingActionMenu(BuildContext context) {
  return new FloatingActionButton(
    tooltip: 'Create',
    child: const Icon(Icons.add),
    backgroundColor: Theme.of(context).primaryColor,
    onPressed: _handleCreateCompany,
  );

}


void _handleCreateCompany() {

}

