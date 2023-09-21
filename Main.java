import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Input Offset Character: ");
        Scanner scanner = new Scanner(System.in);
        char offsetCharacter = scanner.nextLine().charAt(0);
        Encoder encoder = new Encoder(offsetCharacter);
        Decoder decoder = new Decoder();
        
        System.out.print("Input All Capital Plaintext: ");
        String plaintext = scanner.nextLine();
        String encoded = encoder.encode(plaintext);
        System.out.println(encoded);
        System.out.println(decoder.decode(encoded));
    }
}
