package aplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entities.Prova;

public class Program {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Integer n = 0;

		while (n != 10) {

			System.out.println();
			System.out.println("//////////////////////////////");
			System.out.println("1 - Criar respostas dos alunos");
			System.out.println("2 - Gerar Gabarito");
			System.out.println("3 - Visualizar pastas das diciplinas");
			System.out.println("4 - Localizar discplina e gabarito ");
			System.out.println("5 - Ler gabrito");
			System.out.println("6 - Nota");
			System.out.println("10 - Sair");
			System.out.println("//////////////////////////////");
			System.out.print("Opação:  ");
			n = Integer.parseInt(sc.next());
			System.out.println("//////////////////////////////");

			switch (n) {

			case 1:

				System.out.println("Coloque o nome da disciplina");
				String nome = sc.next();
				pastas(nome);
				arquivo(nome);
				break;

			case 2:
				System.out.println("Coloque o nome da disciplina para gerar gabarito");
				String gab = sc.next();
				pastas(gab);
				gabarito(gab);
				break;

			case 3:
				System.out.println("Pastas");
				caminhoPast();
				break;

			case 4:

				System.out.println("Escolha uma disciplina ");
				String disc = sc.next();
				file(disc);
				break;

			case 5:
				System.out.println("Digite qual a disciplina para ver o gabarito");
				String gabDisc = sc.next();
				gerarGabarito(gabDisc);
				break;

			case 6:
				System.out.println("Digite a disciplina");
				String nota = sc.next();
				gerarOrden(nota);
				break;
			}

		}
		sc.close();
	}

	public static void arquivo(String arquivo) {

		boolean flag = true; // bandeira
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("c:\\temp\\" + arquivo + "\\" + arquivo.toLowerCase() + ".txt"))) { // cria arquivo da
																									// disciplina

			while (flag == true) {

				System.out.print("Digite o nome do aluno:");
				sc.nextLine();
				String aluno = sc.nextLine();
				System.out.print("Digite suas respostas:");
				String res = sc.next();
				bw.write(aluno + ", " + res);
				bw.newLine();

				System.out.println("Deseja adicionar mais alunos?");
				System.out.println("S / sim , N / não");
				res = sc.next();
				if (res.equalsIgnoreCase("N"))
					flag = false;
			}

			System.out.println("Arquivo criado com sucesso!!");
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();
	}

	public static void gabarito(String gab) {

		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("c:\\temp\\" + gab + "\\" + gab.toLowerCase() + "_Gabarito.txt"))) { // cria gabarito

			System.out.print("Digite suas respostas:");
			String res = sc.next();
			bw.write(res);
			bw.newLine();
			bw.close();

		} catch (IOException e) {
			System.out.println("A diciplina dos alunos não foram geradas");
			e.printStackTrace();
		}
	}

	public static boolean pastas(String pasta) {

		boolean file = new File("c:\\temp\\" + pasta).mkdir(); // cria pasta da diciplina

		return file;
	}

	public static void caminhoPast() {

		File file = new File("c:\\temp");

		File[] files = file.listFiles(File::isDirectory); // mostra pastas criadas
		for (File f : files) {
			System.out.println(f);
		}

	}

	public static String file(String file) {

		File past = new File("C:\\temp\\" + file + "\\" + file); // pega o caminho da pasta e arquivos
		// System.out.println(past.getPath());
		return past.getPath();
	}

	public static void gerarGabarito(String gab) {

		System.out.println("//GABARITO//");
		try (BufferedReader br = new BufferedReader(new FileReader(file(gab) + "_Gabarito.txt"))) {

			String linha = br.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Erro: Não foi encontrado o arquivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro");
			e.printStackTrace();
		}

	}

	public static void gerarOrden(String disc) {

		List<Prova> prova = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file(disc) + ".txt"))) {

			String line = br.readLine();
			while (line != null) {

				String[] vect = line.split(",");
				prova.add(new Prova(vect[0], vect[1]));
				line = br.readLine();
			}
			

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file(disc) + "Orden.txt"))) {
				
				Collections.sort(prova);
				for (Prova p : prova) {
					bw.write(p.getAluno()+","+ p.getRes());
					System.out.println(p.getAluno() + " , " + p.getRes());
					bw.newLine();
					
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
