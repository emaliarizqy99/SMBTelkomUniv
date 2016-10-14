package id.sch.smktelkom_mlg.tugas01.xiirpl4012.smbtelkomuniv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvHasil;
    Button bOk;
    EditText etNM, etTH, etTP;
    RadioGroup rg;
    Spinner spin;
    CheckBox cbmana, cbti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bOk = (Button) findViewById(R.id.button);
        etNM = (EditText) findViewById(R.id.editTextNama);
        etTH = (EditText) findViewById(R.id.editTextTahun);
        etTP = (EditText) findViewById(R.id.editTextTempat);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        spin = (Spinner) findViewById(R.id.spinner);
        cbmana = (CheckBox) findViewById(R.id.checkBoxMana);
        cbti = (CheckBox) findViewById(R.id.checkBoxTi);


        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
    }
        });
    }

    private void doClick() {
        if (isValid()) {
        }

    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNM.getText().toString();
        if (nama.isEmpty()) {
            etNM.setError("Nama Belum Diisi");
            valid = false;
        }

        String tahun = etTH.getText().toString();
        if (nama.isEmpty()) {
            etTH.setError("Tahun Lahir Belum Diisi");
            valid = false;
        }
        String tempat = etTP.getText().toString();
        if (nama.isEmpty()) {
            etTP.setError("Tempat Lahir Belum Diisi");
            valid = false;
        }

        String jk = null;
        if (rg.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            jk = rb.getText().toString();
        } else if (jk == null) {
            jk = "Anda Belum Memilih Jenis Kelamin";
        }

        String ps = spin.getSelectedItem().toString();

        String jurusan = "";
        int Startlen = jurusan.length();
        if (cbmana.isChecked()) jurusan += "| " + cbmana.getText() + " | ";
        if (cbti.isChecked()) jurusan += "| " + cbti.getText() + " |";
        if (jurusan.length() == Startlen) jurusan += " Anda Belum Memilih Jurusan";


        tvHasil.setText(
                "Nama                        : " + nama + "\n\n" +
                        "Tahun Lahir             : " + tahun + "\n\n" +
                        "Tempat Lahir           : " + tempat + "\n\n" +
                        "Jenis Kelamin          : " + jk + "\n\n" +
                        "Program Studi          : " + ps + "\n\n" +
                        "Jurusan                    : " + jurusan + "\n\n");


        return true;
    }


}
