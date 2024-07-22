package compulsory;

import compulsory.entities.Album;
import compulsory.entities.Artist;
import compulsory.entities.Genre;
import compulsory.repositories.AlbumRepository;
import compulsory.repositories.ArtistRepository;
import compulsory.repositories.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Test {
    public Test() {
    }

    public void testJPA() {
        EntityManagerFactory emf = Singleton.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Artist artist = new Artist("Michael Jackson");
        ArtistRepository artistRepository = new ArtistRepository(em);
        artistRepository.create(artist);
        System.out.println("Artist found by id = 10: " + artistRepository.findById(10));
        System.out.println("Artists found by name = " + artist.getName() + ": " + artistRepository.findByName(artist.getName()));

        Album album = new Album(1979, "The Wall", "Pink Floyd");
        AlbumRepository albumRepository = new AlbumRepository(em);
        albumRepository.create(album);
        System.out.println("Album found by id = 10: " + albumRepository.findById(10));
        System.out.println("Albums found by title = " + album.getTitle() + ": " + albumRepository.findByTitle(album.getTitle()));

        Genre genre = new Genre("Blues");
        GenreRepository genreRepository = new GenreRepository(em);
        genreRepository.create(genre);
        System.out.println("Genre found by id = 10: " + genreRepository.findById(10));
        System.out.println("Genres found by name = " + genre.getName() + ": " + genreRepository.findByTitle(genre.getName()));

        em.close();
        Singleton.closeEntityManagerFactory();
    }
}
