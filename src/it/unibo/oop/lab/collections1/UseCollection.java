package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int START = 1000;
    private static final int END = 2000;
    private static final int ELEMS = 100_000;
    private static final int READS = 1_000;

	private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	final List<Integer> arrayList = new ArrayList<Integer>();
    	for(int i = START; i < END; i++) {
    		arrayList.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	final List<Integer> linkedList = new LinkedList<>(arrayList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	   	
    	int first = arrayList.get(0);
    	arrayList.set(0, arrayList.get(arrayList.size()-1));
    	arrayList.set(arrayList.size()-1, first);

    	/*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for(int el : arrayList) {
    		System.out.print(el + ", ");
    	}
    	System.out.println("");
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	TestPerformance arrayListPerformance = new TestPerformance();
    	for(int i = 0; i < ELEMS; i++) {
    		arrayList.add(0, i);
    	}
    	System.out.println("insert " + ELEMS + " elements in the head of an array list took " + arrayListPerformance.getDifference() + " ms");
        
    	
    	TestPerformance linkedListPerformance = new TestPerformance();
    	for(int i = 0; i < ELEMS; i++) {
    		linkedList.add(0, i);
    	}
    	System.out.println("insert " + ELEMS + " elements in the head of a linked list took " + linkedListPerformance.getDifference() + " ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	TestPerformance readArrayListPerformance = new TestPerformance();
    	for(int i = 0; i < READS; i++) {
    		arrayList.get(arrayList.size()/2);
    	}
    	System.out.println("read " + READS + " elements in the middle of an array list took " + readArrayListPerformance.getDifference() + " ms");
        
    	TestPerformance readLinkedListPerformance = new TestPerformance();
    	for(int i = 0; i < READS; i++) {
    		linkedList.get(linkedList.size()/2);
    	}
    	System.out.println("read " + READS + " elements in the middle of a linked list took " + readLinkedListPerformance.getDifference() + " ms");
        
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	Map<String, Long> continents = new HashMap<>();
    	continents.put("Africa", 1_110_635_000L);
    	continents.put("Americas", 972_005_000L);
    	continents.put("Antarctica", 0L);
    	continents.put("Asia", 4_298_723_000L);
    	continents.put("Europe", 742_452_000L);
    	continents.put("Oceania", 38_304_000L);
    	
        /*
         * 8) Compute the population of the world
         */
    	
    	Long worldPopulation = 0L;
    	for(Long population : continents.values()){
    		worldPopulation += population;
    	}
    	System.out.println("world population is: " + worldPopulation);
    }
}
