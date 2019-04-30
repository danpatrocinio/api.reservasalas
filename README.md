# api.reservasalas

API back-end para controle de reservas de sala

* Para execução deste projeto é necessário ter previamente o Apache Maven instalado e configurado para o ambiente.
<br>Disponível em: https://maven.apache.org/

* É necessário o banco de dados PostgreSQL instalado com a porta padrão 5432 e o database "reservasalas" criado.
<br>Disponível em: https://www.postgresql.org/
<br>O acesso ao banco de dados necessitará do usuário que foi configurado no arquivo project-defaults.yml:

        username: postgres
        password: postgres

* Para rodar a API na porta padrão 8080, por linha de comando, a partir do diretório sala com o arquivo pom.xml:

        mvn thorntail:run

<br>PS. A primeira execução irá demorar mais para iniciar devido ao fato de precisar baixar as dependências do projeto
<br> e ainda criar a estrutura do banco de dados.