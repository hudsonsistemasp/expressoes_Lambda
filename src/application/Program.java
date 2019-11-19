package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		String path = "C:\\Users\\Hudson\\Documents\\CURSOS ON LINE PROGRAMACAO\\Curso Java Completo 2019 OO e Projetos\\Employees.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			Scanner sc = new Scanner(System.in);
			
			
			List<Employee> listEmployee = new ArrayList<>();
			String line = br.readLine();
			while(line != null) {
				String[] content = line.split(",");
				listEmployee.add(new Employee(content[0], content[1],Double.parseDouble(content[2])));
				line = br.readLine();
			}
			System.out.println("Lista dos funcion�rios:");
			listEmployee.forEach(System.out::println);
			
			/*1� Requisito: Mostrar, em ordem alfab�tica, o email dos
			funcion�rios cujo sal�rio seja superior a um dado valor
			fornecido pelo usu�rio.*/
			System.out.println("Informe, � partir o valor, o sal�rio que deseja filtrar: ");
			Double salaryUser = sc.nextDouble();
			
			//Criar uma stream para implementar esses requisitos
			
			//1� maneira criando o Comparator
			Predicate<Employee> predEmp = x -> x.getSalary() > salaryUser;
			List<String> listEmail = listEmployee.stream()
										.filter(predEmp).map(x -> x.getEmail())
										.sorted()
										.collect(Collectors.toList());
			
			System.out.println("Lista com os filtros: ");
			listEmail.forEach(System.out::println);
			
			
			/*2� requisito: Mostrar a soma dos sal�rios dos funcion�rios cujo
			nome come�a com a letra 'M'.*/
			Double sumSalaryEmployees = listEmployee.stream()
										.filter(x -> x.getName().toUpperCase().charAt(0) == 'M')
										 .map(x -> x.getSalary())
										 .reduce(0.0, (x,y) -> x + y);
			
			System.out.println("Soma de todos sal�rios com inicias em letra M: " + "$ " + sumSalaryEmployees);
			
			sc.close();
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}

}
