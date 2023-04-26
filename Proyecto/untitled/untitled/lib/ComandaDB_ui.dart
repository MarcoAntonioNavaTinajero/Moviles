import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';



class addComanda extends StatefulWidget{
  addComanda ({Key? key, required this.orden}): super (key: key);
  List<String> orden = List.empty(growable: true);
  @override
  State<addComanda> createState() => _addComandaState();

}
class _addComandaState extends State<addComanda> {
  @override
  Widget build(BuildContext context)
  {
    return Material(
    child: TextButton(
      onPressed: (){
        print("->Guardando la orden..."+widget.orden.toString());
        CollectionReference ordendb= FirebaseFirestore.instance.collection('comanda');
        final now = DateTime.now();
        final FirebaseAuth firebaseAuth = FirebaseAuth.instance;
        ordendb.add({
            'user' : firebaseAuth.currentUser?.email,
            'diahora': now,
            'orden':{
              'descripcion': widget.orden.toList()
            },
          }).then((value) => print("Comanda agregada"))
        .catchError((error) => print("Fallo al intentar agregar la comanda: $error"));
      },
      child: Text('Guardar su pedido'),
    ),
    );
  }
}