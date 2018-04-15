import java.util.Random;
import java.lang.Math;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;

class Sorts {
    private int arrays[];
    
    public Sorts() {
	int val = 35000;
	Random randomGenerator = new Random();
	this.arrays = new int[val];
	for (int i = 0; i < val; i++) {
	    this.arrays[i] = randomGenerator.nextInt();
	}
	this.arrays[val-1] = 1981;
    }

    public boolean isSorted(int[] array) {
	for (int i = 0; i < array.length/2; i++) {
	    if (array[i] > array[array.length-1-i])
		return false;
	}
	return true;
    }

    public static int incrementalSearch(int[] array, int element) {
	for (int i = 0; i < array.length; i++)
	    if (array[i] == element)
		return i;
	return -1;
    }

    public static boolean binarySearch(int[] array, int element) {
	int search = array.length/2;
	int shift = search/2;
	System.out.println("search: " + search + " shift: " + shift + " element: " + element);
	while (shift > 0) {
	    if (array[search] == element)
		return true;
	    else {
		if (array[search] < element)
		    search += shift;
		else
		    search -= shift;
		shift /= 2;
		System.out.println("search: " + search + " shift: " + shift);
	    }
	}

	System.out.println("Search: " + search + " number: " + array[search]);
	return array[search] == element;
    }

    public static void bubbleSort(int[] array) {
	Instant previous, current;
	long gap;
	previous = Instant.now();
	for (int o = 0; o < array.length; o++) {
	    boolean swapped = false;
	    for (int i = 0; i < array.length-1-o; i++) {
		if (array[i] > array[i+1]) {
		    int temp = array[i];
		    array[i] = array[i+1];
		    array[i+1] = temp;
		    swapped = true;
		}
	    }
	    if (swapped = false)
	    	break;
	}
	current = Instant.now();
	gap = ChronoUnit.MILLIS.between(previous, current);
	System.out.println("That took " + (gap / 1000 > 0 ? gap / 1000 : "")
			   + (gap % 1000 > 50 ? "." + gap % 1000 : "" ) + " seconds.");
    }

    public static void transSort(int[] array) {
        double standardDeviation = 0.0, average = 0.0;
	for (int forward = 0; forward < array.length-1; forward++) {
	    average += array[forward];
	    average /= 2;
	    if (array[forward] > array[forward+1]) {
	        int temp = array[forward];
		array[forward] = array[forward+1];
		array[forward+1] = temp;
	    }
	}
	for (int backward = array.length-1; backward > 0; backward--) {
	    standardDeviation += Math.pow((array[backward] - average), 2);
	    standardDeviation /= 2;
	    if (array[backward] < array[backward-1]) {
		int temp = array[backward];
		array[backward] = array[backward-1];
		array[backward-1] = temp;
	    }
	}
	System.out.println("Average: " + Math.abs(average));
	System.out.println("Standard Deviation: " + Math.sqrt(standardDeviation));
    }
    
    public static void main(String[] args) {
	Sorts sort = new Sorts();
	transSort(sort.arrays);
	if (sort.isSorted(sort.arrays))
	    System.out.println("This array is sorted.");
	else
	    System.out.println("This array is not sorted.");

	bubbleSort(sort.arrays);
    	if (sort.isSorted(sort.arrays))
	    System.out.println("This array is sorted.");
	else
	    System.out.println("This array is not sorted.");

	if (binarySearch(sort.arrays, 1981))
	    System.out.println("I found the number.");
	else {
	    System.out.println("I did not find the number.");
	}
	int index = incrementalSearch(sort.arrays, 1981);
	System.out.println(index);
    }

}
