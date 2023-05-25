package fantasyadventure;

//imports for main function of the game
import java.io.IOException;                                 //
import java.io.*;              
import java.util.Arrays;
import java.util.Random;




public class FantasyAdventure 
{
    
    public static int future_pos = 0;
    public static int seek_pos = 0;
    public static int start_point = 3;
    public static Random rand = new Random();
    public static int x = rand.nextInt(28);
    public static int open_map [][] = {{0,0}, {2,0}, {5,0}, {3,1}, {6,1}, {0,2}, {2,2}, {6,2}, {7,2}, {8,2}, {0,3}, {1,3}, {2,3}, {3,3},
                                       {6,3}, {7,4}, {1,5}, {4,5}, {1,6}, {2,6}, {8,6}, {6,7}, {7,7}, {9,7}, {8,3}, {2,9}, {4,9}, {5,9}};
    public static int dragon_hp = 8;
    public static int player_hp = 10;
    public static int monster_hp = 5;
    public static int potions = 0;
    
   
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {   
        Battle battle = new Battle();
        String filecopy = "C:\\Users\\rettm\\Desktop\\Copy.txt";
        String filepath = "C:\\Users\\rettm\\Desktop\\FantasyAdventureMap.txt";
       
        title();
        instructions();
        writeFile(filecopy, filepath, seek_pos);
        player_start_pos(filepath);
        do
        {          
            if (future_pos == '-')
            {
                monster_hp = 5;
                while(true)
                {
                    if (player_hp <= 0)
                    {
                        System.out.println("GAME OVER\n");
                        System.exit(0);
                    }    

                    else if (monster_hp > 0)
                    {
                        
                        System.out.println("Monster: Ogre\n");
                        battle.player();
                        battle.monster();
                        
                    }
                    else if (monster_hp == 0)
                    {
                        System.out.println("The monster is defeated.\n");
                        player_hp +=2;
                        dis_map(filepath);
                        break;
                    }
                }
            }
           
            else if (future_pos == '$')
            {
                dragon_hp = 12;
                while(true)
                {
                    if (player_hp <= 0)
                    {
                        System.out.println("GAME OVER\n");
                        System.exit(0);
                    }    
                    
                    else if (dragon_hp > 0)
                    {
                        System.out.println("Monster: The Red Dragon\n");
                        battle.player();
                        battle.red_dragon();
                    }
                    
                    else if (dragon_hp == 0)
                    {
                        System.out.println("Congratulations! You won the game.\n");
                        System.exit(0);
                    }
                }
            }
            else
            {    
                dis_map(filepath);
            }
            future_pos = start_point;
        }while(!"stop".equals(input(filepath)));
      
    }
    
    public static String input(String filepath) throws IOException
    {
            Battle battle = new Battle();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("-------------------------------------\n");
            System.out.print("Input: ");
            String c = br.readLine();
            System.out.print("-------------------------------------\n");
            try (RandomAccessFile rac = new RandomAccessFile(filepath, "rw"))
            {
                
                    if (null == c)
                    {
                        System.out.println("What, 'stop'?");
                    }

                    else switch (c) 
                    { 
                         case "w":
                              if(start_point - 24 > 50)
                              {
                                  rac.seek(start_point-24);
                                  future_pos = rac.read();
                                  if((char)future_pos != '&')
                                  {    
                                    if ((char)future_pos == 'P')
                                        {
                                            potions +=1;
                                        }
                                    rac.seek(start_point);
                                    rac.write(" ".getBytes());
                                    start_point -=24;
                                    rac.seek(start_point);
                                    rac.write("X".getBytes());
                                    break;
                                  }
                                  else
                                  {
                                    System.out.println("You cannot go out of bounds.\n");
                                  }    
                                 
                              }
                              else
                              {
                                System.out.println("You cannot go out of bounds.\n");
                                break;
                              }
                         case "s":
                                if(start_point + 24 < 288)
                                {
                                    rac.seek(start_point + 24);
                                    future_pos = rac.read();
                                    if((char)future_pos != '&')
                                    {   
                                        if ((char)future_pos == 'P')
                                        {
                                            potions +=1;
                                        }
                                        rac.seek(start_point);
                                        rac.write(" ".getBytes());
                                        start_point +=24;
                                        rac.seek(start_point);
                                        rac.write("X".getBytes());
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("You cannot go out of bounds.\n");
                                    }    
                                     
                                }
                                else
                                {
                                   System.out.println("You cannot go out of bounds.\n");
                                   break;
                                }
                         case "a":
                                if(start_point != 51 & start_point != 75 & start_point != 99 &
                                   start_point != 123& start_point != 147& start_point != 171& 
                                   start_point != 195& start_point != 219& start_point != 243& start_point != 267)
                                {
                                    rac.seek(start_point - 2);
                                    future_pos = rac.read();
                                    if((char)future_pos != '&')
                                    {   
                                        if ((char)future_pos == 'P')
                                        {
                                            potions +=1;
                                        }
                                        rac.seek(start_point);
                                        rac.write(" ".getBytes());
                                        start_point -=2;
                                        rac.seek(start_point);
                                        rac.write("X".getBytes());
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("You cannot go out of bounds.\n");
                                    }    
                                     
                                }
                                else
                                {
                                   System.out.println("You cannot go out of bounds.\n");
                                   break;
                                }
                         case "d": 
                                    if(start_point != 69 & start_point != 93 & start_point != 117&
                                       start_point != 141& start_point != 165& start_point != 189& 
                                       start_point != 213& start_point != 237& start_point != 261& start_point != 285)
                                    {
                                        rac.seek(start_point + 2);
                                        future_pos = rac.read();
                                        if((char)future_pos != '&')
                                        {    
                                            if ((char)future_pos == 'P')
                                             {
                                                potions +=1;
                                             }
                                            rac.seek(start_point);
                                            rac.write(" ".getBytes());
                                            start_point +=2;
                                            rac.seek(start_point);
                                            rac.write("X".getBytes());
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("You cannot go out of bounds.\n");
                                        }    
                                    }
                                    else
                                    {
                                       System.out.println("You cannot go out of bounds.\n");
                                       break;
                                    }
                         default:
                         {
                             System.out.println("What, 'stop'?\n");
                         }
                    } 
            }
            
            
            catch(NumberFormatException | IOException exc)
            {
                System.out.println(exc);
            }
            return c;
    }
    public static void player_start_pos(String filepath)
    {
        int pos_x = open_map[x][0];
        int pos_y = open_map[x][1];
        try (RandomAccessFile rac = new RandomAccessFile(filepath, "rw"))
        {    
            
            rac.seek(start_point);

            for (int i = 0; i < pos_x; i++)
            {
                start_point+=2;
            }

            for (int i = 0; i < pos_y+2; i++)
            {
                start_point+=24;
            }
            
            rac.seek(start_point);
            rac.write("X".getBytes());
       
        }
         catch(NumberFormatException | IOException exc)
        {
            System.out.println(exc);
        }
        

       
    }
    
