/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpanier;

import java.sql.SQLException;
import models.Article;
import models.Command;
import models.User;
import services.CRUDReclamation;
import services.CRUDReponse;
import services.ServiceArticle;
import services.ServiceBasket;
import services.ServiceUser;
import services.ServiceCommand;

/**
 *
 * @author medmo
 */
public class GestionPanier {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        //Command c =new Command(4,"Livré");
        
        ServiceArticle sa = new ServiceArticle();
        //System.out.println(sa.afficherArticle()); 
        //sa.ajouterArticle(new Article("iezugce", "iueh", 56, "iuhef.r", 5, "uiohv", 32));
        //System.out.println(sa.afficherArticles());
        //System.out.println(sa.getArticleByCategorie());
        //sa.supprimerArt(4);
        //System.out.println(sa.get(1));
        
        
        ServiceUser su = new ServiceUser();
        //System.out.println(su.get(32));
        //su.supprimerUtilisateur(38);
        //System.out.println(su.getByEmail("ismail1@gmail.com"));
        //su.afficherUtilisateur();
        //su.ajouterUser(new User("uhuh", "nn@ieh.eef", "ihe.e", "jjbn", "iknjkn", "injn", 5646, 556));
        //su.modifierUser(new User(39, "uhuh", "nn@ieh.eef", "ihe.e", "jjbn", "iknjkn", "injn", 5646, 333333));
        //System.out.println(su.login("ismail.elgharnougui@esprit.tn", "123456")); 
        
        
        su.login("ismail.elgharnougui@esprit.tn", "123456");
        //Article a = new Article(19,26 , "mod2", "mod2", 12, "url2");
        //sa.modifierArticle(a);
        //System.out.println( sa.get(2));
        //sa.afficherArticles();
        //sa.getArticles(12);
        //sa.ajouter(new Article(12,"Article","50*60",45,"czdzdzdzd"));
        //sa.supprimerArticle(12, 8);
        
        ServiceUser scl = new ServiceUser();
        
        //scl.modifierUser(new User(30, "nom", "prenom", "email", "address", "role", "pass"));
        //scl.afficherUtilisateur();
        //scl.supprimerUtilisateur(9);
        //System.out.println(scl.get(410));
        //System.out.println(scl.getByEmail("mokl@gmail.cim"));
        //scl.ajouterUser(new User("moklll", "mplll", "mokh11@gmail.com", "Mokhtar1234", "Client", "Manzel Bourguiba"));
        //System.out.println(scl.login("mokh11@gmail.com", "Mokhtar1234"));//scl.login("mokh11@gmail.com", "Mokhtar1234");
        
        ServiceBasket sb = new ServiceBasket();
        //sb.ajouter(39,1);
        //sb.vider(39);
        //sb.supprimerArticle(36,1);
        //System.out.println(sb.get(39));
        
        ServiceCommand sc = new ServiceCommand();
        //sc.ajouter(new Command(32, 62, "ft", "uub", "ygyu"));
        //sc.supprimer(3);
        //System.out.println(sc.recupererCommClient(32));      
        //sc.afficherCommands();
        sc.modifierCommand(new Command(1, "check"));   
        
        CRUDReclamation rec = new CRUDReclamation();
        //rec.afficherReclamation();
        
        CRUDReponse rep = new CRUDReponse();
        //rep.afficherReponse();
    }
    
}