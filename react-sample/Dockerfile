ARG APP_HOME=/usr/src/app
FROM --platform=linux/amd64 node:16.15.1-slim as build
WORKDIR ${APP_HOME}

COPY ["package.json", "./"]
RUN npm install
COPY public ${APP_HOME}/public/
COPY src ${APP_HOME}/src/
COPY .env.production ${APP_HOME}
RUN npm run build

FROM --platform=linux/amd64 nginx
RUN rm -rf /etc/nginx/conf.d
COPY conf /etc/nginx
COPY --from=build ${APP_HOME}/build /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
