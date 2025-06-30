public class Users {

    private int userId;
    private int balance;

    public Users(int userId, int balance){
        this.userId=userId;
        this.balance=balance;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String toString() {
        return "{ User ID: " + userId + ", Balance: " + balance + " }";
    }
}
