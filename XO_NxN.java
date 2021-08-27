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
        for (int x = 0; x<=row; x++)
        {
            for (int y = 0; y<=col; y++)
            {
                board_array[x][y] = " ";
            }
        }
    }

    public void display_board()
    {
        for (int x = 0; x<=row; x++)
        {
            for (int y = 0; y<=col; y++)
            {
                System.out.println(board_array[x][y]);
            }
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
                    if (arg <= 8 && arg >= 0)
                    {
                        board_array[2-(arg%3)][arg/3] = player;
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
        if (board_array[0][0] == board_array[0][1] && board_array[0][0] == board_array[0][2] && board_array[0][0] != " " || 
            board_array[1][0] == board_array[1][1] && board_array[1][0] == board_array[1][2] && board_array[1][0] != " " || 
            board_array[2][0] == board_array[2][1] && board_array[2][0] == board_array[2][2] && board_array[2][0] != " " || 
            board_array[0][0] == board_array[1][0] && board_array[0][0] == board_array[2][0] && board_array[0][0] != " " || 
            board_array[0][1] == board_array[1][1] && board_array[0][1] == board_array[2][1] && board_array[0][1] != " " || 
            board_array[0][2] == board_array[1][2] && board_array[0][2] == board_array[2][2] && board_array[0][2] != " " || 
            board_array[0][0] == board_array[1][1] && board_array[0][0] == board_array[2][2] && board_array[0][0] != " " || 
            board_array[0][2] == board_array[1][1] && board_array[0][2] == board_array[2][0] && board_array[0][2] != " " )
        {
            if (player == "X")
            {
                System.out.println("Player O Win");
            }
            else
            {
                System.out.println("Player X Win");
            }
            return true;
        }
        else if (turn_count == 9)
        {
            System.out.println("to end in a tie");
            return true;
        }
        else
        {
            return false;
        }
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
