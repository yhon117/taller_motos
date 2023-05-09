-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
select*from venta;
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
  `tipoperfiles` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idtipo`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


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
    REFERENCES `taller`.`tipo` (`idtipo`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
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
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `taller`.`repuesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`repuesto` (
  `idrepuesto` INT NOT NULL AUTO_INCREMENT,
  `nombreRepuesto` VARCHAR(45) NULL DEFAULT NULL,
  `costo` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`idrepuesto`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
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
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `taller`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`venta` (
  `idventa` INT NOT NULL AUTO_INCREMENT,
  `repuesto_idrepuesto` INT NOT NULL,
  `servicios_id_srevicio` INT NOT NULL,
  `moto_idmoto` INT NOT NULL,
  PRIMARY KEY (`idventa`),
  INDEX `fk_venta_repuesto1_idx` (`repuesto_idrepuesto` ASC) VISIBLE,
  INDEX `fk_venta_servicios1_idx` (`servicios_id_srevicio` ASC) VISIBLE,
  INDEX `fk_venta_moto1_idx` (`moto_idmoto` ASC) VISIBLE,
  CONSTRAINT `fk_venta_repuesto1`
    FOREIGN KEY (`repuesto_idrepuesto`)
    REFERENCES `taller`.`repuesto` (`idrepuesto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_servicios1`
    FOREIGN KEY (`servicios_id_srevicio`)
    REFERENCES `taller`.`servicios` (`id_srevicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_moto1`
    FOREIGN KEY (`moto_idmoto`)
    REFERENCES `taller`.`moto` (`idmoto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taller`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`factura` (
  `idfactura` INT NOT NULL AUTO_INCREMENT,
  `monto` VARCHAR(45) NOT NULL,
  `cliente` VARCHAR(45) NOT NULL,
  `fechaventa` DATETIME NULL,
  `venta_idventa` INT NOT NULL,
  PRIMARY KEY (`idfactura`),
  INDEX `fk_factura_venta1_idx` (`venta_idventa` ASC) VISIBLE,
  CONSTRAINT `fk_factura_venta1`
    FOREIGN KEY (`venta_idventa`)
    REFERENCES `taller`.`venta` (`idventa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into tipo(idtipo, tipoperfiles) values('1','cliente');
insert into tipo(idtipo, tipoperfiles) values('2','administrador');

insert into repuesto(idrepuesto, nombreRepuesto, costo) values('1','aceite','20000');
insert into repuesto(idrepuesto, nombreRepuesto, costo) values('99','general','0');
insert into servicios(id_srevicio, nombre, descripcion, precio) values('1','cambio de aceite','cambio de aceite','50000');

insert into servicios(id_srevicio, nombre, descripcion, precio) values('99','general','general','0');


