CREATE DATABASE QuanLyQuanCafe
GO
USE QuanLyQuanCafe
GO

CREATE TABLE Ban
(
	MaBan INT IDENTITY(1,1) PRIMARY KEY,
	TenBan NVARCHAR(100) NOT NULL UNIQUE,
	TrangThai NVARCHAR(100) NOT NULL DEFAULT N'Trống'	
)
GO

CREATE TABLE TaiKhoan
(
	TenDangNhap NVARCHAR(100) PRIMARY KEY,	
	TenHienThi NVARCHAR(100) NOT NULL DEFAULT N'Người dùng',
	MatKhau NVARCHAR(100) NOT NULL DEFAULT 0,
	Type INT NOT NULL  DEFAULT 0 -- 1: admin && 0: staff
)
GO

CREATE TABLE Loai
(
	MaLoai INT IDENTITY(1,1) PRIMARY KEY,
	TenLoai NVARCHAR(100) NOT NULL UNIQUE
)
GO

CREATE TABLE ThucUong
(
	MaThucUong INT IDENTITY(1,1) PRIMARY KEY,
	TenThucUong NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên',
	MaLoai INT NOT NULL,
	Gia bigint NOT NULL DEFAULT 0,
	FOREIGN KEY (MaLoai) REFERENCES Loai(MaLoai) on delete cascade
)
GO

CREATE TABLE HoaDon
(
	MaHoaDon INT IDENTITY(1,1) PRIMARY KEY,
	ThoiGianVao DATE NOT NULL DEFAULT GETDATE(),
	ThoiGianRa DATE,
	MaBan INT NOT NULL,
	TrangThai BIT NOT NULL DEFAULT 0, -- 1: đã thanh toán && 0: chưa thanh toán
	FOREIGN KEY (MaBan) REFERENCES Ban(MaBan) on delete cascade
)
GO

CREATE TABLE ChiTietHoaDon
(
	id INT IDENTITY PRIMARY KEY,
	MaHoaDon INT NOT NULL,
	MaThucUong INT NOT NULL,
	SoLuong INT NOT NULL DEFAULT 0,
	FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon) on delete cascade,
	FOREIGN KEY (MaThucUong) REFERENCES ThucUong(MaThucUong) on delete cascade
)
GO

-- Chèn dữ liệu cho bảng "Ban"
INSERT INTO Ban (TenBan, TrangThai)
VALUES (N'Bàn 1', N'Trống'),
       (N'Bàn 2', N'Trống'),
       (N'Bàn 3', N'Có người'),
       (N'Bàn 4', N'Trống'),
       (N'Bàn 5', N'Có người');

-- Chèn dữ liệu cho bảng "TaiKhoan"
INSERT INTO TaiKhoan (TenDangNhap, TenHienThi, MatKhau, Type)
VALUES (N'admin', N'Quản trị viên', N'123', 1),
       (N'nhanvien', N'Nhân viên', N'123', 0);

-- Chèn dữ liệu cho bảng "Loai"
INSERT INTO Loai (TenLoai)
VALUES (N'Trà sữa'),
       (N'Cà phê'),
       (N'Sinh tố'),
       (N'Nước uống lạnh');

-- Chèn dữ liệu cho bảng "ThucUong"
INSERT INTO ThucUong (TenThucUong, MaLoai, Gia)
VALUES (N'Capuchino', 2, 35000),
       (N'Trà đào', 1, 25000),
       (N'Espresso', 2, 32000),
       (N'Sinh tố dâu', 3, 30000),
       (N'Caramel Macchiato', 2, 38000),
       (N'Trà bí đao', 1, 27000),
       (N'Cà phê sữa đá', 2, 30000),
       (N'Sinh tố bơ', 3, 29000),
       (N'Latte', 2, 36000),
       (N'Sinh tố xoài', 3, 28000);
