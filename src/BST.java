
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class BST<K extends Comparable<K>, V>
{
    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }



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
        public V get(K key){
            if(key == null)throw new IllegalArgumentException("Can't be found without a key");
            Node current = root;

            while(current != null){
                if(key.compareTo(current.key) > 0) current = current.right;
                else if(key.compareTo(current.key)<0) current = current.left;
                else{
                    return current.value;
                }
            }
            return null;

        }

        public void delete(K key){
                if(key == null){
                    throw new IllegalArgumentException("No no no)");
                }
                Node current = root;
                Node parent = null;

                while(current != null){
                    if(key.compareTo(current.key) == 0){
                        if(current.left == null){
                            if(parent == null) root = current.right;
                            else if(parent.left == current) parent.left = current.right;
                            else parent.right = current.right;
                            size--;
                            break;
                        }
                        else if(current.right == null){
                            if(parent == null) root = current.left;
                            else if(parent.left == current) parent.left = current.left;
                            else parent.right = current.left;
                            size--;
                            break;
                        }
                        else{
                            Node sucessorParent =current;
                            Node sucessor = current.right;
                            while(sucessor.left != null){
                                sucessorParent = sucessor;
                                sucessor = sucessor.left;
                            }
                            current.key = sucessor.key;
                            current.value = sucessor.value;

                            if(sucessorParent.left == sucessor) sucessorParent.left = sucessor.right;
                            else sucessorParent.right = sucessor.right;
                            size--;
                            break;

                        }
                    }
                    else if(key.compareTo(current.key) > 0){
                        current = current.right;
                    }
                    else if(key.compareTo(current.key) < 0){
                        current = current.left;
                    }
                }

        }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderTraversal(root,keys);
        return keys;
    }

    private void inOrderTraversal(Node node, List<K> nodes) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, nodes);
        nodes.add((K)node);
        inOrderTraversal(node.right, nodes);
    }

//
//        public Iterable<K> iterator(){
//
//        }

    }

