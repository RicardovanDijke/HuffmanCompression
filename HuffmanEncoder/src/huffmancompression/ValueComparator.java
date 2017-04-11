package huffmancompression;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author Pajama Sammy
 */
// a comparator that compares Strings
class ValueComparator implements Comparator {
	Map map;
 
	public ValueComparator(Map map) {
		this.map = map;
	}
 
        @Override
	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueB.compareTo(valueA);
	}
}