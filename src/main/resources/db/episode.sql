-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 27, 2024 lúc 03:50 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `webanime`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `episode`
--

CREATE TABLE `episode` (
  `id` bigint(20) NOT NULL,
  `episode_number` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `anime_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `episode`
--

INSERT INTO `episode` (`id`, `episode_number`, `title`, `video_url`, `anime_id`) VALUES
(25, 1, 'Tập 1', '/images/tap/tap_1.jpg', 2),
(26, 2, 'Tập 2', '/images/tap/tap_2.jpg', 2),
(27, 3, 'Tập 3', '/images/tap/tap_3.jpg', 2),
(28, 4, 'Tập 4', '/images/tap/tap_4.jpg', 2),
(29, 5, 'Tập 5', '/images/tap/tap_5.jpg', 2),
(30, 6, 'Tập 6', '/images/tap/tap_6.jpg', 2),
(31, 7, 'Tập 7', '/images/tap/tap_7.jpg', 2),
(32, 8, 'Tập 8', '/images/tap/tap_8.jpg', 2),
(33, 9, 'Tập 9', '/images/tap/tap_9.jpg', 2),
(34, 10, 'Tập 10', '/images/tap/tap_10.jpg', 2),
(35, 11, 'Tập 11', '/images/tap/tap_11.jpg', 2),
(36, 12, 'Tập 12', '/images/tap/tap_12.jpg', 2),
(37, 13, 'Tập 13', '/images/tap/tap_13.jpg', 2),
(38, 14, 'Tập 14', '/images/tap/tap_14.jpg', 2),
(39, 15, 'Tập 15', '/images/tap/tap_15.jpg', 2),
(40, 16, 'Tập 16', '/images/tap/tap_16.jpg', 2),
(41, 17, 'Tập 17', '/images/tap/tap_17.jpg', 2),
(42, 18, 'Tập 18', '/images/tap/tap_18.jpg', 2),
(43, 19, 'Tập 19', '/images/tap/tap_19.jpg', 2),
(44, 20, 'Tập 20', '/images/tap/tap_20.jpg', 2),
(45, 21, 'Tập 21', '/images/tap/tap_21.jpg', 2),
(46, 22, 'Tập 22', '/images/tap/tap_22.jpg', 2),
(47, 23, 'Tập 23', '/images/tap/tap_23.jpg', 2),
(48, 24, 'Tập 24', '/images/tap/tap_24.jpg', 2),
(49, 1, 'Tập 1', '/images/tap/tap_1.jpg', 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `episode`
--
ALTER TABLE `episode`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKff8600eu8cj98mtididvgpfld` (`anime_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `episode`
--
ALTER TABLE `episode`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=357;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `episode`
--
ALTER TABLE `episode`
  ADD CONSTRAINT `FKff8600eu8cj98mtididvgpfld` FOREIGN KEY (`anime_id`) REFERENCES `anime` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
