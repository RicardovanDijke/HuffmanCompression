package Huffman;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo van Dijke
 */
public final class HuffmanCoder {

    private HuffmanCoder()
    {
    }

    public static void EncodeData(String text, TreeData treeData, String outPath)
    {
        //converting original text to Treedata type
        StringBuilder data = new StringBuilder();
        for (char c : text.toCharArray())
        {
            //System.out.println(c);
            //System.out.println((int) c);
            //System.out.println(treeData.GetValues().get((int) c));
            data.append(treeData.GetValues().get((int) c));

        }
        System.out.println(data);

        //writing the TreeData object
        BufferedWriter treeWriter;
        try
        {
            treeWriter =new BufferedWriter(new FileWriter(outPath + ".tree"));

            for (Map.Entry<Integer, String> treeDataLine : treeData.GetValues().entrySet())
            {
                Integer charInt = treeDataLine.getKey();
                System.out.println(charInt);

                treeWriter.write(charInt + "");
                treeWriter.write(':');

                treeWriter.write(treeDataLine.getValue());
                treeWriter.write(':');
            }
            treeWriter.close();

        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(HuffmanCoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(HuffmanCoder.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedOutputStream dataWriter;
        try
        {
            dataWriter = new BufferedOutputStream(new DataOutputStream(new FileOutputStream(outPath + ".bin")));
            for (char character : data.toString().toCharArray())
            {
                //System.out.println(character);
                dataWriter.write(character);
            }
            dataWriter.close();

        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(HuffmanCoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(HuffmanCoder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
