# **Journal de bord**


## Lundi 2 septembre 2024:

_( première session : 2h )_



* Ce que j’ai réalisé : 

Lors de cette première session, j’ai préparé mon environnement de travail. Plus précisément, j’ai initialisé le projet Netbeans, le dépôt Git local, et le dépôt GitLab distant. Ensuite, j’ai réalisé la synchronisation avec GitLab et enfin testé le dépôt distant pour la restauration. Par la suite, j’ai réalisé l’exercice 1 et commencé à construire le diagramme en spécification générale des interfaces fournies en annexe ainsi que de l’extrait de code de la boucle principale. N’ayant pas eu le temps de finir durant la session, j’ai terminé ce diagramme ainsi que celui du code initial fourni dans la soirée.



* Difficultés rencontrées et solutions apportées

J’ai rencontré de nombreuses difficultés lors de la préparation de l’environnement. En effet, l’interface graphique de NetBeans spécifique à la gestion de Git (pour initialiser un dépôt Git local, faire des *git push* et des *git clone*) ne fonctionnait pas. J’ai donc demandé de l’aide à l’un de mes camarades, qui m’a montré une autre façon de faire avec les commandes du terminal. J’ai également eu quelques difficultés lors de la réalisation des diagrammes de spécifications générales, notamment lors de la représentation des collections. J’ai donc fait des recherches personnelles dans mes cours du S2 afin de me débloquer.

## Mardi 3 septembre 2024:

_( 2ème, 3ème et 4ème session: 6h )_

* Ce que j’ai réalisé : 

Lors de la deuxième session, j’ai corrigé les erreurs dans mon diagramme UML tout en aidant mes camarades (Tim, Caroline et Jessica) avec le leur. J’ai également aidé une camarade (Jessica) à préparer son environnement de travail. J’ai ensuite réalisé l’exercice 3, qui consistait à coder la classe Salle. Durant la troisième session, j’ai implémenté la méthode "charger" de la classe Etage (exercice 4) et aidé quelques camarades (Tim, Caroline et Jessica) avec l’UML. Enfin, durant la quatrième séance, j’ai partiellement codé la méthode "estAdjacente" de l’exercice 5 et aidé Tim et Caroline avec les exercices précédents. Je me suis également avancé à la maison en terminant l’exercice 5, en effectuant l’exercice 6, ainsi qu'une partie de l’exercice 7.


* Difficultés rencontrées et solutions apportées

Lors de la 2ᵉ session, je n’ai pas rencontré de difficultés particulières. Cependant, j’ai eu des difficultés à réaliser l’exercice 4, qui consistait à implémenter la méthode `charger`. En effet, je n’avais pas compris comment ajouter des salles à un étage, sachant que la classe `Etage` hérite de la classe `ArrayList&lt;ISalle>`. Cela m’a bloqué pendant un certain temps, mais j’ai pu me débloquer après plusieurs recherches personnelles.

Lors de la 4ᵉ séance, j’ai rencontré des difficultés, notamment pour comprendre l’énoncé de l’exercice 5. Pour mieux comprendre, j’ai fait appel à Monsieur Sopena. J’ai également eu du mal à implémenter la méthode `estAdjacente`. En effet, j’avais oublié que la méthode `equals` de la classe `Salle` ne prenait pas en compte le type de la salle, ce qui s’est avéré important pour le bon fonctionnement de la méthode. Cela m’a bloqué un long moment, mais à force de relire mon code, j’ai finalement réussi.

Par la suite, j’ai eu des difficultés lors de la réalisation de l’exercice 6, car je n’arrivais pas à trouver sous quelle forme devait être écrit le lien permettant d’accéder aux fichiers dans le dossier `etages` dans le constructeur de la classe `Labyrinthe`. Étant chez moi à ce moment-là, je ne pouvais pas demander l’aide d’un professeur. J’ai donc essayé plusieurs solutions jusqu’à ce que cela fonctionne.

Enfin, j’ai eu beaucoup de mal à implémenter la méthode `dessin`. En effet, j’ai dû faire de nombreuses recherches sur internet pour comprendre le fonctionnement de JavaFX, que j’utilisais pour la première fois. Je n’ai donc pas pu finir l’exercice 7 ce soir-là.
