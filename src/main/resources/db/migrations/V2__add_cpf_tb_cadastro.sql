-- V2: Migration para adicionar a tabela cpf no banco de dados

ALTER TABLE tb_cadastro
ADD COLUMN cpf VARCHAR(255);