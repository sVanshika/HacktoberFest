import java.util.Scanner;
class Q10_matrix_multiply
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("**Matrix 1**");
        System.out.print("Rows: ");
        int row1 = sc.nextInt();
        System.out.print("Columns: ");
        int col1 = sc.nextInt();
        int r=0, c=0, mat1[][] = new int[row1][col1];
        for(r=0; r<row1; r++) //inputting values from the user
        {
            for(c=0; c<col1; c++)
            {
                System.out.print("Row "+(r+1)+" Column "+(c+1)+" : ");
                mat1[r][c] = sc.nextInt();
            }
        }

        System.out.println("\n**Matrix 2**");
        System.out.print("Rows: ");
        int row2 = sc.nextInt();
        System.out.print("Columns: ");
        int col2 = sc.nextInt();

        if(col1 == row2) //checking whether they can be multiplied
        {
            int mat2[][] = new int[row2][col2];
            for(r=0; r<row2; r++) //inputting values of mat2 from user
            {
                for(c=0; c<col2; c++)
                {
                    System.out.print("Row "+(r+1)+" Column "+(c+1)+" : ");
                    mat2[r][c] = sc.nextInt();
                }
            }

            System.out.println("-- Matrix 1 --"); //display matrix1
            display(mat1,row1,col1);

            System.out.println("-- Matrix 2 --"); //display matrix 2
            display(mat2,row2,col2);   

            multiply(mat1,row1,col1,mat2,row2,col2);//mat1*mat2 by method call
        }
        else
            System.out.println("---------- \nError: Matrix can't be multiplied as no. of columns of matrix1 is not equals to no. of rows of matrix2");
        
    }

    public static void multiply(int mat1[][],int row1,int col1,int mat2[][],int row2,int col2)
    {
        //multiplies two matrix
        int mat3[][] = new int[row1][col2];
        int sum=0, r=0, c=0, r2=0;
            for(r=0; r<row1; r++) //r - row of mat1
            {
                for(c=0; c<col2; c++)//c - column of mat2
                {
                    for(r2=0; r2<row2; r2++)//r2 - row of mat2; to get elements of column
                    {
                        sum += mat1[r][r2]*mat2[r2][c];
                    }
                    mat3[r][c]=sum;
                    sum=0;
                }
            }
            System.out.println("-- Product of Matrix 1 & Matrix 2 --");
            display(mat3,row1,col2);
    }

    public static void display(int mat[][], int row, int col)
    {
        //displays the matrix
        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
                System.out.print(mat[r][c] + " ");
            System.out.println();
        }
    }

}
