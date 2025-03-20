package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    private int totalAdded = 0;

    @Override
    public void add(int value) {
        boolean added = super.add(value);
        if (added) {
            totalAdded++;
        }
        return added;
    }

    @Override
    public boolean addAll(IntegerList list) {
        int before = size();
        boolean changed = super.addAll(list);
        totalAdded += (size() - before);
        return changed;
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}