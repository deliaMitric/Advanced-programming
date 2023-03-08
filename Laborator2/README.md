*compulsory
 - Am creat clasele Location si Road si am implementat tipurile locatiilor si tipurile strazilor ca si ENUM (Locations,Roads)
 - Am generat constructorii pentru fiecare dintre cele doua clase, setters si getters.
 - Am implementat metoda toString pentru fiecare dintre clasele Location si Road
 - In Main am creat diferite obiecte de tip Location si Road si a afisat pe ecran

*homework
 - Am creat o clasa noua Problem care contine doua array-uri, unul de tip Location si unul de tip Road, precum si informatii legate de dimensiunea acestora.
 - Pentru clasele Location si Road am implementat metoda equals pentru a o folosi la adaugarea unui obiect in array-urile din instanta unei probleme.
 -  pentru equals in Location: verifica doua obiecte de tip Location. Daca numele si coordonatele sunt aceleasi, returneaza TRUE (aceeasi locatie), altfel returneaza FALSE
 -  pentru equals in Road: verifica doua strazi. Daca numele, lungimea, tipul, limita de viteza si localitatile de start, respectiv, localitatile de final, corespund atunci returneaza TRUE (aceeasi strada), altfel returneaza FALSE
 - Clasa Location devine abstracta si este mostenita (extends..) de clasele City, GasStation si Airport care au in plus diferite proprietati (populatia, pretul gazului, numar de zboruri pe zi) si care implementeaza metoda getType (returneaza tipul localitatii) definita in clasa Location.
 - Metoda de verificare a validitatii instantei unei probleme am implementat-o si definit-o in clasa Problem astfel: 
 -  pentru locatii: am luat doua cate doua locatii si le am verificat prin equals, daca rezultatul e afirmativ->problema nu e valida; daca rezultatul e negativ verificam daca nu cumva cele doua locatii au nume diferit, dar aceleasi coordonate; in caz afirmativ->problema nu e valida, altfel continuam cu verificarea strazilor
 -  pentru strazi: am luat doua cate doua strazi si le am verificat prin metoda equals, daca rezultatul e afirmativ->problema nu e valida, altfel continuam verificand daca numele, lungimea, tipul si limita de viteza sunt egale si daca locatia de start pentru strada r1 e egala cu locatia de final a strazii r2 si reciproc; in caz afirmativ->problema nu e valida, altfel return TRUE (problema VALIDA)
 - In clasa Problem am implementat si metode pentru adaugarea de obiecte de tip Location, respectiv Road care folosesc metoda equals pentru a impiedica adaugarea unei locatii, strazi deja adaugate.
 - Pentru implementarea unui algoritm care sa determine daca e posibil sa ajungem dintr-o locatie in alta locatie folosind strazile adaugate am folosit BFS in clasa Graph (clasa care contine listele de adiacenta ale unui graf si numarul de noduri, precum si o metoda ce adauga muchii si metoda BFS ce returneaza TRUE daca a gasit drum de la nodul START la nodul FINISH)
 - Am creat o clasa abstracta Algorithm.
 -  Clasa FindPath mosteneste clasa Algortihm si contine o metoda (definita in clasa Algorithm) ce primeste ca parametri: un obiect de tip Problem (pb), un obiect de tip Location (nodul de START) si un al doilea obiect de tip Location (nodul de FINISH). Am creat o obiect de tip Graph si ne folosim de indexurile array-urile din pb pentru a adauga locatiile ca si noduri in graf, apoi apelam functia bfs cu locatiile primite ca si parametri. Daca rezultatul e afirmativ->return TRUE (avem drum intre locatiile specificate), altfel return FALSE (nu avem drum intre locatiile specificate).
 - Am scris comentarii pentru javadoc folosind /** */ si am generat documentatia din linia de comanda folosind comanda: javadoc -d destinatie package.
