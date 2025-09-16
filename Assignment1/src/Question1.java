import java.util.ArrayList;
import java.util.Comparator;

public class Question1 {

    // We pass the IntegerComparator object defined in main as an argument so it can be accessed by the part() method
	static void sort(ArrayList<Integer> list, Integer left, Integer right, IntegerComparator integerComparator) {
		
		if (right <= left)
			return;
		
		Integer s = part(list, left, right, integerComparator);
	
		sort(list, left, s - 1, integerComparator);
		
		sort(list, s + 1, right, integerComparator);
	}

    // Making use of the IntegerComparator object being passed here for partitioning the data
	static Integer part(ArrayList<Integer> list, Integer left, Integer right, IntegerComparator integerComparator) {
		
		assert(left < right);
		
		Integer i = left - 1, j = right;
		
		for(;;) {

            // Mimic previous comparison behaviour by continuing if compared output is -1
            while (integerComparator.compare(list.get(++i), list.get(right)) < 0)
                ;

            // Similarly mimic previous comparison behaviour by continuing if compared output is -1
            while (integerComparator.compare(list.get(right), list.get(--j)) < 0)
                if (j.equals(left))
                    break;
			
			if (i >= j)
				break; 
			
			swap(list, i, j); 
		
		}
		
		swap(list, i, right);
		
		return i;
	
	}

	static void swap(ArrayList<Integer> list, Integer i, Integer j) {	
		
		Integer h = list.get(i);
		
		list.set(i, list.get(j));
		
		list.set(j, h);
	
	}

	public static void main(String[] args) {
		
		// We test the sorting procedure with a list of random integer objects
		
		Integer n = 100000;
		
		ArrayList<Integer> list = new ArrayList<Integer>();

        // We define an IntegerComparator object to be used for partitioning the data
        IntegerComparator integerComparator = new IntegerComparator();
		
		for (int i = 0; i < n; i++)
			list.add((int) Math.ceil(Math.random() * n));

        // Pass the IntegerComparator object as a parameter for usage by methods within
		sort(list, 0, n-1, integerComparator);

		for (int i = 0; i < n; i++) {
		
			System.out.print(list.get(i) + ", ");
			
			if(i > 0 && i % 20 == 0)
				System.out.println();				
			
		}
		
	}
}

/* A class which compares two integers
 * if x > y returns 1
 * x == y returns 0
 * if x < y returns -1
 */
class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
        return Integer.compare(x, y);
    }
}