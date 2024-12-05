
# Fiche Projet : Plateforme de Gestion de To-Do Lists

## Contexte

Ce projet consiste à développer une plateforme de gestion de To-Do Lists en utilisant le framework **Grails 5.3.6** avec **Java 1.8**. La plateforme propose une interface d'administration robuste et des fonctionnalités spécifiques, tout en assurant une gestion précise des droits utilisateurs grâce à **Spring Security Core**.

## Objectifs Fonctionnels

1.  **Gestion des Rôles** :

    -   Rôles disponibles : `ROLE_USER` et `ROLE_ADMIN`.
    -   **ADMIN** : Peut créer, lire, modifier, supprimer les
        - Utilisateurs et Rôles associés.
        - To-Do Lists et éléments associés.
    -   **USER** :
        - Peut gérer uniquement ses propres To-Do Lists.
        - Peut accéder et modifier des To-Do Lists partagées avec lui en tant que collaborateur.
2.  **Gestion des To-Do Lists** :

    -   Création, lecture, modification et suppression de To-Do Lists.
    -   Gestion des droits de partage avec d'autres utilisateurs.
    -   Tri des To-Do Lists pour chaque utilisateur.
3.  **Gestion des Éléments de To-Do List** :

    -   Deux types d’éléments :
        -   **WysiwygElement** : Élément contenant du texte enrichi.
        -   **FileElement** : Permet l'upload de fichiers associés à la To-Do List.
    -   Les éléments peuvent être triés dans chaque To-Do List.

## Objectifs Techniques

1.  **Sécurité** :
    -   **Authentification** avec **Spring Security Core** intégré à Grails.
    -   Gestion des permissions pour les différents cas.
2.  **Interface Utilisateur** :
    -   Utilisation d'un template d'admin tel que **[AdminLTE](https://adminlte.io/)** ou **[SBAdmin](https://startbootstrap.com/theme/sb-admin-2)**.
    -   Navigation intuitive avec un menu principal comprenant :
        -   **Utilisateurs** : Gestion des comptes et attribution des rôles.
        -   **To-Do Lists** : Création, visualisation, édition et suppression des To-Do Lists et des éléments.
3.  **Fonctionnalités Avancées** :
    -   **Upload de fichiers** dans les FileElements.
    -   **Partage collaboratif** des To-Do Lists.
    -   **Tri dynamique** des To-Do Lists et de leurs éléments.

## Contraintes de Livraison

-   **Date limite** : 22 décembre à 23h59.
-   **Livraison** : Dépôt du code sur le repository GitHub associé à [cet assignment](https://classroom.github.com/a/H-mAGA3B).  ⚠️ Aucune exception de soumission (pas de livraison par e-mail, pas de retard, prenez les devants).

## Livrables Attendus

1.  **Code source complet** sur le dépôt GitHub associé à [cet assignment](https://classroom.github.com/a/H-mAGA3B).
2.  **Documentation** (README) expliquant :
    -   Configuration du projet.
    -   Instructions pour le déploiement local.
    -   Description des principales fonctionnalités.
3.  **Vidéo de démonstration** présentant les principales fonctionnalités de la plateforme, vous rajouterez le lien de la vidéo dans le README (5 minutes max)

## Critères d'Évaluation

1.  **Interface d'administration**  : Fonctionnement des opérations CRUD sur l'interface d'administration. (sur 25)
2.  **Gestion des Images**  : Bon fonctionnement de l'upload et du stockage côté serveur. (sur 15)
4.  **Readme**  : Clarté du readme. (sur 10)
5.  **Vidéo**  : Qualité de la présentation que vous ferez qui devra être préparée et fluide. (sur 10)
6.  **Finition globale**  : Qualité du code métier et des interfaces. (sur 10)