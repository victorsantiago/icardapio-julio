<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Login page: ${subdomain}</title>
		<link href="../resources/bootstrap/css/bootstrap.css" rel="stylesheet">
		<link href="../resources/bootstrap/css/app.css" rel="stylesheet">
		<link href="../resources/bootstrap/img/favicon.ico" rel="icon" type="image/x-icon">
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

	</head>
<body>
<div id="mainWrapper">
			<div class="login-container">
				<div class="login-card">
					<div class="login-form">
					
						<f:form modelAttribute="user" method="post" action="../${subdomain}/loginauth">
						
							<c:if test="${error != null && error == true}">
								<div class="alert alert-danger">
									<p>Invalid username or password.</p>
								</div>
							</c:if>
							<fieldset>
								<div class="input-group input-sm">			
								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
								<f:input path="name" type="text" class="form-control" placeholder="Username"/>
								</div>
								<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>			
								<f:input path="password" type="text" class="form-control" placeholder="Password"/>
								</div>
							</fieldset>
							<f:button class="btn btn-block btn-primary btn-default">Log in</f:button>
						</f:form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>