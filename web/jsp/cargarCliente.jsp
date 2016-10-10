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
  
  JSONObject jObj = new JSONObject(sb.toString());
   
//  Thread.sleep(2000);
  int idCliente = Integer.parseInt(jObj.getString("id"));
  String json="";
  clientesBO cli = new clientesBO();
  json = cli.cargarCliente(idCliente);
  out.println(json);

%>