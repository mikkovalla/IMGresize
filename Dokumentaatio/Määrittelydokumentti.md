# Määrittelydokumentti

### Mitä algoritmeja ja tietorakenteita toteutat työssäsi

Tarkoitus on toteuttaa seuraavat algoritmit:
 1. Bilineaarinen kuvan muokkaus algoritmi
 2. Lähin-naapuri interpolaatio

 Molemmista algoritmeistä löytyy valmiit java luokat, ja pyrin luomaan identtisesti toimivan algoritmin pseudokoodin perusteella.

 Valmiit algoritmit ovat Javan oma Image luokka, sekä mahdollisesti NodeJS totetutettu Sharp kirjaston tarjoama algoritmi Javascriptilla totetutettuna. Pyrin löytämään velä yhden valmiin kirjaston joka antaa käyttöön tehokkaan kuva manipulaatio algoritmin johon voin vertaa omiani.

### Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet

Yhdessä Android projektissa tuli eteen mietintä että kun käyttäjä ottaa mobiililaitteella kuvan ja lataa kuvan palveluun, esimerkiksi palautteena, kuva pitää muuntaa palvelimelle sekä palveluun sopivaan kokoon. Sopiva koko on sekä mobiililaitteen että tietokoneen selaimessa optimaalisesti renderoituva kuva joka on tallennettu palvelimelle.

Kysymys onkin, mikä on tehokas algoritmi suorittamaan kuvan koon muutoksen ennen tallentamista palveluun (tietokanta). Tähän kysymykseen pyrin löytämään työssäni vastauksen. Pyrin toteamaan onko Bilineearinen tai lähin-naapuri algoritmi tehokkaampi minun toteuttamanani kuin valmiista kirjastoa tai Javan Image luokan tarjoamia metodeja käyttämällä tehty kuvan koon muunnos.

### Mitä syötteitä ohjelma saa ja miten näitä käytetään

Tarkoitus on tehdä yksinkertainen käyttöliittymä jossa ohjelmalle annetaan kuva tiedosto JPEG tai PNG muodossa, ja ohjelma luo uuden muunnetun kuvatiedoston tuhoamatta alkuperäisen kuvan rakennetta. Kuvan muunnoksen on tarkoitus toimia kasvatettuna sekä pienennettynä, käyttäjän antaman komennon mukaisesti.

### Tavoitteena olevat aika- ja tilavaativuudet (m.m. O-analyysit)

Tavoite on O(n) nopeuden ja O(n) tilavaativuuden omaava algoritmi. Tarkkaan en osaa vielä sanoa koska en ole vielä analysoinut pseudokoodia syvällisesti.
Stackoverflowssa mainitussa lauseessa mainittiin että kuva manipulaatio olisi nopeimmillaan O(log n) aikavaativuudeltaan.

### Lähteet

- https://en.wikipedia.org/wiki/Image_scaling
- https://en.wikipedia.org/wiki/Comparison_gallery_of_image_scaling_algorithms
- https://www.javalobby.org//articles/ultimate-image/
- https://www.slideshare.net/editorijritcc1/performance-analysis-of-image-scaling-algorithms
- https://github.com/lovell/sharp