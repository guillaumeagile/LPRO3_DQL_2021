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

- diagrammes UML de toute la partie model
- diagrammes de sequence de au moins 2 tests dans AccountTest.java
  * withdrawalSucceeds
  * withdrawalFailure