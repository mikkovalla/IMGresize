# Käyttöohje

### Miten ohjelma suoritetaan, miten eri toiminnalisuuksia käytetään
Ohjelma suoritetaan ajaamalla JAR tiedosto tai kehitysympäristössä.

Kun ohjelma ajetaan, workflow on seuraavanlainen:

1. Ohjelma listaa projekti kansiosta löytyneet kuva tiedostot.
2. Käyttäjä valitsee yhden kuva tiedoston syöttäen sen nimen kokonaisena ohjelmalle.
3. Ohjelma kysyy kuinka suureksi leveys suunnassa käyttäjä haluaa kuvan muokata.
4. ohjelma kysyy kuinka suureksi korkeus suunnassa käyttäjä haluaa kuvan muokata.
5. Ohjelmaa avaa kysytyn kuvan, muodostaa siitä käyttäjän parametrien mukaisesti kaksi uutta kuvaa.
   Toinen muodostetaan Scalr kirjaston tarjoamalla algoritmilla ja toinen oma rakenteisella Bilineeari-interpolaatio algoritmilla.
6. Ohjelma laskee kuvan muodostamiseen käytetyn ajan sekä muodostuneen kuvan koon ja esittää ne käyttäjälle. 
7. Kuvat tallentuvat projektin juureen nimettynä käytetyn metodin mukaisesti.

### Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet
Kyseessä ei varsinaisesti ollut ongelman ratkaisu, vaan pikemminkin mielenkiinnosta syntynyt testi. Web devauksessa palvelimelle kuvia ladattaessa käytetään hyvin yleisesti ImageMagick nimistä kirjastoa, joka on hyvin nopea, ja bilineaarinen interpolaatio on lukemani mukaan suosittu tapa suurentaa käyttäjän lataama kuva.
Halusin testata pystynkö rakentamaan bilineaarisen-interpolaation suorittavan algoritmin itse javalla. Hommassa oli haasteensa mutta algoritmi näyttäisi toimivan oikein.

Minun olisi varmaan pitänyt rakentaa BufferedImage sekä Scanner luokka myös itse mutta ajan puutteen takia päädyin tekemään vain ArrayList tietorakenteen itse. Kyseinen tietorakenne toimii mielestäni yhtä hyvin kuin javan oma. 
### Mitä syötteitä ohjelma saa ja miten näitä käytetään
Ohjelma saa käyttäjältä leveys sekä korkeus arvot. Arvot ovat float tyyppisiä arvoja joilla algoritmi määrittää halutun kuvan suurennus koon.

### Tavoitteena olevat aika- ja tilavaativuudet (m.m. O-analyysit)

Ajateltu O(n^3) on liioiteltu. Aikavaativuudeltaan 
```
public BufferedImage resizeBufferedImageWithBilinearInterpolation(BufferedImage image, float horisontal, float vertical) {
```
suorittaminen vie aikaa O(n^2). Metodi sisältää sisäkkäisen for-loopin, mutta kolmas for-loop on vakio pituudella ja suoritetaan aina arvoon 2 asti. 

Sisäkköiset for-loopit:
```
//Ulompi for looppi iteroi kuvan leveyden mukaan - Loop iterates by image width
        for (int x = 0; x < width; ++x) {
            //Sisempi for looppi iteroi kuvan korkeuden mukaan - Loop iterates by image height
            for (int y = 0; y < height; ++y) {
```
ja vakio suoritus kertainen for-loop
```
for (int i = 0; i <= 2; ++i) {
```
Algoritmin tilavaativuus on O(n) koska tilavaativuus on sidottu syötteenä saadun kuvan korkeuteen sekä leveyteen, eli tilavaativuus on lineaarinen.