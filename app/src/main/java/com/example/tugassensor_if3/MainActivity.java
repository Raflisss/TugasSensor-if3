package com.example.tugassensor_if3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentProfil fragmentProfil = new FragmentProfil();
    FragmentInfo fragmentInfo     = new FragmentInfo();
    FragmentList fragmentList     = new FragmentList();
    FragmentLokasi fragmentLokasi = new FragmentLokasi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.botNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,fragmentProfil).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,fragmentProfil).commit();
                        return true;

                    case R.id.makanan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,fragmentList).commit();
                        return true;

                    case R.id.lokasi:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,fragmentLokasi).commit();
                        return true;

                    case R.id.info:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentOrientation,fragmentInfo).commit();
                        return true;
                }
                return false;
            }
        });
    }
    //onBackPressed adalah fungsi yang akan dieksekusi saat menekan tombol kembali
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        //set pesan yang akan ditampilkan
        builder.setMessage("Anda Yakin Ingin Keluar ?");
        //set positive tombol jika menjawab ya
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //jika kalian menekan tombol ya, maka otomatis akan keluar dari activity saat ini
                finish();
            }
        });
        //set negative tombol jika menjawab tidak
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //jika menekan tombol tidak, maka kalian akan tetap berada di activity saat ini
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}