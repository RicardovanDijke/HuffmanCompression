/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
