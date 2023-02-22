# ProPra II Zusammenfassung

# Woche 1

_Vorgehensmodelle:_
- liefern Entwicklungs-Rahmen/Leitfaden/Plan
- beschreiben wie Problem in Lösung überführt wird
- logisch und zeitlich geordneter, strukturierter Ablauf
- beschreibung von u.a. Ergebnissen, Rollen

## Sequentielle Vorgehensmodelle

Wasserfall Modell
- Aufteilung in sequentiellen Projekt-Phasen
- In den Phasen werden vom Modell vorgeschriebene Artifakte / Dokumente erstellt
- Am Ende einer Phase wir der Meilenstein abgenommen
- Eine Phase beginnt erst, wenn die vorhergehende Phase abgeschlossen ist

![wasserfallmodell](images/wasserfallmodell.png)

Pro:
- Einfaches Modell
- Projektfortschritt transparent
- Produkt ist gut dokumentiert
    - Der Prozess ist auf Dokumente ausgelegt
    - Die Dokumente weden abgenommen, müssen daher qualitativ gut sein

Contra:
- Keine gute Auslastung der Kapazitäten
- Klare Phasengrenzen sind oft nicht realisierbar
- Lösungsalternativen werden früh verworfen
- Mehraufwand durch Dokumentation
- Unflexibel gegenüber Anforderungsänderungen
- Rücksprünge sind überlicherweise notwendig
    - Wiederspruch in den Anforderungen
    - Im Test werden Bugs gefunden
- Ein Rücksprung erfordert dass alle Meilensteine neu abgenommen werden

Nur Sinnvoll, wenn Rücksprünge möglich sind und keine großen Anforderungsänderungen erwartet werden, z.B. in eingebetteten Systemen oder sicherheitskritischen Anwendungen.

## Iterative Vorgehensmodelle
- Umgeht das Problem, dass alle Annahmen von Anfang an richtig sein müssen
- Z.B. Wasserfallmodell wird mehrfach durchlaufen

![spiralmodel_nach_boehm](images/spiralmodel_nach_boehm.png)

Was wollen wir in den einzelnen Iterationen Entwickeln?
=> Mit einem Basissystem starten und dieses Basissytem dann schrittweise erweitern. (inkrementelle Entwicklung)

## Prototypen

Entwicklung ablauffähiger Teile der Software
- Anforderungen klären
- Machbarkeit überprüfen
- Alternativen erforschen
- Erfahrungen mit nicht vertrauten Technologien sammeln

**vertikaler Prototyp**
- Ausschnitt quer durch alle Schichten der Anwendung
- Überprüfung der Machbarkeit
- Einzelne Funktionalitäten implementieren

![vertikalerPrototyp](images/vertikalerPrototyp.png)

**Horizontale Prototyp**
- Entwicklung einer einzelnen Schicht ohne Implementierung anderer Schichten
- Anforderungsstabilisierung
- Meistens UI

![horizontalerPrototyp](images/horizontalerPrototyp.png)

**Vorteile:**
- Risikominimierung
- Konkrete Vorstellung
- Basis für weitere Planung

**Nachteile:**
- Aufwand
- Gefahr durch falsche Ausschnittswahl

**Achtung:** Nie die Entwicklung mit einem Kern, der aus einem zusammengehackten Wegwerfprototyp besteht, starten. Der Wegwerfprototyp hatte das Ziel etwas zu lernen und dieser Zweck ist erfüllt.

## Agile Vorgehensmodelle
Die Entwicklung findet in kurzen iterativen Zyklen statt. Man fängt mit den wichtigsten Anforderungen an und nach jedem Zyklus wird die Anwendung erprobt und daraus gelernt.

Anforderungen:
- ständigen Austausch mit Product Owner (schnelle Feedbackschleife)
- Jederzeit Änderungen der Anforderungen begrüßen
- Dafür hohe Wartbarkeit der Software garantieren

Vorteile:
- Berücksichtigung von Anforderungsänderungen
- Feedback vom Kunden durch häufiges Ausliefern
- Fördert Kooperation im Team
- Sehr gut geeignet für Neuentwicklungen

Nachteile:
- Vertrag
- Beteiligung des Kunden wichtig
- Dokumentation weniger umfangreich

## Domain Driven Design
Ziel ist die Software möglichst nah an den Prozessen und Fachmodellen der Domäne anzulehnen

### Ubiquitous Language
### Bounded Context

## Domain Storytelling

## Scrum

# Woche 2


# Vokabeln:

- Domäne
- Kopplung
- Annotation
