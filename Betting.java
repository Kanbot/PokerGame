package Poker1;

import java.util.Scanner;

public class Betting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// �÷��̾� ���̽�
	public double [] race(double x ,String y) {
		
		double p=0;
		 if(y.equals("����")) {
			x= x+x*1.25;
			p= 1;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}
		else if(y.equals("����")) {
			x=x+x*1.5;
			p=2;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}else if(y.equals("����")) {
			x= x+x*2;
			p=3;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}
		return new double[] {x,p};
	}
	// ���� ���̽�
  public  double ifr(double x) {
		
		int random = (int)(Math.random()*3+1);
		 if(random ==1) {
			x= x+x*1.25;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}
		else if(random ==2) {
			x=x+x*1.5;
			System.out.println(" ���� ����: ���� ");
			System.out.println("���ñݾ� :" +(int)x+"��");
		}else if(random ==3) {
			x= x+x*2;
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
			p=p-100;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}else if(q.equals("����")) {
			p = p-x-(2*x*0.25);
			x= x+x*1.25;
			
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}
		else if(q.equals("����")) {
			p = p-x-(2*x*0.5);
			x=x+x*1.5;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}
		else if(q.equals("����")) {
			x=x+p;
			p=0;
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
			p=p-x; 
			x= x+x;
			 System.out.println(" �÷��̾� ����:" + q);
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				bat=2;
				
		}
		else if(q.equals("���̽�")) {
			p=p-x;
			x= x+x;
			double [] dd =new double [2];
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
			String y ="";
			y= sc.nextLine();
			dd=race(x,y);
			x =dd[0];
			if(dd[1] ==1) {
				p = p-x-(2*x*0.25);
			}else if(dd[1]==2) {
				p = p-x-(2*x*0.5);
			}else if(dd[1]==3) {
				p = p-x-(x);
			}
			
		}
		else if(q.equals("����")) {
			p = p-x-(x);
			x= x+x*2;
			System.out.println(" �÷��̾� ����:" + q);
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			sun++;
		}
		else if(q.equals("����")) {
			System.out.println(" ���ñݾ� :" + (int)x + "��");
			System.out.println("�÷��̾� ����");
			bat=3;
		}
		return new double [] {x,bat,sun,p};
		
	}
	
	// ���� ���� 
		public double [] ifd(double x ,double bat,double sun,double p) {
			
			if(p == 0) {
				int all = (int)(Math.random()*2+1);
				if(all == 1) {
				 x= x+x;
				 System.out.println(" ���� ����:" + "��");
					System.out.println(" ���ñݾ� :" + (int)x + "��");
					sun =4;
					bat=2;
				}else if(all ==2) {
					System.out.println(" ���ñݾ� :" + (int)x);
					System.out.println("���� ����");
					p=p+x;
					System.out.println((int)x+"���� ���̽��ϴ�.");
					System.out.println("���� ������: " +(int)p + "��");
					bat=3;
				}
					
				
				
			}else {
			
			while(true) {
				int random = (int)(Math.random()*8+1);
			if( random == 1 && sun == 0) {
				x =x+100;
				System.out.println(" ���� ����:" + "��");
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				break;
			}else if(random == 2) {
				x= x+x*1.25;
				System.out.println(" ���� ����:" + "����");
				System.out.println(" ���ñݾ� :" + (int)x + "��");
				sun++;
				break;
			}
			else if(random == 3) {
				x=x+x*1.5;
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
				x=ifr(x);
				break;
			}
			else if(random == 7) {
				x= x+x*2;
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
			}
			
			
			return new double[] {x,bat,sun,p};
		}

}
