import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Account {
	private String accountNo;//계좌번호
	private String name;//계좌주명
	private long balance;//잔고
	private ArrayList <Transaction> transaction;//거래내역
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat dateformat;//날짜출력포맷
	SimpleDateFormat timeformat;//시간출력포맷
	
	Account(String accountNo , String name){
		this.accountNo = accountNo;
		this.name = name;
		this.balance =0;
		this.transaction = new ArrayList <Transaction> ();
		dateformat = new SimpleDateFormat("yyyy년MM월dd일");
		timeformat = new SimpleDateFormat("HH시mm분");
	}
	
	//입금한다
		public void deposit(long amount) {
			balance += amount;
			
			String date = dateformat.format(cal.getTime());
			String time = timeformat.format(cal.getTime());
			
			Transaction t = new Transaction(date, time, "입금", amount, this.balance);
			transaction.add(t);
		}
		//출금한다
		public void withdraw(long amount) {
			if (balance >= amount) {
				balance -= amount;
				
				String date = dateformat.format(cal.getTime());
				String time = timeformat.format(cal.getTime());
				
				Transaction t = new Transaction(date, time, "출금", amount, this.balance);
				transaction.add(t);
			} else {
				System.out.println("잔고가 부족합니다");
			}
		}
	//잔고를 확인한다
	public long getBalance() {
		return balance;
	}
	
	//거래내역을 본다
	public ArrayList<Transaction> getTransactions() {
		return transaction;
	}
	
	
	//getter , setter////////////////////////////////////
	public String getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Account [계좌번호=" + accountNo + ", 이름=" + name + ", 잔액=" + balance + "]";
	}
	
	
}
