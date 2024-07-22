Compulsory 10

1. Am creat doua proiecte, _ServerApplication si ClientApplication_.
2. _ServerApplication_ contine clasele **GameServer, ClientThread si StopTheServer**.
3. Clasa **GameServer** este responsabila de crearea unei instante a clasei ServerSocket ce ruleaza la portul 8100. Crearea unui fir de executie pentru fiecare client se face prin interemdiului unui _thread pool_.
4. Clasa **ClientThread** primeste comenzile de la client si trimite un raspuns relevant.
5. Clasa **StopTheThread** este responsabila de setarea si preluarea atributului _running_ de care depinde oprirea serverului prin comanda "stop" data de client.
6. _ClientApplication_ contine clasa **GameClient**.
7. Instantierea unui obiect al clasei **GameClient** in _Main.java_ ne permite citirea de la tastatura a unor comenzi, trimiterea lor la server si primirea unor raspunsuri.
8. Clientul se opreste la tastarea comenzii "exit".
