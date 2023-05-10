/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author medmo
 */
public class ServiceUser implements InterfaceServiceUser {

    Statement ste = null;
    Connection conn = MyConnection.getInstance().getConnection();

    @Override
    public User get(int id) {
        try {
            String req = "SELECT * FROM `utilisateur` WHERE id_user = ?";
            PreparedStatement pste = conn.prepareStatement(req);
            pste.setInt(1, id);

            ResultSet result = pste.executeQuery();
            result.next();
            User resultUser = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),result.getString(7), result.getInt(8), result.getInt(9));
            return resultUser;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public boolean ajouterUser(User user) throws SQLException {
        // Vérifier si l'adresse e-mail de l'utilisateur n'existe pas déjà dans la base de données
        String selectSql = "SELECT COUNT(*) FROM utilisateur WHERE mail = ?";
        try (PreparedStatement selectStatement = conn.prepareStatement(selectSql)) {
            selectStatement.setString(1, user.getEmail());
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count > 0) {
                return false;
            }
        }

        // Calculer le hachage du mot de passe de l'utilisateur
        //byte[] passwordHash = hashPassword(user.getPass());
        

        // Insérer l'utilisateur dans la base de données avec le hachage du mot de passe
        String insertSql = "INSERT INTO utilisateur (password, mail, nom, prenom, adresse, role, cin, numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
            insertStatement.setString(1, user.getPass());
            insertStatement.setString(2, user.getEmail());
            insertStatement.setString(3, user.getNom());
            insertStatement.setString(4, user.getPrenom());
            insertStatement.setString(5, user.getAddress());
            insertStatement.setString(6, user.getRole());
            insertStatement.setInt(7, user.getCin());
            insertStatement.setInt(8, user.getNumero());

            insertStatement.executeUpdate();
        }
        return true;
    }

    private static byte[] hashPassword(String password) {
        // Generate a salt using jBCrypt's default strength (10)
        String salt = BCrypt.gensalt();

        // Hash the password using the generated salt and the bcrypt algorithm
        return BCrypt.hashpw(password, salt).getBytes();
    }

    @Override
    public void modifierUser(User user) throws SQLException {
    PreparedStatement stmt = null;

    try {
        // 1. Create a PreparedStatement with the UPDATE query
        stmt = conn.prepareStatement("UPDATE utilisateur SET password=?, mail=?, nom=?, prenom=?, adresse=?, role=?, cin=?, numero=? WHERE id_user=?");
        
         // Calculer le hachage du mot de passe de l'utilisateur
        //byte[] passwordHash = hashPassword(user.getPass());
        
        // 2. Set the parameters for the PreparedStatement
        stmt.setString(1, user.getPass());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getNom());
        stmt.setString(4, user.getPrenom());
        stmt.setString(5, user.getAddress());
        stmt.setString(6, user.getRole());
        stmt.setInt(7, user.getCin());
        stmt.setInt(8, user.getNumero());
        stmt.setInt(9, user.getId());

        // 3. Execute the PreparedStatement
        stmt.executeUpdate();
    } finally {
    }
}



    public User getByEmail(String email) {
        try {
            String req = "SELECT * FROM `utilisateur` WHERE mail = ?";
            PreparedStatement pste = conn.prepareStatement(req);
            pste.setString(1, email);

            ResultSet result = pste.executeQuery();
            result.next();
            User resultUser = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),result.getString(7), result.getInt(8), result.getInt(9));
            return resultUser;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public User login(String email, String password) throws SQLException {
        // Get the user with the given email from the database
        // tchouf email mawjoud f base walle sinn trajaa nul
        String selectSql = "SELECT * FROM utilisateur WHERE mail = ?";
        try (PreparedStatement selectStatement = conn.prepareStatement(selectSql)) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("Email inexistante");
                // User not found
                return null;
            }
            // tekho pwd 
            // Get the password hash for the user
            //byte[] passwordHash = resultSet.getBytes("mdpU");

            // Check if the password is correct
            if( !password.equals(resultSet.getString("password"))) {
                System.out.println("Incorrect password");
                return null;
            }
            System.out.println("connected");
            // Create and return a User object with the user's information
            //  bch nestaamlo e utilisateur connecte
            User user = new User();
            user.setId(resultSet.getInt("id_user"));
            user.setPass(resultSet.getString("password"));
            user.setNom(resultSet.getString("nom"));
            user.setPrenom(resultSet.getString("prenom"));
            user.setAddress(resultSet.getString("adresse"));
            user.setEmail(resultSet.getString("mail"));
            user.setRole(resultSet.getString("role"));
            user.setCin(resultSet.getInt("cin"));
            user.setNumero(resultSet.getInt("numero"));
            
            return user;
        }
    }

    private static boolean checkPassword(String password, byte[] passwordHash) {
        // Check if the password matches the hash using the bcrypt algorithm
        return BCrypt.checkpw(password, new String(passwordHash));
    }
    
     public ObservableList<User> afficherUtilisateur() {
         
       String sql = "SELECT * FROM utilisateur";
        List<User> listeUtilisateur = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
              User resultUser = new User(result.getInt(1),result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6),result.getString(7), result.getInt(8), result.getInt(9));

                listeUtilisateur.add(resultUser);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         System.out.println(listeUtilisateur);
        return FXCollections.observableArrayList(listeUtilisateur);
    }
     
    
 public void supprimerUtilisateur (int idU) {
        try {
            String req = "DELETE FROM `utilisateur` WHERE id_user = " + idU;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
