package br.com.tech4me.musicasws.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.musicasws.Model.Musica;
import br.com.tech4me.musicasws.Repository.MusicaRepository;
import br.com.tech4me.musicasws.Shared.MusicaDTO;

@Service
public class MusicaServiceImpl implements MusicaService {
    @Autowired
    private MusicaRepository repository;

    @Override
    public MusicaDTO adicionarMusica(Musica musica) {
        repository.save(musica);
        return new ModelMapper().map(musica, MusicaDTO.class);
    }

    @Override
    public List<MusicaDTO> obterTodas() {
        List<Musica> musicas = repository.findAll();
        return musicas.stream()
            .map(p -> new ModelMapper().map(p, MusicaDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<Musica> obterTodasDetalhado() {
        return repository.findAll();
    }

    @Override
    public Optional<MusicaDTO> obterPorId(String id) {
        Optional<Musica> music = repository.findById(id);

        if (music.isPresent())
        {
            return Optional.of(new ModelMapper().map(music.get(), MusicaDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public void excluirMusica(String id) {
        repository.deleteById(id);
    }

    @Override
    public Musica atualizarMusicaId(String id, Musica musica) {
        musica.setId(id);
        return repository.save(musica);
    }

    @Override
    public Optional<List<MusicaDTO>> obterPorAnoLancamento(int de, int ate) {
        Optional<List<MusicaDTO>> music = repository.obterPorAnoLancamento(de, ate);

        if (music.get().size() >= 1)
        {
            return Optional.of(music.get());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Musica> obterPorTitulo(String titulo) {
        Optional<Musica> music = repository.obterPorTitulo(titulo);

        if (music.isPresent())
        {
            return Optional.of(music.get());
        }
        return Optional.empty();
    }

    @Override
    public void excluirPorTitulo(String titulo) {
        repository.deleteByTituloStartingWithIgnoreCase(titulo);
    }
}