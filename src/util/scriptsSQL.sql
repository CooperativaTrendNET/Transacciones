use Proyecto_Operativos_B24814_B35781_B35783_B36630

/*CREACIONES*/
create database Proyecto_Operativos_B24814_B35781_B35783_B36630

create table Empleado(	numeroCuenta char(5) not null constraint PK_Empleado_numeroCuenta PRIMARY KEY,
						nombre nvarchar(30) not null,
						apellidos nvarchar(30) not null,
						cedula char(10) not null constraint UK_Empleado_cedula UNIQUE,
						fondo decimal(10, 3) not null,
						contrasenia nvarchar(40) not null)
						
create table Transaccion(	id_transaccion int not null identity(1, 1) constraint PK_Transaccion_id Primary Key,
							tipo nvarchar(13) not null,
							monto decimal(10, 3) not null,
							cuentaOrigen char(5) not null constraint FK_Transaccion_cuentaOrigen FOREIGN KEY(cuentaOrigen) REFERENCES Empleado(numeroCuenta),
							cuentaDestino char(5) null constraint FK_Transaccion_cuentaDestino FOREIGN KEY(cuentaDestino) REFERENCES Empleado(numeroCuenta),
							fechaTransaccion datetime null default getDate(),
							descripcion nvarchar(MAX))

CREATE TRIGGER Transaccion_AI ON Transaccion after insert AS exec sp_transaccion print(select tipo from Inserted)

CREATE PROCEDURE sp_transaccion @tipo nvarchar(13) AS 
	begin
		if @tipo = 'transferencia'
			begin
				Update Empleado set fondo = fondo-Inserted.monto from Inserted where Inserted.cuentaOrigen=Empleado.numeroCuenta;
				Update Empleado set fondo = fondo+Inserted.monto from Inserted where Inserted.cuentaDestino=Empleado.numeroCuenta;
			end
		else if @tipo = 'deposito'
			begin
				Update Empleado set fondo = fondo+Inserted.monto from Inserted where Inserted.cuentaOrigen=Empleado.numeroCuenta;
			end
		else if @tipo = 'retiro'
			begin
				Update Empleado set fondo = fondo-Inserted.monto from Inserted where Inserted.cuentaOrigen=Empleado.numeroCuenta;
			end
	end

/*INSERCIONES*/
insert Empleado values('00001', 'Diego Andres', 'Roman Navarro', '0101340937', 100000.000, 'c673c7c6c390e3503108e4eb7f9f68d1')
insert Empleado values('00010', 'Daniela Antonella', 'Gallardo Ramos', '0306480649', 100000.000, '664d297c3f00475676d2beade4026477')
insert Empleado values('00011', 'Santiago Emiliano', 'Molina Ortiz', '0402640425', 100000.000, 'e808c61e91f9dec53303c1f1cdcad05e')
insert Empleado values('00100', 'Isabel Ximena', 'Rivas Suarez', '0608520563', 100000.000, '402cb17ca41bc45390f4aa9ea3bf1cfe')
insert Empleado values('00101', 'Angel Daniel', 'Sanchez Rodriguez', '0703690356', 100000.000, 'f6e70bf14a5e0c36d3915695ac2d9989')
insert Empleado values('00110', 'Natalia Valeria', 'Brenes Murillo', '0108740245', 100000.000, '0a94cf4cd44933b7ca4d0b27a29d597f')
insert Empleado values('00111', 'Matias Gabriel', 'Camacho Duarte', '0303680678', 100000.000, 'e331debc6a8467c35bfc1d97cd7969b4')
insert Empleado values('01000', 'Sofia Valentina', 'Masis Blanco', '0702640658', 100000.000, '9e9e1c50f640da6847c612c2d9c714c7')
insert Empleado values('01001', 'Juan Pablo', 'Ruiz Garcia', '0402640326', 100000.000, 'cc931641ea6faac5afb118a54b88c5d3')
insert Empleado values('01010', 'Marianella', 'Serrano Alvarez', '0608590326', 100000.000, '3981ff95a2bffe2d1c9d331a2fbc2ec9')
insert Empleado values('01011', 'Benjamin Fernando', 'Navarro Lopez', '0305030456', 100000.000, '599ab7b9ae169e60c8814f438d08083a')
insert Empleado values('01100', 'Luna Isabella', 'Velasco Jimenez', '0101630365', 100000.000, '192ff5a47caed9870b442af8a40fe987')
insert Empleado values('01101', 'Allison Monserrat', 'Sanchez Fernandez', '0403570436', 100000.000, '0706d79ab94dfbe823e226adb646530e')
insert Empleado values('01110', 'Jose Francisco', 'Casas Sanz', '0604570568', 100000.000, 'c096816480a28ff27a7ae747ec77820b')
insert Empleado values('01111', 'Nicole Andrea', 'Garcia Moreno', '0703460245', 100000.000, 'ec2500e226662702c92c8349bcdc3883')
insert Empleado values('10000', 'Isaac Emmanuel', 'Pardo Romero', '0102450657', 100000.000, 'd9bb5f275d67c00d8ad9ae6de4aeafba')
insert Empleado values('10001', 'Nicole Samantha', 'Palacios Dominguez', '0606170425', 100000.000, 'a0d7b499122ca8d1e6f7959b5eb6e883')
insert Empleado values('10010', 'Joaquin Alejandro', 'Miranda Blanco', '0709490654', 100000.000, '855e93339babccb073aedc9aed81ee57')
insert Empleado values('10011', 'Sara Vanessa', 'Gonzalez Martinez', '0307890254', 100000.000, '5c0521c55c9f33198115510656e41d75')
insert Empleado values('10100', 'Nicolas Alexander', 'Garcia Perez', '0405430658', 100000.000, '595a3b56f7fe13886e5d22b0c0486cdb')

/*CONSULTAS*/
select * from Empleado
select * from Transaccion
select DATEPART(mi, fechaTransaccion) from Transaccion --yyyy:mm:dd hh:mi:ss