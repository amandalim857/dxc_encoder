public class Decoder {
    public String decode(String encodedString) {
        IndexCharacterMap indexCharMap = new IndexCharacterMap();
        StringBuilder decodedString = new StringBuilder();
        int offset = indexCharMap.getIndex(encodedString.charAt(0));
        for (int i = 1; i < encodedString.length(); i++) {
            if (indexCharMap.getIndex(encodedString.charAt(i)) == null) {
                decodedString.append(encodedString.charAt(i));
            } else {
                int index = indexCharMap.getIndex(encodedString.charAt(i));
                int newIndex = index + offset;
                if (newIndex > 43) {
                    newIndex = newIndex - (newIndex / 43) * 43 - 1;
                }
                decodedString.append(indexCharMap.getCharacter(newIndex));
            }
        }
        return decodedString.toString();
    }
}