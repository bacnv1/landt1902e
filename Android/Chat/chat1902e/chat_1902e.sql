-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 27, 2019 at 03:29 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chat_1902e`
--

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `id` int(11) NOT NULL,
  `user_name` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `message` text COLLATE utf8_unicode_ci NOT NULL,
  `pub_date` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`id`, `user_name`, `message`, `pub_date`) VALUES
(1, 'bacnv', 'Hello', '2019/09/08 15:25:29'),
(2, 'bacnv', 'Hello', '2019/09/08 15:25:46'),
(3, 'bacnv', 'How are you?', '2019/09/08 15:43:41'),
(4, 'bacnv', 'hole', '2019/09/15 14:50:19'),
(5, 'bacnv', 'halo', '2019/09/15 14:50:29'),
(6, 'toan', 'can u hear me', '2019/09/15 14:51:00'),
(7, 'bacnv', 'abc', '2019/09/15 14:53:38'),
(8, 'bacnv', 'aaaaaaaaaaaa', '2019/09/15 14:54:02'),
(9, 'toan', 'giáº­t quÃ¡ ae áº¡ =)))', '2019/09/15 14:54:35'),
(10, 'toan', 'cá»© 1s láº¡i giáº­t phÃ¡t :v', '2019/09/15 14:54:49'),
(11, 'bacnv', 'FDSFSD', '2019/09/15 14:55:32'),
(12, 'linh', 'cgg', '2019/09/15 14:56:43'),
(13, 'nnnn', 'Halo', '2019/09/15 14:56:49'),
(14, 'bacnv', 'dd', '2019/09/15 15:01:44'),
(15, 'nnnn', 'jsdhfja', '2019/09/15 15:01:45'),
(16, 'duypham', 'a', '2019/09/15 15:02:08'),
(17, 'bacnv', 'fdsfsd', '2019/09/15 15:02:45'),
(18, 'bacnv', 'fdsfsdfsd', '2019/09/15 15:02:48'),
(19, 'bacnv', 'aaaaaaaaaaaaaaaaaaaa', '2019/09/15 15:02:53'),
(20, 'bacnv', 'zxczx', '2019/09/15 15:07:22'),
(21, 'toan', 'hÃ¬nh nhÆ° háº¿t r ae áº¡ =)))', '2019/09/15 15:08:36'),
(22, 'bacnv', '1235', '2019/09/15 15:10:21'),
(23, 'bacnv', 'dsadasdasdas', '2019/09/15 15:10:29'),
(24, 'bacnv', '6789', '2019/09/15 15:10:30'),
(25, 'bacnv', 'dasdasdas', '2019/09/15 15:10:33'),
(26, 'toan', 'alo', '2019/09/15 15:11:13'),
(27, 'toan', 'hhhh', '2019/09/15 15:13:06'),
(28, 'nnnn', 'okkk', '2019/09/15 15:13:47'),
(29, 'duypham', 'b', '2019/09/15 15:14:49'),
(30, 'nnnn', 'okkk', '2019/09/15 15:18:30'),
(31, 'abc', 'okekek', '2019/09/20 15:58:38'),
(32, 'abc', 'chÃ o ae', '2019/09/20 15:58:45'),
(33, 'bacnv', '1', '2019/09/20 15:58:47'),
(34, 'abc', '1', '2019/09/20 15:58:47'),
(35, 'abc', ':))', '2019/09/20 15:58:50'),
(36, 'abc', '1', '2019/09/20 15:59:05'),
(37, 'tienth', 'abcd', '2019/09/20 15:59:53'),
(38, 'sonth', '1', '2019/09/20 16:01:22'),
(39, 'anonymous', '13213', '2019/09/20 16:06:39'),
(40, 'anonymous', '3243242', '2019/09/20 16:06:44'),
(41, 'quan', 'gh', '2019/09/27 13:54:38'),
(42, 'bacnv', 'Hello', '2019/09/27 14:07:05'),
(43, 'bacnv', 'Hello', '2019/09/27 14:07:47'),
(44, 'bacnv', 'Hello', '2019/09/27 14:08:06'),
(45, 'bacnv', 'Hello', '2019/09/27 14:13:17'),
(46, 'quan', 'hello', '2019/09/27 14:13:20'),
(47, 'quan', 'aloo', '2019/09/27 14:13:27'),
(48, 'quan', 'Ã¢jajaja', '2019/09/27 14:13:34'),
(49, 'bacnv', 'hello', '2019/09/27 14:13:52'),
(50, 'quan', 'chÃ o moi nguoi :))', '2019/09/27 14:13:53'),
(51, 'quan', 'alo 1234', '2019/09/27 14:14:03'),
(52, 'quan', 'blo', '2019/09/27 14:15:18'),
(53, 't', 'abc', '2019/09/27 14:15:44'),
(54, 'quan', 'abc', '2019/09/27 14:15:53'),
(55, 'quan', 'ab', '2019/09/27 14:53:51'),
(56, 'quan', 'a', '2019/09/27 14:53:56'),
(57, 'quan', 'abc', '2019/09/27 14:54:05'),
(58, 'quan', '0', '2019/09/27 14:54:22'),
(59, 'quan', 'Ãª', '2019/09/27 14:54:26'),
(60, 'quan', 'a', '2019/09/27 14:54:28'),
(61, 'bacnv', 'fdsfds', '2019/09/27 14:54:49'),
(62, 'quan', 'ytrg', '2019/09/27 14:55:03'),
(63, 'quan', 'juyu', '2019/09/27 14:55:06'),
(64, 'quan', 'abcd', '2019/09/27 14:55:16'),
(65, 'toan', 'cÃ³ tháº¥y gÃ¬ Ä‘Ã¢u :v', '2019/09/27 14:55:19'),
(66, 't', 'acffzx', '2019/09/27 14:55:19'),
(67, 'sonth', '1', '2019/09/27 14:55:57'),
(68, 'bacnv', 'abc', '2019/09/27 14:57:51'),
(69, 'bacnv', 'truong\n', '2019/09/27 14:58:20'),
(70, 'quan', 'helo', '2019/09/27 14:58:23'),
(71, 'chi', 'qjhss', '2019/09/27 15:01:50'),
(72, 'bacnv', 'abc', '2019/09/27 15:06:31'),
(73, 'bacnv', '6', '2019/09/27 15:16:04'),
(74, 'toan', '.', '2019/09/27 15:16:16'),
(75, 'chi', 'hi', '2019/09/27 15:16:32'),
(76, 'abc', 'abc', '2019/09/27 15:16:58'),
(77, 'abc', 'Ã¢js', '2019/09/27 15:17:01'),
(78, 'abc', 'xjx', '2019/09/27 15:17:03'),
(79, 'toan', 'hshsjhshs', '2019/09/27 15:17:05'),
(80, 'abc', 'an', '2019/09/27 15:17:07'),
(81, 'toan', 'zui hÃ´ng =)))', '2019/09/27 15:17:10'),
(82, 'bacnv', 'abc', '2019/09/27 15:17:13'),
(83, 'toan', 'ðŸ¤£ðŸ¤£ðŸ¤£', '2019/09/27 15:17:17'),
(84, 'chi', 'ðŸ¤­ðŸ¤­', '2019/09/27 15:17:27'),
(85, 'chi', 'ðŸ˜ðŸ˜ðŸ˜', '2019/09/27 15:17:35'),
(86, 'abc', '0', '2019/09/27 15:17:49'),
(87, 'abc', 'a', '2019/09/27 15:17:53'),
(88, 'chi', 'nháº­u Ä‘Ãª :v ', '2019/09/27 15:17:55'),
(89, 'toan', 'âœ‚ðŸ¦†', '2019/09/27 15:18:04'),
(90, 'chi', 'bia khÃ´ng ae Æ¡i ', '2019/09/27 15:18:15'),
(91, 'abc', '1', '2019/09/27 15:18:16'),
(92, 'toan', 'cÃ²n dÆ° 400k nhá»ƒ :v', '2019/09/27 15:19:24'),
(93, 'toan', 'tháº¥y thá»§ quá»¹ báº£o záº­y =)))', '2019/09/27 15:19:45'),
(94, 'abc', ':))', '2019/09/27 15:20:09'),
(95, 'abc', 'chia Ä‘á»u Ä‘i', '2019/09/27 15:20:15'),
(96, 'abc', ':))', '2019/09/27 15:20:18'),
(97, 'toan', 'á»«, nay váº¯ng váº¯ng chia ms Ä‘c nhiá»u :v', '2019/09/27 15:20:44'),
(98, 'abc', 'ðŸ˜‚ðŸ˜‚ðŸ˜‚', '2019/09/27 15:21:14'),
(99, 'abc', ':))', '2019/09/27 15:21:20');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_name` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `token` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_name`, `password`, `name`, `token`) VALUES
('abc', '1', 'abc', 'eVZj8PdW5JU:APA91bHAa_38FgOJF7NVFB9f1iHILsAm8H6hAh6FeLIiGxlrDx-6agWqFYkM_UY4eoiI0nlPwgroxGPPvJGSqPUAp-Y2062du7bnANiaTxXqANB3igvGjipXBZGXn_KldpQrdC8hQiMS'),
('anonymous', '123', 'Anonymous', ''),
('bacnv', '123456', 'Bac', 'eVZj8PdW5JU:APA91bHAa_38FgOJF7NVFB9f1iHILsAm8H6hAh6FeLIiGxlrDx-6agWqFYkM_UY4eoiI0nlPwgroxGPPvJGSqPUAp-Y2062du7bnANiaTxXqANB3igvGjipXBZGXn_KldpQrdC8hQiMS'),
('chi', '123', 'linh chi', 'eLJLJUUuypQ:APA91bF76zFmqLHLaB1-kq2EPe76tV7vzYr5N4ybCVXf-2hvHZ8J5Rdbd8kdgBI6Pk79r5ROqaL5h5dnfF-qyK6MUzZwCpm_DUaSl7gYA-oMjrASzHnMAWN9EK5IeJXJ3Xo_VtMX3Qpn'),
('duy', '12345678', 'Duy', ''),
('duypham', '12345678', 'Duy', ''),
('linh', '123', 'linh', ''),
('linh12', '1233', 'linh', ''),
('linhnguyen', '12345', 'linh', ''),
('nguyenlinh', '123', 'linh', ''),
('nnnn', '123', 'Anonymous', ''),
('phamduy', '1234567', 'Duy', ''),
('quan', '123', 'quN', 'eVZj8PdW5JU:APA91bHAa_38FgOJF7NVFB9f1iHILsAm8H6hAh6FeLIiGxlrDx-6agWqFYkM_UY4eoiI0nlPwgroxGPPvJGSqPUAp-Y2062du7bnANiaTxXqANB3igvGjipXBZGXn_KldpQrdC8hQiMS'),
('sonth', '1', 'son', 'dZYO6RooVuM:APA91bHUys6DUwYm7dBnL7q7W_Avj36A73r7tTeg-2Ly2M7d4Z45xklWXOSZUPzL5TRkw06_azrXB24BBI8o1-MDCPcqu64IzUPtWr1Vsuf8fBnPUsUhT58JFtXoaQBFJK8Au0-ApymA'),
('sonth2', '1', 'son', ''),
('t', '1', 't', 'crPodyrt93w:APA91bFU6DuzZ4Q9lxNWl53U2pSM58a7wtQj0nhGApzk4PN0oOdhkSqTM3SajIiZ06PZtqhyeTDZmEX3vdylE0ktp2yjjXPIIs_bRGVOdci4VNr-20-fidPUz56XSR2aXK5Jd1qUGfxq'),
('tien', '123', 'tien', ''),
('tienth', '123', 'tien', 'f1qrqNR0aY8:APA91bFa83DVIRrSCee6L482hToDUUP9dibL-Vwu9wjIHdZzo4W7Fzc9Vq0pvxuhovVfcnFWIP0fqaEXrTrWERZiEp3narxl7ficSYlbylIqZH293A49e4GN-TKW68VMlAJIoAHlhUuS'),
('toan', '123456', 'toan', ''),
('toan1231', '123456', 'toan', ''),
('truong98', '1234567', 'Truong', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
