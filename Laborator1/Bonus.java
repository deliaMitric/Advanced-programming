//@DeliaMitric
import java.util.Scanner;

public class Bonus {
    public static int[][] createAdjacencyMatrixCyclicGraph(int n)
    {
        int[][] matrix;
        matrix = new int[n+1][n+1];

        int i, j;
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                matrix[i][j]=0;

        //1
        for(j=1;j<=n;j++)
            if(j==2 || j==n) {
                matrix[1][j] = 1;
                matrix[j][1] = 1;
            }
            else
                matrix[1][j]=0;

        //2->n-1
        for(i=2;i<n;i++)
        {
            for(j=1;j<=n;j++)
                if(j==i+1) {
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
        }
        return matrix;
    }

    public static int[][] powersOfAdjacencyMatrix(int[][] adjacencyMatrix, int n, int [][] matrix )
    {
        int  common, i, j, result;
        int [][] resultMatrix;
        result = 0;
        resultMatrix = new int[n+1][n+1];

            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    for (common = 1; common <= n; common++) {
                        result += matrix[i][common] * adjacencyMatrix[common][j];
                    }
                    resultMatrix[i][j] = result;
                    result = 0;
                }
            }
        return resultMatrix;
    }
    public static int[][] createAdjacencyMatrixRegularGraph(int n, int vertexDegree)
    {
        int[][] matrix;
        matrix = new int[n+1][n+1];
        int i, j;

        int[] vDegrees;//array ul cu gradele nodurilor la un moment dat
        vDegrees =  new int[n+1];
        for(i=1;i<=n;i++)
            vDegrees[i] = 0;

        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                matrix[i][j] = 0;

        for(j=n;j>=1;j--)
        {
            i=1;
            while(vDegrees[j] < vertexDegree && i<=n)
            {
                if(vDegrees[i] < vertexDegree) {
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                    vDegrees[i]++;
                    vDegrees[j]++;
                }
                i++;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] adjacencyMatrix, int n, int power)
    {
        int i, j;
        System.out.println("Cycle Graph:");
        System.out.println("Matrix A^" + power + ":");

        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
                System.out.print(adjacencyMatrix[i][j]+" ");
            System.out.println();
        }
    }

    public static void printMatrix2(int[][] adjacencyMatrix, int n)
    {
        int i, j;
        System.out.println("Regular Graph:");
        System.out.println("Matrix for regular graph:");

        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
                System.out.print(adjacencyMatrix[i][j]+" ");
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        //Cyclic Graph
        int n;
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of vertices of cycle graph:");
        n = console.nextInt();
        int[][] adjacencyMatrix;
        adjacencyMatrix = new int[n+1][n+1];
        adjacencyMatrix = createAdjacencyMatrixCyclicGraph(n);

        int i, j;
        int[][] powerAdjacencyMatrix;
        powerAdjacencyMatrix = new int[n+1][n+1];
        powerAdjacencyMatrix = adjacencyMatrix;

        //printMatrix(adjacencyMatrix,n,1);

        for(i=2;i<=n;i++)
        {
            powerAdjacencyMatrix = powersOfAdjacencyMatrix(adjacencyMatrix,n,powerAdjacencyMatrix);
            printMatrix(powerAdjacencyMatrix, n, i);
        }

        //Regular Graph
        int nVertex, vertexDegree;
        System.out.println("Enter the number of vertices and vertex degree for regular graph:");
        nVertex=console.nextInt();
        vertexDegree=console.nextInt();

        int[][] adjacencyMatrix2;
        adjacencyMatrix2=new int[nVertex+1][nVertex+1];

        if(nVertex<vertexDegree || (nVertex*vertexDegree)%2 == 1)
            System.out.println("These values aren't good for creating a regular graph");
        if(nVertex>=vertexDegree && (nVertex*vertexDegree)%2 == 0)
        {
            adjacencyMatrix2 = createAdjacencyMatrixRegularGraph(nVertex,vertexDegree);
            printMatrix2(adjacencyMatrix2,nVertex);
        }


    }
}