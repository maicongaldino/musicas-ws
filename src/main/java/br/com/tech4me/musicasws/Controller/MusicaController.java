package br.com.tech4me.musicasws.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.musicasws.Model.Musica;
import br.com.tech4me.musicasws.Service.MusicaService;
import br.com.tech4me.musicasws.Shared.MusicaDTO;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    @Autowired
    private MusicaService service;

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> obterTodos() {
        return new ResponseEntity<>(service.obterTodas(), HttpStatus.OK);
    }

    @GetMapping(value = "/detalhado")
    public ResponseEntity<List<Musica>> obterTodosDetalhado() {
        return new ResponseEntity<>(service.obterTodasDetalhado(), HttpStatus.OK);
    }

    @GetMapping(value = "/PorId/{id}")
    public ResponseEntity<MusicaDTO> obterPorId(@PathVariable String id) {
        Optional<MusicaDTO> music = service.obterPorId(id);

        if (music.isPresent())
        {
            return new ResponseEntity<>(music.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/PorAno/{de}/{ate}")
    public ResponseEntity<List<MusicaDTO>> obterPorAnoLancamento(@PathVariable("de") int de, @PathVariable("ate") int ate) {
        Optional<List<MusicaDTO>> music = service.obterPorAnoLancamento(de, ate);

        if (music.isPresent())
        {
            return new ResponseEntity<>(music.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/PorTitulo/{titulo}")
    public ResponseEntity<Musica> findByTitulo(@PathVariable("titulo") String titulo) {
        Optional<Musica> music = service.obterPorTitulo(titulo);

        if (music.isPresent())
        {
            return new ResponseEntity<>(music.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaDTO> adicionarMusica(@RequestBody @Valid Musica musica) {
        return new ResponseEntity<>(service.adicionarMusica(musica), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMusica(@PathVariable String id) {
        Optional<MusicaDTO> music = service.obterPorId(id);
        if (music.isPresent())
        {
            service.excluirMusica(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/PorTitulo/{titulo}")
    public ResponseEntity<Void> excluirPorTitulo(@PathVariable("titulo") String titulo) {
        Optional<Musica> music = service.obterPorTitulo(titulo);

        if (music.isPresent())
        {
            service.excluirPorTitulo(titulo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Musica> atualizarMusica(@PathVariable String id, @RequestBody Musica musica) {
        Optional<MusicaDTO> music = service.obterPorId(id);
        if (music.isPresent())
        {
            return new ResponseEntity<>(service.atualizarMusicaId(id, musica), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}