

import java.util.Scanner;

class Contato {
    String nome;
    String telefone;

    void exibe() {
        System.out.println(nome + " - " + telefone);
    }
}

public class Agenda {
    
    static Contato[] contatos = new Contato[3]; 
    static int quantity = 0;

    public static void printMessage(String message) {
        System.out.println(message);
    }

    static void adiciona(String name, String number) {
        if (quantity < contatos.length) {
            Contato c = new Contato();
            c.nome = name;
            c.telefone = number;
            
            contatos[quantity] = c;
            ++quantity;
            printMessage("Contato adicionado com sucesso!");
        } else {
            printMessage("Agenda cheia! Não é possível adicionar mais contatos.");
        }
    }

    static void lista() {
        if (quantity == 0) {
            printMessage("\nNenhum contato cadastrado.");
        } else {
            printMessage("\n=== LISTA DE CONTATOS ===");

            for (int i = 0; i < quantity; ++i) {
                System.out.print((i + 1) + ". ");
                contatos[i].exibe(); // Chama o método de exibição do objeto Contato
            }
            printMessage("==========================");
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int option;

        do {
            printMessage("\n--- MENU AGENDA ---");
            printMessage("1. Adicionar Contato");
            printMessage("2. Listar Contatos");
            printMessage("3. Sair da Agenda");
            printMessage("Digite sua opção: ");

            option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1:
                    printMessage("Digite o nome do contato: ");
                    String name = keyboard.nextLine();
                    printMessage("Digite o número de telefone do contato: ");
                    String number = keyboard.nextLine();
                    adiciona(name, number);
                    break;

                case 2:
                    lista();
                    break;

                case 3:
                    printMessage("Encerrando agenda...");
                    break;

                default:
                    printMessage("Opção inválida! Tente novamente");
            }

        } while (option != 3);

        keyboard.close();
    }
}

