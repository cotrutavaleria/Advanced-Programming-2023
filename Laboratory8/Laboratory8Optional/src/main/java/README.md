Tema 8

1. Am implementat toate clasele DAO.
2. Am creat un model orientat pe obiect al gestiunii de date de catre aplicatia Java dezvoltata, prin implementarea unei interfete **Dao** aplicata de clasele DAO si clasa abstracta **Table** extinsa de clase precum _Album, AlbumGenre,etc_ .
3. Am utilizat **Apache Commons DB Connection Pool** pentru a gestiona conexiunile cu baza de date prin intermediul clasei **ConnectionPool**.
4. Am redactat **script.sql** pentru a crea un nou tabel unde vor fi importate datele din fisierul de tip CSV **albumlist.csv** ce contine un set de date real _Rolling Stone's 500 Greatest Albums of All Time_.

Bonus 
1. Modelul dozvoltat in tema a fost extins pentru a crea playlist-uri. In **script.sql** am adaugat doua comenzi pentru crearea unui tabel _playlists_ ce contine un id, numele playlist-ului si timpul crearii si un tabel _playlists_albums_ ce permite asocierea albumelor la un anumit playlist. 
2. Am implementat clasele din pachetul **bonus**, fiecare avand o denumire sugestiva, care au scopul de a gestiona mai facil interactiunea cu baza de date.
3. Clasa **CreatePlaylistAlgoritm** este responsabila de popularea tabelelor mentionate recent. 
4. Albumele dintr-un playlist nu au acelasi artist, nu sunt lansate in acelasi an si nu fac parte din aceleasi genuri de muzica.
5. Pentru a exemplifica eficienta algoritmului, am implementat metoda _displayTheNumberOfPlaylists_ si _displayTheFirstPlaylist_ care afiseaza numarul de playlist-uri existente si albumele din primul playlist creat.
