# 🎬 ProjetoFeitv

Sistema desktop de filmes desenvolvido em Java com interface gráfica Swing e banco de dados PostgreSQL.

O projeto permite que usuários realizem login, visualizem filmes em formato de cards, curtam filmes, adicionem aos favoritos e organizem uma lista de reprodução personalizada.

## 🚀 Tecnologias Utilizadas
- Java
- Java Swing
- PostgreSQL
- JDBC
- Apache NetBeans
- MVC (Model-View-Controller)
## ✨ Funcionalidades
### 👤 Sistema de Usuário
- Cadastro de usuários
- Login
- Sessão do usuário logado
### 🎥 Filmes
- Exibição dinâmica de filmes em cards
- Informações dos filmes:
- Título
- Gênero
- Duração
- Ano
### 👍 Curtidas
- Curtir/descurtir filmes
- Contador de curtidas em tempo real
- Persistência no banco de dados
- Destaque visual no botão de curtida
### ❤️ Favoritos
- Adicionar/remover filmes dos favoritos
- Tela exclusiva de favoritos
- Destaque visual no botão de favorito
### 📺 Lista de Reprodução
- Adicionar filmes favoritos à lista de reprodução
- Tela exclusiva da lista de reprodução
- Remoção automática da lista ao remover dos favoritos
### 🔍 Pesquisa
- Pesquisa dinâmica de filmes
- Atualização em tempo real ao digitar
### 🗂️ Estrutura do Projeto
- MVC
### 🛠️ Banco de Dados
* Tabelas utilizadas
- usuarios
- filmes
- curtidas
- favoritos
- lista_reproducao

### 📸 Interface

O sistema utiliza:

- Cards dinâmicos
- Barra lateral
- Scroll de filmes
- Tema escuro
- Botões interativos
### 📚 Conceitos Aplicados
- Programação Orientada a Objetos
- MVC
- JDBC
- Relacionamento entre tabelas
- Eventos no Swing
- Manipulação dinâmica de componentes
- Integração Java + PostgreSQL
## Funcionamento do programa
### Diagrama de classes
<img width="1100" height="800" alt="Diagrama de Classes do projeto atualizado" src="https://github.com/user-attachments/assets/9836b973-4b99-4d85-9db0-77598db21c49" />


## Explicação do Funcionamento    
### Cadastro e Login
O cadastro do usuário é realizado através da tela de cadastro. Ao clicar no botão “Cadastrar”, uma função é iniciada para salvar as informações do usuário no banco de dados utilizando SQL. Durante esse processo, também é criado automaticamente um ID único para o usuário, que será utilizado nas demais tabelas do sistema para relacionar suas informações.

O login funciona verificando os dados inseridos com as informações armazenadas no banco de dados. Caso o usuário não exista ou tenha digitado alguma informação incorretamente, o sistema exibirá uma mensagem de erro no login.

### Tela do Catálogo
A tela do catálogo, ou “Tela Principal”, funciona buscando as informações dos filmes diretamente do banco de dados e armazenando esses dados em uma lista. A partir dessas informações, são criados “cards”, que funcionam como pequenos painéis de exibição dos filmes.

Esses cards são construídos por meio de código diretamente na View do JFrame e são divididos em duas partes principais: o painel de informações do filme e o painel de rodapé. No painel do filme são exibidas informações como título, gênero, duração e ano, enquanto no rodapé são criados os botões de curtir e adicionar aos favoritos.

O botão de curtir executa uma função que adiciona o ID do usuário logado e o ID do filme curtido na tabela curtidas do banco de dados. O mesmo processo ocorre com o botão de favoritos, porém os IDs são armazenados na tabela favoritos.

### Tela de Favoritos e Lista de Reprodução dos Favoritos

A parte visual da tela de favoritos e da tela de lista de reprodução funciona de forma semelhante à tela do catálogo principal. Os cards dos filmes são criados da mesma maneira, utilizando componentes gerados dinamicamente na View do JFrame. A principal diferença está na origem das informações exibidas.

Na tela de favoritos, quando o usuário clica no botão de favoritar na tela principal, o ID do usuário e o ID do filme são armazenados na tabela favoritos do banco de dados. Ao abrir a página de favoritos, o ArrayList com as informações dos filmes é montado a partir dessa tabela, diferentemente da tela de catálogo, que exibe todos os filmes presentes na tabela filmes.

O mesmo processo ocorre na tela de lista de reprodução dos favoritos. Os filmes exibidos nos cards são carregados a partir da tabela lista_reproducao, que armazena os filmes adicionados pelo usuário para assistir mais tarde.

A maior diferença visual entre as telas está nos botões presentes no rodapé dos cards. Na tela de favoritos existem os botões de curtir, remover dos favoritos e adicionar à lista de reprodução. Já na tela da lista de reprodução, os botões disponíveis são o de curtir e o de remover da lista.

## ▶️ Como Executar
- Clonar o repositório
- git clone SEU_LINK_GITHUB

- Criar banco PostgreSQL
- Crie um banco chamado:
Projeto

- Executar os scripts SQL
- Crie as tabelas necessárias no PostgreSQL.

### Configurar conexão
No arquivo de conexão JDBC, configure:

- url usuario senha 5. Executar o projeto

- Abra no Apache NetBeans e execute a aplicação.

### 📌 Exemplos da  criaçãos das tabela 
```sql
CREATE TABLE usuarios (

id SERIAL PRIMARY KEY,
usuario VARCHAR(50) UNIQUE NOT NULL,
senha VARCHAR(100) NOT NULL
);

CREATE TABLE filmes (

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


CREATE TABLE curtidas (

usuario_id INT,
filme_id INT,
PRIMARY KEY (usuario_id, filme_id)
);
```
### 📌 Exemplo de Insert na Tabela Filmes
```sql
INSERT INTO filmes (titulo, genero, duracao, ano, curtidas) VALUES

('Vingadores', 'Ação', '2h 23min', 2012, 0),
('Vingadores: Era de Ultron', 'Ação', '2h 21min', 2015, 0),
('Vingadores: Ultimato', 'Ação', '3h 01min', 2019, 0),
('Batman', 'Ação', '2h 56min', 2022, 0),
('Interestelar', 'Ficção', '2h 49min', 2014, 0),
('Matrix', 'Ficção', '2h 16min', 1999, 0),
('Coringa', 'Drama', '2h 02min', 2019, 0),
('Titanic', 'Romance', '3h 15min', 1997, 0),
('Avatar', 'Ficção', '2h 42min', 2009, 0),
('John Wick', 'Ação', '1h 41min', 2014, 0),
('John Wick 2', 'Ação', '2h 02min', 2017, 0),
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
('Deadpool', 'Ação', '1h 48min', 2016, 0),
```

# 👨‍💻 Autor

- Desenvolvido por Gustavo Santos.
