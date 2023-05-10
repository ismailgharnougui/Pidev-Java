/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx;
 
import services.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.User;

/**
 * FXML Controller class
 *
 * @author medmo
 */
public class GuiLoginController implements Initializable {
    public static User user = new User();

    @FXML
    private ImageView btnReturn;
    @FXML
    private AnchorPane bord;
    @FXML
    private Button btnLogin;
    @FXML
    private Label erreur;
    @FXML
    private TextField passwordInput;
    @FXML
    private TextField emailInput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void returnTo(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GuiHome.fxml"));
        try {
            Parent root = loader.load();
            bord.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void login(ActionEvent event) throws SQLException {
        ServiceUser su = new ServiceUser();
        
        String email = emailInput.getText();
        String password = passwordInput.getText();
        
        user = su.login(email, password);
        if (user == null){
            erreur.setText("Email ou mot de passe incorrecte");
        }
        else{  System.out.println("connected");
        if("client".equals(user.getRole())){
              goTo("GuiArticles");       
        }
         /*if("Artiste".equals(user.getRole())){
             goTo("GuiArticleVendeur");
        }*/
          if("admin".equals(user.getRole())){
              goTo("GuiAdmin");
        }
           
            
        }
    }
    
    private void goTo(String view){
         FXMLLoader loader = new FXMLLoader(getClass().getResource(view+".fxml"));
        try {
            Parent root = loader.load();
            bord.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
