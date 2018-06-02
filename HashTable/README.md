In this assignment, you are expected to implement an extendible hashing to index words of a
document named as ‘cartoon.txt’ in Java. You must read this document, split it word by word,
and index each word to your hash table according to rules given below.
RULES

- Hash function for converting words (value) to a key must be implemented by yourself. The
value will be the word and the key will be returned by your hash function. The number of
occurrence of each word also must be stored as count value.
- The hash code for converting a key to the bit representation must be implemented by
yourself.
- The initial table should index a given key according to the last 8 bits (initial global depth and
local depths will be 8). Every slot of the table points a bucket. The bucket size is 10.
- When you need to resize the hash table, the new table size must be doubled to index words
by using one more bit (global depth+1). The bucket size won’t change. E.g., After the first
resize operation, the table should index according to the last 9 bits. After the second resize, it
should index according to 10 bits etc.
- When a word is searched in the hash table; key, count, and index of the word should be
printed. (Global and local depths should also be printed)

Extras this code:
+You can delete a word from hash table
+You can delete the word for all text.
