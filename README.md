# 🏥 Hôpital Connecté

## Description

Hôpital Connecté est une application Java développée avec Swing permettant de simuler la gestion d'objets médicaux connectés.

L'application permet :

- La gestion de plusieurs capteurs médicaux.
- La simulation de mesures en temps réel.
- Le suivi de l'état des capteurs.
- La gestion des abonnements des objets connectés.
- La détection d'alertes lorsque les valeurs mesurées dépassent les seuils définis.

---

## Fonctionnalités

### Capteurs disponibles

- Tensiomètre
- Glucomètre
- Balance connectée

### Gestion des mesures

Chaque capteur génère des valeurs simulées :

| Capteur | Valeurs simulées |
|----------|----------------|
| Tensiomètre | 90 à 140 |
| Glucomètre | 70 à 180 |
| Balance | 40 à 120 |

### Gestion des alertes

Une alerte est générée lorsque :

- la valeur est inférieure au seuil minimum ;
- la valeur est supérieure au seuil maximum.

### Gestion des abonnements

L'utilisateur peut :

- activer un abonnement ;
- désactiver un abonnement ;
- sauvegarder l'état des abonnements dans un fichier texte.

---

## Architecture du projet

```
src/
│
├── controleur/
│   └── ControleurCapteur.java
│
├── model/
│   ├── ObjetConnecte.java
│   ├── Tensiometre.java
│   ├── Glucometre.java
│   └── Balance.java
│
├── service/
│   └── ServiceAbonnement.java
│
├── Vue/
│   ├── FenetreAccueil.java
│   ├── FenetreCapteur.java
│   ├── FenetreAbonnement.java
│   ├── PanelCapteur.java
│   └── PanelAbonnement.java
│
└── Main.java
```

---

## Technologies utilisées

- Java
- Java Swing
- Programmation orientée objet (POO)
- Architecture MVC

---

## Lancement du projet

### Prérequis

- JDK 17 ou supérieur
- VS Code ou tout autre IDE Java

### Exécution

Compiler puis lancer :

```bash
javac src/**/*.java
java Main
```

Ou exécuter directement la classe :

```bash
Main.java
```

---

## Auteur

**Chayma Mrait**

Projet réalisé dans le cadre d'un travail universitaire sur les objets connectés et la gestion des abonnements dans un environnement hospitalier.
