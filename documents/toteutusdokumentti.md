# Toteutusdokumentti
Ohjelmalla voi luoda labyrinttejä ja ratkaista niitä kahdella vaihtoehtoisella algoritmilla. Labyrintti generoidaan käyttämällä recursive backtracking-algoritmiä. Labyrintin ratkaisemiseen on tarjolla kaksi vaihtoehtoista algoritmiä, jotka molemmat perustuvat rekursioon. Ensimmäisen on samansuuntainen generointi-algoritmin kanssa ja toinen on deadend filling-algoritmi. Suurin ero näillä on ehkä se, että rekursiivinen algoritmin ei tarvitse tuntua labyrinttiä etukäteen, kun taas deadend filling-algoritmi käy labyrintin ensiksi läpi eli sem täytyy tuntua labyrintti.

## Ohjelman yleisrakenne
Ohjelma on toteutettu javalla gradle-projektina. Ohjelma käynnistyy App-luokasta, jonka jälkeen käyttöliittymäluokka vastaa ohjelman pyörittämisestä seitsemän interaktiivisen komennon avulla.

Ohjelman luokat:
- App - ohjelman käynnistävä luokka, joss main metodi
- Cell - Kuvaa yhden yksittäisen labyrintin solun
- DeadendFillingSolver - sisältää toiminnallisuuden, jolla voi ratkaista labyrintin deadend filling-algoritmilla
- Direction - Luokka, joka määrittelee liikkumasuunnan käsitteen
- Maze - labyrintti-olio ja sen toiminnallisuus
- MazeGenerator - sisältää toiminnallisuuden labyrinttien luomiseen
- RecursiveSolve - luokka, joka vastaa labyrintin rekursiivisesta ratkaisemisesta
- UserInterface - on käyttöliittymäluokka
- Utils - sisältää apumetodeja. Jäi vähän turhaksi ja olisi voinut sisällyttää muihin luokkiin

## Ohjelman aikavaatimukset
Ohjelma toimii teoriatasolla sekä empiirisen testaamisen jälkeen O(n) ajassa. Ohjelman ratkaisuihin käyttämä aika siis kasvaa lineaarisesti labyrintin koon kasvaessa. Labyrintti on toteutettu kaksi-dimensioisella taulukolla, joten sen koko kasvaa kahden potesseina. Ohjelman suoritusaikaa on testattu empiirisesti, mutta ongelma oli, että se toimii 200 x 200 taulukkoon asti, jonka jälkeen se kaatuu stackoverflow virheeseen. En onnistunut tätä parin päivän työllä korjaamaan enkä tiedä onko se ohjelman vai pinoon allokoidun tallennustilan ongelma. Tässä vaiheessa taulukko sisältää kuitenkin jo 40K solua.

![suoritustestaus](/documents/kuvat/performance.png)

Testus noudattaa oletettua kulkua. Mielenkiintoinen yksityiskohta on se, että rekursiivinen algoritmi tuntuu toimivan tehokkaammin kuin deadend filling-algoritmi, vaikka jälkimmäisessä on mukana enemmän logiikkaa. Toisaalta se voi johtua generoitujen labyrinttien rakenteesta, joka on melko yksinkertaien eikä sisällä esimerkiksi looppeja.

## Parannusehdotukset
Työssä on labyrinttien generoimisessa käytetty bittioperaatiota, jotka toimivat kohtalaisen hyvin, mutta sen jälkeen on palattu käyttämään Cell-olioihin, joiden avulla mallinnetaan yhtä solua. Olisi toki tehokkaampaa käsitellä koko ajan pelkästään primitiiejä. Iso parannuskohde olisi myös selvittää, miksi ohjelma kaatuu, kun labyrintin koko ylittää 200 x 200 ruutua. Se aiheuttaa stackoverflow virheen, mutta taulukko ei kuitenkaan tunnu kovin isolta. Epäilen virheen löytyvän koodistani, mutta en millään keksinyt mistä. Korjausyritukseni eivät tuottaneet mainittavaa parannusta.
