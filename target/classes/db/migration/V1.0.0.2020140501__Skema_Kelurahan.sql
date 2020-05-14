create table kelurahan (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    kde VARCHAR(10) NOT NULL UNIQUE,
    nama VARCHAR(255) NOT NULL,
    kodepos VARCHAR(10) NOT NULL
);
