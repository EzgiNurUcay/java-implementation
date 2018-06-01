/**
 * Created by Ezgi on 17.11.2017.
 */
// The aim of this class, creating a struct -protocol- to hash values with abstract data type
public interface Entry<K, V> {
    K getKey();
    V getValue();

}
