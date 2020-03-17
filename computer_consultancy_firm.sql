-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2019 at 10:31 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `computer_consultancy_firm`
--

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `con_ID` varchar(6) NOT NULL,
  `con_name` varchar(20) DEFAULT NULL,
  `con_description` varchar(30) DEFAULT NULL,
  `con_date` date DEFAULT NULL,
  `con_jobType` varchar(20) DEFAULT NULL,
  `con_projLeaderID` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`con_ID`, `con_name`, `con_description`, `con_date`, `con_jobType`, `con_projLeaderID`) VALUES
('con001', 'Project Andro', 'AI android app', '2019-03-12', 'Software ', 'emp001'),


-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_ID` varchar(6) NOT NULL,
  `cus_fname` varchar(20) DEFAULT NULL,
  `cus_lname` varchar(20) DEFAULT NULL,
  `cus_phone` varchar(20) DEFAULT NULL,
  `cus_address` varchar(100) DEFAULT NULL,
  `cus_contractID` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_ID`, `cus_fname`, `cus_lname`, `cus_phone`, `cus_address`, `cus_contractID`) VALUES
('cus001', 'Imzar', 'Ahmed', '0293849321', 'Nittambuwa', NULL),
('cus002', 'Pasindu', 'Fernando', '213219741', 'Colombo', NULL),
('cus003', 'Inshaf', 'Ifthikar', '119', 'Negombo	', 'con001'),


-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_ID` varchar(6) NOT NULL,
  `emp_fname` varchar(30) DEFAULT NULL,
  `emp_lname` varchar(30) DEFAULT NULL,
  `emp_DOB` date DEFAULT NULL,
  `emp_phone` varchar(15) DEFAULT NULL,
  `emp_address` varchar(50) DEFAULT NULL,
  `emp_roleID_01` varchar(6) DEFAULT NULL,
  `emp_roleID_02` varchar(30) DEFAULT NULL,
  `emp_roleID_03` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_ID`, `emp_fname`, `emp_lname`, `emp_DOB`, `emp_phone`, `emp_address`, `emp_roleID_01`, `emp_roleID_02`, `emp_roleID_03`) VALUES
('emp001', 'Rusiru', 'Fernando', '2019-03-12', '0763358718', 'Negombo', 'rol001', '', ''),
('emp002', 'Hasani', 'Dilhari', '2019-05-25', '1234567890', 'nittambuwa', 'rol002', 'rol003', 'rol004'),


-- --------------------------------------------------------

--
-- Table structure for table `logincredetials`
--

CREATE TABLE `logincredetials` (
  `username` varchar(10) NOT NULL,
  `pwd` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logincredetials`
--

INSERT INTO `logincredetials` (`username`, `pwd`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_ID` varchar(6) NOT NULL,
  `role_description` varchar(20) DEFAULT NULL,
  `role_hourlyPay` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_ID`, `role_description`, `role_hourlyPay`) VALUES
('rol001', 'Hardware Technician', 5999.0),
('rol002', 'Programmer', 4499.99),
('rol003', 'Software Installer', 2499.99),
('rol004', 'Designer', 7499.99),
('rol005', 'Q/A Engineer', 1499.99);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`con_ID`),
  ADD KEY `fk_con` (`con_projLeaderID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_ID`),
  ADD KEY `fk_cus` (`cus_contractID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_ID`),
  ADD KEY `fk_emp_ID` (`emp_roleID_01`);

--
-- Indexes for table `logincredetials`
--
ALTER TABLE `logincredetials`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `fk_con` FOREIGN KEY (`con_projLeaderID`) REFERENCES `employee` (`emp_ID`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `fk_cus` FOREIGN KEY (`cus_contractID`) REFERENCES `contract` (`con_ID`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_emp` FOREIGN KEY (`emp_roleID_01`) REFERENCES `role` (`role_ID`),
  ADD CONSTRAINT `fk_emp_ID` FOREIGN KEY (`emp_roleID_01`) REFERENCES `role` (`role_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
