# Boby
## Appli 4A

- Application Mobile developpé sur android studio.
- Projet de 4ème année / professeur : M Vincent.
- List de livre de programmation et Mapping

## Sommaire

* [Architecture](#Architecture)
* [Fonctionnalités](#Fonctionnalités)
* [Détail fragment et activité](#Détail-fragment-et-activité)

## Architecture

Application réalisé avec l'architecture Model / View / Controller ,
3 fragment : Book , Map , Smile 
3 Activity : Book , Map , Main avec une Navigation Drawer
personnalisée

 - BookFragment  : écran principale contenant notre Liste de bouquin Recyclerview + Cardview + Gridlayout(3)
     - API = "https://raw.githubusercontent.com/bvaughn/infinite-list-reflow-examples/master/books.json"
     - format .json
     - utilisation de librairie Volley pour le JSON parsing
      -
       -  implementation 'com.android.volley:volley:1.1.1' 
     - utilisation de librairie Glide pour les images
      -
       -  implementation 'com.github.bumptech.glide:glide:4.10.0' 
 - BookActivity : une activitée contenant plus d'information sur le livre cliqué par l'utilisateur
       - Titre
       - publication
       - description / résumé
 - RecyclerViewAdapter
   - liste de livre dans des Cardview et dispatcher par 3
   - setOnclickListener vers BookActivity avec le détail de nos livres
 - Map
    - Google API / accès internet
     
        -  uses-permission android:name="android.permission.INTERNET"
   - dans AndroidManifest.xml ( avant <application ... )
 - AppBar et Naviguation Drawer
 
 ## Fonctionnalités
 
 soon
 
 
 ## Détail fragment et activité
