Tema 3 

Homework package:
1. Am dezvoltat un model orientat pe obiect ce contine clasele **Person, Programmer, Designer, Company, Network si interfata Node**;
2. Clasele **Person** si **Company** implementeaza interfata Node;
3. Clasa **Person** este abstracta, iar proprietatile ei sunt mostenite de clasele Programmer si Designer;
4. **Programmer si Designer** suprascriu metoda **public int getConnectionNumber()** pentru a prelua numarul de conexiuni per nod; Fiecare clasa contine interfata **java.util.Map** pentru definirea relatiilor person-to-person si person-to-company si o metoda **public void addRelationship(Node node, String relationshipType)** pentru adaugarea relatiilor mentionate;
5. Clasa **Network** contine o lista de noduri si implementeaza **interfata Comparator** pentru a le compara dupa numarul de conexiuni la alte noduri.
6. In Interfata **Node** am adaugat metoda getRelationships pentru a putea prelua lista de adiacenta a fiecarui nod si a le utiliza in clasa Network.
7. Am implementat in clasa **Network** algoritmul lui Tarjan pentru a verifica daca exista puncte de articulatie, prin intermediul unui algoritm DFS. 