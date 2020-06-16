C1: **Richtig** (, weil Ersetzbarkeitsprinzip, ) (bei einem add gibt es mit Student und deswegen passt es) ge nau (laut der Lösung ist die zeile aber falsch) egal jezz C2  ok ... ,
C2: uff is **falsch** , weil cast fehlt  ivan hier: methode ist zur compilierungszeit sichtbar, weil wir jetzt compiler spielen #dankemarcus
u right
C3: **falsch**(Andi: weil keine übergabeparameter (LEcturer & string) bzw. Assistant ist kein Professor )  

C3: Falsche übergabe im Konstruktor [y]right? #dankemarcus

C4: **richtig** weil keine Metodedefinition verhanden ist. uffffffffffffff #megafalle!!! u right  
doch schau mal bei Person
Assistnt erbt von Lecturer und dieser erbt von Person


C5: **Falsch** (Cast nicht möglich von Assistent 2 professor)

Cast von Class auf interface möglich? ja, aber das passiert hier nicht, warum? (Professor) new Assisten()
es geht um: (course) new VO (..)
bei mir steht VO oop = new VO ((Professor) new Assisten(), "OOP");
bei uns steht VO oop = ((course) new VO (..));
ja und?  cast möglich ?

C6: **Richtig** yes Ivan braucht noch ein bisschen

C7: *Richtig* Ivan braucht noch ein bisschen , das ist falsch weil clearParticipants() **FALSCH**


Das Objekt hat zugriff auf alle eigenen private methoden oder?
die Klasse Testklasse sieht diese Methode aber nicht, ok
C8:**Richtig**

C9: **Falsch** Interfaces können keine Instanzen haben, yes

C10: **Richtig**,yes yes


        Student

          ^
          |
          |
        Tutor

Sicherheitstesten : testen auf Sicherheitslücken, Verschlüsselung
regressionstesten : Nochmaliges testen nach Änderungen (um neu enstandende Fehler zu entdecken )
Leistungstesten : Viele Inputs, CPU & RAM Auslastung
Integrationstesten : Alle Module zusammen, Reihe an Einzeltest um gesamtheit zu testen
Stresstesten : viele Inputs, computetime

Typ hängt von der Sichtweise ab:

Aus sicht des Sysdev: Filter von Interpretation von Rohdaten
Aus sicht des Implementieres : Typ bezeichnet Speicherabbildung von Werten.
Aus sicht des Typen Controller: bezeichnet ein Typ eine Kompartibilität von Operanden zu Operanden
aus Sicht der OOP  : ist ein Typ Verhaltensspezifikation (prizise Problemstellung)

Klassen und Interfaces definieren Typen, jedoch gehören Interfaces nicht zur Klassenhierachie bei.
Eigenschaft der OOP durch die Vererbung kann der Code wieder verwendet werden bzw. ersetzt werden. Jedoch impliziert sie keine Subtypen bildung.


Objekterzeugung

Person karin = null; //referenz auf stack legen mit null setzen | 1.
2. new operator wird aufgerufen Speicherplatz wird alloziert im speicher (:= instanzieren)
3. Datenfelder werden initialisiert (Attribute auf null setzen)
4. Konstruktor wird aufgerufen (Attribute gesetzt )
5. new operator gibt die referenz auf das neu erzeute objekt
6. referenz wird in variable gespeichert
Person karin = new Persion();
