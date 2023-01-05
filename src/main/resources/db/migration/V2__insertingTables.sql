INSERT INTO tb_city (name) VALUES ('São Paulo');
INSERT INTO tb_city (name) VALUES ('Rio de Janeiro');
INSERT INTO tb_city (name) VALUES ('Belo Horizonte');
INSERT INTO tb_city (name) VALUES ('Porto Alegre');
INSERT INTO tb_city (name) VALUES ('Salvador');

INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('João', 'joao@email.com', '12345678910', '1990-01-01 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('Maria', 'maria@email.com', '10987654321', '1995-03-15 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('Pedro', 'pedro@email.com', '01234567890', '1985-05-30 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('Ana', 'ana@email.com', '98765432109', '1980-07-14 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('Carlos', 'carlos@email.com', '12312312345', '1970-09-29 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('Bruna', 'bruna@email.com', '56789012340', '1975-11-13 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('José', 'jose@email.com', '45678901234', '1995-01-01 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('Luiza', 'luiza@email.com', '89012345678', '2000-03-15 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('Rafael', 'rafael@email.com', '01234567890', '2005-05-30 00:00:00.000000');
INSERT INTO tb_person (name, email, cpf, date_of_birth) VALUES ('Sara', 'sara@email.com', '98765432109', '2010-07-14 00:00:00.000000');

INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Rua das Flores', '12345678', 123, 1, 1);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Rua dos Jardins', '98765432', 456, 2, 2);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Avenida dos Pássaros', '56789012', 789, 3, 3);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Praça das Árvores', '01234567', 321, 4, 4);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Estrada das Montanhas', '76543210', 654, 5, 5);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Rua da Lua', '23456789', 987, 6, 1);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Rua do Sol', '45678901', 159, 7, 2);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Avenida dos Anjos', '78901234', 357, 8, 3);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Praça da Estrela', '01234567', 741, 9, 4);
INSERT INTO tb_address (street, zipcode, number, person_id, city_id) VALUES ('Estrada das Nuvens', '12345678', 963, 10, 5);