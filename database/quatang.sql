-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 11, 2019 lúc 09:03 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quatang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(10000) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(2, 19, 21, 'Chuông gió phong thủy', 225000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `sodienthoai` int(11) NOT NULL,
  `diachi` varchar(200) NOT NULL,
  `tongtien` int(11) NOT NULL,
  `ngaytao` datetime NOT NULL,
  `trangthai` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `diachi`, `tongtien`, `ngaytao`, `trangthai`) VALUES
(19, '1', 1, '1', 225000, '2019-01-11 11:38:00', 'PENDING');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaiquatang`
--

CREATE TABLE `loaiquatang` (
  `id` int(11) NOT NULL,
  `tenloaiqt` varchar(200) NOT NULL,
  `hinhanhloaiqt` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaiquatang`
--

INSERT INTO `loaiquatang` (`id`, `tenloaiqt`, `hinhanhloaiqt`) VALUES
(1, 'Chuông gió Nhật Bản', 'http://www.winwinshop88.vn/ProductImage/Chuong%20gio%20nhat%20ban_avatar.jpg'),
(2, 'Quả cầu tuyết pha lê', 'http://www.winwinshop88.vn/ProductImage/QCTTN%20V.32%20co%20nhac%20co%20den%20thoi%20tuyet_avatar.jpg'),
(3, 'Ly đổi màu - đổi kiểu', 'http://www.winwinshop88.vn/ProductImage/HB12_avatar.jpg'),
(4, 'Hộp nhạc', 'http://www.winwinshop88.vn/ProductImage/hop%20nhac%20piano%20vu%20cong_avatar.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quatang`
--

CREATE TABLE `quatang` (
  `id` int(11) NOT NULL,
  `tenqt` varchar(200) NOT NULL,
  `giaqt` int(15) NOT NULL,
  `hinhanhqt` varchar(200) NOT NULL,
  `mota` varchar(5000) NOT NULL,
  `idqt` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `quatang`
--

INSERT INTO `quatang` (`id`, `tenqt`, `giaqt`, `hinhanhqt`, `mota`, `idqt`) VALUES
(1, 'Chuông gió nhật bản Furin', 95000, 'http://www.winwinshop88.vn/ProductImage/FURIN%20-%20MS04-avatar.jpg', 'Sản phẩm là một chiếc chuông gió bằng thủy tinh khá đơn giản, hình bầu, với thành thủy tinh được thiết kế khá đặc biệt, rất mỏng, cho nên sẽ phát ra âm thanh rất \"thanh\", nghe rất êm tai như một điệu nhạc, tạo ra cảm giác thanh thản cho người nghe. Và đặc biệt hơn nữa nó cũng là một \"công cụ\" để \"nhắc nhở\" người nhận món quà này luôn nhớ đến \"người tặng\". Vừa ý nghĩa, vừa lý tưởng. Đó cũng là nguyên nhân mình luôn chọn chiếc chuông gió này để tặng bạn bè, người thân và \"người ấy\" nữa đấy.', 1),
(2, 'Chuông gió Vintage Nhật Bản mèo TOTORO', 110000, 'http://www.winwinshop88.vn/ProductImage/Chu%C3%B4ng%20gi%C3%B3%20Vintage%20Nh%E1%BA%ADt%20B%E1%BA%A3n%20m%C3%A8o%20TOTORO%20avatar.jpg', 'huông gió Vintage Nhật Bản mèo TOTORO sẽ mang may mắn, bình an, tài lộc trên các chặng đường. Đây sẽ là món quà ý nghĩa mà bạn có thể dành tặng người thân yêu của mình trong những dịp đặc biệt.Chuông gió Vintage Nhật Bản mèo TOTORO mô phỏng hình ảnh chú mèo béo Totoro – một nhân vật hoạt hình nổi tiếng của Nhật Bản. Chú mèo đáng yêu này được làm từ chất liệu gốm sứ bền và đẹp. Với những họa tiết sinh động, chú mèo hiện diện cùng sự dễ mến với khuôn mặt biết cười ngộ nghĩnh, khoác trên mình chiếc áo hồng hoặc nâu cùng cái bụng trắng đáng yêu, thân hình tròn trịa.', 1),
(3, 'Chuông gió mèo Totoro V.2', 130000, 'http://www.winwinshop88.vn/ProductImage/Chuong%20gio%20meo%20Totoro%20V2_avatar.jpg', 'Công nghệ Led mới nhất hiện nay, áp dụng phương pháp tạo ánh sáng như loài đom đóm, cho ra ánh sáng từ các vật liệu nhỏ nhất và cực kì tiết kiệm điện năng.Chuông gió có dây đèn đom đóm quấn quanh mèo Totoro, dây đèn đom đóm không có trở ngại về mặt điều kiện khí hậu.', 1),
(4, 'Chuông gió hình con thỏ V.3', 75000, 'http://www.winwinshop88.vn/ProductImage/Chuong%20gio%20hinh%20con%20tho%20V3_avatar.jpg', 'Sản phẩm là một chiếc chuông gió hình con thỏ khá dễ thương, khi cơn gió đến chiếc chuông gió sẽ phát ra âm thanh nghe rất êm tai như một điệu nhạc, tạo ra cảm giác thanh thản cho người nghe. Và đặc biệt hơn nữa nó cũng là một \"công cụ\" để \"nhắc nhở\" người nhận món quà này luôn nhớ đến \"người tặng\". Vừa ý nghĩa, vừa lý tưởng. Đó cũng là nguyên nhân để các bạn chọn chiếc chuông gió này để tặng bạn bè, người thân và \"người ấy\" nữa đấy.', 1),
(5, 'Chuông gió nhật bản mèo mỉm cười', 65000, 'http://www.winwinshop88.vn/ProductImage/chuong-gio-nhat-ban-meo-mim-cuoi.jpg', 'Bạn là tín đồ của nước Nhật ? Bạn có tìm hiểu phong tục tập quán nước Nhật thì chắc chắn bạn cũng biết chuông gió được treo ở nhật là ý nghĩa như thế nào?Chuông gió nhật bản treo ở hiên nhà hoặc khu gần cửa sổ nên khi có gió, chuông sẽ phát ra tiếng kêu, chuông kêu báo hiệu có gió đến, vì vậy người nhật có quan niệm chuông gió có thể mời gió mang theo sự mát lành. Chuông gió được làm từ nhiều chất liệu khác nhau từ kim loại, thủy tinh, gốm sứ và cả gỗ , tuy nhiên những chiếc chuông bằng sứ rất được mọi người ưa chuộng vì sự đa dạng về màu sắc và âm thanh của chúng . Bên cạnh đó chuông gió mèo được coi là biểu tượng của may mắn, đem đến vận may cho gia đình và những cửa hàng đặt bức tượng ở cửa ra vào. Niềm tin này được cho là bắt nguồn từ một điển tích xưa của người Trung Quốc : “ Khi mèo đưa chân lên dụi mắt thì khách sẽ tới nhà”.Sự kết hợp của chuông gió nhật bản và mèo may mắn sẽ mang đến cho gia đình bàn 1 làn gió mới, không khí mới,anh lành và thịnh vượng. 1 tín đồ nhật bản,1 tín đồ của phong thủy tâm linh sao không thử đến với winwinshop để rinh ngay về nhà chiếc chuông gió nhật bản mèo mỉm cười để cầu mong 1 gia đạo bình an 1 hy vọng may mắn trong cuộc sống ...', 1),
(6, 'Quả cầu tuyết ngựa unicorn', 350000, 'http://www.winwinshop88.vn/ProductImage/qua-cau-tuyet-ngua-unicorn.jpg', 'Lung linh với hình ảnh những “bông tuyết” nhỏ xíu dễ thương, du dương êm dịu với âm thanh từ bản nhạc lãng mạn. Bạn có tin là mình có thể nhìn ngắm và lắng nghe mãi mà không thấy chán, với cảm giác hạnh phúc và kỳ diệu biết bao! Mùa Noel và Valentine năm nay Quả Cầu Tuyết chắc chắn là món quà vô cùng ý nghĩa và “Hot” lắm đấy.Quả cầu tuyết là một món đồ lưu niệm rất đỗi dễ thương và cũng đầy lãng mạn. Nó thu hút chúng ta bởi vẻ lấp lánh của những “bông tuyết” trong cái thế giới nhỏ bé và rất đỗi mong manh ấy. Tưởng chừng như thế giới ấy chỉ tồn tại những điều kì diệu, trong sạch và tinh khiết hơn hẳn thế giới thực của chúng ta. Không thể tin được rằng, trong quả cầu tuyết bé xíu lại ẩn chứa cả một thế giới \"tí hon\" vô cùng thú vị.', 2),
(7, 'Quả cầu tuyết tình nhân', 350000, 'http://www.winwinshop88.vn/ProductImage/QCTTN%20V.32%20co%20nhac%20co%20den%20thoi%20tuyet_avatar.jpg', 'Quả cầu tuyết là một món đồ lưu niệm rất đỗi dễ thương và cũng đầy lãng mạn. Nó thu hút chúng ta bởi vẻ lấp lánh của những “bông tuyết” trong cái thế giới nhỏ bé và rất đỗi mong manh ấy. Tưởng chừng như thế giới ấy chỉ tồn tại những điều kì diệu, trong sạch và tinh khiết hơn hẳn thế giới thực của chúng ta. Không thể tin được rằng, trong quả cầu tuyết bé xíu lại ẩn chứa cả một thế giới \"tí hon\" vô cùng thú vị.Quả cầu tuyết phát nhạc với giai điệu êm ái, nhẹ nhàng.\r\n	- Được bảo quản bởi lớp thủy tinh dày chắc\r\n	- Là quà tặng Noel, Valentine, sinh nhật, 20/10, 8/3...\r\n	- Là món quà lưu niệm thật dễ thương và lãng mạn\r\n	- Có nhạc - Có đèn led- Tự động thổi tuyết khi bật công tắc- Tặng kèm 3 pin AAA\r\n	- Chiều cao: 15 cm', 2),
(8, 'Quả cầu tuyết tình nhân V.2', 350000, 'http://www.winwinshop88.vn/ProductImage/QCTTN%20V31%20co%20nhac%20co%20den%20thoi%20tuyet_avatar.jpg', 'Quả cầu tuyết phát nhạc với giai điệu êm ái, nhẹ nhàng.\r\n	- Được bảo quản bởi lớp thủy tinh dày chắc\r\n	- Là quà tặng Noel, Valentine, sinh nhật, 20/10, 8/3...\r\n	- Là món quà lưu niệm thật dễ thương và lãng mạn\r\n	- Có nhạc - Có đèn led- Tự động thổi tuyết khi bật công tắc- Tặng kèm 3 pin AAA\r\n	- Chiều cao: 15 cm- Màu: hồng, xanh dương', 2),
(9, 'Quả cầu tuyết tình nhân V.3', 250000, 'http://www.winwinshop88.vn/ProductImage/QCT%20tinh%20nhan%20V16_avatar2.jpg', 'Quả cầu tuyết phát nhạc với giai điệu êm ái, nhẹ nhàng.\r\n	- Được bảo quản bởi lớp thủy tinh dày chắc\r\n	- Là quà tặng Noel, Valentine, sinh nhật, 20/10, 8/3...\r\n	- Là món quà lưu niệm thật dễ thương và lãng mạn\r\n	- Động cơ: dây cót. Hoạt động: khi xoay dây cót, nhạc vang lên, hình trong cầu nước xoay tròn theo giai điệu, những hạt kim tuyến li ti tung bay nhẹ nhàng.\r\n	- Hàng cao cấp, chi tiết sắc sảo, tất cả các loại music box đều phát nhạc\r\n	- Tất cả các loại quả cầu tuyết bên trong đều có hạt kim tuyến hoặc mút xốp nhỏ, khi lắc lên tạo hiệu ứng tuyết rơi cực đẹp!\r\n	- Xoay đế để lên dây cót, khi phát nhạc thì hình bên trong quả cầu quay tròn.\r\n	 - Chiều cao: 15 cm', 2),
(10, 'Quả cầu tuyết tình nhân V.4', 300000, 'http://www.winwinshop88.vn/ProductImage/QCT%20tinh%20nhan%20V30_avatar.jpg', 'Quả cầu tuyết phát nhạc với giai điệu êm ái, nhẹ nhàng.\r\n- Được bảo quản bởi lớp thủy tinh dày chắc\r\n- Là quà tặng Noel, Valentine, sinh nhật, 20/10, 8/3...\r\n- Là món quà lưu niệm thật dễ thương và lãng mạn\r\n- Có nhạc khi xoay dây cót- Có đèn led- Có nhạc- Tặng kèm 3 pin AAA\r\n- Chiều cao: 15 cm', 2),
(11, 'Ly đổi màu game Pac-Man', 139000, 'http://www.winwinshop88.vn/ProductImage/Ly%20doi%20mau%20game%20Pac-Man_avatar2.jpg', 'Chiếc ly trước khi cho nước vào có màu nâu đen với các chi tiết không nổi bật, nhưng sau khi đổi màu thì chắc chắn  người nhận sẽ có một bất ngờ vô cùng thú vị đó.\r\n	- Có được đặc tính lý thú như vậy là do chiếc ly đổi màu được phủ một lớp men cảm biến nhiệt độ, đây là loại men cao cấp đặc biệt nhạy cảm với nhiệt. Do đó bạn sẽ bất ngờ khi thấy nước nóng được rót vô tới đâu thì chiếc ly lại đổi màu tới đó, đồng thời hé lộ ra những thông điệp ý nghĩa.  \r\n	- Được sản xuất hoàn toàn bằng sứ cao cấp, không bị rạn hay mùi hóa chất độc hại nên sản phẩm ly đổi màu được đảm bảo là an toàn tuyệt đối cho người sử dụng.   - Kích thước: 7.7 x 9.2 cm- Chất liệu: sứ cao cấp- Khi đổ nước nóng vào ly, hình vẽ các nấc pin màu xanh sẽ sáng lên theo mực nước; khi nước nguội, các hình vẽ này trở lại màu đen như ban đầu.- Khi đổ nước nóng vào ly, trò chơi game Pac-Man sẽ hiện ra theo mực nước; khi nước nguội, các hình vẽ này trở lại như hình dáng ban đầu.  - Kích thước: 10.7 x 8.8 x 12 cm- Chất liệu: sứ cao cấp- Khối lượng: 0.5 kg- Màu: Đen', 3),
(12, 'Ly đổi màu 12 cung hoàng đạ', 139000, 'http://www.winwinshop88.vn/ProductImage/Ly%20doi%20mau%2012%20cung%20hoang%20dao_avatar_1.jpg', '-Chiếc ly trước khi cho nước vào có màu đen với các chi tiết không nổi bật, nhưng sau khi đổi màu thì chắc chắn  người nhận sẽ có một bất ngờ vô cùng thú vị đó.\r\n	- Có được đặc tính lý thú như vậy là do chiếc ly đổi màu được phủ một lớp men cảm biến nhiệt độ, đây là loại men cao cấp đặc biệt nhạy cảm với nhiệt. Do đó bạn sẽ bất ngờ khi thấy nước nóng được rót vô tới đâu thì chiếc ly lại đổi màu tới đó, đồng thời hé lộ ra những thông điệp ý nghĩa.  \r\n	- Được sản xuất hoàn toàn bằng sứ cao cấp, không bị rạn hay mùi hóa chất độc hại nên sản phẩm ly đổi màu được đảm bảo là an toàn tuyệt đối cho người sử dụng.   - Kích thước: 7.7 x 9.2 cm- Chất liệu: sứ cao cấp- Khi đổ nước nóng vào ly, hình vẽ các nấc pin màu xanh sẽ sáng lên theo mực nước; khi nước nguội, các hình vẽ này trở lại màu đen như ban đầu.- Khi đổ nước nóng vào ly, hình vẽ 12 cung hoàng đạo sẽ sáng lên theo mực nước; khi nước nguội, các hình vẽ này trở lại màu đen như ban đầu.  - Kích thước: 10.7 x 8.7 x 12.5 cm- Chất liệu: sứ cao cấp- Khối lượng: 0.5 kg- Màu: Đen', 3),
(13, 'Ly đổi màu I Love You ILY17', 109000, 'http://www.winwinshop88.vn/ProductImage/ILY17-avatar.jpg', 'Thoạt nhìn thì đây chỉ là một chiếc ly sứ bình thường, nhưng khi ly được làm đầy bằng cafe, trà, hay bất cứ loại đồ uống nóng nào đó (khoảng trên 70ºC là được) thì điều kì diệu sẽ xuất hiện ngay trước mắt bạn.Được sản xuất hoàn toàn bằng sứ cao cấp, không bị rạn hay mùi hóa chất độc hại nên sản phẩm ly đổi màu được đảm bảo là an toàn tuyệt đối cho người sử dụng.  - Đường kính: 7.7 cm\r\n	- Kích thước (rộng x cao): 7.7 x 9.2 (cm)\r\n	- Dung tích: 300 ML.', 3),
(14, 'Ly sứ gấu trúc Panda', 179000, 'http://www.winwinshop88.vn/ProductImage/Ly%20su%20gau%20truc%20Panda%20V.2_avatar2.jpg', 'Ly sứ với chất liệu men sứ mịn, màu sắc đẹp và bền bỉ. Chất lượng đảm bảo đẹp hơn hẳn tất cả các loại ly sứ có trên thị trường. Phù hợp với khách hàng cần dòng sản phẩm cao cấp. Mẫu mã thú vị, độc đáo.- Ly dày đẹp và chắc chắn hơn ly thường.\r\n	– Chất liệu: gốm sứ – Cao: 14.5 cm– Đường kính nắp ly: 7.5 cm– Dung tích: 350ml- Chiều dài muỗng inox: 17.5 cm– Màu sắc: TRẮNG– Trọng lượng: 380g * Bộ sản phẩm bao gồm: 1 ly sứ + 1 muỗng inox + 1 hộp đựng.', 3),
(15, 'Ly sứ siêu anh hùng', 149000, 'http://www.winwinshop88.vn/ProductImage/Ly%20su%20sieu%20anh%20hung_avatar.jpg', 'Ly sứ sở hữu thiết kế ngộ nghĩnh, đáng yêu, xứng đáng trở thành lựa chọn lý tưởng dành cho người dùng. Sản phẩm được làm từ chất liệu sứ cao cấp với bề mặt nhẵn mịn, không góc cạnh, đảm bảo an toàn tuyệt đối khi sử dụng. Với chiếc ly xinh xắn này, người dùng cảm thấy thích thú hơn mỗi khi uống nước hoặc uống cà phê.\r\n	- Chất liệu sứ cao cấp- Tạo cảm giác thích thú cho người uống- Thiết kế đáng yêu, ngộ nghĩnh- Kích thước: 6.5 x 15 (cm)- Dung tích: 400-500ML.Bộ sản phẩm bao gồm: 1 ly sứ + 1 hộp đựng.', 3),
(16, 'Hộp nhạc xe ngựa', 219000, 'http://www.winwinshop88.vn/ProductImage/Hop%20nhac%20xe%20ngua%20v3-avatar.jpg', 'Hộp nhạc xe ngựa được thiết kế đơn giản theo phong cách lãng mạn nhưng mang lại cảm giác chắc chắn cho người sử dụng. Sản phẩm phù hợp làm quà tặng, làm vật trang trí xinh xắn nơi bàn trang điểm, thể hiện rõ nét phong cách sang trọng, quý phái cho người sử dụng. Enjoy your life!', 4),
(17, 'Hộp nhạc quay tay mèo Totoro', 149000, 'http://www.winwinshop88.vn/ProductImage/Hop-nhac-quay-tay-meo-Totoro-V.2-avatar.jpg', 'Những chiếc gai nhỏ xíu trên lô được bố trí cực kỳ chính xác trên bề mặt lô. Bạn chỉ cần xoay dây cót thì những lô gai sẽ quay và các đầu gai sẽ gẩy vào từng phím đàn theo đúng nhịp điệu và cung bậc của một bản nhạc, và một bản nhạc đã ngân lên, một thông điệp âm nhạc đã được bạn tái hiện lên theo đúng cảm nận của mình', 4),
(18, 'Hộp nhạc vũ công', 250000, 'http://www.winwinshop88.vn/ProductImage/Hop%20nhac%20vu%20cong%20V5_avatar.jpg', 'Đây là một mẫu hộp nhạc vô cùng thú vị, tập hợp những ưu điểm vốn có của dòng hộp nhạc và thêm những thiết kế độc đáo mới lạ. Dây cót được đặt ở dưới chiếc hộp nhạc, bạn chỉ đơn giản lên dây cót là hộp nhạc có thể hoạt động trơn tru. Bên trong hộp nhạc vũ công này có các ngăn nhỏ để các bạn có thể có các vật dụng trang sức như: nhẫn, bông tai, dây chuyền, mặt dây chuyền,...Khi mở nắp hộp nhạc lên các bạn sẽ thấy 1 cái gương nữa nhé, tha hồ mà ngắm mình trong hộp nhạc', 4),
(19, 'Hộp nhạc piano vũ công', 299000, 'http://www.winwinshop88.vn/ProductImage/hop%20nhac%20piano%20vu%20cong_avatar.jpg', 'Thiết kế của hộp nhạc có hình một cây dương cầm trắng theo phong cách classic, được làm một cách tỉ mỉ đến từng chi tiết để sản phẩm như một chiếc dương cầm thật sự thu nhỏ. Nắp bảo vệ bộ phím đàn và nắp thùng đàn đều có thể mở lên, đóng xuống tùy ý thích, các chi tiết nhỏ từ thanh chống thùng đàn đến giá kê sách đều được làm rất sống động và đẹp như của một cây đàn thật. Đặc biệt, khi hộp nhạc khởi động.\r\n	Điều đặc biết tiếp theo nằm ở chính cô vũ công xinh đẹp được làm bằng sứ, khi đặt cô vũ công này lên thùng đàn trong lúc hộp nhạc đang hoạt động bạn sẽ bất ngờ khi thấy cô vũ công bỗng nhiên hòa mình vào những giai điệu du dương bằng vũ điệu xoay tròn rất riêng của mình cho đến khi nhạc kết thúc. Bí mật nằm ở trong thùng đàn, những động cơ nhỏ hoạt động dưới thùng đàn đã kéo cô vũ công bên trên bằng lực từ của nam châm, tạo nên những vũ điệu ba-lê rất đẹp mắt.', 4),
(20, 'Hộp Nhạc Gỗ Cây Thông Giáng Sinh (Sankyo Japan)', 349000, 'http://www.winwinshop88.vn/ProductImage/Hop-nhac-go-cay-thong-giang-sinh-avatar.jpg', 'Những giai điệu du dương nhẹ nhàng phát ra từ chiếc hộp nhạc gỗ mang đậm chất hoài cổ này sẽ làm cho không gian và cảm xúc của bạn trở nên sâu lắng hơn. \r\n	- Tạm gác bộn bề của cuộc sống hòa mình vào giai điệu trong trẻo của những chiếc đàn sát bên trong chiếc hộp nhạc sẽ khiến cho bạn cảm thấy cuộc sống dễ dàng hơn, hãy dành cho tâm hồn bạn một chút sự lãng mạn dịu dàng và dành riêng cho mình một chút không gian hoài niệm ký ức về ngày xưa đã qua với thứ âm thanh quen thuộc sâu lắng. \r\n	- Sản phẩm còn là một món quà tặng ý nghĩa dành cho người bạn thương yêu khi mà bạn đang muốn tìm kiếm một món quà về tinh thần có giá trị hơn rất nhiều so với vât chất. Ngoài ra với hình dáng độc đáo bạn còn có thể làm một vật trang trí vô cùng độc đáo nữa đấy.', 4),
(21, 'Chuông gió phong thủy', 225000, 'http://vn-test-11.slatic.net/original/65642efc14fd17e1d0ab8c4d161bd46c.jpg_720x720q80.jpg', 'Chuông gió còn được gọi là Phong Linh theo tiếng Hán, được coi là một pháp khí hữu hiệu không thể thiếu trong phong thuỷ. Tuy nhỏ bé nhưng tác dụng của Phong linh là vô cùng kỳ diệu và không thể kể hết được.', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaiquatang`
--
ALTER TABLE `loaiquatang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `quatang`
--
ALTER TABLE `quatang`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `loaiquatang`
--
ALTER TABLE `loaiquatang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `quatang`
--
ALTER TABLE `quatang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
