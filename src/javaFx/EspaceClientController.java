/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import models.Evenement;
import models.Ticket;
import services.EvenementCRUD;
import services.TicketCRUD;
import db.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author GOLDEN
 */
public class EspaceClientController implements Initializable {

    @FXML
    private TextField EventTick;

    @FXML
    private TextField EventNa;

    @FXML
    private TextField EventAdrr;

    @FXML
    private TextField EventCap;

    @FXML
    private TextField EventPrix;

    @FXML
    private TextArea EventDesc;

    @FXML
    private DatePicker DDDD;
    @FXML
    private DatePicker D5D;
    @FXML
    private TableView<Evenement> EventTable;
    @FXML
    private TableColumn<Evenement, String> idEvent;
    @FXML
    private TableColumn<Evenement, String> NomEvent;
    @FXML
    private TableColumn<Evenement, String> AdresseEvent;
    @FXML
    private TableColumn<Evenement, String> CapaciteEvent;
    @FXML
    private TableColumn<Evenement, String> NbrTicketsAcheté;
    @FXML
    private TableColumn<Evenement, String> DateDebutEvent;
    @FXML
    private TableColumn<Evenement, String> DateFinEvent;
    @FXML
    private TableColumn<Evenement, String> TypeEvent;
    @FXML
    private TableColumn<Evenement, String> PrixEntrée;
    @FXML
    private Button AddEvenement1;

    @FXML
    private Button ModEvent1;

    @FXML
    private Button SuppEvent1;
    private Button bar2;

    private Button bar1;

    private AnchorPane paneslide;
    
    private TableView<Ticket> TicketTable;

    private TableColumn<Ticket, String> idTicket;

    private TableColumn<Ticket, String> prix_tick;

    private TableColumn<Ticket, String> nomEventTick;

    private TableColumn<Ticket, String> nomClientTick;

    private TableColumn<Ticket, String> NbrTicketsAchetesTick; 


    private TextField prix;

    private TextField nomEvent;


   

    private ComboBox<String> cbx_id;

    private TextField nomClient;
    private TextField nbr_tickets;
    private TextField tel;
    @FXML
    private Label nomPrenom3;
    @FXML
    private VBox vbox2;
    @FXML
    private Button btnNaviguer;
    @FXML
    private AnchorPane bord;

    void AddEvent(ActionEvent event) throws SQLException {
        // Get the input values from the text fields and combo box
    String prixVal = prix.getText();
    String nomEventVal = nomEvent.getText();
    String nomClientVal = nomClient.getText();
    String nbrTicketsVal = nbr_tickets.getText();
    String idVal = cbx_id.getValue();
    String num="+216"+tel.getText();
    String message = "Dear "+nomClientVal +", you have successfully purchased " + nbrTicketsVal + " tickets. Thank you for your purchase!";
    

    // Validate the input values
    if (prixVal == null || prixVal.isEmpty() || nomEventVal == null || nomEventVal.isEmpty()
            || nomClientVal == null || nomClientVal.isEmpty() || nbrTicketsVal == null
            || nbrTicketsVal.isEmpty() || idVal == null || idVal.isEmpty()) {
        // Display an error message if any of the fields are empty
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please fill in all fields.");
        alert.showAndWait();
        return;
    }

    // Convert the number of tickets to an integer
    int nbrTickets = Integer.parseInt(nbrTicketsVal);
    if (nbrTickets>=3){
        float pr=(float) (Float.parseFloat(prixVal)*nbrTickets-Float.parseFloat(prixVal)*nbrTickets*0.2);
        message=message+" There is a 20% discount for your tickets! You only have to pay "+pr;
    }

    // Create a new Ticket object with the input values
    Ticket newTicket = new Ticket(Integer.parseInt(idVal), Float.parseFloat(prixVal), nomEventVal, nomClientVal, nbrTickets);

    // Add the new ticket to the table view
    TicketCRUD c=new TicketCRUD();
    c.ajouterTicket(Integer.parseInt(idVal),  nomClientVal, nbrTickets);
    EvenementCRUD e=new EvenementCRUD();
    Evenement e1=e.getEvenementById(Integer.parseInt(idVal));
    System.out.println(e1.getNbrTicketdispo());
    System.out.println(nbrTickets);
    e1.setNbrTicketdispo(e1.getNbrTicketdispo()-nbrTickets);
    System.out.println(e1.getNbrTicketdispo());
    e.ModifierEvenement(e1,Integer.parseInt(idVal));
    c.sendSms(num,message);
    TicketTable.getItems().add(newTicket);

    // Clear the input fields
    prix.clear();
    nomEvent.clear();
    nomClient.clear();
    nbr_tickets.clear();
    cbx_id.getSelectionModel().clearSelection();
    
    EvenementCRUD ecd = new EvenementCRUD();
        List<Evenement> EV = ecd.afficherEvenemets();
        ObservableList<Evenement> eventList = FXCollections.observableArrayList();

        eventList.addAll(EV);
        idEvent.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
        NomEvent.setCellValueFactory(new PropertyValueFactory<>("NomEvent"));
        AdresseEvent.setCellValueFactory(new PropertyValueFactory<>("AdresseEvent"));
        CapaciteEvent.setCellValueFactory(new PropertyValueFactory<>("CapaciteEvent"));
        NbrTicketsAcheté.setCellValueFactory(new PropertyValueFactory<>("nbrTicketdispo"));
        DateDebutEvent.setCellValueFactory(new PropertyValueFactory<>("DateDebutEvent"));
        DateFinEvent.setCellValueFactory(new PropertyValueFactory<>("DateFinEvent"));

        TypeEvent.setCellValueFactory(new PropertyValueFactory<>("DescriptionEvent"));
        PrixEntrée.setCellValueFactory(new PropertyValueFactory<>("PrixEntre"));
        EventTable.setItems(eventList);
    }

