# Määrittelydokumentti
- Opinto-ohjelma: Tietojenkäsittelytieteen kandidaatin tutkinto (TKT)
- Ohjelmointikieli: Java
- Kieli: suomi
- Vaihtoehtoinen kieli: Javascript, ehkä myös Python(alkeet)
- build tool: Gradle


## Aihe, maze solving algorithm
Ohjelma tulostaa ascii grafiikalla labyrintin ja tämän jälkeen lyhyimmän reitin labyrintistä ulos/läpi. Labyrintti tehdään joko itse tai haetaan valmiina käyttäen siihen tehtyjä paketteja. Mieluummin tekisin labyrintinkin itse, mutta en osaa sanoa vielä kuinka vaikeata se on. Ohjelma testaa ratkaisua kahdella eri algoritmilla ja vertailee niiden tehokkuutta.

Ohjelma tullee eriyttämään käyttöliittymän sekä logiikan. Käyttöliittymä rakennetaan ascii-grafiikan varaan ja se tulee pyytämään tekstimuotoista syötettä, josta ei kuitenkaan ole vielä tietoa.

## Algoritmejä
Algoritmeinä käytetään ainakin Djikstraa. Toinen algoritmi voisi olla IDA*. Eli algoritmien vertailu on IDA* vs. Dikstra.

## Aikavaaticuudet
Aikavaativuus on tässä vaiheessa O^n. Eiköhän se sillä ratkea. Mutta tarkoitus olisi päästä lopulta tirakurssilla esitetyihin aikavaativuuksiin. Aikavaatimus tarkentuu, aiheeseen tutustuminenetenee.