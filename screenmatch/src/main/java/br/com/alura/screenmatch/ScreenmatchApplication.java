package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoapi = new ConsumoAPI();
		//	String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=c727e294";
		var json = consumoapi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=c727e294");
		System.out.println(json);
		//json = consumoapi.obterDados("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json);

		  ConverteDados conversor = new ConverteDados();
		  DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
	}
}
