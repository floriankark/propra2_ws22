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

## Domain Driven Design DDD
Ziel ist die Software möglichst nah an den Prozessen und Fachmodellen der Domäne anzulehnen

### Domain
Ein Bereich von Wissen, Einfluss oder Aktivität. Das Fachgebiet, auf das der Benutzer ein Programm anwendet, ist die *Domain* (Dt.: Domäne) der Software.

### Model
Ein *Model* (Dt.: Modell) ist ein System von Abstraktionen, das ausgewählte Aspekte einer Domäne beschreibt und zur Lösung von Problemen im Zusammenhang mit dieser Domäne verwendet werden kann.

### Ubiquitous Language
Die Ubiquitous Language (Dt.: allgegenwärtige Sprache) ist eine Sprache, die um das Domänenmodell herum gruppiert ist und von allen Teammitgliedern in einem Bounded Context verwendet wird, um alle Aktivitäten des Teams mit der Software zu verbinden.
Typische Hindernisse:
- Fehlende Fachbegriffe
- Unterschiedliche Bedeutungen
- Übersetzungsfehler

### Context
Der Bereich, in dem ein Wort oder eine Aussage auftaucht und der dabei ihre Bedeutung bestimmt. *Aussagen über ein Modell können nur in einem Context (Dt.: Kontext) verstanden werden.*

### Bounded Context
Der Bounded Context (Dt.: begrenzter Kontext) ist eine Beschreibung einer Grenze (typischerweise ein Subsystem oder die Arbeit eines bestimmten Teams), innerhalb derer ein bestimmtes Modell definiert und anwendbar ist.

## Domain Storytelling
Um Wissen über die Domäne zu sammeln, gibt es im DDD sogenannte Knowledge Crunching Techniken, wie u.a. Domain-Storytelling. Das ist ein Workshop-Format, bei dem einzelne Szenarien aus der Domäne *gemeinsam durchgesprochen* und *visualisiert* werden.

# Woche 2

## Software-Architektur

## Entwicklung planen

## Muster

### Das Schichtarchitektur-Muster
In einer strikten Architektur haben wir eine losere Kopplung, da eine Schicht ausschließlich eine andere Schicht verwendet. Der Preis dafür ist aber, dass wir evtl. viele Methoden liefern müssen, die Aufrufe in tiefere Schichten weiterleiten. Das kann die Performance einer Anwendung negativ beeinflussen.

Vorteile
- Einfach und leicht zu verstehen
- Klare Abhängigkeiten
- Reduktion der Kopplung von Komponenten (SRP, LCHC Low Coupling, High Cohesion)
- einheitlicher Abstraktionsgrad
- Austausch von ganzen Schichten

Nachteile
- Bei Änderungen in der untersten Schicht müssen alle darüberliegenden Schichten geändert werden

![schichtarchitektur](images/schichtarchitektur.png)

Bei den Aggregate kann es eine Klasse geben, die mehrere vollkommen unterschiedliche Aufgaben hat. Einerseits die Geschäftsaufgaben, andererseits z.B. sich aus der Datenbank zu laden und zu speichern. Das ist ziemlich deutlich eine Verletzung des Single Responsibility Prinzips.

Lösung: Das Repository-Pattern
- Verschiebung der Verantwortung der obigen Klasse in eine dedizierte Klasse (Repository). Das Repository stellt Lade- und Speicheroperationen für fachliche Objekte bereit, die Datenbank wird dabei abstrahiert. Für den aufrufenden Code wirkt ein Repository wie eine Sammlung von Fachobjekten und befindet sich nun in der Persistenzschicht.

- Mit Dependency Inversion erstellen wir zueltzt noch ein Repository-Interface in der Geschäftslogik und implementieren das Interface in der Persistenzschicht.

=> Dadurch erhalten wir die Onion Architektur

## Die Onion-Architektur

![onionschicht1](images/onionschicht1.png)
![onionschicht2](images/onionschicht2.png)

- Controller extrahieren Daten aus dem Request und bauen ModelAndView zusammen
- Application Services koordinieren einen Geschäftsvorfall (Daten laden, Geschäftslogik aufrufen, Daten speichern)
- Das Domänen Modell setzt die Geschäftsregeln um
- Repositories
    - Haben eine fachliche Schnittstelle in der Geschäftslogik
    - Werden in der Infrastrukturschicht implementiert
