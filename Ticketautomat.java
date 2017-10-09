/**
 * Die Klasse Ticketautomat modelliert einfache Ticketautomaten,
 * die Tickets zu einem Einheitspreis herausgeben.
 * Der Preis f�r die Tickets eines Automaten kann �ber den Konstruktor
 * festgelegt werden.
 * Ticketautomaten dieser Klasse pr�fen, ob sinnvolle Geldbetr�ge
 * eingeworfen werden, und drucken ein Ticket nur dann, wenn
 * ausreichend Geld eingeworfen wurde.
 *
 * @author David J. Barnes und Michael K�lling
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
    // �2.54: Zuweisung ersparnis =  Preis * Rabatt
    private int rabatt = 30 ; // Rabatt in Prozent
    private int ersparnis;  // Ersparniss in Cent

    private int rabattPreis; 
    // �2.55: Zuweisung ist gesamtsumme durch anzahl
    private int anzahl = 0 ;
    private int durchschnitt;
    // �2.56: // preis mit budget vergleichen - zu teuer?
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
        ersparnis = preis * rabatt / 100; // �2.54: Zuweisung ersparnis =  Preis * Rabatt   
    }

    /**
     * Liefere den Preis eines Tickets dieses Automaten (in Cent).
     */
    public int gibPreis()
    {
        return preis;
    }

    /**
     * Liefere die H�he des Betrags, der f�r das n�chste Ticket bereits
     * eingeworfen wurde.
     */
    public int gibBisherGezahltenBetrag()
    {
        return bisherGezahlt;
    }

    /**
     * Nimm den angegebenen Betrag (in Cent) als Anzahlung f�r das 
     * n�chste Ticket. Pr�fe, ob der Betrag sinnvoll ist. Umgeschirebe
     */
    public void geldEinwerfen(int betrag)
    {
        if (betrag <= 0) {
            System.out.println("Bitte nur positive Betr�ge verwenden: "
                + betrag);
            // bisherGezahlt = bisherGezahlt + betrag;
        }
        else {
            // System.out.println("Bitte nur positive Betr�ge verwenden: " + betrag);
            bisherGezahlt = bisherGezahlt + betrag;
        }
    }

    /**
     * Drucke ein Ticket, wenn gen�gend Geld eingeworfen wurde, und 
     * ziehe den Ticketpreis vom bisher gezahlten Betrag ab. Gib eine 
     * Fehlermeldung aus, falls noch Geld f�r ein Ticket fehlt.
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

            // Die Gesamtsumme um den Ticketpreis erh�hen.
            gesamtsumme = gesamtsumme + preis;
            // Den Preis von der bisherigen Bezahlung abziehen.
            bisherGezahlt = bisherGezahlt - preis;// �2.52: Nein: Es wird sichergestellt, dass bisherGezahlt positiv ist und gr��er als preis 
            // Anzahl der tickets
            anzahl = anzahl +1;
        }
        else { // �bung 2.51: L�sst man den else Teil weg, erh�lt der Anw. keine Meldung, aber der Programmablauf �ndert sich ansonsten nicht.
            System.out.println("Sie m�ssen noch mindestens " +
                (preis - bisherGezahlt) +
                " Cent einwerfen.");
        }
    }

    /**
     * Gib das Wechselgeld bzw. den bisher gezahlten Betrag zur�ck.
     * Setze den bisher gezahlten Betrag zur�ck auf 0.
     */
    public int wechselgeldAuszahlen()
    {
        int wechselgeld;
        wechselgeld = bisherGezahlt;//bisherGezahlt wird vor dem R�cksetzen  in Wechselgeld gespoeichert
        bisherGezahlt = 0;
        return wechselgeld;
    }

    /**
     * Zuweisungstest �bung 2.55
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
     *  �2.56: // preis mit budget vergleichen - zu teuer? Mit Anpassungen f�r 2.57
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
