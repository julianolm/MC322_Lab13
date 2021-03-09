package lab13.implementacao;

import java.util.Scanner;

import lab13.auxiliares.Impressora;
import lab13.itens.*;

import java.io.IOException;
import java.util.ArrayList;

public class JewelCollector {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean running = true;

		// Intenciando o mapa
		Map mapa = new Map(10);

		// Instanciando as joias
		ArrayList<Representable> itens = new ArrayList<>() {
			{

				add(new RedJewel(1, 9));
				add(new RedJewel(8, 8));

				add(new GreenJewel(9, 1));
				add(new GreenJewel(7, 6));

				add(new BlueJewel(3, 4));
				add(new BlueJewel(2, 1));

				add(new Water(5, 0));
				add(new Water(5, 1));
				add(new Water(5, 2));
				add(new Water(5, 3));
				add(new Water(5, 4));
				add(new Water(5, 5));
				add(new Water(5, 6));

				add(new Tree(5, 9));
				add(new Tree(3, 9));
				add(new Tree(8, 3));
				add(new Tree(2, 5));
				add(new Tree(1, 4));

			}
		};

//		// Instanciando o robo
		Robot robo = Robot.getInstance(0, 0);

		// adicionando itens ao mapa
		for (int i = 0; i < itens.size(); i++) {
			mapa.addItem(itens.get(i));
		}

		// adicionando a instancia de Robot ao mapa
		mapa.addItem(robo);

		// Criando o controle
		Controle control = Controle.getInstance();
		control.addRobot(robo);
		control.addMap(mapa);

		while (running) {
			mapa.imprimeMapa();
			robo.imprimeSacola();
			System.out.print("Enter the command: ");
			String command = keyboard.nextLine();
			
			if (command.compareTo("quit") == 0) {
				running = false;

			} else if (command.compareTo("w") == 0) {
				try {
					control.w();
				} catch (IOException e) {
					Impressora.imprime("Posicao nao alcancavel\n");
				}

			} else if (command.compareTo("a") == 0) {
				try {
					control.a();
				} catch (IOException e) {
					Impressora.imprime("Posicao nao alcancavel\n");
				}

			} else if (command.compareTo("s") == 0) {
				try {
					control.s();
				} catch (IOException e) {
					Impressora.imprime("Posicao nao alcancavel\n");
				}

			} else if (command.compareTo("d") == 0) {
				try {
					control.d();
				} catch (IOException e) {
					Impressora.imprime("Posicao nao alcancavel\n");
				}

			} else if (command.compareTo("g") == 0) {
				control.g();
			}
			
			if ( ! robo.isAlive()) {
				Impressora.imprime("\n<<Fim de Jogo>>\nO Robo esgotou sua energia\n");
				running = false;
			}
		}
	}
}