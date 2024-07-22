Compulsory 9

1. Pentru a implementa proiectul dat, am utilizat _EclipseLink JPA_. Am creat un fisier **src/main/resources/META-INF/persistence.xml** pentru a detalia informatii despre conexiunea cu baza de date existenta.
2. In pachetul **compulsory/entities** am definit clasele entitati **Album, Artist si Genre** pentru proiect. 
3. Am creat clasa **Singleton** care implementeaza un singleton responsabil de gestionarea interactiunii cu un obiect al interfetei **EntityManagerFactory**.
4. In pachetul **compulsory/repositories** am definit clasele ce contin metodele responsabile de inserarea tuplelor in tabelele _albums, artists, genres_, gasirea unor tuple dupa id-ul acestora, dupa numele artistului/genului sau dupa titlul albumului.
5. Clasa **Test** presupune testarea simpla a aplicatiei.
