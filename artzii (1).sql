-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 10 mars 2023 à 05:05
-- Version du serveur : 8.0.32
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `artzii`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `ArtId` int NOT NULL,
  `ArtLib` varchar(20) NOT NULL,
  `ArtDesc` varchar(20) NOT NULL,
  `ArtDispo` int NOT NULL,
  `ArtImg` varchar(4000) DEFAULT NULL,
  `ArtPrix` int NOT NULL,
  `CatLib` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`ArtId`, `ArtLib`, `ArtDesc`, `ArtDispo`, `ArtImg`, `ArtPrix`, `CatLib`) VALUES
(12, 'the style', 'be Stylish', 1, 'Capture d’écran 2023-01-29 174210.png', 50, 'paysage'),
(13, 'powerless', 'the power in hands', 1, 'Capture d’écran 2023-01-29 174210.png', 50, 'portrait'),
(15, 'bedtime', 'me sleeping', 1, 'Capture d’écran 2023-01-29 174210.png', 40, 'animaux'),
(17, 'nothing else', 'someone stop me', 1, 'Capture d’écran 2023-01-29 174210.png', 40, 'paysage');

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE `articles` (
  `refA` int NOT NULL,
  `idArtiste` int DEFAULT NULL,
  `nomA` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `dimensionA` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `prixA` float NOT NULL,
  `catId` int DEFAULT '1',
  `image_url` varchar(400) COLLATE utf8mb4_general_ci DEFAULT '../resources/eruro.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`refA`, `idArtiste`, `nomA`, `dimensionA`, `prixA`, `catId`, `image_url`) VALUES
(2, 26, 'when going', '120x50', 10, 2, 'C:\\Users\\medmo\\Documents\\NetBeansProjects\\GestionPanier\\src\\resources\\art1.png'),
(3, 32, 'art of fun', '128x45', 20, 2, 'C:\\Users\\medmo\\Documents\\NetBeansProjects\\GestionPanier\\src\\resources\\art2.png'),
(4, 38, 'the style', '63x85', 50, 3, 'C:\\Users\\medmo\\Documents\\NetBeansProjects\\GestionPanier\\src\\resources\\art3.png'),
(10, 39, 'powerless', '60x35', 125, 1, 'C:\\Users\\medmo\\Desktop\\src\\resources\\addbutton.png'),
(11, 26, 'galery momo', '85x30', 20, 1, 'C:\\Users\\medmo\\Documents\\NetBeansProjects\\GestionPanier\\src\\resources\\logo.png'),
(13, 39, 'bed time', '70x30', 156, 1, 'C:\\Users\\medmo\\Desktop\\331924362_931170547913626_2340085389939197998_n.jpg'),
(16, 26, 'nothing else', '78x25', 51, 1, 'C:\\Users\\medmo\\Documents\\NetBeansProjects\\GestionPanier\\src\\resources\\art5.png'),
(18, 26, 'the power', '60x20', 15, 1, 'C:\\Users\\medmo\\Documents\\NetBeansProjects\\GestionPanier\\src\\resources\\trash.png'),
(20, 32, 'the ocean', '70x26', 15, 1, 'C:\\Users\\medmo\\Documents\\NetBeansProjects\\GestionPanier\\src\\resources\\eruro.png');

-- --------------------------------------------------------

--
-- Structure de la table `basket`
--

CREATE TABLE `basket` (
  `id_client` int NOT NULL,
  `id_article` int NOT NULL,
  `date_ajout` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `CatId` int NOT NULL,
  `CatLib` varchar(20) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`CatId`, `CatLib`) VALUES
(1, 'paysage'),
(2, 'animaux'),
(3, 'portrait');

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

CREATE TABLE `commandes` (
  `id` int NOT NULL,
  `date_creation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `prix_total` float NOT NULL,
  `livraison` tinyint(1) NOT NULL DEFAULT '0',
  `adresse` varchar(255) NOT NULL,
  `region` varchar(255) NOT NULL,
  `livreur_id` int NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `commandes`
--

INSERT INTO `commandes` (`id`, `date_creation`, `prix_total`, `livraison`, `adresse`, `region`, `livreur_id`, `user_id`) VALUES
(2, '2023-03-05 23:00:00', 260, 1, 'bizert', 'bizerte', 2, 4),
(3, '2023-03-05 23:00:00', 160, 1, 'jandouba', 'tunis', 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `commands`
--

CREATE TABLE `commands` (
  `id` int NOT NULL,
  `id_client` int NOT NULL,
  `date_commande` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mode_livraison` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mode_paiement` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cout_totale` float DEFAULT NULL,
  `etat_commande` varchar(30) COLLATE utf8mb4_general_ci DEFAULT 'En attente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `commands`
--

INSERT INTO `commands` (`id`, `id_client`, `date_commande`, `mode_livraison`, `mode_paiement`, `cout_totale`, `etat_commande`) VALUES
(115, 40, '2022-03-19 23:00:00', 'Livraison domicile', 'Cash', 100, 'En attente'),
(116, 41, '2022-04-16 23:00:00', 'Artzii now', 'En ligne', 350, 'En attente'),
(118, 36, '2022-06-07 23:00:00', 'Artzii now', 'Cash', 450, 'En cours'),
(119, 40, '2022-07-13 23:00:00', 'Livraison domicile', 'En ligne', 300, 'En cours'),
(122, 36, '2022-10-16 23:00:00', 'Artzii now', 'Cash', 600, 'En cours'),
(123, 41, '2022-11-10 23:00:00', 'Livraison domicile', 'En ligne', 350, 'En attente'),
(124, 40, '2022-12-22 23:00:00', 'Artzii now', 'Cash', 450, 'En cours'),
(125, 45, '2023-03-08 09:20:34', 'Livraison domicile', 'Cash', 17, 'En attente');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `idEvent` int NOT NULL,
  `NomEvent` varchar(255) NOT NULL,
  `AdresseEvent` varchar(255) NOT NULL,
  `CapaciteEvent` int NOT NULL,
  `nbrTicketdispo` int NOT NULL,
  `DateDebutEvent` varchar(255) NOT NULL,
  `DateFinEvent` varchar(255) NOT NULL,
  `DescriptionEvent` varchar(255) DEFAULT NULL,
  `PrixEntre` float NOT NULL,
  `image1` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`idEvent`, `NomEvent`, `AdresseEvent`, `CapaciteEvent`, `nbrTicketdispo`, `DateDebutEvent`, `DateFinEvent`, `DescriptionEvent`, `PrixEntre`, `image1`) VALUES
(12, 'EventGoal', 'gabes', 90, -5, '22/02/2022 à 10.00h', '22/02/2022 à 12h', 'Event for goals', 50, NULL),
(14, 'Eventbook', 'Tunis', 70, 0, '2023-03-08', '2023-03-12', 'Event for all', 50, NULL),
(16, 'MayEvent', 'gabes', 150, 3, '22/02/2022 à 10.00h', '22/02/2022 à 12h', 'Event of may', 50, NULL),
(18, 'Artzii go', 'gabes', 100, 14, '22/02/2022 à 10.00h', '22/02/2022 à 12h', 'Event of books', 50, NULL),
(22, 'we all', 'gabes', 40, 50, '22/02/2022 à 10.00h', '22/02/2022 à 12h', 'Al ghazala', 50, NULL),
(33, 'one4all', 'adresse', 70, 9, '2023-03-08', '2023-03-09', 'description', 1, NULL),
(42, 'one4all', 'adresse', 70, 9, '2023-03-09', '2023-03-15', 'description', 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `livreurs`
--

CREATE TABLE `livreurs` (
  `id` int NOT NULL,
  `num_tel` varchar(50) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `region_livreur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `livreurs`
--

INSERT INTO `livreurs` (`id`, `num_tel`, `nom`, `prenom`, `region_livreur`) VALUES
(1, '52505287', 'med', 'med', 'tunis'),
(2, '12345678', 'houssem', 'sakhri', 'bizerte'),
(3, '12345670', 'oussema', 'sakhri', 'tunis'),
(4, '18345970', 'fedi', 'kharoubi', 'beja'),
(6, '88748970', 'hedi', 'tounsi', 'nabeel');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id` int NOT NULL,
  `TypeR` varchar(30) DEFAULT NULL,
  `dateR` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `etat` varchar(30) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `objet` varchar(60) DEFAULT NULL,
  `iduser` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`id`, `TypeR`, `dateR`, `etat`, `Description`, `objet`, `iduser`) VALUES
(8, 'piece défectueux', '2023-03-08 07:01:42', 'resolu', 'piece est défectueux', 'bonjours j\'attens la réponse', 2),
(17, 'qualité', '2023-03-08 07:01:46', 'resolu', 'probléme qualité', 'bonjours j\'attens la réponse', 1),
(18, 'piece défectueux', '2023-03-08 07:01:58', 'resolu', 'piece est défectueux', 'bonjours j\'attens la réponse', 1),
(21, 'service clientèle', '2023-03-08 07:02:03', 'nonresolu', 'probléme service clientéle', 'bonjours j\'attens la réponse', 1),
(22, 'qualité', '2023-03-08 07:02:07', 'nonresolu', 'probléme qualité', 'bonjours j\'attens la réponse', 1),
(23, 'piece défectueux', '2023-03-08 07:02:11', 'nonresolu', 'piece est défectueux', 'bonjours j\'attens la réponse', 1),
(24, 'service clientèle', '2023-03-08 07:02:17', 'nonresolu', 'piece est défectueux', 'bonjours j\'attens la réponse', 1),
(25, 'qualité', '2023-03-08 07:02:22', 'nonresolu', 'probléme livraison', 'iutiut', 1),
(26, 'livraison', '2023-03-08 06:59:59', 'resolu', 'probléme livraison', 'iutiutg', 1),
(27, 'piece défectueux', '2023-03-08 06:59:32', 'resolu', 'piece est défectueux', 'jhguy', 1),
(28, 'service clientèle', '2023-03-08 07:00:44', 'nonresolu', 'probléme livraison', 'uyfgu', 1),
(29, 'service clientèle', '2023-03-08 06:58:47', 'nonresolu', 'piece est défectueux', 'o', 1),
(30, 'livraison', '2023-03-08 07:00:06', 'nonresolu', 'probléme livraison', 'iughiyhi', 1),
(31, 'piece défectueux', '2023-03-08 06:58:52', 'nonresolu', 'piece est défectueux', 'oeizj', 1),
(35, 'qualite', '2023-03-08 09:07:19', 'nonresolu', 'qualite pas bonne', 'prbleme qualité', 1);

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `idRep` int NOT NULL,
  `dateRep` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `contenuRep` varchar(255) NOT NULL,
  `idreclamation` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `reponse`
--

INSERT INTO `reponse` (`idRep`, `dateRep`, `contenuRep`, `idreclamation`) VALUES
(10, '2023-03-08 07:03:03', 'votre probléme de livraison est fixée ', 8),
(13, '2023-03-08 07:03:39', 'votre probléme de service clientéle est fixée', 17),
(15, '2023-03-08 07:06:37', 'je vous contacte pour la reclamation', 27),
(16, '2023-03-08 07:06:56', 'votre réclamation est en train de traitement', 26),
(17, '2023-03-08 09:51:40', 'on va vous envoyer un mail', 21);

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

CREATE TABLE `ticket` (
  `IdTicket` int NOT NULL,
  `NomClient` varchar(255) NOT NULL,
  `PrixTicket` float NOT NULL,
  `NomEvent` varchar(255) NOT NULL,
  `nbr_ticket` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `ticket`
--

INSERT INTO `ticket` (`IdTicket`, `NomClient`, `PrixTicket`, `NomEvent`, `nbr_ticket`) VALUES
(22, 'Sboui', 50, 'Eventbook', 7),
(33, 'sboui', 1, 'nom', 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idU` int NOT NULL,
  `nomU` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `prenomU` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `emailU` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `mdpU` varbinary(100) DEFAULT NULL,
  `roleU` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `adresse` varchar(20) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idU`, `nomU`, `prenomU`, `emailU`, `mdpU`, `roleU`, `adresse`) VALUES
(29, 'admin', 'admin', 'admin', 0x24326124313024545174716c734253526a4a51616a696175364672724f49686b746877524b58464d595a36324c325062686a454b6e486b3052755547, 'Admin', 'Ariana'),
(32, 'Mokhtar', 'Hadded', 'mokhtar@gmail.com', 0x24326124313024583545534c4539657a6f393238534b2f476f5365344f33494f6e2f444d6d53386757577965464a394744544d73464c2f474a453569, 'Artiste', 'Gabes'),
(33, 'Achref', 'Kawi', 'achrefkawi@gmail.com', 0x2432612431302433445342795673316b572e4e464c4b36455264436e652f677954754b4d647838625a67456c6f714f526242694f6968534133383875, 'Client', 'Touzer'),
(36, 'Maysa', 'Makhlouf', 'kkk@hhh.hjjhj', 0x2432612431302479337158724c574973383377675530677569774c342e34757551737179486e5741584d64766f3971445a32725879664836774d622e, 'Client', 'El-kaf'),
(38, 'Mokhtar2', 'Mokhtar', 'mokh3@gmail.com', 0x243261243130245948763648594777445263774935772f4f2e58566e75596933387137524e565538584d58486c51433645764755766b343739427765, 'Artiste', 'Jandouba'),
(39, 'Ramzi', 'Hbib', 'rrc@yhbhb.hbhb', 0x24326124313024504e4a75395638746d752e616d516b31777764644a4f45567268724e3446666d4235785473664a4a6c7456653670477339476c2e36, 'Artiste', 'Nabel'),
(40, 'Rami', 'Mechergui', 'gyhb@uguh.gtcgv', 0x243261243130247642437473714a6567784c6343685530324b3964672e784e417074566679425472466258703055456b764939535563486f3068594b, 'Client', 'Metloui'),
(41, 'Mohamed', 'Saidi', 'zczc@zi.ub', 0x243261243130247153756f536152757147322e454b6b49593951656a4f3151534557436e692e497078326356645363783264626b2f63432e54457565, 'Client', 'Tatawine'),
(42, 'Smael', 'gharnougui', 'smael@gmail.com', 0x243261243130245a6558655251314748534c57565267636f545a6a4f4f30766d623962734157704372327a49336576713565544533624b7362347a4b, 'Client', 'Tunis'),
(43, 'Artiste', 'artiste1', 'artiste@gmail.com', 0x243261243130242e4b6a5175784845564352474a65526e57677a42432e6742453876552f47476c2e707a69494a372e6d50522f6b587843594e764f69, 'Artiste', 'ldi,'),
(44, 'mm', 'nn', 'm@gmail.com', 0x243261243130245037524f352e784e734c38785754624752362f336c65774147374a48576d327357474f7532576e364b5944444c2f57724578456375, 'Client', 'hh'),
(45, 'mariem', 'ftouhi', 'mariem.ft@gmail.com', 0x24326124313024342f34644574356638647238557776617263456568655731647464746d456c2e576e374953356d6d694e34433770652e634b476475, 'Client', 'tunis'),
(46, 'ismail14', 'gharnougui', 'ismail@gmail.com', 0x243261243130246a464854653633366c435335712e50736c4e43484b2e69334577775335756944724b754450484b484571315a56644b34734a596771, 'Client', 'tunis'),
(47, 'mokhtar', 'ffefev', 'ujhjb@fiahnf.hvhyv', 0x243261243130244b52465746706a4d5a6f72324b7a6c4b5a6c474e2e4f6f587763524449556646444d616b4a454b7a66393937464836746667386565, 'Client', 'hughv');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`ArtId`);

--
-- Index pour la table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`refA`),
  ADD KEY `CatId` (`catId`);

--
-- Index pour la table `basket`
--
ALTER TABLE `basket`
  ADD PRIMARY KEY (`id_client`,`id_article`),
  ADD KEY `id_article` (`id_article`),
  ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`CatId`);

