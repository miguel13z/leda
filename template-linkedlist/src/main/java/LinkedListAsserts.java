public class LinkedListAsserts {
    
    public void testIsEmpty() {
        LinkedList ll = new LinkedList();

        assert ll.isEmpty();

        ll.addFirst(1);
        assert !ll.isEmpty();

        ll.addFirst(2);
        assert !ll.isEmpty();

        ll.addFirst(3);
        ll.removeFirst();
        assert !ll.isEmpty();

        ll.removeFirst();
        assert !ll.isEmpty();

        ll.removeFirst();
        assert ll.isEmpty();
    }

    public void testLastIndexOf() {
        LinkedList ll = new LinkedList();

        assert ll.lastIndexOf(1) == -1;

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        assert ll.lastIndexOf(3) == 2;
        assert ll.lastIndexOf(2) == 1;
        assert ll.lastIndexOf(1) == 0;

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(1);

        assert ll.lastIndexOf(1) == 2;

        ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(3);

        assert ll.lastIndexOf(3) == 4;
    }

    public void testToString() {
        LinkedList list = new LinkedList();

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

    public void testListGet() {
        LinkedList list = new LinkedList();

        try {
            list.get(0);
            assert false;
        } catch (Exception e) {}

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        assert list.get(0) == 10;
        assert list.get(1) == 20;

        list.removeFirst();
        list.addLast(60);

        assert list.get(4) == 60;

        try {
            list.get(-1);
            assert false;
        } catch (Exception e) {}

        try {
            list.get(5);
            assert false;
        } catch (Exception e) {}
    }


    public void testListGetFirst() {
        LinkedList ll = new LinkedList();

        try {
            ll.getFirst();
            assert false;
        } catch (Exception e) {}

        ll.addLast(10);
        assert ll.getFirst() == 10;

        ll.addLast(20);
        assert ll.getFirst() == 10;

        ll.addFirst(30);
        assert ll.getFirst() == 30;
    }

    public void testListGetLast() {
        LinkedList ll = new LinkedList();

        try {
            ll.getLast();
            assert false;
        } catch (Exception e) {}

        ll.addLast(10);
        assert ll.getLast() == 10;

        ll.addLast(20);
        assert ll.getLast() == 20;

        ll.addFirst(30);
        assert ll.getLast() == 20;
    }

    public void testListIndexOf() {
        LinkedList ll = new LinkedList();

        assert ll.indexOf(10) == -1;

        ll.addLast(10);
        assert ll.indexOf(10) == 0;

        ll.addLast(20);
        assert ll.indexOf(20) == 1;
        assert ll.indexOf(10) == 0;

        ll.addLast(10);
        ll.addLast(10);

        assert ll.indexOf(10) == 0;
    }

    public void testListRemoveFirst() {
        LinkedList ll = new LinkedList();

        try {
            ll.removeFirst();
            assert false;
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        assert ll.getFirst() == 1;
        assert ll.removeFirst() == 1;

        assert ll.getFirst() == 2;
        assert ll.removeFirst() == 2;

        assert ll.getFirst() == 3;
        assert ll.removeFirst() == 3;

        assert ll.getFirst() == 4;
        assert ll.removeFirst() == 4;

        assert ll.isEmpty();
    }

    public void testListRemoveLast() {
        LinkedList ll = new LinkedList();

        try {
            ll.removeLast();
            assert false;
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        assert ll.getLast() == 4;
        ll.removeLast();

        assert ll.getLast() == 3;
        ll.removeLast();

        assert ll.getLast() == 2;
        ll.removeLast();

        assert ll.getLast() == 1;
        ll.removeLast();

        assert ll.isEmpty();
    }

    public void testListRemove() {
        LinkedList ll = new LinkedList();

        try {
            ll.remove(-1);
            assert false;
        } catch (Exception e) {}

        try {
            ll.remove(6);
            assert false;
        } catch (Exception e) {}

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(2);

        assert ll.indexOf(2) == 1;

        ll.remove(1);
        assert ll.indexOf(2) == 3;
        assert ll.indexOf(1) == 0;

        ll.remove(0);
        assert ll.indexOf(1) == -1;
        assert ll.indexOf(3) == 0;

        ll.remove(0);
        assert ll.indexOf(3) == -1;
        assert ll.indexOf(4) == 0;

        ll.remove(0);
        assert ll.indexOf(4) == -1;
        assert ll.indexOf(2) == 0;

        ll.remove(0);
        assert ll.indexOf(2) == -1;

        assert ll.isEmpty();
    }

    public void testListRemoveByValue() {
        LinkedList ll = new LinkedList();

        assert !ll.removeByValue(5);

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(2);

        assert ll.removeByValue(1);
        assert !ll.removeByValue(1);

        assert ll.getFirst() == 2;
        assert ll.indexOf(2) == 0;

        ll.removeByValue(2);
        assert ll.indexOf(2) == 2;

        ll.removeByValue(3);
        ll.removeByValue(4);

        assert ll.getFirst() == 2;

        ll.removeByValue(2);
        assert ll.isEmpty();
    }

    public void testLLAddLast() {
        LinkedList ll = new LinkedList();

        assert ll.isEmpty();
        assert ll.size() == 0;

        ll.addLast(12);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 12;
        assert ll.size() == 1;

        ll.addLast(20);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 20;
        assert ll.size() == 2;

        ll.addLast(30);
        ll.addLast(40);

        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 40;
        assert ll.size() == 4;

        ll.addLast(50);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 50;
        assert ll.size() == 5;

        ll.addLast(60);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 60;
        assert ll.size() == 6;
    }

    public void testListAddFirst() {
        LinkedList ll = new LinkedList();

        assert ll.isEmpty();
        assert ll.size() == 0;

        ll.addFirst(50);
        assert !ll.isEmpty();
        assert ll.getFirst() == 50;
        assert ll.size() == 1;

        ll.addFirst(40);
        ll.addFirst(30);

        assert !ll.isEmpty();
        assert ll.getFirst() == 30;
        assert ll.size() == 3;

        ll.addFirst(20);
        assert !ll.isEmpty();
        assert ll.getFirst() == 20;
        assert ll.size() == 4;

        ll.addFirst(10);
        assert !ll.isEmpty();
        assert ll.getFirst() == 10;
        assert ll.size() == 5;

        ll.addFirst(5);
        assert !ll.isEmpty();
        assert ll.getFirst() == 5;
        assert ll.size() == 6;
    }

    public void testLinkedListAdd() {
        LinkedList ll = new LinkedList();

        assert ll.isEmpty();
        assert ll.size() == 0;

        try {
            ll.add(-1, 12);
            assert false;
        } catch (Exception e) {}

        try {
            ll.add(7, 12);
            assert false;
        } catch (Exception e) {}

        ll.add(0, 12);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.size() == 1;

        ll.add(1, 20);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 20;
        assert ll.size() == 2;

        ll.add(2, 30);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.getLast() == 30;
        assert ll.size() == 3;

        ll.add(2, 25);
        assert !ll.isEmpty();
        assert ll.getFirst() == 12;
        assert ll.get(2) == 25;
        assert ll.getLast() == 30;
        assert ll.size() == 4;

        ll.add(0, 5);
        assert !ll.isEmpty();
        assert ll.getFirst() == 5;
        assert ll.getLast() == 30;
        assert ll.size() == 5;

        ll.add(2, 15);
        assert !ll.isEmpty();
        assert ll.getFirst() == 5;
        assert ll.getLast() == 30;
        assert ll.size() == 6;
    }

    public static void main(String[] args) {
        LinkedListAsserts tests = new LinkedListAsserts();

        tests.testIsEmpty();
        tests.testLastIndexOf();
        tests.testToString();
        tests.testListGet();
        tests.testListGetFirst();
        tests.testListGetLast();
        tests.testListIndexOf();
        tests.testListRemoveFirst();
        tests.testListRemoveLast();
        tests.testListRemove();
        tests.testListRemoveByValue();
        tests.testLLAddLast();
        tests.testListAddFirst();
        tests.testLinkedListAdd();
    }

}
