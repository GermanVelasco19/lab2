FLUSH PRIVILEGES;
--
DROP SCHEMA IF EXISTS `mydb`;
--
CREATE SCHEMA IF NOT EXISTS `mydb`;
--
USE `mydb`;
--
CREATE TABLE IF NOT EXISTS `mydb`.`persona` (
 `cc` INT(15) NOT NULL,
 `nombre` VARCHAR(45) NOT NULL,
 `apellido` VARCHAR(45) NOT NULL,
 `genero` ENUM('M', 'F') NOT NULL,
 `edad` INT(3) NULL DEFAULT NULL, 
 CONSTRAINT `persona_pk` PRIMARY KEY (`cc`)
);
--
CREATE TABLE IF NOT EXISTS `mydb`.`profesion` (
 `id` INT(6) NOT NULL,
 `nom` VARCHAR(90) NOT NULL,
 `des` TEXT NULL DEFAULT NULL, 
 CONSTRAINT `profesion_pk` PRIMARY KEY (`id`)
);
--
CREATE TABLE IF NOT EXISTS `mydb`.`telefono` (
 `num` VARCHAR(15) NOT NULL,
 `oper` VARCHAR(45) NOT NULL,
 `duenio` INT(15) NOT NULL, 
 CONSTRAINT `telefono_pk` PRIMARY KEY (`num`), 
 CONSTRAINT `telefono_persona_fk` FOREIGN KEY (`duenio`) REFERENCES `mydb`.`persona` (`cc`)
);
--
CREATE TABLE IF NOT EXISTS `mydb`.`estudios` (
 `id_prof` INT(6) NOT NULL,
 `cc_per` INT(15) NOT NULL,
 `fecha` DATE NULL DEFAULT NULL,
 `univer` VARCHAR(50) NULL DEFAULT NULL, 
 CONSTRAINT `estudios_pk` PRIMARY KEY (`id_prof`, `cc_per`),
 CONSTRAINT `estudio_persona_fk` FOREIGN KEY (`cc_per`) REFERENCES `mydb`.`persona` (`cc`),
 CONSTRAINT `estudio_profesion_fk` FOREIGN KEY (`id_prof`) REFERENCES `mydb`.`profesion` (`id`)
);
--
COMMIT;
FLUSH PRIVILEGES;