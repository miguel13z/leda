import java.util.Arrays;

public class CountingSortAsserts {

    public void classicCountingSort() {
        CountingSort sorting = new CountingSort();
        int[] v;

        v = new int[]{8, 1, 78, 45, 3, 2, 103};
        assert Arrays.equals(sorting.classicCountingSort(v, 103), new int[]{1, 2, 3, 8, 45, 78, 103});

        v = new int[]{2};
        assert Arrays.equals(sorting.classicCountingSort(v, 2), new int[]{2});

        v = new int[]{10, 2, 3, 4, 1, 1, 5, 1, 2, 10, 5};
        assert Arrays.equals(sorting.classicCountingSort(v, 10), new int[]{1, 1, 1, 2, 2, 3, 4, 5, 5, 10, 10});

        v = new int[]{1, 1, 1, 2, 2 ,2};
        assert Arrays.equals(sorting.classicCountingSort(v, 2), new int[]{1, 1, 1, 2, 2, 2});
    }

    public void zeroCountingSort() {
        CountingSort sorting = new CountingSort();
        int[] v;

        v = new int[]{8, 1, 78, 45, 0, 3, 2, 103};
        assert Arrays.equals(sorting.zeroCountingSort(v, 103), new int[]{0, 1, 2, 3, 8, 45, 78, 103});

        v = new int[]{0};
        assert Arrays.equals(sorting.zeroCountingSort(v, 0), new int[]{0});

        v = new int[]{10, 2, 3, 4, 1, 1, 5, 1, 2, 10, 5, 0, 0};
        assert Arrays.equals(sorting.zeroCountingSort(v, 10), new int[]{0, 0, 1, 1, 1, 2, 2, 3, 4, 5, 5, 10, 10});

        v = new int[]{0, 0, 0};
        assert Arrays.equals(sorting.zeroCountingSort(v, 0), new int[]{0, 0, 0});
    }

    public void negativosCountingSort() {
        CountingSort sorting = new CountingSort();
        int[] v;

        v = new int[]{8, 1, 78, 45, -1, -30, -1, 0, 3, 2, 103};
        assert Arrays.equals(sorting.negativosCountingSort(v, 103), new int[]{-30, -1, -1, 0, 1, 2, 3, 8, 45, 78, 103});

        v = new int[]{-5};
        assert Arrays.equals(sorting.negativosCountingSort(v, -5), new int[]{-5});

        v = new int[]{10, 2, -2, -1, -1, 3, 4, 1, 1, 5, 1, 2, 10, 5, 0, 0};
        assert Arrays.equals(sorting.negativosCountingSort(v, 10), new int[]{-2, -1, -1, 0, 0, 1, 1, 1, 2, 2, 3, 4, 5, 5, 10, 10});
    }

    public static void main(String[] args) {
        new CountingSortAsserts().classicCountingSort();
        new CountingSortAsserts().zeroCountingSort();
        //new CountingSortAsserts().negativosCountingSort();
    	//meusTestes();
    }
    
    public static void meusTestes() {
    	CountingSort sorting = new CountingSort();
    	
    	sorting.zeroCountingSort(new int[] {0, 7, 3, 2}, 7);
    }
}