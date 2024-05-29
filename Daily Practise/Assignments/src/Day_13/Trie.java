package Day_13;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private TrieNode root;

	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean isEndOfWord;

		TrieNode() {
			children = new HashMap<>();
			isEndOfWord = false;
		}
	}

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			current = current.children.computeIfAbsent(ch, c -> new TrieNode());
		}
		current.isEndOfWord = true;
	}

	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (char ch : prefix.toCharArray()) {
			current = current.children.get(ch);
			if (current == null) {
				return false;
			}
		}
		return true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			current = current.children.get(ch);
			if (current == null) {
				return false;
			}
		}
		return current.isEndOfWord;
	}

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