    public static void dis_sec(byte[] read)
    {   
   
            //take the position of the file pointer and move it accordingly
            //new moves items from one object to an entirely new object
            System.out.print(new String (read)); 
    }
    
    public static void dis_map(String filepath)
    {
    
     for(int i = 0; i<15; i++)
        {
            dis_sec(readFile(filepath, seek_pos));
            seek_pos+=25;
        }
     seek_pos-=seek_pos;
     System.out.println("");
    }
    
    public static void instructions()
    {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("INSTRUCTIONS:\n"
        +"Type 'stop' on map menu to quit the game.\n"
        +"w ~ move North\n"
        +"s ~ move South\n"
        +"a ~ move West\n"
        +" d ~ move East\n\n\n");
      
        pw.println("CHARACTERS:\n"
        +"X ~ King Phineas\n"
        +"- ~ Ogre\n"
        +"$ ~ The Red Dragon\n"
        +" P ~ Potion\n\n\n");
        
        pw.println("DURING BATTLE:\n"
        +"Type \"fight\" to attack.\n"
        +" Type \"health\" to regain health.\n");
   }
    
    public static void title()
    { 
        PrintWriter pw = new PrintWriter(System.out, true); 
        pw.println("Fantasy Adventure");
        pw.println("                 ");
        pw.println("By Everett Miller");
        pw.println("                 ");
        pw.println("King Phineas was kidnapped and taken to an unknown location.\n"
                   +"Help Phineas locate his kingdom by journeying across the lands\n"
                   +" of Gregoria. This Journey will include fighting many Ogres and the dreaded Red Dragon.\n\n\n");
    }
   
    
    public static void map_coord()
    {
        try
        {
           System.out.println("Position: "+Arrays.toString(FantasyAdventure.open_map[x])+"\n"); 
        }
        
        catch(ArrayIndexOutOfBoundsException exc)
        {
           System.out.println("Error");
        }
    }

    public static void writeFile(String filecopy, String filepath, int seek_pos)
    {
 
        try (RandomAccessFile rin = new RandomAccessFile(filecopy,"rw");
            RandomAccessFile rout = new RandomAccessFile(filepath, "rw"))
        {
            for (int i = 0; i<15; i++)
           {
                rin.seek(seek_pos);
                byte[] btr = new byte[21];
                rin.read(btr);
                rout.write(btr);
                seek_pos+=21;
           }
        }
        catch(IOException exc)
        {
            System.out.println("I/O Error: " + exc);
        }
        
    }
    
    public static byte[] readFile(String filepath, int seek_pos)
    {
        
        try (RandomAccessFile rac = new RandomAccessFile(filepath, "rw"))
        {
           rac.seek(seek_pos);
           byte[] btr = new byte[25];
           rac.read(btr);
           return btr;
        }    
   
        catch(Exception exc)
        {
            System.out.print("Error occured");
        }
        
        //if you want to open a file, but it doesn't 
        //work your file pointer is returned as NULL. So you can test the value 
        //of a pointer and check to see if it worked or not.
        return null;
        
     
       
    }

}
