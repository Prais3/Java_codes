//---------------------------------------------------------------------------------------------------------------
// Name: Varun Jani
// Email: vxj5053@psu.edu
// Class: CMPSC 122
// Program 1.1
// Due Date: September 19, 2018
//
// Description: This program reads the chessboard size and queen locations from the input file
// and prints a chessboard using the location of the queens. Then the other function/s check the
// safety of the queen in that location and check if the nqueen problem is solved or not.
//
// Acknowledgement:
// 1. I discussed with a tutor(Deep) at the learning center about the implementation of the chessboard for nqueen
// 2. I discussed with Austin how to solve the segmentation error (core dumped)
//---------------------------------------------------------------------------------------------------------------

#include <iostream>
#include <fstream>

using namespace std;

//Function to read values of the number of rows, columns and queens from the file
bool** ReadChessboard(char* filepath, int& num_rows, int& num_cols, int& num_queen)
{
    fstream infile;
    infile.open(filepath);

    infile >> num_rows;
    infile >> num_cols;
    infile >> num_queen;

    cout << endl;

    int a,b;
    
    //Creating a chessboard by dynamic memory allocation
    bool **board;
    board = new bool* [num_rows];
    for(int i = 0; i < num_rows; i ++)
        board[i] = new bool[num_cols];
    for(int j = 0; j < num_rows; j++)
        for(int y = 0; y < num_cols; y++)
        {
            board[j][y] = false;
        }

    //Getting the location of the queens from the file
    for(int x = 0; x < num_queen; x++)
    {
        infile >> a;
        infile >> b;

        board[a][b] = true;
    }

    return board;
}

//Function to print the chessboard
void PrintChessboard(bool** board, int num_rows, int num_cols)
{
    cout << "Print chess board:" << endl << endl;

    cout << "   ";
    
    //if-else statement to check rows and columns and print accordingly 
    if(num_rows >= num_cols)
     {
       for(int i = 0; i < num_rows; i++)
       {
        cout << i << "  ";
       }
     }
    else 
     {
       for(int j = 0; j < num_cols; j++)
        {
        cout << j << "  ";
        }
     }
   
    cout << endl;

    for(int i = 0; i < num_rows; i++)
    {
        cout << i << "  ";

        for(int j = 0; j < num_cols; j++)
        {
            if(board[i][j] == true)
            {
                cout << "Q" << "  ";
            }
            else
            {
                cout << "." << "  ";
            }
        }

        cout << endl << endl;
    }
}

//Function to check whether this is a Nqueen problem or not
bool Check_Nqueen(int num_rows, int num_cols, int num_queens)
{
  if(num_queens != num_rows || num_queens != num_cols)
    {
      return false;
    }
    else
    {
      return true;
    }

  return false;
}

//Function to check the safety of the queen at that location and return true if the nqueen problem is solved
bool Check_Cell_Safety(bool **board, int num_rows, int num_cols)
{
    int sum = 0;
    
    //Many for loops here to check the rows, columns and diagonals to check if the queens are safe or not
    for(int i = 0; i < num_rows; i++)
    {
        sum = 0;
        for (int j = 0; j < num_cols; j++)
        {
            sum += board[i][j];
            if (sum > 1)
            {
                return false;
            }
        }
    }
    
    for(int i = 0; i < num_cols; i++)
    {
        sum = 0;
        for (int j = 0; j < num_rows; j++)
        {
            sum += board[j][i];
            if (sum > 1)
            {
                return false;
            }
        }
    }

    for(int i = 0; i < num_rows; i++)
    {
        sum = 0;
        for (int r = i, c = 0; r < num_rows && c < num_cols; r++, c++)
        {
            sum += board[r][c];
            if(sum > 1)
            {
                return false;
            }
        }
    }

    for(int i = 0; i < num_cols; i++)
    {
        sum = 0;
        for (int r = 0, c = i; r < num_rows && c < num_cols; r++, c++)
        {
            sum += board[r][c];
            if(sum > 1)
            {
                return false;
            }
        }
    }

    for(int i = num_rows - 1; i >= 0; i--)
    {
        sum = 0;
        for(int r = i, c = 0; r >= 0 && c < num_cols; r--, c++)
        {
            sum += board[r][c];
            if(sum > 1)
            {
                return false;
            }
        }
    }

    for(int i = 0; i < num_cols; i++)
    {
        sum = 0;
        for(int r = num_rows - 1, c = i; r >= 0 && c < num_cols; r--, c++)
        {
            sum += board[r][c];
            if(sum > 1)
            {
                return false;
            }
        }
    }

    return true;
}

//Function to destroy the board (So as to delete the allocated memory) after the problem is solved
void Destroy_Board(bool **board, int num_cols)
{
    for(int i = 0; i < num_cols; i++)
    {
        delete [](board[i]);
    }

    delete []board;
    board = NULL;
}

int main(int argc, char* argv[])
{
    if(argc <= 1)
    {
        cout << "Need the input file containing chess board size and queen locations." << endl;
        return 0;
    }

    int num_rows, num_cols, num_queen;

    bool** board = ReadChessboard(argv[1], num_rows, num_cols, num_queen);

    PrintChessboard(board, num_rows, num_cols);
    
    cout << endl;
    
    //Calling the functions 
    bool nqueen = Check_Nqueen(num_rows, num_cols, num_queen);
    bool there_are_attacks = Check_Cell_Safety(board, num_rows, num_cols);

    if(nqueen == true)
    {
        cout << "Solution to the N Queen Problem? Yes" << endl << endl;
    }
    else
    {
        cout << "Solution to the N Queen Problem? No" << endl << endl;
    }

    if(there_are_attacks == 1)
    {
      cout << "There is no queen attacking other queen(s)" << endl;
    }
    else
    {
      cout << "There is at least one queen attacking other queen(s)" << endl;
    }
    
    void Destroy_Board();

    return 0;
}


