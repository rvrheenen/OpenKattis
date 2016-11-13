#include <iostream>
#include <string>
#include <math.h>
using namespace std;

void printArray(int array[], int length) {
    for (int i = 0; i < length; i++) {
        cout << array[i] << endl;
    }
}

// // swaps two rows
// void swapRows(double m[][], int row1, int row2) {
//     // double [] swap = new double[m[0].length];
//     double swap[sizeof(m[0])/sizeof(*m[0])];

//     for(int c1 = 0; c1 < (sizeof(m[0])/sizeof(*m[0])); c1++){
//         swap[c1] = m[row1][c1];
//     }

//     for(int c1 = 0; c1 < (sizeof(m[0])/sizeof(*m[0])); c1++) {
//         m[row1][c1] = m[row2][c1];
//         m[row2][c1] = swap[c1];
//     }
//     // return m;
// }

// void multiplyRow(double m[][], int row, double scalar) {
//     for(int c1 = 0; c1 < (sizeof(m[0])/sizeof(*m[0])); c1++) {
//         m[row][c1] *= scalar;
//     }
//     // return m;
// }

// void subtractRows(double m[][], double scalar, int subtract_scalar_times_this_row, int from_this_row) {
//     for(int c1 = 0; c1 < sizeof(m[0])/sizeof(*m[0]); c1++) {
//         m[from_this_row][c1] -= scalar * m[subtract_scalar_times_this_row][c1];
//     }
//     // return m;
// }

// void rref(double **m) {
//     int lead = 0;
//     int rowCount = m.length;
//     int colCount = m[0].length;
//     int i;
//     int quit = 0;

//     for(int row = 0; row < rowCount && !quit; row++) {
//         if(colCount <= lead) {
//             quit = 1;
//             break;
//         }
//         i = row;
//         while(!quit && m[i][lead] == 0) {
//             i++;
//             if(rowCount == i) {
//                 i = row;
//                 lead++;
//                 if(colCount == lead) {
//                     quit = 1;
//                     break;
//                 }
//             }
//         }

//         if(!quit) {
//             swapRows(m, i, row);

//             if(m[row][lead] != 0) {
//                 multiplyRow(m, row, 1.0f / m[row][lead]);
//             }

//             for(i = 0; i < rowCount; i++) {
//                 if(i != row){
//                     subtractRows(m, m[i][lead], row, i);
//                 }
//             }
//         }
//     }
// }

int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    int ring[n];
    int ans[n];

    // construct the ring
    for (int i = 0; i < n; i++) {
        cin >> ring[i];
    }
    // case 1
    if (n == 1) {
        ans[0] = ring[0];
    }

    // case 2
    if (n == 2) {
        ans[0] = (int) ceil((double) ring[0] / 2);
        ans[1] = (int) floor((double) ring[0] / 2);
    }

    // case 3
    if (n == 3) {
        ans[0] = (int) ceil((double) ring[0]/2);
        int temp = (int) floor((double) ring[0]/2);
        ans[1] = (int) floor((double) temp/2);
        ans[2] = (int) ceil((double) temp/2);
    }

    if (n < 4) {
        printArray(ans, n);
    } else {
    
        double matrix[n][n + 1];
        for (int i = 0; i < n; i++) {
            //self
            matrix[i][i] = 1;
            //left neighbor
            if (i == 0) {
                matrix[i][n-1] = 1;
            } else {
                matrix[i][i-1] = 1;
            }
            // right neighbor
            if (i == n-1) {
                matrix[i][0] = 1;
            } else {
                matrix[i][i+1] = 1;
            }
            // add ring value
            matrix[i][n] = ring[i];
        }
        rref(matrix);
        
        for (int i = 0; i < n; i++) {
            cout << matrix[i][n];
        }
    }

    // printArray(ans, n);


}


/*
public class Kemija {
    public static void main(String[] args) throws IOException {
        IO io = new IO(System.in);
        
        int n = io.nextInt();
        int[] ring = new int[n];
        
        // construct the ring
        for (int i = 0; i < n; i++) {
            ring[i] = io.nextInt();
        }
        
        int[] ans = new int[n];
        // case 1
        if (n == 1) {
            ans[0] = ring[0];
        }
        // case 2
        if (n == 2) {
            ans[0] = (int) ceil((double) ring[0]/2);
            ans[1] = (int) floor((double) ring[0]/2);
        }
        // case 3
        if (n == 3) {
            ans[0] = (int) ceil((double) ring[0]/2);
            int temp = (int) floor((double) ring[0]/2);
            ans[1] = (int) floor((double) temp/2);
            ans[2] = (int) ceil((double) temp/2);
        }
        
        if (n < 4) {
            for (int i = 0; i < n; i++) {
                io.println(ans[i]);
            }
        } else {
        
            double[][] matrix = constructMatrix(n, ring);
            
            matrix = rref(matrix);
            
            for (int i = 0; i < n; i++) {
                io.println((int) matrix[i][n]);
            }
        }
        
        
        io.close();
    }
    
    
    public static double[][] constructMatrix(int n, int[] ring) {
        double[][] matrix = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            
            //self
            matrix[i][i] = 1;
            
            //left neighbor
            if (i == 0) {
                matrix[i][n-1] = 1;
            } else {
                matrix[i][i-1] = 1;
            }
            
            // right neighbor
            if (i == n-1) {
                matrix[i][0] = 1;
            } else {
                matrix[i][i+1] = 1;
            }
            
            // add ring value
            matrix[i][n] = ring[i];
        }
        
        return matrix;
    }
    
    static public double[][] rref(double [][] m)
    {
        int lead = 0;
        int rowCount = m.length;
        int colCount = m[0].length;
        int i;
        boolean quit = false;

        for(int row = 0; row < rowCount && !quit; row++)
        {

            if(colCount <= lead)
            {
                quit = true;
                break;
            }

            i=row;

            while(!quit && m[i][lead] == 0)
            {
                i++;
                if(rowCount == i)
                {
                    i=row;
                    lead++;

                    if(colCount == lead)
                    {
                        quit = true;
                        break;
                    }
                }
            }

            if(!quit)
            {
                m = swapRows(m, i, row);

                if(m[row][lead] != 0)
                    m = multiplyRow(m, row, 1.0f / m[row][lead]);

                for(i = 0; i < rowCount; i++)
                {
                    if(i != row)
                        m = subtractRows(m, m[i][lead], row, i);
                }
            }
        }
        return m;
    }

    // swaps two rows
    static double[][] swapRows(double [][] m, int row1, int row2)
    {
        double [] swap = new double[m[0].length];

        for(int c1 = 0; c1 < m[0].length; c1++)
            swap[c1] = m[row1][c1];

        for(int c1 = 0; c1 < m[0].length; c1++)
        {
            m[row1][c1] = m[row2][c1];
            m[row2][c1] = swap[c1];
        }
        return m;
    }

    static double[][] multiplyRow(double [][] m, int row, double scalar)
    {
        for(int c1 = 0; c1 < m[0].length; c1++) {
            m[row][c1] *= scalar;
        }
        return m;
    }

    static double[][] subtractRows(double [][] m, double scalar, int subtract_scalar_times_this_row, int from_this_row)
    {
        for(int c1 = 0; c1 < m[0].length; c1++) {
            m[from_this_row][c1] -= scalar * m[subtract_scalar_times_this_row][c1];
        }
        return m;
    }
    
}
*/