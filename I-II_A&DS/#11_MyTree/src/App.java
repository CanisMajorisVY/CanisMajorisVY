/**
 * Created by Mihail on 23.05.2017.
 */
public class App {
    public static void main(String[] args) {
        Tree<String> myTree = new Tree<>();
        myTree.setRoot(new Node<>("Root", null));

        myTree.addNode("1gen1ch", "Root");
        myTree.addNode("1gen2ch", "Root");
        myTree.addNode("2gen1ch", "1gen1ch");
        myTree.addNode("2gen2ch", "1gen1ch");
        myTree.addNode("2gen3ch", "1gen2ch");
        myTree.addNode("3gen1ch", "2gen1ch");
        

        System.out.print(myTree.getRoot().getChildren().get(0).getChildren().get(1).getData());

    }
}
