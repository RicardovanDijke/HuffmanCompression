/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmandecoder;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pajama Sammy
 */
public class HuffmanDecoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        BufferedReader br;
        StringBuilder text = new StringBuilder();
        String treePath;

        Map<String, Character> treeDataLines = new HashMap<>();
        do
        {
            System.out.println("Enter the Tree data file path");

            br = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                treePath = br.readLine();

                BufferedReader reader = new BufferedReader(new FileReader(treePath));

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    String[] data = line.split(":");
                    for (int i = 0; i < data.length; i = i + 2)
                    {
                        String integer = data[i];
                        char charInt = (char) Integer.parseInt(data[i]);
                        System.out.println(charInt);
                        treeDataLines.put(data[i + 1], charInt);
                    }
                }
                break;
            }
            catch (IOException ex)
            {
                System.err.println("invalid path, please enter again");
                System.err.println(ex);
            }
        }
        while (true);

        String dataPath;

        do
        {
            System.out.println("Enter the binary file path");
            br = new BufferedReader(new InputStreamReader(System.in));

            try
            {
                dataPath = br.readLine();

                DataInputStream reader = new DataInputStream(new FileInputStream(dataPath));

                while (reader.available() > 0)
                {
                    try
                    {
                        char character = (char) reader.read();
                        text.append(character);
                    }
                    catch (IOException ioEx)
                    {
                        System.err.println("Something went wrong reading the binary file");
                        System.err.println(ioEx);
                    }
                }
                break;
            }
            catch (IOException ex)
            {
                System.err.println("invalid path, please enter again");
                System.err.println(ex);
            }
        }

        while (true);

        System.out.println(text.toString());

        StringBuilder code = new StringBuilder();
        StringBuilder decodedText = new StringBuilder();
        for (Character c : text.toString().toCharArray())
        {
            code.append(c);
            //System.out.println(code);
            for (Map.Entry<String, Character> entry : treeDataLines.entrySet())
            {
                if (entry.getKey().equals(code.toString()))
                {
                    decodedText.append(entry.getValue());
                    code = new StringBuilder();
                }
            }
        }

        BufferedOutputStream outputWriter;
        try
        {
            outputWriter = new BufferedOutputStream(new DataOutputStream(new FileOutputStream("C:/Data/Output.txt")));
            for (char character : decodedText.toString().toCharArray())
            {
                outputWriter.write(character);
            }
            outputWriter.close();
        }
        catch (FileNotFoundException ex)
        {
            System.err.println(ex);
        }
        catch (IOException ex)
        {
            System.err.println(ex);
        }
    }

}
