package Poker;

import java.util.Scanner;

public class Betting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// �÷��̾� ���̽�
	public double race(double x ,String y) {
		
		
		 if(y.equals("����")) {
			x= (x+x)*1.25;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}
		else if(y.equals("����")) {
			x=(x+x)*1.5;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}else if(y.equals("����")) {
			x= (x+x)*2;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}
		return x;
	}
	// ���� ���̽�
  public  double ifr(double x) {
		
		int random = (int)(Math.random()*3+1);
		 if(random ==1) {
			x= (x+x)*1.25;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}
		else if(random ==2) {
			x=(x+x)*1.5;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}else if(random ==3) {
			x= (x+x)*2;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}
		return x;
	}
  
//�÷��̾� ����
	public  double [] ifb(String q,double x ,double p,double bat,double sun,double [] B){
		Scanner sc =new Scanner(System.in);
		if( q.equals("��") && sun ==0) {
			x =x+100;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}else if(q.equals("����")) {
			x= (x+x)*1.25;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}
		else if(q.equals("����")) {
			x=(x+x)*1.5;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}
		else if(q.equals("����")) {
			x=x+p;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}
		else if(q.equals("üũ") && sun ==0) {
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}
		else if(q.equals("��")) {
			 x= x+x;
			 System.out.println(" �÷��̾� ����:" + q);
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				bat=2;
				
		}
		else if(q.equals("���̽�")) {
			x= x+x;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
			String y ="";
			y= sc.nextLine();
			x=race(x,y);
			
		}
		else if(q.equals("����")) {
			x= (x+x)*2;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}
		else if(q.equals("����")) {
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			System.out.println("�÷��̾� ����");
			bat=3;
		}
		return new double [] {x,bat,sun};
		
	}
	
	// ���� ���� 
		public double [] ifd(double x ,double bat,double sun) {
			
			
			while(true) {
				int random = (int)(Math.random()*8+1);
			if( random == 1 && sun == 0) {
				x =x+100;
				System.out.println(" ���� ����:" + "��");
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				break;
			}else if(random == 2) {
				x= (x+x)*1.25;
				System.out.println(" ���� ����:" + "����");
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				break;
			}
			else if(random == 3) {
				x=(x+x)*1.5;
				System.out.println(" ���� ����:" + "����");
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				break;
				
			}else if(random == 4 && sun == 0) {
				System.out.println(" ���� ����:" + "üũ");
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				break;
			}
			else if(random == 5 && sun !=0) {
				 x= x+x;
				 System.out.println(" ���� ����:" + "��");
					System.out.println(" ���ñݾ� :" + (int)x + "��");
					sun++;
					bat=2;
					break;
			}
			else if(random == 6) {
				x= x+x;
				System.out.println(" ���� ����:" + "���̽�");
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				ifr(x);
				break;
			}
			else if(random == 7) {
				x= (x+x)*2;
				System.out.println(" ���� ����:" + "����");
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				break;
			}
			else if(random == 8) {
				System.out.println(" ���ñݾ� :" + (int)x);
				System.out.println("���� ����");
				bat=3;
				break;
			}
			
			
		
			}
			
			return new double[] {x,bat,sun};
		}

}
