import java.util.*;

public class Programa {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia(1000);
        conta.setNumero(22222);
      //  conta.setlimiteChequeEspecial


        Correntista correntista = new Correntista(conta);
        correntista.setNome("Carlos Zeve");

        leMovimentos(correntista);
    }

    private static void leMovimentos(Correntista correntista){

        Scanner sc = new Scanner(System.in);
        String ch = null;

       // ControleTransacao controleTransacao = new ControleTransacao(correntista.getConta());

        do{
            try {
                Movimento movimento = new Movimento();
                System.out.println("Operação: [C]rédito,[D]ébito,[I]mprimir ou [S]air: ");
                ch = sc.next().toUpperCase(Locale.ROOT).trim();
                switch (ch) {
                    case "C":
                        System.out.println("Digite o valor: ");
                        movimento.setValor(sc.nextDouble());
                        movimento.setTipo(Tipo.CREDITO);
                        //movimento.setDescricao("Operação de Crédito");

                        sc.nextLine();
                        System.out.println("Informar a descrição do movimento: ");
                        movimento.setDescricao(sc.nextLine());

                        correntista.getConta().getMovimentos().add(movimento);
                        break;
                    case "D":
                        System.out.println("Digite o valor: ");
                        movimento.setValor(sc.nextDouble());
                        movimento.setTipo(Tipo.DEBITO);
                        //movimento.setDescricao("Operação de Débito");
                    //    if(controleTransacao.validaTransacao(movimento));
                      //      correntista.getConta().getMovimentos().add(movimento);
                        //Conta conta = correntista.getConta();
                        //List<Movimento> movimentos = conta.getMovimentos();
                        //movimentos.add(movimento);
                        sc.nextLine();
                        System.out.println("Informar a descrição do movimento: ");
                        movimento.setDescricao(sc.nextLine());

                        correntista.getConta().getMovimentos().add(movimento);
                        break;
                    case "I":
                        imprime(correntista.getConta());
                        break;
                    case "S":
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Operação Inválida!");
                }

            }catch (InputMismatchException e){
                ch = "";
                System.out.println("O valor informado é inválido " + e.getMessage());
            }catch (Exception e){
                ch = "";
                System.out.println("Houve um erro ao processar sua solicitação!" + e.getMessage());
            }
        }while(!ch.equals("S"));

        //System.out.println(correntista.toString());
    }

    private static void imprime(Conta conta){
        Double totalCredito = 0d;
        Double totalDebito = 0d;
        List<Movimento> novaLista = conta.getMovimentos();
        for (int i = 0; i < novaLista.size(); i++) {
            Movimento movimento = novaLista.get(i);
            System.out.printf("Movimento do %s no valor de R$%,.2f - %s\n",
                    movimento.getTipo(), movimento.getValor(),
                    movimento.getDescricao());
            if(movimento.getTipo().equals(Tipo.CREDITO))
                totalCredito += movimento.getValor();
            if(movimento.getTipo().equals(Tipo.DEBITO))
                totalDebito += movimento.getValor();
        }
        System.out.printf("Saldo da conta = R$%,.2f\n",totalCredito-totalDebito);

    }

    //outra forma de pegar os movimentos
    private static void imprime(Correntista correntista){
        for(Movimento movimento: correntista.getConta().getMovimentos()){
            System.out.printf("Movimento do %s no valor de R$%,.2f - %s\n",
                    movimento.getTipo(), movimento.getValor(),
                    movimento.getDescricao());
        }
        //Usando foreach -> lambda
        //correntista.getConta().getMovimentos().forEach(movimento ->
        //        System.out.printf("Movimento do %s no valor de R$%,.2f\n",
        //        movimento.getTipo(), movimento.getValor()));
    }

}
