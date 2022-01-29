# Viikkoraportti 2

## Viikon tekemiset
Gradlen kanssa on painittu. Selvitetty System.in ongelma, jonka takia Scanner ei toiminut. Piti asettaa build.gradleen standardInput = System.in.
Käyttöliittymä on aloitettu, mutta sitä ei olla vielä sen erikoisemmin suunniteltu. 
Katselin videoita Java FX:n käytöstä ja mahdollisia toteutuksia labyrinttien tulostamisesta. Jatkan ainakin toistaiseksi ascii grafiikan (System.out.print) kanssa. En ainakaan vielä ole keksinyt muita vaihtoehja. 
Ensimmäinen labyrintti tulostettu. En ole vielä päättänyt, miten labyrinttien generointi toteutetaan, mutta aika monessa lähteessä verkossa käytetään "recursive backtracker"-algoritmiä, joka perustuu verkkoihin. Pitäisi selvittää, voiko labyrintin luoda jollakin yksinkertaisemmalla algoritmillä ja ratkaista toisella.
Opiskelin, että mikä on javaDoc ja se selvisi. Näköjään Netbeans luo pohjan jo heti luokka luotaessa.
Aloitettu juJunit opiskelu 2020 java moocista.

## Ohjelman edistyminen
Itse ohjelma on edistynyt melko vähän. Se tulostaa ascii grafiikalla labyrintin, mutta labyrintti on valmis 2d-array, joka on kovakoodattu koodiin. Aloin toteuttamaan dead-end filling algoritmiä, mutta se on vasta alku tekijöissään.

## oppiminen
Tähän mennessä asiat ovat oikeastaan olleet vanhan kertaamista. En ole pariin vuoteen Javaa käyttänyt ja vanhoja muistoja on vähän pitänyt verestää.  

## Ongelmia
Ei vielä pahoja tai että olisi jumissa jossain. 

## Seuraavat toimet
Dead-end filling saattaminen loppuun. Labyrinttien generoinnin suunnittelu. Ensiksi pitäisi tehdä helpompi labyrintti, jolla ohjelmaa voi testata. JavaFX:n pohdinta vaihtoehtoiseksi UI:ksi. Labyrinteissä animaatio olisi kyllä makeeta. Toisaalta en tiedä saako silloin laskettua suoritusaikoja. Ja sitten on myös testit. Niistä en muista tällä hetkellä mitään, joten 2020 MOOC pitää kaivaa esiin. 

## Työaika
Työaikaa on käytetty tällä viikolla 5 tuntia. Seuraava viikko on jo helpompi ja tämä projekti saa tarvitsemansa ajan.  
