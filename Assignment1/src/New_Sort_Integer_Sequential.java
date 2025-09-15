import java.util.ArrayList;

public class New_Sort_Integer_Sequential {

	static void sort(ArrayList<Integer> list, Integer left, Integer right) {
		
		if (right <= left)
			return;
		
		Integer s = part(list, left, right);
	
		sort(list, left, s - 1);
		
		sort(list, s + 1, right);
	
	}

	static Integer part(ArrayList<Integer> list, Integer left, Integer right) {
		
		assert(left < right);
		
		Integer i = left - 1, j = right;
		
		for(;;) {
		
			while (compare(list.get(++i), list.get(right)))
				; 
			
			while (compare(list.get(right), list.get(--j)))
				if (j.equals(left))
					break; 
			
			if (i >= j)
				break; 
			
			swap(list, i, j); 
		
		}
		
		swap(list, i, right);
		
		return i;
	
	}

	static boolean compare(Integer x, Integer y) {
		
		return x < y;
	
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
		
		for (int i = 0; i < n; i++)
			list.add((int) Math.ceil(Math.random() * n));

		sort(list, 0, n-1);

		for (int i = 0; i < n; i++) {
		
			System.out.print(list.get(i) + ", ");
			
			if(i > 0 && i % 20 == 0)
				System.out.println();				
			
		}
		
	}
}