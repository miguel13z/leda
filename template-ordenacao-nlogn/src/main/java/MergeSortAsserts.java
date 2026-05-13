import java.util.Arrays;

public class MergeSortAsserts {

	 public static void main(String[] args) {
	        MergeSortAsserts t = new MergeSortAsserts();
	        t.testMergeOrdenadosCrescente();
	        t.testMergeOrdenadosDecrescente();
	        t.testMergeOrdenadosDistintos();
	        t.testMergeSort();
	 }

	 public void testMergeOrdenadosCrescente() {
		 MergeSort sorting = new MergeSort();
		 int[] a;
		 int[] b;
        
        
		 a = new int[] {1, 2, 3, 4, 5};
		 b = new int[] {6, 7, 8, 9, 10};
		 assert Arrays.equals(sorting.mergeOrdenadosCrescente(a, b), new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        
		 a = new int[] {1, 2, 50};
		 b = new int[] {6, 7, 8, 9, 10, 100};
		 assert Arrays.equals(sorting.mergeOrdenadosCrescente(a, b), new int[] {1, 2, 6, 7, 8, 9, 10, 50, 100});
        
		 a = new int[] {0};
		 b = new int[] {-20, -10, -3};
		 assert Arrays.equals(sorting.mergeOrdenadosCrescente(a, b), new int[] {-20, -10, -3, 0});
        
		 a = new int[] {1, 100};
		 b = new int[] {4, 10, 20, 30, 40, 60, 81};
		 assert Arrays.equals(sorting.mergeOrdenadosCrescente(a, b), new int[] {1, 4, 10, 20, 30, 40, 60, 81, 100});
        
		 a = new int[] {10, 20};
		 b = new int[] {0, 3, 1000};
		 assert Arrays.equals(sorting.mergeOrdenadosCrescente(a, b), new int[] {0, 3, 10, 20, 1000});
	 }
	 
	 public void testMergeOrdenadosDecrescente() {
		MergeSort sorting = new MergeSort();
        int[] a;
        int[] b;
        
        
        a = new int[] {5, 4, 3, 2, 1};
        b = new int[] {10, 9, 8, 7, 6};
        assert Arrays.equals(sorting.mergeOrdenadosDecrescente(a, b), new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        
        a = new int[] {50, 2, 1};
		b = new int[] {100, 10, 9, 8, 7, 6};
		assert Arrays.equals(sorting.mergeOrdenadosDecrescente(a, b), new int[] {1, 2, 6, 7, 8, 9, 10, 50, 100});
		
		a = new int[] {0};
		b = new int[] {-3, -10, -20};
		assert Arrays.equals(sorting.mergeOrdenadosDecrescente(a, b), new int[] {-20, -10, -3, 0});
		
		a = new int[] {100, 1};
		b = new int[] {81, 60, 40, 30, 20, 10, 4};
		assert Arrays.equals(sorting.mergeOrdenadosDecrescente(a, b), new int[] {1, 4, 10, 20, 30, 40, 60, 81, 100});
		
		a = new int[] {20, 10};
		b = new int[] {1000, 3, 0};
		assert Arrays.equals(sorting.mergeOrdenadosDecrescente(a, b), new int[] {0, 3, 10, 20, 1000});
	}
	 
	public void testMergeOrdenadosDistintos() {
		MergeSort sorting = new MergeSort();
		int[] a;
        int[] b;
        
        a = new int[] {1, 2, 3, 4, 5};
        b = new int[] {10, 9, 8, 7, 6};
        assert Arrays.equals(sorting.mergeOrdenadosDistintos(a, b), new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        
        a = new int[] {1, 2, 50};
		b = new int[] {100, 10, 9, 8, 7, 6};
		assert Arrays.equals(sorting.mergeOrdenadosDistintos(a, b), new int[] {1, 2, 6, 7, 8, 9, 10, 50, 100});
		
		a = new int[] {0};
		b = new int[] {-3, -10, -20};
		assert Arrays.equals(sorting.mergeOrdenadosDistintos(a, b), new int[] {-20, -10, -3, 0});
		
		a = new int[] {1, 100};
		b = new int[] {81, 60, 40, 30, 20, 10, 4};
		assert Arrays.equals(sorting.mergeOrdenadosDistintos(a, b), new int[] {1, 4, 10, 20, 30, 40, 60, 81, 100});
		
		a = new int[] {10, 20};
		b = new int[] {1000, 3, 0};
		assert Arrays.equals(sorting.mergeOrdenadosDistintos(a, b), new int[] {0, 3, 10, 20, 1000});
	}
	
	public void testMergeSort() {
		 MergeSort sorting = new MergeSort();
		 int[] v;
		 
		 v = new int[] {10, 20, 50, 30, 40, 10};
		 sorting.sort(v, 0, v.length - 1);
		 System.out.println(Arrays.toString(v));
	}
}
