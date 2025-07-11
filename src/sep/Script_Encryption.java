package sep;

public class Script_Encryption {
	// Encrypts method
    public static String encrypt(String input, String key) {
        StringBuilder st = new StringBuilder();
        String result = "";
        st.insert(0, input);
        int row = 0;
        if (st.length() % 5 > 0) {
            row = (st.length() / 5) + 1;
        } else if (st.length() % 5 == 0) {
            row = st.length() / 5;
        }
        char[][] encryptChar = new char[row][5];
        char[] tempArray = new char[st.length()];
        for (int i = 0; i < tempArray.length; i++) {
            if (st.charAt(i) == ' ') {
                tempArray[i] = '-';
            } else {
                tempArray[i] = st.charAt(i);
            }
        }
        int count = 0;
        for (int i = 0; i < encryptChar.length; i++) {
            for (int j = 0; j < encryptChar[i].length; j++) {
                if (count < tempArray.length) {
                    encryptChar[i][j] = tempArray[count];
                    count++;
                } else {
                    encryptChar[i][j] = '-';
                    count++;
                }
            }
        }
        System.out.println("ENCRYPTION SCRIPT");
        System.out.println("Password input: " + input);
        System.out.println("Start encryption (permutation):");
        for (int i = 0; i < encryptChar.length; i++) {
            for (int j = 0; j < encryptChar[i].length; j++) {
                System.out.print(encryptChar[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < row; j++) {
                result += encryptChar[j][i];
            }
        }
        System.out.println("Permutation results: " + result);
        String encryptedXORResult = xOr(result.trim(), key);
        System.out.println("Encrypted: " + encryptedXORResult);
        return encryptedXORResult;
    }
    // Decrypts method
    public static String decrypt(String input, String key) {
        String xoredDecryptedInput = xOr_decrypt(input, key);
        
        StringBuilder st = new StringBuilder();
        String result = "";
        st.insert(0, xoredDecryptedInput);
        
        int column = 0;
        if (st.length() % 5 > 0) {
            column = (st.length() / 5) + 1;
        } else if (st.length() % 5 == 0) {
            column = st.length() / 5;
        }
        
        char[][] decryptChar = new char[5][column];
        char[] tempArray = new char[st.length()];
        for (int i = 0; i < tempArray.length; i++) {
            if (st.charAt(i) == '-') { 
                tempArray[i] = ' ';
            } else {
                tempArray[i] = st.charAt(i);
            }
        }
        int count = 0;
        for (int i = 0; i < decryptChar.length; i++) {
            for (int j = 0; j < decryptChar[i].length; j++) {
                if (count < tempArray.length) {
                    decryptChar[i][j] = tempArray[count];
                    count++;
                } else {
                    decryptChar[i][j] = ' ';
                    count++;
                }
            }
        }
        System.out.println("DECRYPTION SCRIPT");
        System.out.println("Password input: " + xoredDecryptedInput);
        System.out.println("Start decryption (inverse permutation):");
        for (int i = 0; i < decryptChar.length; i++) {
            for (int j = 0; j < decryptChar[i].length; j++) {
                System.out.print(decryptChar[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < 5; j++) {
                result += decryptChar[j][i];
            }
        }
        System.out.println("Reverse permutation result " + result);
        return result.trim();
    }
    // XOR encryption method
    public static String xOr(String input, String pass) {
        StringBuilder hexResult = new StringBuilder();
        int inputLen = input.length();
        int passLen = pass.length();

        for (int i = 0; i < inputLen; i++) {
            char inputChar = input.charAt(i);
            char passChar = pass.charAt(i % passLen);
            
            byte xoredByte = (byte) (inputChar ^ passChar);
            
            hexResult.append(String.format("%02X", xoredByte));
        }
        return hexResult.toString();
    }
    // XOR decryption method
    public static String xOr_decrypt(String hexInput, String pass) {
        StringBuilder decryptedResult = new StringBuilder();
        int passLen = pass.length();

        byte[] hexBytes = hexStringToByteArray(hexInput);

        for (int i = 0; i < hexBytes.length; i++) {
            byte xoredByte = hexBytes[i];
            char passChar = pass.charAt(i % passLen);
            

            char originalChar = (char) (xoredByte ^ passChar);
            decryptedResult.append(originalChar);
        }
        return decryptedResult.toString();
    }
    // Converts a hex string to a byte array
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}