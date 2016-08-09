-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-08-2016 a las 23:23:23
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ejemplo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulodescrip`
--

CREATE TABLE `articulodescrip` (
  `idCodigo` int(11) NOT NULL,
  `idArticulo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `articulodescrip`
--

INSERT INTO `articulodescrip` (`idCodigo`, `idArticulo`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `idCodigo` int(11) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `modelo` varchar(25) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`idCodigo`, `marca`, `modelo`, `nombre`) VALUES
(1, 'Liliana', 'Al-516.600w 1.2 Litros', 'Licuadoras Liliana'),
(2, 'Oster', '6805 RGO', 'Licuadora Oster'),
(3, 'ELECTROLUX', 'EHF A09T5AJS', 'LAVAVAJILLAS ELECTROLUX'),
(4, 'DREAN', 'DREAN NEXT! 8.14', 'LAVARROPAS AUTOMÁTICO DREAN NEXT! 8.14'),
(5, 'BGH', 'B120M1', 'MICROONDAS BGH'),
(6, 'SAMSUNG', 'UN40JU6000G', 'TELEVISOR LED 40" SAMSUNG'),
(7, 'CANON', 'EOS REBEL T5', 'CAMARA CANON'),
(8, 'PANASONIC', 'RF-P50GC9-S', 'RADIO PANASONIC'),
(9, 'SONY', 'SONY PLAYSTATION', 'CONSOLA PLAY STATION 4 PS4 500 GB');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descripcion`
--

CREATE TABLE `descripcion` (
  `idArticulo` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `imagen` text NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `descripcion`
--

INSERT INTO `descripcion` (`idArticulo`, `stock`, `descripcion`, `imagen`, `precio`) VALUES
(1, 98, 'Licuadora Liliana Shake con cuchilla dentada para optimizar todos los usos. Pico vertedor, Capacidad 1.2 lts. 3 velocidades + pulsador. Potencia: 600 watts. Industria Argentina.', 'licuadoras-liliana-al-600w-12-litros.jpg', 629),
(2, 99, 'Licuadora Oster 12 Velocidades Jarra De Vidrio Roja 6805-rgo', 'licuadora-oster-12-velocidades-jarra-de-vidrio-roja.jpg', 1110),
(3, 98, 'Modelo<br> 	EHFA09T5AJS <br>Familia<br> 	Lavavajillas  <br>Capacidad<br> 	9 Cubiertos <br>Cantidad De Programas<br> 	6<br> Dosificador De Detergente 	si <br>Panel (digital o mecanico) 	digital <br>Caracteristicas Adicionales 	<br>Opción de flotación ~ Filtro: principal/inferior ~ Cesta superior ajustable ~ Cesta inferior : estante plegable ~ Secado residual <br>Color 	plateado <br>Alto (en cm) 	84 <br>Ancho (en cm) 	45 <br>Profundidad (en cm) 	58 <br>Pais de Origen 	CHINA', 'LAVAVAJILLAS ELECTROLUX EHFA09T5AJS.jpg', 8499.15),
(4, 2, 'Mantenimiento Predictivo. Luz Interior de Tambor<br> Lavado Personalizado: Podes armar tu propia rutina de lavado y activarla con sólo apretar un botón<br> Display LCD Táctil<br> Puerta Extra Grande: Con apertura instantánea y de 180º <br>Tambor Elevado: Mejor ergonomía para un acceso más fácil <br>Aviso Sonoro: Para interacciones con el usuario<br> 1400 RPM - 8 Kg - Clase AAA <br>Super Silencioso y Económico (ahorra hasta un 20% respecto a un motor de Clase A) <br>Jabonera con Dispensers Específicos.<br>', 'LAVARROPAS AUTOMÁTICO DREAN NEXT! 8.14.jpg', 10199.2),
(5, 11, 'Descongelamiento automático de 2 categorías', 'MICROONDAS BGH B120M1 20LTS MECÁNICO.jpg', 2783),
(6, 9, 'LED 40" SAMSUNG UN40JU6000G', 'TELEVISOR LED 40_ SAMSUNG UN40JU6000G.jpg', 11999),
(7, 4, 'CAMARA CANON EOS REBEL T5', 'CAMARA CANON EOS REBEL T5.jpg', 12749),
(8, 1, 'RADIO PANASONIC RF-P50GC9-S PLATA', 'RADIO PANASONIC RF-P50GC9-S PLATA.jpg', 299),
(9, 9, 'Consola PS4 500 GB de capacidad.', 'CONSOLA PLAY STATION 4 PS4 500 GB.jpg', 8999);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `email` varchar(40) NOT NULL,
  `user` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `rol` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`email`, `user`, `password`, `rol`) VALUES
('admin@admin.com', '', 'admin', 'admin'),
('user@user.com', 'Usuario', 'user', 'user'),
('usuario1@usuario1.com', 'usuario 1', 'usuario1', 'user');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulodescrip`
--
ALTER TABLE `articulodescrip`
  ADD PRIMARY KEY (`idCodigo`);

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`idCodigo`);

--
-- Indices de la tabla `descripcion`
--
ALTER TABLE `descripcion`
  ADD PRIMARY KEY (`idArticulo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`email`(10));

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
