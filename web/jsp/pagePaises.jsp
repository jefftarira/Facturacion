<%@page import="org.json.JSONObject"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="BO.paisesBO"%>
<%@page import="general.paises"%>
<%@ page language="java" contentType="application/json" %>
<%
  StringBuilder sb = new StringBuilder();
  BufferedReader br = request.getReader();
  
  
  //Thread.sleep(1000);
  
  String str = null;
  while ((str = br.readLine()) != null) {
    sb.append(str);
  }
  
  JSONObject jObj = new JSONObject(sb.toString());

  int pagina = Integer.parseInt(jObj.getString("pagina"));
  System.out.println(pagina);
  String json="";
  paisesBO pai = new paisesBO();
  json = pai.cargarPaises(pagina);
  out.println(json);

%>