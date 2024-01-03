package dataStrucrues.hashTable;
public class HashTable {
  private int size = 7;
  private Node[] dataMap;

  class Node {
    String key;
    int value;
    Node next;

    Node(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public HashTable() {
    dataMap = new Node[size];
  }

  public void printTable() {
    for (int i = 0; i < dataMap.length; i++) {
      System.out.println(i + ":");
      Node temp = dataMap[i];
      while (temp != null) {
        System.out.println("   {" + temp.key + "= " + temp.value + "}");
        temp = temp.next;
      }
    }
  }

  public int hash(String key) {
    int hash=0;
    char[] charArray = key.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      int ascii = charArray[i];
      hash = (hash+ascii*23) % dataMap.length;
    }
    return hash;
  }

}