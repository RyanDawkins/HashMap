/**
 *
 *
 *
 */
 public class SetOfStrings
 {
 	private int size;
 	private LinkedList[] references;
 	private int slotSize;

 	/**
 	 * Default constructor that takes a parameter for the "HashTable" size
 	 *
 	 * @param  slotSize		the size of the hashtable
 	 */
 	public SetOfStrings(int slotSize)
 	{
 		/*
	 	 * Instructions:
	 	 *
	 	 * This constructor has one parameter: an int that represents the number
	 	 * of slots in the hash table. Store the value, and use it to create 
	 	 * the array of slots for the table.
	 	 *
	 	 */
 		this.setSlotSize(slotSize);
 		this.references = new LinkedList[this.getSlotSize()];
 		this.size = 0;
 	}

 	/**
 	 * Method to add a value to hash table
 	 *
 	 * @param  s 		some string to be added to the hash table
 	 * @return bool     a boolean value of whether it was inserted by call or not
 	 */
 	public boolean add(String s)
 	{
 		/*
 		 * Instructions:
 		 *
 		 * Adds the string to the hash table, if the string is not
 		 * present already. Return true if the string was added by call,
 		 * and false otherwise.
 		 */

 		// Computes the hash value for the given string
 		int hash = this.hash(s);

 		// Grabs the LinkedList associated with the hash value
 		LinkedList slot = this.get(hash);

 		if(slot == null)
 		{
 			// If slot is empty create a new instance of the LinkedList in the array
 			// and store the given string.
 			this.references[hash] = new LinkedList();
 			this.references[hash].add(s);
 		}
 		else
 		{
 			// Another string that is the same or has the same hash value
 			// is in the LinkedList.
 			if(this.contains(s) > 0)
 			{
 				return false;
 			}
 			this.references[hash].add(s);
 		}

 		this.size++;
 		return true;
 	}

 	/**
 	 *
 	 */
 	public boolean delete(String s)
 	{
 		/*
 		 * Instructions:
 		 * 
 		 * Deletes the string from the hash table, if the string is not
 		 * present in the hash table. Returns true if the string was deleted
 		 * by the call, and false otherwise.
 		 */

 		int hash = this.hash(s);
 		LinkedList slot = this.get(hash);

 		if(slot == null)
 		{
 			return false;
 		}

 		String deleted = slot.delete(s);
 		if(deleted == null)
 		{
 			return false;
 		}

 		this.size--;
 		return true;
 	}

 	/**
 	 *
 	 */
 	public int contains(String s)
 	{
 		/*
 		 * Instructions:
 		 * 
 		 * Returns the number of string comparisons needed to find the string
 		 * in the hash table. (For example, if the string is the first value
 		 * in its linked list, return 1; if it is the second string in its linked list
 		 * return 2, and so forth.) If the string is not found, return the number of string
 		 * comparisons performed to determine that result, but return it as a negative number.
 		 * (For example, if the string "cat" is not found in a linked list of length 4, return -4.)
 		 */
 		int hash = this.hash(s);

 		LinkedList slot = this.get(hash);

 		if(slot == null)
 		{
 			return 0;
 		}
 		else
 		{
 			int comparisons = 1;
 			String node = slot.first();
 			while(!s.equals(node))
 			{
 				if(s.equals(node))
 				{
 					comparisons++;
 					return comparisons;
 				}
 				comparisons++;
 				node = slot.next();
 			}
 			return comparisons*-1;
 		}
 	}

 	/**
 	 * Calculates the hash value of a string by the summation of
 	 * the unicode values in the string, the formula is sum % m
 	 * where m is the size of the HashTable.
 	 *
 	 * @param  s 			a String value to be hashed into the table
 	 * @return hash 		the sum of the unicode values of the string mod the slot size
 	 */
 	public int hash(String s)
 	{
 		/*
 		 * Instructions:
 		 * 
 		 * Calculate the sum of the Unicode values of all characters from the string,
 		 * and return sum mod m, where m is the number of slots in the hash table.
 		 */

 		int sum = 0;
 		// Iterates through the string and gets the unicode value
 		// of the string.
 		for(int i = 0; i < s.length(); i++)
 		{
 			sum += (int)s.charAt(i);
 		}

 		return sum % this.getSlotSize();
 	}

 	/**
 	 * Method to return the amount of elements that have been added into the
 	 * hash table.
 	 *
 	 * @return 			the amount of elements in the hash table.
 	 */
 	public int count()
 	{
 		/*
 		 * Instructions
 		 *
 		 * Return the number of tokens stored in the set. You may either calculate this
 		 * on request or maintain data member that contains the count.
 		 */
 		return this.size;
 	}

 	/**
 	 * Method to get slot size if the method of calculating the slot size ever
 	 * ever changes in the future
 	 *
 	 * @return slotSize 	the amount of possible hash values
 	 */
 	private int getSlotSize()
 	{
 		return this.slotSize;
 	}

 	/**
 	 * Method to set the slot size
 	 *
 	 * @param  slotSize 	the amount of possible hashes there are
 	 * @return this  		returns a reference to the object to
 	 * 						allow chainability.
 	 */
 	private SetOfStrings setSlotSize(int slotSize)
 	{
 		this.slotSize = slotSize;
 		return this;
 	}

 	/**
 	 * Method to get a LinkedList by a given computed hash
 	 *
 	 * @param  int 			the value computed by the hash(String) function
 	 * @return String 		the value stored in the LinkedList associated with the has function
 	 */
 	private LinkedList get(int hash)
 	{
 		return this.references[hash];
 	}

 	public LinkedList[] getData()
 	{
 		return this.references;
 	}

 }