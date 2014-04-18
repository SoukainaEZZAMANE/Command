-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Sam 12 Avril 2014 à 23:41
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `commande`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `solde` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `solde`) VALUES
(1, 'EZZAMANE', 35303),
(2, 'ELKHOUFAIRI', 2291201);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateCommande` varchar(30) NOT NULL,
  `dateEcheance` varchar(30) NOT NULL,
  `montant` double NOT NULL,
  `paiementActuel` double NOT NULL,
  `id_client` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_client` (`id_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`id`, `dateCommande`, `dateEcheance`, `montant`, `paiementActuel`, `id_client`) VALUES
(6, '21-02-14', '30-05-14', 7599, 1527, 1),
(8, '21-04-14', '30-08-14', 16448, 125, 1),
(9, '12-12-14', '01-10-15', 7142, 1935, 1),
(10, '12-04-14', '13-02-15', 7918, 1256, 2),
(16, '2014-04-05', '2014-04-06', 269587, 559, 2);

-- --------------------------------------------------------

--
-- Structure de la table `commandeitem`
--

CREATE TABLE IF NOT EXISTS `commandeitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prix` double NOT NULL,
  `quantite` double NOT NULL,
  `id_produit` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `commandeitem`
--

INSERT INTO `commandeitem` (`id`, `prix`, `quantite`, `id_produit`, `id_commande`) VALUES
(1, 152, 12, 1, 8),
(2, 123, 12, 2, 6),
(3, 500, 12, 2, 6),
(4, 123, 2, 1, 9),
(5, 123, 52, 1, 10),
(6, 123, 52, 1, 9),
(7, 123, 12, 2, 8),
(8, 1235, 12, 1, 8),
(9, 1522, 152, 2, 16),
(10, 159, 152, 2, 16),
(11, 159, 15, 2, 16),
(12, 123, 85, 2, 16);

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE IF NOT EXISTS `paiement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datePaiement` varchar(30) NOT NULL,
  `montant` double NOT NULL,
  `id_commande` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_commande` (`id_commande`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `paiement`
--

INSERT INTO `paiement` (`id`, `datePaiement`, `montant`, `id_commande`) VALUES
(1, '12-15-14', 123, 6),
(3, '12-10-14', 145, 6),
(4, '21-05-14', 500, 6),
(5, '21-05-14', 500, 6),
(6, '21-12-14', 1526, 6),
(7, '21-12-14', 1, 6),
(8, '12-04-12', 125, 8),
(9, '12-04-12', 1250, 9),
(10, '12-04-12', 1256, 10),
(11, '2014-04-05', 123, 9),
(12, '2014-04-06', 562, 9),
(13, '2014-04-12', 236, 16),
(14, '2014-04-12', 200, 16);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) NOT NULL,
  `stock` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `libelle`, `stock`) VALUES
(1, 'Lait', 1035),
(2, 'Sucre', 1071);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `paiement_ibfk_1` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
