package v1poo;

import java.util.Scanner;

public class Cofre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("    PASSWORD VAULT v1.0");
        System.out.println("==============================");

        System.out.print("Crie sua senha mestra: ");
        String senhaMestra = sc.nextLine();
        CofreSenhas cofre = new CofreSenhas(senhaMestra);

        int tentativas = 3;
        while (tentativas > 0 && !cofre.isDesbloqueado()) {
            System.out.print("\nSenha mestra (" + tentativas + " tentativas): ");
            String senhaDigitada = sc.nextLine();

            if (cofre.desbloquear(senhaDigitada)) {
                System.out.println("Cofre desbloqueado!");
            } else {
                tentativas--;
                if (tentativas > 0) {
                    System.out.println("Senha incorreta!");
                }
            }
        }

        if (!cofre.isDesbloqueado()) {
            System.out.println("Cofre bloqueado por seguranca!");
            sc.close();
            return;
        }

        int op = 0;
        while (op != 9) {
            System.out.println("\n--- MENU (Total: " + cofre.getTotal() + ") ---");
            System.out.println("1) Cadastrar credencial");
            System.out.println("2) Cadastrar com senha gerada");
            System.out.println("3) Listar todas");
            System.out.println("4) Ordenar por site");
            System.out.println("5) Ordenar por forca");
            System.out.println("6) Mostrar mais fraca");
            System.out.println("7) Contar fracas");
            System.out.println("8) Gerar senha forte");
            System.out.println("9) Sair");
            System.out.println("10) Buscar por site");
            System.out.print("Escolha: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Site: ");
                    String s = sc.nextLine();
                    System.out.print("Usuario: ");
                    String u = sc.nextLine();
                    System.out.print("Senha: ");
                    String p = sc.nextLine();
                    cofre.adicionar(new Crendecial(s, u, p));
                    System.out.println("Credencial cadastrada! ID: " +
                            (Crendecial.getProximoId() - 1));
                    break;

                case 2:
                    System.out.print("Site: ");
                    String s2 = sc.nextLine();
                    System.out.print("Usuario: ");
                    String u2 = sc.nextLine();
                    System.out.print("Tamanho da senha: ");
                    int tam = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Com especiais? (s/n): ");
                    boolean esp = sc.nextLine().equalsIgnoreCase("s");

                    String senhaGerada = GeradorSenhas.gerar(tam, esp);
                    System.out.println("Senha gerada: " + senhaGerada);
                    cofre.adicionar(new Crendecial(s2, u2, senhaGerada));
                    System.out.println("Credencial cadastrada! ID: " +
                            (Crendecial.getProximoId() - 1));
                    break;

                case 3:
                    if (cofre.getTotal() == 0) {
                        System.out.println("Cofre vazio!");
                    } else {
                        cofre.listar();
                    }
                    break;

                case 4:
                    if (cofre.getTotal() == 0) {
                        System.out.println("Cofre vazio!");
                    } else {
                        cofre.ordenarPorSite();
                        System.out.println("Ordenado por site:");
                        cofre.listar();
                    }
                    break;

                case 5:
                    if (cofre.getTotal() == 0) {
                        System.out.println("Cofre vazio!");
                    } else {
                        cofre.ordenarPorForca();
                        System.out.println("Ordenado por forca:");
                        cofre.listar();
                    }
                    break;

                case 6:
                    if (cofre.getTotal() > 0) {
                        System.out.println("Mais fraca: " + cofre.maisFraca());
                    } else {
                        System.out.println("Cofre vazio!");
                    }
                    break;

                case 7:
                    System.out.println("Senhas fracas: " + cofre.contarFracas());
                    break;

                case 8:
                    System.out.print("Tamanho: ");
                    int t = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Com especiais? (s/n): ");
                    boolean usarEsp = sc.nextLine().equalsIgnoreCase("s");
                    String forte = GeradorSenhas.gerar(t, usarEsp);
                    System.out.println("Gerada: " + forte);
                    System.out.println("Forca: " + GeradorSenhas.avaliarForca(forte));
                    System.out.println("E segura? " + GeradorSenhas.ehSegura(forte));
                    break;

                case 9:
                    System.out.println("Ate mais, Caue!");
                    break;

                case 10:
                    if (cofre.getTotal() == 0) {
                        System.out.println("Cofre vazio!");
                    } else {
                        System.out.print("Site para buscar: ");
                        String siteBusca = sc.nextLine();
                        Crendecial encontrada = cofre.buscarPorSite(siteBusca);
                        if (encontrada != null) {
                            System.out.println("Encontrada: " + encontrada);
                        } else {
                            System.out.println("Nao encontrado!");
                        }
                    }
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }
        sc.close();
    }
}