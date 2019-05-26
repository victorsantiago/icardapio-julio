<html>
<head>
<title>Login</title>
</head>
<!--  target="/${subdomain}" -->
<body onload='document.loginForm.j_username.focus();'>
<h3>Login no tenant: ${subdomain}</h3>
 
<% String errorString = (String)request.getAttribute("error");
		if(errorString != null && errorString.trim().equals("true")){
			out.println("Incorrect login name or password. Please retry using correct login name and password.");
		}
%>
    <form name='f' action="../j_spring_security_check" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>