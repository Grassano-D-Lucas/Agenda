package Projeto;

import java.util.Scanner;

public class Agenda {
    
    static Contato[] contatos = new Contato[3]; 
    static int quantity = 0;

    static void adiciona(String name, String number) {
        if (quantity < contatos.length) {
            Contato c = new Contato();

            if(!c.setNome(name)) {
                System.out.println("ERRO: nome inválido.");
                return;
            }

            if(!c.setTelefone(number)) {
                System.out.println("ERRO: o número deve conter no mínimo 8 caracteres!");
                return;
            }
            
            contatos[quantity] = c;
            ++quantity;
            
            System.out.println("Contato adicionado com sucesso!");
        } else {
            System.out.println("Agenda cheia! Não é possível adicionar mais contatos.");
        }
    }

    static void lista() {
        if (quantity == 0) {
            System.out.println("\nNenhum contato cadastrado.");
        } else {
            System.out.println("\n=== LISTA DE CONTATOS ===");

            for (int i = 0; i < quantity; ++i) {
                System.out.print((i + 1) + ". ");
                contatos[i].exibe(); // Chama o método de exibição do objeto Contato
            }
            System.out.println("==========================");
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- MENU AGENDA ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Sair da Agenda");
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
                    System.out.println("Encerrando agenda...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente");
            }

        } while (option != 3);

        keyboard.close();
    }
}

