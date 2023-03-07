*compulsory
 - Am afisat pe ecran mesajul "Hello World"
 - Am declarat si inializat un String array languages cu {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
 - Am generat random un numar n folosind comanda (int) (Math.random() * 1_000_000)
 - Am inmultit n cu 3, apoi l-a adunat cu numarul 10101 in baza 2. Rezultatul l-am adunat cu FF in baza 16 si rezultatul final l-am inmultit cu 6.
 - Rezultatul final e dat ca si parametru metodei "suma" care calculeaza suma cifrelor unui numar in mod repetitiv cat timp aceasta rezulatul acestei sume este mai mare decat 9 (are mai mult de o cifra)
 - Afisam rezultatul pe ecran si elementul de pe pozitia "result" din arrayul languages
*homework
 - Am citit de la linia de comanda un numar n ce reprezinta dimensiunea matricii latine pe care o vom construi.
 - Metoda createLatinMatrix primeste ca si parametru numarul citit si returneaza o matrice de nxn. Matricea e construita astfel:
 -  in variabila finalValueOfLine pastram ultima valoare de pe linia precedenta cu care vom incepe linia curenta. Pentru prima linie, aceasta variabila e initializata cu 1
 -  pe linia curenta, pt fiecare pozitie inafara de prima verificam valoarea precedenta.Pentru pozitia i, daca pe pozitia i-1 e valoarea n, atunci pe pozitia i punem 1, altfel, punem val(i-1)+1
 - Metoda printLinesColumns parcurge matricea pe linii si creaza un string pentru fiecare linie si il afiseaza, iar pentru coloane face la fel. 
 -  folosesc un StringBuffer pentru a putea modifica string-ul si la fiecare pas din parcurgerea unei linii/coloane, convertesc integer-ul la string si apoi il concatenez cu sirul format pana la momentul respectiv.
 -  repet procesul pentru fiecare linie/coloana in parte si afisez pe ecran
 - Pentru a calcula timpul de rulare in nanosecunde am folosit System.nanoTime():
 -  o data la inceputul lui main si o data la final apoi am calculat valoare absoluta a scaderii celor doua 
