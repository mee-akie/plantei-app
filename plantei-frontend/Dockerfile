# syntax=docker/dockerfile:1.4

FROM node:18 AS build

WORKDIR /plantei

COPY package.json /plantei/package.json
COPY package-lock.json /plantei/package-lock.json

RUN [ "npm", "install" ]

COPY . /plantei

ENV CI=true
ENV PORT=3000

ENTRYPOINT [ "npm", "run", "dev" ]
#RUN [ "npm", "run", "build" ]
#
#FROM nginx:alpine
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
