
public class HashTable {
	
	public int size;
	public Queue [] hash_Table;
	
	HashTable() {
		size = 10;
		hash_Table = new Queue[size];
		for (int i = 0; i < 10; i++)
			hash_Table[i] = new Queue();
	}
	
}
