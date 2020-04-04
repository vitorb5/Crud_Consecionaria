package br.com.consecionaria.service;

import br.com.consecionaria.dto.ConsecionariaDTO;
import br.com.consecionaria.exception.ConsecionariaNaoExisteException;
import br.com.consecionaria.model.Consecionaria;
import br.com.consecionaria.repository.ConsecionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsecionariaService {

    @Autowired
    private ConsecionariaRepository consecionariaRepository;

    public List<Consecionaria> listar() throws Exception {
        try {
            return this.consecionariaRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public Consecionaria buscar(Long id) throws Exception {
        try {
            final Optional<Consecionaria> optionalConsecionaria = this.consecionariaRepository.findById(id);

            if (optionalConsecionaria.isPresent()) {
                return optionalConsecionaria.get();
            } else {
                throw new ConsecionariaNaoExisteException("Carro não existe");
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public void alterar(Long id, ConsecionariaDTO consecionariaDTO) throws Exception{
        try {
            final Optional<Consecionaria> consecionariaOptional = this.consecionariaRepository.findById(id);

            if ((consecionariaOptional.isPresent())) {
                final Consecionaria consecionaria = consecionariaOptional.get();
                consecionaria.setModelo(consecionariaDTO.getPlaca());
                this.consecionariaRepository.save(consecionaria);
            } else {
                throw new ConsecionariaNaoExisteException("Carro Não existe");
            }
        }catch (Exception e){
            throw e;
        }

    }

    public Consecionaria criar(ConsecionariaDTO consecionariaDTO){
        try {

           // if (equals(consecionariaDTO.getPlaca()!=consecionariaDTO.getPlaca()));
            return this.consecionariaRepository.save(new Consecionaria(consecionariaDTO.getPlaca()));
        }catch (Exception e){
            throw e;
        }

    }

    public void deletar (Long id){
        try {
            this.consecionariaRepository.deleteById(id);
        }catch (Exception e){
            throw  e;
        }
    }
}
