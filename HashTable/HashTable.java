
/**
 * Created by Ezgi on 17.11.2017.
 */
public class HashTable<K, V> implements HashMap<K, V> {
    private Index headindex;
    private Index tailindex;
    private int globaldepth;

    public HashTable(int globaldepth) {
        this.globaldepth = globaldepth;
        settingLink(globaldepth);
    }

    /***
     * Most hard part of extendible hash.
     * When insert a value in the extendible hash, if your index's bucket is full and
     * global depth is equal local depth you have to resize your hashtable and so important
     * part, you have to set link to show same bucket.
     */
    @Override
    public void resize() {
        globaldepth++;
        settingLink();
    }

    /**
     * When we search for a word in the hashtable, we check that this is added before.
     * doaddbefore function's boolean variable provide increase of value's count.
     */
    @Override
    public void search(K key, V value) {
        Index temp = findIndex(key, globaldepth);
        if (temp.link == null) {
            System.err.println("This word is no in this text.");
        } else {
            if (temp.link.doAddBefore(key, value, false)) { // If true added before
                temp.link.printBucket(key, value);
                System.out.println("Index Key: " + hashmode((String) temp.getIndexKey(), globaldepth));
                System.out.println("Integer Key: " + findKey((String) value));
                System.out.println("Global Depth: " + globaldepth);
                System.out.println("Local Depth: " + temp.link.getLocaldepth());

            } else System.err.println("This word is no in this text.");

        }
    }

    public void deleteAll(K key, V value) {
        Index newindex = findIndex(key, globaldepth);
        System.out.println(newindex.getLink().delete(key, value, true));

    }

    @Override
    public void delete(K key, V value) {
        Index newindex = findIndex(key, globaldepth);
        System.out.println(newindex.getLink().delete(key, value, false));

    }

    // This is extra for check value according to same depth.
    public void searchtoDepth(int depth) {
        Index temp1 = headindex;
        Index temp2 = tailindex;
        while (temp1 != null && temp2 != null) {
            if (temp1.link != null && temp1.link.getLocaldepth() == depth)
                temp1.link.printBucket();
            if (temp2.link != null && temp2.link.getLocaldepth() == depth)
                temp2.link.printBucket();
            if (temp1.getNext().getIndexKey() == temp2.getIndexKey()) break;
            temp1 = temp1.getNext();
            temp2 = temp2.getPrevious();
        }
    }

    @Override
    public void insert(K key, V value) { // Binary and string formats.
        if (globaldepth < 33) { // This is capacity according to key length.
            Index temp = findIndex(key, globaldepth);
            if (temp.link == null) {
                createBucket(temp, globaldepth);
                temp.link.addData(key, value);
            } else {
                //if count true that means this word could not be added before else their count is increase.
                if (!temp.link.doAddBefore(key, value, true)) {
                    if (!temp.link.isFull()) {
                        temp.link.addData(key, value);
                    } else {
                        if (globaldepth == temp.link.getLocaldepth()) {
                            resize();
                        } else { // distribute buckets.
                            Bucket bucket = new Bucket(temp.link);
                            deleteAllSameLink(temp.link);
                            distributeBucket(bucket);
                        }
                        insert(key, value);
                    }
                }
            }
        } else {
            System.err.println("This text bigger than hash table can get. ");
        }
    }

    // To find index according to depth and key.
    private Index findIndex(K key, int depth) {
        // Convert base.
        int location = Integer.parseInt(hashmode((String) key, depth), 2);
        Index temp = headindex;
        // Not global depth it's run with local to provide more short loop.
        for (int i = 0; i < location; i++) {
            try {
                temp = temp.getNext();
            } catch (NullPointerException e) {
                System.err.println("There is a problem in the key");
            }
        }

        return temp;

    }

    private boolean isSameBucket(Index i, Bucket bucket) {
        if (i.link.getLocaldepth() == bucket.getLocaldepth() && i.link.data == bucket.data)
            return true;
        return false;
    }

    public void deleteAllSameLink(Bucket bucket) {
        Index temp1 = headindex;
        Index temp2 = tailindex;
        while (temp1 != null && temp2 != null) {
            if (temp1.link != null && isSameBucket(temp1, bucket))// To cut link.
                temp1.link = null;
            if (temp2.link != null && isSameBucket(temp2, bucket))// To cut link.
                temp2.link = null;
            if (temp1.getNext().getIndexKey() == temp2.getIndexKey()) break;
            temp1 = temp1.getNext();
            temp2 = temp2.getPrevious();
        }
    }

