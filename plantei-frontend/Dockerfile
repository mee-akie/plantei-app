# syntax=docker/dockerfile:1.4

FROM node:18 AS development

WORKDIR /plantei

COPY package.json /plantei/package.json
COPY package-lock.json /plantei/package-lock.json

RUN [ "npm", "install" ]

COPY . /plantei

ENV CI=true
ENV PORT=3000

CMD [ "npm", "run", "dev" ]
#CMD [ "npm", "start" ]
#
#
#FROM development AS build
#
#RUN [ "npm", "run", "build" ]
#
#FROM development as dev-envs
#RUN <<EOF
#apt-get update
#apt-get install -y --no-install-recommends git
#EOF
#
#RUN <<EOF
#useradd -s /bin/bash -m vscode
#groupadd docker
#usermod -aG docker vscode
#EOF
#
#COPY --from=gloursdocker/docker / /
#CMD [ "npm", "start" ]
#
#
#FROM nginx:alpine
#
#
#COPY --from=build /plantei/.nginx/nginx.conf /etc/nginx/conf.d/default.conf
#
#WORKDIR /usr/share/nginx/html
#
## Remove default nginx static assets
#RUN rm -rf ./*
#
## Copy static assets from builder stage
#COPY --from=build /plantei/build .
#
## Containers run nginx with global directives and daemon off
#ENTRYPOINT ["nginx", "-g", "daemon off;"]
#
