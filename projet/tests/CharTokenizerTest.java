import java.util.Arrays;
public class CharTokenizerTest {
    public static void check(boolean condition , String message){
        if(!condition){
            throw new AssertionError(message);
        }
    }

    public static void main(String[] args){
        String known = "chat é😁\n";
        CharTokenizer tokenizer = new CharTokenizer(known);
        check((tokenizer.decode(tokenizer.encode(known)).equals(known)), "Round trip Unicode");
        check(tokenizer.encode("😁").length == 1, "Emoji encode comme un point de code");
        check(Arrays.equals(tokenizer.encode("?"),new int[]{0}), "Inconnue encode en 0");
        check(tokenizer.decode(new int[]{0}).equals("\uFFFD"),"Marqueur Inconnue");
        CharTokenizer other = new CharTokenizer("\n😁é tahc");
        check(Arrays.equals(tokenizer.encode(known),other.encode(known)), "Ids déterministes");
        check(tokenizer.encode("").length == 0, "texte vide");
        boolean rejected = false;
        try{
            tokenizer.decode(new int[]{tokenizer.size()});
        }
        catch(IllegalArgumentException expected){ rejected = true;}
        check(rejected, "ID invalide refusé");
        System.out.println("Ok : Tests Passés");
    }
}
