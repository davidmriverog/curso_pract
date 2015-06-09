-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.33-MariaDB - openSUSE package
-- SO del servidor:              Linux
-- HeidiSQL Versión:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para bd_crud
DROP DATABASE IF EXISTS `bd_crud`;
CREATE DATABASE IF NOT EXISTS `bd_crud` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_crud`;


-- Volcando estructura para tabla bd_crud.contactos
DROP TABLE IF EXISTS `contactos`;
CREATE TABLE IF NOT EXISTS `contactos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `nombre_completo` varchar(255) DEFAULT NULL,
  `cedula` int(11) DEFAULT NULL,
  `cedula_holder` int(11) DEFAULT NULL,
  `holder` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `holder` (`holder`),
  CONSTRAINT `contactos_ibfk_1` FOREIGN KEY (`holder`) REFERENCES `holders` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_crud.contactos: ~2 rows (aproximadamente)
DELETE FROM `contactos`;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` (`id`, `nombres`, `apellidos`, `nombre_completo`, `cedula`, `cedula_holder`, `holder`) VALUES
	(1, 'David', 'Rivero', 'David Rivero', 23456789, 23456789, 1),
	(2, 'Leyla', 'Rivero', 'Leyla de Rivero', 32456789, 23456789, 2);
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;


-- Volcando estructura para tabla bd_crud.holders
DROP TABLE IF EXISTS `holders`;
CREATE TABLE IF NOT EXISTS `holders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_crud.holders: ~2 rows (aproximadamente)
DELETE FROM `holders`;
/*!40000 ALTER TABLE `holders` DISABLE KEYS */;
INSERT INTO `holders` (`id`, `nombre`) VALUES
	(1, 'Titular'),
	(2, 'Beneficiario');
/*!40000 ALTER TABLE `holders` ENABLE KEYS */;


-- Volcando estructura para tabla bd_crud.pedidos
DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contactos_id` int(11) DEFAULT NULL,
  `fecha_emision` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `monto_pagar` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `contactos_id` (`contactos_id`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`contactos_id`) REFERENCES `contactos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_crud.pedidos: ~2 rows (aproximadamente)
DELETE FROM `pedidos`;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` (`id`, `contactos_id`, `fecha_emision`, `fecha_entrega`, `monto_pagar`) VALUES
	(1, 1, '2015-06-08', '2016-06-15', 3500),
	(2, 2, '2015-06-08', '2015-06-10', 1600);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
