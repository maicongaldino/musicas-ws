package br.com.tech4me.musicasws.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.tech4me.musicasws.Model.Musica;
import br.com.tech4me.musicasws.Shared.MusicaDTO;

public interface MusicaRepository extends MongoRepository<Musica, String> {

    @Query(value = "{ $and: [ { 'anoLancamento' : { $gte: ?0 } }, { 'anoLancamento' : { $lte : ?1 } } ] }")
    public Optional<List<MusicaDTO>> obterPorAnoLancamento(int de, int ate);

    @Query(value = "{'titulo' : ?0}")
    public Optional<Musica> obterPorTitulo(String titulo);

    public void deleteByTituloStartingWithIgnoreCase(String titulo);

    public Musica findByTitulo(String id);
}