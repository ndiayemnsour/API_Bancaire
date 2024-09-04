-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : mer. 04 sep. 2024 à 18:40
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
('1dc17f', '2024-09-04 18:36:08.000000', '1991-02-02', 'janesmith@example.com', 'Smith', 'Jane'),
('44edfc', '2024-09-04 18:37:53.680421', '1993-04-04', 'emilyjohnson@example.com', 'Johnson', 'Emily'),
('46127c', '2024-09-04 18:38:19.053893', '1995-06-06', 'sophiajones@example.com', 'Jones', 'Sophia'),
('9a994d', '2024-09-04 18:38:28.709598', '1996-07-07', 'jamesgarcia@example.com', 'Garcia', 'James'),
('acbed5', '2024-09-04 18:38:08.653427', '1994-05-05', 'davidwilliams@example.com', 'Williams', 'David'),
('b236f3', '2024-09-04 18:38:49.247130', '1998-09-09', 'michaelmartinez@example.com', 'Martinez', 'Michael'),
('da1245', '2024-09-04 18:38:39.445085', '1997-08-08', 'oliviamiller@example.com', 'Miller', 'Olivia'),
('e2de42', '2024-09-04 18:37:17.983431', '1992-03-03', 'charliebrown@example.com', 'Brown', 'Charlie'),
('e708f6', '2024-09-04 18:32:02.000000', '1990-01-01', 'johndoe@example.com', 'Doe', 'John'),
('f8fa86', '2024-09-04 18:38:58.694117', '1999-10-10', 'isabelladavis@example.com', 'Davis', 'Isabella');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id_compte` varchar(255) NOT NULL,
  `date_fermature` datetime(6) DEFAULT NULL,
  `date_ouverture` datetime(6) DEFAULT NULL,
  `devise` varchar(255) DEFAULT NULL,
  `numero_compte` int DEFAULT NULL,
  `solde` float DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  `gestionnaire_compte` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
  `prenom_gestionnaire` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
('483813', 'Bloquée'),
('529d71', 'Expirée'),
('62cce0', 'En attente'),
('a5febb', 'Réussie'),
('aa9db8', 'Actif'),
('b5d88e', 'Échouée'),
('b83786', 'Fermé'),
('dcb43f', 'Inactif');

-- --------------------------------------------------------

--
-- Structure de la table `telephone`
--

CREATE TABLE `telephone` (
  `id_telephone` varchar(255) NOT NULL,
  `telephone_personne_contacte` int DEFAULT NULL,
  `telephone_primary` int DEFAULT NULL,
  `telephone_secondary` int DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
('7d8279', 'Virement'),
('906425', 'Débit'),
('d4de82', 'Courant'),
('f28068', 'Épargne'),
('fd0270', 'Crédit');

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
  ADD KEY `FKh2hdkom4e5i1uatk6dwq6k00d` (`statut`),
  ADD KEY `FKbtqxycyygcs4l5khnlfx1glnu` (`client`),
  ADD KEY `FKrjj6wwtv31nbrwvv8r075ndg9` (`gestionnaire_compte`),
  ADD KEY `FK10h7un8g0d7bh3ldiq0r00hs0` (`type`);

--
-- Index pour la table `gestionnaire_compte`
--
ALTER TABLE `gestionnaire_compte`
  ADD PRIMARY KEY (`id_gestionnaire`),
  ADD KEY `FKd6epq9p9dd9volyjbmi7rpvkp` (`statut`);

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
-- Contraintes pour la table `gestionnaire_compte`
--
ALTER TABLE `gestionnaire_compte`
  ADD CONSTRAINT `FKd6epq9p9dd9volyjbmi7rpvkp` FOREIGN KEY (`statut`) REFERENCES `statut` (`id_statut`);

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
