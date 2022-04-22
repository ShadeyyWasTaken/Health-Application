-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 17, 2022 at 02:16 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthapp`
--

-- --------------------------------------------------------

DROP DATABASE IF EXISTS healthapp;
CREATE DATABASE IF NOT EXISTS healthapp DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE healthapp;


--
-- Table structure for table `UserInfo`
--
DROP TABLE IF EXISTS UserInfo;
CREATE TABLE IF NOT EXISTS UserInfo (
	USERNAME varchar(30) NOT NULL PRIMARY KEY,
	PASSWORD varchar(512) NOT NULL,
	SALT varchar(50) NOT NULL,
	EMAIL varchar(30)  NOT NULL,
	USERROLE varchar(20) DEFAULT NULL) 
ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `UserInfo`
--

INSERT INTO `UserInfo` (`USERNAME`, `PASSWORD`, `SALT`, `EMAIL`, `USERROLE`) VALUES
('Djordan', '789', 'test', 'daniel@gmail.com', 'user'),
('JDoe', '123', 'test', 'admin@admin.com', 'administrator'),
('StevieJ', '456', 'test', 'user@user.com', 'user');

-- Table structure for table `UserAttributes`

DROP TABLE IF EXISTS UserAttributes;
CREATE TABLE IF NOT EXISTS UserAttributes (
	WEIGHT FLOAT(5)  DEFAULT NULL,
	WEIGHT_GOAL FLOAT(5) DEFAULT NULL,
	AGE INT(3) DEFAULT NULL,
	GENDER varchar(6) DEFAULT NULL,
	HEIGHT INT(3)  DEFAULT NULL,
	HEART_RATE INT(3) DEFAULT NULL,
	RESTING_HEART_RATE INT(3) DEFAULT NULL,
	BLOOD_PRESSURE INT(3) DEFAULT NULL,
	BLOOD_OXYGEN FLOAT(5) DEFAULT NULL,
	RESPIRATORY_RATE INT(3) DEFAULT NULL,
	LUNG_CAPACITY INT(5) DEFAULT NULL,
	STEPS INT(7) DEFAULT NULL,
	WALKING_DISTANCE FLOAT(7) DEFAULT NULL,
	WALKING_TIME INT(4) DEFAULT NULL,
	SLEEP_TIME INT(4) DEFAULT NULL,
	SLEEP_GOAL INT(4) DEFAULT NULL,
	WATER_INTAKE INT(2) DEFAULT NULL,
	WATER_GOAL INT(2) DEFAULT NULL,
	TODAY_DATE varchar(20) NOT NULL,
	APPOINTMENT BIT(1) DEFAULT 0,
	MOOD varchar(20) DEFAULT NULL,
	STRESS_LEVEL varchar(10) DEFAULT NULL,
	USERNAME varchar(30)  NOT NULL,
	FOREIGN KEY(USERNAME) REFERENCES UserInfo(USERNAME))
ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `UserAttributes`
--

INSERT INTO `UserAttributes` (`TODAY_DATE`, `USERNAME`) VALUES
('19/04/2022', 'JDoe'),
('20/04/2022', 'JDoe'),
('19/04/2022', 'StevieJ'),
('20/04/2022', 'StevieJ');



DELIMITER $$

DROP PROCEDURE IF EXISTS `GetAccount`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAccount` (IN `inUsername` TEXT)  BEGIN
	SELECT *
	FROM   UserInfo
	WHERE  USERNAME = inUsername;
END$$

DROP PROCEDURE IF EXISTS `GetAccountAttributes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAccountAttributes` (IN `inUsername` TEXT)  BEGIN
	SELECT *
	FROM   UserAttributes
	WHERE  USERNAME = inUsername;
END$$

DROP PROCEDURE IF EXISTS `GetAccountAttributesByDate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAccountAttributesByDate` (IN `inUsername` TEXT, IN `inDate` TEXT)  BEGIN
	SELECT *
	FROM   UserAttributes
	WHERE  USERNAME = inUsername
	AND TODAY_DATE = inDate;
END$$

DROP PROCEDURE IF EXISTS `GetAccounts`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAccounts` ()  READS SQL DATA
BEGIN
	Select USERNAME, PASSWORD, SALT , EMAIL, USERROLE 
	From UserInfo 
	Order By USERNAME;    
END$$

DROP PROCEDURE IF EXISTS `AddAccount`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddAccount` (IN `inUsername` TEXT, IN `inPassword` TEXT, IN `inSalt` TEXT, IN `inEmail` TEXT)  BEGIN
		INSERT INTO UserInfo (USERNAME, PASSWORD, SALT, EMAIL, USERROLE)
        VALUES (inUsername, inPassword, inSalt, inEmail, "user");
END$$

DROP PROCEDURE IF EXISTS `AddActivity`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddActivity` (IN `inUsername` TEXT, IN `inDate` TEXT)  BEGIN
		INSERT INTO UserAttributes (USERNAME, TODAY_DATE)
        VALUES (inUsername, inDate);
END$$

DROP PROCEDURE IF EXISTS `MakeAdministrator`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `MakeAdministrator` (IN `inUsername` TEXT)  BEGIN
	UPDATE UserInfo 
	SET USERROLE = "administrator"
	WHERE USERNAME = inUsername;
END$$

DROP PROCEDURE IF EXISTS `ChangeAttribute`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ChangeAttribute` (IN `inUsername` TEXT, IN `inAttribute` TEXT, IN `inValue` TEXT, IN `inDate` TEXT)  BEGIN

	SET @s=CONCAT('UPDATE UserAttributes SET UserAttributes.',inAttribute,' ="',inValue,'" WHERE USERNAME ="',inUsername,'" AND TODAY_DATE="',inDate,'"');
	PREPARE stmt1 FROM @s;
	EXECUTE stmt1;
	DEALLOCATE PREPARE stmt1;
END$$

DROP PROCEDURE IF EXISTS `ChangeUserInfo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ChangeUserInfo` (IN `inUsername` TEXT, IN `inAttribute` TEXT, IN `inValue` TEXT)  BEGIN

	SET @s=CONCAT('UPDATE UserInfo SET UserInfo.',inAttribute,' ="',inValue,'" WHERE USERNAME ="',inUsername,'"');
	PREPARE stmt1 FROM @s;
	EXECUTE stmt1;
	DEALLOCATE PREPARE stmt1;	
END$$
