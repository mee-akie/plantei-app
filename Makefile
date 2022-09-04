.PHONY: 'all start build clean'

all: build start

start:
	@docker run --rm -it -p 8000:8000 plantei-backend

build:
	@docker build --tag plantei-backend .

clean:
	@docker rmi plantei-backend
