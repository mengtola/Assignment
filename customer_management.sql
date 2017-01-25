-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2017 at 05:10 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `customer_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `td_customer`
--

CREATE TABLE IF NOT EXISTS `td_customer` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_first_name` varchar(50) NOT NULL DEFAULT '0',
  `cus_last_name` varchar(50) NOT NULL DEFAULT '0',
  `cus_gender` varchar(1) NOT NULL DEFAULT '0',
  `cus_email_address` varchar(50) NOT NULL DEFAULT '0',
  `cus_dob` date NOT NULL DEFAULT '0000-00-00',
  `cus_address` varchar(200) NOT NULL DEFAULT '0',
  `cus_phone` varchar(20) NOT NULL DEFAULT '0',
  `cus_created` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `cus_updated` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `td_customer`
--

INSERT INTO `td_customer` (`cus_id`, `cus_first_name`, `cus_last_name`, `cus_gender`, `cus_email_address`, `cus_dob`, `cus_address`, `cus_phone`, `cus_created`, `cus_updated`) VALUES
(1, 'Bun', 'Samno', '0', 'bunsamno@gmail.com', '1990-04-06', 'Phnom Penh', '069875643', '2016-12-12 00:00:00', '2017-01-24 23:05:20'),
(2, 'Heng', 'Dara', '0', 'hengdara@yahoo.com', '1990-12-14', 'Phnom Penh', '098765435', '2015-12-13 00:00:00', '2017-01-24 23:04:54'),
(3, 'Sok', 'Lida', '0', 'Soklida@gmail.com', '1992-01-16', 'Phnom Penh, Cambodia', '09835645', '2016-01-09 00:00:00', '2017-01-11 00:00:00'),
(4, 'Heng', 'Panha', '1', 'hengpanha@ymail.com', '1990-04-09', 'Kompung Cham', '09876343', '2016-01-09 00:00:00', '2017-02-12 00:00:00'),
(5, 'Sok', 'Suny', '0', 'suny@gmail.com', '1990-09-09', 'Kompung Chhnang', '098745345', '2015-03-09 00:00:00', '2017-01-24 23:05:45'),
(6, 'Eng', 'Chan', '1', 'engchan@gmail.com', '1990-03-04', 'Phnom Penh', '090976563', '2015-02-06 00:00:00', '2016-09-12 00:00:00'),
(7, 'Sok', 'Sopheak', '1', 'sokpheak@gmail.com', '1990-09-02', 'Phnom Penh', '0976543654', '2015-11-19 00:00:00', '2017-01-09 00:00:00'),
(8, 'Det', 'Nary', '0', 'nary@gmail.com', '1992-01-02', 'Phnom Penh', '098765643', '2015-09-16 00:00:00', '2017-01-24 23:07:57'),
(9, 'No', 'Bunly', '1', 'bunly@gmail.com', '1991-08-03', 'Phnom Penh', '09876343', '2016-01-09 00:00:00', '2017-01-02 00:00:00'),
(10, 'Heng', 'Sopheaktra', '1', 'sopheaktra', '1992-09-09', 'Phnom Penh', '089873465', '2015-09-23 00:00:00', '2016-04-03 00:00:00'),
(11, 'Pun', 'Dara', '1', 'darapun@gmail.com', '1990-03-09', 'Phnom Penh', '012436754', '2015-04-03 00:00:00', '2017-01-05 00:00:00'),
(12, 'Om', 'Novan', '1', 'novan@gmail.com', '1987-00-00', 'Phnom Penh', '011348743', '2015-03-01 00:00:00', '2016-09-14 00:00:00'),
(13, 'Ty', 'Henglay', '1', 'henglay@gmail.com', '1990-02-04', 'Phnom Penh', '09873433', '2016-01-04 00:00:00', '2017-02-17 00:00:00'),
(14, 'Sun', 'Lida', '0', 'lida@gmail.com', '1987-08-19', 'Phnom Penh', '093657845', '2015-09-18 00:00:00', '2016-08-17 00:00:00'),
(15, 'Ly', 'Polin', '1', 'polin@gmail.com', '1993-02-07', 'Phnom Penh', '090876754', '2015-02-06 00:00:00', '2016-09-19 00:00:00'),
(16, 'Eang', 'Oudom', '1', 'eangoudom@gmail.com', '1990-08-09', 'Phnom Penh', '098348765', '2015-09-23 00:00:00', '2016-09-12 00:00:00'),
(17, 'Leng', 'Kanha', '1', 'kanha@gmail.com', '1992-09-19', 'Phnom Penh', '098734323', '2016-01-19 00:00:00', '2016-09-23 00:00:00'),
(18, 'Hong', 'Ly', '0', 'ly@gmail.com', '1992-01-01', 'Phnom Penh', '09876987', '2014-01-02 00:00:00', '2016-01-09 00:00:00'),
(19, 'Sreang', 'Kimheng', '1', 'kimheng@gmail.com', '1990-11-23', 'Phnom Penh', '095454354', '2015-09-12 00:00:00', '2016-02-18 00:00:00'),
(20, 'Hy', 'Model', '1', 'model@gmail.com', '1989-12-11', 'Phnom Penh', '098734543', '2014-01-01 00:00:00', '2016-09-01 20:16:03'),
(21, 'Dy', 'Sopheak', '1', 'sopheakdy@gmail.com', '1990-09-12', 'Phnom Penh', '098783454', '2015-01-01 00:00:00', '2017-01-09 00:00:00'),
(22, 'Heng', 'Chanda', '0', 'chanda@gmail.com', '1995-10-01', 'Phnom Penh', '0108764563', '2017-01-24 21:29:48', '2017-01-24 21:29:48'),
(23, 'Bun', 'Samno', '0', 'bunsamno@gmail.com', '1990-04-06', 'Phnom Penh', '069875643', '2017-01-24 22:54:19', '2017-01-24 22:54:19');

-- --------------------------------------------------------

--
-- Table structure for table `td_user`
--

CREATE TABLE IF NOT EXISTS `td_user` (
  `use_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`use_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `td_user`
--

INSERT INTO `td_user` (`use_id`, `username`, `password`) VALUES
(1, 'admin', '123456');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
