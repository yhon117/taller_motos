-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema taller
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema taller
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `taller` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `taller` ;

-- -----------------------------------------------------
-- Table `taller`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`tipo` (
  `idtipo` INT NOT NULL AUTO_INCREMENT,
  `tipoperfiles` VARCHAR(45) NULL,
  PRIMARY KEY (`idtipo`))
ENGINE = InnoDB;

INSERT INTO `tipo` VALUES (1,'cliente'),(2,'Administrador');




-- -----------------------------------------------------
-- Table `taller`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(18) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(50) NULL DEFAULT NULL,
  `contrasena` VARCHAR(100) NULL DEFAULT NULL,
  `tipo_idtipo` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_cliente_tipo1_idx` (`tipo_idtipo` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_tipo1`
    FOREIGN KEY (`tipo_idtipo`)
    REFERENCES `taller`.`tipo` (`idtipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;





insert into cliente(id_cliente, cedula, nombre, apellido, telefono, correo, usuario, contrasena, tipo_idtipo) 
values('9','45363','pepe','gonzales','23829','elpepe@gmail.com','admin','admin123','2');


-- -----------------------------------------------------
-- Table `taller`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`pago` (
  `idpago` INT NOT NULL AUTO_INCREMENT,
  `fechaPago` VARCHAR(45) NOT NULL,
  `montoPago` DOUBLE NULL DEFAULT NULL,
  `tipo_pago_id_tipo_pago` INT NOT NULL,
  PRIMARY KEY (`idpago`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `taller`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`factura` (
  `idfactura` INT NOT NULL AUTO_INCREMENT,
  `total` DECIMAL(10,0) NOT NULL,
  `pago_idpago` INT NOT NULL,
  PRIMARY KEY (`idfactura`),
  INDEX `fk_factura_pago1_idx` (`pago_idpago` ASC) VISIBLE,
  CONSTRAINT `fk_factura_pago1`
    FOREIGN KEY (`pago_idpago`)
    REFERENCES `taller`.`pago` (`idpago`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `taller`.`servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`servicios` (
  `id_srevicio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `precio` DECIMAL(10,0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_srevicio`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `taller`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`proveedor` (
  `idproveedor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idproveedor`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `taller`.`repuesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`repuesto` (
  `idrepuesto` INT NOT NULL AUTO_INCREMENT,
  `nombreRepuesto` VARCHAR(45) NULL DEFAULT NULL,
  `costo` DECIMAL(10,0) NOT NULL,
  `proveedor_idproveedor` INT NOT NULL,
  PRIMARY KEY (`idrepuesto`),
  INDEX `fk_repuesto_proveedor1_idx` (`proveedor_idproveedor` ASC) VISIBLE,
  CONSTRAINT `fk_repuesto_proveedor1`
    FOREIGN KEY (`proveedor_idproveedor`)
    REFERENCES `taller`.`proveedor` (`idproveedor`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `taller`.`moto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`moto` (
  `idmoto` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(6) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `kilometraje` VARCHAR(45) NOT NULL,
  `numeroChasis` VARCHAR(45) NOT NULL,
  `cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`idmoto`),
  INDEX `fk_moto_cliente1_idx` (`cliente_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_moto_cliente1`
    FOREIGN KEY (`cliente_id_cliente`)
    REFERENCES `taller`.`cliente` (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `taller`.`detalle_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`detalle_factura` (
  `id-detalle_factura` INT NOT NULL AUTO_INCREMENT,
  `repuesto_idrepuesto` INT NOT NULL,
  `servicios_id_srevicio` INT NOT NULL,
  `factura_idfactura` INT NOT NULL,
  `moto_idmoto` INT NOT NULL,
  PRIMARY KEY (`id-detalle_factura`),
  INDEX `fk_detalle_servicios_repuesto1_idx` (`repuesto_idrepuesto` ASC) VISIBLE,
  INDEX `fk_detalle_factura_servicios1_idx` (`servicios_id_srevicio` ASC) VISIBLE,
  INDEX `fk_detalle_factura_factura1_idx` (`factura_idfactura` ASC) VISIBLE,
  INDEX `fk_detalle_factura_moto1_idx` (`moto_idmoto` ASC) VISIBLE,
  CONSTRAINT `fk_detalle_factura_factura1`
    FOREIGN KEY (`factura_idfactura`)
    REFERENCES `taller`.`factura` (`idfactura`),
  CONSTRAINT `fk_detalle_factura_servicios1`
    FOREIGN KEY (`servicios_id_srevicio`)
    REFERENCES `taller`.`servicios` (`id_srevicio`),
  CONSTRAINT `fk_detalle_servicios_repuesto1`
    FOREIGN KEY (`repuesto_idrepuesto`)
    REFERENCES `taller`.`repuesto` (`idrepuesto`),
  CONSTRAINT `fk_detalle_factura_moto1`
    FOREIGN KEY (`moto_idmoto`)
    REFERENCES `taller`.`moto` (`idmoto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

