<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="it.quizzy.logiclayer.manager.QuizManager"%>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>

<%
DocenteManager dmSession = (DocenteManager)session.getAttribute("dm");
if(dmSession==null){
	response.sendRedirect("/home/login.jsp");
}else{
	if(!dmSession.isLogged()){
		response.sendRedirect("/home/login.jsp");
	}else{
		try{
			StringBuilder sb = new StringBuilder();
		    BufferedReader reader = request.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		      sb.append(line);
		    }
		    String requestBody = sb.toString();
		    JSONObject jo = new JSONObject(requestBody);
		    String titolo = (String) jo.getString("titolo");
			if(titolo=="")
				throw new IllegalArgumentException("Unexpected value");
			
		    QuizManager qm = new QuizManager(dmSession.addQuiz(titolo));
		    for(Object o : jo.getJSONArray("domande")){
		        if ( o instanceof JSONObject ) {
		        	JSONObject d = (JSONObject) o;
		        	if(d.getString("domanda")=="")
						throw new IllegalArgumentException("Unexpected value");
		        	
		        	if(d.getString("rispostaCorretta")=="")
						throw new IllegalArgumentException("Unexpected value");
		        	
		            switch(d.getInt("tipo")){
		            case 0: qm.aggiungiDomandaVeroFalso(d.getString("domanda"), d.getString("rispostaCorretta"));
		            	break;
		            case 1: List<String> risposte=new ArrayList<>();
		            		JSONArray rispJson = d.getJSONArray("risposte");
		            		for(int i =0 ; i<rispJson.length();i++){
		            			if(rispJson.getString(i)=="")
		    						throw new IllegalArgumentException("Unexpected value");
		            			risposte.add(rispJson.getString(i));
		            			
		            		}
		            		qm.aggiungiDomandaRispostaMultipla(d.getString("domanda"), d.getString("rispostaCorretta"), risposte);
		            			
		            	break;
		            default: throw new IllegalArgumentException("Unexpected value");
		            }
		        }
		    }
		}catch(Exception e){
			response.sendError(400);
		}
	}
}
%>