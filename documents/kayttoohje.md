## Käyttöohje
Ohjelma käynnistyy komentoriviltä projektin juuressa komennolla 
```./gradlew run``` tai ```gradle run```

Toinen vaihtoehto ja visuaalisesti miellyttävämpi on ajaa ensin build komennolla
```./gradlew build``` ja sen jälkeen ajaa ohjelman jar-tiedosto komennolla 
```java -jar app/build/libs/app.jar```.

Kolmas vaihtoehto on ladata github releaseista jar tiedosto ja ajaa se tiedoston sijaintikansiossa komennolla 
```java -jar app.jar```

## Ohjelman toiminta
Ohjelman toiminta on yksinkertainen ja se selviää yksinkertaisesta tekstipohjaisesta käyttöliittymästä. Valittavana on seitsemän toiminta, jotka selittävät melko hyvin itsensä. Vaihtoehto 6 suorittaa molemmat algoritmit samalla kerralla ja tulostaa niihin käytetyn ajan. 

## Testaus
Testit ja Jacoco raportit saa ajettua komennoilla
```./gradlew test``` ja ```./gradlew jacocoTestReport```

