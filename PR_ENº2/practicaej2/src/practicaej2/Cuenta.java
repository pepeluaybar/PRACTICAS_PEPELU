package practicaej2;

public class Cuenta {
    private int nIdent, saldo;

    public Cuenta(int nIdent, int saldo) {
        this.nIdent = nIdent;
        this.saldo = saldo;
    }
     public Cuenta(){
        this.nIdent = 0/*aqui va una funcion*/;
        this.saldo = 0;
     }
    public Cuenta(Cuenta cu){
        this.nIdent = cu.nIdent;
        this.saldo = cu.saldo;
    }

    public int getnIdent() {
        return nIdent;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setnIdent(int nIdent) {
        this.nIdent = nIdent;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "nIdent=" + nIdent + ", saldo=" + saldo + '}';
    }  
    
}
