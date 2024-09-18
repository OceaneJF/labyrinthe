# <span style="color:#FF0000">Journal de bord</span>


## Sommaire
- [Lundi 2 septembre 2024](#lundi-2-septembre-2024)
- [Mardi 3 septembre 2024](#mardi-3-septembre-2024)
- [Mercredi 4 septembre 2024](#mercredi-4-septembre-2024)
- [Jeudi 5 septembre 2024](#jeudi-5-septembre-2024)
- [Vendredi 6 septembre 2024](#vendredi-6-septembre-2024)
- [Lundi 9 septembre 2024](#lundi-9-septembre-2024)
- [Mercredi 11 septembre 2024](#mercredi-11-septembre-2024)
- [Mardi 17 septembre 2024](#mardi-17-septembre-2024)


---


<a name="lundi-2-septembre-2024"></a>
## <span style="color:#5b91fc">Lundi 2 septembre 2024</span>


### Première session : 2h


- **Ce que j’ai réalisé :**  
Lors de cette première session, j’ai préparé mon environnement de travail. Plus précisément, j’ai initialisé le projet Netbeans, le dépôt Git local, et le dépôt GitLab distant. Ensuite, j’ai réalisé la synchronisation avec GitLab et enfin testé le dépôt distant pour la restauration. Par la suite, j’ai réalisé l’exercice 1 et commencé à construire le diagramme en spécification générale des interfaces fournies en annexe ainsi que de l’extrait de code de la boucle principale. N’ayant pas eu le temps de finir durant la session, j’ai terminé ce diagramme ainsi que celui du code initial fourni dans la soirée.


- **Difficultés rencontrées et solutions apportées :**  
J’ai rencontré de nombreuses difficultés lors de la préparation de l’environnement. En effet, l’interface graphique de NetBeans spécifique à la gestion de Git (pour initialiser un dépôt Git local, faire des *git push* et des *git clone*) ne fonctionnait pas. J’ai donc demandé de l’aide à l’un de mes camarades, qui m’a montré une autre façon de faire avec les commandes du terminal. J’ai également eu quelques difficultés lors de la réalisation des diagrammes de spécifications générales, notamment lors de la représentation des collections. J’ai donc fait des recherches personnelles dans mes cours du S2 afin de me débloquer.


---


<a name="mardi-3-septembre-2024"></a>
## <span style="color:#5b91fc">Mardi 3 septembre 2024</span>


### 2ème, 3ème et 4ème sessions : 6h


- **Ce que j’ai réalisé :**  
Lors de la deuxième session, j’ai corrigé les erreurs dans mon diagramme UML tout en aidant mes camarades (Tim, Caroline et Jessica) avec le leur. J’ai également aidé une camarade (Jessica) à préparer son environnement de travail. J’ai ensuite réalisé l’exercice 3, qui consistait à coder la classe Salle. Durant la troisième session, j’ai implémenté la méthode "charger" de la classe Etage (exercice 4) et aidé quelques camarades (Tim, Caroline et Jessica) avec l’UML. Enfin, durant la quatrième séance, j’ai partiellement codé la méthode "estAdjacente" de l’exercice 5 et aidé Tim et Caroline avec les exercices précédents. Je me suis également avancé à la maison en terminant l’exercice 5, en effectuant l’exercice 6, ainsi qu'une partie de l’exercice 7.




- **Difficultés rencontrées et solutions apportées :**  
Lors de la 2ᵉ session, je n’ai pas rencontré de difficultés particulières. Cependant, j’ai eu des difficultés à réaliser l’exercice 4, qui consistait à implémenter la méthode `charger`. En effet, je n’avais pas compris comment ajouter des salles à un étage, sachant que la classe `Etage` hérite de la classe `ArrayList<ISalle>`. Cela m’a bloqué pendant un certain temps, mais j’ai pu me débloquer après plusieurs recherches personnelles.
Lors de la 4ᵉ séance, j’ai rencontré des difficultés, notamment pour comprendre l’énoncé de l’exercice 5. Pour mieux comprendre, j’ai fait appel à Monsieur Sopena. J’ai également eu du mal à implémenter la méthode `estAdjacente`. En effet, j’avais oublié que la méthode `equals` de la classe `Salle` ne prenait pas en compte le type de la salle, ce qui s’est avéré important pour le bon fonctionnement de la méthode. Cela m’a bloqué un long moment, mais à force de relire mon code, j’ai finalement réussi.
Par la suite, j’ai eu des difficultés lors de la réalisation de l’exercice 6, car je n’arrivais pas à trouver sous quelle forme devait être écrit le lien permettant d’accéder aux fichiers dans le dossier `etages` dans le constructeur de la classe `Labyrinthe`. Étant chez moi à ce moment-là, je ne pouvais pas demander l’aide d’un professeur. J’ai donc essayé plusieurs solutions jusqu’à ce que cela fonctionne.
Enfin, j’ai eu beaucoup de mal à implémenter la méthode `dessin`. En effet, j’ai dû faire de nombreuses recherches sur internet pour comprendre le fonctionnement de JavaFX, que j’utilisais pour la première fois. Je n’ai donc pas pu finir l’exercice 7 ce soir-là.


---


<a name="mercredi-4-septembre-2024"></a>
## <span style="color:#5b91fc">Mercredi 4 septembre 2024</span>


### 5ème session : 2h


- **Ce que j’ai réalisé :**  
Lors de la 5ᵉ session, j'ai poursuivi l'exercice 7, mais je n'ai pas eu le temps de le terminer. Comme j'étais bloqué, j'ai optimisé la méthode “charger” de la classe “Étage”. J'ai également aidé Jessica avec les exercices de l'objectif 1. J'ai terminé les exercices 7 et 8 chez moi dans l'après-midi.


- **Difficultés rencontrées et solutions apportées :**  
Durant cette 5ème session, j'ai rencontré de nombreuses difficultés à réaliser l'exercice 7. En effet, je n'arrivais pas à afficher d'autres types de salles que celles de type NORMALE. J'ai donc essayé de déboguer mon code en ajoutant des println dans plusieurs méthodes et me suis rendu compte que le calcul pour placer les différentes salles aux bonnes coordonnées n'était pas correct. Je n'ai cependant pas réussi à trouver le problème pendant la séance. J'ai donc continué dans l'après-midi et ai finalement trouvé la solution.
J'ai également eu des difficultés lors de l'implémentation des tests de la classe Salle, notamment pour les méthodes "voisines", "suivante" et "estDansPlateaux", qui sont utilisées dans la méthode "estAdjacente". Bien que celles-ci me permettaient d'afficher le labyrinthe (j'ai utilisé la méthode "voisines" pour afficher les murs), elles étaient partiellement incorrectes. En implémentant les tests, je me suis également rendu compte que la méthode "estDansPlateaux" était inutile.


---


<a name="jeudi-5-septembre-2024"></a>
## <span style="color:#5b91fc">Jeudi 5 septembre 2024</span>


### 6ème, 7ème et 8ème sessions : 6h


- **Ce que j’ai réalisé :**  
Lors de la 6e séance, j'ai ajouté plusieurs cas de tests dans la classe SalleTest après avoir constaté qu'il en manquait. J'ai également aidé Tim et Caroline avec l'affichage du labyrinthe et pour l'exercice 8. Lors des 7e et 8e séances, j'ai codée l'exercice 9 et une partie de l'exercice 10, tout en aidant Tim, Caroline et Jessica pour les tests unitaires. J'ai ensuite continué à coder chez moi le soir et j'ai réalisé les exercices 11, 12, 13 et 14.


- **Difficultés rencontrées et solutions apportées :**  
Je n’ai pas rencontré de difficultés particulières lors de la 6ème séance. Cependant, j'ai eu quelques problèmes lors des séances suivantes. En effet, je me suis rendu compte trop tard (après avoir commit) que je n'avais pas bien compris l’exercice 9. C’est en réalisant l’exercice 10 que je m’en suis aperçu et que j’ai pu le corriger. Je suis également resté bloqué un moment sur l’exercice 10, car je ne savais pas comment ajouter une salle à un étage en utilisant la méthode *add* de Java, au lieu de celle que j’étais en train de coder. J’ai finalement trouvé la solution après quelques recherches sur internet et en consultant mes cours du S2. J’ai aussi eu du mal à comprendre les consignes des exercices 13 et 14. Étant chez moi, je n’ai pas pu demander de l’aide à un professeur.


---


<a name="vendredi-6-septembre-2024"></a>
## <span style="color:#5b91fc">Vendredi 6 septembre 2024</span>


### 9ème et 10ème sessions : 4h


- **Ce que j’ai réalisé :**  
Lors de la 9ᵉ séance, j'ai commencé à coder l'exercice 15, que j'ai terminé lors de la 10ᵉ séance. J'ai aussi débuté l'exercice 16 pendant cette séance, puis poursuivi un peu chez moi le soir. J'ai également réalisé les exercices 17, 18, 19 et 20 durant le week-end.


- **Difficultés rencontrées et solutions apportées :**  
J’ai eu beaucoup de mal à comprendre la consigne de l’exercice 15, ce qui m’a bloqué pendant la première séance. J’ai profité de la deuxième séance pour demander des explications à Monsieur Sopena, ce qui m’a permis de débloquer la situation et d'avancer. Cependant, durant la séance 10, je me suis rendu compte que je ne savais pas comment accéder à l'attribut “salleChoisie” de la classe Héros alors que j'étais dans la classe HeroSprite. J’ai demandé de l’aide à Monsieur Merry, ce qui m’a permis de finir l’exercice 15. J’ai également été bloqué sur l’exercice 16, car je n’arrivais pas à faire bouger le personnage. Étant chez moi sans professeur pour m’aider, j’ai donc arrêté pour la journée. Le lendemain (samedi), j’ai repris et compris que mon problème venait du fait que j’instanciais un étage vide, sans salle. Ainsi, lors de l’appel de setEtageCourant dans Core, la boucle while s’arrêtait. J’ai donc sauvegardé les salles courantes dans l’étage et ajouté la méthode setCoordonnee dans Dessin.sprites() afin de rafraîchir la position des images. Par la suite, j’ai également rencontré un problème : le personnage ne pouvait pas monter ou descendre entre les étages. Cela était dû à un mauvais retour de la méthode “suivante”, qui renvoyait une salle de type Normal au lieu d’une salle de type Escalier. Pour résoudre cela, j’ai modifié l’énumération de Direction et adapté les méthodes concernées. Le lendemain (dimanche), j’ai rencontré un autre problème avec l’exercice 20 : une exception était levée lorsque je chargeais l’étage 2, alors qu'il était censé être valide. En parcourant le fichier de cet étage, je me suis rendu compte qu’il y avait des salles avec des coordonnées x à 0, alors que j’étais persuadé qu’une salle n’était pas valide si ses coordonnées en x étaient inférieures à 1. J’avais codé ma méthode “estDansPlateau” en conséquence. Pour régler le problème, j’ai simplement modifié cette méthode.


---


<a name="lundi-9-septembre-2024"></a>
## <span style="color:#5b91fc">Lundi 9 septembre 2024</span>


### 11ème session : 2h


- **Ce que j’ai réalisé :**  
Lors de la 11ᵉ séance, j'ai commencé à coder l'exercice 21. N'ayant pas eu le temps de le terminer pendant la séance, je l'ai finalisé chez moi le soir. J'ai également aidé Tim et Caroline avec l'exercice 16 durant cette séance.


- **Difficultés rencontrées et solutions apportées :**  
J’ai eu du mal à comprendre l’énoncé de l’exercice 21, j’ai donc demandé de l’aide à Monsieur Sopena. Après cela, bien que j’aie compris la consigne, je ne trouvais pas comment la mettre en œuvre dans le code. Je n’ai donc pas réussi à finir l’exercice durant la séance. Une fois chez moi, j’ai été confronté à un autre problème. En effet, le héros se déplaçait bien de manière fluide, mais les monstres apparaissaient tous dans la salle de coordonnées (1,1), alors qu’ils devraient normalement apparaître aléatoirement dans le labyrinthe. En relisant mon code, je me suis rendu compte que j’avais oublié de multiplier les positions par l’unité dans le constructeur de ASprite.




---


<a name="mercredi-11-septembre-2024"></a>
## <span style="color:#5b91fc">Mercredi 11 septembre 2024</span>


### 12ème session : 2h


- **Ce que j’ai réalisé :**  
Lors de la 12ᵉ séance, j'ai mis en place l’éclairage autour du héros (exercice 22) et j’ai aussi aidé Caroline et Tim pour l’exercice 16. Durant le week-end suite à cette séance j’ai corrigé quelques bugs ( les escalier montant et descendant se transformer en salle normale quand j’allais dessus )


- **Difficultés rencontrées et solutions apportées :**  
Je n’ai pas eu de difficultés particulière durant cette séance.
---


<a name="mardi-17-septembre-2024"></a>
## <span style="color:#5b91fc">Mardi 17 septembre 2024</span>


### 13ème session : 2h


- **Ce que j’ai réalisé :**  
Lors de la 13ᵉ séance, j'ai ajouté de la JavaDoc et aidé Caroline. Le lendemain (mercredi 18 septembre), j'ai continué à ajouter de la JavaDoc et j'ai également réalisé le diagramme final en spécification complète du paquet "personnage".


- **Difficultés rencontrées et solutions apportées :**  
Je n’ai pas eu de difficultés particulière durant cette séance.

