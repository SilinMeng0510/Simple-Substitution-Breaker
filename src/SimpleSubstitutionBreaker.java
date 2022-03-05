import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SimpleSubstitutionBreaker {
    static String key;
    public static void main(String[] args) {
        // Taking the ciphertext
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter Ciphertext: ");
        String ciphertext = s.nextLine().replaceAll(" ", "").toUpperCase();
        System.out.println("Ciphertext: " + ciphertext);

        // Calculating the frequency
        Map<String, Integer> frequencyMap = new TreeMap<>();
        for(int i = 0; i < ciphertext.length(); i ++){
            String str = ciphertext.substring(i, i+1);
            if (frequencyMap.containsKey(str)){
                frequencyMap.put(str, frequencyMap.get(str) + 1);
            }
            else {
                frequencyMap.put(str, 1);
            }
        }

        // Loop til user get the right key
        boolean done = false;
        while(!done){
            boolean valid = false;
            while(!valid){
                for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                    System.out.print("Character: " + entry.getKey() + " Frequency: " + entry.getValue() + ".    ");
                }
                System.out.println("");
                System.out.println("Please Enter Your Key: ");
                key = s.nextLine().toUpperCase();
                if (key.length() == 26){
                    valid = true;
                }
                else{
                    System.out.println("Invalid Input");
                }
            }
            Map<String, String> keyMap = new TreeMap<>();
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String plaintext = "Plaintext: \n";
            for (int i = 0; i < characters.length(); i++){
                keyMap.put(characters.substring(i, i+1), key.substring(i, i+1));
            }
            for (int i = 0; i < ciphertext.length(); i++){
                plaintext +=  keyMap.get(ciphertext.substring(i, i+1));
            }
            System.out.println(plaintext);

            System.out.println("Enter Y If You Are Done: ");
            String respond = s.nextLine().toUpperCase();
            if (respond.equals("Y"))
                done = true;
        }
    }
}
