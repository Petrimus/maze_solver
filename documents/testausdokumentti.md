# Testausdokumentti
Testauksessa on keskitytty yksikkötesteihin, joita seurataan Jacocon avulla. Ohjelman toiminnallisia luokkia ovat MazeGenerator, RecursiveSolve ja DeadendFillingSolver. Näiden oikea toiminta on pyritty testeillä varmistamaan. Jacoco testausraportit löytyvät 

## Yksikkötestit

### MazeGnerator
Testeissä generoidaan uusi labyrintti ja generoidulle labyrintille suoritetaan testejä, joilla varmistetaan sen oikeellisuus.
- Testataan, että labyrintti ei ole tyhjä.
- Testataan, että on oikean mittainen.
- Testataan, että 10 satunnaisesti valitusta labyrintin solmusta on ainakin yksi tie eteenpäin.
- Testataan, että ensimmäisestä ja viimeisestä solmusta on vain yksi tie pois.
-Testataan, että väärän kokoista labyrinttiä ei voi luoda.


### RecursiveSolve
Testataan rekursiivista ratkaisualgoritmia valmiilla etukäteen luotavalla labyrintillä, jonka oikeellisuus on paperilla varmistettu.

- Testataan, että palauttaa ei tyhjän olion.
- Testataan, että labyrintti ratkaiseminen onnistuu.
- Testataan, että palautuva Maze-olio on oikeanlainen.
- Testaan, että ratkaisualgoritmi palauttaa oikean ratkaistun labyrintin.

## DeadendFillingSolver
- Testataan, että labyrintti ratkaiseminen onnistuu.
- Testataan, että palautuva Maze-olio on oikeanlainen.
- Testaan, että ratkaisualgoritmi palauttaa oikean ratkaistun labyrintin.

## Suorituskykytestaus
Ohjelman algoritmeja testattiin empiirisesti erilaisilla labyrinteilla. Labyrinttien leveys ja korkeus olivat samat. Testattavien labyrinttien koot olivat 10, 50 100, 150 ja 200. Tämän suurempaan ei ikävä kyllä päästy, koska labyrinttigeneraattorin algoritmi aiheutti ylivuotoongelman, johon ei käytettävissä olevassa ajassa löytynyt ratkaisua. Tulokset olivat seuraavanlaiset:

![suoritustestaus](/documents/kuvat/performance.png)

Tulokset olivat linjassa oletusten kanssa, että aikavaatimus kasvaa lineaarisesti labyrintin koon kasvaessa eli että algoritmit toimivat O(n) ajassa.

## Testikattavuus

![testikattavuus](/documents/kuvat/testcoverage.png)



