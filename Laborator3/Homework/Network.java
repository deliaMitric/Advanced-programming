package Homework;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }
    public Network(){};

    /**
     * Adds a node in the network if the node is an instance of Person or Company
     *
     * @param node represents the node that will be "insert" in this network
     */
    public void addNode(Node node) {
        if(node==null)
            throw new NullPointerException();
        if(!(node instanceof Person) && !(node instanceof Company))
        {
            throw new ClassCastException("Invalid node!");
        }
        else
        {
            if(nodes.size()==0)
                nodes.add(node);

            else {//parcurg lista pt verificare numelor unice!
                boolean gasit=false;
                for(int i=0;i<nodes.size();i++)
                    if(nodes.get(i).getName().compareTo(node.getName())==0){//numele sunt diferite
                        gasit=true;
                    }
                if(gasit==false)
                    nodes.add(node);
                else {
                    throw new ClassCastException("Same names!");
                    }
            }
        }

    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * Verifies if a node is found in this network
     *
     * @param node represents the searched node
     * @return the position of the node in this network, -1 if it isn't in this network
     */
    private int foundNode(Node node)
    {
        //verific prin compareTo  daca acest nod apare in aceasta retea(pt ca am nume unice!)

        int i;
        for(i=0;i<nodes.size();i++)
        {
            if(nodes.get(i).getName().compareTo(node.getName())==0)//nume egale
            {
                return  i;
            }
        }
        return -1;
    }

    /**
     * Computes the importance of every node in this network
     *
     * @param node the node for is computed the importance
     * @return the importance of the node in this network
     */
    public int importance(Node node)
    {
        int i;
        if(node==null)
            throw new NullPointerException();
        else
            if((node instanceof Person) || (node instanceof Company)) {
                if(foundNode(node)!=-1) {
                    int importance=0;

                    if(node instanceof Person) {//PERSON
                        Person person=(Person) node;
                        for (i = 0; i < nodes.size(); i++) {
                            //verific pt fiecare nod din retea
                            //diferit de nodul pt care calculez importanta, daca e in relatie cu node

                            if(person.thereIsRelationship(nodes.get(i))){
                                importance++;
                            }
                        }
                        person.setImportance(importance);
                    }
                    if(node instanceof Company){//COMPANY
                        for(i=0;i<nodes.size();i++){
                            //numar doar persoanele care au aceasta companie in lista lor de relatii
                            if(nodes.get(i) instanceof Person){
                                Person person=(Person) nodes.get(i);
                                    if(person.thereIsRelationship(node))
                                        importance++;
                            }
                        }
                        ((Company)node).setImportance(importance);
                    }
                    return importance;
                }
                else {
                    return 0;
                }

            }
            return 0;
    }

    public int getSize()
    {
        return nodes.size();
    }
    public Node getNode(int position)
    {
        return nodes.get(position);
    }

    /**
     * Sorts this network by importance
     *
     */
    public void sortNetworkImportance()
    {
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                 if(o1.getImportance()==o2.getImportance())
                     return 0;
                 if(o1.getImportance()<o2.getImportance())
                     return -1;
                 if(o1.getImportance()>o2.getImportance())
                     return 1;
                return 0;
            }
        });
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
