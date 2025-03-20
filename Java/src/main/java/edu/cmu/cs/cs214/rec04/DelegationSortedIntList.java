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
    private SortedIntList list;
    private int totalAdded = 0;

    public DelegationSortedIntList() {
        list = new SortedIntList();
    }

    @Override
    public boolean add(int value) {
        boolean added = list.add(value);
        if (added) {
            totalAdded++;
        }
        return added;
    }

    @Override
    public boolean addAll(IntegerList otherList) {
        int before = list.size();
        boolean changed = list.addAll(otherList);
        totalAdded += (list.size() - before);
        return changed;
    }

    // Делегацлах бусад методүүд
    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }

    // ... remove, indexOf гэх мэт бусад методүүдийг ижил зарчмаар хэрэгжүүлнэ
}