
import java.util.Iterator;

public class BST<K extends Comparable<K>, V>{
    private class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }}

        private Node root;
        private int size;



        public void put(K key, V value){
            if(key == null) throw new IllegalArgumentException("Key cant be null");
            if(root == null){
                root = new Node(key, value);
                size++;
            }

            Node newnode = new Node(key, value);
            Node current = root;

            while(current != null){
                if(key.compareTo(current.key) > 0){
                    if(current.right == null){
                        current.right = newnode;
                        size++;
                        break;
                    }else {current = current.right;}

                }
                else if(key.compareTo(current.key) < 0){
                        if(current.left == null){
                            current.left = newnode;
                            size++;
                            break;
                        }else{
                            current = current.left;
                        }
                }
                else{
                    current.value = value;
                    break;
                }
            }
        }
//        public V get(K key){
//
//        }
//
//        public void delete(K key){
//
//        }
//
//        public Iterable<K> iterator(){
//
//        }

    }

