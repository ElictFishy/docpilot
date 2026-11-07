# DocPilot — MiniGPT en Java

Créer **son propre petit modèle de langage** et l'entraîner depuis des poids aléatoires, avec du code Java et un calcul CPU local.

## Commencer

Ouvrir `cours/index.html` par double-clic, puis suivre le chapitre 1. Le site fonctionne hors ligne, sans API ni installation. Les liens de référence nécessitent Internet.

- `cours/` : 16 chapitres réécrits autour de l'entraînement, exercices, quiz et jalons Git.
- `projet/` : dossier volontairement vide ; tu y écris le modèle et tu y initialises ton dépôt Git.
- `cours/corriges/minigpt/` : correction Java exécutable à étudier après les exercices.

Le parcours couvre corpus, tokenizer Unicode, softmax, entropie croisée, gradients, moteur d'autodiff, embeddings, attention causale, bloc decoder, SGD/Adam, évaluation, génération et checkpoints. Les deux ateliers du site montrent softmax/température et descente de gradient.

## Échelle et matériel

Le modèle de référence est miniature : un bloc, dimension 12, contexte 8 caractères, trois têtes, 2 448 paramètres sur le corpus fourni. Il apprend et génère, mais ne sait pas tenir une conversation utile. L'objectif est de comprendre et démontrer l'entraînement, pas de reproduire les capacités d'un grand assistant.

Le relevé local a détecté un Core Ultra 5 325, environ 16 Go de RAM et Intel Graphics, sans NVIDIA. Une première expérience de 100 pas a été compilée et exécutée en Java : les détails et les limites sont dans `VALIDATION.md`. Aucune dépendance ML ou GPU n'est nécessaire pour cette correction.

## GitHub

Chaque chapitre comporte les commandes et vérifications Git. Le dépôt conseillé est dans `projet/` seulement, afin de publier ton code, tes tests et tes résultats. Aucun dépôt distant, commit ou push n'a été créé à ta place. Les fichiers de poids et corpus locaux doivent rester ignorés jusqu'à une publication volontaire et autorisée.

Le parcours précédent sur un assistant documentaire a été remplacé : ce n'était pas l'objectif demandé.
