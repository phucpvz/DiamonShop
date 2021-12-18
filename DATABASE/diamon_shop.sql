-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 18, 2021 lúc 08:58 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `diamon_shop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `billdetails`
--

CREATE TABLE `billdetails` (
  `id` bigint(20) NOT NULL,
  `id_product` bigint(20) NOT NULL,
  `id_bill` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `billdetails`
--

INSERT INTO `billdetails` (`id`, `id_product`, `id_bill`, `quantity`, `total`) VALUES
(1, 2, 3, 1, 200000),
(2, 7, 3, 1, 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bills`
--

CREATE TABLE `bills` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `display_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `total` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `bills`
--

INSERT INTO `bills` (`id`, `username`, `phone`, `display_name`, `address`, `total`, `quantity`, `note`) VALUES
(3, 'a@gmail.com', '0962792171', 'NguyÃ¡Â»Ân VÃÂn A', '84 - Mai Háº¯c Äáº¿ - Hai BÃ  TrÆ°ng - HÃ  Ná»i', 400000, 2, 'abc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
(1, 'Đồng hồ', NULL),
(2, 'Vòng tay', NULL),
(3, 'Dây đeo tay', NULL),
(4, 'Dây chuyền', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `colors`
--

CREATE TABLE `colors` (
  `id` int(11) NOT NULL,
  `id_product` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `colors`
--

INSERT INTO `colors` (`id`, `id_product`, `name`, `code`, `img`) VALUES
(1, 1, 'Vàng', '#FFFF00', 'a.jpg'),
(2, 1, 'Xanh', '#FFFF00', 'b.jpg'),
(3, 2, 'Vàng', '#FFFF00', 'c.jpg'),
(4, 2, 'Xanh', '#FFFF00', 'd.jpg'),
(5, 5, 'Vàng', '#FFFF00', 'e.jpg'),
(6, 6, 'Vàng', '#FFFF00', 'g.jpg'),
(7, 7, 'Vàng', '#FFFF00', 'h.jpg'),
(8, 8, 'Vàng', '#FFFF00', 'i.jpg'),
(9, 9, 'Vàng', '#FFFF00', 'b.jpg'),
(10, 10, 'Vàng', '#FFFF00', 'b.jpg'),
(11, 11, 'Vàng', '#FFFF00', 'b.jpg'),
(12, 12, 'Vàng', '#FFFF00', 'b.jpg'),
(13, 13, 'Vàng', '#FFFF00', 'b.jpg'),
(14, 14, 'Vàng', '#FFFF00', 'b.jpg'),
(15, 15, 'Vàng', '#FFFF00', 'b.jpg'),
(16, 16, 'Vàng', '#FFFF00', 'b.jpg'),
(17, 17, 'Vàng', '#FFFF00', 'b.jpg'),
(18, 18, 'Vàng', '#FFFF00', 'b.jpg'),
(19, 19, 'Vàng', '#FFFF00', 'b.jpg'),
(20, 20, 'Vàng', '#FFFF00', 'b.jpg'),
(21, 21, 'Vàng', '#FFFF00', 'b.jpg'),
(22, 22, 'Vàng', '#FFFF00', 'b.jpg'),
(23, 23, 'Vàng', '#FFFF00', 'b.jpg'),
(24, 24, 'Vàng', '#FFFF00', 'b.jpg'),
(25, 25, 'Vàng', '#FFFF00', 'b.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menuitems`
--

CREATE TABLE `menuitems` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `menuitems`
--

INSERT INTO `menuitems` (`id`, `name`, `url`) VALUES
(3, 'Trang chủ', NULL),
(4, 'Sản phẩm', NULL),
(5, 'So sánh', NULL),
(6, 'Giỏ hàng', NULL),
(7, 'Bài viết', NULL),
(8, 'Liên hệ', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `id_category` int(11) NOT NULL,
  `sizes` varchar(255) NOT NULL,
  `name` text NOT NULL,
  `price` double NOT NULL,
  `sale` int(3) NOT NULL,
  `title` varchar(255) NOT NULL,
  `highlight` tinyint(1) NOT NULL,
  `new_product` tinyint(1) NOT NULL,
  `details` longtext NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `id_category`, `sizes`, `name`, `price`, `sale`, `title`, `highlight`, `new_product`, `details`, `created_at`, `updated_at`) VALUES
