CREATE DATABASE CineStarDB;
GO
USE CineStarDB;
GO

CREATE TABLE Sala (
    idSala INT IDENTITY PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    capacidad INT NOT NULL
);

CREATE TABLE Pelicula (
    idPelicula INT IDENTITY PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    duracionMin INT NOT NULL,
    clasificacion VARCHAR(10)
);

CREATE TABLE Funcion (
    idFuncion INT IDENTITY PRIMARY KEY,
    idSala INT NOT NULL,
    idPelicula INT NOT NULL,
    fechaHora DATETIME NOT NULL,
    cupoDisponible INT NOT NULL,
    FOREIGN KEY (idSala) REFERENCES Sala(idSala),
    FOREIGN KEY (idPelicula) REFERENCES Pelicula(idPelicula)
);

CREATE TABLE Asiento (
    idAsiento INT IDENTITY PRIMARY KEY,
    idSala INT NOT NULL,
    fila CHAR(1) NOT NULL,
    numero INT NOT NULL,
    FOREIGN KEY (idSala) REFERENCES Sala(idSala)
);

CREATE TABLE Usuario (
    idUsuario INT IDENTITY PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Reserva (
    idReserva INT IDENTITY PRIMARY KEY,
    idUsuario INT NOT NULL,
    idFuncion INT NOT NULL,
    idAsiento INT NOT NULL,
    fechaReserva DATETIME DEFAULT GETDATE(),
    estado VARCHAR(20) DEFAULT 'ACTIVA',
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idFuncion) REFERENCES Funcion(idFuncion),
    FOREIGN KEY (idAsiento) REFERENCES Asiento(idAsiento),
    CONSTRAINT UQ_Reserva UNIQUE (idFuncion, idAsiento)
);

CREATE TABLE HistorialCancelaciones (
    idCancelacion INT IDENTITY PRIMARY KEY,
    idReserva INT NOT NULL,
    idUsuario INT NOT NULL,
    fechaCancelacion DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (idReserva) REFERENCES Reserva(idReserva),
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);