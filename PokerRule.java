package Poker1;

import java.util.Collections;

public class PokerRule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] Deck = new String[7]; // ���� ��
		String[] Deck1 = new String[7]; // �÷��̾� ��
		String[] Decka = new String[7]; // ���� �� ����
		String[] Deckb = new String[7]; // ���� �� ����
		String[] Deckc = new String[7]; // �÷��̾� �� ����
		String[] Deckd = new String[7]; // �÷��̾� �� ����

		double[] Deck_int = new double[7]; // ���ڸ� ���ڷ� ��ȯ�� ���� ��
		double[] Deck_int1 = new double[7]; // ���ڸ� ���ڷ� ��ȯ�� �÷��̾� ��

		double num = 0; // ���� �� �ִ밪
		double num1 = 0; // �÷��̾� �� �ִ밪

		Rule rr = new Rule();
		Deck dk = new Deck();

		try {
			dk.Newly(dk.Card); // ���� ī�� ����
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���� ī�� ���� �߰�
		dk.Convert("��", 0, 13);
		dk.Convert("��", 13, 26);
		dk.Convert("��", 26, 39);
		dk.Convert("��", 39, 52);

		dk.dis(Deck); // ���� �� �ߺ� ����
		dk.dis(Deck1); // �÷��̾� �� �ߺ� ����

		dk.caedc(Deck, Decka, Deckb); // ���� �� ���� �� ���� �и�
		dk.caedc(Deck1, Deckc, Deckd); // �÷��̾� �� ���� �� ���� �и�
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
		dk.Deckdis(Deck); // ���� �� ���
		rr.print(jokbo1[0], qq1, nn1,set1); // �÷��̾� ��� ���
		dk.Deckdis(Deck1); // �÷��̾� �� ��� 
		rr.jude(jokbo, jokbo1, num, num1); // ���� �Ǵ� �� ���� ��� 
		
	}
}

class Rule {

	// ���� ����
	public double[] rule(double[] Deck) {
		double count = 0;
		double unit = 0;

		for (int x = 0; x < Deck.length; x++) {
			for (int y = x + 1; y < Deck.length; y++) {
				if ((int) Deck[x] == (int) (Deck[y])) {
					if ((int) unit < (int) (Deck[x])) {
						unit = Deck[x];
					}

					count++;

				}

			}

		}

		return new double[] { count, unit };
	}

	public void qual(double[] jokbo, double[] jokbo1, double[] st, double[] st1, int x, int y) {
		// TODO Auto-generated method stub
		if (st[2] >= 5) {
			jokbo[0] = 3.1;
		}
		if (st1[2] >= 5) {
			jokbo1[0] = 3.1;
		}
		if (st[0] == 5) {
			jokbo[0] = 3.2;
		}
		if (st1[0] == 5) {
			jokbo1[0] = 3.2;
		}
		if (st[1] == 5) {
			jokbo[0] = 3.3;
		}
		if (st1[1] == 5) {
			jokbo1[0] = 3.3;
		}
		if (x >= 5) {
			jokbo[0] = 3.4;
		}
		if (y >= 5) {
			jokbo1[0] = 3.4;
		}
		if (st[2] == 4 && x == 4) {
			jokbo[0] = 7;
		}
		if (st1[2] == 4 && y == 4) {
			jokbo1[0] = 7;
		}
		if (st[0] == 5 && x == 4) {
			jokbo[0] = 8;
		}
		if (st1[0] == 5 && y == 4) {
			jokbo1[0] = 8;
		}
		if (st[1] == 5 && x == 4) {
			jokbo[0] = 9;
		}
		if (st1[1] == 5 && y == 4) {
			jokbo1[0] = 9;
		}
	}

	// ���� ���
	public void print(double count, String num, String nn,String st) {

		if (num.substring(0, 1).equals("1")) {
			num = "10" + num.substring(1, 2);
		}
		if (nn.substring(0, 1).equals("1")) {
			nn = "10" + nn.substring(1, 2);
		}
		if (st.substring(0, 1).equals("1")) {
			st = "10" + st.substring(1, 2);
		}
		if (count == 0) {
			System.out.println(nn + "����� �Դϴ�");
		} else if (count == 1) {
			System.out.println(num + "����� �Դϴ�");
		} else if (count == 2) {
			System.out.println(num + "����� �Դϴ�");
		} else if (count == 3) {
			System.out.println(num + "Ʈ���� �Դϴ�.");
		} else if (count == 3.1) {
			System.out.println(st + "��Ʈ����Ʈ �Դϴ�.");
		} else if (count == 3.2) {
			System.out.println(nn + "�齺Ʈ����Ʈ �Դϴ�.");
		} else if (count == 3.3) {
			System.out.println(nn + "����ƾ �Դϴ�.");
		} else if (count == 3.4) {
			System.out.println(num + "�÷��� �Դϴ�.");
		} else if (count == 4) {
			System.out.println(num + "Ǯ �Ͽ콺 �Դϴ�.");
		} else if (count == 6) {
			System.out.println(num + "��ī�� �Դϴ�.");
		} else if (count == 7) {
			System.out.println(num + "��Ʈ����Ʈ �÷��� �Դϴ�.");
		} else if (count == 8) {
			System.out.println(num + "�齺Ʈ����Ʈ �÷��� �Դϴ�.");
		} else if (count == 9) {
			System.out.println(num + "�ξ� ��Ʈ����Ʈ �÷��� �Դϴ�.");
		} else {
			System.out.println("����");
		}

		// Ǯ �Ͽ콺 , ��ī�� ,Ʈ���� ,����� ,�����
	}

