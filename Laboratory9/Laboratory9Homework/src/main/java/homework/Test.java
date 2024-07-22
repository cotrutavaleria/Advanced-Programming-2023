package homework;

import com.github.javafaker.Faker;
import homework.entities.Album;
import homework.entities.Artist;
import homework.entities.Genre;
import homework.repositories.AlbumRepository;
import homework.repositories.ArtistRepository;
import homework.repositories.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private long start;

    public Test() {
    }

    public void testJPA() {
        EntityManagerFactory emf = Singleton.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        GenreRepository genreRepository = new GenreRepository(em);
        Genre genre1 = new Genre("Blues");
        genreRepository.create(genre1);
        Genre genre2 = new Genre("Rock");
        genreRepository.create(genre2);

        List<Genre> genreList = new ArrayList<Genre>();
        genreList.add(genre1);
        genreList.add(genre2);

        AlbumRepository albumRepository = new AlbumRepository(em);
        Album album1 = new Album(1979, "The Wall", "Pink Floyd");
        Album album2 = new Album(1979, "Hey You", "Pink Floyd");
        Album album3 = new Album(1985, "We are the World", "Michael Jackson");
        Album album4 = new Album(1982, "Beat It", "Michael Jackson");
        album1.setAlbumGenres(genreList);
        albumRepository.create(album1);
        albumRepository.create(album2);
        albumRepository.create(album3);
        albumRepository.create(album4);

        System.out.println("Album found by id = 10: " + albumRepository.findById(10));
        System.out.println("Albums found by title = " + album1.getTitle() + ": " + albumRepository.findByName(album1.getTitle()));

        ArtistRepository artistRepository = new ArtistRepository(em);
        Artist artist1 = new Artist("Michael Jackson");
        Artist artist2 = new Artist("Pink Floyd");
        artistRepository.create(artist1);
        artistRepository.create(artist2);

        List<Album> albumList1 = new ArrayList<Album>();

        albumList1.add(album1);
        albumList1.add(album2);
        artist1.setAlbumList(albumList1);

        List<Album> albumList2 = new ArrayList<Album>();

        albumList2.add(album3);
        albumList2.add(album4);
        artist2.setAlbumList(albumList2);

        System.out.println("Artist found by id = 10: " + artistRepository.findById(10));
        System.out.println("Artists found by name = " + artist1.getName() + ": " + artistRepository.findByName(artist1.getName()));

        insertFake(albumRepository, artistRepository);

        em.getTransaction().commit();
        em.close();
        Singleton.closeEntityManagerFactory();
    }
    public void insertFake(AlbumRepository albumRepository, ArtistRepository artistRepository){
        Faker faker = new Faker();
        this.start = System.currentTimeMillis();
        for (int index = 0; index < 100; index++) {
            albumRepository.create(new Album(Integer.parseInt(faker.number().digits(4)), faker.music().instrument() + faker.music().genre(), faker.artist().name()));
        }
        long end = System.currentTimeMillis();
        System.out.println("Timpul pentru a insera 100 de albume: " + (end - start) + " milisecunde");

        for (int index = 0; index < 50; index++) {
            artistRepository.create(new Artist(faker.artist().name()));
        }
        end = System.currentTimeMillis();
        System.out.println("Timpul pentru a insera 50 de artisti: " + (end - start) + " milisecunde");
    }
}
