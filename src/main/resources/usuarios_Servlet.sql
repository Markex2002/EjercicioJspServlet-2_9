-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 23-08-2014 a las 11:18:07
-- Versión del servidor: 5.5.38-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `baloncesto`
--
CREATE DATABASE IF NOT EXISTS `DB_jspEjercicio2_9` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `DB_jspEjercicio2_9`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usuarioID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `password` varchar(40) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`usuarioID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuarioID`, `nombre`, `password`) VALUES
(1235, 'admin', 'admin'),
(1236, 'usuario1', '1234'),
(1237, 'usuario2', '1234'),
(1238, 'usuario3', '1234'),
(1239, 'usuario4', '1234');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;