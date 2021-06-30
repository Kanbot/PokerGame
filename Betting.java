package Poker;

import java.util.Scanner;

public class Betting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 플레이어 레이스
	public double race(double x ,String y) {
		
		
		 if(y.equals("쿼터")) {
			x= (x+x)*1.25;
			System.out.println(" 딜러 배팅: 쿼터 ");
			System.out.println("배팅금액 :" +(int)x+"원");
		}
		else if(y.equals("하프")) {
			x=(x+x)*1.5;
			System.out.println(" 딜러 배팅: 하프 ");
			System.out.println("배팅금액 :" +(int)x+"원");
		}else if(y.equals("따당")) {
			x= (x+x)*2;
			System.out.println(" 딜러 배팅: 따당 ");
			System.out.println("배팅금액 :" +(int)x+"원");
		}
		return x;
	}
	// 딜러 레이스
  public  double ifr(double x) {
		
		int random = (int)(Math.random()*3+1);
		 if(random ==1) {
			x= (x+x)*1.25;
			System.out.println(" 딜러 배팅: 쿼터 ");
			System.out.println("배팅금액 :" +(int)x+"원");
		}
		else if(random ==2) {
			x=(x+x)*1.5;
			System.out.println(" 딜러 배팅: 하프 ");
			System.out.println("배팅금액 :" +(int)x+"원");
		}else if(random ==3) {
			x= (x+x)*2;
			System.out.println(" 딜러 배팅: 따당 ");
			System.out.println("배팅금액 :" +(int)x+"원");
		}
		return x;
	}
  
//플레이어 배팅
	public  double [] ifb(String q,double x ,double p,double bat,double sun,double [] B){
		Scanner sc =new Scanner(System.in);
		if( q.equals("뻥") && sun ==0) {
			x =x+100;
			System.out.println(" 플레이어 배팅:" + q);
			System.out.println(" 배팅금액 :" + (int)x + "원");
			sun++;
		}else if(q.equals("쿼터")) {
			x= (x+x)*1.25;
			System.out.println(" 플레이어 배팅:" + q);
			System.out.println(" 배팅금액 :" + (int)x + "원");
			sun++;
		}
		else if(q.equals("하프")) {
			x=(x+x)*1.5;
			System.out.println(" 플레이어 배팅:" + q);
			System.out.println(" 배팅금액 :" + (int)x + "원");
			sun++;
		}
		else if(q.equals("올인")) {
			x=x+p;
			System.out.println(" 플레이어 배팅:" + q);
			System.out.println(" 배팅금액 :" + (int)x + "원");
			sun++;
		}
		else if(q.equals("체크") && sun ==0) {
			System.out.println(" 플레이어 배팅:" + q);
			System.out.println(" 배팅금액 :" + (int)x + "원");
			sun++;
		}
		else if(q.equals("콜")) {
			 x= x+x;
			 System.out.println(" 플레이어 배팅:" + q);
				System.out.println(" 배팅금액 :" + (int)x + "원");
				sun++;
				bat=2;
				
		}
		else if(q.equals("레이스")) {
			x= x+x;
			System.out.println(" 플레이어 배팅:" + q);
			System.out.println(" 배팅금액 :" + (int)x + "원");
			sun++;
			String y ="";
			y= sc.nextLine();
			x=race(x,y);
			
		}
		else if(q.equals("따당")) {
			x= (x+x)*2;
			System.out.println(" 플레이어 배팅:" + q);
			System.out.println(" 배팅금액 :" + (int)x + "원");
			sun++;
		}
		else if(q.equals("다이")) {
			System.out.println(" 배팅금액 :" + (int)x + "원");
			System.out.println("플레이어 다이");
			bat=3;
		}
		return new double [] {x,bat,sun};
		
	}
	
	// 딜러 배팅 
		public double [] ifd(double x ,double bat,double sun) {
			
			
			while(true) {
				int random = (int)(Math.random()*8+1);
			if( random == 1 && sun == 0) {
				x =x+100;
				System.out.println(" 딜러 배팅:" + "뻥");
				System.out.println(" 배팅금액 :" + (int)x + "원");
				sun++;
				break;
			}else if(random == 2) {
				x= (x+x)*1.25;
				System.out.println(" 딜러 배팅:" + "쿼터");
				System.out.println(" 배팅금액 :" + (int)x + "원");
				sun++;
				break;
			}
			else if(random == 3) {
				x=(x+x)*1.5;
				System.out.println(" 딜러 배팅:" + "하프");
				System.out.println(" 배팅금액 :" + (int)x + "원");
				sun++;
				break;
				
			}else if(random == 4 && sun == 0) {
				System.out.println(" 딜러 배팅:" + "체크");
				System.out.println(" 배팅금액 :" + (int)x + "원");
				sun++;
				break;
			}
			else if(random == 5 && sun !=0) {
				 x= x+x;
				 System.out.println(" 딜러 배팅:" + "콜");
					System.out.println(" 배팅금액 :" + (int)x + "원");
					sun++;
					bat=2;
					break;
			}
			else if(random == 6) {
				x= x+x;
				System.out.println(" 딜러 배팅:" + "레이스");
				System.out.println(" 배팅금액 :" + (int)x + "원");
				sun++;
				ifr(x);
				break;
			}
			else if(random == 7) {
				x= (x+x)*2;
				System.out.println(" 딜러 배팅:" + "따당");
				System.out.println(" 배팅금액 :" + (int)x + "원");
				sun++;
				break;
			}
			else if(random == 8) {
				System.out.println(" 배팅금액 :" + (int)x);
				System.out.println("딜러 다이");
				bat=3;
				break;
			}
			
			
		
			}
			
			return new double[] {x,bat,sun};
		}

}
