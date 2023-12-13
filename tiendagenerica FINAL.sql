-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2023 a las 03:09:16
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendagenerica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cheques`
--

CREATE TABLE `cheques` (
  `consecutivocheque` int(11) NOT NULL,
  `codigocompra` int(11) NOT NULL,
  `nitproveedor` text NOT NULL,
  `totalconiva` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cedula` text NOT NULL,
  `nombrecompleto` text NOT NULL,
  `direccion` text NOT NULL,
  `telefono` text NOT NULL,
  `coreoelectronico` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`cedula`, `nombrecompleto`, `direccion`, `telefono`, `coreoelectronico`) VALUES
('2345678', 'Laura Mina', 'Faraday', '20304049', 'lsmo000r@yahoo.com'),
('1039494939', 'Sofia Morales', 'Cra 58C # 1420', '40200491', 'sofiamh568@outlook.com'),
('1039494939', 'Sofia Morales', 'Cra 58C # 1420', '40200491', 'sofiamh568@outlook.com'),
('1039494939', 'Sofia Morales', 'Cra 58C # 1420', '40200491', 'sofiamh568@outlook.com'),
('1039494939', 'Sofia Morales', 'Cra 58C # 1420', '40200491', 'sofiamh568@outlook.com'),
('1039494939', 'Sofia Morales', 'Cra 58C # 1420', '40200491', 'sofiamh568@outlook.com'),
('1039494939', 'Sofia Morales', 'Cra 58C # 1420', '40200491', 'sofiamh568@outlook.com'),
('2345678', 'Laura Mina', 'Cra 6934', '20304291', 'lsmor@yahoo.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `codigocompra` int(11) NOT NULL,
  `nitproveedor` text NOT NULL,
  `totalcompra` float NOT NULL,
  `valoriva` float NOT NULL,
  `totalmasiva` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompras`
--

CREATE TABLE `detallecompras` (
  `codigodetallecompra` int(11) NOT NULL,
  `codigoproducto` text NOT NULL,
  `codigocompra` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `valorunitario` float NOT NULL,
  `valortotal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventas`
--

CREATE TABLE `detalleventas` (
  `codigodetalleventa` int(11) NOT NULL,
  `codigoproducto` int(11) NOT NULL,
  `codigoventa` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `valorunitario` float NOT NULL,
  `valortotal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalleventas`
--

INSERT INTO `detalleventas` (`codigodetalleventa`, `codigoproducto`, `codigoventa`, `cantidad`, `valorunitario`, `valortotal`) VALUES
(1, 12345678, 1234, 1, 1234, 1234),
(0, 12345678, 0, 1, 0, 0),
(0, 12345678, 0, 2, 0, 0),
(0, 12345678, 0, 22, 0, 0),
(0, 12345678, 0, 3, 0, 0),
(0, 12345678, 0, 3, 0, 0),
(0, 12345678, 0, 12, 0, 0),
(0, 12345678, 0, 2, 0, 0),
(0, 12345678, 0, 3, 0, 0),
(0, 5430, 0, 1, 0, 0),
(0, 12345678, 0, 12, 0, 0),
(0, 12345678, 0, 2, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametros`
--

CREATE TABLE `parametros` (
  `nit` int(12) NOT NULL,
  `tipocomercio` text NOT NULL,
  `nombretienda` text NOT NULL,
  `ciudadtienda` text NOT NULL,
  `valoriva` float NOT NULL,
  `tasainteres` float NOT NULL,
  `banco` text NOT NULL,
  `cuentacorriente` text NOT NULL,
  `nombregerente` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `parametros`
--

INSERT INTO `parametros` (`nit`, `tipocomercio`, `nombretienda`, `ciudadtienda`, `valoriva`, `tasainteres`, `banco`, `cuentacorriente`, `nombregerente`) VALUES
(10203040, 'papitas', 'ANA', 'Bogota', 0, 0, 'Davivienda', '10304020', 'Sofia'),
(10203040, 'papitas', 'ANA', 'Bogota', 0, 0, 'Davivienda', '10304020', 'Sofia'),
(10203040, 'papitas', 'ANA', 'Bogota', 0, 0, 'Davivienda', '10304020', 'Sofia'),
(123456789, 'Pan', 'ki', 'Bogota', 0.19, 0.19, 'Din', '111111111111111111', 'ki'),
(1234, 'Pan', 'ki', 'Bogota', 0.19, 0.19, 'Din', '111111111111111111', 'ki'),
(2345678, 'jua', 'as', 's', 0.19, 0.19, 'ju', '23456', 'as'),
(2345678, 'jua', 'as', 's', 19, 19, 'ju', '23456', 'as'),
(98765436, 'Pan', 'JULIIIIIIIIIII', 'NEW YORK', 0.19, 23, 'USABANK', '23456', 'HARRYSTYLES'),
(2345678, 'Pan', 'JULIIIIIIIIIII', 'SKI', 0.19, 6, 'USABANK', '23456', 'HARRYSTYLES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigoproducto` int(11) NOT NULL,
  `nombreproducto` text NOT NULL,
  `nitproveedor` text NOT NULL,
  `preciocompra` float NOT NULL,
  `precioventa` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigoproducto`, `nombreproducto`, `nitproveedor`, `preciocompra`, `precioventa`) VALUES
(987654322, 'Platano', '432345678', 9, 0),
(12345678, 'Leche Entera', '234567890', 1234, 1234),
(123456783, 'Leche Entera', '1234', 0, 0),
(543, 'Cafe', '1234', 9, 9),
(5430, 'Cafe', '8888', 29, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `nit` text NOT NULL,
  `nombreproveedor` text NOT NULL,
  `direccion` text NOT NULL,
  `telefono` text NOT NULL,
  `ciudad` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`nit`, `nombreproveedor`, `direccion`, `telefono`, `ciudad`) VALUES
('302919382', 'Sofia MoralesH', 'Cra 58C # 1420', '40200491', 'Medellin'),
('987654321', 'Sofia MoralesH', 'Cra 58C # 1420', '40200491', 'Medellin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablaamortizacion`
--

CREATE TABLE `tablaamortizacion` (
  `codigoamortizacion` int(11) NOT NULL,
  `codigocredito` int(11) NOT NULL,
  `numerocuota` int(11) NOT NULL,
  `saldo` float NOT NULL,
  `cuotapesos` float NOT NULL,
  `intereses` float NOT NULL,
  `amortizacion` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablacreditos`
--

CREATE TABLE `tablacreditos` (
  `codigoamortizacion` int(11) NOT NULL,
  `codigocredito` int(11) NOT NULL,
  `codigoventa` int(11) NOT NULL,
  `cedulacliente` text NOT NULL,
  `numerocuota` int(11) NOT NULL,
  `saldo` float NOT NULL,
  `cuotapesos` float NOT NULL,
  `intereses` float NOT NULL,
  `amortizacion` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `codigoventa` int(11) NOT NULL,
  `cedulacliente` text NOT NULL,
  `totalventa` float NOT NULL,
  `valoriva` float NOT NULL,
  `totalmasiva` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventasporcuotas`
--

CREATE TABLE `ventasporcuotas` (
  `codigoventacuotas` int(11) NOT NULL,
  `cedulacliente` text NOT NULL,
  `codigoventa` int(11) NOT NULL,
  `montoafinanciar` float NOT NULL,
  `tasanominal` float NOT NULL,
  `tasaefectiva` float NOT NULL,
  `anualidad` float NOT NULL,
  `cuotapesos` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventasporcuotas`
--

INSERT INTO `ventasporcuotas` (`codigoventacuotas`, `cedulacliente`, `codigoventa`, `montoafinanciar`, `tasanominal`, `tasaefectiva`, `anualidad`, `cuotapesos`) VALUES
(1234, '2345678', 12345678, 0.19, 0.19, 0.19, 0.19, 0.19);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