    void SupprimerEvent(ActionEvent event) throws SQLException {
        Ticket selectedEvent = TicketTable.getSelectionModel().getSelectedItem();
    if (selectedEvent == null) {
        // Aucun événement sélectionné
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aucun ticket sélectionné");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un ticket à supprimer.");
        alert.showAndWait();
        return;
    }
    // Demander une confirmation de la suppression
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation de la suppression");
    alert.setHeaderText(null);
    alert.setContentText("Êtes-vous sûr de vouloir supprimer le ticket sélectionné ?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        // Supprimer l'événement de la base de données
        TicketCRUD ecd = new TicketCRUD();
        ecd.supprimerTicket(selectedEvent.getIdTicket());
        // Supprimer l'événement de la TableView
        TicketTable.getItems().remove(selectedEvent);
        // Afficher un message de succès
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Suppression réussie");
        alert2.setHeaderText(null);
        alert2.setContentText("Le ticket a été supprimé avec succès.");
        alert2.showAndWait();
    }
    }

      void run1(MouseEvent event) {
        TranslateTransition slide = new  TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(paneslide);
        slide.setToX(0);
        slide.play();
        paneslide.setTranslateX(-780);
        slide.setOnFinished((ActionEvent e) -> {
            bar1.setVisible(false);
             bar2.setVisible(true);
        });

    }

    void run2(MouseEvent event) {
        TranslateTransition slide = new  TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
          slide.setNode(paneslide);
        slide.setToX(-780);
        slide.play();
        paneslide.setTranslateX(0);
       
        slide.setOnFinished((ActionEvent e) -> {
            bar1.setVisible(true);
             bar2.setVisible(false);
        });

    }
  




    @FXML
    void add(ActionEvent event) {
        try {
            // Récupérer les données saisies par l'utilisateur
            String nom = EventNa.getText();
            String adresse = EventAdrr.getText();
            int capacite = Integer.parseInt(EventCap.getText());
            float prix = Float.parseFloat(EventPrix.getText());
            String description = EventDesc.getText();
            LocalDate dateDebut = DDDD.getValue();
            LocalDate dateFin = D5D.getValue();
            int tick = Integer.parseInt(EventTick.getText());

            // Vérifier que les données sont valides
            if (nom.isEmpty() || adresse.isEmpty() || description.isEmpty()
                    || dateDebut == null || dateFin == null) {
                // Afficher un message d'erreur si des champs sont vides
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Certains champs sont vides");
                alert.setContentText("Veuillez remplir tous les champs obligatoires (*)");
                alert.showAndWait();
                return;
            }
            if (dateDebut.isAfter(dateFin)) {
                // Afficher un message d'erreur si la date de fin est antérieure à la date de début
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("La date de fin est antérieure à la date de début");
                alert.setContentText("Veuillez sélectionner une date de fin ultérieure à la date de début");
                alert.showAndWait();
                return;
            }
            if (capacite < 0 || prix < 0) {
                // Afficher un message d'erreur si la capacité ou le prix sont négatifs
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("La capacité ou le prix est négatif");
                alert.setContentText("Veuillez saisir une valeur positive pour la capacité et le prix");
                alert.showAndWait();
                return;
            }

            // Créer un nouvel événement avec les données saisies
            Evenement evenement = new Evenement();
            evenement.setNomEvent(nom);
            evenement.setAdresseEvent(adresse);
            evenement.setCapaciteEvent(capacite);
            evenement.setPrixEntre(prix);
            evenement.setDescriptionEvent(description);
            evenement.setDateDebutEvent(Date.valueOf(dateDebut).toString());
            evenement.setDateFinEvent(Date.valueOf(dateFin).toString());
            evenement.setNbrTicketdispo(tick);

            // Ajouter l'événement dans la base de données
            EvenementCRUD ecd = new EvenementCRUD();
            ecd.ajouterEvenement(evenement);

            // Afficher un message de confirmation
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText("L'événement a été ajouté avec succès");
            alert.setContentText("L'événement \"" + nom + "\" a été ajouté à la base de données");
            alert.showAndWait();

            // Réinitialiser les champs de saisie et rafraîchir la table des événements
            EventNa.setText("");
            EventAdrr.setText("");
            EventCap.setText("");
            EventPrix.setText("");
            EventDesc.setText("");
            DDDD.setValue(null);
            D5D.setValue(null);
            EventTable.setItems(FXCollections.observableArrayList(ecd.afficherEvenemets()));
        } catch (NumberFormatException e) {
            // Afficher un message d'erreur si les champs de capacité ou de prix ne conti
        }
    }

    @FXML
    void Supprimer(ActionEvent event) throws SQLException {
         Evenement selectedEvent = EventTable.getSelectionModel().getSelectedItem();
    if (selectedEvent == null) {
        // Aucun événement sélectionné
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Aucun événement sélectionné");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un événement à supprimer.");
        alert.showAndWait();
        return;
    }
    // Demander une confirmation de la suppression
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation de la suppression");
    alert.setHeaderText(null);
    alert.setContentText("Êtes-vous sûr de vouloir supprimer l'événement sélectionné ?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        // Supprimer l'événement de la base de données
        EvenementCRUD ecd = new EvenementCRUD();
        ecd.supprimerEvent(selectedEvent.getIdEvent());
        // Supprimer l'événement de la TableView
        EventTable.getItems().remove(selectedEvent);
        // Afficher un message de succès
        Alert alert2 = new Alert(AlertType.INFORMATION);
        alert2.setTitle("Suppression réussie");
        alert2.setHeaderText(null);
        alert2.setContentText("L'événement a été supprimé avec succès.");
        alert2.showAndWait();
    }
    }

    @FXML
    void UpdateEvent(MouseEvent event) {
        Evenement selectedEvent = EventTable.getSelectionModel().getSelectedItem();
        if (selectedEvent == null) {
            // Aucun événement sélectionné
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aucun événement sélectionné");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un événement à modifier.");
            alert.showAndWait();
            return;
        }
        // Récupérer les données des champs
        String nomEvent = EventNa.getText();
        String adresseEvent = EventAdrr.getText();
        int capaciteEvent = Integer.parseInt(EventCap.getText());
        int tick = Integer.parseInt(EventTick.getText());
        float prixEvent = Float.parseFloat(EventPrix.getText());
        String descEvent = EventDesc.getText();
        String dateDebutEvent = DDDD.getValue().toString();
        String dateFinEvent = D5D.getValue().toString();
        // Créer un nouvel objet Evenement avec les données
        Evenement newEvent = new Evenement(nomEvent, adresseEvent, capaciteEvent, tick, dateDebutEvent, dateFinEvent, descEvent, prixEvent);
        // Modifier l'événement dans la base de données
        EvenementCRUD ecd = new EvenementCRUD();
        ecd.ModifierEvenement(newEvent, selectedEvent.getIdEvent());
        // Modifier l'événement dans la TableView
        int selectedIndex = EventTable.getSelectionModel().getSelectedIndex();
        EventTable.getItems().set(selectedIndex, newEvent);
        // Afficher un message de succès
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Modification réussie");
        alert.setHeaderText(null);
        alert.setContentText("L'événement a été modifié avec succès.");
        alert.showAndWait();

    }
    Connection mc;
    PreparedStatement ste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //paneslide.setTranslateX(0);
        
        EvenementCRUD ecd = new EvenementCRUD();
        List<Evenement> EV = ecd.afficherEvenemets();
        ObservableList<Evenement> eventList = FXCollections.observableArrayList();

        eventList.addAll(EV);
        idEvent.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
        NomEvent.setCellValueFactory(new PropertyValueFactory<>("NomEvent"));
        AdresseEvent.setCellValueFactory(new PropertyValueFactory<>("AdresseEvent"));
        CapaciteEvent.setCellValueFactory(new PropertyValueFactory<>("CapaciteEvent"));
        NbrTicketsAcheté.setCellValueFactory(new PropertyValueFactory<>("nbrTicketdispo"));
        DateDebutEvent.setCellValueFactory(new PropertyValueFactory<>("DateDebutEvent"));
        DateFinEvent.setCellValueFactory(new PropertyValueFactory<>("DateFinEvent"));

        TypeEvent.setCellValueFactory(new PropertyValueFactory<>("DescriptionEvent"));
        PrixEntrée.setCellValueFactory(new PropertyValueFactory<>("PrixEntre"));
        EventTable.setItems(eventList);
        
         // Ajouter un ChangeListener à la propriété de sélection du TableView
    EventTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if(newValue != null) {
            // Remplir les champs de texte et de date avec les attributs de l'élément sélectionné
            EventNa.setText(newValue.getNomEvent());
            EventAdrr.setText(newValue.getAdresseEvent());
            EventCap.setText(String.valueOf(newValue.getCapaciteEvent()));
            EventTick.setText(String.valueOf(newValue.getNbrTicketdispo()));
            EventDesc.setText(newValue.getDescriptionEvent());
            EventPrix.setText(String.valueOf(newValue.getPrixEntre()));
        }
    });
    }

    @FXML
    private void goToNavigate(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GuiAdmin.fxml"));
        try {
            Parent root = loader.load();
            bord.getChildren().setAll(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    }



