package Day_23;

public class BankAccountSimulation {
	static class BankAccount {
		private int balance = 0;

		public synchronized void deposit(int amount) {
			balance += amount;
			System.out.println("Deposited: " + amount + ", Balance: " + balance);
		}

		public synchronized void withdraw(int amount) {
			if (balance >= amount) {
				balance -= amount;
				System.out.println("Withdrew: " + amount + ", Balance: " + balance);
			} else {
				System.out.println("Insufficient balance for withdrawal of: " + amount);
			}
		}
	}

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		Thread depositor = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				account.deposit(100);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread withdrawer = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				account.withdraw(50);
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		depositor.start();
		withdrawer.start();
	}
}