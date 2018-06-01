package co.edu.icesi.id.studio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView currentdate;
    ImageButton addevento;
    ListView eventos;
    ArrayList<Evento>eve;
    ArrayList<Evento>paraestedia;
    String fechaseleccionada;
    String [] datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentdate = findViewById(R.id.currentdate);
        addevento = findViewById(R.id.addevento);

        eve = new ArrayList<Evento>();
        paraestedia = new ArrayList<Evento>();

        Date today = new Date();
        Calendar nexYear = Calendar.getInstance();
        nexYear.add(Calendar.YEAR, 1);

        CalendarPickerView datePicker = findViewById(R.id.calendar);
        datePicker.init(today,nexYear.getTime()).withSelectedDate(today).inMode(CalendarPickerView.SelectionMode.RANGE).withSelectedDate(today);

        datePicker.getSelectedDates();

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                final String selectedDate = "" + calendar.get(calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(calendar.YEAR);
                //Toast.makeText(MainActivity.this,selectedDate,Toast.LENGTH_LONG).show();
                currentdate.setText(selectedDate);
                fechaseleccionada = selectedDate;

            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });

        addevento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearEvento.class);
                startActivity(intent);
            }
        });

        datos = getIntent().getStringArrayExtra("datos");

    }

    public void crearevento(){
        Evento nuevo = new Evento(fechaseleccionada);
        nuevo.setNombreevento(datos[0]);
        nuevo.setInicio(datos[1]);
        nuevo.setFin(datos[2]);
        eve.add(nuevo);
        Toast.makeText(MainActivity.this,nuevo.getNombreevento(),Toast.LENGTH_LONG).show();
    }
}

