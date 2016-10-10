<%@page import="org.json.JSONObject"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="BO.clientesBO"%>
<%@page import="general.clientes"%>
<%@ page language="java" contentType="application/json" %>
<%
  StringBuilder sb = new StringBuilder();
  BufferedReader br = request.getReader();
  
  String str = null;
  while ((str = br.readLine()) != null) {
    sb.append(str);
  }
//  Thread.sleep(2000);
  JSONObject jObj = new JSONObject(sb.toString());

  int pagina = Integer.parseInt(jObj.getString("pagina"));
//  int pagina = 1;
  String json="";
  clientesBO pai = new clientesBO();
  json = pai.cargarClientes(pagina);
  out.println(json);

%>