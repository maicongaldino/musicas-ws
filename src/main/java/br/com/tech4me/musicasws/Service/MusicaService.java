package br.com.tech4me.musicasws.Service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.musicasws.Model.Musica;
import br.com.tech4me.musicasws.Shared.MusicaDTO;

public interface MusicaService {
    MusicaDTO adicionarMusica(Musica musica);

    List<MusicaDTO> obterTodas();

    List<Musica> obterTodasDetalhado();

    Optional<List<MusicaDTO>> obterPorAnoLancamento(int de, int ate);

    Optional<Musica> obterPorTitulo(String titulo);

    Optional<MusicaDTO> obterPorId(String id);

    void excluirMusica(String id);

    void excluirPorTitulo(String titulo);

    Musica atualizarMusicaId(String id, Musica musica);
}