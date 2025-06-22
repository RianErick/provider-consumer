CREATE TABLE produtor (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL UNIQUE,
    dataMensagem VARCHAR(255)
)