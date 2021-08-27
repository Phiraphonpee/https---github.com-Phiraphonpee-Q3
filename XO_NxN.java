import java.util.Scanner;
public class XO_NxN {
    public String[][] board_array;
    public String player = "X";
    public int turn_count = 0;
    public int row,col;

    public void Select_borad()
    {
        System.out.print("Please select row borad: ");
        Scanner sc=new Scanner(System.in);
        row = sc.nextInt();
        System.out.print("Please select column borad: ");
        col = sc.nextInt();
        board_array = new String[row][col];
        int countnum = 0;
        for (int x = 0; x<row; x++)
        {
            for (int y = 0; y<col; y++)
            {
                countnum++;
                if(countnum<10){
                    board_array[x][y] = " " + Integer.toString(countnum);
                }
                else
                {
                    board_array[x][y] = Integer.toString(countnum);
                }
            }
        }
    }

    public void display_board()
    {
        for (int x = 0; x<row; x++)
        {
            for (int y = 0; y<col; y++)
            {
                System.out.printf("| %s |",board_array[x][y]);

            }
            System.out.println();
        }
    }

    public void change_player() 
    {
        if (player == "X")
            { 
                player = "O";
            }
        else
            {
                player = "X";
            }
    }

    public void add_postion()
    {
        boolean done = false;
            while(!done)
            {
                try 
                {
                    Scanner sc=new Scanner(System.in);
                    System.out.print("Please select your position : ");
                    int position=sc.nextInt();
                    int arg = position-1;
                    if (arg <= (row*col - 1) && arg >= 0 )
                    {
                        board_array[arg/row][arg%col] = player;
                        done = true;
                    }
                    else
                    {
                        System.out.println("You entered wrong key");
                        done = false;
                    }
                }
                catch (Exception e) 
                {
                    System.out.println("You entered wrong key");
                    done = false;
                }
            }
        this.display_board();
    }

    public boolean check_winner()
    {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        //เช็คrow
        for(int y=0; y<col; y++)
        {
            for(int x=0; x<row-1; x++)
            {
                if(board_array[x][y] == board_array[x+1][y])
                {
                    count1++;
                    if(count1 == col-1)
                    {
                        System.out.printf("Player %s Win",board_array[x][y]);
                        return true;
                    }
                }
            }
            count1 = 0;
        }
        //เช็คcolumn
        for(int x=0; x<row; x++)
        {
            for(int y=0; y<col-1; y++)
            {
                if(board_array[x][y] == board_array[x][y+1])
                {
                    count2++;
                    if(count2 == row-1)
                    {
                        System.out.printf("Player %s Win",board_array[x][y]);
                        return true;
                    }
                }
            }
            count2 = 0;
        }
        //เช็คซ้ายบนไปขวาล่าง
        for(int x=0; x<row-1; x++)
        {
            for(int y=0; y<col-1; y++)
            {
                if(x == y && board_array[x][y] == board_array[x+1][y+1])
                {
                    count3++;
                    if(count3 == row-1)
                    {
                        System.out.printf("Player %s Win",board_array[x][y]);
                        return true;
                    }
                }
            }
        }
        //เช็คขวาบนไปซ้ายล่าง
        for(int x=0; x<row-1; x++)
        {
           if (board_array[x][row-1-x] == board_array[x+1][row-2-x])
           {
               count4++;
               if(count4 == row-1)
               {
                   System.out.printf("Player %s Win",board_array[x][row-1-x]);
                   return true;
               }
           }
        }
        if(turn_count == row*col)
        {
            System.out.println("to end in a tie");
            return true;
        }
        turn_count++;
        return false;
    }
    public static void main(String[] args) {

        XO_NxN board = new XO_NxN();
        board.Select_borad();
        board.display_board();
        while(board.check_winner() == false)
        {
            board.add_postion();
            board.change_player();

        }
    }
}
