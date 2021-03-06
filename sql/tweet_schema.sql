-- MySQL Script generated by MySQL Workbench
-- Wed Mar 10 18:19:00 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tweet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tweet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tweet` DEFAULT CHARACTER SET utf8 ;
USE `tweet` ;

-- -----------------------------------------------------
-- Table `tweet`.`tw_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tweet`.`tw_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(1) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `login_ind` VARCHAR(1) NOT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tweet`.`tw_post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tweet`.`tw_post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tweet` VARCHAR(255) NULL,
  `tw_user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tw_post_tw_user_idx` (`tw_user_id` ASC) VISIBLE,
  CONSTRAINT `tw_post_tw_user`
    FOREIGN KEY (`tw_user_id`)
    REFERENCES `tweet`.`tw_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
