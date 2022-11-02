package br.org.serratec.exameExemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.org.serratec.exameExemplo.teste.Pagamento;

@SpringBootApplication
public class ExemploExameApplication implements CommandLineRunner {

	@Autowired
	Pagamento pagamento;

	public static void main(String[] args) {
		SpringApplication.run(ExemploExameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Total a pagar:" + pagamento.calcularProcedimento(200.0, 80.0));

	}

}
