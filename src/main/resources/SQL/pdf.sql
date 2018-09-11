-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 11 sep. 2018 à 08:13
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pdf`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `client_id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `billingPlace` varchar(255) NOT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`client_id`, `name`, `firstName`, `billingPlace`, `mail`, `phone`) VALUES
(7, 'Beaupré', 'Vail', '8, rue Goya 77350 LE MÉE-SUR-SEINE', '', '01.22.05.54.37'),
(8, 'Ducharme', 'Rachelle', '53, Rue St Ferréol 57050 METZ', 'rachelleducharme@dayrep.com ', '01.76.82.04.49'),
(9, 'Migneault', 'Arthur', '25, rue de Penthièvre 95300 PONTOISE', '', '03.03.60.78.09'),
(10, 'Aubé', 'Amélie', '44, rue Charles Corbeau 09000 FOIX', 'amelieaube@armyspy.com', '01.08.18.31.15'),
(11, 'Claude', 'Édouard', '10, route de Lyon 94200 IVRY-SUR-SEINE', '', '04.33.95.21.43'),
(12, 'Chevrette', 'Halette', '46, rue des Lacs 78800 HOUILLES', '', '01.66.02.23.17');

-- --------------------------------------------------------

--
-- Structure de la table `detailsrequests`
--

DROP TABLE IF EXISTS `detailsrequests`;
CREATE TABLE IF NOT EXISTS `detailsrequests` (
  `detailsRequests_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_reference` int(11) NOT NULL,
  `request_billNumber` int(11) NOT NULL,
  `quantity` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`detailsRequests_id`),
  KEY `FKb48mpwsjoqddn8xa6fr3gxww3` (`request_billNumber`),
  KEY `FKi7duyw5yh2ywoa6fusbrj63of` (`product_reference`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `detailsrequests`
--

INSERT INTO `detailsrequests` (`detailsRequests_id`, `product_reference`, `request_billNumber`, `quantity`) VALUES
(14, 5, 31, 13),
(15, 6, 31, 2),
(16, 7, 32, 1),
(17, 8, 32, 1),
(18, 5, 33, 1),
(19, 7, 33, 1),
(20, 8, 33, 1),
(21, 8, 34, 1),
(22, 6, 35, 1),
(23, 7, 35, 1),
(24, 7, 36, 1),
(25, 8, 36, 1),
(26, 5, 37, 1),
(27, 6, 38, 1);

-- --------------------------------------------------------

--
-- Structure de la table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `product_reference` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `weight` float DEFAULT NULL,
  `numberStock` int(10) NOT NULL,
  `priceUnit` float NOT NULL,
  `commentary` text,
  `tva_id` int(11) NOT NULL,
  PRIMARY KEY (`product_reference`),
  KEY `FKdaawwdfed9ysr9um43mx8sl33` (`tva_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `products`
--

INSERT INTO `products` (`product_reference`, `name`, `brand`, `type`, `weight`, `numberStock`, `priceUnit`, `commentary`, `tva_id`) VALUES
(5, 'Frêne', 'Haut-Bois', 'Bois', 10, 100, 10, 'Le frêne, arbre du genre Fraxinus, appartient à la famille des Oléacées ; une soixantaine d\'espèces de frênes sont connues, elles vivent essentiellement dans les forêts tempérées. Caractérisées par des feuilles composées pennées, elles sont reconnaissables à leurs grappes de samares simples surnommées localement « langues d\'oiseau ». ', 1),
(6, 'Châtaigner', 'Maison Copeaux', 'Bois', 10, 100, 11, '', 1),
(7, 'Marbre', 'Sergeant Pierre Qui Roule (SPQR)', 'Pierre', 20, 130, 32.5, 'En géologie, le marbre est une roche métamorphique dérivée du calcaire et constituée principalement de cristaux de calcite. En architecture, sculpture et marbrerie ce terme peut désigner n\'importe quelle pierre difficile à tailler et capable de prendre un beau poli, dont les plus courantes sont les « vrais » marbres (au sens géologique). ', 2),
(8, 'Sapin', 'Haut-Bois', 'Bois', 8, 70, 17.5, '', 1);

-- --------------------------------------------------------

--
-- Structure de la table `requests`
--

DROP TABLE IF EXISTS `requests`;
CREATE TABLE IF NOT EXISTS `requests` (
  `request_billNumber` int(20) NOT NULL AUTO_INCREMENT,
  `dateCreation` date NOT NULL,
  `dateDelivery` date DEFAULT NULL,
  `confirmation` tinyint(1) NOT NULL,
  `deliveryplace` varchar(255) DEFAULT NULL,
  `client_id` int(20) NOT NULL,
  PRIMARY KEY (`request_billNumber`),
  KEY `FKljmj9fpy346ea5hejj9ej6x6o` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `requests`
--

INSERT INTO `requests` (`request_billNumber`, `dateCreation`, `dateDelivery`, `confirmation`, `deliveryplace`, `client_id`) VALUES
(31, '2017-01-14', '2017-02-04', 1, '6, boulevard Amiral Courbet 69600 OULLINS ', 7),
(32, '2018-02-12', '2018-03-08', 1, '22, rue des Coudriers 31600 MURET', 8),
(33, '2017-02-09', '2017-03-05', 1, '72, rue Ernest Renan52000 CHAUMONT ', 9),
(34, '2018-04-02', '2018-05-20', 1, '9, cours Franklin Roosevelt 13007 MARSEILLE ', 7),
(35, '2018-05-28', '2018-06-14', 1, '71, rue Clement Marot 66100 PERPIGNAN ', 10),
(36, '2018-07-18', NULL, 0, NULL, 10),
(37, '2016-10-22', '2016-11-28', 1, '14, rue du Président Roosevelt 49400 SAUMUR ', 11),
(38, '2017-11-24', '2017-12-09', 1, '48, rue de l\'Epeule 97440 SAINT-ANDRÉ ', 12);

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

DROP TABLE IF EXISTS `tva`;
CREATE TABLE IF NOT EXISTS `tva` (
  `Tva_id` int(11) NOT NULL AUTO_INCREMENT,
  `Taux` double NOT NULL,
  `Nom` varchar(250) NOT NULL,
  PRIMARY KEY (`Tva_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tva`
--

INSERT INTO `tva` (`Tva_id`, `Taux`, `Nom`) VALUES
(1, 20, 'Taxe normal'),
(2, 10, 'Intermédiaire'),
(3, 5.5, 'Réduit'),
(4, 2.1, 'Spécifique');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mmns67o5v4bfippoqitu4v3t6` (`userName`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `detailsrequests`
--
ALTER TABLE `detailsrequests`
  ADD CONSTRAINT `FK_DetailsRequests_Produit` FOREIGN KEY (`product_reference`) REFERENCES `products` (`product_reference`),
  ADD CONSTRAINT `FK_DetailsRequests_Request` FOREIGN KEY (`request_billNumber`) REFERENCES `requests` (`request_billNumber`),
  ADD CONSTRAINT `FKb48mpwsjoqddn8xa6fr3gxww3` FOREIGN KEY (`request_billNumber`) REFERENCES `requests` (`request_billNumber`),
  ADD CONSTRAINT `FKi7duyw5yh2ywoa6fusbrj63of` FOREIGN KEY (`product_reference`) REFERENCES `products` (`product_reference`);

--
-- Contraintes pour la table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK_Products_Tva` FOREIGN KEY (`tva_id`) REFERENCES `tva` (`Tva_id`),
  ADD CONSTRAINT `FKdaawwdfed9ysr9um43mx8sl33` FOREIGN KEY (`tva_id`) REFERENCES `tva` (`Tva_id`);

--
-- Contraintes pour la table `requests`
--
ALTER TABLE `requests`
  ADD CONSTRAINT `FK_Request_Client` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`),
  ADD CONSTRAINT `FKljmj9fpy346ea5hejj9ej6x6o` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
