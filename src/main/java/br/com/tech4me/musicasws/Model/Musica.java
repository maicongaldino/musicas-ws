package br.com.tech4me.musicasws.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("musicas")
public class Musica {
    @Id
    private String id;
    
    @NotBlank(message = "Titulo só com caracteres em branco, impossivel adicionar !!!")
    @NotEmpty(message = "Titulo não pode estar em branco !!!")
    private String titulo;

    @NotBlank(message = "Artista só com caracteres em branco, impossivel adicionar !!!")
    @NotEmpty(message = "Artista não pode estar em branco !!!")
    @Size(min = 3, message = "O Artista deve conter 4 ou mais caracteres !!!")
    private String artista;

    private String album;

    @NotBlank(message = "Genero só com caracteres em branco, impossivel adicionar !!!")
    @NotEmpty(message = "Genero não pode estar em branco !!!")
    private String genero;

    @Min(value = 1877, message = "Data inválida !!!") //Pelo que eu vi foi a primeira musica gravada feita no mundo kkkk, ai a pessoa não pode botar antes.
    private int anoLancamento;

    @NotBlank(message = "Compositor só com caracteres em branco, impossivel adicionar !!!")
    @NotEmpty(message = "Compositor não pode estar em branco !!!")
    @Size(min = 3, message = "O compositor deve conter 4 ou mais caracteres !!!")
    private String compositor;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
}