-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: produccion
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bitacora`
--

DROP TABLE IF EXISTS `bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacora` (
  `idBitacora` int(11) NOT NULL,
  `idUsuario` varchar(12) NOT NULL,
  `fechaModifica` date NOT NULL,
  `tipoAccion` varchar(20) NOT NULL,
  `tabla` varchar(45) NOT NULL,
  `registro` varchar(1000) NOT NULL,
  PRIMARY KEY (`idBitacora`),
  KEY `fk_Bitacora_Usuario_idx` (`idUsuario`),
  CONSTRAINT `fk_Bitacora_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora`
--

LOCK TABLES `bitacora` WRITE;
/*!40000 ALTER TABLE `bitacora` DISABLE KEYS */;
/*!40000 ALTER TABLE `bitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bobinafardo`
--

DROP TABLE IF EXISTS `bobinafardo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bobinafardo` (
  `idBobinaFardo` varchar(100) NOT NULL,
  `peso` float NOT NULL,
  `cantidad` float DEFAULT NULL,
  `idOperario` int(11) NOT NULL,
  `idSupervisor` int(11) NOT NULL,
  `idBodega` int(11) NOT NULL,
  `horaInicio` datetime NOT NULL,
  `horaFinal` datetime NOT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `idBobinaFardoEntrada` varchar(100) DEFAULT NULL,
  `pesoEntrada` float DEFAULT NULL,
  `idOrden` int(11) NOT NULL,
  `secuencial` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBobinaFardo`),
  KEY `fk_BobinasFardo_Empleado_idx` (`idOperario`),
  KEY `fk_BobinasFardo_Bodega_idx` (`idBodega`),
  KEY `fk_BobinasFardo_EmpleadoS_idx` (`idSupervisor`),
  KEY `fk_BobinaFardo_OrdenProduccion_idx` (`idOrden`),
  CONSTRAINT `fk_BobinaFardo_Bodega` FOREIGN KEY (`idBodega`) REFERENCES `bodega` (`idBodega`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_BobinaFardo_EmpleadoO` FOREIGN KEY (`idOperario`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_BobinaFardo_EmpleadoS` FOREIGN KEY (`idSupervisor`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_BobinaFardo_OrdenProduccion` FOREIGN KEY (`idOrden`) REFERENCES `ordenproduccion` (`idOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bobinafardo`
--

LOCK TABLES `bobinafardo` WRITE;
/*!40000 ALTER TABLE `bobinafardo` DISABLE KEYS */;
INSERT INTO `bobinafardo` VALUES ('P1-E1-SKU-1',25,0,1,6,1,'2014-05-26 03:10:00','2014-05-26 03:30:00','',NULL,0,1,1),('P1-E1-SKU-2',60.5,0,1,6,1,'2014-08-25 21:20:00','2014-08-25 21:20:00','-',NULL,NULL,1,2),('P1-E1-SKU-3',95,0,1,6,1,'2014-08-25 21:20:00','2014-08-27 22:27:00','-',NULL,NULL,1,3),('P1-E2-SKU-1',45.8,0,2,6,1,'2014-08-25 21:24:51','2014-08-25 21:24:00','esta es la segunda',NULL,NULL,352,1),('P1-E2-SKU-2',35.8,0,1,6,1,'2014-08-25 21:35:00','2014-08-25 21:35:00','-',NULL,NULL,352,2),('P1-E2-SKU-3',49.1,0,1,6,1,'2014-08-25 21:35:00','2014-08-25 22:00:00','-',NULL,NULL,352,3),('P1-E2-SKU-4',50,0,1,6,1,'2014-08-25 22:00:00','2014-08-25 22:30:00','-',NULL,NULL,352,4),('P1-E3-SKU-1',45,0,2,6,1,'2014-08-26 21:30:00','2014-08-26 22:00:00','-',NULL,NULL,552,1),('P2-E4-SKU-1',60.1,0,1,6,1,'2014-08-27 19:00:00','2014-08-27 19:25:00','-',NULL,NULL,602,1),('P2-E4-SKU-2',55.2,0,2,6,1,'2014-08-27 19:25:00','2014-08-27 20:00:00','-',NULL,NULL,602,2),('P2-E4-SKU-3',102.3,0,2,6,1,'2014-08-27 20:00:00','2014-08-27 20:35:00','-',NULL,NULL,602,3),('P2-E4-SKU-4',45,0,2,6,1,'2014-08-27 20:35:00','2014-08-27 20:35:00','-',NULL,NULL,602,4),('P2-E4-SKU-5',120.1,0,2,6,1,'2014-08-27 20:35:00','2014-08-27 21:00:00','-',NULL,NULL,602,5),('P2-E4-SKU-6',75.4,0,1,6,1,'2014-08-27 21:00:00','2014-08-27 20:40:00','-',NULL,NULL,602,6),('P2-E4-SKU-7',77.6,0,1,6,1,'2014-08-27 20:40:00','2014-08-27 20:44:00','-',NULL,NULL,602,7);
/*!40000 ALTER TABLE `bobinafardo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bodega`
--

DROP TABLE IF EXISTS `bodega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bodega` (
  `idBodega` int(11) NOT NULL,
  `codigo` varchar(3) NOT NULL COMMENT 'BMP, BPP, BPT',
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idBodega`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bodega`
--

LOCK TABLES `bodega` WRITE;
/*!40000 ALTER TABLE `bodega` DISABLE KEYS */;
INSERT INTO `bodega` VALUES (1,'BPP','BODEGA DE PRODUCTO EN PROCESO'),(2,'BPT','BODEGA DE PRODUCTO TERMINADO'),(3,'BMP','BODEGA DE MATERIA PRIMA');
/*!40000 ALTER TABLE `bodega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idProveedor` int(11) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_Compra_Persona_idx` (`idProveedor`),
  CONSTRAINT `fk_Compra_Persona` FOREIGN KEY (`idProveedor`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'2014-07-19',3),(2,'2014-07-14',2),(3,'2014-08-04',3),(53,'2014-08-04',3),(103,'2014-08-06',3),(153,'2014-08-04',2),(203,'2014-08-29',3),(253,'2014-08-13',2),(303,'2014-08-23',2),(353,'2014-08-07',3),(403,'2014-08-29',2),(453,'2014-08-05',2),(503,'2014-08-04',2),(504,'2014-08-07',3),(554,'2014-08-25',2);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compradetalle`
--

DROP TABLE IF EXISTS `compradetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compradetalle` (
  `idCompraDet` int(11) NOT NULL,
  `idCompra` int(11) NOT NULL,
  `idMateriaPrima` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  PRIMARY KEY (`idCompraDet`),
  KEY `fk_Compra_Detalle_Compra1_idx` (`idCompra`),
  KEY `fk_Compra_Detalle_Materias Primas1_idx` (`idMateriaPrima`),
  CONSTRAINT `fk_CompraDetalle_Compra` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_CompraDetalle_MateriaPrima` FOREIGN KEY (`idMateriaPrima`) REFERENCES `materiaprima` (`idMateriaPrima`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compradetalle`
--

LOCK TABLES `compradetalle` WRITE;
/*!40000 ALTER TABLE `compradetalle` DISABLE KEYS */;
INSERT INTO `compradetalle` VALUES (1,1,5,5.5),(2,1,6,7.3),(3,1,5,2.6),(4,1,10,3),(5,103,12,4.2),(6,153,3,6.6),(7,153,6,15),(8,203,4,25.6),(9,203,6,35.9),(10,203,2,15.6),(11,253,1,12.5),(12,253,2,10),(13,253,3,8),(14,303,8,14),(15,353,1,2.5),(16,353,2,5.5),(17,353,12,12.3),(18,403,1,13.7),(19,403,2,10),(20,453,6,14.5),(21,503,11,2),(22,503,10,16.5),(23,504,4,50),(24,504,5,60),(25,504,6,100),(73,403,1,60);
/*!40000 ALTER TABLE `compradetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `idPuesto` int(11) NOT NULL,
  `idEstado` varchar(6) NOT NULL COMMENT 'activo, desactivo',
  `idUsuario` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `idPuesto_idx` (`idPuesto`),
  KEY `fk_Empleado_Estado_idx` (`idEstado`),
  KEY `fk_Empleado_Usuario_idx` (`idUsuario`),
  CONSTRAINT `fk_Empleado_Puesto` FOREIGN KEY (`idPuesto`) REFERENCES `puesto` (`idPuesto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Tipo` FOREIGN KEY (`idEstado`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'RODOLFO','CONTRERAS',1,'E00001','ACRUZ'),(2,'ARISTIDES JOSE','RAMIREZ ARGUETA',2,'E00001','ACRUZ'),(3,'CARLOS','SANCHEZ',3,'E00001',NULL),(4,'HERIBERTO','LOPEZ',4,'E00001','ACRUZ'),(5,'OSWALDO','MEJIA',5,'E00001','ACRUZ'),(6,'ERICK FRANCISCO','ALVARADO',6,'E00001','CCASTRO'),(7,'FRANCISCO','CHICAS',7,'E00001',NULL),(8,'NELSON','MENDEZ',8,'E00001',NULL),(9,'OMAR','MARQUEZ',9,'E00001',NULL),(10,'MIGUEL','OLIVARES',10,'E00001',NULL),(11,'EDUARDO','ESCOBAR',11,'E00001',NULL),(12,'ANTONIO','CALDERON',11,'E00001',NULL),(13,'ANDRES','HERNANDEZ',11,'E00001','ACRUZ'),(64,'JUAN CARLOS','BATRES',4,'E00001','CCASTRO');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maquina`
--

DROP TABLE IF EXISTS `maquina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maquina` (
  `idMaquina` int(11) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `idTipoMaq` varchar(6) NOT NULL COMMENT 'valor desde tabla TIPO',
  `idEstado` varchar(6) NOT NULL COMMENT 'activo, desactivo',
  PRIMARY KEY (`idMaquina`),
  KEY `fk_Maquina_Tipo_idx` (`idTipoMaq`),
  KEY `fk_Maquina_Estado_idx` (`idEstado`),
  CONSTRAINT `fk_Maquina_Estado` FOREIGN KEY (`idEstado`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Maquina_Tipo` FOREIGN KEY (`idTipoMaq`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maquina`
--

LOCK TABLES `maquina` WRITE;
/*!40000 ALTER TABLE `maquina` DISABLE KEYS */;
INSERT INTO `maquina` VALUES (1,'185','M00001','E00001'),(2,'186','M00001','E00001'),(3,'4-1','M00002','E00001'),(4,'4-2','M00002','E00001'),(5,'R-1','M00003','E00001'),(6,'R-2','M00003','E00001'),(7,'DOB1','M00004','E00001'),(8,'DOB2','M00004','E00002'),(9,'SL1','M00005','E00001'),(10,'SL2','M00005','E00001');
/*!40000 ALTER TABLE `maquina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiaprima`
--

DROP TABLE IF EXISTS `materiaprima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiaprima` (
  `idMateriaPrima` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idUnidadMedida` int(11) NOT NULL,
  `idBodega` int(11) NOT NULL,
  `existencia` float NOT NULL,
  PRIMARY KEY (`idMateriaPrima`),
  KEY `fk_MateriaPrima_Bodega_idx` (`idBodega`),
  KEY `fk_MateriaPrima_UnidadMedida_idx` (`idUnidadMedida`),
  CONSTRAINT `fk_MateriaPrima_Bodega` FOREIGN KEY (`idBodega`) REFERENCES `bodega` (`idBodega`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MateriaPrima_UnidadMedida` FOREIGN KEY (`idUnidadMedida`) REFERENCES `unidadmedida` (`idUnidadMedida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiaprima`
--

LOCK TABLES `materiaprima` WRITE;
/*!40000 ALTER TABLE `materiaprima` DISABLE KEYS */;
INSERT INTO `materiaprima` VALUES (1,'POLIETILENO HD',1,3,62.7),(2,'POLIETILENO LD',1,3,9.4),(3,'POLIETILENO LLD',1,3,0),(4,'SLIP-ANTIIBLOCK',1,3,50),(5,'BLANCO MB',1,3,60),(6,'SOLVENTE FORMULA',1,3,94.5),(7,'ALCOHOL ISOPROPILICO',1,3,0),(8,'ADITIVO SOLVENTE 2 COMPONENTES',1,3,0),(9,'ANILOX CLEANER',1,3,0),(10,'AMARILLO BENCIDINA',1,3,16.5),(11,'BARNIZ EXTENDER',1,3,20),(12,'AZUL PROCESO',1,3,10.3),(13,'POLIETILENO LD',1,3,9.4555),(14,'POLIETILENO LD',1,3,9.4555),(15,'POLIETILENO LD',1,3,9.4555),(16,'POLIETILENO LD',2,3,9.4555);
/*!40000 ALTER TABLE `materiaprima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `posicion` int(11) NOT NULL,
  PRIMARY KEY (`idMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuperfil`
--

DROP TABLE IF EXISTS `menuperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menuperfil` (
  `idPerfil` int(11) NOT NULL,
  `idMenu` int(11) NOT NULL,
  PRIMARY KEY (`idPerfil`,`idMenu`),
  KEY `fk_MenuPerfil_Menu_idx` (`idMenu`),
  KEY `fk_MenuPerfil_Perfil_idx` (`idPerfil`),
  CONSTRAINT `fk_MenuPerfil_Menu` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MenuPerfil_Perfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuperfil`
--

LOCK TABLES `menuperfil` WRITE;
/*!40000 ALTER TABLE `menuperfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `menuperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notaenvio`
--

DROP TABLE IF EXISTS `notaenvio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notaenvio` (
  `idNotaEnvio` int(11) NOT NULL,
  `fechaDespacho` date NOT NULL,
  `idPedido` int(11) NOT NULL,
  PRIMARY KEY (`idNotaEnvio`),
  KEY `fk_NotaEnvio_Pedido_idx` (`idPedido`),
  CONSTRAINT `fk_NotaEnvio_Pedido` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notaenvio`
--

LOCK TABLES `notaenvio` WRITE;
/*!40000 ALTER TABLE `notaenvio` DISABLE KEYS */;
INSERT INTO `notaenvio` VALUES (1,'2014-07-17',1),(51,'2014-07-25',1),(101,'2014-08-17',1);
/*!40000 ALTER TABLE `notaenvio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notaenviodetalle`
--

DROP TABLE IF EXISTS `notaenviodetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notaenviodetalle` (
  `idNotaEnvioDet` int(11) NOT NULL,
  `idBobinaFardo` varchar(100) NOT NULL,
  `idNotaEnvio` int(11) NOT NULL,
  PRIMARY KEY (`idNotaEnvioDet`),
  KEY `fk_NotaEnvio_Detalle_Nota_Envio1_idx` (`idNotaEnvio`),
  KEY `fk_NotaEnvioDet_BobinaFardo_idx` (`idBobinaFardo`),
  CONSTRAINT `fk_NotaEnvioDetalle_NotaEnvio` FOREIGN KEY (`idNotaEnvio`) REFERENCES `notaenvio` (`idNotaEnvio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_NotaEnvioDet_BobinaFardo` FOREIGN KEY (`idBobinaFardo`) REFERENCES `bobinafardo` (`idBobinaFardo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notaenviodetalle`
--

LOCK TABLES `notaenviodetalle` WRITE;
/*!40000 ALTER TABLE `notaenviodetalle` DISABLE KEYS */;
INSERT INTO `notaenviodetalle` VALUES (1,'P1-E1-SKU-1',1);
/*!40000 ALTER TABLE `notaenviodetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenproduccion`
--

DROP TABLE IF EXISTS `ordenproduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenproduccion` (
  `idOrden` int(11) NOT NULL,
  `proceso` varchar(2) NOT NULL,
  `correlativo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idTurno` varchar(6) NOT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `ancho` float NOT NULL,
  `largo` float DEFAULT NULL,
  `calibre` float NOT NULL,
  `estadoOrden` varchar(2) NOT NULL,
  `rodillo` int(11) DEFAULT NULL,
  `repeticiones` int(11) DEFAULT NULL,
  `rollos` int(11) DEFAULT NULL,
  `empaque` int(11) DEFAULT NULL,
  `registros` varchar(45) DEFAULT NULL,
  `idPedido` int(11) NOT NULL,
  `idMaquina` int(11) NOT NULL,
  PRIMARY KEY (`idOrden`),
  KEY `fk_OrdenProduccion_Pedido_idx` (`idPedido`),
  KEY `fk_OrdenProduccion_Maquina_idx` (`idMaquina`),
  KEY `fk_OrdenProduccion_Tipo_idx` (`idTurno`),
  CONSTRAINT `fk_OrdenProduccion_Maquina` FOREIGN KEY (`idMaquina`) REFERENCES `maquina` (`idMaquina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdenProduccion_Pedido` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdenProduccion_Tipo` FOREIGN KEY (`idTurno`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenproduccion`
--

LOCK TABLES `ordenproduccion` WRITE;
/*!40000 ALTER TABLE `ordenproduccion` DISABLE KEYS */;
INSERT INTO `ordenproduccion` VALUES (1,'Ex',1,'2014-05-26','TUR001','',10,12,5.2,'Pr',0,0,0,0,'CONTINUO',1,1),(2,'Re',1,'2014-08-20','TUR001','ccccccccccc',10,12,5.2,'Pr',0,0,2,0,'-',1,5),(52,'Re',2,'2014-08-20','TUR001','edededededed',10,12,5.2,'Pr',0,0,5,0,'-',1,5),(102,'Re',3,'2014-08-20','TUR002','gggggggg',10,12,5.2,'Pr',0,0,0,0,'-',1,6),(152,'Re',4,'2014-08-20','TUR002','kfkfkfkfkfkfkfkfkfkf',10,12,5.2,'Pr',0,0,15,0,'-',1,6),(202,'Re',5,'2014-08-21','TUR001','-',10,12,5.2,'Pr',0,0,30,0,'-',1,5),(252,'Re',6,'2014-08-21','TUR001','fff gfggff ggfgfg gfgfgfgfgf',10,12,5.2,'Pr',0,0,50,0,'-',1,5),(302,'Re',7,'2014-08-21','TUR002','ESTA ORDEN ES URGENTE',10,12,5.2,'Pr',0,0,75,0,'-',1,6),(352,'Ex',2,'2014-08-21','TUR001','ORDEN DE EXTRUSION',10,12,5.2,'Pr',0,0,0,0,'-',1,2),(402,'Db',1,'2014-08-21','TUR001','ESTA ES DE DOBLADO',10,12,6.1,'Pr',0,0,0,0,'-',1,7),(452,'Fl',1,'2014-08-21','TUR002','-',10,12,4,'Pr',1,5,0,0,'CONTINUO',1,4),(502,'Cs',1,'2014-08-21','TUR001','-',10,12,5.2,'Pr',0,0,0,100,'ojo electronico',1,10),(552,'Ex',3,'2014-08-26','TUR001','prueba 1',10,12,5.2,'Pr',0,0,0,0,'-',1,1),(602,'Ex',4,'2014-08-27','TUR002','-',12,8.5,10,'Pr',0,0,0,0,'-',2,2),(652,'Re',8,'2014-08-27','TUR002','-',12,8.5,10,'Pr',0,0,5,0,'-',2,6);
/*!40000 ALTER TABLE `ordenproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `fechaEntrega` date NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idVendedor` int(11) NOT NULL,
  `direcEntrega` varchar(250) NOT NULL,
  `observacion` varchar(250) DEFAULT NULL,
  `aprobado` int(11) DEFAULT NULL,
  `estado` varchar(2) NOT NULL COMMENT 'pendiente, proceso, terminado',
  `idProducto` int(11) NOT NULL COMMENT 'codigo del producto solicitado : bolsa o bobina',
  `cantidad` float NOT NULL COMMENT 'cantidad solicitada del producto',
  `ancho` float NOT NULL,
  `largo` float DEFAULT NULL,
  `calibre` float NOT NULL,
  `librasTotales` float DEFAULT NULL,
  `refilado` int(11) DEFAULT NULL,
  `doblado` int(11) DEFAULT NULL,
  `impresa` int(11) DEFAULT NULL,
  `idAdicional` varchar(6) DEFAULT NULL COMMENT 'lista en tabla TIPOS',
  `tamanoAdicional` float DEFAULT NULL,
  `idTroquelado` varchar(6) DEFAULT NULL,
  `resistencia` varchar(6) DEFAULT NULL COMMENT 'calor, frio',
  `idFuelle1` varchar(6) DEFAULT NULL COMMENT 'lista en tabla TIPOS',
  `tamanoFuelle1` float DEFAULT NULL,
  `idFuelle2` varchar(6) DEFAULT NULL COMMENT 'lista en tabla TIPOS',
  `tamanoFuelle2` float DEFAULT NULL,
  `idSello` varchar(6) DEFAULT NULL,
  `pigmento` varchar(45) DEFAULT 'TRANSPARENTE' COMMENT 'color de fondo',
  `precioUnitario` float DEFAULT NULL,
  `tipoTinta` varchar(45) DEFAULT NULL COMMENT 'mate, brillante',
  `impresionFrente` int(11) DEFAULT NULL,
  `impresionDorso` int(11) DEFAULT NULL,
  `impresionUnaCara` int(11) DEFAULT NULL,
  `impresionDosCara` int(11) DEFAULT NULL,
  `impresionContinua` int(11) DEFAULT NULL,
  `textoImpreso` varchar(250) DEFAULT NULL,
  `etapa` varchar(2) NOT NULL,
  `idUniadMedida` int(11) NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `fk_Pedido_Persona_idx` (`idCliente`),
  KEY `fk_Pedido_Empleado_idx` (`idVendedor`),
  KEY `fk_Pedido_Producto_idx` (`idProducto`),
  KEY `fk_Pedido_TipoA_idx` (`idAdicional`),
  KEY `fk_Pedido_TipoF1_idx` (`idFuelle1`),
  KEY `fk_Pedido_TipoF2_idx` (`idFuelle2`),
  KEY `fk_Pedido_UnidadM_idx` (`idUniadMedida`),
  KEY `fk_Pedido_TipoTro_idx` (`idTroquelado`),
  KEY `fk_Pedido_TipoSello_idx` (`idSello`),
  CONSTRAINT `fk_Pedido_Empleado` FOREIGN KEY (`idVendedor`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Persona` FOREIGN KEY (`idCliente`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_TipoA` FOREIGN KEY (`idAdicional`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_TipoF1` FOREIGN KEY (`idFuelle1`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_TipoF2` FOREIGN KEY (`idFuelle2`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_TipoSello` FOREIGN KEY (`idSello`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_TipoTro` FOREIGN KEY (`idTroquelado`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_UnidadM` FOREIGN KEY (`idUniadMedida`) REFERENCES `unidadmedida` (`idUnidadMedida`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2014-05-24','2014-06-24',1,11,'san salvador','',0,'Pe',1,10,10,12,5.2,418.253,1,1,1,'A00001',0.13,'T00001','calor','F00001',0.11,'F00002',1.2,'S00001','blanco',1.75,'brillante',0,1,0,0,1,'pizza hut','Re',2),(2,'2014-08-26','2014-08-26',2,12,'SAN SALVADOR 5','-',0,'Pr',2,1500,12,8.5,10,1500,1,1,1,'A00001',0.23,'T00001','CALOR','F00001',0.11,'F00001',0,'S00001','TRANSPARENTE',1.2,'-',0,1,0,0,1,'BUENOS DIAS','Re',1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `idPerfil` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `registroFiscal` varchar(45) DEFAULT NULL,
  `idTipoPago` varchar(6) DEFAULT NULL COMMENT 'lista en tabla TIPOS',
  `nrc` varchar(45) DEFAULT NULL,
  `idTipoPersona` varchar(6) DEFAULT NULL,
  `proveedor` int(11) DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `fk_Persona_Tipo_idx` (`idTipoPago`),
  KEY `fk_Persona_Tipo_idx1` (`idTipoPersona`),
  CONSTRAINT `fk_Persona_Tipo` FOREIGN KEY (`idTipoPago`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Persona_TipoPer` FOREIGN KEY (`idTipoPersona`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'PIZZA HUT','SAN SALVADOR','22222222','125-63','P00002','6565','PER002',0,1),(2,'china wok','san salv','22152215','123','P00003','2122','PER002',1,1),(3,'A&A REPUESTOS','ss','22556633','526-3','P00002','14','PER002',1,0);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'BOLSA'),(2,'BOBINA');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puesto` (
  `idPuesto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idDepto` varchar(6) NOT NULL,
  PRIMARY KEY (`idPuesto`),
  KEY `fk_Puesto_Tipo_idx` (`idDepto`),
  CONSTRAINT `fk_Puesto_Tipo` FOREIGN KEY (`idDepto`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (1,'OPERARIO EX','D00001'),(2,'OPERARIO FL','D00001'),(3,'OPERARIO RE','D00002'),(4,'OPERARIO DB','D00004'),(5,'OPERARIO CS','D00005'),(6,'SUPERVISOR EX','D00001'),(7,'SUPERVISOR FL','D00003'),(8,'SUPERVISOR RE','D00002'),(9,'SUPERVISOR DB','D00004'),(10,'SUPERVISOR CS','D00005'),(11,'VENDEDOR','D00006');
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisicion`
--

DROP TABLE IF EXISTS `requisicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requisicion` (
  `idRequisicion` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `idOrden` int(11) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `fechaDespacho` date DEFAULT NULL,
  PRIMARY KEY (`idRequisicion`),
  KEY `fk_Requisicion_OrdenProduccion_idx` (`idOrden`),
  CONSTRAINT `fk_Requisicion_OrdenProduccion` FOREIGN KEY (`idOrden`) REFERENCES `ordenproduccion` (`idOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisicion`
--

LOCK TABLES `requisicion` WRITE;
/*!40000 ALTER TABLE `requisicion` DISABLE KEYS */;
INSERT INTO `requisicion` VALUES (1,'2014-07-17',1,'Pe','2014-07-17'),(2,'2014-07-19',1,'Pe','2014-08-08'),(3,'2014-08-06',1,'Pe','2014-08-07'),(4,'2014-07-31',1,'Pe','2014-08-07'),(5,'2014-08-01',1,'Pe','2014-08-07'),(6,'2014-08-06',1,'Pe','2014-08-07'),(56,'2014-08-07',1,'Pe','2014-08-08'),(106,'2014-08-07',1,'Pe','2014-08-08'),(156,'2014-08-07',1,'Pe','2014-08-08');
/*!40000 ALTER TABLE `requisicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisiciondetalle`
--

DROP TABLE IF EXISTS `requisiciondetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requisiciondetalle` (
  `idRequisicionDetalle` int(11) NOT NULL,
  `idMateriaPrima` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  `idRequisicion` int(11) NOT NULL,
  PRIMARY KEY (`idRequisicionDetalle`),
  KEY `fk_Requisicion_detalle_Requisicion1_idx` (`idRequisicion`),
  KEY `fk_RequisicionDetalle_MateriaPrima_idx` (`idMateriaPrima`),
  CONSTRAINT `fk_RequisicionDetalle_MateriaPrima` FOREIGN KEY (`idMateriaPrima`) REFERENCES `materiaprima` (`idMateriaPrima`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RequisicionDetalle_Requisicion` FOREIGN KEY (`idRequisicion`) REFERENCES `requisicion` (`idRequisicion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisiciondetalle`
--

LOCK TABLES `requisiciondetalle` WRITE;
/*!40000 ALTER TABLE `requisiciondetalle` DISABLE KEYS */;
INSERT INTO `requisiciondetalle` VALUES (1,4,30.5,1),(2,9,5.8,2),(3,1,5.5,3),(4,2,2.1,3),(5,1,5,4),(6,1,2,5),(7,2,2,6),(8,6,20,6),(57,2,1,56),(107,12,2,106),(157,1,1,156),(158,2,1,156);
/*!40000 ALTER TABLE `requisiciondetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secuencia`
--

DROP TABLE IF EXISTS `secuencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secuencia` (
  `secuenciaNombre` varchar(100) NOT NULL,
  `secuenciaValor` int(11) NOT NULL,
  PRIMARY KEY (`secuenciaNombre`,`secuenciaValor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secuencia`
--

LOCK TABLES `secuencia` WRITE;
/*!40000 ALTER TABLE `secuencia` DISABLE KEYS */;
INSERT INTO `secuencia` VALUES ('secBodega',353),('secCompra',603),('secCompraDetalle',122),('secEmpleado',113),('secMaquina',60),('secMateriaPrima',62),('secMenu',0),('secNotaEnvio',150),('secNotaEnvioDetalle',50),('secOPCs',0),('secOPDb',0),('secOPEx',0),('secOPFl',0),('secOPRe',0),('secOrdenProduccion',701),('secPedido',51),('secPerfil',0),('secPersona',2),('secProducto',52),('secPuesto',61),('secRequisicion',205),('secRequisicionDetalle',206),('secUnidadMedida',102);
/*!40000 ALTER TABLE `secuencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `idTipo` varchar(6) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES ('A00001','PESTAÑA'),('A00002','SOLAPA POR DENTRO'),('A00003','SOLAPA POR FUERA'),('D00001','EX'),('D00002','RE'),('D00003','FL'),('D00004','DB'),('D00005','CS'),('D00006','VENTAS'),('E00001','ACTIVO'),('E00002','INACTIVO'),('F00001','LATERAL'),('F00002','FONDO'),('F00003','SUPERIOR'),('F00004','INFERIOR'),('M00001','EXTRUSORA'),('M00002','FLEXOGRAFA'),('M00003','REFILADORA'),('M00004','DOBLADORA'),('M00005','CORTADORA'),('P00001','PAGO 30 DIAS'),('P00002','PAGO 60 DIAS'),('P00003','PAGO 90 DIAS'),('P00004','PAGO CONTADO'),('PER001','NATURAL'),('PER002','JURIDICA'),('S00001','FONDO'),('S00002','LATERAL'),('T00001','SONRISA'),('T00002','SONRISA INVERTIDA'),('T00003','CUADRADO'),('T00004','REDONDO'),('TUR001','DIURNO'),('TUR002','NOCTURNO');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadmedida`
--

DROP TABLE IF EXISTS `unidadmedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidadmedida` (
  `idUnidadMedida` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `abreviatura` varchar(6) NOT NULL,
  PRIMARY KEY (`idUnidadMedida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadmedida`
--

LOCK TABLES `unidadmedida` WRITE;
/*!40000 ALTER TABLE `unidadmedida` DISABLE KEYS */;
INSERT INTO `unidadmedida` VALUES (1,'LIBRAS','LBS.'),(2,'MILLARES','MIL.');
/*!40000 ALTER TABLE `unidadmedida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` varchar(12) NOT NULL,
  `nombre` varchar(120) NOT NULL,
  `password` varchar(100) NOT NULL,
  `idEstado` varchar(6) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_Tipo_idx` (`idEstado`),
  CONSTRAINT `fk_Usuario_Tipo` FOREIGN KEY (`idEstado`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('ACRUZ','AIDA CRUZ','123','E00002'),('ADMIN','ADMINISTRADOR','123','E00001'),('CCASTRO','USUARIO 1','123','E00001');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioperfil`
--

DROP TABLE IF EXISTS `usuarioperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioperfil` (
  `idUsuario` varchar(12) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  KEY `fk_UsuarioPerfil_Usuario_idx` (`idUsuario`),
  KEY `fk_UsuarioPerfil_Perfil_idx` (`idPerfil`),
  CONSTRAINT `fk_UsuarioPerfil_Perfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioPerfil_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioperfil`
--

LOCK TABLES `usuarioperfil` WRITE;
/*!40000 ALTER TABLE `usuarioperfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarioperfil` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-28  0:36:39
