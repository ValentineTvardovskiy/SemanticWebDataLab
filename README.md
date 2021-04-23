# FOR DOCKER START
## all commands should be performed from the project root
1) mvn clean install
2) docker build -t wikidata-app .
3) docker run -p 8080:8080 wikidata-app