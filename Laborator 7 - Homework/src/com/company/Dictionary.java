package com.company;
import java.io.*;

public class Dictionary {
    public boolean isWord(String str) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Laborator 7 - Homework\\src\\com\\company\\Words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int count =0;
                if(line.length() == str.length())
                {
                    for(int i = 0; i < str.length(); i++) {
                        char c = str.charAt(i);
                        if (line.toLowerCase().indexOf(c) == -1) {
                            break;
                        }
                        else
                        {
                            count = count+1;
                        }
                    }
                    if(count == str.length())
                        return true;
                }
            }
        }
       return false;
    }
}
