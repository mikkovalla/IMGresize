# Testaus Dokumentti

## JUnit yksikkötestaus

Pyrin niin lähelle kuin mahdollista 100% testi kattavuutta. Testikattavuuden seuranta on automatisoitu Jacoco'lla ja dokumentti on nähtävissä täällä:

[Jacoco testikattavuus seuranta](../master/IMGresize/target/site/jacoco/index.html)


## Ajankäyttö / Empirical

Ohjelmaan on rakennettu apu metodit Performance luokkaan mitkä mittaavat eri algoritmien ajan käytön sekä koko-muokatun kuvan tiedoston koon. 

Tässä on nyt huomioitava että vaikka Scalr dokumentointi sanoo että kuva generoidaan annettujen parametrien mukaan niin vaikuttaisi ettei Scalr metodi ota huomioon annettua kuvan korkeutta ollenkaan. Tämä tulee esille jos antaa parametreinä 2 ja 4.

Alla on taulukoituna tähän mennessä kirjaamani testit:

 - Alkuperäinen kuvan koko 68.75 kb

#### Bilianeerinen oma toteutus

| Value1 x Value2 | Aika millisekuntia       | Koko kb |
| -------------  |:------------:| ----------:|
| 2 x 2      | 990          | 198.970        |
| 2 x 3      | 1354          | 268.708        |
| 3 x 2      | 1346        | 273.784       | 
| 6 x 6    | 7488         | 1054.736      |
| 10 x 10    | 20399         | 2382.617      |

#### Bilianeerinen Scalr kirjasto

| Value1 x Value2 | Aika millisekuntia       | Koko kb |
| -------------  |:------------:| ----------:|
| 2 x 2      | 152         | 188.952        |
| 2 x 3      | 132          | 188.952        |
| 3 x 2      | 203         | 370.064       | 
| 6 x 6    | 592        | 1040.236      |
| 10 x 10    | 1689         | 2359.814      |