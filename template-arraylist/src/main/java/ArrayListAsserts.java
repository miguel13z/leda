import java.util.Arrays;

public class ArrayListAsserts {

    public static void main(String[] args) {
        ArrayListAsserts t = new ArrayListAsserts();

        t.testIsEmpty();
        t.testLastIndexOf();
        t.testToString();
        t.testArrayListGet();
        t.testArrayListGetFirst();
        t.testArrayListGetLast();
        t.testArrayListIndexOf();
        t.testArrayListRemoveFirst();
        t.testArrayListRemoveLast();
        t.testArrayListRemove();
        t.testArrayListRemoveByValue();
        t.testArrayListAddLast();
        t.testArrayListAddFirst();
        t.testArrayListAdd();
        t.testArrayListSize();

        System.out.println("All tests passed!");
    }

    public void testIsEmpty() {
        ArrayList array = new ArrayList(3);
        assert array.isEmpty();

        array.addFirst(1);
        assert !array.isEmpty();
        array.addFirst(2);
        assert !array.isEmpty();
        array.addFirst(3);
        array.removeFirst();
        assert !array.isEmpty();
        array.removeFirst();
        assert !array.isEmpty();
        array.removeFirst();
        assert array.isEmpty();

        ArrayList arrayWithNoCapacity = new ArrayList(0);
        assert arrayWithNoCapacity.isEmpty();

        ArrayList arrayWithALotOfCapacity = new ArrayList(30);
        assert arrayWithALotOfCapacity.isEmpty();
    }

    public void testLastIndexOf() {
        ArrayList emptyArray = new ArrayList(5);
        assert emptyArray.lastIndexOf(1) == -1;

        ArrayList array = new ArrayList(3);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);

        assert array.lastIndexOf(3) == 2;
        assert array.lastIndexOf(2) == 1;
        assert array.lastIndexOf(1) == 0;

        ArrayList dupli = new ArrayList(4);
        dupli.addLast(1);
        dupli.addLast(1);
        dupli.addLast(1);

        assert dupli.lastIndexOf(1) == 2;

        ArrayList list = new ArrayList(5);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(3);

