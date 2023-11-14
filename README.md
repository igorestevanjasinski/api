# api

## Criando Imagem
Para reproduzir a infra, apenas criei as imagens, utilizando os arquivos Dockerfile, para a aplicação e mysql.

### MYSQL
```bash
cd /api/infra/mysql
docker build -t your_imagem_mysql:tag .
```
Após criar a imagem alterar no docker-compose.yml, com o nome e tag criada.

### API
Na raiz do projeto verá um Dockerfile, contendo as configurações da autoinstrementação do opentelemetry e deploy da nossa aplicação
```bash
mvn clean package
docker build -t your_imagem_api:tag .
```
Após criar a imagem alterar no docker-compose.yml, com o nome e tag criada.

### Deploy
```bash
cd /api/infra
docker-compose up
```
### OBS
Não esqueça de alterar as senhas dentro do docker-compose e também 5_insert_user.sql
Caso, não execute o init-scripts do mysql para criação do usuario, acesse o mysql usando comando abaixo e rode o conteudo do 5_insert_user.sql
```bash
docker exec -it container_id mysql -u user -p
use vollmed_api;
insert into usuarios values (1, 'user@voll.med', 'senha_bcrypt');
```

