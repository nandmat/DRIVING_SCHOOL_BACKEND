package hello.dev.DrivingSchool.repository;

import hello.dev.DrivingSchool.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);


}
