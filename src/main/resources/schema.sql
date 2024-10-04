CREATE TABLE CLIENTE (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(150) NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    apellido VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE PRODUCTO (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(150) NOT NULL,
    descripcion VARCHAR(250) NOT NULL,
    precio DOUBLE NOT NULL,
    cantidad INT NOT NULL 
);

CREATE TABLE VENTA (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME,
    monto_total DECIMAL, 
    estado VARCHAR(250),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES CLIENTE(id_cliente)
);

CREATE TABLE DETALLE_VENTA (
    id_detalle  INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT,
    FOREIGN KEY (id_venta) REFERENCES VENTA(id_venta),
    id_producto INT,
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto),
    cantidad INT,
    precio_unitario DECIMAL
);
