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
		
		String[] Deck_final =new String[7];  //�÷��̾� ������
		String[] Deck_final1 =new String[7]; //���� ������
		String[] Deck =  new String [4];  // ���� ���ʵ�
		String[] Deck1 = new String [4];  // �÷��̾� ���ʵ�
		String[] Decka = new String[7]; // �÷��̾� ���� ���ڿ�
		String[] Deckb = new String[7]; // �÷��̾� ���� ���ڿ�
		String[] Deckc = new String[7]; // ���� ���� ���ڿ�
		String[] Deckd = new String[7]; // ���� �N ���ڿ�	
		
		String open1=""; // �÷��̾� 1��° ���� ī��
		String open2=""; // �÷��̾� 2��° ���� ī��
		String open3=""; // �÷��̾� 3��° ���� ī��
		String open4=""; // �÷��̾� 4��° ���� ī��
		String hidden=""; // �÷��̾� ���� ī��
		String open2_d=""; // ���� 2��° ���� ī��
		String open3_d=""; // ���� 3���� ���� ī�夤	
		String open4_d=""; // ���� 4���� ���� ī��
		String hidden_d=""; // ���� ���� ī��
		
		double[] Deck_int = new double[7]; //���ڸ� ���ڷ� ��ȯ�� ���� ��
		double[] Deck_int1 = new double[7]; // ���ڸ� ���ڷ� ��ȯ�� �÷��̾� ��
		double[] Bat = {100,0,0,1000000}; // ���� �ݾ�, ���� ��ū, ���� ����,������
		
		double player; //�÷��̾� �� ��ū
		double dealer; //���� �� ��ū		
		double player_money =1000000; // �÷��̾� ������ 		
		double num = 0; // ���� �����  �ִ밪
		double num1 = 0; // �÷��̾� ����� �ִ밪
		
		int so =0; // ����� ��� 
		int vic =0; // �¸� ���� 0-���� �¸� 1 -�÷��̾� �¸�
		
		while(player_money >=0) { // ���� �� ���
		while(player_money >-1) { // ���� �ݺ� ���
			Bat[0] =100; // ���� �ʱ�ȭ
			Bat[1] =0;
			Bat[2] =0;
			//ī�� �� �ʱ�ȭ
			try {					
			dk.Newly(dk.Card);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		   //���� ��� 
		dk.Convert("��", 0, 13);
		dk.Convert("��", 13, 26);
		dk.Convert("��", 26, 39);
		dk.Convert("��", 39, 52);
		   //���� �� �ߺ� ���� 
		try{
			dk.dis(Deck);
		}catch(Exception e) {
			
		}
		   // �÷��̾� �� �ߺ� ����
		try {
		dk.dis(Deck1);
		}catch(Exception e) {
			
		}
		
		//////////////////���� ���� ���� //////////////////////////////
		System.out.println("��Ŀ ������ �����մϴ�.");
		System.out.println("���� ��������:" + (int)player_money+ "��" );
		System.out.println("--- ī�� ���� ---");
		System.out.println(" ����    ���� ī�� 4���� �й� �Ǿ����ϴ�.");
		System.out.println(" �÷��̾� ���� ī�� 4���� �й� �Ǿ����ϴ�.");
		System.out.println("--- �÷��̾� �� ---");
		
		for(int x =0; x <4; x++) {
			System.out.print(" "+"["+(x+1)+"] "+Deck1[x]+" ");	
		}
		ut.space();
		System.out.println("������ ī�� ������ ���� ���ּ���.(1~4)");
		int drop =sc.nextInt();
		dk.drop(drop,Deck1); // ���� ī�� ������ ���� 
		
		
		System.out.println("--- ���� ī�� ---");
		for(int x=0; x<3;x ++) {
			System.out.print(" "+"["+(x+1)+"]"+" "+Deck1[x]);
		}
		ut.space();
		System.out.println("������ ī�带 ���� ������");
	
		int open =sc.nextInt();
		open1 =dk.opens(open,Deck1,open1); // ������ ���� ī�� 1�� ����
		
		ut.clean();
		dk.cc(Deck_final,Deck); // ���� ���ʵ��� �������� ����
		dk.cc(Deck_final1,Deck1);// �÷��̾� ���ʵ��� �������� ����
		System.out.println("----------------------------------");
		System.out.println("����    ���� �� "+Deck[0]);
		System.out.print("�÷��̾� ���� �� "+open1 + "  �÷��̾� ���� ��"	);
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
		///�ι�° ���� ī�� ������ //////////////////////////////////////////////////
			ut.piase(2,so); // ī�� ������ �ȳ� ���� 
			System.out.print("���� ī��");
			open2_d=dk.newcard(Deck_final, Deck_final1);
			System.out.println("     "+open2_d);
			dk.plus(3,Deck_final,open2_d);
			System.out.print("�÷��̾� ī��");
			
			open2=dk.newcard(Deck_final, Deck_final1);
			System.out.println("  "+open2);
			dk.plus(3,Deck_final1,open2);
			System.out.println("------------------------------------------");
			
			System.out.println("����    ���� �� "+Deck[0]+" "+Deck_final[3]);		
			System.out.print("�÷��̾� ���� �� "+open1 +" "+open2+ "  �÷��̾� ���� ��"	);
			for(int x =0 ; x<4; x++) {
				if(Deck1[x] != open1){
					System.out.print(" "+Deck1[x]);
					}
}
			
			ut.space();
			System.out.println("���� ����� �����ϰڽ��ϱ�?(�ƹ��� Ű�� �Է�)");
			so=sc.nextInt();
			ut.note();
			sc.nextLine();	
			
			///// ���� ������ ///////////////////////////////////////////////////////////
			
			while(Bat[1] !=2 && Bat[1] !=3) {
				
				
				
				System.out.println("-----------------------------------------");
				System.out.println("���� ���� �� �Դϴ�.");
			Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // ���� ����
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
			System.out.println("�÷��̾� ���� �� �Դϴ�.(�Է�)");
					

			String bet =sc.nextLine(); // �÷��̾� ����
			if(bet.equals("üũ") && Bat[2] != 0) {
				System.out.println("üũ�� ù��° ���� �÷��̾ ���� �մϴ�");
				
				System.out.println("�ٽ� �Է����ּ���.");
				
				bet =sc.nextLine(); 
			}
			if(bet.equals("��") && Bat[2] != 0) {
				System.out.println("üũ�� ù��° ���� �÷��̾ ���� �մϴ�");
				System.out.println("�ٽ� �Է����ּ���.");
				bet =sc.nextLine(); 
				
			}
			 
			
			Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat); //�÷��̾� ����
			player_money= Bat[3];
			rr.lose(Bat,player_money);
			System.out.println("���� ������: "+(int)player_money);
			System.out.println("-----------------------------------------");
			}
			System.out.println("�ι�° ���� ������ ��");
			if(Bat[1] ==3) {
				break;
			}
			
			Bat[1] =0;
			
			
			//3 �� ° ����ī��///////////////////////////////////////////////////////////
			
			ut.piase(3,so);
			System.out.print("���� ī��");
			open3_d=dk.newcard(Deck_final, Deck_final1);
			System.out.println("     "+open3_d);
			dk.plus(4,Deck_final,open3_d);
			System.out.print("�÷��̾� ī��");
			
			open3=dk.newcard(Deck_final, Deck_final1);
			System.out.println("  "+open3);
			dk.plus(4,Deck_final1,open3);
			System.out.println("------------------------------------------");
			
			System.out.println("����    ���� �� "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]);		
			System.out.print("�÷��̾� ���� �� "+open1 +" "+open2+" "+ open3+ "  �÷��̾� ���� ��"	);
			for(int x =0 ; x<4; x++) {
				if(Deck1[x] != open1){
					System.out.print(" "+Deck1[x]);
					}
}
			
			ut.space();
			if(Bat[2] == 4) {
				
			}else {
			System.out.println("���� ����� �����ϰڽ��ϱ�?(�ƹ��� Ű�� �Է�)");
			so=sc.nextInt();
			ut.note1(Bat[0]);
			sc.nextLine();	
			
		///// ���� ������ ///////////////////////////////////////////////////////////
			
			while(Bat[1] !=2 ||	 Bat[1] !=3) {
				
				System.out.println("-----------------------------------------");
				System.out.println("���� ���� �� �Դϴ�.");
			Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // ���� ����
			player_money=rr.win(Bat,player_money);
			if(Bat[1] == 3) {
				break;
			}
			
			System.out.println("-----------------------------------------");
			ut.space();
		
			System.out.println("-----------------------------------------");
			System.out.println("�÷��̾� ���� �� �Դϴ�.(�Է�)");
					
			String bet =sc.nextLine(); // �÷��̾� ����
			if(bet.equals("üũ") && Bat[2] != 0) {
				System.out.println("üũ�� ù��° ���� �÷��̾ ���� �մϴ�");
				System.out.println("�ٽ� �Է����ּ���.");
				bet =sc.nextLine(); 
			}
			if(bet.equals("��") && Bat[2] != 0) {
				System.out.println("üũ�� ù��° ���� �÷��̾ ���� �մϴ�");
				System.out.println("�ٽ� �Է����ּ���.");
				bet =sc.nextLine(); 
			}
			 
			
			Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
			player_money= Bat[3];
			rr.lose(Bat,player_money);
			System.out.println("���� ������: "+(int)player_money);
			System.out.println("-----------------------------------------");
			}
			}
			System.out.println("����° ���� ������ ��");
			if(Bat[1] ==3) {
				break;
			}
			Bat[1] =0;
			
			
			// 4 ��° ���� ������ ////////////////////////////////////////////////////////////////////
			
			ut.piase(4,so);
			System.out.print("���� ī��");
			open4_d=dk.newcard(Deck_final, Deck_final1);
			System.out.println("     "+open4_d);
			dk.plus(5,Deck_final,open4_d);
			System.out.print("�÷��̾� ī��");
			
			open4=dk.newcard(Deck_final, Deck_final1);
			System.out.println("  "+open4);
			dk.plus(5,Deck_final1,open4);
			System.out.println("------------------------------------------");
			
			System.out.println("����    ���� �� "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]+" "+Deck_final[5]);		
			System.out.print("�÷��̾� ���� �� "+open1 +" "+open2+" "+ open3+ " "+open4+"  �÷��̾� ���� ��"	);
			for(int x =0 ; x<4; x++) {
				if(Deck1[x] != open1){
					System.out.print(" "+Deck1[x]);
					}
}
			
			ut.space();
			if(Bat[2] == 4) {
				
			}else {
			System.out.println("���� ����� �����ϰڽ��ϱ�?(�ƹ��� Ű�� �Է�)");
			so=sc.nextInt();
			ut.note1(Bat[0]);
			sc.nextLine();	
			
		///// ���� ������ ///////////////////////////////////////////////////////////
			
			while(Bat[1] !=2 && Bat[1] !=3) {
				
				System.out.println("-----------------------------------------");
				System.out.println("���� ���� �� �Դϴ�.");
			Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // ���� ����
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
			System.out.println("�÷��̾� ���� �� �Դϴ�.(�Է�)");
					
			String bet =sc.nextLine(); // �÷��̾� ����
			if(bet.equals("üũ") && Bat[2] != 0) {
				System.out.println("üũ�� ù��° ���� �÷��̾ ���� �մϴ�");
				System.out.println("�ٽ� �Է����ּ���.");
				bet =sc.nextLine(); 
			}
			if(bet.equals("��") && Bat[2] != 0) {
				System.out.println("üũ�� ù��° ���� �÷��̾ ���� �մϴ�");
				System.out.println("�ٽ� �Է����ּ���.");
				bet =sc.nextLine(); 
			}
			 
			
			Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
			player_money= Bat[3];
			rr.lose(Bat,player_money);
			System.out.println("���� ������: "+(int)player_money);
			System.out.println("-----------------------------------------");
			}
			}
			System.out.println("�׹�° ���� ������ ��");
			if(Bat[1] ==3) {
				break;
			}
			Bat[1] =0;
			
			
			// ���� ī�� ������ /////////////////////////////////////////////////////////////////
			System.out.println("����ī��  ������");
			System.out.println("���ο� ī�带 �̼��ϴ�.(1 ~9) �Է�");
			  so =sc.nextInt();
			System.out.println("---���� ī�� ���---");
			System.out.print("���� ī��");
			hidden_d=dk.newcard(Deck_final, Deck_final1);
			System.out.println("     "+hidden_d);
			dk.plus(6,Deck_final,hidden_d);
			System.out.print("�÷��̾� ī��");
			
			hidden=dk.newcard(Deck_final, Deck_final1);
			System.out.println("  "+hidden);
			dk.plus(6,Deck_final1,hidden);
			System.out.println("------------------------------------------");
			
			System.out.println("����    ���� �� "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]+" "+Deck_final[5]);		
			System.out.print("�÷��̾� ���� �� "+open1 +" "+open2+" "+ open3+ " "+open4+"  �÷��̾� ���� ��"	);
			for(int x =0 ; x<4; x++) {
				
				if(Deck1[x] != open1){
					System.out.print(" "+Deck1[x]);
					}
			
}
			System.out.print("  ����ī��: "+hidden);	
			ut.space();
			if(Bat[2] == 4) {
				
			}else {
			System.out.println("���� ����� �����ϰڽ��ϱ�?(�ƹ��� Ű�� �Է�)");
			so=sc.nextInt();
			ut.note1(Bat[0]);
			sc.nextLine();	
			
		///// ���� ������ ///////////////////////////////////////////////////////////
			
			while(Bat[1] !=2 && Bat[1] !=3) {
			
				System.out.println("-----------------------------------------");
				System.out.println("���� ���� �� �Դϴ�.");
			Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // ���� ����
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
			System.out.println("�÷��̾� ���� �� �Դϴ�.(�Է�)");
			
					
			String bet =sc.nextLine(); // �÷��̾� ����
			if(bet.equals("üũ") && Bat[2] != 0) {
				System.out.println("üũ�� ù��° ���� �÷��̾ ���� �մϴ�");
				System.out.println("�ٽ� �Է����ּ���.");
				
				bet =sc.nextLine(); 
			}
			if(bet.equals("��") && Bat[2] != 0) {
				System.out.println("üũ�� ù��° ���� �÷��̾ ���� �մϴ�");
				System.out.println("�ٽ� �Է����ּ���.");
				bet =sc.nextLine(); 
			}
			 
			
			Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
			player_money= Bat[3];	
			rr.lose(Bat,player_money);
			System.out.println("���� ������: "+(int)player_money);
			System.out.println("-----------------------------------------");
			}
			}
			System.out.println("���� ī�� ������ ��");
			if(Bat[1] ==3) {
				break;
			}
			Bat[1] =0;			
			
			ut.clean();
			
			dk.caedc(Deck_final, Decka, Deckb); // ���� �� ���� �� ���� �и�
			dk.caedc(Deck_final1, Deckc, Deckd); // �÷��̾� �� ���� �� ���� �и�
			dk.change(Decka); // ������ ���ڸ� ���ڷ� ��ȯ
			dk.change(Deckc); // �÷��̾ ���ڸ� ���ڷ� ��ȯ
			dk.convert(Decka, Deckb, Deck_int); // ���� �� ���ڸ� ���ڷ� ��ȯ
			dk.convert(Deckc, Deckd, Deck_int1); // �÷��̾� �� ���ڸ� ���ڷ� ��ȯ
			double[] jokbo = rr.rule(Deck_int); // ���� �� ���� ����
			double[] jokbo1 = rr.rule(Deck_int1); // �÷��̾� �� ���� ����
			num = dk.sort(Deck_int); // ���� �� �ִ밪
			num1 = dk.sort(Deck_int1); // �÷��̾� �� �ִ밪
			double[] st = rr.streight(Deck_int); // ���� �� ��Ʈ����Ʈ �Ǵ�
			double[] st1 = rr.streight(Deck_int1); // �÷��̾� �� ��Ʈ����Ʈ �Ǵ�
			int f = rr.flush(Deck_int); // ���� �� �÷��� �Ǵ�
			int f1 = rr.flush(Deck_int1); // �÷��̾� �� �÷��� �Ǵ�

			rr.qual(jokbo, jokbo1, st, st1, f, f1); // ������ ����

			String qq = dk.rechan(jokbo[1]); // ���� �� �򰡰� ����
			String qq1 = dk.rechan(jokbo1[1]); // �÷��̾� �� �򰡰� ����
			String set=dk.rechan(st[3]); // ���� ��Ʈ����Ʈ �򰡰� ����
			String set1= dk.rechan(st[3]); // �÷��̾� ��Ʈ����Ʈ �򰡰� ����
			String nn = dk.rechan(num); // ���� �����,�齺Ʈ,����ƾ �򰡰� 
			String nn1 = dk.rechan(num1); // �÷��̾� �����,�齺Ʈ,����ƾ �򰡰� 

			rr.print(jokbo[0], qq, nn ,set); // ���� ��� ���
			dk.Deckdis(Deck_final); // ���� �� ���
			rr.print(jokbo1[0], qq1, nn1,set1); // �÷��̾� ��� ���
			dk.Deckdis(Deck_final1); // �÷��̾� �� ��� 
			vic=rr.jude(jokbo, jokbo1, num, num1); // ���� �Ǵ� �� ���� ��� 
			if(vic ==0) {
				player_money -= Bat[0];
			}else if(vic ==1) {
				player_money += Bat[0];
			}
			System.out.println("�÷��̾� ������: " + (int)player_money);
			System.out.println("���� ���� �Ͻðڽ��ϱ�?(��/�ƴϿ�)");
			String vx =sc.nextLine();
			if(vx.equals("��")) {
				System.out.println("�������� �����մϴ�.");
				ut.space();
			}else if(vx.equals("�ƴϿ�")) {
				System.out.println("������ ���� �մϴ�.");
				break;
			}
			ut.clean();
			
			}
		System.out.println("���� ��");
		System.out.println("���� ���� �Ͻðڽ��ϱ�?(��/�ƴϿ�)");
		String vx =sc.nextLine();
		if(vx.equals("��")) {
			System.out.println("�������� �����մϴ�.");
			ut.space();
		}else if(vx.equals("�ƴϿ�")) {
			System.out.println("������ ���� �մϴ�.");
			break;
		}
		}
		
		
		
		System.out.println("���� �Ѱ� �µ���"+ "�Դϴ�.");
		
	}

	
	
	
	


}

