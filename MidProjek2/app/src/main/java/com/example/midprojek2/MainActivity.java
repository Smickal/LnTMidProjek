package com.example.midprojek2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.midprojek2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {
    ActivityMainBinding mb;

    String tipeKendaraan;
    String brand;
    String name;
    String licenseNumber = "[A-Z]+ [0-9]{1,4}+ [A-Z]{1,3}+";
    String licenseNumberName;
    Integer TopSpeed;
    Integer GasCapacity;
    Integer WheelMotor;
    Integer WheelMobil;
    Integer CarEntertainment;
    Integer JumlahHelm;
    String tipeMobil, tipeMotor;
    Integer PriceMotor;

    Boolean BBrand = false, Bname = false , BlicenseNumber = false , BTopSpeed = false, BGasCapacity = false
            , BWheelMotor = false, BWheelMobil = false, BCarEntertainment = false, BjumlahHelm = false, BtipeMobil = false , BtipeMotor = false;



    Boolean TipeCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mb = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mb.getRoot();
        super.onCreate(savedInstanceState);
        setContentView(view);

        mb.viewMotor.setVisibility(View.INVISIBLE);
        mb.etTypeMotor.setVisibility(View.INVISIBLE);
        mb.enterMotor.setVisibility(View.INVISIBLE);
        mb.etJumlahHelm.setVisibility(View.INVISIBLE);
        mb.etWheelMotor.setVisibility(View.INVISIBLE);
        mb.etWheelMobil.setVisibility(View.VISIBLE);
        mb.viewMobil.setVisibility(View.VISIBLE);
        mb.etTypeMobil.setVisibility(View.VISIBLE);
        mb.etEntertaimentSystemAmount.setVisibility(View.VISIBLE);
        mb.enterMobil.setVisibility(View.VISIBLE);
        mb.btnTestDrive.setVisibility(View.INVISIBLE);

        mb.HasilJadi.setVisibility(View.INVISIBLE);
        mb.viewBrand.setVisibility(View.INVISIBLE);
        mb.viewEnterystem.setVisibility(View.INVISIBLE);
        mb.viewGasCapacity.setVisibility(View.INVISIBLE);
        mb.viewJmlhhelm.setVisibility(View.INVISIBLE);
        mb.viewName.setVisibility(View.INVISIBLE);
        mb.viewTopSpeed.setVisibility(View.INVISIBLE);
        mb.viewType.setVisibility(View.INVISIBLE);
        mb.viewLicensePlate.setVisibility(View.INVISIBLE);
        mb.viewWheels.setVisibility(View.INVISIBLE);

        mb.viewPriceMotor.setVisibility(View.INVISIBLE);
        mb.editMotorPrice.setVisibility(View.INVISIBLE);
        mb.viewMotorPrice.setVisibility(View.INVISIBLE);
        mb.btnAccept.setVisibility(View.INVISIBLE);


        mb.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TipeCheck){
                    //Validasi brandName
                    brand = mb.etBrand.getEditableText().toString();
                    if(brand.length() < 5){
                        mb.etBrand.setText("Error");
                        BBrand = false;
                    }else {
                        BBrand = true;
                    }

                    //Validasi name
                    name = mb.etName.getEditableText().toString();
                    if(name.length() < 5){
                        mb.etName.setText("Error");
                        Bname = false;
                    }else{
                        Bname = true;
                    }

                    //validasi LicenseNUmber
                    licenseNumberName = mb.etLicense.getEditableText().toString();
                    if(!licenseNumberName.trim().matches(licenseNumber)){
                        mb.etLicense.setText("Error");
                        BlicenseNumber = false;
                    }else{
                        BlicenseNumber = true;
                    }

                    //Validasi TopSpeed
                    TopSpeed = Integer.parseInt(mb.etTopSpeed.getEditableText().toString());
                    if(TopSpeed < 100 || TopSpeed > 250){
                        mb.etTopSpeed.setText("Error");
                        BTopSpeed = false;
                    }else{
                        BTopSpeed = true;
                    }

                    //validasi GasCapacity
                    GasCapacity = Integer.parseInt(mb.etGasCapacity.getEditableText().toString());
                    if(GasCapacity < 30 || GasCapacity >60){
                        mb.etGasCapacity.setText("Error");
                        BGasCapacity = false;
                    }else{
                        BGasCapacity = true;
                    }

                    //validasi wheel dan entertainment dan
                    switch (tipeKendaraan){
                        case "Mobil":
                            //validasi wheel mobil
                            WheelMobil = Integer.parseInt(mb.etWheelMobil.getEditableText().toString());
                            if(WheelMobil < 4 || WheelMobil > 6 ){
                                mb.etWheelMobil.setText("Error");
                                BWheelMobil = false;
                            }else{
                                BWheelMobil = true;
                            }
                            //validasi enter mobil
                            CarEntertainment = Integer.parseInt(mb.etEntertaimentSystemAmount.getEditableText().toString());
                            if(CarEntertainment <1){
                                mb.etEntertaimentSystemAmount.setText("Error");
                                BCarEntertainment = false;
                            }else {
                                BCarEntertainment = true;
                            }

                            //validasi tipe mobil
                            tipeMobil = mb.etTypeMobil.getEditableText().toString();
                            if(tipeMobil.equals("SUV") || tipeMobil.equals("SuperCar") || tipeMobil.equals("Minivan")){
                                BtipeMobil = true;
                            }else{
                                BtipeMobil = false;
                                mb.etTypeMobil.setText("Error");
                            }

                            break;
                        case "Motor":
                            //Validasi wheel motor
                            WheelMotor = Integer.parseInt(mb.etWheelMotor.getEditableText().toString());
                            if(WheelMotor < 2 || WheelMotor > 3){
                                mb.etWheelMotor.setText("Error");
                                BWheelMotor = false;
                            }else{
                                BWheelMotor = true;
                            }

                            //validase helem motor
                            JumlahHelm = Integer.parseInt(mb.etJumlahHelm.getEditableText().toString());
                            if(JumlahHelm < 1){
                                mb.etJumlahHelm.setText("Error");
                                BjumlahHelm = false;
                            }else{
                                BjumlahHelm = true;
                            }

                            //validasi tipe motor
                            tipeMotor = mb.etTypeMotor.getEditableText().toString();
                            if(tipeMotor.equals("Automatic")  || tipeMotor.equals("Manual")){
                                BtipeMotor = true;
                            }else{
                                mb.etTypeMotor.setText("Error");
                                BtipeMotor = false;
                            }
                            break;
                    }


                    // Validasi semua hal
                    switch (tipeKendaraan){
                        case "Mobil":
                            if(BBrand && Bname && BlicenseNumber && BTopSpeed && BGasCapacity && BWheelMobil && BCarEntertainment && BtipeMobil){
                                mb.HasilJadi.setVisibility(View.VISIBLE);
                                mb.HasilJadi.setText("Car " + name);
                                mb.btnTestDrive.setVisibility(View.VISIBLE);

                                mb.btnTestDrive.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(tipeMobil == "Supercar"){
                                            Toast.makeText(MainActivity.this, "BOOOSTING!!!", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(MainActivity.this, "Turning on entertainment system....", Toast.LENGTH_SHORT).show();
                                        }


                                        mb.viewBrand.setVisibility(View.VISIBLE);
                                        mb.viewEnterystem.setVisibility(View.VISIBLE);
                                        mb.viewGasCapacity.setVisibility(View.VISIBLE);
                                        mb.viewName.setVisibility(View.VISIBLE);
                                        mb.viewTopSpeed.setVisibility(View.VISIBLE);
                                        mb.viewType.setVisibility(View.VISIBLE);
                                        mb.viewLicensePlate.setVisibility(View.VISIBLE);
                                        mb.viewWheels.setVisibility(View.VISIBLE);


                                        mb.viewBrand.setText("Brand : " + brand);
                                        mb.viewEnterystem.setText("Entertainment System Amount : "+ CarEntertainment);
                                        mb.viewGasCapacity.setText("Gas Capacity : "+ GasCapacity);
                                        mb.viewName.setText("Name : " + name);
                                        mb.viewTopSpeed.setText("Top Speed : "+ TopSpeed);
                                        mb.viewType.setText("Type : "+tipeMobil);
                                        mb.viewWheels.setText("Wheels : "+ WheelMobil);
                                        mb.viewLicensePlate.setText("License Plate : "+ licenseNumberName);

                                    }
                                });

                            }
                            break;
                        case "Motor":
                            if(BBrand && Bname && BlicenseNumber && BTopSpeed && BGasCapacity && BWheelMotor && BjumlahHelm && BtipeMotor){
                                mb.HasilJadi.setVisibility(View.VISIBLE);
                                mb.HasilJadi.setText("Motorcycle " + name);
                                mb.btnTestDrive.setVisibility(View.VISIBLE);

                                mb.btnTestDrive.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(MainActivity.this, name + " is standing!!!!", Toast.LENGTH_SHORT).show();


                                                mb.viewBrand.setVisibility(View.VISIBLE);
                                                mb.viewGasCapacity.setVisibility(View.VISIBLE);
                                                mb.viewJmlhhelm.setVisibility(View.VISIBLE);
                                                mb.viewName.setVisibility(View.VISIBLE);
                                                mb.viewTopSpeed.setVisibility(View.VISIBLE);
                                                mb.viewType.setVisibility(View.VISIBLE);
                                                mb.viewLicensePlate.setVisibility(View.VISIBLE);
                                                mb.viewWheels.setVisibility(View.VISIBLE);

                                                mb.viewBrand.setText("Brand : " + brand);
                                                mb.viewWheels.setText("Wheels : "+ WheelMotor);
                                                mb.viewGasCapacity.setText("Gas Capacity : "+ GasCapacity);
                                                mb.viewName.setText("Name : " + name);
                                                mb.viewTopSpeed.setText("Top Speed : "+ TopSpeed);
                                                mb.viewType.setText("Type : "+tipeMotor);
                                                mb.viewLicensePlate.setText("License Plate : " + licenseNumberName);
                                                mb.viewJmlhhelm.setText("Jumlah helm : " + JumlahHelm);

                                                mb.viewPriceMotor.setVisibility(View.VISIBLE);
                                                mb.editMotorPrice.setVisibility(View.VISIBLE);
                                                mb.viewMotorPrice.setVisibility(View.VISIBLE);
                                                mb.btnAccept.setVisibility(View.VISIBLE);

                                                mb.btnAccept.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        PriceMotor = Integer.parseInt(mb.editMotorPrice.getEditableText().toString());
                                                        mb.viewMotorPrice.setText("Price : " + PriceMotor);
                                                    }
                                                });
                                    }
                                });
                            }
                            break;
                    }
                }else{
                    Toast.makeText(MainActivity.this, "YOU NEED TO INSEERT THE TYPE", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mb.etSaveTipekendaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipeKendaraan = mb.edTipeKendaraan.getEditableText().toString();
                switch (tipeKendaraan){
                    case "Mobil":
                        Toast.makeText(MainActivity.this, "Mobil Choosed", Toast.LENGTH_SHORT).show();
                        mb.viewMotor.setVisibility(View.INVISIBLE);
                        mb.etTypeMotor.setVisibility(View.INVISIBLE);
                        mb.enterMotor.setVisibility(View.INVISIBLE);
                        mb.etJumlahHelm.setVisibility(View.INVISIBLE);
                        mb.etWheelMotor.setVisibility(View.INVISIBLE);
                        mb.etWheelMobil.setVisibility(View.VISIBLE);
                        mb.viewMobil.setVisibility(View.VISIBLE);
                        mb.etTypeMobil.setVisibility(View.VISIBLE);
                        mb.etEntertaimentSystemAmount.setVisibility(View.VISIBLE);
                        mb.enterMobil.setVisibility(View.VISIBLE);
                        TipeCheck = true;
                        break;

                    case "Motor":
                        Toast.makeText(MainActivity.this, "Motor Choosed", Toast.LENGTH_SHORT).show();
                        mb.viewMotor.setVisibility(View.VISIBLE);
                        mb.etTypeMotor.setVisibility(View.VISIBLE);
                        mb.enterMotor.setVisibility(View.VISIBLE);
                        mb.etJumlahHelm.setVisibility(View.VISIBLE);
                        mb.etWheelMotor.setVisibility(View.VISIBLE);
                        mb.etWheelMobil.setVisibility(View.INVISIBLE);
                        mb.viewMobil.setVisibility(View.INVISIBLE);
                        mb.etTypeMobil.setVisibility(View.INVISIBLE);
                        mb.etEntertaimentSystemAmount.setVisibility(View.INVISIBLE);
                        mb.enterMobil.setVisibility(View.INVISIBLE);
                        TipeCheck = true;
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "WRONG INPUT!!!!!", Toast.LENGTH_SHORT).show();
                        TipeCheck = false;
                        break;
                }
            }
        });


    }




}