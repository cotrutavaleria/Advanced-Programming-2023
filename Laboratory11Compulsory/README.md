Compulsory 11
1. Pentru a inregistra jucatorii, in aplicatia **ServerApplication**, am utilizat EclipseLink JPA. Am creat un fisier src/main/resources/META-INF/persistence.xml pentru a detalia informatii despre conexiunea cu baza de date existenta.
2. Am definit clasa **Player** drept entitate pentru proiect. 
3. Am creat clasa **Singleton** care implementeaza un singleton responsabil de gestionarea interactiunii cu un obiect al interfetei EntityManagerFactory. 
4. Am definit clasa **PlayerRepository** ce contine metoda responsabila de inserarea tuplelor in tabela _players_ din baza de date.
5. Am instantiat un obiect al clasei **RegisterPlayer** in clasa **ClientThread** pentru a insera informatiile in baza de date despre jucatorul caruia i s-a desemnat un fir de executie.
6. In aplicatia **demo**, am creat pachetele controllers, entities, repositories si services.
7. Pachetul **entities** contine clasa **Player** ce defineste tabela din care se vor prelua informatiile despre jucatorii inregistrati in baza de date.
8. Pachetul **repositories** contine clasa **PlayerRepository** care extinde clasa **JpaRepository** si preia metoda _findAll()_.
9. Pachetul **services** contine clasa **PlayerService** care este responsabila de implementarea metodei _findAllPlayers()_ ce utilizeaza metoda din clasa **PlayerRepository**.
10. Pachetul **controllers** contine clasa **PlayerController** care gestioneaza rutele publice specifice jucatorului. Clasa contine metodele _List<Player> getPlayers(), int countPlayers(), Player getPlayer(@PathVariable("id") int id)_ care ofera informatii despre toti jucatorii existenti, numarul de jucatori si jucatorul cu un anumit id.
11. Pentru a testa serviciul, am utilizat platforma API _Postman_.