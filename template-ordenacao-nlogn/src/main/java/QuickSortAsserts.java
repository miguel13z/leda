import java.util.Arrays;

public class QuickSortAsserts {

    public static void main(String[] args) {
        QuickSortAsserts t = new QuickSortAsserts();
        t.testMediana();
        t.testSort();
        t.testMedianaDeTres();
    }

    public void testMediana() {
        QuickSort sorting = new QuickSort(); 
        int[] v;

        v = new int[]{1};
        assert sorting.mediana(v) == 1;

        v = new int[]{1, 1, 1};
        assert sorting.mediana(v) == 1;

        v = new int[]{5,1,4,3,2,6,7};
        assert sorting.mediana(v) == 4;

        v = new int[]{5,1,4,3,2,6,7,11,9,8,10};
        assert sorting.mediana(v) == 6;

        v = new int[]{8, 1, 78, 45, 3, 2, 103};
        assert sorting.mediana(v) == 8;
    }

    public void testSort() {
        QuickSort sorting = new QuickSort(); 
        int[] v;

        v = new int[]{8, 1, 78, 45, 3, 2, 103};
        sorting.sort(v, 0, v.length - 1);
        assert Arrays.equals(v, new int[]{1, 2, 3, 8, 45, 78, 103});

        v = new int[]{2};
        sorting.sort(v, 0, v.length - 1);
        assert Arrays.equals(v, new int[]{2});

        v = new int[]{1, 2, 3, -4};
        sorting.sort(v, 0, v.length - 1);
        assert Arrays.equals(v, new int[]{-4, 1, 2, 3});

        v = new int[]{10, 2, 3, 4};
        sorting.sort(v, 0, v.length - 1);
        assert Arrays.equals(v, new int[]{2, 3, 4, 10});
    }	

    public void testMedianaDeTres() {
        QuickSort sorting = new QuickSort(); 
        int[] v;

        v = new int[]{1, 2, 3, 4, 5};
        assert sorting.medianaDeTres(v) == 3;

        v = new int[]{4, 8, 10, 12};
        assert sorting.medianaDeTres(v) == 8;

        v = new int[]{40, 8, 10, 12, 12};
        assert sorting.medianaDeTres(v) == 12;

        v = new int[]{12, 8, 40, 12, 10};
        assert sorting.medianaDeTres(v) == 12;
    }
}