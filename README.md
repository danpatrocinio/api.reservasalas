# api.reservasalas

API back-end para controle de reservas de salas

Para execução deste projeto é necessário ter previamente o Apache Maven instalado e configurado para o ambiente do SO.
<br>Disponível em: https://maven.apache.org/

Também é necessário ter o banco de dados PostgreSQL instalado na porta padrão 5432 e o database "reservasalas" criado.
<br> o acesso deverá ser:
        username: postgres
        password: postgres

* Para subir a API na porta padrão 8080, por linha de comando, a partir do diretório local com o arquivo pom.xml:

        mvn thorntail:run

<br>PS. A primeira execução irá demorar mais para iniciar devido ao fato de precisar baixar as dependências do projeto
<br> e ainda criar a estrutura do banco de dados.