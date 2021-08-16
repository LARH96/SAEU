--drop database SAEU2;

CREATE DATABASE SAEU2
GO
USE SAEU2;

CREATE TABLE ActividadDeportiva
(
	id int IDENTITY(1,1) NOT NULL,
	idPlanEntrenamiento int NOT NULL,
	nombre nvarchar(50) NOT NULL,
	explicacion nvarchar(100) NOT NULL,
	duracion time(7) NOT NULL,
	cantidadRepeticiones int NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);

ALTER TABLE ActividadDeportiva ADD CONSTRAINT PK_ActividadDeportiva PRIMARY KEY (id);

CREATE TABLE AsignDeportistaPorInstructor
(
	idInstructor char(9) NOT NULL,
	idDeportista char(9) NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);

ALTER TABLE AsignDeportistaPorInstructor ADD CONSTRAINT PK_AsignDeportistaPorInstructor PRIMARY KEY (idInstructor,idDeportista);

CREATE TABLE Barrio
(
	COD_PROVINCIA numeric(1, 0) NOT NULL,
	COD_CANTON numeric(2, 0) NOT NULL,
	COD_DISTRITO numeric(3, 0) NOT NULL,
	COD_BARRIO numeric(4, 0) NOT NULL,
	DSC_BARRIO nvarchar(255) NULL,
	LOG_ACTIVO numeric(1, 0) NULL,
);

ALTER TABLE Barrio ADD CONSTRAINT PK_Barrio PRIMARY KEY (COD_PROVINCIA,COD_CANTON,COD_DISTRITO,COD_BARRIO);

CREATE TABLE Canton
(
	COD_PROVINCIA numeric(1, 0) NOT NULL,
	COD_CANTON numeric(2, 0) NOT NULL,
	DSC_CANTON nvarchar(255) NULL,
	LOG_ACTIVO numeric(1, 0) NULL,
);

ALTER TABLE Canton ADD CONSTRAINT PK_Canton PRIMARY KEY (COD_PROVINCIA,COD_CANTON);

CREATE TABLE Contrasenna
(
	idUsuario char(9) NOT NULL,
	actual varchar(20) NOT NULL,
	anterior varchar(20) NULL,
	trasanterior varchar(20) NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);

ALTER TABLE Contrasenna ADD CONSTRAINT PK_Contrasenna PRIMARY KEY (idUsuario);

CREATE TABLE CumplimActivDeportiva
(
	id int NOT NULL,
	fecha datetime NOT NULL,
	cantidadRepeticiones int NOT NULL,
	duracion time(7) NOT NULL,
	observacion varchar(50) NULL,
	observacionInstructor nchar(10) NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);

ALTER TABLE CumplimActivDeportiva ADD CONSTRAINT PK_CumplimActivDeportiva PRIMARY KEY (id);

CREATE TABLE Deportista
(
	id char(9) NOT NULL,
	idTipoIdentificacion char(1) NOT NULL,
	nombre nvarchar(20) NOT NULL,
	apellido1 nvarchar(20) NOT NULL,
	apellido2 nvarchar(20) NOT NULL,
	correoElectronico varchar(320) NOT NULL,
	idDisciplinaDeportiva varchar(2) NOT NULL,
	peso float NOT NULL,
	talla varchar(2) NOT NULL,
	altura float NOT NULL,
	objetivoDeporte1 varchar(50) NOT NULL,
	objetivoDeporte2 varchar(50) NULL,
	objetivoDeporte3 varchar(50) NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL,
	pago bit NOT NULL
);

ALTER TABLE Deportista ADD CONSTRAINT PK_Deportista PRIMARY KEY (id);

CREATE TABLE Direccion
(
	id char(9) NOT NULL,
	idProvincia numeric(1, 0) NOT NULL,
	idCanton numeric(2, 0) NOT NULL,
	idDistrito numeric(3, 0) NOT NULL,
	idBarrio numeric(4, 0) NOT NULL,
	OtrasSennas varchar(100) NOT NULL
);

ALTER TABLE Direccion ADD CONSTRAINT PK_Direccion PRIMARY KEY (id); 

CREATE TABLE DisciplinaDeportiva
(
	id varchar(2) NOT NULL,
	descripcion varchar(30) NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);

