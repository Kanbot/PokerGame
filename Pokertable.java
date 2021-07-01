package Poker1;

import java.util.Scanner;


public class Pokertable {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		PokerRule pk = new PokerRule();
		Deck dk =new Deck();
		Util ut =new Util();
		Rule rr =new Rule();
		Betting bt =new Betting();
		Scanner sc =new Scanner(System.in);		
		
		String[] Deck_final =new String[7];  //ÇÃ·¹ÀÌ¾î ÃÖÁ¾µ¦
		String[] Deck_final1 =new String[7]; //µô·¯ ÃÖÁ¾µ¦
		String[] Deck =  new String [4];  // µô·¯ ÃÖÃÊµ¦
		String[] Deck1 = new String [4];  // ÇÃ·¹ÀÌ¾î ÃÖÃÊµ¦
		String[] Decka = new String[7]; // ÇÃ·¹ÀÌ¾î ÃÖÃÊ ¼ıÀÚ¿­
		String[] Deckb = new String[7]; // ÇÃ·¹ÀÌ¾î ÃÖÃÊ ¹®ÀÚ¿­
		String[] Deckc = new String[7]; // µô·¯ ÃÖÃÊ ¼ıÀÚ¿­
		String[] Deckd = new String[7]; // µô·¯ ­N ¹®ÀÚ¿­	
		
		String open1=""; // ÇÃ·¹ÀÌ¾î 1¹øÂ° ¿ÀÇÂ Ä«µå
		String open2=""; // ÇÃ·¹ÀÌ¾î 2¹øÂ° ¿ÀÇÂ Ä«µå
		String open3=""; // ÇÃ·¹ÀÌ¾î 3¹øÂ° ¿ÀÇÂ Ä«µå
		String open4=""; // ÇÃ·¹ÀÌ¾î 4¹øÂ° ¿ÀÇÂ Ä«µå
		String hidden=""; // ÇÃ·¹ÀÌ¾î È÷µç Ä«µå
		String open2_d=""; // µô·¯ 2¹øÂ° ¿ÀÇÂ Ä«µå
		String open3_d=""; // µô·¯ 3¹ø¤Š ¿ÀÇÂ Ä«µå¤¤	
		String open4_d=""; // µô·¯ 4¹ø¤Š ¿ÀÇÂ Ä«µå
		String hidden_d=""; // µô·¯ È÷µç Ä«µå
		
		double[] Deck_int = new double[7]; //¼ıÀÚ¸¦ ¹®ÀÚ·Î º¯È¯ÇÑ µô·¯ µ¦
		double[] Deck_int1 = new double[7]; // ¼ıÀÚ¸¦ ¹®ÀÚ·Î º¯È¯ÇÑ ÇÃ·¹ÀÌ¾î µ¦
		double[] Bat = {100,0,0,1000000}; // ¹èÆÃ ±İ¾×, ¹èÆÃ ÅäÅ«, ¼±ÈÄ Â÷·Ê,¼ÒÁö±İ
		
		double player; //ÇÃ·¹ÀÌ¾î ¼± ÅäÅ«
		double dealer; //µô·¯ ¼± ÅäÅ«		
		double player_money =1000000; // ÇÃ·¹ÀÌ¾î ¼ÒÁö±İ 		
		double num = 0; // µô·¯ ³ëÆä¾î  ÃÖ´ë°ª
		double num1 = 0; // ÇÃ·¹ÀÌ¾î ³ëÆä¾î ÃÖ´ë°ª
		
		int so =0; // °ø¹é¿ë Çã¼ö 
		int vic =0; // ½Â¸® º¯¼ö 0-µô·¯ ½Â¸® 1 -ÇÃ·¹ÀÌ¾î ½Â¸®
		
