package core_logic;
public class Tester {
	
	public static void main(String args[])
	{
		Logic testLogic = new Logic();
		//userRank calc test
		System.out.println("###Userrankcalc test###");
		System.out.println(testLogic.userRankCalc(0, 5) == 0);
		System.out.println(testLogic.userRankCalc(0, 10)== 1);
		System.out.println(testLogic.userRankCalc(10, 78)== 4);
		System.out.println(testLogic.userRankCalc(20, 99)== 5);
		System.out.println("--------------------------");
	}
}
