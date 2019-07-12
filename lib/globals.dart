library my_prj.globals;
import 'package:flutter/material.dart';
import 'package:flutter_charts/flutter_charts.dart';

bool isErrorLogin = false;
String _authHint = '';

void set_auth_err(String a){
  //RegExp exp = new RegExp(r"\((\w+)\)");
  //_authHint=exp.stringMatch(a);
  _authHint = a;
}
String get_auth_err(){
  return _authHint;
}
void set_err_bool(bool val){
  isErrorLogin=val;
}
bool get_err_bool(){
  return isErrorLogin;
}


////Chart Stuff