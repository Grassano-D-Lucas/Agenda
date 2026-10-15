package Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    
    static List<Contato> contatos = new ArrayList<>(); 

    static void adiciona(String name, String number) {
            Contato c = new Contato(name, number);

            if(!c.setNome(name)) {
                System.out.println("ERRO: nome inválido.");
                return;
            }

            if(!c.setTelefone(number)) {
                System.out.println("ERRO: o número deve conter no mínimo 8 caracteres!");
                return;
            }
            
            contatos.add(c);
            
            System.out.println("Contato adicionado com sucesso!");
        
    }

    static void lista() {
        if (contatos.isEmpty()) {
            System.out.println("\nNenhum contato cadastrado.");
            return;
        } else {
            System.out.println("\n=== LISTA DE CONTATOS ===");

            for (int i = 0; i < contatos.size(); i++) {
                System.out.print((i + 1) + ". " + contatos.get(i));
            }
            System.out.println("\n==========================");
        }
    }

    static void buscaPorNome(String termo) {
        if(contatos.isEmpty()) {
            System.out.println("\nNenhum contato cadastrado");
            return;
        }

        boolean encontrou = false;
        System.out.println("\n==========================");
        for(Contato c : contatos) {
            if(c.getNome().toLowerCase().contains(termo.toLowerCase())) { // condição que verifica o nome da lista de contatos
                System.out.println("- " + c);                             // método nativo do Java ".toLowerCase" converte todos os caracteres em minúsculo
                encontrou = true;                                         // método nativo do Java ".contains()" verifica se um trecho específico está na String
            }
        }

        if(!encontrou) {
            System.out.println("Nenhum contato encontrado com o termo: \"" + termo + "\"");
        }
        else {
            System.out.println("Contato encontrado com sucesso!");
        }
        System.out.println("\n==========================");
    }

    static void removerContato(Scanner keyboard) {
        if(contatos.isEmpty()) {
            System.out.println("\nNenhum contato cadastrado");
            return;
        }

        lista();

        System.out.println("\nDigite o número referente a lista acima para remover o contato: ");
        int opcao = keyboard.nextInt();
        keyboard.nextLine();

        int index = opcao - 1;

        if(index < 0 || index > contatos.size()) {
            System.out.println("ERRO: opção inválida!");
            return;
        }

        Contato removido = contatos.remove(index);
        System.out.println("Contato \"" + removido.getNome() + "\" removido com sucesso");

    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- MENU AGENDA ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Procurar contato");
            System.out.println("4. Remover Contato");
            System.out.println("5. Sair da Agenda");
            System.out.println("Digite sua opção: ");

            option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Digite o nome do contato: ");
                    String name = keyboard.nextLine();
                    System.out.println("Digite o número de telefone do contato: ");
                    String number = keyboard.nextLine();
                    adiciona(name, number);
                    break;

                case 2:
                    lista();
                    break;

                case 3:
                    System.out.println("Digite o nome ou trecho para buscar: ");
                    String termo = keyboard.nextLine();
                    buscaPorNome(termo);
                    break;

                case 4:
                    removerContato(keyboard);
                    break;
    
                case 5:
                    System.out.println("Encerrando agenda...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente");
            }

        } while (option != 5);

        keyboard.close();
    }
}

