/**
 * Created by Ezgi on 17.11.2017.
 */
public class Bucket<K, V> {
    /**
     *          +-------------------------+
     * bucket = |   HEADER   |   ENTRY    |
     *          +-------------------------+
     * HEADER contains local depth and capacity, total entry number.
     * ENTRY contains Key and values and count.
     * Ex: "cartoon", "00110000111110.."," 3"
     */
    private int localdepth;
    protected int capacity;
    protected int n; // total entry number
    MapEntry[] data;

    public Bucket(int depth) {
        localdepth = depth;
        capacity = 10;
        data = new MapEntry[capacity];
    }

    public Bucket(Bucket bucket) {
        localdepth = bucket.localdepth;
        capacity = bucket.capacity;
        data = bucket.data;
        n = bucket.n;
    }

    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K k;  // key
        private V v;  // value
        private int count = 0;   // value's repeat count

        //TODO you have to increase count if you added same value in the hash table.
        public MapEntry(K key, V value) {
            k = key;
            v = value;
            count = 0; // in the beginning
        }

        // public methods of the Entry interface
        public K getKey() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public void setV(V v) {
            this.v = v;
        }

        public V getValue() {
            return v;
        }


        public int getCount() {
            return count;
        }

    }

    public void addData(K key, V value) {
        n++;
        if (!doAddBefore(key, value, true)) {
            for (int i = 0; i < capacity; i++) {
                if (data[i] == null) {
                    data[i] = new MapEntry(key, value);
                    data[i].count++; // unique data.
                    break;
                }
            }
        }
    }

    public boolean doAddBefore(K key, V value, boolean count) {
        // This boolean for using to this function both use search and insert operation.
        for (int i = 0; i < capacity; i++) {
            if (data[i] != null) {
                if (data[i].getKey().equals(key) && data[i].getValue().equals(value)) {
                    if (count)
                        data[i].count++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        return n >= capacity;
    }

    public void printBucket(K key, V value) {
        for (int i = 0; i < capacity; i++) {
            if (data[i] != null) {
                if (data[i].getKey().equals(key) && data[i].getValue().equals(value)) {
                    System.out.println("Key : " + data[i].getKey());
                    System.out.println("Count : " + data[i].getCount());
                    break;
                }

            }
        }
    }

    public void printBucket() {
        for (int i = 0; i < capacity; i++) {
            if (data[i] != null) {
                System.out.print("V:" + data[i].getValue() + " ");
                System.out.print("K:" + data[i].getKey() + " ");
                System.out.println("C:" + data[i].getCount());
                break;

            }

        }

    }

    public void printbucket() {
        for (int i = 0; i < capacity; i++) {
            if (data[i] != null) {
                System.out.print(data[i].getValue() + " ");
                System.out.print(data[i].getKey() + " ");
                System.out.print(data[i].getCount());

            }

        }

    }

    public int getLocaldepth() {
        return localdepth;
    }

    public String delete(K key, V value, boolean allorones) {
        String back = "";
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (data[i].getKey().equals(key) && data[i].getValue().equals(value)) {
                    back = data[i].getKey() + " " + data[i].getValue();
                    if (!allorones && data[i].getCount() > 1) // All
                    {
                        data[i].count--;
                        break;
                    } else {
                        for (int j = i; j < data.length - 1; j++) {
                            if (data[j] != null && data[j + 1] != null) {
                                data[j].count = data[j + 1].getCount();
                                data[j].setK(data[j + 1].getKey());
                                data[j].setV(data[j + 1].getValue());
                            } else if (data[j + 1] == null) {
                                data[j] = null;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return back;
    }

}