ALTER TABLE DisciplinaDeportiva ADD CONSTRAINT PK_DisciplinaDeportiva PRIMARY KEY (id);

CREATE TABLE Distrito
(
	COD_PROVINCIA numeric(1, 0) NOT NULL,
	COD_CANTON numeric(2, 0) NOT NULL,
	COD_DISTRITO numeric(3, 0) NOT NULL,
	DSC_DISTRITO nvarchar(255) NULL,
	LOG_ACTIVO numeric(1, 0) NULL
);

ALTER TABLE Distrito ADD CONSTRAINT PK_Distrito PRIMARY KEY (COD_PROVINCIA,COD_CANTON,COD_DISTRITO);

CREATE TABLE Instructor
(
	id char(9) NOT NULL,
	idTipoIdentificacion char(1) NOT NULL,
	nombre nvarchar(20) NOT NULL,
	apellido1 nvarchar(20) NOT NULL,
	apellido2 nvarchar(20) NOT NULL,
	correoElectronico varchar(320) NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);
 
ALTER TABLE Instructor ADD CONSTRAINT PK_Instructor PRIMARY KEY (id);

CREATE TABLE InstructorDisciplinaDeportiva
(
	idInstructor char(9) NOT NULL,
	idDisciplinaDeportiva varchar(2) NOT NULL,
	id int IDENTITY(1,1) NOT NULL
);

ALTER TABLE InstructorDisciplinaDeportiva ADD CONSTRAINT PK_InstructorDisciplinaDeportiva PRIMARY KEY
(idInstructor, idDisciplinaDeportiva, id);

CREATE TABLE Periodicidad
(
	id char(1) NOT NULL,
	descripcion varchar(20) NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);
ALTER TABLE Periodicidad ADD CONSTRAINT PK_Periodicidad PRIMARY KEY (id);

CREATE TABLE PlanEntrenamiento
(
	id int IDENTITY(1,1) NOT NULL,
	idPeriodicidad char(1) NOT NULL,
	fechaInicio datetime NOT NULL,
	fechaFinal datetime NOT NULL,
	idDeportista char(9) NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);
ALTER TABLE PlanEntrenamiento ADD CONSTRAINT PK_PlanEntrenamiento PRIMARY KEY (id)

CREATE TABLE Provincia
(
	COD_PROVINCIA numeric(1, 0) NOT NULL,
	DSC_CORTA_PROVINCIA nvarchar(255) NULL,
	DSC_PROVINCIA nvarchar(255) NULL,
	LOG_ACTIVO numeric(1, 0) NULL
);
ALTER TABLE Provincia ADD CONSTRAINT PK_Provincia PRIMARY KEY (COD_PROVINCIA);

CREATE TABLE Telefono
(
	id char(9) NOT NULL,
	numero int NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);
ALTER TABLE Telefono ADD CONSTRAINT PK_Telefono PRIMARY KEY (id);

CREATE TABLE TipoIdentificacion
(
	id char(1) NOT NULL,
	descripcion varchar(9) NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);
ALTER TABLE TipoIdentificacion ADD CONSTRAINT PK_TipoIdentificacion PRIMARY KEY (id);

CREATE TABLE TipoUsuario
(
	id char(1) NOT NULL,
	nombre varchar(20) NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
)
ALTER TABLE TipoUsuario ADD CONSTRAINT PK_TipoUsuario PRIMARY KEY (id);

CREATE TABLE Usuario
(
	id char(9) NOT NULL,
	nombre nvarchar(20) NOT NULL,
	idTipoPerfil char(1) NOT NULL,
	log_estado bit NOT NULL,
	codUsuario_Registra char(9) NOT NULL,
	fechaRegistra smalldatetime NOT NULL,
	codUsuario_Edita char(9) NULL,
	fechaEdita smalldatetime NULL
);
ALTER TABLE Usuario ADD CONSTRAINT PK_Usuario PRIMARY KEY (id);

ALTER TABLE ActividadDeportiva ADD CONSTRAINT FK_ActividadDeportiva_CumplimActivDeportiva FOREIGN KEY(id)
REFERENCES CumplimActivDeportiva (id);

