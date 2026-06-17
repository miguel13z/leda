
public class MeusTestes {

	public static void main(String[] args) {
		 new MeusTestes().testStrategy();
	}

	public void testStrategy() {
        
        LRUEvictionStrategy lrucache = new LRUEvictionStrategy(4);
        System.out.println(lrucache.getNextEviction()); // null;
        System.out.println(lrucache.size()); //0
        System.out.println(lrucache.get("a").equals("miss"));

        // cache status: ["a", null, null, null]
        System.out.println(lrucache.getNextEviction());  //== null;
        System.out.println(lrucache.size());  ///== 1;
        System.out.println(lrucache.get("a").equals("hit"));
        System.out.println(lrucache.size() == 1);

        System.out.println(lrucache.get("b").equals("miss")) ;
        System.out.println(lrucache.getNextEviction());  //== null;
        System.out.println(lrucache.get("c").equals("miss"));
        System.out.println(lrucache.get("d").equals("miss"));

        // cache status: ["a", "b", "c", "d"]
        System.out.println(lrucache.getNextEviction().equals("a")) ;
	}
}
