Tema 2
1. Compulsory package:

   1.Am modificat clasele Location si Road, astfel incat:

   1. Clasa Location este o clasa abstracta;
   2. S-a implementat metoda Object.equals in cele doua clase mentionate;
   3. In clasa Road s-a implementat metoda public boolean isTheRoadLengthValid(double length) pentru a determina daca o instanta a problemei este valida ("The length of a road should not be less than the euclidian distance between the location coordinates.")
2. Homework package:

   1. S-au implementat clasele City, Airport, GasStation in locul clasei enum din Location, fiecare avand proprietati si metode aditionale; 
   2. Clasele City, Airport, GasStation sunt in relatie de mostenire cu clasa abstracta Location; 
   3. A fost creata o clasa Problem care descrie o instanta a problemei; 
   4. Clasa Problem contine metode de adaugare a  locatiilor si drumurilor fara duplicate si implementarea unui algoritm DFS utilizand HashMap-uri pentru a determina daca exista posibilitatea de ajunge dintr-o locatie specificata in alta;
3. Bonus package:

   1. A fost creata o clasa Solution cu scopul de a implementa o solutie pentru gasirea celui mai scurt drum de la o locatie anumita la fiecare locatie existenta; 
   2. Clasa Solution are implementat un algoritm bazat pe Algoritmul lui Dijkstra (cu HashMap-uri), care este apelat in clasa Problem.
4. In Main.java am initializat un obiect al clasei Problem. Am generat cateva instante ale problemei si am analizat performanta algoritmului lui Dijkstra implementat (running times, memory consumption).
5. Pentru Homework s-au generat doc comments si javadoc in folderul JavaDoc.