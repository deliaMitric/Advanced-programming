package newP;
/**
 *FindPath is a class that extends Algorithm class.
 * Resolves the problem of searching if there is a path into two Locations using the Roads of the Problem
 *
 * @author Delia
 */
public class  FindPath extends Algorithm{
    private int var=0;

    /**
     * Creates a graph (using the Graph class) for the Problem instance and verify (using a BFs algorithm from Graph class) if there is a path into the teo given locations.
     *
     * @param pb represents a Problem object
     * @param l1 represents a Location object
     * @param l2 represents a Location object
     * @return
     */
    public boolean algorithm(Problem pb, Location l1, Location l2)
    {
        //avem  datele problemei, deci cautam daca avem un drum de la L1 la L2
        if(pb.problemValidation())
        {
            if(l1.equals(l2))
                return true;

            //continuam
            if(pb.haveLocation(l1)!=-1 && pb.haveLocation(l2)!=-1)
            {
                //algoritm
                int numberOfLocations = pb.getNumberOfLocations();
                int leftE, rightE;
                Graph g=new Graph(numberOfLocations);
                Road[] roads= pb.getRoads();

                for(int i=0;i<pb.getNumberOfRoads();i++)//adaugam muchiile in graf
                {
                    leftE=pb.getIndexOfLoc(roads[i].getLoc1());
                    rightE=pb.getIndexOfLoc(roads[i].getLoc2());

                    if(leftE!=-1 && rightE!=-1)
                        g.addEdge(leftE,rightE);
                }

                if(g.BFS(pb.getIndexOfLoc(l1),pb.getIndexOfLoc(l2)))
                    return true;
                return false;
            }
            else {
                System.out.println("Invalid locations!");
                return false;
            }


        }
        else
            System.out.println("Invalid problem!");
        return false;
    }

}
