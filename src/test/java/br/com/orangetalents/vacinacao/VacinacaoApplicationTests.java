package br.com.orangetalents.vacinacao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.orangetalents.vacinacao.model.AplicacaoDeVacina;
import br.com.orangetalents.vacinacao.model.Usuario;
import br.com.orangetalents.vacinacao.repository.CadastradorBd;

@SpringBootTest
class VacinacaoApplicationTests {

	@Autowired
    CadastradorBd cadastrador;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testarCadastroUsuarioComSucesso() throws ParseException {
		Usuario usuario = new Usuario();
		usuario.setNome("Rodrigo");
		usuario.setEmail("rodrigo@gmail.com");
		usuario.setCpf("72906419060");//gerado por https://www.4devs.com.br/gerador_de_cpf
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		usuario.setDataDeNascimento(df.parse("1990-12-30 12:00:32"));

		usuario = cadastrador.adicionar(usuario);

		assertNotNull(usuario);
		assertNotNull(usuario.getId());
	}

	@Test
	public void testarCadastroDeUsuarioSemNome() throws ParseException {
		Usuario usuario = new Usuario();
		usuario.setEmail("rodrigo@gmail.com");
		usuario.setCpf("72906419060");//gerado por https://www.4devs.com.br/gerador_de_cpf
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		usuario.setDataDeNascimento(df.parse("1990-12-30"));

		Assertions.assertThrows(Exception.class, () -> cadastrador.adicionar(usuario));
	}

	@Test
	public void testarCadastroAplicacaoDeVacinaComSucesso() throws ParseException {
		this.testarCadastroUsuarioComSucesso();
		AplicacaoDeVacina aplicacaoDeVacina = new AplicacaoDeVacina();
		aplicacaoDeVacina.setNome("Rodrigo");
		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		usuario.setEmail("rodrigo@gmail.com");
		aplicacaoDeVacina.setUsuario(usuario);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		aplicacaoDeVacina.setDataDeVacinacao(df.parse("2021-03-03 14:00:32"));

		aplicacaoDeVacina = cadastrador.adicionar(aplicacaoDeVacina);

		assertNotNull(aplicacaoDeVacina);
		assertNotNull(aplicacaoDeVacina.getId());
	}

	@Test
	public void testarCadastroAplicacaoDeVacinaSemNome() throws ParseException {
		AplicacaoDeVacina aplicacaoDeVacina = new AplicacaoDeVacina();
		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		usuario.setEmail("rodrigo@gmail.com");
		aplicacaoDeVacina.setUsuario(usuario);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		aplicacaoDeVacina.setDataDeVacinacao(df.parse("2021-03-03 14:00:32"));

		Assertions.assertThrows(Exception.class, () -> cadastrador.adicionar(aplicacaoDeVacina));
	}
}
