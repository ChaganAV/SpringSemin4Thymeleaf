CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(30) NOT NULL,
    description varchar(80),
    count_product int
);