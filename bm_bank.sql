-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : mer. 25 sep. 2024 à 11:40
-- Version du serveur : 8.0.35
-- Version de PHP : 8.2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bm_bank`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id_adresse` varchar(255) NOT NULL,
  `code_postal` int DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `quartier` varchar(255) DEFAULT NULL,
  `rue` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id_adresse`, `code_postal`, `pays`, `quartier`, `rue`, `ville`, `client`) VALUES
('21bbc6', 997654, 'Sénégal', 'Hersent ', '127', 'Thiès', '455bff'),
('400868', 987654, 'Sénégal', '10eme', '57', 'Thiès', '4aba9d'),
('41c098', 987654, 'Sénégal', 'Fahu', '57', 'Thiès', '162a8f'),
('6f4742', 997654, 'Sénégal', 'Grand Standing', '07', 'Thiès', 'd161d0'),
('76b79f', 987654, 'Sénégal', 'Mbour 1', '07', 'Thiès', '6c034f'),
('93243a', 997654, 'Sénégal', ' Keur Massamba Gueye', '07', 'Thiès', '6ec786'),
('a385a8', 997654, 'Sénégal', 'Parcelles ', '120', 'Thiès', '621b3b');

-- --------------------------------------------------------

--
-- Structure de la table `carte_bancaire`
--

CREATE TABLE `carte_bancaire` (
  `id_carte` varchar(255) NOT NULL,
  `cvv` int DEFAULT NULL,
  `date_expiration` date DEFAULT NULL,
  `numero_carte` int DEFAULT NULL,
  `compte` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `carte_bancaire`
--

INSERT INTO `carte_bancaire` (`id_carte`, `cvv`, `date_expiration`, `numero_carte`, `compte`, `statut`, `type`) VALUES
('1ae0bb', 190, '2027-09-19', 97589765, '57a8ac', '939061', 'a9b7b3'),
('4e0178', 993, '2027-09-19', 76599765, '4c4ee4', '939061', 'a9b7b3'),
('4e3a41', 930, '2027-09-19', 90599765, '4c4ee4', '939061', '3c2c3d'),
('d66f6d', 123, '2027-09-19', 12398234, '57a8ac', '939061', '3c2c3d');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` varchar(255) NOT NULL,
  `date_creation` datetime(6) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `date_creation`, `date_naissance`, `email`, `nom`, `prenom`) VALUES
