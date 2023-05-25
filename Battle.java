
package fantasyadventure;

import static fantasyadventure.FantasyAdventure.rand;
import java.io.*;
import java.util.Random;


public class Battle
{
    
    
    
    
public static void player() throws IOException
{
     while(true)
     {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Options:\n"
        +"HP: "+FantasyAdventure.player_hp+"\n"
        +"1. fight\n"
        +" 2. health\n\n\n");
        System.out.println("-------------------------------------\n");
        System.out.print("Input: ");
        String c = br.readLine();
        System.out.print("\n-------------------------------------\n"); 
                if ("fight".equals(c))
                {   
                    int x = rand.nextInt(6); 
                    if (x<4)
                    {
                        System.out.println("You hit the monster.\n");
                        FantasyAdventure.monster_hp-=1;
                    }
                    else
                    {
                        System.out.println("Miss.\n");
                    }
                    break;
                }
                else if ("health".equals(c))
                {   
                    if(FantasyAdventure.potions > 0)
                    {    
                       FantasyAdventure.player_hp +=5;
                       FantasyAdventure.potions-=1;
                       break;
                    }
                    else
                    {
                        System.out.println("You do not have any potions.");
                    }
                } 
                else
                {
                    System.out.println("You did nothing.");
                }
     }
}
    public static void monster() throws IOException
    {
        int y = rand.nextInt(6); 
        PrintWriter pw = new PrintWriter(System.out, true);
        if (y < 4)
        {
            pw.println("The Ogre attacked you.\n");
            FantasyAdventure.player_hp-=1;
        }
        
        else
        {
            pw.println("The Ogre missed.\n");  
        }
        
    }
    public static void red_dragon() throws IOException
    {
        int y = rand.nextInt(6); 
        PrintWriter pw = new PrintWriter(System.out, true);
        if (y < 4)
        {
            pw.println("The Red Dragon attacked you.\n");
            FantasyAdventure.player_hp-=2;
        }
        
        else
        {
            pw.println("The Red Dragon missed.\n");  
        }
    }
    
}



/*
Next Idea: One-player Tic Tac Toe
*/
