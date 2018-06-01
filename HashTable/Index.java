/**
 * Created by Ezgi on 18.11.2017.
 */
public class Index<K> {
    Bucket link;
    private Index previous;
    private Index next;
    private K indexKey;

    public Index() {
        this.link = null;
        this.next = null;
        this.setIndexKey(null);
    }

    public Index getPrevious() {
        return previous;
    }

    public void setPrevious(Index previous) {
        this.previous = previous;
    }

    public K getIndexKey() {
        return indexKey;
    }

    public void setIndexKey(K indexKey) {
        this.indexKey = indexKey;
    }

    public Bucket getLink() {
        return link;
    }

    public Index getNext() {
        return next;
    }

    public void setNext(Index next) {
        this.next = next;
    }

}
