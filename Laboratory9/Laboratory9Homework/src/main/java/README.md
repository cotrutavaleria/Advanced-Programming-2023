Tema 9
1. Toate clasele entitati si cele de stocare au fost create in proiectul _Laboratory9Compulsory_.
2. Am implementat relatia _one-to-many_ dintre albume si genuri. De asemenea, relatia _many-to-many_ a fost dezvoltata intre clasele **Album si Artist**.
3. Clasa abstracta **AbstractEntity** este extinsa de catre clasele **Album, Artist, Genre**.
4. Am creat o clasa abstracta **DataRepository** utilizand "generics" pentru a simplifica implementarea claselor ce fac parte din pachetul **homework/repositories**.
5. Pentru inserarea unui numar mare de artisti si albume false, am utilizat clasa **Faker**. Metoda _insertFake(AlbumRepository albumRepository, ArtistRepository artistRepository)_ vizeaza monitorizarea timpului de executie a celor doua tipuri de inserare.
