package DS10_08;

public class HashTable {
	public Entry[] entries;
	public double loadfactory;
	public int size;
	public int used;
	
	public HashTable(int size, double loadfactory) {
		entries = new Entry[size];
		this.loadfactory = loadfactory;
		
	}
	public Object get(Object key) {
		int h = hash(key);
		for(Entry e = entries[h]; e !=null; e=e.next) {
			if(e.key.equals(key)) return e.value;
		}
		return null;
	}
	public Object add(Object key, String value) {
		int h = hash(key);
		for(Entry e = entries[h]; e !=null; e=e.next) {
			if(e.key.equals(key)) {
				e.value = e.value+","+value;
				return e.value; //수정
			}
		}
		entries[h] = new Entry(key, value, entries[h]);
		++size;
		if(size > loadfactory*entries.length) rehash();
		return null;
	}
	
	public int hash(Object key) {
		return (key.hashCode() & 0x7FFFFFFF) % entries.length;

	}
	public void rehash() {
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k=0;k<oldEntries.length;k++) {
			for(Entry old = oldEntries[k]; old != null; ) {
				Entry e = old;
				old = old.next;
				int h = hash(e.key);
				e.next = entries[h];
				entries[h] = e;
			}
		}
	}
	public int size() {
		return size;
	}

	private class Entry {
		private Object key;
		private String value;
		private Entry next;
		
		public Entry(Object key, String value) {
			this.key = key;
			this.value = value;
		}
		public Entry(Object key, String value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
