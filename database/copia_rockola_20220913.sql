-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: rockola
-- ------------------------------------------------------
-- Server version	5.7.34-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cancion`
--

DROP TABLE IF EXISTS `cancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `aniopublicacion` int(11) NOT NULL,
  `duracion` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `interprete` varchar(100) NOT NULL,
  `compositor` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cancion_genero_musical_idx` (`genero`),
  KEY `fk_cancion_interprete_idx` (`interprete`),
  KEY `fk_cancion_compositor_idx` (`compositor`),
  CONSTRAINT `fk_cancion_compositor1` FOREIGN KEY (`compositor`) REFERENCES `compositor` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cancion_genero_musical1` FOREIGN KEY (`genero`) REFERENCES `generomusical` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cancion_interprete1` FOREIGN KEY (`interprete`) REFERENCES `interprete` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancion`
--

LOCK TABLES `cancion` WRITE;
/*!40000 ALTER TABLE `cancion` DISABLE KEYS */;
/*!40000 ALTER TABLE `cancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `numdocumento` int(11) NOT NULL,
  `tipodocumento` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `edad` int(2) NOT NULL,
  `correo` varchar(45) NOT NULL,
  PRIMARY KEY (`numdocumento`),
  UNIQUE KEY `num_documento_UNIQUE` (`numdocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1234523,'Cédula de ciudadanía','Juan','Correa',23,'juan@gmail.com'),(12324522,'Cédula de ciudadanía','Juan Sebastian','Rodriguez Correa',23,'juan22@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compositor`
--

DROP TABLE IF EXISTS `compositor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compositor` (
  `nombre` varchar(100) NOT NULL,
  `fechanacimiento` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compositor`
--

LOCK TABLES `compositor` WRITE;
/*!40000 ALTER TABLE `compositor` DISABLE KEYS */;
/*!40000 ALTER TABLE `compositor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `cliente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cuenta_cliente_idx` (`cliente`),
  CONSTRAINT `fk_cuenta_cliente1` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`numdocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentahasrol`
--

DROP TABLE IF EXISTS `cuentahasrol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentahasrol` (
  `cuentaid` int(11) NOT NULL,
  `rolnombre` varchar(45) NOT NULL,
  PRIMARY KEY (`cuentaid`,`rolnombre`),
  KEY `fk_cuenta_has_rol_rol_idx` (`rolnombre`),
  KEY `fk_cuenta_has_rol_cuenta_idx` (`cuentaid`),
  CONSTRAINT `fk_cuenta_has_rol_cuenta1` FOREIGN KEY (`cuentaid`) REFERENCES `cuenta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cuenta_has_rol_rol1` FOREIGN KEY (`rolnombre`) REFERENCES `rol` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentahasrol`
--

LOCK TABLES `cuentahasrol` WRITE;
/*!40000 ALTER TABLE `cuentahasrol` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentahasrol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generomusical`
--

DROP TABLE IF EXISTS `generomusical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generomusical` (
  `nombre` varchar(45) NOT NULL,
  `carpeta` varchar(45) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `carpeta_UNIQUE` (`carpeta`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generomusical`
--

LOCK TABLES `generomusical` WRITE;
/*!40000 ALTER TABLE `generomusical` DISABLE KEYS */;
/*!40000 ALTER TABLE `generomusical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interprete`
--

DROP TABLE IF EXISTS `interprete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interprete` (
  `nombre` varchar(100) NOT NULL,
  `fechanacimiento` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interprete`
--

LOCK TABLES `interprete` WRITE;
/*!40000 ALTER TABLE `interprete` DISABLE KEYS */;
/*!40000 ALTER TABLE `interprete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `fechacreacion` varchar(45) NOT NULL,
  `numcanciones` bigint(20) NOT NULL,
  `cuenta` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_playlist_cuenta_idx` (`cuenta`),
  CONSTRAINT `fk_playlist_cuenta1` FOREIGN KEY (`cuenta`) REFERENCES `cuenta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlisthascancion`
--

DROP TABLE IF EXISTS `playlisthascancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlisthascancion` (
  `playlistid` int(11) NOT NULL,
  `cancionid` int(11) NOT NULL,
  PRIMARY KEY (`playlistid`,`cancionid`),
  KEY `fk_playlist_has_cancion_cancion_idx` (`cancionid`),
  KEY `fk_playlist_has_cancion_playlist_idx` (`playlistid`),
  CONSTRAINT `fk_playlist_has_cancion_cancion1` FOREIGN KEY (`cancionid`) REFERENCES `cancion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_has_cancion_playlist1` FOREIGN KEY (`playlistid`) REFERENCES `playlist` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlisthascancion`
--

LOCK TABLES `playlisthascancion` WRITE;
/*!40000 ALTER TABLE `playlisthascancion` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlisthascancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-13 17:43:17
