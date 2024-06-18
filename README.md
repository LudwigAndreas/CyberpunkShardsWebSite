# Cyberpunk Shards

This project is a web application that allows users to read in-game notes and books from the game Cyberpunk 2077.

## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installing](#installing)
- [Built Using](#built-using)
- [Authors](#authors)
- [Acknowledgements](#acknowledgements)
- [License](#license)

## About

This java-application was developed for the purpose of learning how to create a web application using the servlet technology and thyemleaf template engine. Also, the project was developed to learn how to work with the PostgreSQL database and how to deploy a web application on the Heroku platform.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them.

```text
Java 11
Maven
PostgreSQL
```

```bash
sudo apt-get install openjdk-11-jdk
sudo apt-get install maven
sudo apt-get install postgresql
```

### Installing

A step by step series of examples that tell you how to get a development env running.

Clone the repository.

```bash
git clone https://github.com/LudwigAndreas/CyberpunkShardsWebSite.git

cd CyberpunkShardsWebSite
```

Run docker-compose to start the PostgreSQL database.

```bash
docker-compose up -d
```

it will create a database with the name `cyberpunk_shards` and a user with the name `cyberpunk_shards` and password `cyberpunk_shards`.

After that, you need to compile the project.

```bash
mvn clean package
```

And deploy the project on the Tomcat server.

```bash
mvn tomcat7:run
```

## Built Using

- [Java](https://www.java.com/) - Programming language.
- [Maven](https://maven.apache.org/) - Dependency Management.
- [PostgreSQL](https://www.postgresql.org/) - Database.
- [Tomcat](http://tomcat.apache.org/) - Web server.
- [Thymeleaf](https://www.thymeleaf.org/) - Template engine.
- [Docker](https://www.docker.com/) - Containerization platform.
- [Heroku](https://www.heroku.com/) - Cloud platform.

## Authors

This project was developed by:

| <img src="https://avatars.githubusercontent.com/u/88089961?v=4" alt="drawing" width="50"/> |[LudwigAndreas](https://github.com/LudwigAndreas)|
| --- | --- |

## Acknowledgements

- [NightCityShards and CDcruz for his fantastic website](https://nightcityshards.net/)
- [Cyberpunk 2077](https://www.cyberpunk.net/)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
