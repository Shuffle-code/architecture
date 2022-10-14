package patterns.chain;

public abstract class Account {
    public Account successor;
    public float balance;

    public void setNext(Account account){
        this.successor = account;
    }

    public void pay (float amountToPay) {
        if (this.canPay(amountToPay)) {
            System.out.printf("Paid %s using %s", amountToPay, getClass());
        }else if (this.successor != null){
        System.out.printf("Cannot pay using %s. Proceeding ..", getClass());
            System.out.println("");
        this.successor.pay(amountToPay);
        }else System.out.println("None of the accounts have enough balance");
    }
    public boolean canPay(float amount){
       return this.balance >= amount;
    }
}
