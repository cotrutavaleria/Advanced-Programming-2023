Compulsory 5
1. Am creat un model orientat pe obiect al problemei descrise in laborator. Modelul consta din doua clase **Catalog** si **Document** care implementeaza interfata speciala **Serializable**, clasa **CatalogCommands** care prevede implementarea comenzilor _save_ si _load_ si clasa **InvalidCatalogException** care extinde clasa **Exception** pentru a crea o exceptie custom.
2. Comenzile _add_ si _toString_ au fost implementate in clasa **Catalog**.
3. Comenzile _save_ si _load_ au fost implementate utilizand libraria Jackson. 
4. Fisierul **Main.java** descrie o instanta a problemei.

Homework 5
1. Comenzile _load, list, view, report_ sunt create si implementate drept clase cu nume sugestive ce implementeaza interfata **Command** care contine o comanda generica.
2. Clasa **AddCommand** prevede implementarea comenzii _load_ prin verificarea extensiei fisierului si citirea din fisier in cazul in care este valid.
3. **ListCommand** apeleaza comanda _toString_ creata in Homework.
4. Clasa **ViewReport** utilizeaza clasa **Desktop** si metoda _open_ din ea.
5. Clasa **ReportCommand** permite crearea si deschiderea unui raport HTML ce reprezinta continutul catalogului. Pentru a construi clasa, am utilizat template-ul engine _FreeMaker_. Fisierele utilizate se pot gasi in directorul _FreemakerTemplate_.
6. Aplicatia semnaleaza exceptii pentru comenzi sau fisiere invalide pe baza exceptiei custom _InvalidCatalogException_ sau a exceptiei _IOException_.
7. Fisierul **Main.java** descrie o instanta a problemei.
