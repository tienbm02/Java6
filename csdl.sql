USE [master]
GO
/****** Object:  Database [BMT_J6]    Script Date: 8/4/2023 2:02:18 PM ******/
CREATE DATABASE [BMT_J6]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BMT_J6', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\BMT_J6.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BMT_J6_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\BMT_J6_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BMT_J6] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BMT_J6].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BMT_J6] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BMT_J6] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BMT_J6] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BMT_J6] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BMT_J6] SET ARITHABORT OFF 
GO
ALTER DATABASE [BMT_J6] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [BMT_J6] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BMT_J6] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BMT_J6] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BMT_J6] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BMT_J6] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BMT_J6] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BMT_J6] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BMT_J6] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BMT_J6] SET ENABLE_BROKER 
GO
ALTER DATABASE [BMT_J6] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BMT_J6] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BMT_J6] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BMT_J6] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BMT_J6] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BMT_J6] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BMT_J6] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BMT_J6] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BMT_J6] SET  MULTI_USER 
GO
ALTER DATABASE [BMT_J6] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BMT_J6] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BMT_J6] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BMT_J6] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BMT_J6] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BMT_J6] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BMT_J6] SET QUERY_STORE = OFF
GO
USE [BMT_J6]
GO
/****** Object:  Table [dbo].[Authorities]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Authorities](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[roleId] [varchar](10) NULL,
 CONSTRAINT [PK_Authorities] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDonHang]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonHang](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDDonHang] [int] NULL,
	[IDSP] [int] NULL,
	[TenSP] [nvarchar](150) NULL,
	[Gia] [float] NULL,
	[SL] [int] NULL,
	[ThanhTien] [float] NULL,
	[Hinh] [nvarchar](200) NULL,
 CONSTRAINT [PK_ChiTietDonHang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[IDDonHang] [int] IDENTITY(1,1000) NOT NULL,
	[Username] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](200) NULL,
	[Ngay] [date] NULL,
	[Gia] [float] NULL,
	[PhiVanChuyen] [float] NULL,
	[TongTien] [float] NULL,
 CONSTRAINT [PK_DonHang_1] PRIMARY KEY CLUSTERED 
(
	[IDDonHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DSSP]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DSSP](
	[IDSP] [int] IDENTITY(1,1) NOT NULL,
	[TenSP] [nvarchar](150) NULL,
	[IDthuongHieu] [int] NULL,
	[IDgioiTinh] [int] NULL,
	[IDSize] [int] NULL,
	[Gia] [float] NULL,
	[ChatLieu] [nvarchar](150) NULL,
	[Mau] [nvarchar](100) NULL,
	[MoTa] [nvarchar](200) NULL,
	[Hinh1] [nvarchar](250) NULL,
	[Hinh2] [nvarchar](250) NULL,
	[Hinh3] [nvarchar](250) NULL,
	[Hinh4] [nvarchar](250) NULL,
 CONSTRAINT [PK_DS_SP_1] PRIMARY KEY CLUSTERED 
(
	[IDSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioiTinh]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioiTinh](
	[IDGT] [int] NOT NULL,
	[GioiTinh] [nchar](10) NULL,
 CONSTRAINT [PK_Gioi_Tinh_1] PRIMARY KEY CLUSTERED 
(
	[IDGT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[Id] [varchar](10) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[IDSize] [int] NOT NULL,
	[Size] [int] NULL,
 CONSTRAINT [PK_Size] PRIMARY KEY CLUSTERED 
(
	[IDSize] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NULL,
	[Admin] [bit] NULL,
	[Hovaten] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[gmail] [nvarchar](50) NULL,
	[Diachi] [nvarchar](max) NULL,
	[Hinh] [nvarchar](max) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 8/4/2023 2:02:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[IDTH] [int] NOT NULL,
	[ThuongHieu] [nvarchar](50) NULL,
 CONSTRAINT [PK_Thuong_Hieu_1] PRIMARY KEY CLUSTERED 
(
	[IDTH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Authorities] ON 

INSERT [dbo].[Authorities] ([Id], [username], [roleId]) VALUES (1, N'tien01', N'USER')
INSERT [dbo].[Authorities] ([Id], [username], [roleId]) VALUES (2, N'tien02', N'GUEST')
INSERT [dbo].[Authorities] ([Id], [username], [roleId]) VALUES (3, N'tienbm', N'ADMIN')
INSERT [dbo].[Authorities] ([Id], [username], [roleId]) VALUES (4, N'tienbm02', N'ADMIN')
INSERT [dbo].[Authorities] ([Id], [username], [roleId]) VALUES (5, N'thaontn', 'USER')
INSERT [dbo].[Authorities] ([Id], [username], [roleId]) VALUES (6, N'tuanlv', 'USER')
INSERT [dbo].[Authorities] ([Id], [username], [roleId]) VALUES (7, N'hainv', 'USER')
INSERT [dbo].[Authorities] ([Id], [username], [roleId]) VALUES (5, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Authorities] OFF
GO
SET IDENTITY_INSERT [dbo].[ChiTietDonHang] ON 

INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (1, 1, 5, N'VANS UA OLD SKOOL 36 DX ANAHEIM FACTORY', 12000, 1, 12000, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (20, 28001, NULL, NULL, 10000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (21, 28001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (22, 28001, NULL, NULL, 13000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (23, 30001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (24, 30001, NULL, NULL, 10000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (25, 30001, NULL, NULL, 13000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (26, 31001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (27, 32001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (28, 32001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (29, 33001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (30, 33001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (31, 34001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (32, 34001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (33, 35001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (34, 35001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (35, 36001, NULL, NULL, 10000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (36, 36001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (37, 38001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (38, 38001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (39, 45001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (40, 45001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (41, 45001, NULL, NULL, 5000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (42, 46001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (43, 46001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (44, 46001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (45, 49001, NULL, NULL, 10000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (46, 49001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (47, 50001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (48, 50001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (49, 50001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (50, 51001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (51, 51001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (52, 52001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (53, 52001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (54, 53001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (55, 53001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (56, 55001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (57, 55001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (58, 56001, NULL, NULL, 15000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (59, 56001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (60, 57001, NULL, NULL, 5000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (61, 58001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (62, 58001, NULL, NULL, 13000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (63, 59001, NULL, NULL, 10000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (64, 59001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (65, 60001, NULL, NULL, 5000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (66, 60001, NULL, NULL, 11000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (67, 61001, NULL, NULL, 10000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (68, 61001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (69, 62001, NULL, NULL, 12000, 1, NULL, NULL)
INSERT [dbo].[ChiTietDonHang] ([ID], [IDDonHang], [IDSP], [TenSP], [Gia], [SL], [ThanhTien], [Hinh]) VALUES (70, 62001, NULL, NULL, 10000, 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[ChiTietDonHang] OFF
GO
SET IDENTITY_INSERT [dbo].[DonHang] ON 

INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (1, N'tien01', N'0907416635', N'cần thơ', CAST(N'2022-01-01' AS Date), 120000, 120000, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (27001, NULL, NULL, N'', CAST(N'2022-08-13' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (28001, NULL, NULL, N'cần thơ', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (29001, NULL, NULL, N'', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (30001, NULL, NULL, N'tp hcm', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (31001, NULL, NULL, N'', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (32001, NULL, NULL, N'', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (33001, NULL, NULL, N'cần thơ', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (34001, NULL, NULL, N'', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (35001, NULL, NULL, N'', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (36001, NULL, NULL, N'sadasdsadas', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (37001, NULL, NULL, N'', CAST(N'2022-08-14' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (38001, NULL, NULL, N'', CAST(N'2022-08-15' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (45001, N'tien02', NULL, N'', CAST(N'2022-08-15' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (46001, N'tien02', NULL, N'', CAST(N'2022-08-15' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (49001, N'tien02', NULL, N'', CAST(N'2022-08-15' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (50001, N'tien02', NULL, N'', CAST(N'2022-08-15' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (51001, N'tien02', NULL, N'', CAST(N'2022-08-15' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (52001, N'tien02', N'', N'', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (53001, N'tien02', NULL, N'cần thơ', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (54001, N'tien02', N'09213912321', N'đasada', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (55001, N'tien01', N'', N'', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (56001, N'tien01', N'0907416635', N'cần thơ', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (57001, N'tien01', N'01902121', N'cần thơ', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (58001, N'tien01', N'093912321', N'cần thơ', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (59001, N'tien01', N'', N'', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (60001, N'tien01', N'0939213123', N'cần thơ', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (61001, N'tien01', N'21321321', N'cần thơ', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([IDDonHang], [Username], [SDT], [DiaChi], [Ngay], [Gia], [PhiVanChuyen], [TongTien]) VALUES (62001, N'tien01', N'0392139213', N'cần thơ', CAST(N'2022-08-16' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[DonHang] OFF
GO
SET IDENTITY_INSERT [dbo].[DSSP] ON 

INSERT [dbo].[DSSP] ([IDSP], [TenSP], [IDthuongHieu], [IDgioiTinh], [IDSize], [Gia], [ChatLieu], [Mau], [MoTa], [Hinh1], [Hinh2], [Hinh3], [Hinh4]) VALUES (5, N'VANS UA OLD SKOOL 36 DX ANAHEIM FACTORY', 4, 1, 6, 12000, N'Chất liệu Suede được gia công ở phần mũi và gót giày', N'Classic White', N'Đệm lót bên trong êm ái
Phần bo thun ở phần cổ giày giúp người mang thoải mái hơn', N'vans.jpg', NULL, NULL, NULL)
INSERT [dbo].[DSSP] ([IDSP], [TenSP], [IDthuongHieu], [IDgioiTinh], [IDSize], [Gia], [ChatLieu], [Mau], [MoTa], [Hinh1], [Hinh2], [Hinh3], [Hinh4]) VALUES (6, N'VANS UA CLASSIC SLIP-ON CUSTOM CULTURE', 4, 1, 6, 11000, N'Chất liệu Canvas được in họa tiết với công nghệ cao', N'Nikko/Black/True White', NULL, N'vans1.jpg', NULL, NULL, NULL)
INSERT [dbo].[DSSP] ([IDSP], [TenSP], [IDthuongHieu], [IDgioiTinh], [IDSize], [Gia], [ChatLieu], [Mau], [MoTa], [Hinh1], [Hinh2], [Hinh3], [Hinh4]) VALUES (9, N'VANS UA OLD SKOOL STYLE 36 MARSHMALLOW JOLLY GREEN', 4, 1, 6, 15000, N'Chất liệu Leather và Textile mang lại trải nghiệm tốt hơn', N'Marshmallow / Jolly Green', N'Mặt đế Waffle đặc trưng tạo độ bám và hạn chế trơn trượt
Tem Logo thương hiệu màu đỏ đặc trưng sau gót
Thiết kế vừa vặn phù hợp cho mọi đôi chân', N'vans2.jpg', NULL, NULL, NULL)
INSERT [dbo].[DSSP] ([IDSP], [TenSP], [IDthuongHieu], [IDgioiTinh], [IDSize], [Gia], [ChatLieu], [Mau], [MoTa], [Hinh1], [Hinh2], [Hinh3], [Hinh4]) VALUES (10, N'VANS UA OLD SKOOL STYLE 36 SE BIKES', 4, 1, 6, 13000, N'Đế giày cao su bền bỉ, chắc chắn
Đệm lót bên trong êm ái với độ đàn hồi và chịu lực tốt', N'Blocks Flyer/white/reflective', N'Mặt đế vân Waffle đặc trưng tạo độ bám, tăng ma sát và giảm trơn trượt hiệu quả', N'vans3.jpg', NULL, NULL, NULL)
INSERT [dbo].[DSSP] ([IDSP], [TenSP], [IDthuongHieu], [IDgioiTinh], [IDSize], [Gia], [ChatLieu], [Mau], [MoTa], [Hinh1], [Hinh2], [Hinh3], [Hinh4]) VALUES (11, N'VANS UA CLASSIC SLIP-ON DENNIS ENARSON BMX', 4, 1, 6, 12000, N'Đế giày Gum màu đen cook ngầu, dễ dàng vệ sinh', N'Pewter/black', N'Họa tiết được chạm khắc âm sắc sau gót chân của đôi giày với thông điệp “hòa bình, tình yêu, sự tích cực”. ', N'vans4.jpg', NULL, NULL, NULL)
INSERT [dbo].[DSSP] ([IDSP], [TenSP], [IDthuongHieu], [IDgioiTinh], [IDSize], [Gia], [ChatLieu], [Mau], [MoTa], [Hinh1], [Hinh2], [Hinh3], [Hinh4]) VALUES (12, N'VANS UA OLD SKOOL CLASSIC SPORT POP', 4, 1, 6, 10000, N'Đế giày sử dụng công nghệ cao su lưu hóa hiện đại.', N'vallarta blue/red', N'Các khoen xỏ giày kim loại mang tính bền bỉ.
Dễ dàng nhận diện thương hiệu qua tem logo và tape.', N'vans5.jpg', NULL, NULL, NULL)
INSERT [dbo].[DSSP] ([IDSP], [TenSP], [IDthuongHieu], [IDgioiTinh], [IDSize], [Gia], [ChatLieu], [Mau], [MoTa], [Hinh1], [Hinh2], [Hinh3], [Hinh4]) VALUES (13, N'VANS UA OLD SKOOL STYLE 36 MARSHMALLOW JOLLY GREEN', 4, 1, 6, 5000, N'Chất liệu Leather và Textile mang lại trải nghiệm tốt hơn', N'Marshmallow / Jolly Green', N'Mặt đế Waffle đặc trưng tạo độ bám và hạn chế trơn trượt
Tem Logo thương hiệu màu đỏ đặc trưng sau gót
Thiết kế vừa vặn phù hợp cho mọi đôi chân', N'vans6.jpg', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[DSSP] OFF
GO
INSERT [dbo].[GioiTinh] ([IDGT], [GioiTinh]) VALUES (0, N'Nữ        ')
INSERT [dbo].[GioiTinh] ([IDGT], [GioiTinh]) VALUES (1, N'Nam       ')
INSERT [dbo].[GioiTinh] ([IDGT], [GioiTinh]) VALUES (3, N'Unisex    ')
GO
INSERT [dbo].[Roles] ([Id], [name]) VALUES (N'ADMIN', N'Administators')
INSERT [dbo].[Roles] ([Id], [name]) VALUES (N'GUEST', N'Guest')
INSERT [dbo].[Roles] ([Id], [name]) VALUES (N'USER', N'Users')
GO
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (1, 36)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (2, 37)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (3, 38)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (4, 39)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (5, 40)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (6, 41)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (7, 42)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (8, 43)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (9, 44)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (10, 45)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (11, 46)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (12, 47)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (13, NULL)
INSERT [dbo].[Size] ([IDSize], [Size]) VALUES (14, NULL)
GO
INSERT [dbo].[TaiKhoan] ([Username], [Password], [Admin], [Hovaten], [SDT], [gmail], [Diachi], [Hinh]) VALUES (N'tien01', N'1234', 1, N'Mạnh Tiến 1', N'0344563469', N'tien01@gmail', N'Ninh Thuận', N'null')
INSERT [dbo].[TaiKhoan] ([Username], [Password], [Admin], [Hovaten], [SDT], [gmail], [Diachi], [Hinh]) VALUES (N'tien02', N'1234', 0, N'Mạnh Tiến 2', N'0397656566', NULL, N'cần Thơ', N'null')
INSERT [dbo].[TaiKhoan] ([Username], [Password], [Admin], [Hovaten], [SDT], [gmail], [Diachi], [Hinh]) VALUES (N'tienbm', N'admin', 0, N'Bùi Mạnh Tiến', N'0976805602', NULL, N'Bình Thuận', NULL)
INSERT [dbo].[TaiKhoan] ([Username], [Password], [Admin], [Hovaten], [SDT], [gmail], [Diachi], [Hinh]) VALUES (N'tienbm02', N'1234', 1, N'Tiến Bùi', N'0255365689', NULL, N'TP. HCM', NULL)
INSERT [dbo].[TaiKhoan] ([Username], [Password], [Admin], [Hovaten], [SDT], [gmail], [Diachi], [Hinh]) VALUES (N'thaontn', N'1234', 1, N'Nguyễn Thị Ngọc Thảo', N'0255365689', NULL, N'Kiên Giang', NULL)
INSERT [dbo].[TaiKhoan] ([Username], [Password], [Admin], [Hovaten], [SDT], [gmail], [Diachi], [Hinh]) VALUES (N'tuanlv', N'1234', 1, N'Lê Văn Tuấn', N'0868648814', NULL, N'Tiền Giang', NULL)
INSERT [dbo].[TaiKhoan] ([Username], [Password], [Admin], [Hovaten], [SDT], [gmail], [Diachi], [Hinh]) VALUES (N'hainv', N'1234', 1, N'Nguyễn Văn Hải', N'0393404520', NULL, N'Đà Lạt', NULL)
GO
INSERT [dbo].[ThuongHieu] ([IDTH], [ThuongHieu]) VALUES (1, N'Adidas')
INSERT [dbo].[ThuongHieu] ([IDTH], [ThuongHieu]) VALUES (2, N'Puma')
INSERT [dbo].[ThuongHieu] ([IDTH], [ThuongHieu]) VALUES (3, N'Nike')
INSERT [dbo].[ThuongHieu] ([IDTH], [ThuongHieu]) VALUES (4, N'Vans')
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [FK_Authorities_Roles] FOREIGN KEY([roleId])
REFERENCES [dbo].[Roles] ([Id])
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [FK_Authorities_Roles]
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [FK_Authorities_TaiKhoan] FOREIGN KEY([username])
REFERENCES [dbo].[TaiKhoan] ([Username])
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [FK_Authorities_TaiKhoan]
GO
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonHang_DonHang] FOREIGN KEY([IDDonHang])
REFERENCES [dbo].[DonHang] ([IDDonHang])
GO
ALTER TABLE [dbo].[ChiTietDonHang] CHECK CONSTRAINT [FK_ChiTietDonHang_DonHang]
GO
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonHang_DSSP1] FOREIGN KEY([IDSP])
REFERENCES [dbo].[DSSP] ([IDSP])
GO
ALTER TABLE [dbo].[ChiTietDonHang] CHECK CONSTRAINT [FK_ChiTietDonHang_DSSP1]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_TaiKhoan] FOREIGN KEY([Username])
REFERENCES [dbo].[TaiKhoan] ([Username])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_TaiKhoan]
GO
ALTER TABLE [dbo].[DSSP]  WITH CHECK ADD  CONSTRAINT [FK_DS_SP_Gioi_Tinh] FOREIGN KEY([IDgioiTinh])
REFERENCES [dbo].[GioiTinh] ([IDGT])
GO
ALTER TABLE [dbo].[DSSP] CHECK CONSTRAINT [FK_DS_SP_Gioi_Tinh]
GO
ALTER TABLE [dbo].[DSSP]  WITH CHECK ADD  CONSTRAINT [FK_DS_SP_Size] FOREIGN KEY([IDSize])
REFERENCES [dbo].[Size] ([IDSize])
GO
ALTER TABLE [dbo].[DSSP] CHECK CONSTRAINT [FK_DS_SP_Size]
GO
ALTER TABLE [dbo].[DSSP]  WITH CHECK ADD  CONSTRAINT [FK_DS_SP_Thuong_Hieu] FOREIGN KEY([IDthuongHieu])
REFERENCES [dbo].[ThuongHieu] ([IDTH])
GO
ALTER TABLE [dbo].[DSSP] CHECK CONSTRAINT [FK_DS_SP_Thuong_Hieu]
GO
USE [master]
GO
ALTER DATABASE [BMT_J6] SET  READ_WRITE 
GO
