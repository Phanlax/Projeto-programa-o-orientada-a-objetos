# Projeto-programa-o-orientada-a-objetos
Repositório relacionado ao desenvolvimento do projeto de Programação orientada a objetos

CREATE TABLE usuarios (

    id SERIAL PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL
);


CREATE TABLE filmes (

    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100),
    genero VARCHAR(50),
    duracao VARCHAR(20),
    ano INT,
);

CREATE TABLE favoritos (

    usuario_id INT,
    filme_id INT,

    PRIMARY KEY (usuario_id, filme_id),

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (filme_id) REFERENCES filmes(id)
);

CREATE TABLE lista_reproducao (

    usuario_id INT,
    filme_id INT,

    PRIMARY KEY (usuario_id, filme_id),

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (filme_id) REFERENCES filmes(id)
);

INSERT INTO filmes (titulo, genero, duracao, ano)
VALUES
('Vingadores: Ultimato', 'Ação', '181min', 2019),

('Batman', 'Ação', '176min', 2022),

('Interestelar', 'Ficção', '169min', 2014),
('Matrix', 'Ficção', '136min', 1999),
('Coringa', 'Drama', '122min', 2019),
('Titanic', 'Romance', '195min', 1997),
('Avatar', 'Ficção', '162min', 2009),
('John Wick', 'Ação', '101min', 2014),
('Toy Story', 'Animação', '81min', 1995);

CREATE TABLE curtidas (

    usuario_id INT,
    filme_id INT,
    PRIMARY KEY (usuario_id, filme_id)
);
