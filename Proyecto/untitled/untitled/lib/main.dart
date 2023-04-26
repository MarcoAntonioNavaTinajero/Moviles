import 'dart:js';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:untitled/home.dart';
import 'Authentication.dart';
import 'firebase_options.dart';

//nuevas librerías
import 'package:go_router/go_router.dart'; //nuevo
import 'app_state.dart'; //nuevo
import 'package:provider/provider.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  //runApp(const MyApp());
  runApp(ChangeNotifierProvider(
    create: (context) => ApplicationState(),
    builder: ((context, child) => const MyApp()),
  ));
}

final _router = GoRouter(
    routes: [
      GoRoute(
          path: '/',
          builder: (context, state) => Consumer<ApplicationState>(
            builder: (context, appState, _) => DashboardScreen(
                loggedIn: appState.loggedIn,
                signOut: () {
                  FirebaseAuth.instance.signOut();
              },
            ),
          ),
        routes: [
          GoRoute(
            path: 'sign-in',
            builder: (context,state) =>
              Authentication(),
          ),
        ]
      )
    ]
);

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      routerConfig: _router,
    );
  }
}