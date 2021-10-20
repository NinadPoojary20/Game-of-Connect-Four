import java.util.*;

public class Code{
    public static String[][] create(int r, int c){
        String a[][] = new String[r][c*2+1];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                if(j%2 == 0)
                    a[i][j] = "|";
                else
                    a[i][j] = " ";
            }
        }
        return a;
    }

    public static void print(String[][] a){
        for (int i =0; i<a.length; i++)
        {

            for (int j=0; j<a[i].length; j++)
            {
                System.out.print(a[i][j]);
            }
            System.out.println("\n");
        }

    }
    public static int forRed(String[][] a){
        System.out.print("Which column do you want to insert (1-7)");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt()*2-1;
        for(int i=a.length-1; i>=0; i--){
            if(a[i][c] == " "){
                a[i][c] = "r";
                return 0;
            }
        } 
        System.out.println("Column "+c+" is full.");
        return 1;   
    }
    public static int forYellow(String[][] a){
        System.out.print("Which column do you want to insert (1-7)");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt()*2-1;
        for(int i=a.length-1; i>=0; i--){
            if(a[i][c] == " "){
                a[i][c] = "y";
                return 0;
            }
        }
        System.out.println("Column "+c+" is full.");
        return 1;    
    }
    public static String winner(String[][] a, int cntw){
    //For Horizontal check.
        for(int i=0; i<a.length; i++){
            int rcnt=1,ycnt=1;
            for(int j=1; j<a[i].length && ((j+2)!= a[i].length); j++){
                if(a[i][j].equals("r")){
                    if(a[i][j].equals(a[i][j+2]))
                        rcnt++;
                    else
                        rcnt=1;
                }
                else if(a[i][j].equals("y")){
                    if(a[i][j].equals(a[i][j+2]))
                        ycnt++;
                    else
                        ycnt=1;
                }
            }
            if(rcnt == cntw)
                return "r";
            else if(ycnt == cntw)
                return "y";
        }
    //For Vertical check.
    int cl=a[0].length;
    for(int i=0; i<cl ; i++){
        int rcnt=1,ycnt=1;
        for(int j=0;j<a.length && ((j+1)!= a.length);j++){
            if(a[j][i].equals("r")){
                if(a[j][i].equals(a[j+1][i]))
                    rcnt++;
                else
                    rcnt=1;
            }
            else if(a[j][i].equals("y")){
                if(a[j][i].equals(a[j+1][i]))
                    ycnt++;
                else
                    ycnt=1;
            }
        }
        if(rcnt == cntw)
            return "r";
        else if(ycnt == cntw)
            return "y";
    }
    //For Diagnol check.
    
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 0, col = 0, cntWin = 0;
        int ar = Integer.parseInt(args[0]);
        int ac = Integer.parseInt(args[1]);
        int ap = Integer.parseInt(args[2]);
        while(true){
            if(ar >= 2){
                row = ar;
                break;
            }
            else{
                System.out.println("Please enter the valid row(should be greater than or equal to 2).");
                System.out.print("Enter the valid row = ");
                row = sc.nextInt();
            }
        }
        while(true){
            if(ac >= 2){
                col = ac;
                break;
            }
            else{
                System.out.println("Please enter the valid column(should be greater than or equal to 2).");
                System.out.print("Enter the valid column = ");
                col = sc.nextInt();
            }
        }
        
        while(true){
            if((col >= ap || row >= ap) && ap != 0 && ap != 1){
                cntWin = ap;
                break;
            }
            else if((col >= cntWin || row >= cntWin) && cntWin != 0 && cntWin != 1)
                break;
            else{
                System.out.println("Please enter the valid piece (should be less than or equal to row or column).");
                System.out.print("Enter the value of piece = ");
                cntWin = sc.nextInt();
            }
        }
        String[][] a = create(row,col);
        print(a);
        String color;
        int cnt, full=1;
        while(true){
            System.out.print("Which colour you want to select 'red' or 'yellow' (r or y)");
            color = sc.next();
            if(color.equals("r")){
                cnt = 0;
                break;
            }
            else if(color.equals("y")){
                cnt = 1;
                break;
            }
            else
                System.out.println("Please Enter the valid colour.");
        }    
        while(full <= (row * col)){
            if(cnt == 0){
                int re = forRed(a);
                if(re == 0)
                    print(a);
                cnt=1;
            }
            else{
                int yel = forYellow(a);
                if(yel == 0)
                    print(a);
                cnt=0;
            }
            String win = winner(a, cntWin);
            if(win != null){
                if(win.equals("r"))
                    System.out.println("Player Red is Winner.");
                else
                    System.out.println("Player Yellow is Winner.");
                break;
            }
            full++;
        }
        if(full > (row * col))
            System.out.println("Game Over.....");
    }
}