        assert list.lastIndexOf(3) == 4;
    }

    public void testToString() {
        ArrayList list = new ArrayList(5);

        assert list.toString().equals("");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        assert list.toString().equals("1, 2, 3, 4, 5");

        list.removeFirst();
        list.removeFirst();

        assert list.toString().equals("3, 4, 5");

        list.addLast(10);
        list.addLast(11);

        assert list.toString().equals("3, 4, 5, 10, 11");
    }

    public void testArrayListGet() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.get(0);
            assert false;
        } catch (Exception e) {}

        arrayList.addLast(10);
        arrayList.addLast(20);
        arrayList.addLast(30);
        arrayList.addLast(40);
        arrayList.addLast(50);
        assert arrayList.get(0) == 10;
        assert arrayList.get(1) == 20;

        arrayList.removeFirst();
        arrayList.addLast(60);
        assert arrayList.get(4) == 60;

        try {
            arrayList.get(-1);
            assert false;
        } catch (Exception e) {}

        try {
            arrayList.get(5);
            assert false;
        } catch (Exception e) {}
    }

    public void testArrayListGetFirst() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.getFirst();
            assert false;
        } catch (Exception e) {}

        arrayList.addLast(10);
        assert arrayList.getFirst() == 10;
        arrayList.addLast(20);
        assert arrayList.getFirst() == 10;

        arrayList.addFirst(30);
        assert arrayList.getFirst() == 30;
    }

    public void testArrayListGetLast() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.getLast();
            assert false;
        } catch (Exception e) {}

        arrayList.addLast(10);
        assert arrayList.getLast() == 10;
        arrayList.addLast(20);
        assert arrayList.getLast() == 20;

        arrayList.addFirst(30);
        assert arrayList.getLast() == 20;
    }

    public void testArrayListIndexOf() {
        ArrayList arrayList = new ArrayList(5);
        assert arrayList.indexOf(10) == -1;
        arrayList.addLast(10);
        assert arrayList.indexOf(10) == 0;
        arrayList.addLast(20);
        assert arrayList.indexOf(20) == 1;
        assert arrayList.indexOf(10) == 0;

        arrayList.addLast(10);
        arrayList.addLast(10);
        assert arrayList.indexOf(10) == 0;
    }

    public void testArrayListRemoveFirst() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.removeFirst();
            assert false;
        } catch (Exception e) {}

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);

        assert arrayList.getFirst() == 1;
        assert arrayList.removeFirst() == 1;
        assert arrayList.getFirst() == 2;
        assert arrayList.removeFirst() == 2;
        assert arrayList.getFirst() == 3;
        assert arrayList.removeFirst() == 3;
        assert arrayList.getFirst() == 4;
        assert arrayList.removeFirst() == 4;
        assert arrayList.isEmpty();
    }

    public void testArrayListRemoveLast() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.removeLast();
            assert false;
        } catch (Exception e) {}

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);

        assert arrayList.getLast() == 4;
        arrayList.removeLast();
        assert arrayList.getLast() == 3;
        arrayList.removeLast();
        assert arrayList.getLast() == 2;
        arrayList.removeLast();
        assert arrayList.getLast() == 1;
        arrayList.removeLast();
        assert arrayList.isEmpty();
    }

    public void testArrayListRemove() {
        ArrayList arrayList = new ArrayList(5);

        try {
            arrayList.remove(-1);
            assert false;
        } catch (Exception e) {}

        try {
            arrayList.remove(6);
            assert false;
        } catch (Exception e) {}

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);
        arrayList.addLast(2);

        assert arrayList.indexOf(2) == 1;
        arrayList.remove(1);
        assert arrayList.indexOf(2) == 3;
        assert arrayList.indexOf(1) == 0;
        arrayList.remove(0);
        assert arrayList.indexOf(1) == -1;
        assert arrayList.indexOf(3) == 0;
        arrayList.remove(0);
        assert arrayList.indexOf(3) == -1;
        assert arrayList.indexOf(4) == 0;
        arrayList.remove(0);
        assert arrayList.indexOf(4) == -1;
        assert arrayList.indexOf(2) == 0;
        arrayList.remove(0);
        assert arrayList.indexOf(2) == -1;
        assert arrayList.isEmpty();
    }

    public void testArrayListRemoveByValue() {
        ArrayList arrayList = new ArrayList(5);

        arrayList.removeByValue(5);

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);
        arrayList.addLast(2);

        assert arrayList.getFirst() == 1;
        arrayList.removeByValue(1);
        arrayList.removeByValue(1);
        assert arrayList.getFirst() == 2;
        assert arrayList.indexOf(2) == 0;
        arrayList.removeByValue(2);
        assert arrayList.indexOf(2) == 2;
        arrayList.removeByValue(3);
        arrayList.removeByValue(4);
        assert arrayList.getFirst() == 2;
        arrayList.removeByValue(2);
        assert arrayList.isEmpty();
    }

    public void testArrayListAddLast(){
        ArrayList arrayList = new ArrayList(5);
        assert arrayList.isEmpty();
        assert arrayList.size() == 0;

        arrayList.addLast(12);
        assert !arrayList.isEmpty();
        assert arrayList.getFirst() == 12;
        assert arrayList.getLast() == 12;
        assert arrayList.size() == 1;

        arrayList.addLast(20);
        assert arrayList.getFirst() == 12;
        assert arrayList.getLast() == 20;
        assert arrayList.size() == 2;

        arrayList.addLast(30);
        arrayList.addLast(40);
        assert arrayList.getFirst() == 12;
        assert arrayList.getLast() == 40;
        assert arrayList.size() == 4;

        arrayList.addLast(50);
        assert arrayList.getLast() == 50;
        assert arrayList.size() == 5;

        arrayList.addLast(60);
        assert arrayList.getLast() == 60;
        assert arrayList.size() == 6;
    }

    public void testArrayListAddFirst(){
        ArrayList arrayList = new ArrayList(5);       
        assert arrayList.isEmpty();
        assert arrayList.size() == 0;

        arrayList.addFirst(50);
        assert arrayList.getFirst() == 50;
        assert arrayList.size() == 1;

        arrayList.addFirst(40);
        arrayList.addFirst(30);
        assert arrayList.getFirst() == 30;
        assert arrayList.size() == 3;

        arrayList.addFirst(20);
        assert arrayList.getFirst() == 20;
        assert arrayList.size() == 4;

        arrayList.addFirst(10);
        assert arrayList.getFirst() == 10;
        assert arrayList.size() == 5;

        arrayList.addFirst(5);
        assert arrayList.getFirst() == 5;
        assert arrayList.size() == 6;
    }

    public void testArrayListAdd(){
        ArrayList arrayList = new ArrayList(5);
        assert arrayList.isEmpty();
        assert arrayList.size() == 0;

        try {
            arrayList.add(-1, 12);
            assert false;
        } catch (Exception e) {}

        try {
            arrayList.add(7, 12);
            assert false;
        } catch (Exception e) {}

        arrayList.add(0, 12);
        assert arrayList.getFirst() == 12;
        assert arrayList.size() == 1;

        arrayList.add(1, 20);
        assert arrayList.getLast() == 20;
        assert arrayList.size() == 2;

        arrayList.add(2, 30);
        assert arrayList.getLast() == 30;
        assert arrayList.size() == 3;

        arrayList.add(2, 25);
        assert arrayList.get(2) == 25;
        assert arrayList.getLast() == 30;
        assert arrayList.size() == 4;

        arrayList.add(0, 5);
        assert arrayList.getFirst() == 5;
        assert arrayList.getLast() == 30;
        assert arrayList.size() == 5;

        arrayList.add(2, 15);
        assert arrayList.getFirst() == 5;
        assert arrayList.getLast() == 30;
        assert arrayList.size() == 6;
    }

    public void testArrayListSize(){
        ArrayList arrayList = new ArrayList(5);
        assert arrayList.isEmpty();
        assert arrayList.size() == 0;

        arrayList.addFirst(5);
        assert arrayList.size() == 1;

        arrayList.removeFirst();
        assert arrayList.size() == 0;

        arrayList.addFirst(4);
        arrayList.addFirst(3);
        arrayList.addFirst(2);
        arrayList.addFirst(1);
        assert arrayList.size() == 4;

        arrayList.addFirst(0);
        assert arrayList.size() == 5;
    }
}