-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 17 avr. 2023 à 19:58
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `jee`
--

-- --------------------------------------------------------

--
-- Structure de la table `notation`
--

CREATE TABLE `notation` (
  `id` bigint(20) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `value2` int(11) DEFAULT NULL,
  `value3` int(11) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `notation`
--

INSERT INTO `notation` (`id`, `value`, `value2`, `value3`, `user_id`) VALUES
(1, 10, 8, 5, 1),
(2, NULL, 8, NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
(1, 'ui@ui.ui', 'ui', 'ui', '$2a$10$zDqjr1.eEh.o9pzwWW/zNumz3Mv1FfqyimSw73CakBUGFt.QRFxU2'),
(2, 'non@non.non', 'non', 'non', '$2a$10$9jy52BOH5/jxvmUHVU5piu7L2Qu4sr6mIc2TJ1qV308aNxseHCGMq');

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `notation`
--
ALTER TABLE `notation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8cai0bja041o3ixvlthrqotto` (`user_id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- Index pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  ADD KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `notation`
--
ALTER TABLE `notation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `notation`
--
ALTER TABLE `notation`
  ADD CONSTRAINT `FK8cai0bja041o3ixvlthrqotto` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
