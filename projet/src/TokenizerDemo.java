import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class TokenizerDemo {
    public static void main(String[] args) throws Exception{
        Path path = Path.of("projet/data","corpus.txt");
        String text = Files.readString(path, StandardCharsets.UTF_8);
        int[] points = text.codePoints().toArray();
        if(points.length<20){
             throw new IllegalArgumentException("Ajoute au moins 20 caracteres au corpus.");
        }

        int split = (int)(points.length*0.9);
        String trainText = new String(points,0,split);
        String validationText = new String(points,split,points.length-split);
        CharTokenizer tokenizer= new CharTokenizer(trainText);

        String example = "le chat";
        int[] tokens = tokenizer.encode(example);
        System.out.println("Corpus lu: "+path.toAbsolutePath());
        System.out.println("Caractere train: "+trainText.codePointCount(0, trainText.length()));
        System.out.println("Caracteres validation : " + validationText.codePointCount(0, validationText.length()));
        System.out.println("Taille du vocabulaire : " + tokenizer.size());
        System.out.println("Texte : " + example);
        System.out.println("IDs : " + Arrays.toString(tokens));
        System.out.println("Retour au texte : " + tokenizer.decode(tokens));
        int unknowns = 0;
        for(int id : tokenizer.encode(validationText)){
            if(id==0) unknowns++;
        }
        System.out.println("Tokens inconnus dans la validation : " + unknowns);
    }    
}
