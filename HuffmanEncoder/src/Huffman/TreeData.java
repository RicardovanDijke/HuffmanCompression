package Huffman;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pajama Sammy
 */
public class TreeData implements Serializable
{
    private Map<Integer,String> values = new HashMap<>();
    
    public Map<Integer,String> GetValues()
    {
        return values;
    }
    
    public void AddValue(Integer key ,String value)
    {
        values.put(key,value);
    }
}
