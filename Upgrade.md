# Zusammenfassung aller Upgrades aus jeder Woche

# Woche 1

## Scrum

### Rollen

**Product Owner (PO)** stellen die Schnittstelle zu den Stakeholdern dar. Sind für das Einfordern der Anforderungen und die Priorisierung dieser verantwortlich.
Das **Development Team** setzt die Anforderungen vom PO um und ist verantwortlich für die Einhaltung der Qualitätsziele. Das Team schätzt den Aufwand der Implementierung.
Der **Scrum Master** ist nicht Teil des Entwicklungsteams und verhält sich als Coach für den Scrum Prozess. Kommt es zu Problemen in der Zusammenarbeit vermittelt dieser und beseitigt Störungen, die von Außen kommen.

### Product Backlog

Aufgaben und Ziele werden vom PO als Liste in dem Product Backlog nach Priorität sortiert.
Die DoD (Definition of Done) wird vorher definiert und beinhaltet die Regeln, nachdem eine Anforderung als erfüllt gilt.

### Sprint
Ein Sprint stellt eine Entwicklungs-Iteration dar. Am Ende dieses Sprints wurde das Produkt um etwas erweitert. 

1. Planungsmeeting
    Das Ziel ist es zu vermitteln was erreicht werden soll. Es wird auch der Arbeitsaufwand geschätzt.
  
2. Planungsmeeting
    Hier werden die Stories in handhabbare Aufgaben zerlegt. Wird von Entwicklerteam festgelegt. Zerstückelte Stories werden in das Sprint Backlog hinzugefügt.
    
### Daily Scrum

Jeden Morgen wird sich getroffen und es findet ein Informationsaustausch statt.
- Was wurde gemacht
- Was wird heute gemacht
- Probleme und Blockaden

Es wird nicht über die Lösung von Problemen geredet. Bei Fehleinschätzungen werden Aufgaben weiter unterteilt.

### Sprint Review

Entwicklerteam präsentiert die Sprint-Resulate den Stakeholtern. Sie erhalten Feedback, welches in das Product Backlog mit eingeht. Es werden die erreichten Ziele überprüft.

### Sprint Retrospektive

Überprüfung der Arbeitsweise während eines Sprints. Dies soll zu effizienterer Arbeitsweise führen. 

## Kanban

Durch den Work in Progress wird festgelegt wie viele Tickets gleichzeitig in einer Phase seinen dürfen.

## Scrum vs. Kanban

Scrum passiert in Iterationen, Kanban ist ein kontinuierlicher Prozess. 
Man erhält mit Kanban keinen natürliche Produktinkrementation. 
In Scrum hat man bestimmte Rollen wohingehend in Kanban diese nicht vorhanden sind. Man kann Kanban ohne großen Aufwand nebenbei einführen. 
Scrum muss hingehend ganz oder garnicht eingeführt werden. 

## Architekturdokumentation
1. Einführung und Ziele
2. Randbedingungen
3. Kontextabgrenzung
4. Lösungsstrategie
5. Bausteinsicht
6. Laufzeitsicht
7. Verteilungssicht
8. Querschnittliche Konzepte
9. Entscheidungen
10. Qualitätsanforderungen
11. Risiken
12. Glossar

# Woche 2

## Architekturmuster II

### Pipes and Filters

Pipes and Filters ist Teil der Data Flow Architektur, die das System als eine Reihe von Transformationen auf Datensätzen.

Filter verändern Daten, die sie durch den Input erhalten. Pipes sind Verbindungen die Zugang zu den transformierten Daten geben.

Die Anordnung der Filter können das Enresultat verändern (Mathematische Operationen).

**Pro:**

- Lose und Flexible Verknüpfungen zwischen Komponenten (Filtern)
- Filter operieren unabhänig von anderen Filtern
    - Kümmern sich nur um ihren Input und den Output von Daten
- Austauschbarkeit von Filtern
- Wiederverwendbarkeit
    - Innerhalb des Systems öfter verwenden mit unterschiedlichen Datensätzen
    - In anderen Systemen

**Contra:**

- Performance Einbußen, durch vorhandenem Verarbeitungs-Überschuss in jedem Filter
    - Jeder Filter erhält Input der geparst werden muss
    - Die eingegangenen Daten werden transformiert
    - Daten werden über den Output abgegeben
    - **Ist nur ein Nachteil, wenn diese Systeme als separete Programme eingesetzt werden (UNIX-Programme).**
        - Es können auch Datenstrukturen ausgegeben und direkt im Input verarbeitet werden.
- Kann nicht für interaktive Anwendung verwendet werden, da es zu langsam sein kann wenn viele Daten auf einmal verarbeitet werden müssen.

 

### Microkernel

Ist hilfreich, wenn Anwendungen im Nachhinein erweiterbar sein sollen. Dar Core-System hat Schnittstellen, die von Plugins genutzt werden können um weitere Funktionen hinzuzufügen.

Pro:

- Die Basisanwendung kann erweitert werden, ohne sie verändern zu müssen
- Open/Close Prinzip auf Architekturebene
