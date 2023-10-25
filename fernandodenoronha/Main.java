package com.fernandodenoronha;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 
      
        String[] times = {
                "América Mineiro", "Athletico-PR", "Atlético Mineiro", "Bahia", "Botafogo",
                "Corinthians", "Coritiba", "Cruzeiro", "Cuiabá", "Flamengo", 
                "Fluminense", "Fortaleza", "Goiás", "Grêmio", "Internacional", 
                "Ponte-Preta", "Red Bull Bragantino", "Santos", "São Paulo", "Vasco" 
        }; 
        int[] pontuacoes = new int[times.length]; 
                                                  


        int[] Vitórias = new int[times.length];

        Scanner scanner = new Scanner(System.in); 

        while (true) { 
            
            System.out.println("\nEscolha uma opção:"); 
            System.out.println("1 - Visualizar Tabela"); 
            System.out.println("2 - Editar Pontuação"); 
            System.out.println("3 - Editar Vitórias");
            System.out.println("0 - Sair");
            
            int opcao = scanner.nextInt(); 

            switch (opcao) { 
                case 0: 
                    scanner.close(); 
                    return; 
                case 1: 
                    exibirTabela(times, pontuacoes, Vitórias); 
                    break; 
                case 2: 
                    editarPontuacao(times, pontuacoes, Vitórias, scanner); 
                    break; 
                    case 3:
                    editarVitórias(times, pontuacoes, Vitórias, scanner);
                    break;
                default:

                System.out.println("Opção inválida. Tente novamente."); 
                    break; 
            } 
        } 
    } 
      

    public static void exibirTabela(String[] times, int[] pontuacoes, int[] Vitórias) { 
        System.out.println("\nPosição | Time | Pontuação | Vitórias"); 
        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + " | " + times[i] + " | " + pontuacoes[i] + " | " + Vitórias[i]); 
                                                                                  
        } 
    } 

     
    public static void exibirTimes(String[] times, int[] pontuacoes, int[] Vitórias) { 
        for (int i = 0; i < times.length; i++) { 
            System.out.println((i + 1) + " - " + times[i] + " | Pontuação: " + pontuacoes[i] + " | Vitórias:" + Vitórias[i]); 
                                                                                            
        } 
    } 

    
    public static void editarPontuacao(String[] times, int[] pontuacoes, int[] Vitórias, Scanner scanner) { 
                                                                                           
        while (true) { 
            
            System.out.println("\nTimes disponíveis para edição:"); 
            exibirTimes(times, pontuacoes, Vitórias); 
            System.out.println("Escolha o número do time para editar a pontuação (ou 0 para voltar):"); 
            
            int posicao = scanner.nextInt(); 
            if (posicao == 0) { 
                break; 
            }
            if (posicao >= 1 && posicao <= times.length) { 
                System.out.println("Digite a nova pontuação para " + times[posicao - 1] + ":"); 
                int novaPontuacao = scanner.nextInt(); 

                if (novaPontuacao >= 0) { 
                    pontuacoes[posicao - 1] = novaPontuacao; 
                } else { 
                    System.out.println("A pontuação não pode ser negativa."); 
                }
            } else {
                System.out.println("Posição inválida. Tente novamente."); 
            }

            scanner.nextLine(); 
        } 
        ordenarPorPontuacaoEVitórias(times, pontuacoes, Vitórias ); 
    } 

    public static void editarVitórias(String[] times, int[] pontuacoes, int[] Vitórias, Scanner scanner) {
        while(true) {
            System.out.println("\nTimes disponíveis para edição:");
            exibirTimes(times, pontuacoes, Vitórias);
            System.out.println("\nEscolha o número do time para editar os Vitórias(ou 0 para voltar):");
            int posicao = scanner.nextInt();
            if (posicao==0) {
                break;
            }
            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite o novo número de Vitórias do" + times[posicao - 1] + ":");
                int novosCartoes = scanner.nextInt();
                if (novosCartoes >= 0) {
                    Vitórias[posicao - 1] = novosCartoes;
                } else {
                    System.out.println("O número de Vitórias não pode ser negativo.");
                }
            } else {
                System.out.println("Posição inválida, tente novamente");
            }
            scanner.nextLine();
        }
    }

   
    public static void ordenarPorPontuacaoEVitórias(String[] times, int[] pontuacoes, int[] Vitórias) {
        for (int i = 0; i < pontuacoes.length - 1; i++) {
            for (int j = i + 1; j < pontuacoes.length; j++) {
                
                if (pontuacoes[i] < pontuacoes[j] || (pontuacoes[i] == pontuacoes[j] && Vitórias[i] > Vitórias[j])) {
           
                    int tempPontuacao = pontuacoes[i];
                    pontuacoes[i] = pontuacoes[j];
                    pontuacoes[j] = tempPontuacao;
                    
                    int tempCartoes = Vitórias[i];
                    Vitórias[i] = Vitórias[j];
                    Vitórias[i] = tempCartoes;
                
                    String tempTime = times[i];
                    times[i] = times[j];
                    times[j] = tempTime;
              }
              }
              }
              }
              }