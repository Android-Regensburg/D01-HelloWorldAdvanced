package de.ur.mi.android.helloWorldAdvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Die Anwendung zeigt dem Nutzer die Zwölf Prinzipien der Agilen Softwareentwicklung (Agile
 * Manifesto, https://agilemanifesto.org/) an. Ein Button erlaubt das schrittweise durchschalten
 * der angezeigten Prinzipien.
 *
 * Diese Activity repräsentiert den einzigen Bildschirm der Anwendung. Die Activity
 * überwacht die Klicks auf den Button und sorgt dafür, dass mit jedem Klick ein weiteres
 * der zwölf Agile-Prinzipien im TextView der Activity angezeigt wird. Nach dem letzten
 * Text, zeigt die Anwendung erneut den ersten Text an.
 *
 * Die Activity implementiert das OnClickListener-Interface. Dadurch können wir die Activity selbst
 * als Listener für Events verwenden, die beim Klick auf den Button ausgelöst werden.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Repräsentiert den Bereich des UIs, in dem das aktuelle Agile-Prinzip
    private TextView contentHolder;
    // Array mit den einzelnen Prinzipien (als Text)
    private String[] agilePrinciples;
    // Zählervariable als Verweis auf das aktuell angezeigte Prinzip
    private int currentTextIndex = 0;

    /**
     * Lifecycle-Methode der Activity: Wird automatisch aufgerufen, wenn die Anwendung gestartet und diese
     * Activity erstellt wird und dient und als Einstiegspunkt in die Entwicklung der Anwendung.
     * Hier "beginnt" der Teil des Programmcodes, den wir gestalten.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Alle Activities erben von einer Basisklasse Activity, der Aufruf der geerbten Methode
         * sorgt für einen Reibungslosen Ablauf und ist zwingend notwendig.
         */
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        // Bestimmt, welche Layout-Datei zur Darstellung dieser Activity verwendet werden soll
        setContentView(R.layout.activity_main);
        // Erstellt eine Referenz auf den TextView (Layout) in unserem Code (contentHolder)
        contentHolder = findViewById(R.id.content);
        // Lädt das in der XML-Datei definierte String-Array in eine entsprechende Java-Variable
        agilePrinciples = getResources().getStringArray(R.array.agile_principles);
        // Verändert den im TextView angezeigten Inhalt. Durch die Veränderung des Java-Objekts
        // ändern wir direkt den entsprechenden Bereich des User Interface!
        contentHolder.setText(agilePrinciples[currentTextIndex]);
        // Referenziert den Button (findViewById(R.id.button)) und registriert
        // diese Activity als Listener auf dem Button (setOnClickListener(this)).
        // Ab jetzt werden wir über die implementierte Interfacemethode (onClick) über jeden Klick
        // auf den Button informiert.
        findViewById(R.id.button).setOnClickListener(this);
    }

    /**
     * Interface-Methode (View.OnClickListener) die bei jedem Klick auf View-Elemente ausgelöst
     * wird, auf denen wir diese Acitivity als "OnCLickListener" registriert haben.
     */
    @Override
    public void onClick(View v) {
        showNextValue();
    }

    /**
     * Ändert den im TextView (contentHolder) angezeigten Text und verwendet dazu den jeweils
     * nächsten Eintrag im entsprechenden Array. Nach dem letzten Eintrag wird wieder der erste
     * Text im Array angezeigt.
     */
    private void showNextValue() {
        currentTextIndex++;
        if(currentTextIndex == agilePrinciples.length) {
            currentTextIndex = 0;
        }
        contentHolder.setText(agilePrinciples[currentTextIndex]);
    }
}
