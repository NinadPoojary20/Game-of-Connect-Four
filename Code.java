import java.util.*;

public class Code{
    //create() is used to create the structure of the the give row and col.
    public static String[][] create(int r, int c){
        String a[][] = new String[r][c*2+1];    //c*2+1 is done because we are storing the '|' and 'r or y' in the array.
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                if(j%2 == 0)        //for even place we are storing '|' as a seperater.
                    a[i][j] = "|";
                else                //for odd place we store ' ' blank.
                    a[i][j] = " ";
            }
        }
        return a;
    }
    // print() is used to print the are structure to the user.
    public static void print(String[][] a){
        for (int i =0; i<a.length; i++)
        {
            for (int j=0; j<a[i].length; j++)
                System.out.print(a[i][j]);
            System.out.println("\n");
        }
    }
    // forRed() is used for adding the dice in the required position for red player.
    public static int forRed(String[][] a){
        System.out.println("......Player Red......");
        System.out.print("Which column do you want to insert (1-7)");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt()*2-1;   // to get the proper odd position of the column.
        for(int i=a.length-1; i>=0; i--){
            if(a[i][c] == " "){     // if the given position is empty then the 'r' is stored.
                a[i][c] = "r";
                return 0;
            }
        } 
        System.out.println("Column "+c+" is full.");    // if the give column is full then tis will print and then return the value as 1.
        return 1;   
    }
    // forYellow() is used for adding the dice in the required position for yellow player.
    public static int forYellow(String[][] a){
        System.out.println("......Player Yellow......");
        System.out.print("Which column do you want to insert (1-7)");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt()*2-1;   // to get the proper odd position of the column.
        for(int i=a.length-1; i>=0; i--){
            if(a[i][c] == " "){     // if the given position is empty then the 'y' is stored.
                a[i][c] = "y";
                return 0;
            }
        }
        System.out.println("Column "+c+" is full.");    // if the give column is full then tis will print and then return the value as '1'.
        return 1;    
    }
    //winner() is used to check which player is winner and display it respectively.
    public static String winner(String[][] a, int cntw){
    //For Horizontal check.
        for(int i=0; i<a.length; i++){
            int rcnt=1,ycnt=1;
            for(int j=1; j<a[i].length && ((j+2)!= a[i].length); j++){
                if(a[i][j].equals("r")){            //this if is for 'r' player.
                    if(a[i][j].equals(a[i][j+2]))   //if a[i][j] is equal to a[i][j+2] then only the counter will be incremented.
                        rcnt++;                     // to check whether the is the any common 'r' in the horizontal position.
                    else if(a[i][j+2]!=" ")         // this will execute only if a[i][j+2] is 'y'.
                        rcnt = 1;                   // it will initialized to '1' if there is no consecutive 'r' in the horizontal position.
                }
                else if(a[i][j].equals("y")){       //this if is for 'y' player.
                    if(a[i][j].equals(a[i][j+2]))   //if a[i][j] is equal to a[i][j+2] then only the counter will be incremented.
                        ycnt++;                     // to check whether the is the any common 'y' in the horizontal position.
                    else if(a[i][j+2]!=" ")         // this will execute only if a[i][j+2] is 'r'.
                        ycnt = 1;                   // it will initialized to '1' if there is no consecutive 'y' in the horizontal position.
                }
            }
            if(rcnt == cntw)                        //it will check 'r' count with the give count.
                return "r";                         // if it is same it will return 'r'.
            else if(ycnt == cntw)                   //it will check 'y' count with the give count.
                return "y";                         //if it is same it will return 'y'.
        }
    //For Vertical check.
    int cl=a[0].length;
    for(int i=0; i<cl ; i++){
        int rcnt=1,ycnt=1;
        for(int j=0;j<a.length && ((j+1)!= a.length);j++){
            if(a[j][i].equals("r")){                //this if is for 'r' player.
                if(a[j][i].equals(a[j+1][i]))       //if a[j][i] is equal to a[j+1][i] then only the counter will be incremented.
                    rcnt++;                         // to check whether the is the any common 'r' in the vertical position.
                else if(a[j+1][i] != " ")           // this will execute only if a[j+1][i] is 'y'.
                    rcnt=1;                         // it will initialized to '1' if there is no consecutive 'r' in the vertical position.
            }
            else if(a[j][i].equals("y")){           //this if is for 'y' player.
                if(a[j][i].equals(a[j+1][i]))       //if a[j][i] is equal to a[j+1][i] then only the counter will be incremented.
                    ycnt++;                         // to check whether the is the any common 'y' in the vertical position.
                else if(a[j+1][i] != " ")           // this will execute only if a[j+1][i] is 'r'.
                    ycnt=1;                         // it will initialized to '1' if there is no consecutive 'y' in the vertical position.
            }
        }
        if(rcnt == cntw)                            //it will check 'r' count with the give count.
            return "r";                             // if it is same it will return 'r'.
        else if(ycnt == cntw)                       //it will check 'y' count with the give count.
            return "y";                             //if it is same it will return 'y'.
    }
    //For Diagnol check.
    
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 0, col = 0, cntWin = 0;
        int ar = Integer.parseInt(args[0]);         //take value from command line and assign to it.....
        int ac = Integer.parseInt(args[1]);         //values from command line are row, column and piece.
        int ap = Integer.parseInt(args[2]);
        while(true){
            if(ar >= 2){                            //it will check whether the row value is greater than or equal to 2. 
                row = ar;
                break;
            }
            else{                                   //if the value is less than 2 then the user has to re-enter the row value.
                System.out.println("Please enter the valid row(should be greater than or equal to 2).");
                System.out.print("Enter the valid row = ");
                row = sc.nextInt();
            }
        }
        while(true){
            if(ac >= 2){                            //it will check whether the column value is greater than or equal to 2.
                col = ac;
                break;
            }
            else{                                   //if the value is less than 2 then the user has to re-enter the row value.
                System.out.println("Please enter the valid column(should be greater than or equal to 2).");
                System.out.print("Enter the valid column = ");
                col = sc.nextInt();
            }
        }
        
        while(true){
            if((col >= ap || row >= ap) && ap != 0 && ap != 1){//it will check whether the piece value from command line is greater or equal to row or column and not less than 1.
                cntWin = ap;
                break;
            }
            else if((col >= cntWin || row >= cntWin) && cntWin != 0 && cntWin != 1)// it will check whether the give value is corect or not from the user.
                break;
            else{                                    //player has to re-enter the piece value.
                System.out.println("Please enter the valid piece (should be less than or equal to row or column).");
                System.out.print("Enter the value of piece = ");
                cntWin = sc.nextInt();
            }
        }
        String[][] a = create(row,col);             // create the structure by create() by passing row and column value.
        print(a);                                   // print the created structure to the player.
        String color;
        int cnt, full=1;
        while(true){                                // this while loop is used to accept the player colour choise.
            System.out.print("Which colour you want to select 'red' or 'yellow' (r or y)");
            color = sc.next();
            if(color.equals("r")){                  // if user select red as colour.
                cnt = 0;
                break;
            }
            else if(color.equals("y")){             // if user select yellow as colour.
                cnt = 1;
                break;
            }
            else
                System.out.println("Please Enter the valid colour.");
        }    
        while(full <= (row * col)){                 // this loop will run until the array is full or the player has win the game. 
            if(cnt == 0){                           // '0' indicate the 'red' colour.
                int re = forRed(a);                 // forRed() return '0' or '1'.
                if(re == 0){                        // if 're' is '0' then the 'r' is entered in the array.
                    print(a);
                    cnt=1;
                }
            }
            else if(cnt == 1){                      // '1' indicate the 'yellow' colour.
                int yel = forYellow(a);             // forYellow() return '0' or '1'.
                if(yel == 0){                       // if 'yel' is '0' then the 'y' is entered in the array.
                    print(a);
                    cnt=0;
                }
            }
            String win = winner(a, cntWin);         // it will check whether 'red' or 'yellow' is winner and return the value 'r' or 'y'.
            if(win != null){
                if(win.equals("r"))                 // if 'win' is equal to 'r' then the player 'red' is winner.
                    System.out.println("Player Red is Winner.");
                else                                // if 'win' is equal to 'y' then the player 'yellow' is winner.
                    System.out.println("Player Yellow is Winner.");
                break;
            }
            full++;                                 //counter is incremented.
        }
        if(full > (row * col))                      // if full is greater then 'row*col' means the array is full.
            System.out.println("Game Over.....");
    }
}