# syntax=docker/dockerfile:1.4

FROM postgres:14.2-alpine
COPY init.sql /docker-entrypoint-initdb.d/
RUN chmod a+r /docker-entrypoint-initdb.d/*
