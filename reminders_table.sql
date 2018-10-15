-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2018 at 02:00 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reminder`
--

-- --------------------------------------------------------

--
-- Table structure for table `reminders_table`
--

CREATE TABLE `reminders_table` (
  `name` varchar(50) NOT NULL,
  `notes` varchar(500) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `priority` tinyint(1) NOT NULL,
  `completed` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reminders_table`
--

INSERT INTO `reminders_table` (`name`, `notes`, `date`, `time`, `priority`, `completed`) VALUES
('dfdfdfdf', '', '2018-10-15', '16:40:00', 0, 0),
('hvhvhvh', 'vhjvhjvhv', '2018-10-15', '11:11:11', 1, 0),
('hvhvv', 'fyfyf', '2018-10-01', '11:11:11', 1, 1),
('yahoo', '	sssssssssss', '2018-10-16', '14:00:00', 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reminders_table`
--
ALTER TABLE `reminders_table`
  ADD PRIMARY KEY (`name`,`date`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
