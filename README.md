# Projeto-programa-o-orientada-a-objetos
Repositório relacionado ao desenvolvimento do projeto de Programação orientada a objetos

CREATE TABLE filmes (

    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100),
    genero VARCHAR(50),
    duracao VARCHAR(20),
    ano INT,
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
