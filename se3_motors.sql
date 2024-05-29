-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3310
-- Généré le : lun. 27 mai 2024 à 20:16
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `se3_motors`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `name`, `email`, `password`, `tel`) VALUES
(1, 'Admin', 'admin@gmail.com', '12345', 675512648);

-- --------------------------------------------------------

--
-- Structure de la table `brand`
--

CREATE TABLE `brand` (
  `brandId` varchar(255) NOT NULL,
  `brandName` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `brand`
--

INSERT INTO `brand` (`brandId`, `brandName`, `description`) VALUES
('28dd9204-be82-4fba-98d8-5a06d87f1c73', 'Audi', 'The Audi, a high-performance mid-engine supercar.'),
('8b518290-7d1d-4e29-8096-85f299a811bc', 'Volswagen II', ''),
('e67eb586-0fd7-4a1d-9144-a9f4321883f9', 'Toyota Am', '');

-- --------------------------------------------------------

--
-- Structure de la table `cars`
--

CREATE TABLE `cars` (
  `carId` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `numberOfCarsAvailable` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `otherDetails` text NOT NULL,
  `brandId` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cars`
--

INSERT INTO `cars` (`carId`, `model`, `price`, `numberOfCarsAvailable`, `year`, `otherDetails`, `brandId`, `image`) VALUES
('147203dd-cfc8-4c57-97ba-08668f007384', 'Tesla Model S', 2500000, 2, 2021, 'The Tesla Model S, a revolutionary all-electric luxury sedan.', '8b518290-7d1d-4e29-8096-85f299a811bc', 'uploads\\TeslaModelS.jpg'),
('14a2ab2c-9386-4688-a8bc-a143703e612e', 'Audi R8', 150000000, 5, 2017, 'The Audi R8, a high-performance mid-engine supercar.\r\n\r\n', '28dd9204-be82-4fba-98d8-5a06d87f1c73', 'uploads\\AudiR8.jpg'),
('35aa8ecf-836a-40a0-85bb-39ed7171078d', 'Lamborghini Aventador', 3250000, 1, 2018, 'Powerful and sleek, the Lamborghini Aventador is a true supercar.', 'e67eb586-0fd7-4a1d-9144-a9f4321883f9', 'uploads\\LamborghiniAventador.jpg'),
('35ac35a2-7a4e-45f1-8ed2-9e136a051d53', 'Ford Mustang GT', 2500000, 2, 2020, 'The iconic Ford Mustang GT, a classic American muscle car.', '8b518290-7d1d-4e29-8096-85f299a811bc', 'uploads\\FordMustangGT.jpg'),
('80609bb4-122f-4a38-8d85-18eb4604baf6', 'DAS Auto', 2500000, 2, 2021, '', 'e67eb586-0fd7-4a1d-9144-a9f4321883f9', 'uploads\\error-pic.jpg'),
('a72fc42d-48c9-4746-8101-d6d41ea97f59', 'Porsche 911 Turbo', 1750000, 1, 2019, 'The Porsche 911 Turbo, a high-performance sports car icon.', '8b518290-7d1d-4e29-8096-85f299a811bc', 'uploads\\Porsche911Turbo.png'),
('cbf052f8-1f94-43cd-8783-2d091828b0ad', 'Toyota Land Cruiser', 25000000, 1, 2019, 'MToyota Land Cruiser, Rugged, Reliable, Versatile. Iconic SUV renowned for off-road capability and durability.', 'e67eb586-0fd7-4a1d-9144-a9f4321883f9', 'uploads\\ToyotaLandCruiser.jpg'),
('d551a2e3-9d1b-4495-b8a1-477fa50e091e', 'BMW M3', 3500000, 1, 2020, 'The BMW M3, a iconic high-performance sports sedan.\r\n\r\n', '28dd9204-be82-4fba-98d8-5a06d87f1c73', 'uploads\\BMWM3.jpg');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`brandId`);

--
-- Index pour la table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`carId`),
  ADD KEY `brandId` (`brandId`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cars`
--
ALTER TABLE `cars`
  ADD CONSTRAINT `cars_ibfk_1` FOREIGN KEY (`brandId`) REFERENCES `brand` (`brandId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
