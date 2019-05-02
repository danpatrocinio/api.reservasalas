# api.reservasalas

API back-end para controle de reservas de sala

* Foi utilizado CDI para facilitar o controle de ciclo de vida das classes de interação com o banco de dados.

* Para validação dos dados recebidos de client front-end foi utilizado a especificação Bean Validation que é muito útil e agiliza uma série de validações básicas de dados de forma padronizada.

* Com o intuito de melhor empacotar e distribuir a aplicação foi utilizado o Thorntail, originalmente WildFly Swarm, que oferece um servidor JavaEE embutido à aplicação com somente as dependências que são necessárias para executar o código sobre a JVM.

* Para execução deste projeto é necessário ter previamente o Apache Maven instalado e configurado para o ambiente.
<br>Disponível em: https://maven.apache.org/

* É necessário o banco de dados PostgreSQL instalado com a porta padrão 5432 e o database "reservasalas" criado.
<br>Disponível em: https://www.postgresql.org/
<br>O acesso ao banco de dados necessita de um usuário de conexão que foi configurado no arquivo project-defaults.yml:

        username: postgres
        password: postgres

* Para rodar a API na porta padrão 8080, pela linha de comando, a partir do diretório com o arquivo pom.xml:

        mvn thorntail:run

<br>PS. A primeira execução irá demorar mais para iniciar devido ao fato de precisar baixar as dependências do projeto
<br> e ainda criar a estrutura do banco de dados. Uma vez feita as próximas execuções são mais céleres.