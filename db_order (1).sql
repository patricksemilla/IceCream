-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2020 at 12:41 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_order`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_scoop`
--

CREATE TABLE `tbl_scoop` (
  `scoop_id` int(10) NOT NULL,
  `first` varchar(60) NOT NULL,
  `second` varchar(60) NOT NULL,
  `third` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_scoop`
--

INSERT INTO `tbl_scoop` (`scoop_id`, `first`, `second`, `third`) VALUES
(1, 'chocolate', '', ''),
(2, 'chocolate', 'chocolate', ''),
(3, 'chocolate', 'chocolate', 'chocolate'),
(4, 'vanila', '', ''),
(5, 'vanila', 'vanila', ''),
(6, 'vanila', 'vanila', 'vanilla'),
(7, 'strawberry', '', ''),
(8, 'strawberry', 'strawberry', ''),
(9, 'strawberry', 'strawberry', 'strawberry'),
(10, 'chocolate', 'chocolate', 'vanila'),
(11, 'chocolate', 'chocolate', 'strawberry'),
(12, 'vanilla', 'vanilla', 'chocolate'),
(13, 'vanilla', 'vanilla', 'strawberry'),
(14, 'strawberry', 'strawberry', 'chocolate'),
(15, 'strawberry', 'strawberry', 'vanilla'),
(16, 'chocolate', 'vanilla', 'strawberry'),
(17, 'chocolate', 'vanilla', ''),
(18, 'chocolate', 'strawberry', ''),
(19, 'vanila', 'strawberry', ''),
(20, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_toppings`
--

CREATE TABLE `tbl_toppings` (
  `topping_ID` int(11) NOT NULL,
  `almonds` varchar(60) NOT NULL,
  `nuts` varchar(60) NOT NULL,
  `sprinkles` varchar(60) NOT NULL,
  `choco` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_toppings`
--

INSERT INTO `tbl_toppings` (`topping_ID`, `almonds`, `nuts`, `sprinkles`, `choco`) VALUES
(1, '', '', '', 'choco'),
(2, '', '', 'sprinkles', ''),
(3, '', '', 'sprinkles', 'choco'),
(4, '', 'nuts', '', ''),
(5, '', 'nuts', '', 'choco'),
(6, '', 'nuts', 'sprinkles', ''),
(7, '', 'nuts', 'sprinkles', 'choco'),
(8, 'almonds', '', '', ''),
(9, 'almonds', '', '', 'choco'),
(10, 'almonds', '', 'sprinkles', ''),
(11, 'almonds', '', 'sprinkles', 'choco'),
(12, 'almonds', 'nuts', '', ''),
(13, 'almonds', 'nuts', '', 'choco'),
(14, 'almonds', 'nuts', 'sprinkles', ''),
(15, 'almonds', 'nuts', 'sprinkles', 'choco');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaction`
--

CREATE TABLE `tbl_transaction` (
  `tran_id` int(60) NOT NULL,
  `type` varchar(225) NOT NULL,
  `scoop` int(60) NOT NULL,
  `toppings` int(225) NOT NULL,
  `ammt` int(60) NOT NULL,
  `cash` int(225) NOT NULL,
  `sukli` int(225) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_transaction`
--

INSERT INTO `tbl_transaction` (`tran_id`, `type`, `scoop`, `toppings`, `ammt`, `cash`, `sukli`, `date`) VALUES
(1, 'test', 1, 1, 0, 500, 300, '2020-03-13 00:07:13'),
(2, 'test ', 2, 8, 0, 331, 1233, '2020-03-13 00:04:00'),
(3, 'test', 7, 13, 0, 500, 500, '2020-03-13 01:00:00'),
(4, 'test ', 2, 3, 500, 2000, 2000, '2020-03-13 03:00:00'),
(5, 'asdtest', 1, 7, 222, 222, 222, '2020-03-13 03:00:00'),
(8, 'test', 1, 1, 233, 234, 52, '2020-03-13 07:00:00'),
(12, 'cup', 2, 2, 68, 1234, 1166, '2020-03-13 07:00:00'),
(13, 'sugar cone', 2, 2, 100, 100, 0, '2020-03-13 05:00:00'),
(14, 'cup', 1, 2, 53, 123, 70, '2020-03-13 04:00:00'),
(15, 'sugar cone', 1, 2, 85, 100, 15, '2020-03-13 07:00:00'),
(16, 'cup', 1, 2, 53, 123, 70, '2020-03-13 04:00:00'),
(17, 'cup', 1, 2, 33, 1234, 1201, '2020-03-13 04:00:00'),
(18, 'wafer cone', 1, 2, 35, 1234, 1199, '2020-03-13 05:12:07'),
(19, 'cup', 1, 2, 33, 321, 288, '2020-03-13 02:54:13'),
(20, 'cup', 1, 2, 33, 123, 90, '2020-03-13 03:03:06');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `ID` int(60) NOT NULL,
  `user` varchar(225) NOT NULL,
  `pass` varchar(225) NOT NULL,
  `name` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`ID`, `user`, `pass`, `name`) VALUES
(1, 'pat', '12345', 'patrick semilla'),
(2, 'rog', '12345', 'rogeline jutie');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_scoop`
--
ALTER TABLE `tbl_scoop`
  ADD PRIMARY KEY (`scoop_id`);

--
-- Indexes for table `tbl_toppings`
--
ALTER TABLE `tbl_toppings`
  ADD PRIMARY KEY (`topping_ID`);

--
-- Indexes for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  ADD PRIMARY KEY (`tran_id`),
  ADD KEY `fk_scp` (`scoop`),
  ADD KEY `fk_top` (`toppings`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_scoop`
--
ALTER TABLE `tbl_scoop`
  MODIFY `scoop_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tbl_toppings`
--
ALTER TABLE `tbl_toppings`
  MODIFY `topping_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  MODIFY `tran_id` int(60) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `ID` int(60) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  ADD CONSTRAINT `fk_scp` FOREIGN KEY (`scoop`) REFERENCES `tbl_scoop` (`scoop_id`),
  ADD CONSTRAINT `fk_top` FOREIGN KEY (`toppings`) REFERENCES `tbl_toppings` (`topping_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