--
-- Index pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `livreur_id` (`livreur_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Index pour la table `commands`
--
ALTER TABLE `commands`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`idEvent`);

--
-- Index pour la table `livreurs`
--
ALTER TABLE `livreurs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `num_tel` (`num_tel`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user` (`iduser`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`idRep`),
  ADD KEY `fk_reclamation` (`idreclamation`);

--
-- Index pour la table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`IdTicket`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idU`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `ArtId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `articles`
--
ALTER TABLE `articles`
  MODIFY `refA` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `CatId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `commandes`
--
ALTER TABLE `commandes`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `commands`
--
ALTER TABLE `commands`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `idEvent` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT pour la table `livreurs`
--
ALTER TABLE `livreurs`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `idRep` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idU` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `fk_id` FOREIGN KEY (`catId`) REFERENCES `categorie` (`CatId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `basket`
--
ALTER TABLE `basket`
  ADD CONSTRAINT `fk_bc` FOREIGN KEY (`id_article`) REFERENCES `articles` (`refA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cli` FOREIGN KEY (`id_client`) REFERENCES `utilisateur` (`idU`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `commandes_ibfk_1` FOREIGN KEY (`livreur_id`) REFERENCES `livreurs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commands`
--
ALTER TABLE `commands`
  ADD CONSTRAINT `fk_idk` FOREIGN KEY (`id_client`) REFERENCES `utilisateur` (`idU`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
