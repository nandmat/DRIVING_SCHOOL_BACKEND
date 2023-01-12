package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Administrativo;
import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.repository.UsuarioRepository;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrativoService extends UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
        Administrativo administrativo = new Administrativo();
        administrativo.setNome(cadastroDeUsuarioForm.getNome());
        administrativo.setEmail(cadastroDeUsuarioForm.getEmail());
        administrativo.setSenha(cadastroDeUsuarioForm.getSenha());
        administrativo.setCpf(cadastroDeUsuarioForm.getCpf());
        administrativo.setDataDeNascimento(cadastroDeUsuarioForm.getDataDeNascimento());
        administrativo.setEndereco(
                new Endereco(cadastroDeUsuarioForm.getLogradouro(),
                        cadastroDeUsuarioForm.getCep(),
                        cadastroDeUsuarioForm.getNumero(),
                        cadastroDeUsuarioForm.getCidade())
        );
        administrativo.setTelefone(cadastroDeUsuarioForm.getTelefone());
        return usuarioRepository.save(administrativo);
    }
}
