<html>
	<body>
		<pre>
			<%
	         out.println("\nYour IP address is " + request.getRemoteAddr());
	         out.println("Server address is " + request.getServerName());
	      	%>
		</pre>
	</body>
</html>