		while(player_money >=0) { // °ÔÀÓ ³¡ °æ°è
		while(player_money >-1) { // °ÔÀÓ ¹İº¹ °æ°è
			Bat[0] =100; // º¯¼ö ÃÊ±âÈ­
			Bat[1] =0;
			Bat[2] =0;
			//Ä«µå µ¦ ÃÊ±âÈ­
			try {					
			dk.Newly(dk.Card);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		   //¹®¾ç ¹èºĞ 
		dk.Convert("¢À", 0, 13);
		dk.Convert("¢¼", 13, 26);
		dk.Convert("¢¾", 26, 39);
		dk.Convert("¡ß", 39, 52);
		   //µô·¯ µ¦ Áßº¹ Á¦°Å 
		try{
			dk.dis(Deck);
		}catch(Exception e) {
			
		}
		   // ÇÃ·¹ÀÌ¾î µ¦ Áßº¹ Á¦°Å
		try {
		dk.dis(Deck1);
		}catch(Exception e) {
			
		}
		
		//////////////////°ÔÀÓ ½ÃÀÛ ¹®±¸ //////////////////////////////
		System.out.println("Æ÷Ä¿ °ÔÀÓÀ» ½ÃÀÛÇÕ´Ï´Ù.");
		System.out.println("ÇöÀç ¼ÒÁö±İÀº:" + (int)player_money+ "¿ø" );
		System.out.println("--- Ä«µå ¼ÅÇÃ ---");
		System.out.println(" µô·¯    ¿¡°Ô Ä«µå 4ÀåÀÌ ºĞ¹è µÇ¾ú½À´Ï´Ù.");
		System.out.println(" ÇÃ·¹ÀÌ¾î ¿¡°Ô Ä«µå 4ÀåÀÌ ºĞ¹è µÇ¾ú½À´Ï´Ù.");
		System.out.println("--- ÇÃ·¹ÀÌ¾î µ¦ ---");
		
		for(int x =0; x <4; x++) {
			System.out.print(" "+"["+(x+1)+"] "+Deck1[x]+" ");	
		}
		ut.space();
		System.out.println("¹ö¸®½Ç Ä«µå ÇÑÀåÀ» ¼±ÅÃ ÇØÁÖ¼¼¿ä.(1~4)");
		int drop =sc.nextInt();
		dk.drop(drop,Deck1); // ¹ö¸± Ä«µå ÁöÁ¤ÈÄ »èÁ¦ 
		
		
		System.out.println("--- ³²Àº Ä«µå ---");
		for(int x=0; x<3;x ++) {
			System.out.print(" "+"["+(x+1)+"]"+" "+Deck1[x]);
		}
		ut.space();
		System.out.println("°ø°³ÇÒ Ä«µå¸¦ ÇÑÀå °í¸£¼¼¿ä");
	
		int open =sc.nextInt();
		open1 =dk.opens(open,Deck1,open1); // °ø°³ÇÒ ¿ÀÇÂ Ä«µå 1°³ ¼±Á¤
		
		ut.clean();
		dk.cc(Deck_final,Deck); // µô·¯ ÃÖÃÊµ¦À» ÃÖÁ¾µ¦¿¡ »ğÀÔ
		dk.cc(Deck_final1,Deck1);// ÇÃ·¹ÀÌ¾î ÃÖÃÊµ¦À» ÃÖÁ¾µ¦¿¡ »ğÀÔ
		System.out.println("----------------------------------");
		System.out.println("µô·¯    ¿ÀÇÂ µ¦ "+Deck[0]);
		System.out.print("ÇÃ·¹ÀÌ¾î ¿ÀÇÂ µ¦ "+open1 + "  ÇÃ·¹ÀÌ¾î º¸À¯ µ¦"	);
		for(int x =0 ; x<3; x++) {
			if(Deck1[x] != open1){
			System.out.print(" "+Deck1[x]);
			}
		}
		ut.space();
		System.out.println("----------------------------------");
		player =dk.condeck(open1);
		dealer =dk.condeck(Deck[0]);
		//if(player < dealer) {
		///µÎ¹øÂ° ¿ÀÇÂ Ä«µå ÆäÀÌÁî //////////////////////////////////////////////////
			ut.piase(2,so); // Ä«µå ÆäÀÌÁî ¾È³» ¹®±¸ 
			System.out.print("µô·¯ Ä«µå");
			open2_d=dk.newcard(Deck_final, Deck_final1);
			System.out.println("     "+open2_d);
			dk.plus(3,Deck_final,open2_d);
			System.out.print("ÇÃ·¹ÀÌ¾î Ä«µå");
			
			open2=dk.newcard(Deck_final, Deck_final1);
			System.out.println("  "+open2);
			dk.plus(3,Deck_final1,open2);
			System.out.println("------------------------------------------");
			
			System.out.println("µô·¯    ¿ÀÇÂ µ¦ "+Deck[0]+" "+Deck_final[3]);		
			System.out.print("ÇÃ·¹ÀÌ¾î ¿ÀÇÂ µ¦ "+open1 +" "+open2+ "  ÇÃ·¹ÀÌ¾î º¸À¯ µ¦"	);
			for(int x =0 ; x<4; x++) {
				if(Deck1[x] != open1){
					System.out.print(" "+Deck1[x]);
					}
}
			
			ut.space();
			System.out.println("¹èÆÃ ÆäÀÌÁî¸¦ ½ÃÀÛÇÏ°Ú½À´Ï±î?(¾Æ¹«³ª Å°³ª ÀÔ·Â)");
			so=sc.nextInt();
			ut.note();
			sc.nextLine();	
			
			///// ¹èÆÃ ÆäÀÌÁî ///////////////////////////////////////////////////////////
			
			while(Bat[1] !=2 && Bat[1] !=3) {
				
				
				
				System.out.println("-----------------------------------------");
				System.out.println("µô·¯ ¹èÆÃ ÅÏ ÀÔ´Ï´Ù.");
			Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // µô·¯ ¹èÆÃ
			player_money=rr.win(Bat,player_money);
			if(Bat[1] == 3) {
				break;
			}
			if(Bat[1] == 2) {
				break;
			}
			System.out.println("-----------------------------------------");
			ut.space();
			
			System.out.println("-----------------------------------------");
			System.out.println("ÇÃ·¹ÀÌ¾î ¹èÆÃ ÅÏ ÀÔ´Ï´Ù.(ÀÔ·Â)");
					

			String bet =sc.nextLine(); // ÇÃ·¹ÀÌ¾î ¹èÆÃ
			if(bet.equals("Ã¼Å©") && Bat[2] != 0) {
				System.out.println("Ã¼Å©´Â Ã¹¹øÂ° ¼ø¼­ ÇÃ·¹ÀÌ¾î¸¸ °¡´É ÇÕ´Ï´Ù");
				
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				
				bet =sc.nextLine(); 
			}
			if(bet.equals("»½") && Bat[2] != 0) {
				System.out.println("Ã¼Å©´Â Ã¹¹øÂ° ¼ø¼­ ÇÃ·¹ÀÌ¾î¸¸ °¡´É ÇÕ´Ï´Ù");
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				bet =sc.nextLine(); 
				
			}
			 
			
			Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat); //ÇÃ·¹ÀÌ¾î ¹èÆÃ
			player_money= Bat[3];
			rr.lose(Bat,player_money);
			System.out.println("ÇöÀç ¼ÒÁö±İ: "+(int)player_money);
			System.out.println("-----------------------------------------");
			}
			System.out.println("µÎ¹øÂ° ¿ÀÇÂ ÆäÀÌÁî ³¡");
			if(Bat[1] ==3) {
				break;
			}
			
			Bat[1] =0;
			
			
			//3 ¹ø Â° ¿ÀÇÂÄ«µå///////////////////////////////////////////////////////////
			
			ut.piase(3,so);
			System.out.print("µô·¯ Ä«µå");
			open3_d=dk.newcard(Deck_final, Deck_final1);
			System.out.println("     "+open3_d);
			dk.plus(4,Deck_final,open3_d);
			System.out.print("ÇÃ·¹ÀÌ¾î Ä«µå");
			
			open3=dk.newcard(Deck_final, Deck_final1);
			System.out.println("  "+open3);
			dk.plus(4,Deck_final1,open3);
			System.out.println("------------------------------------------");
			
			System.out.println("µô·¯    ¿ÀÇÂ µ¦ "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]);		
			System.out.print("ÇÃ·¹ÀÌ¾î ¿ÀÇÂ µ¦ "+open1 +" "+open2+" "+ open3+ "  ÇÃ·¹ÀÌ¾î º¸À¯ µ¦"	);
			for(int x =0 ; x<4; x++) {
				if(Deck1[x] != open1){
					System.out.print(" "+Deck1[x]);
					}
}
			
			ut.space();
			if(Bat[2] == 4) {
				
			}else {
			System.out.println("¹èÆÃ ÆäÀÌÁî¸¦ ½ÃÀÛÇÏ°Ú½À´Ï±î?(¾Æ¹«³ª Å°³ª ÀÔ·Â)");
			so=sc.nextInt();
			ut.note1(Bat[0]);
			sc.nextLine();	
			
		///// ¹èÆÃ ÆäÀÌÁî ///////////////////////////////////////////////////////////
			
			while(Bat[1] !=2 ||	 Bat[1] !=3) {
				
				System.out.println("-----------------------------------------");
				System.out.println("µô·¯ ¹èÆÃ ÅÏ ÀÔ´Ï´Ù.");
			Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // µô·¯ ¹èÆÃ
			player_money=rr.win(Bat,player_money);
			if(Bat[1] == 3) {
				break;
			}
			
			System.out.println("-----------------------------------------");
			ut.space();
		
			System.out.println("-----------------------------------------");
			System.out.println("ÇÃ·¹ÀÌ¾î ¹èÆÃ ÅÏ ÀÔ´Ï´Ù.(ÀÔ·Â)");
					
			String bet =sc.nextLine(); // ÇÃ·¹ÀÌ¾î ¹èÆÃ
			if(bet.equals("Ã¼Å©") && Bat[2] != 0) {
				System.out.println("Ã¼Å©´Â Ã¹¹øÂ° ¼ø¼­ ÇÃ·¹ÀÌ¾î¸¸ °¡´É ÇÕ´Ï´Ù");
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				bet =sc.nextLine(); 
			}
			if(bet.equals("»½") && Bat[2] != 0) {
				System.out.println("Ã¼Å©´Â Ã¹¹øÂ° ¼ø¼­ ÇÃ·¹ÀÌ¾î¸¸ °¡´É ÇÕ´Ï´Ù");
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				bet =sc.nextLine(); 
			}
			 
			
			Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
			player_money= Bat[3];
			rr.lose(Bat,player_money);
			System.out.println("ÇöÀç ¼ÒÁö±İ: "+(int)player_money);
			System.out.println("-----------------------------------------");
			}
			}
			System.out.println("¼¼¹øÂ° ¿ÀÇÂ ÆäÀÌÁî ³¡");
			if(Bat[1] ==3) {
				break;
			}
			Bat[1] =0;
			
			
			// 4 ¹øÂ° ¿ÀÇÂ ÆäÀÌÁî ////////////////////////////////////////////////////////////////////
			
			ut.piase(4,so);
			System.out.print("µô·¯ Ä«µå");
			open4_d=dk.newcard(Deck_final, Deck_final1);
			System.out.println("     "+open4_d);
			dk.plus(5,Deck_final,open4_d);
			System.out.print("ÇÃ·¹ÀÌ¾î Ä«µå");
			
			open4=dk.newcard(Deck_final, Deck_final1);
			System.out.println("  "+open4);
			dk.plus(5,Deck_final1,open4);
			System.out.println("------------------------------------------");
			
			System.out.println("µô·¯    ¿ÀÇÂ µ¦ "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]+" "+Deck_final[5]);		
			System.out.print("ÇÃ·¹ÀÌ¾î ¿ÀÇÂ µ¦ "+open1 +" "+open2+" "+ open3+ " "+open4+"  ÇÃ·¹ÀÌ¾î º¸À¯ µ¦"	);
			for(int x =0 ; x<4; x++) {
				if(Deck1[x] != open1){
					System.out.print(" "+Deck1[x]);
					}
}
			
