package aplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String caminho = "c:\\temp";
		System.out.println("Coloque o nome da diciplina");
		String nome = sc.next();
		
		boolean flag = true;
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho+"\\"+nome+".txt"))){
			
			while(flag == true) {
				
				System.out.print("Digite o nome do aluno:");
				sc.nextLine();
				String aluno = sc.nextLine();
				System.out.print("Digite suas respostas:");
				String res = sc.next();
				bw.write(aluno +", "+ res);
				bw.newLine();
				
				System.out.println("Deseja adicionar mais alunos?");
				System.out.println("S / sim , N / não");
				res = sc.next();
				if(res.equalsIgnoreCase("N")) flag = false;
				
			}
			
			System.out.println("Arquivo criado com sucesso!!");
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		sc.close();
	}

}
