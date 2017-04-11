package Huffman;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Pajama Sammy
 */
public class HuffmanTreeBuilder {
    public TreeData treeData = new TreeData();

    private Map.Entry<Character,Integer> firstChar;
    public HuffmanTree buildTree(Map<Character, Integer> charFreqs)
    {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();

        boolean firstEntry = true;
        for (Map.Entry<Character, Integer> i : charFreqs.entrySet())
        {
           if (firstEntry)
            {
                firstEntry = false;
                firstChar = i;
            }
            else
            {
                trees.offer(new HuffmanLeaf(i.getValue(), i.getKey()));
            }
        }

      //  trees.offer(new HuffmanLeaf())
        assert trees.size() > 0;

        System.out.println("=====Starting sort=====");
        while (trees.size() > 1)
        {
            HuffmanTree tree1 = trees.poll();
            HuffmanTree tree2 = trees.poll();
            trees.offer(new HuffmanNode(tree1, tree2));

            //This is for debugging only
            if (false)
            {
                Iterator it = trees.iterator();

                while (it.hasNext())
                {
                    Object o = it.next();
                    if (o instanceof HuffmanTree)
                    {
                        HuffmanTree tree = (HuffmanTree) o;
                        System.out.println(tree.frequency);
                    }
                    else if (o instanceof HuffmanLeaf)
                    {
                        HuffmanLeaf leaf = (HuffmanLeaf) o;
                        System.out.println(leaf.frequency + " + " + leaf.value);
                    }
                }
            }
        }

                trees.offer(new HuffmanLeaf(firstChar.getValue(), firstChar.getKey()));
           HuffmanTree tree1 = trees.poll();
            HuffmanTree tree2 = trees.poll();
            trees.offer(new HuffmanNode(tree1, tree2));
        return trees.poll();
    }

    public void fillTreeData(HuffmanTree tree, StringBuilder prefix)
    {
        assert tree != null;
        if (tree instanceof HuffmanLeaf)
        {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            treeData.AddValue((int) leaf.value, prefix.toString());
            //treeData..add( + ":" + prefix + "\n");
            //System.out.println((int)leaf.value + "\t" + leaf.frequency + "\t" + prefix + "\n");

        }
        else if (tree instanceof HuffmanNode)
        {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            fillTreeData(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            fillTreeData(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public void encodeText(String text)
    {

    }

}
