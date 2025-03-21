package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList sortedIntList;
    private int totalAdded; 

    public DelegationSortedIntList() {
        this.sortedIntList = new SortedIntList(); 
        this.totalAdded = 0;
    }

    public boolean add(int num) {
        boolean result = sortedIntList.add(num);
        if (result) {
            totalAdded++;
        }
        return result;
    }

    public boolean addAll (IntegerList list){
        boolean result = false;
        for(int i = 0; i < list.size(); i++){
            int element = list.get(i);
            if(add(element)){
                result = true;
            }
        }
        return result;
    }

    public int get(int index) {
        return sortedIntList.get(index); 
    }

    public boolean remove(int num) {
        boolean result = sortedIntList.remove(num);
        if (result) {
            // totalAdded--;
        }
        return result;
    }

    public boolean removeAll(IntegerList list) {
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if(remove(element)){
                result = true;
            }        
        }
        return result;
    }

    public int size() {
        return sortedIntList.size(); 
    }

    public int getTotalAdded() {
        return totalAdded; 
    }
}