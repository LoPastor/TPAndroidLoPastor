Rendu des TP 1 à 3 d'Android, crées et réalisés par PASTOR Loïc


Bilan TP1 : 

la calculatrice est implémentée, les calculs simples se font sans problèmes.

Ce qu'il faut améliorer :

- les opérations à la suite (1+2+3) font que seul le 1er et dernier chiffre ne se répètereont pas
Dans cet exemple, au lieu de faire 1 + 2 + 3, il fera 1 + 2 + 2 + 3 ;
le problème vient du fait que je parcoure ma chaîne de caractère lettre par lettre
Si je pouvais supprimer les nombres déjà utilisé, le problème serait résolu, mais 
le fait que je fasse le parcours dans une boucle m'empèche de bien le faire.
- Les parenthèses ne sont pas implémentés dans le code ; à ne pas utiliser.

Bilan TP3 :

J'arrive à accéder aux données de l'API sans problèmes.
