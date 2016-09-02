package world;
import java.util.Scanner;
interface UnionPay {
    public double getBalance();    
    public boolean drawMoney(double number);
    public boolean checkPwd(String input);
}
interface ICBC extends UnionPay {
    public void payOnline(double number);
}
interface ABC extends UnionPay {
    public boolean payTelBill(String phoneNum,double sum);
}
class ICBCImpl implements ICBC {
    private double money;
    private String pwd;
    public ICBCImpl(double money,String pwd){
        this.money = money;
        this.pwd = pwd;
    }
    public double getBalance() {        
        return money;
    }
    public boolean drawMoney(double number) {
        if(number <= money){
            money -=number;
            return true;
        }
        return false;
    }
    public void payOnline(double number) {
        if(number < money){
            money-=number;
        }
    }
    public boolean checkPwd(String input) {
        if(pwd.equals(input))
            return true;
        else
            return false;
    }
}
class ABCImpl implements ABC {
    private double balance;
    private String password;
    public ABCImpl(double balance,String password){
        this.balance = balance;
        this.password = password;
    }  
    public double getBalance() {        
        return balance;
    }
    public boolean drawMoney(double number) {
        if((balance-number) >= -2000){
            balance-=number;
            return true;
        }
        return false;
    }
    public boolean checkPwd(String input) {
        if(password.equals(input)){
            return true;
       }else{
            return false;
        }            
    }
    public boolean payTelBill(String phoneNum, double sum) {
        if(phoneNum.length() == 11 && (balance-sum)>=-2000){
            balance-=sum;
            return true;
        }
        return false;
    }
}
public class jiekou {
	public static void main(String[] args) {
		 UnionPay icbc = new ICBCImpl(2000,"123456");   
	        Scanner input = new Scanner(System.in);
	        System.out.println("«Î ‰»Î√‹¬Î£∫");
	        if(icbc.checkPwd(input.next())){
	            System.out.println("«Î ‰»ÎΩ∂Ó£∫");
	            double num = Double.parseDouble(input.next());
	            if(icbc.drawMoney(num)){
	                System.out.println("»°«Æ≥…π¶£¨ø®”‡∂ÓŒ™£∫"+icbc.getBalance());
	            }
	            else{
	                System.out.println("»°«Æ ß∞‹");
	            }
	        }else{
	            System.out.println("√‹¬Î¥ÌŒÛ");
	        }
	input.close();
	}
	
}


