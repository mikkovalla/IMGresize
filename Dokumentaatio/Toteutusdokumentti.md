## Ohjelman yleisrakenne

Ohjelma käyttää käyttäjän määrittelemää kuvaa ja muuntaa sen kahdella eri kuvan muokkaus algoritmilla käyttäjän haluamaan uuteen kokoon. 

Muunnoksen suorituksen aikana ohjelma mittaa vaaditun ajan operaatioiden suorittamiselle sekä laskee uusien kuvien koon.

## Saavutetut aika- ja tilavaativuudet (m.m. O-analyysit pseudokoodista)

Näitä en ole vielä tarkkaan laskenut.

Ensimmäinen arvio kuitenkin on että oman bilineaarisen algoritmin toteutus on O(n^3) koska Bilinear luokan metodi resizeBufferedImageWithBilinearInterpolation() sisältää kolme sisäkkäistä for-looppia.

## Suorituskyky- ja O-analyysivertailu (mikäli työ vertailupainotteinen)

Ensimmäisten testien perusteella oma algoritmi on huomattavasti hitaampi kuin Sclar kirjaston tarjoama valmis toteutus.

## Työn mahdolliset puutteet ja parannusehdotukset

Apache kirjaston kuvan muokkaus algoritmi mukaan antamaan kolmannen vertaus kohteen, sekä tuloksien esittäminen selkeämmin line-graph muodossa. Nyt pelkistä luvuista ei saa selkeää kuvaa algoritmien tehokkuus eroista.

## Lähteet