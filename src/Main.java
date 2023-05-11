public class Main {
    public static void main(String[] args) {

        BST<Integer, String> tree = new BST<>();

        tree.put(1, "SHESH");

        System.out.println(tree.get(1));

        tree.put(5, "MAN");
        tree.put(3, "SHOOT");
        tree.put(4, "YES SIR!");
        System.out.println(tree.get(4));
        tree.delete(4);
        System.out.println(tree.get(4));
    }
}