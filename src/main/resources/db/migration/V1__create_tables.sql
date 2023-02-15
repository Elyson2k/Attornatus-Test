CREATE TABLE tb_city(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE tb_person(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    email varchar(255),
    senha varchar(255),
    cpf varchar(255),
    date_of_birth datetime(6) NOT NULL,
    confirmation_token UUID,
    account_verified boolean NOT NULL
);

CREATE TABLE tb_address(
  id INT AUTO_INCREMENT PRIMARY KEY,
  street varchar(255),
  zipcode varchar(255),
  number INT,
  priorityaddress CHAR,
  person_id INT,
  city_id INT,
  FOREIGN KEY (person_id) REFERENCES tb_person(id)
);





