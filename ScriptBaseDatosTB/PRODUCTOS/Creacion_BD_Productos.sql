USE [master]
GO
/****** Object:  Database [TB_PRODUCTOS]    Script Date: 2/10/2016 8:38:30 p. m. ******/
CREATE DATABASE [TB_PRODUCTOS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TB_PRODUCTOS', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS2\MSSQL\DATA\TB_PRODUCTOS.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TB_PRODUCTOS_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS2\MSSQL\DATA\TB_PRODUCTOS_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TB_PRODUCTOS] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TB_PRODUCTOS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TB_PRODUCTOS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET ARITHABORT OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [TB_PRODUCTOS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TB_PRODUCTOS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TB_PRODUCTOS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TB_PRODUCTOS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TB_PRODUCTOS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TB_PRODUCTOS] SET  MULTI_USER 
GO
ALTER DATABASE [TB_PRODUCTOS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TB_PRODUCTOS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TB_PRODUCTOS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TB_PRODUCTOS] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [TB_PRODUCTOS]
GO
/****** Object:  User [touresbalon]    Script Date: 2/10/2016 8:38:31 p. m. ******/
CREATE USER [touresbalon] FOR LOGIN [touresbalon] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [touresbalon]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [touresbalon]
GO
USE [TB_PRODUCTOS]
GO
/****** Object:  Sequence [dbo].[SEC_CIUDAD_ID]    Script Date: 2/10/2016 8:38:31 p. m. ******/
CREATE SEQUENCE [dbo].[SEC_CIUDAD_ID] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [TB_PRODUCTOS]
GO
/****** Object:  Sequence [dbo].[SEC_PRODUCTO_ID]    Script Date: 2/10/2016 8:38:31 p. m. ******/
CREATE SEQUENCE [dbo].[SEC_PRODUCTO_ID] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [TB_PRODUCTOS]
GO
/****** Object:  Sequence [dbo].[SEC_TARCIU_ID]    Script Date: 2/10/2016 8:38:31 p. m. ******/
CREATE SEQUENCE [dbo].[SEC_TARCIU_ID] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [TB_PRODUCTOS]
GO
/****** Object:  Sequence [dbo].[SEC_TARESP_ID]    Script Date: 2/10/2016 8:38:31 p. m. ******/
CREATE SEQUENCE [dbo].[SEC_TARESP_ID] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [TB_PRODUCTOS]
GO
/****** Object:  Sequence [dbo].[SEC_TARHOS_ID]    Script Date: 2/10/2016 8:38:31 p. m. ******/
CREATE SEQUENCE [dbo].[SEC_TARHOS_ID] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [TB_PRODUCTOS]
GO
/****** Object:  Sequence [dbo].[SEC_TARTRANS_ID]    Script Date: 2/10/2016 8:38:31 p. m. ******/
CREATE SEQUENCE [dbo].[SEC_TARTRANS_ID] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[CIUDAD]    Script Date: 2/10/2016 8:38:31 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CIUDAD](
	[id_ciudad] [int] NOT NULL,
	[nombre_ciudad] [varchar](40) NULL,
	[pais] [varchar](100) NULL,
	[id_tarifa_ciudad] [int] NULL,
 CONSTRAINT [PK_CIUDAD] PRIMARY KEY CLUSTERED 
(
	[id_ciudad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PRODUCTO]    Script Date: 2/10/2016 8:38:31 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PRODUCTO](
	[id_producto] [int] NOT NULL,
	[espectaculo] [varchar](100) NULL,
	[descripcion] [varchar](max) NULL,
	[id_espectaculo] [int] NULL,
	[id_transporte] [int] NULL,
	[id_hospedaje] [int] NULL,
	[id_ciudad] [int] NULL,
	[fecha_salida] [datetime] NULL,
	[fecha_llegada] [datetime] NULL,
	[fecha_espectaculo] [datetime] NULL,
	[url_imagen] [varchar](1000) NULL,
 CONSTRAINT [PK_PRODUCTO] PRIMARY KEY CLUSTERED 
(
	[id_producto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TARIFA_CIUDAD]    Script Date: 2/10/2016 8:38:31 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TARIFA_CIUDAD](
	[id_tarifa_ciudad] [int] NOT NULL,
	[tipo_ciudad] [varchar](50) NULL,
	[precio] [decimal](9, 2) NULL,
 CONSTRAINT [PK_TARIFA_CIUDAD] PRIMARY KEY CLUSTERED 
(
	[id_tarifa_ciudad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tarifa_espectaculo]    Script Date: 2/10/2016 8:38:31 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tarifa_espectaculo](
	[id_espectaculo] [int] NOT NULL,
	[nombre_espectaculo] [varchar](4000) NULL,
	[precio] [decimal](9, 2) NULL,
 CONSTRAINT [PK_Tarifa_espectaculo] PRIMARY KEY CLUSTERED 
(
	[id_espectaculo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tarifa_hospedaje]    Script Date: 2/10/2016 8:38:31 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tarifa_hospedaje](
	[id_hospedaje] [int] NOT NULL,
	[nombre_hospedaje] [varchar](4000) NULL,
	[precio] [decimal](9, 2) NULL,
 CONSTRAINT [PK_Tarifa_hospedaje] PRIMARY KEY CLUSTERED 
(
	[id_hospedaje] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tarifa_transporte]    Script Date: 2/10/2016 8:38:31 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tarifa_transporte](
	[id_transporte] [int] NOT NULL,
	[nombre_transporte] [varchar](4000) NULL,
	[precio] [decimal](9, 2) NULL,
 CONSTRAINT [PK_tarifa_transporte] PRIMARY KEY CLUSTERED 
(
	[id_transporte] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[CIUDAD]  WITH CHECK ADD  CONSTRAINT [FK_CIUDAD_TARIFA_CIUDAD] FOREIGN KEY([id_tarifa_ciudad])
REFERENCES [dbo].[TARIFA_CIUDAD] ([id_tarifa_ciudad])
GO
ALTER TABLE [dbo].[CIUDAD] CHECK CONSTRAINT [FK_CIUDAD_TARIFA_CIUDAD]
GO
ALTER TABLE [dbo].[PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCTO_CIUDAD] FOREIGN KEY([id_ciudad])
REFERENCES [dbo].[CIUDAD] ([id_ciudad])
GO
ALTER TABLE [dbo].[PRODUCTO] CHECK CONSTRAINT [FK_PRODUCTO_CIUDAD]
GO
ALTER TABLE [dbo].[PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCTO_Tarifa_espectaculo] FOREIGN KEY([id_espectaculo])
REFERENCES [dbo].[Tarifa_espectaculo] ([id_espectaculo])
GO
ALTER TABLE [dbo].[PRODUCTO] CHECK CONSTRAINT [FK_PRODUCTO_Tarifa_espectaculo]
GO
ALTER TABLE [dbo].[PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCTO_Tarifa_hospedaje] FOREIGN KEY([id_hospedaje])
REFERENCES [dbo].[Tarifa_hospedaje] ([id_hospedaje])
GO
ALTER TABLE [dbo].[PRODUCTO] CHECK CONSTRAINT [FK_PRODUCTO_Tarifa_hospedaje]
GO
ALTER TABLE [dbo].[PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCTO_tarifa_transporte] FOREIGN KEY([id_transporte])
REFERENCES [dbo].[tarifa_transporte] ([id_transporte])
GO
ALTER TABLE [dbo].[PRODUCTO] CHECK CONSTRAINT [FK_PRODUCTO_tarifa_transporte]
GO
USE [master]
GO
ALTER DATABASE [TB_PRODUCTOS] SET  READ_WRITE 
GO
