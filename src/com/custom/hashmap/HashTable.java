package com.custom.hashmap;

public class HashTable {

	private int INITAL_SIZE = 15;
	private HashEntry[] entryArray ;
	
	class HashEntry {
		String key;
		String value;
		HashEntry next ;
		
		public HashEntry(String key, String value) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public HashEntry getNext() {
			return next;
		}

		public void setNext(HashEntry next) {
			this.next = next;
		}
		
		
	}
	
	public HashTable() {
	       entryArray = new HashEntry[INITAL_SIZE];
	}
	
	public void put(String key, String value) {
		int keyHashCode = generateHashCode(key);
		
		for (int i=keyHashCode; i<entryArray.length;) {
			HashEntry hh = entryArray[i];
			if(hh== null) {
				HashEntry newhh = new HashEntry(key, value);
				entryArray[keyHashCode] = newhh;
			} else {
				int existingHashCode = generateHashCode(hh.getKey());
				if( !hh.getKey().equals(key)  &&existingHashCode == keyHashCode) {
					HashEntry nextEntry = new HashEntry(key, value);
					hh.setNext(nextEntry);
				} else {
					hh.setKey(key);
					hh.setValue(value);
					entryArray[keyHashCode] = hh;
				}
			}
			break;
		}	
	}
	
	public String getValue(String inputKey) throws Exception{
		int keyHashCode = generateHashCode(inputKey);
		String value = null;
		for (int i=keyHashCode; i<entryArray.length;) {
			HashEntry hh = entryArray[i];
			if(hh== null) {
				throw new Exception("Object does not exist");
				} else {
					if(!hh.getKey().equals(inputKey)) {
						HashEntry tempHh = hh.getNext();
						while(tempHh != null) {
							if(tempHh.getKey().equals(inputKey)) {
								value = tempHh.getValue();
								break;
							} else {
								tempHh = tempHh.getNext();
							}
						}
					} else {
						value = hh.getValue();
					}
				}
			break;
			}
		return value;
	}
	
	private int generateHashCode(String key) {
		int hashCode = key.length();
		int x = hashCode % INITAL_SIZE;
		if(x<0) {
			x = 0-x;
		}
		return x;
	}
}