('162a8f', '2024-09-13 02:24:19.981165', '1999-05-29', 'etienneclement.mbaye@bm-bank.com', 'Mbaye', 'Etienne Clement'),
('455bff', '2024-09-13 02:23:10.636457', '1997-05-29', 'awasylla.diallo@bm-bank.com', 'Diallo', 'Awa Sylla'),
('4aba9d', '2024-09-13 02:20:49.327837', '1997-08-18', 'mansour.ndiaye@bm-bank.com', 'Ndiaye', 'Mansour'),
('621b3b', '2024-09-13 02:24:46.777770', '1996-05-29', 'mouhamed.tall@bm-bank.com', 'Tall', 'Mouhamed'),
('6c034f', '2024-09-13 02:21:50.554097', '1997-09-18', 'babacar.wade@bm-bank.com', 'Wade', 'Babacar'),
('6ec786', '2024-09-13 02:22:34.487896', '1997-05-20', 'aida.ndoye@bm-bank.com', 'Ndoye', 'Aida'),
('d161d0', '2024-09-13 02:23:39.346046', '1999-05-29', 'kany.cisse@bm-bank.com', 'Cisse', 'Kany');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id_compte` varchar(255) NOT NULL,
  `date_fermature` date DEFAULT NULL,
  `date_ouverture` date DEFAULT NULL,
  `devise` varchar(255) DEFAULT NULL,
  `numero_compte` int DEFAULT NULL,
  `solde` float DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  `gestionnaire_compte` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `date_fermature`, `date_ouverture`, `devise`, `numero_compte`, `solde`, `client`, `gestionnaire_compte`, `statut`, `type`) VALUES
('4c4ee4', NULL, '2024-09-19', 'FCFA', 1002, 800000, '4aba9d', 'b2faed', '939061', '3c2c3d'),
('57a8ac', NULL, '2024-09-19', 'FCFA', 1003, 950000, '4aba9d', 'b2faed', '939061', '3c2c3d'),
('5a096c', NULL, '2024-09-19', 'FCFA', 1005, 950000, '4aba9d', 'b2faed', '939061', '3c2c3d'),
('83e60c', NULL, '2024-09-19', 'FCFA', 1004, 900000, '4aba9d', 'b2faed', '939061', '3c2c3d'),
('e05061', NULL, '2024-09-19', 'FCFA', 1001, 550000, '4aba9d', 'b2faed', '939061', '3c2c3d');

-- --------------------------------------------------------

--
-- Structure de la table `gestionnaire_compte`
--

CREATE TABLE `gestionnaire_compte` (
  `id_gestionnaire` varchar(255) NOT NULL,
  `date_creation_gestionnaire` datetime(6) DEFAULT NULL,
  `date_naissance_gestionnaire` varchar(255) DEFAULT NULL,
  `email_gestionnaire` varchar(255) DEFAULT NULL,
  `nom_gestionnaire` varchar(255) DEFAULT NULL,
  `prenom_gestionnaire` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `gestionnaire_compte`
--

INSERT INTO `gestionnaire_compte` (`id_gestionnaire`, `date_creation_gestionnaire`, `date_naissance_gestionnaire`, `email_gestionnaire`, `nom_gestionnaire`, `prenom_gestionnaire`) VALUES
('5eac95', '2024-09-13 02:33:25.495309', '1994-05-13', 'fatou.diop@bm-bank.com', 'Diop', 'Fatou'),
('b2faed', '2024-09-13 02:34:09.291905', '1998-05-13', 'khady.ndiaye@bm-bank.com', 'Ndiaye', 'Khady'),
('cf44ec', '2024-09-13 02:32:13.922059', '1990-09-13', 'modoufata.diouf@bm-bank.com', 'Diouf', 'Modou Fata'),
('e8a237', '2024-09-13 02:32:55.105434', '1998-09-13', 'modou.ba@bm-bank.com', 'Ba', 'Modou');

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

CREATE TABLE `statut` (
  `id_statut` varchar(255) NOT NULL,
  `nom_statut` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`id_statut`, `nom_statut`) VALUES
('23e67d', 'En attente'),
('3f7b71', 'Expirée'),
('4ca81d', 'Bloquée'),
('6c990a', 'Echouée'),
('85733a', 'Fermé'),
('939061', 'Actif'),
('c9065f', 'Inactif'),
('ddb2a3', 'Réussie');

-- --------------------------------------------------------

--
-- Structure de la table `telephone`
--

CREATE TABLE `telephone` (
  `id_telephone` varchar(255) NOT NULL,
  `telephone_personne_contacte` varchar(255) DEFAULT NULL,
  `telephone_primary` varchar(255) DEFAULT NULL,
  `telephone_secondary` varchar(255) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `telephone`
--

INSERT INTO `telephone` (`id_telephone`, `telephone_personne_contacte`, `telephone_primary`, `telephone_secondary`, `client`) VALUES
('411600', '00221 77 908 88 80', '00221 77 765 09 00', '00221 76 876 57 06', '4aba9d'),
('9864ae', '00221 78 908 88 87', '00221 77 765 06 77', '00221 76 876 87 76', '162a8f'),
('98bfff', '00221 77 900 88 80', '00221 78 795 09 00', '00221 76 816 57 06', '6ec786'),
('9bfe18', '00221 78 908 88 80', '00221 77 765 06 00', '00221 76 876 87 06', '455bff'),
('b79fc1', '00221 77 908 88 80', '00221 78 795 09 00', '00221 76 896 57 06', '621b3b'),
('c006fd', '00221 77 990 88 80', '00221 78 795 89 00', '00221 76 816 87 06', 'd161d0'),
('c3afbd', '00221 77 903 88 80', '00221 78 705 09 00', '00221 76 886 57 06', '6c034f');

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `id_transaction` varchar(255) NOT NULL,
  `date_transaction` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `compte_credite` varchar(255) DEFAULT NULL,
  `compte_debiteur` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `transaction`
--

INSERT INTO `transaction` (`id_transaction`, `date_transaction`, `description`, `montant`, `compte_credite`, `compte_debiteur`, `statut`, `type`) VALUES
('4a1edd', '2024-09-19 03:12:24.362252', 'Transfert d\'argent ', 50000, 'e05061', '57a8ac', 'ddb2a3', '9ec602');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE `type` (
  `id_type` varchar(255) NOT NULL,
  `nom_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`id_type`, `nom_type`) VALUES