			ut.space();
			if(Bat[2] == 4) {
				
			}else {
			System.out.println("¹èÆÃ ÆäÀÌÁî¸¦ ½ÃÀÛÇÏ°Ú½À´Ï±î?(¾Æ¹«³ª Å°³ª ÀÔ·Â)");
			so=sc.nextInt();
			ut.note1(Bat[0]);
			sc.nextLine();	
			
		///// ¹èÆÃ ÆäÀÌÁî ///////////////////////////////////////////////////////////
			
			while(Bat[1] !=2 && Bat[1] !=3) {
				
				System.out.println("-----------------------------------------");
				System.out.println("µô·¯ ¹èÆÃ ÅÏ ÀÔ´Ï´Ù.");
			Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // µô·¯ ¹èÆÃ
			player_money=rr.win(Bat,player_money);
			if(Bat[1] == 3) {
				break;
			}
			if(Bat[1] == 2) {
				break;
			}
			
			System.out.println("-----------------------------------------");
			ut.space();
			
			System.out.println("-----------------------------------------");
			System.out.println("ÇÃ·¹ÀÌ¾î ¹èÆÃ ÅÏ ÀÔ´Ï´Ù.(ÀÔ·Â)");
					
			String bet =sc.nextLine(); // ÇÃ·¹ÀÌ¾î ¹èÆÃ
			if(bet.equals("Ã¼Å©") && Bat[2] != 0) {
				System.out.println("Ã¼Å©´Â Ã¹¹øÂ° ¼ø¼­ ÇÃ·¹ÀÌ¾î¸¸ °¡´É ÇÕ´Ï´Ù");
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				bet =sc.nextLine(); 
			}
			if(bet.equals("»½") && Bat[2] != 0) {
				System.out.println("Ã¼Å©´Â Ã¹¹øÂ° ¼ø¼­ ÇÃ·¹ÀÌ¾î¸¸ °¡´É ÇÕ´Ï´Ù");
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				bet =sc.nextLine(); 
			}
			 
			
			Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
			player_money= Bat[3];
			rr.lose(Bat,player_money);
			System.out.println("ÇöÀç ¼ÒÁö±İ: "+(int)player_money);
			System.out.println("-----------------------------------------");
			}
			}
			System.out.println("³×¹øÂ° ¿ÀÇÂ ÆäÀÌÁî ³¡");
			if(Bat[1] ==3) {
				break;
			}
			Bat[1] =0;
			
			
			// È÷µç Ä«µå ÆäÀÌÁî /////////////////////////////////////////////////////////////////
			System.out.println("È÷µçÄ«µå  ÆäÀÌÁî");
			System.out.println("»õ·Î¿î Ä«µå¸¦ »Ì¼ü´Ï´Ù.(1 ~9) ÀÔ·Â");
			  so =sc.nextInt();
			System.out.println("---È÷µç Ä«µå ¹èºĞ---");
			System.out.print("µô·¯ Ä«µå");
			hidden_d=dk.newcard(Deck_final, Deck_final1);
			System.out.println("     "+hidden_d);
			dk.plus(6,Deck_final,hidden_d);
			System.out.print("ÇÃ·¹ÀÌ¾î Ä«µå");
			
