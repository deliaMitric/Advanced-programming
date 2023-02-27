//@DeliaMitric
public class Homework {

    static int[][] createLatinMatrix(int n)
    {
        int[][] LatinMatrix;
        LatinMatrix =  new int[n][n];
        int i, j, finalValueOfLine;
        finalValueOfLine = 1;


        for(i=0; i<n; i++)
        {
            for(j=0;j<n;j++) {
                if (j == 0) {
                    LatinMatrix[i][j] = finalValueOfLine;

                } else {
                    if (LatinMatrix[i][j-1] <= n) LatinMatrix[i][j] = LatinMatrix[i][j - 1] + 1;
                    if (LatinMatrix[i][j-1] == n ) LatinMatrix[i][j] = 1;
                }

            }
            finalValueOfLine = LatinMatrix[i][n-1];

        }

        return LatinMatrix;
    }

    static void printLinesColumns(int[][] LatinMatrix, int n)
    {
        int i, j;
        StringBuffer number = new StringBuffer(2 * n);
        //number.append("");

        //System.out.println("Lines:");
        for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
            {
                number.append(Integer.toString(LatinMatrix[i][j]));
            }
            //System.out.println(number);
            number.delete(0,number.capacity());
        }

        //System.out.println("Columns:");
        for(j=0; j<n; j++)
        {
            for(i=0; i<n; i++)
            {
                number.append(Integer.toString(LatinMatrix[i][j]));
            }
            //System.out.println(number);
            number.delete(0,number.capacity());
        }
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        //pas1
        int n;
        n = Integer.parseInt(args[0]);

        //pas2
        int[][] LatinMatrix;
        LatinMatrix =  new int[n][n];
        LatinMatrix = createLatinMatrix(n);

        /*for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
            {
                System.out.print(LatinMatrix[i][j] + " ");
            }
            System.out.println();
        }*/

        //pas3
        printLinesColumns(LatinMatrix,n);
        long endTime = System.nanoTime();

        //pas4
        System.out.print("Running time in nanoseconds: ");
        System.out.println(endTime - startTime);

    }
}