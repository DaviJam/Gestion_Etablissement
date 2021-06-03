# Gestion Etablissement


## Pré-requis
Version java : 15.0.2 <br>
Système de gestion de Base de donnée: MySQL <br>
Container web Tomcat : version 7.0

## Utilisation
Cloner le projet dans le répertoire de votre choix.
> git clone -b David https://github.com/DaviJam/Gestion_Etablissement.git

# GestionEtablissement

## Release V5 
* Création de la version WEB de l'application

## Release V4

* Passage du projet sous maven,
* Ajout des tests unitaires avec junit, harmcrest et mockito

## Release V3

* Possibilité de renseigner la moyenne générale d'un étudiant,
* Possibilité d'afficher la moyenne des étudiants sous forme d'histogramme et camembert

## Release V2

Amélioration de la gestion des erreurs

## Release V1

Amélioration de la robustesse

## Release V0

Création du projet

## Fonctionalités

Ce logiciel permet de gérer un etablissement scolaire. Il est actuellement possible de :

* Se connecter,
* Gérer les cours de l'école,
* Gérer les étudiants,
* Associer un cours à un étudiant,
* Donner une note à un étudiant pour un cours donnée,
* Accéder à la liste des étudiants (pour le directeur uniquement)

:warning: Les fonctionnalités suivantes n'ont été implémentéés :
* Accéder au menu de l'organisation depuis l'accueil,
* Créer un compte,
* Accéder au menu Planning depuis l'accueil,

## Installation

* Aller dans le projet Github : https://github.com/DaviJam/GestionEtablissement.
* Cliquer sur le bouton vert "code" puis télécharger le fichier zip.
* Dans Windows extraire le fichier zip.
* Se rendre dans le dossier "GestionEtablissement".
* Copier/Coller le fichier GestionEtablissement.war dans le répertoire 'webapps' de votre container web. Vous devez avoir une instance de tomcat en fonctionnement.
* Ouvrir la page web http://localhost:8080/etablissement/accueil dans votre navigateur

Deux choix sont alors possibles.

* Accéder à l'application avec le compte Directeur :

  > Identifiant : e.chaumont@ensup.eu
  >  <br/>Mot de passe : e.chaumont

* Accéder à l'application avec le compte Responsable :

  > Identifiant : m.demaison@ensup.eu
  >  <br/>Mot de passe : m.demaison

## Localisation du répertoire des Logs

Format application
* Le répertoire des logs est situé dans le même répertoire que le .jar.

## Convention de nommage

1. <b/>Package:</b>
   <br/>Utiliser la convention <u/>dotcase</u>.
   <br/>Examples:
    * com.sun.eng
    * com.apple.quicktime.v2
    * edu.cmu.cs.bovik.cheese
      <br/>
2. <b/>Attribut:</b>
   <br/>Utiliser la convention <u/>camelCase</u>.
   <br/>Examples:
    * int     iDea;
    * char     n;
    * float    myWidth;
3. <b/>Méthode:</b>
   <br/>Utiliser la convention <u/>camelCase</u>.
   <br/>Examples:
    * run();
    * runFast();
    * getBackground();
4. <b/>Class:</b>
   <br/>Utiliser la convention <u/>PascalCase</u>.
   <br/>Examples:
    * class Raster;
    * class ImageSprite;
5. <b/>Interface:</b>
   <br/>Utiliser la convention <u/>IPascalCase</u>.
   <br/>Examples:
    * interface IRasterDelegate;
    * interface IStoring;
    
## Tests unitaires
Pour lancer les tests unitaires
> mvn test
