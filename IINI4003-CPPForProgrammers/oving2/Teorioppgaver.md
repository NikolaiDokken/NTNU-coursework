## Oppgave 2

Det vil ikke skje veldig mye, men vi får segmentation fault: 11.
Siden vi ikke initierer størrelsen til line. Vil vi kunne støte på problemer.

## Oppgave 3

Først og fremst kan man få feil om man skriver inn tekst som har lengde 5 eller
mer. Videre får man problemer om teksten ikke har noen e'er i seg. Da vil løkken
fortsette og pekeren vil peke på adresser utenfor adresserommet til tabellen.
