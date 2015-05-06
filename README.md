# TP-JPA

TP JPA+SERVLET+REST
===================

Groupe : Anne-Sophie Balestra et Jérémy Viallatte.

Ce TP comprend : 
> - Les classes annotés avec JPA
> - Une partie REST (GET)
> - Une partie Servlet (POST + GET)

**Configuration**
-------------------------

> - Cloner le projet depuis github.
> - Modifier le fichier **persistence.xml** afin d'adapter les informations à votre base de données MySQL.


**Peuplement de la BDD** 
-------------------------

> - Run **JpaTest.java** pour alimenter la base de données.


**Lancement de l'application** 
-------------------------

> - Lancer le serveur Tomcat 7 avec maven : ``` mvn tomcat7:run```
> - Rendez vous sur ```http://localhost:8080/ ```
> - Les servlets sont dans **src.main.java.fr.istic.sir.servlet**
> - Les pages web dans **src/main/webapp**
> - L'application permet de visualiser et de créer des Personnes. 


**API REST Jersey** 
-----------

La commande ``` mvn tomcat7:run``` démarre également le web service de JERSEY, la source se situe dans **src.main.java.fr.istic.sir.rest**

Le path de base pour Jersey est **/rest/hello**.

| Method     | URL | Action   |
| :------- | ----: | :---: |
| GET    | /rest/home  |  créer une maison   |
