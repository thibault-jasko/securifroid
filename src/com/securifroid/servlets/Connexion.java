package com.securifroid.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Connexion extends HttpServlet {
	String resultat;
    Map<String, String> erreurs = new HashMap<String, String>();
    
	public static final String VUE = "/WEB-INF/connexion.jsp";
	public static final String CHAMP_EMAIL = "id";
    public static final String CHAMP_PASS = "pwd";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";
    public static final String ERR_CONNECTION = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button><h6>L\'adresse e-mail ou le mot de passe saisi est invalide.</h6></div>";
    public static final String ERR_MAILVIDE = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button><h6>Saisissez votre adresse e-mail.</h6></div>";
    public static final String ERR_MOTDEPASSEVIDE = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button><h6>Saisissez votre mot de passe.</h6></div>";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */
    	String email = request.getParameter( CHAMP_EMAIL );
        String motDePasse = request.getParameter( CHAMP_PASS );
      
        try {
            validationEmail( email );
            try {
                validationMotDePasse(motDePasse);
            } catch (Exception e) {
                /* Gérer les erreurs de validation ici. */
            	erreurs.put( CHAMP_PASS, e.getMessage() );
            }
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        	erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }
        
       /* try {
            validationMotDePasse(motDePasse);
        } catch (Exception e) {*/
            /* Gérer les erreurs de validation ici. */
       /* 	erreurs.put( CHAMP_PASS, e.getMessage() );
        }*/
        
        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    private void validationEmail( String email ) throws Exception {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( ERR_CONNECTION );
            }
        } else {
            throw new Exception( ERR_MAILVIDE );
        }
    }
    
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null && motDePasse.trim().length() != 0 ) {
            if (motDePasse!="coucou") {
                throw new Exception( ERR_CONNECTION );
            }
        } else {
            throw new Exception( ERR_MOTDEPASSEVIDE );
        }
    }
}
