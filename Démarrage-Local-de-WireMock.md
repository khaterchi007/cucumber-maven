Démarrage Local de WireMock
Ce guide décrit la méthode la plus simple pour démarrer WireMock sur votre machine locale en utilisant le fichier JAR autonome.

1. Prérequis
Java Runtime Environment (JRE) : Vous devez avoir Java installé (version 8 ou supérieure) pour exécuter le fichier JAR.

2. Démarrage de Base de WireMock
La méthode privilégiée pour un démarrage rapide est d'utiliser le fichier JAR standalone (autonome).

Téléchargez le fichier JAR de la dernière version stable de WireMock (ex: wiremock-standalone-X.X.X.jar) (https://wiremock.org/docs/download-and-installation/).

Ouvrez votre terminal (ou Git Bash/CMD) et naviguez jusqu'au répertoire où vous avez téléchargé le fichier.

Exécutez la commande suivante :
````
java -jar wiremock-standalone-X.X.X.jar
````
(Remplacez wiremock-standalone-X.X.X.jar par le nom de votre fichier téléchargé).
✅ Résultat et Accès
WireMock démarre par défaut sur le port 8080.

Vous devriez voir un message de journalisation (log) comme : Serving HTTP on port 8080.

Vous pouvez accéder à la console d'administration via : http://localhost:8080/__admin/

---

3. Options de Démarrage Courantes
   Vous pouvez personnaliser le comportement de WireMock en ajoutant des arguments après le nom du JAR :

| Option                      | Description                                                                                | Exemple                                                |
|-----------------------------|--------------------------------------------------------------------------------------------|--------------------------------------------------------|
| --port                      | Spécifie un port HTTP différent de 8080 (utile si le 8080 est déjà utilisé).               | java -jar wiremock.jar --port 9090                     |
| --https-port                | Active un service HTTPS sur un port spécifié.                                              | java -jar wiremock.jar --https-port 8443               |
| --root-dir                  | Définit le répertoire racine contenant les sous-dossiers mappings et __files.              | java -jar wiremock.jar --root-dir /mon/dossier/mocks   |
| --verbose                   | Active le mode verbeux (plus de logs) pour le débogage.                                    | java -jar wiremock.jar --verbose                       |
| --global-response-templating| Active le moteur de templating Handlebars pour créer des réponses dynamiques.              | java -jar wiremock.jar --global-response-templating    |

---

4. Démarrage en Mode Enregistrement (Proxy Recording)
   WireMock peut agir comme un proxy pour une API réelle et enregistrer toutes les requêtes/réponses qu'il reçoit pour créer automatiquement des mappings (stubs).

  1. Démarrez WireMock en spécifiant l'API cible pour le proxy et activez l'enregistrement :
````
java -jar wiremock-standalone-X.X.X.jar --proxy-all="http://api.cible.com" --record-mappings --verbose
````
(Remplacez http://api.cible.com par l'URL de l'API que vous souhaitez simuler).

   2. Envoyez des requêtes à WireMock (ex: http://localhost:8080/v1/users/123).

   3. WireMock transmettra la requête à l'API réelle, recevra la réponse et enregistrera automatiquement le mapping dans le dossier mappings/ de votre répertoire de travail.

Une fois que vous avez enregistré les mappings nécessaires, vous pouvez arrêter WireMock et le redémarrer normalement pour servir les réponses simulées sans dépendre de l'API réelle.
