## Kotlin Redis Lock

This repository is an example using distributed locks with redis in spring boot

### How to run

To run this project you need Java, [Docker](https://docs.docker.com/engine/install/) and [docker-compose](https://docs.docker.com/compose/install/) installed in your PC

Run in terminal:
    `docker-compose up -d && mvn verify && java -jar target/lock_redis-1.0.0.jar`

or run `make up` if you have `make` installed


