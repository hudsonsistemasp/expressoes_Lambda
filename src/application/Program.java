package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		String path = "C:\\Users\\Hudson\\Documents\\CURSOS ON LINE PROGRAMACAO\\Curso Java Completo 2019 OO e Projetos\\Employees.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			Scanner sc = new Scanner(System.in);
			/*System.out.println("Informe, à partir o valor, o salário que deseja filtrar: ");
			Double salaryUser = sc.nextDouble();*/
			
			List<Employee> listEmployee = new ArrayList<>();
			String line = br.readLine();
			while(line != null) {
				String[] content = line.split(",");
				listEmployee.add(new Employee(content[0], content[1],Double.parseDouble(content[2])));
				line = br.readLine();
			}
			
			Collections.sort(listEmployee);
			listEmployee.forEach(System.out::println);
			
			sc.close();
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}

}
