# 🎬 ProjetoFeitv

Sistema desktop de filmes desenvolvido em Java com interface gráfica Swing e banco de dados PostgreSQL.

O projeto permite que usuários realizem login, visualizem filmes em formato de cards, curtam filmes, adicionem aos favoritos e organizem uma lista de reprodução personalizada.

## 🚀 Tecnologias Utilizadas
-Java
-Java Swing
-PostgreSQL
-JDBC
-Apache NetBeans
-MVC (Model-View-Controller)
##✨ Funcionalidades
###👤 Sistema de Usuário
-Cadastro de usuários
-Login
-Sessão do usuário logado
###🎥 Filmes
-Exibição dinâmica de filmes em cards
-Informações dos filmes:
-Título
-Gênero
-Duração
-Ano
###👍 Curtidas
-Curtir/descurtir filmes
-Contador de curtidas em tempo real
-Persistência no banco de dados
-Destaque visual no botão de curtida
###❤️ Favoritos
-Adicionar/remover filmes dos favoritos
-Tela exclusiva de favoritos
-Destaque visual no botão de favorito
###📺 Lista de Reprodução
-Adicionar filmes favoritos à lista de reprodução
-Tela exclusiva da lista de reprodução
-Remoção automática da lista ao remover dos favoritos
###🔍 Pesquisa
-Pesquisa dinâmica de filmes
-Atualização em tempo real ao digitar
###🗂️ Estrutura do Projeto
-MVC
###🛠️ Banco de Dados
*Tabelas utilizadas
-usuarios
-filmes
-curtidas
-favoritos
-lista_reproducao
###📌 Exemplo da tabela filmes
CREATE TABLE filmes (

    id SERIAL PRIMARY KEY,

    titulo VARCHAR(100) NOT NULL,

    genero VARCHAR(50) NOT NULL,

    duracao VARCHAR(20) NOT NULL,

    ano INT NOT NULL,

    curtidas INT DEFAULT 0
);
###▶️ Como Executar
-1. Clonar o repositório
-git clone SEU_LINK_GITHUB
-2. Criar banco PostgreSQL

-Crie um banco chamado:

-Projeto
-3. Executar os scripts SQL

Crie as tabelas necessárias no PostgreSQL.

4. Configurar conexão

No arquivo de conexão JDBC, configure:

url
usuario
senha
5. Executar o projeto

Abra no Apache NetBeans e execute a aplicação.

###📸 Interface

O sistema utiliza:

-Cards dinâmicos
-Barra lateral
-Scroll de filmes
-Tema escuro
-Botões interativos
###📚 Conceitos Aplicados
-Programação Orientada a Objetos
-MVC
-JDBC
-Relacionamento entre tabelas
-Eventos no Swing
-Manipulação dinâmica de componentes
-Integração Java + PostgreSQL
##👨‍💻 Autor

-Desenvolvido por Gustavo Santos.
