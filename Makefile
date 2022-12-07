.PHONY: 'start stop build clean'

start: build
	@echo 'Starting containers...'
	@COMPOSE_PROJECT_NAME=plantei docker-compose up

stop:
	@echo 'Stopping containers...'
	@docker-compose down

build:
	@echo 'Building the docker image...'
	@COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose build

clean:
	@echo 'Removing the docker images...'
	@docker container rm plantei-frontend || echo 'Error while removing plantei-frontend container'
	@docker container rm plantei-database || echo 'Error while removing plantei-database container'
	@docker container rm plantei-backend || echo 'Error while removing plantei-backend container'
	@docker image rm plantei-frontend:1.0 || echo 'Error while removing plantei-frontend image'
	@docker image rm plantei-database:1.0 || echo 'Error while removing plantei-database image'
	@docker image rm plantei-backend:1.0 || echo 'Error while removing plantei-backend image'
	@docker network rm plantei-backend || echo 'Error while removing plantei-backend network'
	@docker network rm plantei-frontend || echo 'Error while removing plantei-frontend network'
	@docker volume rm plantei-db || echo 'Error while removing plantei-db volume'
