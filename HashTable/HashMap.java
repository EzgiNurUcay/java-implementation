/**
 * Created by Ezgi on 17.11.2017.
 */
public interface HashMap<K, V> {
    void resize();

    void search(K key, V value);

    void insert(K key, V value);

    void delete(K key, V value);


}
