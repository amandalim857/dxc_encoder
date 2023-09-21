import java.util.HashMap;
public class Encoder {

    private Character offsetCharacter;
    private IndexCharacterMap indexCharMap;

    Encoder(Character offsetCharacter) {
        this.indexCharMap = new IndexCharacterMap();
        if (!indexCharMap.containsKey(offsetCharacter)) {
            System.out.println("Offset Character is not valid");
            System.exit(1);
        }
        this.offsetCharacter = Character.toUpperCase(offsetCharacter);
    }

    public String encode(String plainText) {
        StringBuilder encodedString = new StringBuilder();
        encodedString.append(offsetCharacter);
        for (int i = 0; i < plainText.length(); i++) {
            if (indexCharMap.getIndex(plainText.charAt(i)) == null) {
                encodedString.append(plainText.charAt(i));
            } else {
                int newIndex = indexCharMap.getIndex(plainText.charAt(i)) - indexCharMap.getIndex(offsetCharacter);
                if (newIndex < 0) {
                    newIndex = 44 + newIndex;
                }
                encodedString.append(indexCharMap.getCharacter(newIndex));
            }
        }
        return encodedString.toString();
    }
}