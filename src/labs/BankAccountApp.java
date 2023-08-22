package labs;

public class BankAccountApp {

	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("465329874", 1000);
		
		acc1.setName("Jomall");
		System.out.println(acc1.getName());
		acc1.makeDeposit(600);
		acc1.makeDeposit(500);
		acc1.payBill(250);
		acc1.accrue();
		System.out.println(acc1.toString());
		
		

	}

}


class BankAccount implements IInterest {
	// Properties of bank account 
	// Encapsulation uses *private*
	private static int iD = 1000;                  // Internal ID
	private String accountNumber;   //iD + random 2-digit number + first 2 numbers of SSN 
	private static final String routingNumber = "005400657"; 
	private String name;
	private String SSN;
	private double balance;
	
	
	// Constructor 
	public BankAccount(String SSN, double initDeposit) {
		//System.out.println("New Account Created");
		balance = initDeposit;
		this.SSN = SSN;
		iD++;
		setAccountNumber();
		
	}
	
	private void setAccountNumber() {
		int random = (int) (Math.random() * 100);
		//System.out.println(random);
		accountNumber = iD +""+ random + SSN.substring(0, 2);
		System.out.println("Your Account Number: " + accountNumber);
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void payBill(double amount) {
		balance = balance-amount;
		showBalance();
	}
	
	public void makeDeposit(double amount) {
		balance = balance+amount;
		showBalance();
	}
	
	public void showBlance() {
		System.out.print("Balance: " + balance);
	}
	
	public void showBalance() {
		System.out.println("Balance: " + balance);
	}

	@Override
	public void accrue() {
		balance = balance * (1 + rate/100);
		showBlance();
		
	}
	
	@Override
	public String toString() {
		return "[Name: " + name + " ]\n[Account Number: " + accountNumber + "]\n" + "[ Routing Number: " + routingNumber + "]\n" + "[Balance " + balance + "]";
	}
}