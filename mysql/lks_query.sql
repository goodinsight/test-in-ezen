-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema moviedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema moviedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviedb` DEFAULT CHARACTER SET utf8mb3 ;
USE `moviedb` ;

-- -----------------------------------------------------
-- Table `moviedb`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviedb`.`movie` (
  `m_name` VARCHAR(45) NOT NULL,
  `m_opening` VARCHAR(45) NULL DEFAULT NULL,
  `m_reopening` VARCHAR(45) NULL DEFAULT NULL,
  `m_genre` VARCHAR(45) NULL DEFAULT NULL,
  `m_nation` VARCHAR(45) NULL DEFAULT NULL,
  `m_age` VARCHAR(45) NULL DEFAULT NULL,
  `m_runtime` VARCHAR(45) NULL DEFAULT NULL,
  `m_grade` VARCHAR(45) NULL DEFAULT NULL,
  `m_director` VARCHAR(45) NULL DEFAULT NULL,
  `m_actor` VARCHAR(45) NULL DEFAULT NULL,
  `m_attendance` VARCHAR(45) NULL DEFAULT NULL,
  `m_awards` VARCHAR(45) NULL DEFAULT NULL,
  `m_number` INT NOT NULL AUTO_INCREMENT,
  UNIQUE INDEX `m_name_UNIQUE` (`m_name` ASC) VISIBLE,
  UNIQUE INDEX `m_number_UNIQUE` (`m_number` ASC) VISIBLE,
  PRIMARY KEY (`m_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 951
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `moviedb`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviedb`.`article` (
  `articleno` INT NOT NULL,
  `articlecontext` VARCHAR(45) NULL,
  `articledate` DATETIME NULL,
  PRIMARY KEY (`articleno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moviedb`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviedb`.`board` (
  `bno` INT NOT NULL AUTO_INCREMENT,
  `btitle` VARCHAR(45) NOT NULL,
  `bcontext` VARCHAR(45) NOT NULL,
  `bcreatedate` DATETIME NOT NULL,
  `boardcntlike` INT NULL,
  `article_articleno` INT NOT NULL,
  PRIMARY KEY (`bno`, `article_articleno`),
  INDEX `fk_board_article_idx` (`article_articleno` ASC) VISIBLE,
  CONSTRAINT `fk_board_article`
    FOREIGN KEY (`article_articleno`)
    REFERENCES `moviedb`.`article` (`articleno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moviedb`.`userfavorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviedb`.`userfavorite` (
  `ufno` INT NOT NULL AUTO_INCREMENT,
  `usergrade` VARCHAR(45) NOT NULL,
  `usereval` VARCHAR(45) NOT NULL,
  `movie_m_number` INT NOT NULL,
  PRIMARY KEY (`ufno`),
  INDEX `fk_userfavorite_movie1_idx` (`movie_m_number` ASC) VISIBLE,
  CONSTRAINT `fk_userfavorite_movie1`
    FOREIGN KEY (`movie_m_number`)
    REFERENCES `moviedb`.`movie` (`m_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moviedb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviedb`.`user` (
  `userno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(45) NOT NULL,
  `userpw` VARCHAR(45) NULL,
  `userage` INT NULL,
  `useraddr` VARCHAR(45) NULL,
  `usercreatedate` DATETIME NULL,
  `usergender` VARCHAR(45) NOT NULL,
  `useremail` VARCHAR(45) NULL,
  `userbirthday` VARCHAR(45) NULL,
  `board_bno` INT NOT NULL,
  `board_article_articleno` INT NOT NULL,
  `userfavorite_ufno` INT NOT NULL,
  PRIMARY KEY (`userno`, `board_bno`, `board_article_articleno`, `userfavorite_ufno`),
  INDEX `fk_user_board1_idx` (`board_bno` ASC, `board_article_articleno` ASC) VISIBLE,
  INDEX `fk_user_userfavorite1_idx` (`userfavorite_ufno` ASC) VISIBLE,
  CONSTRAINT `fk_user_board1`
    FOREIGN KEY (`board_bno` , `board_article_articleno`)
    REFERENCES `moviedb`.`board` (`bno` , `article_articleno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_userfavorite1`
    FOREIGN KEY (`userfavorite_ufno`)
    REFERENCES `moviedb`.`userfavorite` (`ufno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moviedb`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviedb`.`admin` (
  `adminno` INT NOT NULL AUTO_INCREMENT,
  `adminid` VARCHAR(45) NOT NULL,
  `adminpw` VARCHAR(45) NOT NULL,
  `adminname` VARCHAR(45) NOT NULL,
  `adminemail` VARCHAR(45) NULL,
  `admindept` VARCHAR(45) NULL,
  PRIMARY KEY (`adminno`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
