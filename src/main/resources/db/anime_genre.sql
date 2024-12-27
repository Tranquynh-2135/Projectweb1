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
-- Cấu trúc bảng cho bảng `anime_genre`
--

CREATE TABLE `anime_genre` (
  `anime_id` bigint(20) NOT NULL,
  `genre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `anime_genre`
--

INSERT INTO `anime_genre` (`anime_id`, `genre_id`) VALUES
(4, 8),
(4, 7),
(4, 9),
(4, 10),
(4, 4),
(5, 1),
(5, 17),
(5, 4),
(5, 3),
(6, 1),
(6, 7),
(6, 4),
(6, 5),
(7, 6),
(7, 12),
(7, 13),
(7, 14),
(4, 8),
(4, 7),
(4, 9),
(4, 10),
(4, 4),
(5, 1),
(5, 17),
(5, 4),
(5, 3),
(6, 1),
(6, 7),
(6, 4),
(6, 5),
(7, 6),
(7, 12),
(7, 13),
(7, 14),
(4, 8),
(4, 7),
(4, 9),
(4, 10),
(4, 4),
(5, 1),
(5, 17),
(5, 4),
(5, 3),
(6, 1),
(6, 7),
(6, 4),
(6, 5),
(7, 6),
(7, 12),
(7, 13),
(7, 14),
(4, 8),
(4, 7),
(4, 9),
(4, 10),
(4, 4),
(5, 1),
(5, 17),
(5, 4),
(5, 3),
(6, 1),
(6, 7),
(6, 4),
(6, 5),
(7, 6),
(7, 12),
(7, 13),
(7, 14),
(8, 9),
(8, 8),
(9, 5),
(9, 3),
(9, 13),
(9, 4),
(4, 8),
(4, 7),
(4, 9),
(4, 10),
(4, 4),
(5, 1),
(5, 17),
(5, 4),
(5, 3),
(6, 1),
(6, 7),
(6, 4),
(6, 5),
(7, 6),
(7, 12),
(7, 13),
(7, 14),
(8, 9),
(8, 8),
(9, 5),
(9, 3),
(9, 13),
(9, 4),
(4, 8),
(4, 7),
(4, 9),
(4, 10),
(4, 4),
(5, 1),
(5, 17),
(5, 4),
(5, 3),
(6, 1),
(6, 7),
(6, 4),
(6, 5),
(7, 6),
(7, 12),
(7, 13),
(7, 14),
(8, 9),
(8, 8),
(9, 5),
(9, 3),
(9, 13),
(9, 4),
(10, 3),
(10, 2),
(10, 10),
(11, 16),
(11, 10),
(11, 12),
(11, 15),
(12, 1),
(12, 5),
(12, 2),
(12, 3),
(12, 16),
(12, 15),
(13, 6),
(13, 1),
(13, 4),
(4, 8),
(4, 7),
(4, 9),
(4, 10),
(4, 4),
(5, 1),
(5, 17),
(5, 4),
(5, 3),
(6, 1),
(6, 7),
(6, 4),
(6, 5),
(7, 6),
(7, 12),
(7, 13),
(7, 14),
(8, 9),
(8, 8),
(9, 5),
(9, 3),
(9, 13),
(9, 4),
(10, 3),
(10, 2),
(10, 10),
(11, 16),
(11, 10),
(11, 12),
(11, 15),
(12, 1),
(12, 5),
(12, 2),
(12, 3),
(12, 16),
(12, 15),
(13, 6),
(13, 1),
(13, 4),
(14, 1),
(14, 3),
(14, 7),
(15, 1),
(15, 3),
(15, 4),
(16, 1),
(16, 6),
(16, 17),
(16, 4),
(17, 1),
(17, 3),
(17, 9),
(18, 1),
(18, 5),
(18, 3),
(18, 18),
(19, 3),
(19, 2),
(19, 5),
(19, 19),
(20, 1),
(20, 5),
(20, 3),
(20, 4),
(23, 3),
(3, 1),
(3, 4),
(3, 5),
(3, 6),
(3, 7),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 10);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `anime_genre`
--
ALTER TABLE `anime_genre`
  ADD KEY `FKfsd5quou9lv0tlt8br825w9yn` (`genre_id`),
  ADD KEY `FK72693b55ypxe99ik71d43od0v` (`anime_id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `anime_genre`
--
ALTER TABLE `anime_genre`
  ADD CONSTRAINT `FK72693b55ypxe99ik71d43od0v` FOREIGN KEY (`anime_id`) REFERENCES `anime` (`id`),
  ADD CONSTRAINT `FKfsd5quou9lv0tlt8br825w9yn` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
