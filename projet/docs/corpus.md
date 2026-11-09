# Corpus de démarrage

Le corpus de démonstration du chapitre 3 se trouve dans `projet/data/corpus.txt`. Le programme `TokenizerDemo` lit ce fichier en UTF-8 depuis la racine de DocPilot. Le corpus est conservé localement et ignoré par Git.

Le programme découpe les 304 points de code dans leur ordre d'origine. Il utilise les 273 premiers pour préparer le vocabulaire et garde les 31 derniers pour la validation. Le vocabulaire comprend 26 caractères distincts issus de la première partie, plus l'ID `0` réservé aux caractères inconnus.

Lors de l'essai, `le chat` a donné `[15, 9, 3, 7, 12, 5, 22]`, puis le décodage a restitué `le chat`. Tous les caractères de la partie validation étaient déjà présents dans le vocabulaire. Les tests du tokenizer ont aussi passé, notamment l'aller-retour Unicode, le traitement des caractères inconnus et le rejet d'un ID hors limites.

Ce petit corpus sert à vérifier la conversion entre texte et IDs. Les résultats mesurent le fonctionnement du tokenizer sur cet exemple.
