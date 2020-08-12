package aplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		
		System.out.println("1 - Criar respostas dos alunos");
		System.out.println("2 - Gerar Gabarito");
		System.out.println("3 - ");
		System.out.println("4 - ");
		Integer n = sc.nextInt();
		
		switch(n) {
		
		case 1:
			
			System.out.println("Coloque o nome da disciplina");
			String nome = sc.next();
			
			arquivo(nome);
			break;
		
		case 2:
			System.out.println("Coloque o nome da disciplina para gerar gabarito");
			String gab = sc.next();
			gabarito(gab);
			
			break;
		
		}
		
		sc.close();
	}

	public static void arquivo(String arquivo) {
		
		boolean flag = true; //bandeira
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\" + arquivo + ".txt"))) {

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
	
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\" + gab + ".txt"))) {
			
			System.out.print("Digite suas respostas:");
			String res = sc.next();
			bw.write(res);
			bw.newLine();
			bw.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
