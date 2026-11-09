import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


public class CharTokenizer{
    public int[] alphabet;
    public Map<Integer,Integer>ids = new HashMap<>();

    public CharTokenizer(String trainText){
        if(trainText.isEmpty()){
            throw new IllegalArgumentException("Le texte d'apprentissage est vide.");
        }
        // 1. Convertir les caracteres en nombres Unicode, puis les trier.
        int[] points = trainText.codePoints().toArray();
        Arrays.sort(points);

        // 2. Compter les caracteres differents pour dimensionner le tableau.
        int count = 0;
        for(int i = 0 ; i<points.length;i++){
            if(i==0 || points[i]!= points[i-1]){
                count++;
            }
        }
        alphabet = new int[count];

         // 3. Copier une seule fois chaque caractere dans l'alphabet.
         int next = 0;
         for(int i = 0 ; i<points.length; i++){
            if(i == 0 || points[i] != points[i-1]){
                alphabet[next] = points[i];
                next++;
            }
         }
        // 4. Associer chaque caractere a son identifiant (0 reste reserve).
         for(int i = 0 ; i< alphabet.length ; i++){
            ids.put(alphabet[i],i+1);
         }
    }

    public int size(){
        return alphabet.length + 1; // l'id 0 est reserve à l'inconnue
    }

    public int[] encode(String texte){
        int[] points = texte.codePoints().toArray();
        int[] result = new int[points.length];
        
        for(int i=0 ; i<result.length;i++){
            Integer id = ids.get(points[i]);
            if(id==null){
                result[i] = 0;
            }
            else result[i] = id;
        }
        return result;
    }

    public String decode(int[] tokens){
        StringBuilder text = new StringBuilder();
        for(int id : tokens){
            if(id >= size() || id<0){
                throw new IllegalArgumentException("Identifiant invalide : " + id);
            }
            if(id==0){
                text.appendCodePoint(0xFFFD);
            }
            else text.appendCodePoint(alphabet[id-1]);
        }
        return text.toString();
    }
}