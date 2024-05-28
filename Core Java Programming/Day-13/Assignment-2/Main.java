package Assesment_2;

public class Main {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("app");
		System.out.println("Starts with 'app': " + trie.startsWith("app"));
		System.out.println("Starts with 'appl': " + trie.startsWith("appl"));
		System.out.println("Starts with 'apl': " + trie.startsWith("apl"));
		System.out.println("Search 'apple': " + trie.search("apple"));
		System.out.println("Search 'app': " + trie.search("app"));
		System.out.println("Search 'appl': " + trie.search("appl"));
	}
}
