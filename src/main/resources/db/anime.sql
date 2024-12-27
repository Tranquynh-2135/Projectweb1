-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 27, 2024 lúc 03:48 AM
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
-- Cấu trúc bảng cho bảng `anime`
--

CREATE TABLE `anime` (
  `id` bigint(20) NOT NULL,
  `cover_image` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `release_year` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `anime`
--

INSERT INTO `anime` (`id`, `cover_image`, `description`, `rating`, `release_year`, `title`) VALUES
(2, 'naruto.jpg', 'A young ninja dreams of becoming Hokage.', 9.7, 2002, 'Naruto'),
(3, 'one_piece.jpg', 'The journey of Monkey D. Luffy to find the ultimate treasure.', 10, 1999, 'One Piece'),
(4, 'death_note.jpg', 'A high school student discovers a supernatural notebook.', 9.2, 2006, 'Death Note'),
(5, 'myHeroAcademia.jpg', 'A world where almost everyone has superpowers.', 8.4, 2016, 'My Hero Academia'),
(6, 'bleach.jpg', 'A high school student becomes a Soul Reaper to protect the living and the dead.', 8.2, 2004, 'Bleach'),
(7, 'doraemon.jpg', 'A robotic cat travels back in time to help a young boy improve his future.', 8, 1979, 'Doraemon'),
(8, 'conan.jpg', 'A young detective solves mysteries while trapped in a child\'s body.', 8.5, 1996, 'Detective Conan'),
(9, 'pokemon.jpg', 'A young trainer travels the world to become a Pokemon Master.', 7.5, 1997, 'Pokemon'),
(10, 'reZero.jpg', 'A boy is transported to another world where he faces death and resets.', 8.3, 2016, 'Re:Zero'),
(11, 'kiseijuu.jpg', 'A teenager fights for survival after being infected by a parasitic alien.', 8.4, 2014, 'Kiseijuu: Sei no Kakuritsu'),
(12, 'berserk.jpg', 'A dark fantasy story of a lone swordsman seeking revenge.', 9, 1997, 'Berserk'),
(13, 'dan-dan-da.jpg', 'A surreal adventure filled with bizarre twists and unexpected friendships.', 7.8, 2021, 'Dan-Da-Dan'),
(14, 'overlord.jpg', 'A gamer is trapped in his favorite MMORPG as his powerful in-game character.', 8.1, 2015, 'Overlord'),
(15, 'black_clover.jpg', 'A young boy born without magic aims to become the Wizard King.', 8.3, 2017, 'Black Clover'),
(16, 'saitama.jpg', 'A hero who can defeat any enemy with a single punch, seeking stronger challenges.', 8.7, 2015, 'One Punch Man'),
(17, 'shadow_garden.jpg', 'A secret organization works in the shadows to fight an unseen enemy.', 8.5, 2022, 'Shadow Garden'),
(18, 'dororo.jpg', 'A ronin teams up with a child thief to reclaim his stolen body parts.', 8.3, 2019, 'Dororo'),
(19, 'sousou_no_frieren.jpg', 'An elf mage explores the meaning of life and legacy after the defeat of a demon king.', 8.6, 2023, 'Sousou no Frieren'),
(20, 'dragonball_super.jpg', 'The continuation of Goku\'s adventures as he faces gods and intergalactic challenges.', 8.4, 2015, 'Dragon Ball Super'),
(23, 'attack_on_titan.jpg', 'Đại chiến Titan, cũng được biết tới với tựa bản tiếng Anh Attack on Titan và tên gốc tiếng Nhật Shingeki no Kyojin (Nhật: 進撃しんげきの巨人きょじん (Tiến Kích Cự Nhân)? . \'\"Người khổng lồ tiến công\"\') là một bộ manga Nhật Bản do Isayama Hajime sáng tác. ', 9, 2009, 'Attack on Titann');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `anime`
--
ALTER TABLE `anime`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `anime`
--
ALTER TABLE `anime`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
