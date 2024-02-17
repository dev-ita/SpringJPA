package br.com.springjpa;

import br.com.springjpa.dao.TelefoneRepository;
import br.com.springjpa.dao.UsuarioRepository;
import br.com.springjpa.model.Telefone;
import br.com.springjpa.model.UsuarioSpringData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringJpaApplicationTests {
    // injeção de dependência
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Test
    void testeInsert() {
        UsuarioSpringData usuarioSpringData = new UsuarioSpringData("teste123", "teste", "teste", "teste@hotmail.com", 78);
        usuarioRepository.save(usuarioSpringData);
    }

    @Test
    void testeConsulta() {
        Optional<UsuarioSpringData> usuarioSpringData = usuarioRepository.findById(102L);
        System.out.println(usuarioSpringData.get());
    }

    @Test
    void testeConsultaAll() {
        List<UsuarioSpringData> usuarios = usuarioRepository.findAll();
        List<UsuarioSpringData> usuariosId = usuarioRepository.findAllById(Arrays.asList(1L, 2L, 52L, 102L, 152L));

        usuarios.forEach(System.out::println);
    }

    @Test
    void testeUpdate() {
        Optional<UsuarioSpringData> usuarioSpringData = usuarioRepository.findById(152L);
        UsuarioSpringData data = usuarioSpringData.get();
        data.setNome("nome atualizado");
        usuarioRepository.save(data);
    }

    @Test
    void testeDelete() {
        Optional<UsuarioSpringData> usuarioSpringData = usuarioRepository.findById(302L);
        usuarioRepository.delete(usuarioSpringData.get());

//        usuarioRepository.deleteById(152L);
    }

    @Test
    void testeQuery() {
        List<UsuarioSpringData> lista = usuarioRepository.buscaPorNome("Oliveira");
        lista.forEach(System.out::println);
    }

    @Test
    void testeQueryParam() {
        UsuarioSpringData usuario = usuarioRepository.buscaPorNomeParam("Ítalo Oliveira");
        System.out.println(usuario);
    }

    @Test
    void testeDeletaPorNome() {
        usuarioRepository.deletarPorNome("teste");
    }

    @Test
    void testeAtualizarEmail() {
        usuarioRepository.updateEmailPorNome("italo.odsilva@aluno.uepa.br", "teste");
    }

    @Test
    void testeInsertTelefone() {
        Telefone telefone = new Telefone("trabalho", "(91) 9999-9999", usuarioRepository.findById(302L).get());
        telefoneRepository.save(telefone);
    }

    @Test
    void testeConsultaTelefone() {
        UsuarioSpringData usuario = usuarioRepository.findById(1L).get();
        System.out.println(usuario.getTelefones());
    }
}