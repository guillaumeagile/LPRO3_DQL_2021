# Travaux Dirigés et Notés

## Plan des 3 jours
1. finir le event story mapping du Pet Nanny
2. regarder et comprendre du code: architecture hexagonale; schématiser en UML ce que vous comprenez
3. à partir des idées d'un projet avec archi hexagonale, proposer tests et construction du domaine

## 1. Story Mapping
voir Miro pour vous inspirer
https://miro.com/app/board/uXjVOE2XYB4=/

créer un dashboard Miro par Group
utiliser le template User Story Map Framework fourni par Miro

sujet de l'exerice:  https://www.animaute.fr/
domaine métier:  Pet Sitting

### Activités principales:
- enregistrement Animal
- enregistrement Gardien
- Recherche d'un Gardien pour effectuer une Garde à une certaine date
- booking effectif pour une garde à date choisie, avec un prix fixé par le Gardien
- Garde ou visite:  Helen amène Rex chez Joe pour qu'il le garde, ou bien Joe va chez Helen pour sortir/nourrir Rex
- Fin de la garde ou la visite : Feedback du propriétaire

### Exigences Métier:
- (en tant que propriétaire de l'animal) je veux que les préférences alimentaires de mon chien soient respectées 
- potentiellement le site n'est pas réservé qu'aux chiens, mais à tous types d'animaux
Les Gardiens (nounous) doivent être géolocalisés, comme ca un propriétaire peut choisir le gardien le plus proche 
- les gardiens ne doivent pas garder des chiens et des chats en même temps (incompatibilité)
un gardien doit indiquer son  type de résidence (appart, maison, chateau) et si il a un jardin/terrain et quelle surface
- un gardien doit déclarer combien d'animaux au maximal il peut garder dans une journée (en général en fonction de la taille de là où il habite) 
- un gardien doit tenir à jour son calendrier: indiquer les jours où il est disponible pour faire des gardes/visites
- un Propriétaire, quand il fait une demande de garde, ne doit voir apparaitre que les Gardiens qui sont "libres" pour faire des gardes/visites
- Un propriétaire doit pouvoir demander si il veut une prestation de type garde ou visite
- Un gardien répond à une demande de garde ou de visite, tant que une demande n'a pas été acceptée (par le gardien) elle ne peut pas être effectuée
- Lorsqu'un gardien accepte d'honorer une demande de garde/visite, il ne peut plus la refuser
- Lorsque la visite/garde commence, il faut faire un "état de santé de l'animal"
- Lorsque la visite/garde se fini, le propriétaire faire un "état de santé au retour de l'animal". Si il y a un problème, il déclenche une réclamation 
- A la fin de la visite/garde, le propriétaire laisse un commentaire au Gardien
- Au moment de la réservation, le propriétaire fait le versement du prix à payer, au site Web, qui garde l'argent, le temps que la garde/visite soit effectuée
- Au moment de la restitution de l'animal, le site Web fait le versement du prix à payer au Gardien (si il n'y a pas eu de réclamation)


## 2. Lire une architecture

### pré requis

IntelliJ IDEA Community
https://www.jetbrains.com/idea/download/?


Brew
```
 ~/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

JVM 11 (avec SdkMan)
```
https://sdkman.io/install
```
puis
` sdk install java 11.0.14-zulu `

Gradle
(si SdkMan n'a pas installé gradle)
```
brew install gradle
```

### récupérer des projets "sample"
celle qui marche pas : comprendre pourquoi les tests ne passent pas, discuter de la complexité
https://github.com/CodelyTV/java-ddd-skeleton.git
décortiquer le projet
comprendre pourquoi les tests ne marchent pas


celui qui marche en Kotlin
[Bank]
https://github.com/lmirabal/hexagonal-testing.git
(kotlin)  gadle build, puis regarder le repertoire build/test-results
discuter de la pertinence des tests, du découplage

un autre (en Java):

https://github.com/thombergs/buckpal.git

pour le faire marcher (JVM 11), changer dans build.gradle:

`
dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.20'
    annotationProcessor 'org.projectlombok:lombok:1.18.20'
