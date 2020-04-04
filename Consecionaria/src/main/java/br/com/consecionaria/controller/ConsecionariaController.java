package br.com.consecionaria.controller;

import br.com.consecionaria.dto.ConsecionariaDTO;
import br.com.consecionaria.exception.ConsecionariaNaoExisteException;
import br.com.consecionaria.model.Consecionaria;
import br.com.consecionaria.service.ConsecionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consecinarias")
public class ConsecionariaController {

    @Autowired
    private ConsecionariaService consecionariaService;

    @GetMapping
    public ResponseEntity<List<Consecionaria>> Listar() throws Exception{
        List<Consecionaria> consecionarias = this.consecionariaService.listar();
        if (consecionarias != null && !consecionarias.isEmpty()){
            return new ResponseEntity<>(consecionarias, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(consecionarias,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consecionaria> buscar(@PathVariable("id") Long id) throws Exception{
        try {
            Consecionaria consecionaria = this.consecionariaService.buscar(id);
            return new ResponseEntity<>(consecionaria, HttpStatus.OK);
        }catch (ConsecionariaNaoExisteException ce){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> alterar(@PathVariable("id")Long id, @RequestBody ConsecionariaDTO consecionariaDTO) {
    try {
        this.consecionariaService.alterar(id, consecionariaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }catch (ConsecionariaNaoExisteException ce){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
    @PostMapping
    public ResponseEntity<Consecionaria> criar (@RequestBody ConsecionariaDTO consecionariaDTO) {
        try {
            Consecionaria consecionaria = this.consecionariaService.criar(consecionariaDTO);
            return new ResponseEntity<>(consecionaria, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable("id") Long id){
            try {
                this.consecionariaService.deletar(id);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
