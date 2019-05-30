package DS10_07;

public class linearSearchHash {
	public Entry[] entries;
	public double loadfactor;
	public int size;
	public int used;
	public int crash=0;
	public Entry NIL = new Entry(null, -1);
	
	public linearSearchHash(int size, double loadfactor) {
		entries = new Entry[size];
		this.loadfactor = loadfactor; 
	}
	public Object get(Object key) {
		int h = hash(key);
		for(int i=0;i<entries.length;i++) {
			int j = (h+i)%entries.length;
			Entry entry = entries[j];
			if(entry == null) break;
			if(entry == NIL) continue;
			if(entry.key.equals(key)) return entry.value;
		}
		return null;
	}
	public Object add(Object key) {
		if(used > loadfactor*entries.length) {
			rehash();
		}
		int h = hash(key);
		for(int i=0;i<entries.length;i++) {
			int j = (h+i)%entries.length;
			Entry entry = entries[j];
			if(entry==null) {
				entries[j] = new Entry(key);
				entries[j].value=1;
				++used;
				++size;
				return null;
			}
			/*if(entry == NIL) {
				crash++;
				continue;
			}*/
			if(!entry.key.equals(key)) {
				crash++;
				continue;
			}
			if(entry.key.equals(key)) {
				entries[j].value+=1;
				break;
			}
		}
		return null;
	}
	public Object remove(Object key) {
		int h = hash(key);
		for(int i=0;i<entries.length;i++) {
			int j = (h+i)%entries.length;
			Entry entry = entries[j];
			if(entry==null) {
				break;
			}
			if(entry==NIL) {
				continue;
			}
			if(entry.key.equals(key)) {
				Object temp = entry.value;
				entries[j] = NIL;
				--size;
				return temp;
			}
		}
		return null;
	}
	public int hash(Object key) {
		return (key.hashCode() & 0x7FFFFFFF) % entries.length;
	}
	
	public void rehash() {
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k=0;k<oldEntries.length;k++){
			Entry entry = oldEntries[k];
			if(entry==null || entry==NIL) continue;
			int h = hash(entry.key);
			for(int i=0;i<entries.length;i++) {
				int j = (h+i)%entries.length;
				if(entries[j]==null) {
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
	public int numberOfCrash() {
		return crash;
	}
	
	private class Entry{
		private Object key;
		private int value;
		
		public Entry(Object key) {
			this.key = key;
		}
		public Entry(Object key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
