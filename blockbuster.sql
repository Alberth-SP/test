-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2025 at 02:26 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blockbuster`
--

-- --------------------------------------------------------

--
-- Table structure for table `pelicula`
--

CREATE TABLE `pelicula` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `genero` tinyint(4) NOT NULL,
  `clasificacion` varchar(1) NOT NULL,
  `duracion` varchar(20) NOT NULL,
  `director` varchar(100) NOT NULL,
  `actores` varchar(150) NOT NULL,
  `sinopsis` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `pelicula`
--

INSERT INTO `pelicula` (`id`, `nombre`, `genero`, `clasificacion`, `duracion`, `director`, `actores`, `sinopsis`) VALUES
(2, 'MEGALODON', 1, 'A', '1:53', 'MARC FORSTER', 'RUBEN FLEISCHER', 'CUANDO UNA JOVEN MONJA SE SUICIDA EN UN AISLADO MONASTERIO EN RUMANIA, ...'),
(3, 'ANIMALES FANTASTICOS', 3, 'C', '1:45', 'BOYD HOLBROOK', 'RUBEN FLEISCHER, ROBIN GIVENSE', 'AMBER, UNA JOVEN MADRE, DEVOTA Y AMOROSA, LUCHA POR HACER LO MEJOR QUE PUEDE ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