('3c2c3d', 'Courant'),
('7b30ee', 'Credit'),
('9c2452', 'Debit'),
('9ec602', 'Virement'),
('a9b7b3', 'Epargne');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id_adresse`),
  ADD UNIQUE KEY `UK36b8tnc4349u8ao0ikrtqu8l6` (`client`);

--
-- Index pour la table `carte_bancaire`
--
ALTER TABLE `carte_bancaire`
  ADD PRIMARY KEY (`id_carte`),
  ADD KEY `FKkbqa38i6lkcfd6svxh66dvorh` (`compte`),
  ADD KEY `FKowxuh9fgypkvlkefulpob13j7` (`statut`),
  ADD KEY `FK5satox6uynwd6y3l3j568jsql` (`type`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id_compte`),
  ADD KEY `FKbtqxycyygcs4l5khnlfx1glnu` (`client`),
  ADD KEY `FKrjj6wwtv31nbrwvv8r075ndg9` (`gestionnaire_compte`),
  ADD KEY `FKh2hdkom4e5i1uatk6dwq6k00d` (`statut`),
  ADD KEY `FK10h7un8g0d7bh3ldiq0r00hs0` (`type`);

--
-- Index pour la table `gestionnaire_compte`
--
ALTER TABLE `gestionnaire_compte`
  ADD PRIMARY KEY (`id_gestionnaire`);

--
-- Index pour la table `statut`
--
ALTER TABLE `statut`
  ADD PRIMARY KEY (`id_statut`);

--
-- Index pour la table `telephone`
--
ALTER TABLE `telephone`
  ADD PRIMARY KEY (`id_telephone`),
  ADD UNIQUE KEY `UKnfpvqo80yxra1cc4aetl4jk6` (`client`);

--
-- Index pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id_transaction`),
  ADD KEY `FKnm206g07hro88fm08u2f538fr` (`compte_credite`),
  ADD KEY `FK4s50fexgtn5g8v9f7xhl9l9fy` (`compte_debiteur`),
  ADD KEY `FKab0xg4ccxeucxxjgtt7bbn1gg` (`statut`),
  ADD KEY `FKbyorhekevw1676p6qfxnala9o` (`type`);

--
-- Index pour la table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id_type`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD CONSTRAINT `FKogmmswufligrjtxl0akccg213` FOREIGN KEY (`client`) REFERENCES `client` (`id_client`);

--
-- Contraintes pour la table `carte_bancaire`
--
ALTER TABLE `carte_bancaire`
  ADD CONSTRAINT `FK5satox6uynwd6y3l3j568jsql` FOREIGN KEY (`type`) REFERENCES `type` (`id_type`),
  ADD CONSTRAINT `FKkbqa38i6lkcfd6svxh66dvorh` FOREIGN KEY (`compte`) REFERENCES `compte` (`id_compte`),
  ADD CONSTRAINT `FKowxuh9fgypkvlkefulpob13j7` FOREIGN KEY (`statut`) REFERENCES `statut` (`id_statut`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK10h7un8g0d7bh3ldiq0r00hs0` FOREIGN KEY (`type`) REFERENCES `type` (`id_type`),
  ADD CONSTRAINT `FKbtqxycyygcs4l5khnlfx1glnu` FOREIGN KEY (`client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `FKh2hdkom4e5i1uatk6dwq6k00d` FOREIGN KEY (`statut`) REFERENCES `statut` (`id_statut`),
  ADD CONSTRAINT `FKrjj6wwtv31nbrwvv8r075ndg9` FOREIGN KEY (`gestionnaire_compte`) REFERENCES `gestionnaire_compte` (`id_gestionnaire`);

--
-- Contraintes pour la table `telephone`
--
ALTER TABLE `telephone`
  ADD CONSTRAINT `FKbdbs25nvrlj9dpk2pppyg6n1h` FOREIGN KEY (`client`) REFERENCES `client` (`id_client`);

--
-- Contraintes pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FK4s50fexgtn5g8v9f7xhl9l9fy` FOREIGN KEY (`compte_debiteur`) REFERENCES `compte` (`id_compte`),
  ADD CONSTRAINT `FKab0xg4ccxeucxxjgtt7bbn1gg` FOREIGN KEY (`statut`) REFERENCES `statut` (`id_statut`),
  ADD CONSTRAINT `FKbyorhekevw1676p6qfxnala9o` FOREIGN KEY (`type`) REFERENCES `type` (`id_type`),
  ADD CONSTRAINT `FKnm206g07hro88fm08u2f538fr` FOREIGN KEY (`compte_credite`) REFERENCES `compte` (`id_compte`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
