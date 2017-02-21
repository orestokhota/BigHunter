package ua;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		int a = 30;
//		int b = 60;
//		
//		if(a == b){
//			System.out.println("Moge");
//		}else if (b == a+(2*15)){
//			System.out.println("TAK TO4No");
//		}
//		
//		else if(a*2 == b){
//			System.out.println("Toge pravda");
//		}
//		
//		
//		else if(a+30 == b){
//			System.out.println("Zna4itb Da");
//		}else{
//			System.out.println("Zna4itb Vrodi Da");
//		}
//		
//		int h = 2+3;
//		
//		
//		switch (h) {
//		case 1:{
//			System.out.println("Wuflida 1");
//			break;
//		}
//		case 5:
//		case 3:{
//			System.out.println("wufliada 3");
//			System.out.println("ok");
//			System.out.println("yes");
//			break;
//		}
//		case 4:{
//			System.out.println("Wufliada 4");
//			break;
//		}
//		case 2:{
//			System.out.println("wufliada 5");
//		}
//		default:{
//			System.out.println("Kinec");
//		}
//		
//		
//		
//		
//		
//		}
		Scanner scanner = new Scanner(System.in);
		int prog = (int) (Math.random()*20); 
		int user = prog;
		
		do{
		
			System.out.println("try to guess my number");
			
			user = scanner.nextInt();
			
			if(prog == user){
				System.out.println("you win");
			}else if(prog >= user){
				System.out.println("my number is bigger");
			}else{
				System.out.println("my number is less");
			}
		
		
		}while(prog != user);
		
		//String text = scanner.next();
		//System.out.println("++++ "+text);
		
		
		
	}
	}