ALTER TABLE ActividadDeportiva ADD CONSTRAINT FK_ActividadDeportiva_PlanEntrenamiento FOREIGN KEY(idPlanEntrenamiento)
REFERENCES PlanEntrenamiento (id);

ALTER TABLE AsignDeportistaPorInstructor ADD  CONSTRAINT FK_AsignDeportistaPorInstructor_Deportista FOREIGN KEY(idDeportista)
REFERENCES Deportista (id);

ALTER TABLE AsignDeportistaPorInstructor ADD  CONSTRAINT FK_AsignDeportistaPorInstructor_Instructor FOREIGN KEY(idInstructor)
REFERENCES Instructor (id);

ALTER TABLE Barrio ADD CONSTRAINT FK_Barrio_Distrito FOREIGN KEY(COD_PROVINCIA, COD_CANTON, COD_DISTRITO)
REFERENCES Distrito (COD_PROVINCIA, COD_CANTON, COD_DISTRITO);

ALTER TABLE Canton ADD  CONSTRAINT FK_Canton_Provincia FOREIGN KEY(COD_PROVINCIA)
REFERENCES Provincia (COD_PROVINCIA);

ALTER TABLE Deportista ADD  CONSTRAINT FK_Deportista_Direccion FOREIGN KEY(id)
REFERENCES Direccion (id);

ALTER TABLE Deportista ADD CONSTRAINT FK_Deportista_DisciplinaDeportiva FOREIGN KEY(idDisciplinaDeportiva)
REFERENCES DisciplinaDeportiva (id);

ALTER TABLE Deportista ADD  CONSTRAINT FK_Deportista_TipoIdentificacion FOREIGN KEY(idTipoIdentificacion)
REFERENCES TipoIdentificacion (id);

ALTER TABLE Direccion ADD  CONSTRAINT FK_Direccion_Barrio FOREIGN KEY(idProvincia, idCanton, idDistrito, idBarrio)
REFERENCES Barrio (COD_PROVINCIA, COD_CANTON, COD_DISTRITO, COD_BARRIO)

ALTER TABLE Distrito ADD  CONSTRAINT FK_Distrito_Canton FOREIGN KEY(COD_PROVINCIA, COD_CANTON)
REFERENCES Canton (COD_PROVINCIA, COD_CANTON)

ALTER TABLE Instructor ADD  CONSTRAINT FK_Instructor_Direccion FOREIGN KEY(id)
REFERENCES Direccion (id)

ALTER TABLE Instructor ADD  CONSTRAINT FK_Instructor_TipoIdentificacion FOREIGN KEY(idTipoIdentificacion)
REFERENCES TipoIdentificacion (id)

ALTER TABLE InstructorDisciplinaDeportiva ADD CONSTRAINT FK_InstructorDisciplinaDeportiva_DisciplinaDeportiva FOREIGN KEY(idDisciplinaDeportiva)
REFERENCES DisciplinaDeportiva (id)

ALTER TABLE InstructorDisciplinaDeportiva ADD  CONSTRAINT FK_InstructorDisciplinaDeportiva_Instructor FOREIGN KEY(idInstructor)
REFERENCES Instructor (id)

ALTER TABLE PlanEntrenamiento ADD  CONSTRAINT FK_PlanEntrenamiento_Deportista FOREIGN KEY(idDeportista)
REFERENCES Deportista (id)

ALTER TABLE PlanEntrenamiento ADD  CONSTRAINT FK_PlanEntrenamiento_Periodicidad FOREIGN KEY(idPeriodicidad)
REFERENCES Periodicidad (id)

ALTER TABLE Telefono ADD  CONSTRAINT FK_Telefono_Deportista FOREIGN KEY(id)
REFERENCES Deportista (id)

ALTER TABLE Telefono ADD  CONSTRAINT FK_Telefono_Instructor FOREIGN KEY(id)
REFERENCES Instructor (id)

ALTER TABLE Usuario  ADD  CONSTRAINT FK_Usuario_Contrasenna FOREIGN KEY(id)
REFERENCES Contrasenna (idUsuario)

ALTER TABLE Usuario ADD  CONSTRAINT FK_Usuario_TipoUsuario FOREIGN KEY(idTipoPerfil)
REFERENCES TipoUsuario (id)