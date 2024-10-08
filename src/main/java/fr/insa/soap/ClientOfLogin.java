package fr.insa.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;

import fr.insa.soap.wsdltojava.LoginService;
import fr.insa.soap.wsdltojava.LoginServiceWS;


public class ClientOfLogin {

    public static void main(String[] args) throws MalformedURLException {
        //@ service web
        final String adresse="http://localhost:8089/analyzer";

        //création de l'URL
        final URL url=URI.create(adresse).toURL();

        //instanciation de l'image du service
        final LoginService service = new LoginService(url);

        //création du proxy (en utilisant le portType) pour l'appel du service
        final LoginServiceWS port = service.getPort(LoginServiceWS.class);

        String username="user";
        String password="pwd";

        //appel de la méthode login via le port
        System.out.println("Votre login est " + port.login(username, password));
    }
}
