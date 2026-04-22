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

INSERT INTO Sala (nombre, capacidad) VALUES
('Sala 1', 100),
('Sala 2', 100),
('Sala 3', 100);

INSERT INTO Pelicula (titulo, duracionMin, clasificacion) VALUES
('Avengers', 180, 'PG13'),
('Spiderman', 140, 'PG13'),
('Toy Story', 100, 'G');

INSERT INTO Funcion (idSala, idPelicula, fechaHora, cupoDisponible) VALUES
(1, 1, '2026-04-23 18:00', 100),
(2, 2, '2026-04-23 20:00', 100),
(3, 3, '2026-04-23 22:00', 100);

DECLARE @sala INT = 1;

WHILE @sala <= 3
BEGIN
    DECLARE @fila CHAR(1) = 'A';
    WHILE @fila <= 'J'
    BEGIN
        DECLARE @num INT = 1;
        WHILE @num <= 10
        BEGIN
            INSERT INTO Asiento (idSala, fila, numero)
            VALUES (@sala, @fila, @num);

            SET @num = @num + 1;
        END
        SET @fila = CHAR(ASCII(@fila) + 1);
    END
    SET @sala = @sala + 1;
END;

CREATE INDEX idx_reserva_funcion
ON Reserva(idFuncion, estado);
