﻿CREATE TABLE [dbo].[PRODUCTOS] (
    [ID]                 NUMERIC (18)   IDENTITY (1, 1) NOT NULL,
    [ESPECTACULO]        NVARCHAR (MAX) NULL,
    [FECHA_ESPECTACULO]  DATE           NULL,
    [CIUDAD_ESPECTACULO] NVARCHAR (50) NULL,
    [FECHA_LEGADA]       DATE           NULL,
    [FECHA_SALIDA]       DATE           NULL,
    [TIPO_TRANSPORTE]    NUMERIC (18)   NULL,
    [TIPO_ESPECTACULO]   NUMERIC (18)   NULL,
    [TIPO_HOSPEDAJE]     NUMERIC (18)   NULL,
    PRIMARY KEY CLUSTERED ([ID] ASC),
    CONSTRAINT [FK_PRODUCTOS_TARIFA_HOSPEDAJE] FOREIGN KEY ([TIPO_HOSPEDAJE]) REFERENCES [dbo].[TARIFA_HOSPEDAJE] ([ID]),
	CONSTRAINT [FK_PRODUCTOS_TARIFA_ESPECTACULO] FOREIGN KEY ([TIPO_ESPECTACULO]) REFERENCES [dbo].[TARIFA_ESPECTACULO] ([ID]),
	CONSTRAINT [FK_PRODUCTOS_CIUDAD] FOREIGN KEY ([CIUDAD_ESPECTACULO]) REFERENCES [dbo].[CIUDAD] ([ID_CIUDAD])
);