`

https://exerror.com/java-lang-illegalaccesserror-class-lombok-javac-apt-lombokprocessor-cannot-access-class-com-sun-tools-javac-processing-javacprocessingenvironment/


### Exercice  sur le projet BuckPal

- 1 diagramme UML de 'paquetages' de tout ce qu'il y a dans io/reflectoring/buckpal
(uniquement les paquetages, pas toutes les classes dedans)

- 1 diagramme UML de classes de toute la partie 'model' qui se trouve dans
io/reflectoring/buckpal/account/domain
Uniquement les membres (fields, methods) PUBLIC, sur une classe ca suffira
Le plus important, c'est les relations entre les classes

AU CHOIX UN DES 2 DIAGRAMMES DE SEQUENCE suivant: 
- diagrammes de sequence de au moins 2 tests dans AccountTest.java
  ( src/test/java/io/reflectoring/buckpal/account/application/domain/AccountTest.java )
  * withdrawalSucceeds
  * withdrawalFailure
- (PLUS 5pts) diagrammes de sequence de la fonction 'sendMoney' dans io/reflectoring/buckpal/account/application/service/SendMoneyService.java


REMETTRE LES DIAGRAMMES AU FORMAT PDF (print)

  Questions bonus (avec des points!)
  + que fait l'application ?
  + à quoi sert la classe 'SendMoneyController'? Pourquoi est-elle là ? (io/reflectoring/buckpal/account/adapter/in/web/)
  + à quoi sert le package 'io/reflectoring/buckpal/account/adapter/out/persistence'?  sur quelle librairie (importante) se base-t-il ?
  + pourquoi utilisent-ils des interfaces alors que on aurait pu écrire les classes directement (rappel cours SOLID)



## 3. produire un walking skeleton

Dans votre langage de prédilection
contruire un squelette de projet, qui compile  avec une partie de test unitaire/ TDD
(vous pouvez copier coller le squellete du projet BuckPal et vider la partie Domain)

Avoir un paquetage 'domain', dedans des classes métiers  et surtout un certain nombre de tests unitaire
Dans ce paquetage, vont apparaitre les objets métiers ( )


Quel est le métier:  Pet Sitting
Sous Contexte (Bounded Context)  =  Booking

La story a retranscrire sous forme d'objets (et de tests):
un 'Propriétaire' (Joe) qui possède un 'Animal' (Rex, c'est un chien) fait une Demande de 'Booking' à  'Gardien' Helena

1er test:
La 'Demande de Booking' est refusée si le 'Gardien' n'a pas 'chien' dans la liste d'animaux acceptés.

2e test: 
La 'Demande de Booking' est acceptée si le 'Gardien' a le 'chien' dans la liste d'animaux acceptés.
A ce moment là, le 'Calendrier' du 'Gardien' est modifié, et la date (plage de date, début et fin) est marquée comme occuppée. Une astuce: le Calendrier contient une liste de Booking(s).
Un objet 'Booking' est renvoyé et il contient les infos nécessaire au booking (la date de début et de fin, l'Animal, le Propriétaire, le Gardien, le Montant de la prestation)


3e test: 
La 'Demande de Booking' est refusée si le 'Gardien' n'est pas disponible à la date demandée en fonction de son 'Calendrier'
C'est à dire qu'il a déjà un booking actif dans son calendrier sur cette plage de date.


Vous pouvez ajouter d'autres tests qui correspondent aux User Stories que vous avez choisies dans votre UserStory Mapping du 1er exercice.


### un concept vient d'émerger
la Plage De Date
c'est une nouvelle classe (donc un nouveau type d'objet) qui a besoin que de 2 informations: la date de début et la date de fin.

Ecrivez cette classe , avec la particularité que cela doit être un Value Object
https://en.wikipedia.org/wiki/Value_object
En Java, plusieurs façon de faire
https://dzone.com/articles/value-objects
( dans le projet BuckPal, ils utilisent la librairie Lombok )

Ecrivez 2 tests pour vérifier que 2 instances de ce value object (Plage De Date) sont égales si et seulement si leur date de début et de fin (respectives) sont égales.
Ils seront 'isNotEqualTo' (ca c'est l'assertion JUnit 5) si au moins une des deux valeurs est différente.

Ensuite, la Plage De Date doit porter une règle métier importante: la date de fin ne peut pas être inférieure à la date de début (logique).
Vu que date de début et date de fin sont des localDateTime (précis à la minute), on peut dire que date de fin doit être supérieure ou égale à date de début.
Ecrivez 3 tests qui prouvent cela. Les faire passer au vert.


Et pour finir (presque?) gérer la collision de date:
Ecrire une méthode 'Collision' dans Plage De Date qui prend un paramètre (autrePlageDeDate) et qui retournera un Boolean
True: si la plage de date courante (this) chevauche par le début ou par la fin ou parce que la  autrePlageDeDate est entièrement recouverte par la plage courante.
False: dans les autres cas.

Ecrire 4 tests qui couvrent les cas de collisions et non collision.

### (fin) utiliser 'Collision' de Plage De Date   
pour le test qui dit que La 'Demande de Booking' est refusée si le 'Gardien' a déjà un Booking enregistré dans son calendrier pour lequel la plage de date est en Collision avec la plage de date demandée.

### Question bonus:
avez vous besoin de re tester tous les cas de plage de date , pour vérifier le code de 'Demande de Booking' à partir du moment où vous utilisez 'Plage de Date' ?

# Pour rendre votre devoir
Créez (ou utilisez) votre Repo GIt

Me donner les droits de lecture (si il est privé)

Mettre aussi dedans les images de la modélisation UML (exercice 2)