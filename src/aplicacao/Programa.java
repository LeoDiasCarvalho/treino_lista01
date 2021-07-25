package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entidades.Funcionario;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Quantos funcionarios deseja cadastrar: ");
		int quant = sc.nextInt();
		
		for(int i = 0; i < quant; i++) {
			System.out.println();
			System.out.println("Funcionario #" + (i + 1));
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while(idCadastrado(list, id)) {
				System.out.print("Esse id já está cadastrado, digite outro: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();
			
			Funcionario func = new Funcionario(id, nome, salario);
			list.add(func);
			
			}
		System.out.println();
		System.out.print("Digite o id do funcionario que você deseja aumentar o salário: ");
		int idAumento = sc.nextInt();
		
		Funcionario func = list.stream().filter(x -> x.getId() == idAumento).findFirst().orElse(null);
		
		if(func == null) {
			System.out.println();
			System.out.print("Esse id não existe");
		} else {
			System.out.print("Qual a porcentagem do aumento: ");
			double taxa = sc.nextDouble();
			func.aumentoSalario(taxa);
		}
		
		System.out.println();
		System.out.println("Lista de Funcionários");
		for(Funcionario i : list) {
			System.out.println(i);
		}
		
		sc.close();

	}
	
	
	public static Boolean idCadastrado(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}

}
