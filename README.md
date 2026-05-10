# Projeto-programação-orientada-a-objetos
Repositório relacionado ao desenvolvimento do projeto de Programação orientada a objetos

CREATE TABLE usuarios (

    id SERIAL PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL
);


CCREATE TABLE filmes (

    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    duracao VARCHAR(20) NOT NULL,
    ano INT NOT NULL,
    curtidas INT DEFAULT 0
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

INSERT INTO filmes (titulo, genero, duracao, ano, curtidas) VALUES

('Vingadores', 'Ação', '2h 23min', 2012, 0),

('Vingadores: Era de Ultron', 'Ação', '2h 21min', 2015, 0),

('Vingadores: Guerra Infinita', 'Ação', '2h 29min', 2018, 0),

('Vingadores: Ultimato', 'Ação', '3h 01min', 2019, 0),

('Batman: O Cavaleiro das Trevas', 'Ação', '2h 32min', 2008, 0),

('Batman', 'Ação', '2h 56min', 2022, 0),

('Interestelar', 'Ficção', '2h 49min', 2014, 0),

('Matrix', 'Ficção', '2h 16min', 1999, 0),

('Coringa', 'Drama', '2h 02min', 2019, 0),

('Titanic', 'Romance', '3h 15min', 1997, 0),

('Avatar', 'Ficção', '2h 42min', 2009, 0),

('Avatar: O Caminho da Água', 'Ficção', '3h 12min', 2022, 0),

('John Wick', 'Ação', '1h 41min', 2014, 0),

('Toy Story', 'Animação', '1h 21min', 1995, 0),

('Toy Story 2', 'Animação', '1h 32min', 1999, 0),

('Toy Story 3', 'Animação', '1h 43min', 2010, 0),

('Jogos Vorazes', 'Ação', '2h 22min', 2012, 0),

('Transformers', 'Ação', '2h 24min', 2007, 0),

('Invocação do Mal', 'Terror', '1h 52min', 2013, 0),

('Invocação do Mal 2', 'Terror', '2h 14min', 2016, 0),


('Corra!', 'Terror', '1h 44min', 2017, 0),

('Barbie', 'Comédia', '1h 54min', 2023, 0),

('Top Gun', 'Ação', '1h 50min', 1986, 0),

('Top Gun: Maverick', 'Ação', '2h 11min', 2022, 0),

('Deadpool', 'Ação', '1h 48min', 2016, 0),

('Deadpool 2', 'Ação', '1h 59min', 2018, 0);

CREATE TABLE curtidas (

    usuario_id INT,
    filme_id INT,
    PRIMARY KEY (usuario_id, filme_id)
);
