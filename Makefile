.PHONY: 'start stop build clean setup'

start:
	@echo 'Starting containers...'
	@COMPOSE_PROJECT_NAME=plantei docker-compose --profile deploy up

stop:
	@echo 'Stopping containers...'
	@docker-compose down

build:
	@echo 'Building the docker image...'
	@COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose --profile deploy build

clean:
	@echo 'Removing the docker images...'
	@docker container rm plantei_database 2>/dev/null || echo 'Error while removing plantei-database container'
	@docker container rm plantei_backend 2>/dev/null || echo 'Error while removing plantei-backend container'
	@docker image rm plantei_database:1.0 2>/dev/null || echo 'Error while removing plantei-database image'
	@docker image rm plantei_backend:1.0 2>/dev/null || echo 'Error while removing plantei-backend image'
	@docker volume rm plantei_postgres_conf 2>/dev/null || echo 'Error while removing plantei-database-config volume'
	@docker volume rm plantei_postgres_db 2>/dev/null || echo 'Error while removing plantei-database-db volume'
	@docker volume rm plantei_postgres_log 2>/dev/null || echo 'Error while removing plantei-database-log volume'
	@docker network rm plantei_backend 2>/dev/null || echo 'Error while removing plantei-backend network'
	@docker network rm plantei_database 2>/dev/null || echo 'Error while removing plantei-database network'
