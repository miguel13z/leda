import java.util.Arrays;

public class RadixSortAsserts {

    private RadixSort sorting = new RadixSort();

    public void radixSort() {
        int[] v;

        v = new int[]{800, 100, 780, 450, 300, 200, 103};
        assert Arrays.equals(sorting.radixSort(v), new int[]{100, 103, 200, 300, 450, 780, 800});

        v = new int[]{2};
        assert Arrays.equals(sorting.radixSort(v), new int[]{2});

        v = new int[]{2, 3, 4, 1, 1, 5, 1, 2, 5};
        assert Arrays.equals(sorting.radixSort(v), new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5});

        v = new int[]{1111, 1111, 1111, 2222, 2222 ,2222};
        assert Arrays.equals(sorting.radixSort(v), new int[]{1111, 1111, 1111, 2222, 2222, 2222});
    }
    
    public void meusTestes() {
    	int[] v;
    	
    	v = new int[] {2314, 2000, 2111};
    	System.out.println(Arrays.toString(sorting.radixSort(v)));
    }

    public static void main(String[] args) {
        RadixSortAsserts t = new RadixSortAsserts();
        t.radixSort();
        //t.meusTestes();
    }
}