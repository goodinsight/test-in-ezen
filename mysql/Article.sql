-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Article` (
  `aid` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NOT NULL,
  `createdBy` VARCHAR(45) NOT NULL,
  `modifiedAt` DATETIME NOT NULL,
  `modifiedBy` VARCHAR(45) NOT NULL,
  `Articlecol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`aid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ArticleComment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ArticleComment` (
  `acid` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NOT NULL,
  `createdBy` VARCHAR(45) NOT NULL,
  `modifiedAt` DATETIME NOT NULL,
  `modifiedBy` VARCHAR(45) NOT NULL,
  `ArticleCommentcol` VARCHAR(45) NOT NULL,
  `Article_aid` INT NOT NULL,
  PRIMARY KEY (`acid`, `Article_aid`),
  INDEX `fk_ArticleComment_Article_idx` (`Article_aid` ASC) VISIBLE,
  CONSTRAINT `fk_ArticleComment_Article`
    FOREIGN KEY (`Article_aid`)
    REFERENCES `mydb`.`Article` (`aid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
