/**
 * Die Klasse Ticketautomat modelliert einfache Ticketautomaten,
 * die Tickets zu einem Einheitspreis herausgeben.
 * Der Preis für die Tickets eines Automaten kann über den Konstruktor
 * festgelegt werden.
 * Ticketautomaten dieser Klasse prüfen, ob sinnvolle Geldbeträge
 * eingeworfen werden, und drucken ein Ticket nur dann, wenn
 * ausreichend Geld eingeworfen wurde.
 *
 * @author David J. Barnes und Michael Kölling
 * @version 31.07.2011
 */
public class Ticketautomat
{
    // Der Preis eines Tickets dieses Automaten.
    private int preis;
    // Der Betrag, der bisher vom Automatenbenutzer eingeworfen wurde.
    private int bisherGezahlt;
    // Die Geldsumme, die bisher von diesem Automaten eingenommen wurde.
    private int gesamtsumme;
    // Ü2.54: Zuweisung ersparnis =  Preis * Rabatt
    private int rabatt = 30 ; // Rabatt in Prozent
    private int ersparnis;  // Ersparniss in Cent

    private int rabattPreis; 
    // Ü2.55: Zuweisung ist gesamtsumme durch anzahl
    private int anzahl = 0 ;
    private int durchschnitt;
    // Ü2.56: // preis mit budget vergleichen - zu teuer?
    private int budget;

    /**
     * Erzeuge einen Automaten, der Tickets zum angegebenen Preis
     * (in Cent) ausgibt.
     */
    public Ticketautomat(int ticketpreis)
    {
        preis = ticketpreis;
        bisherGezahlt = 0;
        gesamtsumme = 0;
        ersparnis = preis * rabatt / 100; // Ü2.54: Zuweisung ersparnis =  Preis * Rabatt   
    }

    /**
     * Liefere den Preis eines Tickets dieses Automaten (in Cent).
     */
    public int gibPreis()
    {
        return preis;
    }

    /**
     * Liefere die Höhe des Betrags, der für das nächste Ticket bereits
     * eingeworfen wurde.
     */
    public int gibBisherGezahltenBetrag()
    {
        return bisherGezahlt;
    }

    /**
     * Nimm den angegebenen Betrag (in Cent) als Anzahlung für das 
     * nächste Ticket. Prüfe, ob der Betrag sinnvoll ist. Umgeschirebe
     */
    public void geldEinwerfen(int betrag)
    {
        if (betrag <= 0) {
            System.out.println("Bitte nur positive Beträge verwenden: "
                + betrag);
            // bisherGezahlt = bisherGezahlt + betrag;
        }
        else {
            // System.out.println("Bitte nur positive Beträge verwenden: " + betrag);
            bisherGezahlt = bisherGezahlt + betrag;
        }
    }

    /**
     * Drucke ein Ticket, wenn genügend Geld eingeworfen wurde, und 
     * ziehe den Ticketpreis vom bisher gezahlten Betrag ab. Gib eine 
     * Fehlermeldung aus, falls noch Geld für ein Ticket fehlt.
     */
    public void ticketDrucken()
    {
        if (bisherGezahlt >= preis) {
            // Den Ausdruck eines Tickets simulieren.
            System.out.println("##################");
            System.out.println("# Die BlueJ-Linie");
            System.out.println("# Ticket");
            System.out.println("# " + preis + " Cent.");
            System.out.println("##################");
            System.out.println();

            // Die Gesamtsumme um den Ticketpreis erhöhen.
            gesamtsumme = gesamtsumme + preis;
            // Den Preis von der bisherigen Bezahlung abziehen.
            bisherGezahlt = bisherGezahlt - preis;// Ü2.52: Nein: Es wird sichergestellt, dass bisherGezahlt positiv ist und größer als preis 
            // Anzahl der tickets
            anzahl = anzahl +1;
        }
        else { // Übung 2.51: Lässt man den else Teil weg, erhält der Anw. keine Meldung, aber der Programmablauf ändert sich ansonsten nicht.
            System.out.println("Sie müssen noch mindestens " +
                (preis - bisherGezahlt) +
                " Cent einwerfen.");
        }
    }

    /**
     * Gib das Wechselgeld bzw. den bisher gezahlten Betrag zurück.
     * Setze den bisher gezahlten Betrag zurück auf 0.
     */
    public int wechselgeldAuszahlen()
    {
        int wechselgeld;
        wechselgeld = bisherGezahlt;//bisherGezahlt wird vor dem Rücksetzen  in Wechselgeld gespoeichert
        bisherGezahlt = 0;
        return wechselgeld;
    }

    /**
     * Zuweisungstest Übung 2.55
     * 
     */
    public void gibDurchschnitt(){
        if (anzahl > 0){

            System.out.println("gesamt / anzahl ist: " + gesamtsumme / anzahl);
        }
        else{
            System.out.println("Noch kein Ticket gedruckt! " );
        }
    }

    /**
     *  Ü2.56: // preis mit budget vergleichen - zu teuer? Mit Anpassungen für 2.57
     */
    public void gibPreiswert(int aktuellesBudget){
        if (aktuellesBudget < preis) {
            System.out.println("Ich hab nur "+ aktuellesBudget +" Cent. " + preis + " Cent? Das ist zu teuer! " );
        }
        else{
            System.out.println("Na gut! " + preis + " Cent, das ist okay! " );
        }
    }

}