			hidden=dk.newcard(Deck_final, Deck_final1);
			System.out.println("  "+hidden);
			dk.plus(6,Deck_final1,hidden);
			System.out.println("------------------------------------------");
			
			System.out.println("µô·¯    ¿ÀÇÂ µ¦ "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]+" "+Deck_final[5]);		
			System.out.print("ÇÃ·¹ÀÌ¾î ¿ÀÇÂ µ¦ "+open1 +" "+open2+" "+ open3+ " "+open4+"  ÇÃ·¹ÀÌ¾î º¸À¯ µ¦"	);
			for(int x =0 ; x<4; x++) {
				
				if(Deck1[x] != open1){
					System.out.print(" "+Deck1[x]);
					}
			
}
			System.out.print("  È÷µçÄ«µå: "+hidden);	
			ut.space();
			if(Bat[2] == 4) {
				
			}else {
			System.out.println("¹èÆÃ ÆäÀÌÁî¸¦ ½ÃÀÛÇÏ°Ú½À´Ï±î?(¾Æ¹«³ª Å°³ª ÀÔ·Â)");
			so=sc.nextInt();
			ut.note1(Bat[0]);
			sc.nextLine();	
			
		///// ¹èÆÃ ÆäÀÌÁî ///////////////////////////////////////////////////////////
			
			while(Bat[1] !=2 && Bat[1] !=3) {
			
				System.out.println("-----------------------------------------");
				System.out.println("µô·¯ ¹èÆÃ ÅÏ ÀÔ´Ï´Ù.");
			Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // µô·¯ ¹èÆÃ
			player_money=rr.win(Bat,player_money);
			if(Bat[1] == 3) {
				break;
			}
			if(Bat[1] == 2) {
				break;
			}
			System.out.println("-----------------------------------------");
			ut.space();
			
			
			System.out.println("-----------------------------------------");
			System.out.println("ÇÃ·¹ÀÌ¾î ¹èÆÃ ÅÏ ÀÔ´Ï´Ù.(ÀÔ·Â)");
			
					
			String bet =sc.nextLine(); // ÇÃ·¹ÀÌ¾î ¹èÆÃ
			if(bet.equals("Ã¼Å©") && Bat[2] != 0) {
				System.out.println("Ã¼Å©´Â Ã¹¹øÂ° ¼ø¼­ ÇÃ·¹ÀÌ¾î¸¸ °¡´É ÇÕ´Ï´Ù");
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				
				bet =sc.nextLine(); 
			}
			if(bet.equals("»½") && Bat[2] != 0) {
				System.out.println("Ã¼Å©´Â Ã¹¹øÂ° ¼ø¼­ ÇÃ·¹ÀÌ¾î¸¸ °¡´É ÇÕ´Ï´Ù");
				System.out.println("´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				bet =sc.nextLine(); 
			}
			 
			
			Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
			player_money= Bat[3];	
			rr.lose(Bat,player_money);
			System.out.println("ÇöÀç ¼ÒÁö±İ: "+(int)player_money);
			System.out.println("-----------------------------------------");
			}
			}
			System.out.println("È÷µç Ä«µå ÆäÀÌÁî ³¡");
			if(Bat[1] ==3) {
				break;
			}
			Bat[1] =0;			
			
			ut.clean();
			
			dk.caedc(Deck_final, Decka, Deckb); // µô·¯ µ¦ ¹®ÀÚ ¿Í ¼ıÀÚ ºĞ¸®
			dk.caedc(Deck_final1, Deckc, Deckd); // ÇÃ·¹ÀÌ¾î µ¦ ¹®ÀÚ ¿Í ¼ıÀÚ ºĞ¸®
			dk.change(Decka); // µô·¯µ¦ ¹®ÀÚ¸¦ ¼ıÀÚ·Î º¯È¯
			dk.change(Deckc); // ÇÃ·¹ÀÌ¾îµ¦ ¹®ÀÚ¸£ ¼ıÀÚ·Î º¯È¯
			dk.convert(Decka, Deckb, Deck_int); // µô·¯ µ¦ ¼ıÀÚ¸¦ ¹®ÀÚ·Î º¯È¯
			dk.convert(Deckc, Deckd, Deck_int1); // ÇÃ·¹ÀÌ¾î µ¦ ¼ıÀÚ¸¦ ¹®ÀÚ·Î º¯È¯
			double[] jokbo = rr.rule(Deck_int); // µô·¯ µ¦ ¼ıÀÚ Á·º¸
			double[] jokbo1 = rr.rule(Deck_int1); // ÇÃ·¹ÀÌ¾î µ¦ ¼ıÀÚ Á·º¸
			num = dk.sort(Deck_int); // µô·¯ µ¦ ÃÖ´ë°ª
			num1 = dk.sort(Deck_int1); // ÇÃ·¹ÀÌ¾î µ¦ ÃÖ´ë°ª
			double[] st = rr.streight(Deck_int); // µô·¯ µ¦ ½ºÆ®·¹ÀÌÆ® ÆÇ´Ü
			double[] st1 = rr.streight(Deck_int1); // ÇÃ·¹ÀÌ¾î µ¦ ½ºÆ®·¹ÀÌÆ® ÆÇ´Ü
			int f = rr.flush(Deck_int); // µô·¯ µ¦ ÇÃ·¯½¬ ÆÇ´Ü
			int f1 = rr.flush(Deck_int1); // ÇÃ·¹ÀÌ¾î µ¦ ÇÃ·¯½¬ ÆÇ´Ü

			rr.qual(jokbo, jokbo1, st, st1, f, f1); // Á·º¸°ª °áÁ¤

			String qq = dk.rechan(jokbo[1]); // µô·¯ µ¦ Æò°¡°ª º¯°æ
			String qq1 = dk.rechan(jokbo1[1]); // ÇÃ·¹ÀÌ¾î µ¦ Æò°¡°ª º¯°æ
			String set=dk.rechan(st[3]); // µô·¯ ½ºÆ®·¹ÀÌÆ® Æò°¡°ª º¯°æ
			String set1= dk.rechan(st[3]); // ÇÃ·¹ÀÌ¾î ½ºÆ®·¹ÀÌÆ® Æò°¡°ª º¯°æ
			String nn = dk.rechan(num); // µô·¯ ³ëÆä¾î,¹é½ºÆ®,¸¶¿îÆ¾ Æò°¡°ª 
			String nn1 = dk.rechan(num1); // ÇÃ·¹ÀÌ¾î ³ëÆä¾î,¹é½ºÆ®,¸¶¿îÆ¾ Æò°¡°ª 

			rr.print(jokbo[0], qq, nn ,set); // µô·¯ °á°ú Ãâ·Â
			dk.Deckdis(Deck_final); // µô·¯ µ¦ Ãâ·Â
			rr.print(jokbo1[0], qq1, nn1,set1); // ÇÃ·¹ÀÌ¾î °á°ú Ãâ·Â
			dk.Deckdis(Deck_final1); // ÇÃ·¹ÀÌ¾î µ¦ Ãâ·Â 
			vic=rr.jude(jokbo, jokbo1, num, num1); // ½ÂÆĞ ÆÇ´Ü ¹× ½ÂÆĞ Ãâ·Â 
			if(vic ==0) {
				player_money -= Bat[0];
			}else if(vic ==1) {
				player_money += Bat[0];
			}
			System.out.println("ÇÃ·¹ÀÌ¾î ¼ÒÁö±İ: " + (int)player_money);
			System.out.println("´ÙÀ½ ÆÇÀ» ÇÏ½Ã°Ú½À´Ï±î?(¿¹/¾Æ´Ï¿À)");
			String vx =sc.nextLine();
			if(vx.equals("¿¹")) {
				System.out.println("´ÙÀ½ÆÇÀ» ½ÃÀÛÇÕ´Ï´Ù.");
				ut.space();
			}else if(vx.equals("¾Æ´Ï¿À")) {
				System.out.println("°ÔÀÓÀ» Á¾·á ÇÕ´Ï´Ù.");
				break;
			}
			ut.clean();
			
			}
		System.out.println("°ÔÀÓ ³¡");
		System.out.println("´ÙÀ½ ÆÇÀ» ÇÏ½Ã°Ú½À´Ï±î?(¿¹/¾Æ´Ï¿À)");
		String vx =sc.nextLine();
		if(vx.equals("¿¹")) {
			System.out.println("´ÙÀ½ÆÇÀ» ½ÃÀÛÇÕ´Ï´Ù.");
			ut.space();
		}else if(vx.equals("¾Æ´Ï¿À")) {
			System.out.println("°ÔÀÓÀ» Á¾·á ÇÕ´Ï´Ù.");
			break;
		}
		}
		
		
		
		System.out.println("ÇöÀç ÇÑ°­ ¿Âµµ´Â"+ "ÀÔ´Ï´Ù.");
		
	}

	
	
	
	


}

