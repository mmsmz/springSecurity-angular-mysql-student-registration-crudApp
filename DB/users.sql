-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2021 at 06:04 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `courseid` int(11) NOT NULL,
  `coursename` varchar(40) NOT NULL,
  `courseprice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`courseid`, `coursename`, `courseprice`) VALUES
(1, 'strings', 15410),
(2, 'FADS', 123456),
(3, 'FDSAD', 798456);

-- --------------------------------------------------------

--
-- Table structure for table `studentcourses`
--

CREATE TABLE `studentcourses` (
  `studcrsid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentcourses`
--

INSERT INTO `studentcourses` (`studcrsid`, `userid`, `courseid`) VALUES
(3, 1, 1),
(13, 1, 2),
(16, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `usertype` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Id`, `username`, `email`, `usertype`, `password`) VALUES
(1, 'Maas', 'maas@gmail.com', 'USER', '456'),
(2, 'mujaaaaaaaa', 'muja@gmail.com', 'student', 'null'),
(4, 'Islam', 'islam@gmail.com', NULL, NULL),
(10000, 'admin', 'admin@gmail.com', 'ADMIN', '123'),
(200000, 'desk', 'desk@gmail.com', 'frontdesk', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`courseid`);

--
-- Indexes for table `studentcourses`
--
ALTER TABLE `studentcourses`
  ADD PRIMARY KEY (`studcrsid`),
  ADD KEY `userid` (`userid`),
  ADD KEY `courseid` (`courseid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `studentcourses`
--
ALTER TABLE `studentcourses`
  MODIFY `studcrsid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `studentcourses`
--
ALTER TABLE `studentcourses`
  ADD CONSTRAINT `studentcourses_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`Id`),
  ADD CONSTRAINT `studentcourses_ibfk_2` FOREIGN KEY (`courseid`) REFERENCES `courses` (`courseid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