(1, 1, 'L,M,S', 'Manicure & Pedicure', 20000, 0, 'Nowadays the lingerie industry is one of the most successful business spheres. Nowadays the lingerie industry is one of ...', 1, 0, '<div class=\"tab-pane fade active in\" id=\"home\">\r\n			  <h4>Product Information</h4>\r\n                <table class=\"table table-striped\">\r\n				<tbody>\r\n				<tr class=\"techSpecRow\"><td class=\"techSpecTD1\">Color:</td><td class=\"techSpecTD2\">Black</td></tr>\r\n				<tr class=\"techSpecRow\"><td class=\"techSpecTD1\">Style:</td><td class=\"techSpecTD2\">Apparel,Sports</td></tr>\r\n				<tr class=\"techSpecRow\"><td class=\"techSpecTD1\">Season:</td><td class=\"techSpecTD2\">spring/summer</td></tr>\r\n				<tr class=\"techSpecRow\"><td class=\"techSpecTD1\">Usage:</td><td class=\"techSpecTD2\">fitness</td></tr>\r\n				<tr class=\"techSpecRow\"><td class=\"techSpecTD1\">Sport:</td><td class=\"techSpecTD2\">122855031</td></tr>\r\n				<tr class=\"techSpecRow\"><td class=\"techSpecTD1\">Brand:</td><td class=\"techSpecTD2\">Shock Absorber</td></tr>\r\n				</tbody>\r\n				</table>\r\n				<p>Raw denim you probably haven\'t heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>\r\n				<p>Raw denim you probably haven\'t heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>\r\n				<p>Raw denim you probably haven\'t heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>\r\n				<p>Raw denim you probably haven\'t heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>\r\n				<p>Raw denim you probably haven\'t heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>\r\n				<p>Raw denim you probably haven\'t heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>\r\n				<p>Raw denim you probably haven\'t heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>\r\n				<p>Raw denim you probably haven\'t heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>\r\n\r\n			</div>', '2020-04-09 11:38:43', '2020-04-09 11:47:31'),
(2, 1, 'L,S,M', '2', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(3, 1, 'L,S,M', '3', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(4, 1, 'L,S,M', '4', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(5, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(6, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(7, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(8, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(9, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(10, 1, 'L,S,M', '10', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(11, 1, 'L,S,M', '11', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(12, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(13, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(14, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(15, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(16, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(17, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(18, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(19, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(20, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(21, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(22, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(23, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(24, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(25, 1, 'L,S,M', 'cuoi', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(26, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(27, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43'),
(28, 1, 'L,S,M', 'Name', 200000, 0, 'tital', 1, 0, 'details', '2020-04-09 11:38:43', '2020-04-09 11:38:43');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `slides`
--

CREATE TABLE `slides` (
  `id` int(11) NOT NULL,
  `img` varchar(255) NOT NULL,
  `caption` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `slides`
--

INSERT INTO `slides` (`id`, `img`, `caption`, `content`) VALUES
(1, 'carousel3.png', 'Nhiều loại trang sức', 'Đẹp - Thời trang - Giá cả phải chăng'),
(2, 'bootstrap_free-ecommerce.png', 'Vòng đeo tay', 'Đẹp và lấp lánh'),
(3, 'carousel1.png', 'Đồng hồ Thụy Sĩ', 'Thể hiện sự quý phái và lịch lãm'),
(4, 'bootstrap-templates.png', 'Dây chuyền', 'Thích hợp tặng cho người yêu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `display_name` varchar(150) NOT NULL,
  `address` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `display_name`, `address`) VALUES
(1, 'a@gmail.com', '$2a$12$/zpzIdKUyJoQNz0k3zLWxOYZWKE/KyXJaAd4mVkD0Qi7MMBYhstre', 'Nguyá»n VÄn A', '84 - Mai Hắc Đế - Hai Bà Trưng - Hà Nội');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `billdetails`
--
ALTER TABLE `billdetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_bill` (`id_bill`);

--
-- Chỉ mục cho bảng `bills`
--
ALTER TABLE `bills`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `colors`
--
ALTER TABLE `colors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`);

--
-- Chỉ mục cho bảng `menuitems`
--
ALTER TABLE `menuitems`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_category` (`id_category`);

--
-- Chỉ mục cho bảng `slides`
--
ALTER TABLE `slides`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `billdetails`
--
ALTER TABLE `billdetails`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `bills`
--
ALTER TABLE `bills`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `colors`
--
ALTER TABLE `colors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT cho bảng `menuitems`
--
ALTER TABLE `menuitems`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `slides`
--
ALTER TABLE `slides`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `billdetails`
--
ALTER TABLE `billdetails`
  ADD CONSTRAINT `billdetails_ibfk_1` FOREIGN KEY (`id_bill`) REFERENCES `bills` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `billdetails_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `colors`
--
ALTER TABLE `colors`
  ADD CONSTRAINT `colors_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
