INSERT INTO tb_city (name) VALUES ('São Paulo');
INSERT INTO tb_city (name) VALUES ('Rio de Janeiro');
INSERT INTO tb_city (name) VALUES ('Belo Horizonte');
INSERT INTO tb_city (name) VALUES ('Porto Alegre');
INSERT INTO tb_city (name) VALUES ('Salvador');

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('John Doe', 'john.doe@example.com', '123-456-789-00', '2000-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Jane Doe', 'jane.doe@example.com', '123-456-789-01', '2001-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Bob Smith', 'bob.smith@example.com', '123-456-789-02', '2002-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Alice Smith', 'alice.smith@example.com', '123-456-789-03', '2003-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Tom Johnson', 'tom.johnson@example.com', '123-456-789-04', '2004-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Jerry Johnson', 'jerry.johnson@example.com', '123-456-789-05', '2005-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Sue Williams', 'sue.williams@example.com', '123-456-789-06', '2006-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Harry Williams', 'harry.williams@example.com', '123-456-789-07', '2007-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Chris Anderson', 'chris.anderson@example.com', '123-456-789-08', '2008-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_person (name, email, cpf, date_of_birth, confirmation_token, account_verified)
VALUES ('Emma Anderson', 'emma.anderson@example.com', '123-456-789-09', '2009-01-01', '01234567-abcd-0123-abcd-0123456789ab', true);

INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Rua das Flores', '12345678', 123, 'Y', 1, 1);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Rua dos Jardins', '98765432', 456, 'N', 2, 2);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Avenida dos Pássaros', '56789012', 789, 'N',3, 3);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Praça das Árvores', '01234567', 321, 'N', 4, 4);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Estrada das Montanhas', '76543210', 654, 'Y',  5, 5);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Rua da Lua', '23456789', 987, 'N', 6, 1);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Rua do Sol', '45678901', 159,'N', 7, 2);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Avenida dos Anjos', '78901234', 357,'N', 8, 3);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Praça da Estrela', '01234567', 741,'N', 9, 4);
INSERT INTO tb_address (street, zipcode, number, priorityaddress, person_id, city_id) VALUES ('Estrada das Nuvens', '12345678', 963,'N', 10, 5);