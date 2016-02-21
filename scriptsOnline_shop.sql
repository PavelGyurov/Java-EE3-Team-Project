-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`characteristict`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`characteristict` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `amount` INT NOT NULL,
  `amountInstock` INT NULL,
  `price` DOUBLE NULL,
  `warranty_months` INT NULL,
  `categoryID` INT NOT NULL,
  `caracteristicsID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `characteristics_id_idx` (`caracteristicsID` ASC),
  INDEX `category_id_idx` (`categoryID` ASC),
  CONSTRAINT `categoryID`
    FOREIGN KEY (`categoryID`)
    REFERENCES `mydb`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `characteristicsID`
    FOREIGN KEY (`caracteristicsID`)
    REFERENCES `mydb`.`characteristict` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`shopping_cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`shopping_cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `total_price` DOUBLE NULL,
  `customerID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_id_idx` (`customerID` ASC),
  CONSTRAINT `customer`
    FOREIGN KEY (`customerID`)
    REFERENCES `mydb`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`address` (
  `id` INT NOT NULL,
  `country` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `province` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `street_number` INT NULL,
  `building` INT NULL,
  `entrance` VARCHAR(45) NULL,
  `floor` INT NULL,
  `apartment` INT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer` (
  `id` INT NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `online_status` INT NOT NULL,
  `credit_card` VARCHAR(45) NULL,
  `addressID` INT NOT NULL,
  `shopping_cartID` INT NULL,
  INDEX `shopping_cart_id_idx` (`shopping_cartID` ASC),
  INDEX `address_id_idx` (`addressID` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `credit_card_UNIQUE` (`credit_card` ASC),
  UNIQUE INDEX `shopping_cart_id_UNIQUE` (`shopping_cartID` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `shopping_cartID`
    FOREIGN KEY (`shopping_cartID`)
    REFERENCES `mydb`.`shopping_cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `addressID`
    FOREIGN KEY (`addressID`)
    REFERENCES `mydb`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customerID` INT NOT NULL,
  `date_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `customer_id_UNIQUE` (`customerID` ASC),
  CONSTRAINT `customer`
    FOREIGN KEY (`customerID`)
    REFERENCES `mydb`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order_products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orderID` INT NOT NULL,
  `productID` INT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `orderID_idx` (`orderID` ASC),
  INDEX `product_id_idx` (`productID` ASC),
  CONSTRAINT `orderID`
    FOREIGN KEY (`orderID`)
    REFERENCES `mydb`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `productID`
    FOREIGN KEY (`productID`)
    REFERENCES `mydb`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`shopping_cart_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`shopping_cart_products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `shopping_cartID` INT NULL,
  `productID` INT NULL,
  `amount` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `shopping_cart_id_idx` (`shopping_cartID` ASC),
  INDEX `product_id_idx` (`productID` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `shopping_cartID`
    FOREIGN KEY (`shopping_cartID`)
    REFERENCES `mydb`.`shopping_cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `productID`
    FOREIGN KEY (`productID`)
    REFERENCES `mydb`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`payment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payment_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`payment_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payment_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `payment_typeID` INT NOT NULL,
  `payment_statusID` INT NOT NULL,
  `orderID` INT NOT NULL,
  `date_time_fullfilled` DATETIME NULL,
  `date_time_confirmed` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `order_id_idx` (`orderID` ASC),
  INDEX `payments_type_id_idx` (`payment_typeID` ASC),
  INDEX `payment_status_id_idx` (`payment_statusID` ASC),
  CONSTRAINT `orderID`
    FOREIGN KEY (`orderID`)
    REFERENCES `mydb`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `payments_typeID`
    FOREIGN KEY (`payment_typeID`)
    REFERENCES `mydb`.`payment_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `payment_statusID`
    FOREIGN KEY (`payment_statusID`)
    REFERENCES `mydb`.`payment_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`category_relationship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category_relationship` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category1ID` INT NULL,
  `category2ID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `category1_id_idx` (`category1ID` ASC),
  INDEX `category1_id_idx1` (`category2ID` ASC),
  CONSTRAINT `category1_id`
    FOREIGN KEY (`category1ID`)
    REFERENCES `mydb`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `category2_id`
    FOREIGN KEY (`category2ID`)
    REFERENCES `mydb`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`characterictics_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`characterictics_category` (
  `id` INT NOT NULL,
  `categoryID` INT NOT NULL,
  `characteristicsID` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `category_id_idx` (`categoryID` ASC),
  INDEX `characteristics_id_idx` (`characteristicsID` ASC),
  CONSTRAINT `categoryID`
    FOREIGN KEY (`categoryID`)
    REFERENCES `mydb`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `characteristicsID`
    FOREIGN KEY (`characteristicsID`)
    REFERENCES `mydb`.`characteristict` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
