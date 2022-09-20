.PHONY: 'start stop build clean setup'

start:
	@echo 'Starting containers...'
	docker-compose up

stop:
	@echo 'Stopping containers...'
	docker-compose down

build:
	@echo 'Building the docker image'
	COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose build

clean:
	@echo 'Removing the docker images'
	docker container rm plantei-database plantei-backend
	docker image rm plantei-database:1.0 plantei-backend:1.0

setup:
	@echo 'Not yet'

