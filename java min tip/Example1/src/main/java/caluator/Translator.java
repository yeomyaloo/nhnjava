package caluator;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Translator {

    public static void main(String[] args) {
        String s = "10 +-2 = 10+ -2 = 10+-2";
        int i = 0;
        ArrayList<String> tokens;
        StringBuilder stringBuilder = new StringBuilder();

        while (i < s.length()) {
            switch (s.charAt(i)) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9: {

                    stringBuilder.append(s.charAt(i));
                    i++;
                }
                case "-": {
                    if((tokens.size()) == 0)
                        || tokens.get(tokens.size() -1).equals("(")
                        || tokens.get(tokens.size() -1).equals("*")
                        || tokens.get(tokens.size() -1).equals("-")
                        || tokens.get(tokens.size() -1).equals("/")
                        || tokens.get(tokens.size() -1).equals("*"))
                    }

                }

            }
        }

    }
}

