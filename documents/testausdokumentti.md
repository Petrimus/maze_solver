# Testausdokumentti
Testauksessa on keskitytty yksikkötesteihin, joita seurataan Jacocon avulla. Ohjelman toiminnallisia luokkia ovat MazeGenerator, RecursiveSolve ja DeadendFillingSolver. Näiden oikea toiminta on pyritty testeillä varmistamaan.

## Yksikkötestit

### MazeGnerator
Testeissä generoidaan uusi labyrintti ja generoidulle labyrintille suoritetaan testejä, joilla varmistetaan sen oikeellisuus.
- Testataan, että labyrintti ei ole tyhjä.
- Testataan, että on oikean mittainen.
- Testataan, että 10 satunnaisesti valitusta labyrintin solmusta on ainakin yksi tie eteenpäin.
- Testataan, että ensimmäisestä ja viimeisestä solmusta on vain yksi tie pois.


### RecursiveSolve
Testataan rekursiivista ratkaisualgoritmia valmiilla etukäteen luotavalla labyrintillä.
- Testataan, että labyrintti ratkaiseminen onnistuu ja että ratkaisualgoritmi palauttaa oikean ratkaistun labyrintin.


