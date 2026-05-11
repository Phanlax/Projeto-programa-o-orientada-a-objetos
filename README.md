#🎬 ProjetoFeitv

Sistema desktop de filmes desenvolvido em Java com interface gráfica Swing e banco de dados PostgreSQL.

O projeto permite que usuários realizem login, visualizem filmes em formato de cards, curtam filmes, adicionem aos favoritos e organizem uma lista de reprodução personalizada.

🚀 Tecnologias Utilizadas
Java
Java Swing
PostgreSQL
JDBC
Apache NetBeans
MVC (Model-View-Controller)
✨ Funcionalidades
👤 Sistema de Usuário
Cadastro de usuários
Login
Sessão do usuário logado
🎥 Filmes
Exibição dinâmica de filmes em cards
Informações dos filmes:
Título
Gênero
Duração
Ano
👍 Curtidas
Curtir/descurtir filmes
Contador de curtidas em tempo real
Persistência no banco de dados
Destaque visual no botão de curtida
❤️ Favoritos
Adicionar/remover filmes dos favoritos
Tela exclusiva de favoritos
Destaque visual no botão de favorito
📺 Lista de Reprodução
Adicionar filmes favoritos à lista de reprodução
Tela exclusiva da lista de reprodução
Remoção automática da lista ao remover dos favoritos
🔍 Pesquisa
Pesquisa dinâmica de filmes
Atualização em tempo real ao digitar
🗂️ Estrutura do Projeto
src/
│
├── controller/
├── dao/
├── model/
├── view/
└── util/
🛠️ Banco de Dados
Tabelas utilizadas
usuarios
filmes
curtidas
favoritos
lista_reproducao
📌 Exemplo da tabela filmes
CREATE TABLE filmes (

    id SERIAL PRIMARY KEY,

    titulo VARCHAR(100) NOT NULL,

    genero VARCHAR(50) NOT NULL,

    duracao VARCHAR(20) NOT NULL,

    ano INT NOT NULL,

    curtidas INT DEFAULT 0
);
▶️ Como Executar
1. Clonar o repositório
git clone SEU_LINK_GITHUB
2. Criar banco PostgreSQL

Crie um banco chamado:

Projeto
3. Executar os scripts SQL

Crie as tabelas necessárias no PostgreSQL.

4. Configurar conexão

No arquivo de conexão JDBC, configure:

url
usuario
senha
5. Executar o projeto

Abra no Apache NetBeans e execute a aplicação.

📸 Interface

O sistema utiliza:

Cards dinâmicos
Barra lateral
Scroll de filmes
Tema escuro
Botões interativos
📚 Conceitos Aplicados
Programação Orientada a Objetos
MVC
JDBC
Relacionamento entre tabelas
Eventos no Swing
Manipulação dinâmica de componentes
Integração Java + PostgreSQL
👨‍💻 Autor

Desenvolvido por Gustavo Santos.

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
