package huffmancompression;

import Huffman.HuffmanCoder;
import Huffman.HuffmanTree;
import Huffman.HuffmanTreeBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Pajama Sammy
 */
public class HuffmanCompression {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br;
        StringBuilder sb;
        StringBuilder text = new StringBuilder();
        String path;
        do
        {
            System.out.println("Enter the text file path");

            br = new BufferedReader(new InputStreamReader(System.in));
            path = br.readLine();

            try
            {
                br = new BufferedReader(new FileReader(new File(path)));
                break;
            }
            catch (IOException ex)
            {
                System.out.println("invalid path, please enter again");
            }
        }
        while (true);

        Map<Character, Integer> numChars = new HashMap<>();
        int charInt;
        while ((charInt = br.read()) != -1)
        {
            Character character = (char) charInt;

            text.append(character);
            if (!numChars.containsKey(character))
            {
                numChars.put(character, 1);
            }
            else
            {
                numChars.put(character, numChars.get(character) + 1);
            }
        }
        Map<Character, Integer> sortedMap = sortByValue(numChars);
        for (Map.Entry<Character, Integer> i : sortedMap.entrySet())
        {
            System.out.println(i);
        }
        HuffmanTreeBuilder treeBuilder = new HuffmanTreeBuilder();
        HuffmanTree tree = treeBuilder.buildTree(sortedMap);

        treeBuilder.fillTreeData(tree, new StringBuilder(""));

        HuffmanCoder.EncodeData(text.toString(), treeBuilder.treeData, path);
    }

    public static Map sortByValue(Map unsortedMap)
    {
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

}
