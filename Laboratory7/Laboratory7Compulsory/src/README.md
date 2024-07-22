Tema 7
1. Am creat un model orientat pe obiect al problemei propuse.
2. Am construit clasa **Robot** care ofera fiecarui robot o denumire. Robotul extrage un numar predefinit de tokeni din memoria impartita si ii pune in celula vizitata. Robotii existenti se misca in mod concurent in jurul hartii de tip matrice (s-a implementat metoda run() ce apeleaza metoda visit din clasa **ExplorationMap**).
3. Se afiseaza un mesaj in caz ca robotul viziteaza o celula noua sau daca vreun robot viziteaza o celula oarecare vizitata in trecut.
4. Simularea explorarii se face prin utilizarea unui fir de executie pentru fiecare robot.
5. Sincronizarea robotilor se face la extragerea tokenilor cand o celula se viziteaza.