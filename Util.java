package Poker1;

import java.util.Scanner;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// ��ĭ ����
	public void space() { 
		System.out.println();
	}
	// �ܼ� â �ʱ�ȭ
	public  void clean() { 
		for(int x=0;x<25;x++) {
			System.out.println();
	
		}
	}
	// x��° ������ �ȳ� ����
	public void piase(int o ,int so) {
		Scanner sc =new Scanner(System.in);
	 	System.out.println(o+"��° ���� ������");
		System.out.println("���� ��");
		System.out.println("���ο� ī�带 �̼��ϴ�.(1 ~9) �Է�");
		so =sc.nextInt();
		System.out.println("---���ο� ���� ī�� ���---");
		}
	//�˸�
	public  void note() {
		System.out.println("------------------------------------------");
		System.out.println("--- ���� ---");
		System.out.println("�ּ� ���� �ݾ�: 100��");
		System.out.println("����: �� /���� /���� /���� /���� /üũ /�� /���� /���̽�");
	}
	
	//�˸�1 
	public void note1(double bat) {
		System.out.println("------------------------------------------");
		System.out.println("--- ���� ---");
		System.out.println("���� ���� �ݾ�: "+(int)bat +"��");
		System.out.println("����: �� /���� /���� /���� /���� /üũ /�� /���� /���̽�");
	}

}
