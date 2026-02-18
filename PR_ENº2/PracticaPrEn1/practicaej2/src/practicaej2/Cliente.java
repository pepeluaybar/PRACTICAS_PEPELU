package practicaej2;

public class Cliente {
    private Cuenta account;
    public Cliente(){
    }

    public Cliente(Cuenta account) {
        this.account = account;
    }
    
    public Cliente(Cliente cli){
        this.account = cli.account;
    }

    public Cuenta getAccount() {
        return account;
    }

    public void setAccount(Cuenta account) {
        this.account = account;
    }
    
    public void ingresarSaldo(int saldoAIngresar, int saldo){
    if(saldoAIngresar >= 0){
        saldo += saldoAIngresar;
            this.account.setSaldo(saldo);
            System.out.println("Saldo ingresado con exito"); 
    }else{
        System.out.println("El saldo no puede ser negativo");     
    }
    }
    public void retirarSaldo(int saldoARetirar, int saldo){
        if(saldoARetirar > saldo){
        System.out.println("No puedes retirar mas dinero del que tienes, saldo actual: " + saldo);
        }
        else if(saldoARetirar >= 0){
        saldo -= saldoARetirar;
        this.account.setSaldo(saldo);
        System.out.println("Saldo retirado con exito");
        }    
        else{
            System.out.println("El saldo a retirar no puede ser negativo");
        }
    }
    public void consultarSaldo(int saldo){
        System.out.println("Tu saldo actual es: " + saldo);
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "account=" + account + '}';
    }
    
}
