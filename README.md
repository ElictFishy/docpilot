# DocPilot

DocPilot est un projet de modèle de langage développé en Java. Il vise à construire et entraîner un petit Transformer à partir de poids aléatoires, puis à générer du texte avec les paramètres appris.

L'objectif est de comprendre chaque étape du fonctionnement d'un modèle de langage et de faire évoluer progressivement le projet vers des échanges simples.

## Objectifs

- Préparer un corpus et construire un tokenizer.
- Implémenter un moteur de différentiation automatique.
- Construire un Transformer avec attention causale.
- Entraîner le modèle avec la prédiction du prochain token.
- Évaluer les résultats sur des données distinctes du corpus d'entraînement.
- Sauvegarder les poids et générer du texte.
- Explorer ensuite l'entraînement sur des données de dialogue.

## Approche technique

Le premier moteur sera écrit en Java, sans API de génération ni poids préentraînés. Il reposera sur des embeddings entraînables, une attention multi-têtes, un réseau de projections et un optimiseur Adam.

La priorité est une implémentation lisible, testable et reproductible. La taille du modèle et ses capacités évolueront à partir des résultats mesurés.

## Organisation

Le développement de l'application se fait dans `projet/`. La documentation de cadrage se trouve dans `projet/docs/objectif.md`.

Le code source, les tests et les rapports d'expériences seront ajoutés au fil du développement.

## Prérequis

- JDK 21 ou supérieur.
- Git.

Les commandes de compilation et d'exécution seront documentées avec l'implémentation.

## État du projet

Le projet est en phase de cadrage. Le tokenizer, le moteur d'apprentissage et le modèle restent à implémenter dans ce dépôt.

Il ne s'agit pas encore d'un assistant conversationnel. Les premières versions viseront la génération de texte sur un corpus limité, avant d'aborder le dialogue.
