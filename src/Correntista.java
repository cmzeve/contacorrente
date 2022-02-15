public class Correntista {
    private String nome;
    private Conta conta;

    public Correntista(Conta conta){
        this.conta =conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Correntista{" +
                "nome='" + nome + '\'' +
                ", conta=" + conta +
                '}';
    }
}
