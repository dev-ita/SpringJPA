package br.com.springjpa.dao;

import br.com.springjpa.model.UsuarioSpringData;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioSpringData, Long> {
    @Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
    List<UsuarioSpringData> buscaPorNome(String nome);

    @Lock(LockModeType.READ) // quando alguém estiver fazendo essa consulta, ela é bloqueada somente para leitura, evitando erros caso alguem tente módificar enquanto outro lê.
    @Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
    UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);

    @Modifying
    @Transactional
    @Query("delete from UsuarioSpringData u where u.nome = :nome")
    void deletarPorNome(@Param("nome") String nome);

    @Modifying
    @Transactional
    @Query("update UsuarioSpringData u set u.email = :email where u.nome = :nome")
    void updateEmailPorNome(@Param("email") String email, @Param("nome") String nome);
}
