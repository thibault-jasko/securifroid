<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
	 <head>
        <meta charset="utf-8">
        <title>Sécurifroid</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
        <link href="inc/signin.css" rel="stylesheet">
        <link href="inc/css/bootstrap.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="/twitter-bootstrap/twitter-bootstrap-v2/js/bootstrap-modal.js"></script>
    </head>
	<body>
		<div>
		    <form method="post" action="connexion" class="form-signin" role="form">
		    	<h2>SÉCURIFROID</h2>
		     	<h2 class="form-signin-heading"><small>Connectez-vous à votre espace personnel.</small></h2>
		        <div class="well">
			        <input name="id" type="email" class="form-control" placeholder="Adresse e-mail" required autofocus>
			        <input name="pwd" type="password" class="form-control" placeholder="Mot de passe" required>
			        ${erreurs['id']}
			        ${erreurs['pwd']}
			        <label class="checkbox">
			          <input type="checkbox" value="remember-me"> Rester connecté
			        </label>
			        <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
		      	</div>
		    </form>
    	</div>
	</body>
</html>