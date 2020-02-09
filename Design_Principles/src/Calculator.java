import java.util.Scanner;
class Database{
	int op[]=new int[10];
	int num1[]=new int[10];
	int num2[]=new int[10];
	float result[]=new float[10];
	static int k=0;
	float table(int n1,int n2,int operation) {
		for(int i=0;i<num1.length;i++) {
			if(num1[i]==n1)
				if(num2[i]==n2)
					if(op[i]==operation)
						return result[i];
		}
		return -1; 
	}
	void add(int n1,int n2,int operation,float r) {
		op[k]=operation;
		num1[k]=n1;
		num2[k]=n2;
		result[k]=r;
		k++;
	}
	
}
class Application extends Database{
	float check;
	//Application app=new Application();
	float action(int n1,int n2,int operation) {
		Application app=new Application();
		check=app.table(n1, n2, operation);
		if(check!=-1)
			return check;
		else {
		float r;
		switch(operation) {
		case 1:r=n1+n2;
		break;
		case 2:r=n1-n2;
		break;
		case 3:r=n1*n2;
		break;
		case 4:r=n1/n2;
		break;
		default:System.out.println("wrong option");
		return -1; 
		}
		app.add(n1,n2,operation,check);
		return r;
		}
	}
}
public class Calculator extends Application{

	public static void main(String[] args) {
		int n1,n2,operation;
		float result;
		Scanner scan=new Scanner(System.in);
		Calculator cal=new Calculator();
		while(true) {
			System.out.println("select operation to be performed:\n1.Addition\n2.Subtraction\n3.Multiply\n4.Division\n5.EXIT");
			operation=scan.nextInt();
			if(operation!=5) {
			System.out.println("enter number1:");
			n1=scan.nextInt();
			System.out.println("enter number2:");
			n2=scan.nextInt();
				result=cal.action(n1,n2,operation);
				System.out.println("result="+result);
			}
			else {
				break;
			}
		}
	}
}