    // When inserting a word if bucket is full and global depth is greater than local depth.
    // You have to distribute this bucket according to global depth.
    private void distributeBucket(Bucket bucket) {
        for (int i = 0; i < bucket.data.length; i++) {
            if (bucket.data[i] != null) {
                for (int j = 0; j < bucket.data[i].getCount(); j++) {
                    insert((K) bucket.data[i].getKey(), (V) bucket.data[i].getValue());
                }

                /*countunu aktarmıyorsunn*/
            } else // To stop for if data[i]'s null.
                break;

        }
    }

    private void createIndex(String key, Bucket bucket) {

        Index newIndex = new Index();
        newIndex.setIndexKey(key);
        if (bucket != null)
            newIndex.link = new Bucket(bucket);// Uses when table resize and in the beginning.
        if (headindex == null) {
            tailindex = headindex = newIndex;

        } else {
            // Add to the end.
            newIndex.setPrevious(tailindex);
            tailindex.setNext(newIndex);
            tailindex = newIndex;
        }


    }

    public void settingLink(int i) {
        Index temp = headindex;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        for (int j = count; j < Math.pow(2, i); j++) {
            String val = Integer.toBinaryString(j);
            while (val.length() < 32)
                val = "0" + val;
            createIndex(val, null);
        }

    }

    // This method provide create new index when table resized and copy old link to new indexes.
    public void settingLink() {
        Index temp = headindex;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        Index temp2 = headindex;
        for (int j = count; j < Math.pow(2, globaldepth); j++) {
            String val = Integer.toBinaryString(j);
            while (val.length() < 32)
                val = "0" + val;
            createIndex(val, temp2.link);
            temp2 = temp2.getNext();
        }

    }

    private void createBucket(Index i, int depth) {
        Bucket bucket = new Bucket(depth);
        i.link = bucket;
    }

    // To provide substring operation according to depth.
    private String hashmode(String key, int depth) {
        return key.substring(key.length() - depth);
    }

    // If operation is true this function inserts input in the hash table else search input.
    public void add(String input, int operation) {

        if (operation == 1)
            insert(floatingpoint(findKey(input), input), (V) input);
        else if (operation == 2) {
            search(floatingpoint(findKey(input), input), (V) input);
        } else if (operation == 3) {
            deleteAll(floatingpoint(findKey(input), input), (V) input);
        } else {
            delete(floatingpoint(findKey(input), input), (V) input);
        }

    }

    private String inttobinary(String input) {
        String binary = "";

        binary += Long.toBinaryString(Long.valueOf(input));

        return binary;
    }

    private String findKey(String input) {
        char[] ascii = input.toCharArray();
        long num = 0;
        for (int i = 0; i < ascii.length; i++) {
            num += (int) ((ascii[i]) * Math.pow(2, i));  // Max productivity.
        }
        return String.valueOf(num);

    }

    /***
     *  Integer value of "a" is 97 and integer value of "z" is 122.
     *  The count character for all letters is 25. The avarage this letter 110.
     *  So I signed all letter to keep from collision according to first letter.
     * -----------32bits-------------
     * | [SIGN][EXPONENT][MANTISSA] |
     * --1bits--8bits-----23bits-----
     * <p>
     * Floating point uses to save so big and so small numbers.For creating floating point
     * you need a integer,you have to convert binary this number.If the number's first
     * letter isn't 1, add 1 in the beginning from the number.To calculate exponent gather binary's length with 127
     * convert to binary this sum to be 8 bits this is your exponent. Finally add this all number together
     * and complete 32bit to add 0. But if I added 0 to the last It might be
     * collision so much, so I used base form to create unique id.
     *
     * @param value
     * @return
     */
    private K floatingpoint(String intForm, String value) {
        String bin = "";
        String base = inttobinary(intForm);
        if (base.charAt(0) != '1') { //To convert floating point , exponents part.
            base = "1" + base;
        }
        String exp = inttobinary(String.valueOf(base.length() - 1 + 127)); // Must be 8 bit.
        String bit8exp = exp.substring(0, 8);

        bin = base + bit8exp;
        if (bin.length() > 31)
            bin = bin.substring(bin.length() - 31);
        else {
            int i = 0;
            while (bin.length() < 31) {
                bin = base.substring(i, i + 1) + bin;
                i++;
                if (i >= base.length() - 1) i = 0;
            }

        }
        if ((int) value.charAt(0) < 110)
            bin = "0" + bin;
        else bin = "1" + bin;


        return (K) bin;

    }

    public void printhash() { // To check operations.
        System.out.println("hash table viev =) : global: " + globaldepth);
        Index temp = headindex;
        while (temp != null) {                 // Moves by linked structures.
            System.out.print(hashmode((String) temp.getIndexKey(), globaldepth) + " ");
            if (temp.getLink() != null) {
                System.out.print("lo:" + temp.getLink().getLocaldepth() + " ");
                temp.getLink().printbucket();
            }
            temp = temp.getNext();
            System.out.println();
        }
    }

}
