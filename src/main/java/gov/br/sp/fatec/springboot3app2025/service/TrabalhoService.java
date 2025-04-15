package gov.br.sp.fatec.springboot3app2025.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import gov.br.sp.fatec.springboot3app2025.entity.Trabalho;
import gov.br.sp.fatec.springboot3app2025.repository.TrabalhoRepository;

@Service
public class TrabalhoService {
    
    @Autowired
    private TrabalhoRepository repoTrabalho;

    public List<Trabalho> buscarTodos() {
        return repoTrabalho.findAll();
    }

    public Trabalho novo(Trabalho trabalho) {
        if(trabalho.getTitulo() == null ||
            trabalho.getTitulo().isBlank() ||
            trabalho.getGrupo() == null ||
            trabalho.getGrupo().isBlank()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta título ou grupo");
            }
        if(trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }
        return repoTrabalho.save(trabalho);
    }

    public List<Trabalho> buscarPorTituloENota(String titulo, Integer nota) {
        return repoTrabalho.findByTituloContainsAndNotaGreaterThan(titulo, nota);
    }
}
