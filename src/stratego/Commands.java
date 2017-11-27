
package stratego;

import java.io.IOException;

public class Commands {
    
    public static void AvailablePieces(){
        System.out.println("Your available pieces are as follows:");
        System.out.println(Piece.numFlags + " Flag(s)");
        System.out.println(Piece.numBombs + " Bomb(s)");
        System.out.println(Piece.numSpies + " Spy");
        System.out.println(Piece.numScouts + " Scout(s)");
        System.out.println(Piece.numMiners + " Miner(s)");
        System.out.println(Piece.numSergeants + " Sergeant(s)");
        System.out.println(Piece.numLieutenants + " Lieutenant(s)");
        System.out.println(Piece.numCaptains + " Captain(s)");
        System.out.println(Piece.numMajors + " Major(s)");
        System.out.println(Piece.numColonels + " Colonel(s)");
        System.out.println(Piece.numGenerals + " General(s)");
        System.out.println(Piece.numMarshalls + " Marshall(s)");
        System.out.println("=======================================");        
    }
    
    public static void WhatIsFlag(){
    System.out.println("- Flag: This immobile unit is the goal of both sides. It is captured by any enemy unit that attacks it, leading to a loss. Base Rank: 0");        
    }
    
    public static void WhatIsBomb(){
    System.out.println("- Bomb: This immobile unit destroys any attacking enemy, no matter their rank. The only way they can be removed from the field of battle is if a miner attacks one. Base Rank: 11");        
    }
    
    public static void WhatIsSpy(){
    System.out.println("- Spy: This unit cannot rank up, and is destroyed by any other attacking enemy units. However, when this unit attacks an enemy of rank 10, that opponent is instantly captured. Base Rank: 1");    
    }
    
    public static void WhatIsScout(){
    System.out.println("- Scout: No special abilities. Base Rank: 2");    
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
        System.out.println("Enter command here:");
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

    public static int ReadRank(){
        System.out.println("Enter the rank of the piece you wish to place: ");
	String str = read();
	int num = Integer.parseInt(str.trim());
	return (num);
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