	// ���� �Ǵ�
	public int jude(double[] x, double[] y, double num, double num1) {
		int s=0;
		s=this.judeinsert(x[0], y[0], 0, num, num1);
		s=this.judeinsert(x[0], y[0], 1, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 2, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3.1, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3.2, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3.3, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3.4, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 4, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 6, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 7, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 8, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 9, x[1], y[1]);
		if (x[0] > y[0]) {
			System.out.println("���� �� �¸�");
			s= 0;
		} else if (x[0] < y[0]) {
			System.out.println("�÷��̾� �� �¸�");
			s=1;
		}
		return s;
	}

	// ��� if �޼ҵ�
	public int judeinsert(double x, double y, double a, double num, double num1) {
		int q=0;
		if (x == a && y == a) {
			if (num > num1) {
				System.out.println("���� �� �¸�");
				q=0;
			} else {
				System.out.println("�÷��̾� �� �¸�");
				q=1;
			}
		}
		return q;
	}

	// ��Ʈ����Ʈ �Ǵ�
	public double[] streight(double[] Deck) {
		double count = 0; // ����Ʈ����Ʈ
		double mount = 0; // ����ƾ
		double sount = 0; // ��Ʈ����Ʈ
		double set = 0; // ��Ʈ����Ʈ �򰡰� 
		double[] st = { 2, 3, 4, 5, 14 };
		double[] mt = { 10, 11, 12, 13, 14 };
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < Deck.length; y++) {
				if (st[x] == (int) (Deck[y])) {
					count++;
					break;
				}
			}
		}
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < Deck.length; y++) {
				if (mt[x] == (int) Deck[y]) {
					mount++;
					break;
				}
			}
		}

		for (int i = 0; i < 6; i++) {

			if (((int) Deck[i + 1] - (int) Deck[i]) == 1) {
				sount++;

			}
			if ((int) Deck[i + 1] - (int) Deck[i] != 1) {
				sount--;
			}
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 2
				&& Deck[5] == Deck[6]) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 2
				&& Deck[0] == Deck[1]) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 2
				&& Deck[0] == Deck[6]) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 4
				&& (int) Deck[6] - (int) Deck[5] == 1) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 4
				&& (int) Deck[5] - (int) Deck[4] == 1) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 4
				&& (int) Deck[2] - (int) Deck[1] == 1) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 4
				&& (int) Deck[1] - (int) Deck[0] == 1) {
			sount = 5;
		}
		if((int)Deck[5] -(int)Deck[4] ==1) {
			set =Deck[5];
			if((int)Deck[5] ==(int)Deck[6] && Deck[5] <Deck[6] ) {
				set =Deck[6];
			}
		}
		else if((int)Deck[5] - (int)Deck[4] ==1 && (int)Deck[6] -(int)Deck[5] ==1) {
			set =Deck[6];
		}else {
			set =Deck[4];
			if((int)Deck[4] ==(int)Deck[5] && Deck[4] <Deck[5] ) {
				set =Deck[5];
			}
			if((int)Deck[5] ==(int)Deck[6] && Deck[5] <Deck[6] ) {
				set =Deck[6];
			}
		}
		return new double[] { count, mount, sount ,set};
	}

	// �÷��� �Ǵ�
	public int flush(double[] Deck) {
		Deck dk = new Deck();
		double[] x = new double[7];
		int c = 0;
		for (int i = 0; i < Deck.length; i++) {
			x[i] = Deck[i] - (int) Deck[i];
			x[i] = Double.parseDouble(String.format("%.1f", x[i]));

		}
		dk.sort1(x);

		for (int i = 0; i < 6; i++) {
			if (x[i + 1] == x[i]) {
				c++;
			}
			if (x[i + 1] != x[i]) {
				c--;
			}

		}
		if (x[0] != x[6] && c == 2 && x[0] != x[1] && x[5] != x[6]) {
			c = 5;
		}
		if (x[2] == x[3] && x[3] == x[4] && c == 4) {
			 c = 5;
		}
		if(x[4] == x[5]) {
			
		}
		return c;
	}
	// �¸�
		public  double win(double [] Bat ,double player_money ) {
			if(Bat[1] == 3 && player_money !=0) {
				player_money += Bat[0];
				System.out.println((int)Bat[0]+"���� ���̽��ϴ�");
				System.out.println("���� ������: "+(int)player_money);
			}else if (Bat[1] ==3 && player_money == 0) {
			
				
			}
			return player_money;
		}
	// �й� 
		public  void lose(double [] Bat ,double player_money) {
			if(Bat[1] == 3) {
				player_money =1000000- player_money;
				System.out.println((int)player_money+"���� ��"
						+ "���̽��ϴ�");			
			}
		
		}
}
