============= TASK MANAGER =============
- gérer les tasks (ajouter , supprimer , consulter l'historique,...)
- contient réveil pour informer si une tâche est prédefinie ou régulé
- l'utilisateur peut accéder à l'historique des tâches
- l'utilisateur peut importer/exporter des fichiers de taches (peuvent être .json , .csv , ou bient xml)
- l'utilisateur peut supprimer les tâches (system de corbeille , delai de supp = 3 jours)
- chaque tâhe a son importance (1-5) et chaque niveau à ses propres couleurs
- les tâches sont enregistré vers le chemain : C:\users%USERNAME%\appData\MyTachApp

 =========== class Task ===========
    📌 Fonctionnalités principales
		- Gestion des tâches (ajouter, modifier, supprimer)
		- Historique des actions
		- Système de notification (réveil ⏰)
		- Import / Export (JSON, CSV, XML)
		- Corbeille avec suppression différée (3 jours)
		- Gestion de l’importance avec couleurs
		- Stockage local des données
    structure : 
	    - long id;
	    - String title;
	    - String description;
	    - Date createAt;
	    - int importance; // 1..5
	    - Color color;
	    - String status;
	    - Date scheduled;
=== How it works ===
1. créer les fonctions de base : 
