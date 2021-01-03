# Correction

Attention à la gestion de la base de données, clairement ce n'est pas maitrisé. La facon dont vos accès sont implementés feraient planter
le service s'il y a trop de documents en base de données.
Pareil pour trouver un document on fait une recherche en base on ne filtre pas dans le code la liste de résultats.

Si je reprends votre code pour récupérer 1 page e 10 éléments : 
```java
public final DocumentRepository documentRepository;

    public List<Document> findAll(){
        // Charge toute la liste des documents en mémoire 1 accès base
        return this.documentRepository.findAll();
    }
    
    public List<Document> getListOnPageNumber(int pageSize, int page){
        // Charge toute la liste des documents en mémoire 1 accès base
        int documentsSize = this.documentRepository.findAll().size();
        List<Document> documents = new ArrayList<>();
        int i = 0;
        int j = page;
        while (i < pageSize){
            // Pareil recharge la liste en mémoire à chaque boucle !!!!!
            documents.add(findAll().get(j));
            j++; i++;
        }
        return documents;
    }

    public JSONObject createJsonWithDocumentsDetails(int page, int pageSize){
        List<Document> documents = getListOnPageNumber(pageSize, page);
        JSONObject json = new JSONObject();
        json.put("page", page);
        json.put("nbElements", documents.size());
        json.put("data", documents);
        return json;
    }
    
    
    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        scratch.createJsonWithDocumentsDetails(0, 10);
    }
```
Ici on charge 11 fois la liste entière de documents à partir de la base

Clairement beaucoup de concept de programmation ne sont pas maitrisés, attention si vous souhaitez vous orienter vers du technique il va falloir revoir les bases.
