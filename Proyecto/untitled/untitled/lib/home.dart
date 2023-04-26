import 'package:firebase_auth/firebase_auth.dart'
hide EmailAuthProvider, PhoneAuthProvider;  // new
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:untitled/Authentication.dart';
import 'app_state.dart';
import 'ComandaDB_ui.dart';
import 'package:provider/provider.dart'; //nuevo



class DashboardScreen extends StatefulWidget {
  DashboardScreen({Key? key, required this.loggedIn, required this.signOut}): super(key: key);
  final bool loggedIn;
  final void Function() signOut;
  final List<String> orden = List.empty(growable: true);

  @override
  State<DashboardScreen> createState() => _DashboardScreenState();
}



class _DashboardScreenState extends State<DashboardScreen> {
  @override
  Widget build(BuildContext context) {
    if (this.widget.loggedIn) {
      return Scaffold(
appBar: AppBar(
  title: Text('La Pizza de Don Cangrejo'),
),
          body:
          ListView(
    children: <Widget>[

      Row(
        children: [
          InkWell(
            onTap: (){
              widget.orden.add('Champiñones');
              final snackBar = SnackBar(
                backgroundColor: Colors.blueAccent,
                content: Row(
                  children: <Widget>[
                    // add your preferred icon here
                    Icon(
                      Icons.add,
                      color: Colors.white,
                    ),
                    // add your preferred text content here
                    Text('Champiñones'),
                  ],
                ),
                action: SnackBarAction(
                  label: 'Cancelar',
                  textColor: Colors.white,
                  onPressed: () {
                    widget.orden.remove('Champiñones');
                    print("\n orden: \n");
                    print(widget.orden);
                    // Some code to undo the change.
                  },
                ),
                duration: Duration(milliseconds: 3000),
              );
              print("\n orden: \n");
              print(widget.orden);
              // Find the ScaffoldMessenger in the widget tree
              // and use it to show a SnackBar.
              ScaffoldMessenger.of(context).showSnackBar(snackBar);
            },
            child: Ink.image(
              image: AssetImage('images/pizzachampi.webp'),height:100,
                width: 100,
                fit: BoxFit.cover,
              ),
            ),
          Column(
            children: [
              Padding(
                  padding: const EdgeInsets.all(16.0),
                child: Container(
                  child: Align(
                    alignment: Alignment.topLeft,
                    child: Column(
                      children: [
                        Text('Pizza Champiñones',
                        style: Theme.of(context).textTheme.headlineMedium),
                        Text('Rica pizza de champiñones',
                            style: Theme.of(context).textTheme.bodyLarge),
                      ],
                    ),
                  ),
                ),
              ),
            ],
          ),
        ],
      ),
      Row(
        children: [
          InkWell(
            onTap: (){
              widget.orden.add('Jitomate');
              final snackBar = SnackBar(
                backgroundColor: Colors.blueAccent,
                content: Row(
                  children: <Widget>[
                    // add your preferred icon here
                    Icon(
                      Icons.add,
                      color: Colors.white,
                    ),
                    // add your preferred text content here
                    Text('Jitomate'),
                  ],
                ),
                action: SnackBarAction(
                  label: 'Cancelar',
                  textColor: Colors.white,
                  onPressed: () {
                    widget.orden.remove('Jitomate');
                    print("\n orden: \n");
                    print(widget.orden);
                    // Some code to undo the change.
                  },
                ),
                duration: Duration(milliseconds: 3000),
              );
              print("\n orden: \n");
              print(widget.orden);
              // Find the ScaffoldMessenger in the widget tree
              // and use it to show a SnackBar.
              ScaffoldMessenger.of(context).showSnackBar(snackBar);
            },
            child: Ink.image(
              image: AssetImage('images/pizzajitomate.png'),height:100,
              width: 100,
              fit: BoxFit.cover,
            ),
          ),
          Column(
            children: [
              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Container(
                  child: Align(
                    alignment: Alignment.topLeft,
                    child: Column(
                      children: [
                        Text('Pizza Jitomate',
                            style: Theme.of(context).textTheme.headlineMedium),
                        Text('Excelente pizza de jitomate',
                            style: Theme.of(context).textTheme.bodyLarge),
                      ],
                    ),
                  ),
                ),
              ),
            ],
          ),
        ],
      ),
      Row(
        children: [
          InkWell(
            onTap: (){
              widget.orden.add('Peperoni');
              final snackBar = SnackBar(
                backgroundColor: Colors.blueAccent,
                content: Row(
                  children: <Widget>[
                    // add your preferred icon here
                    Icon(
                      Icons.add,
                      color: Colors.white,
                    ),
                    // add your preferred text content here
                    Text('Peperoni'),
                  ],
                ),
                action: SnackBarAction(
                  label: 'Cancelar',
                  textColor: Colors.white,
                  onPressed: () {
                    widget.orden.remove('Peperoni');
                    print("\n orden: \n");
                    print(widget.orden);
                    // Some code to undo the change.
                  },
                ),
                duration: Duration(milliseconds: 3000),
              );
              print("\n orden: \n");
              print(widget.orden);
              // Find the ScaffoldMessenger in the widget tree
              // and use it to show a SnackBar.
              ScaffoldMessenger.of(context).showSnackBar(snackBar);
            },
            child: Ink.image(
              image: AssetImage('images/pizzapeperoni.png'),height:100,
              width: 100,
              fit: BoxFit.cover,
            ),
          ),
          Column(
            children: [
              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Container(
                  child: Align(
                    alignment: Alignment.topLeft,
                    child: Column(
                      children: [
                        Text('Pizza Peperoni',
                            style: Theme.of(context).textTheme.headlineMedium),
                        Text('Delicia de pizza de peperoni',
                            style: Theme.of(context).textTheme.bodyLarge),
                      ],
                    ),
                  ),
                ),
              ),
            ],
          ),
        ],
      ),
      Center(
          child:
          Column(
            children: [
              Row(
                children: [
                  Padding(
                    padding: const EdgeInsets.only(left: 24, bottom: 8),
                    child: TextButton(
                      onPressed: () {
                        widget.signOut();
                      },
                      child: const Text('Cerrar sesión'),
                    ),
                  ),
                ],
              )
            ],
          )
      ),
    ],
  )
      );
    }else{
      return Authentication();
    }
  }
}



