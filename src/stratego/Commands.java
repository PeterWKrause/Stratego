
package stratego;

import java.io.IOException;

public class Commands {
    
    public static void AvailablePieces(){
        System.out.println("Your available pieces are as follows:");
        System.out.println("1 Flag");
        System.out.println("6 Bombs");
        System.out.println("1 Spy");
        System.out.println("8 Scouts");
        System.out.println("5 Miners");
        System.out.println("4 Sergeants");
        System.out.println("4 Lieutenants");
        System.out.println("4 Captains");
        System.out.println("3 Majors");
        System.out.println("2 Colonels");
        System.out.println("1 General");
        System.out.println("1 Marshall");
        System.out.println("=======================================");        
    }
    
    public static void WhatIsFlag(){
    System.out.println("- Flag: This immobile unit is the goal of both sides. It is captured by any enemy unit that attacks it, leading to a loss. Base Rank: N/A");        
    }
    
    public static void WhatIsBomb(){
    System.out.println("- Bomb: This immobile unit destroys any attacking enemy, no matter their rank. The only way they can be removed from the field of battle is if a miner attacks one. Base Rank: N/A");        
    }
    
    public static void WhatIsSpy(){
    System.out.println("- Spy: This unit cannot rank up, and is destroyed by any other attacking enemy units. However, when this unit attacks an enemy of rank 10, that opponent is instantly captured. Base Rank: 1");    
    }
    
    public static void WhatIsScout(){
    System.out.println("- Scout: This highly mobile unit can move an unlimited number of squares in any cardinal direction, although they cannot jump over any units. Base Rank: 2");    
    }
    
    public static void WhatIsMiner(){
    System.out.println("- Miner: This unit will remove any enemy bomb it attacks. Base Rank: 3");    
    }
    
    public static void WhatIsSergeant(){
    System.out.println("- Sergeant: No special abilities. Base Rank: 4");    
    }
    
    public static void WhatIsLieutenant(){
    System.out.println("- Lieutenant: No special abilities. Base Rank: 5");    
    }
    
    public static void WhatIsCaptain(){
    System.out.println("- Captain: No special abilities. Base Rank: 6");    
    }
    
    public static void WhatIsMajor(){
    System.out.println("- Major: No special abilities. Base Rank: 7");    
    }
    
    public static void WhatIsColonel(){
    System.out.println("- Colonel: No special abilities. Base Rank: 8");    
    }
    
    public static void WhatIsGeneral(){
    System.out.println("- General: No special abilities. Base Rank: 9");    
    }
    
    public static void WhatIsMarshall(){
    System.out.println("- Marshall: No special abilities. Base Rank: 10");    
    }
    
    public static void Info(){
    
    }
    
    public static void readCommand()
    {
        String str = read();
        if (!str.matches("Help"))
        {
                Info(); //Triggers other commands
        } 
        if (!str.matches("AvailablePieces"))
        {
                AvailablePieces();
        } 
        if (!str.matches("WhatIsFlag"))
        {
                WhatIsFlag();
        } 
        if (!str.matches("WhatIsBomb"))
        {
                WhatIsBomb();
        } 
        if (!str.matches("WhatIsSpy"))
        {
                WhatIsSpy();
        } 
        if (!str.matches("WhatIsScout"))
        {
                WhatIsScout();
        } 
        if (!str.matches("WhatIsMiner"))
        {
                WhatIsMiner();
        } 
        if (!str.matches("WhatIsSergeant"))
        {
                WhatIsSergeant();
        } 
        if (!str.matches("WhatIsLieutenant"))
        {
                WhatIsLieutenant();
        } 
        if (!str.matches("WhatIsCaptain"))
        {
                WhatIsCaptain();
        } 
        if (!str.matches("WhatIsMajor"))
        {
                WhatIsMajor();
        } 
        if (!str.matches("WhatIsColonel"))
        {
                WhatIsColonel();
        } 
        if (!str.matches("WhatIsGeneral"))
        {
                WhatIsGeneral();
        } 
        if (!str.matches("WhatIsMarshall"))
        {
                WhatIsMarshall();
        }                 
    }

    public static String read()
    {
            byte [] buffer = new byte[10];
        try
        {
                    int numBytes = System.in.read(buffer);
        }
    catch(IOException e)
    {
            System.out.print("Error: " + e);
                    System.exit(1);
    }
            String str = new String(buffer);
        return (str);
    }

}
