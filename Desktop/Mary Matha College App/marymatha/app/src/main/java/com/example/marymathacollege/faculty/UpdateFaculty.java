package com.example.marymathacollege.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marymathacollege.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDept, phyDept, matDept, cheDept, zoDept, cDept, eDept, jDept, ptDept, pDept, sDept, mlDept, hDept, btDept,prDept;
    private LinearLayout CsnoData, chenoData, matnoData, phynoData, zonoData, cnoData, enoData, jnoData, ptnoData, pnoData, snoData, mlnoData, hnoData, btnoData,prnoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14,list15;
    private DatabaseReference reference, dbref;
    private TeacherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);
        cheDept = findViewById(R.id.cheDept);
        chenoData = findViewById(R.id.chenoData);
        prDept = findViewById(R.id.prDept);
        prnoData = findViewById(R.id.prnoData);
        matDept = findViewById(R.id.matDept);
        matnoData = findViewById(R.id.matnoData);
        phyDept = findViewById(R.id.phyDept);
        phynoData = findViewById(R.id.phynoData);
        csDept = findViewById(R.id.csDept);
        CsnoData = findViewById(R.id.CsnoData);
        zoDept = findViewById(R.id.zoDept);
        zonoData = findViewById(R.id.zonoData);
        cDept = findViewById(R.id.cDept);
        cnoData = findViewById(R.id.cnoData);
        eDept = findViewById(R.id.eDept);
        enoData = findViewById(R.id.enoData);
        jDept = findViewById(R.id.jDept);
        jnoData = findViewById(R.id.jnoData);
        ptDept = findViewById(R.id.ptDept);
        ptnoData = findViewById(R.id.ptnoData);
        pDept = findViewById(R.id.peDept);
        pnoData = findViewById(R.id.penoData);
        sDept = findViewById(R.id.sDept);
        snoData = findViewById(R.id.snoData);
        mlDept = findViewById(R.id.mlDept);
        mlnoData = findViewById(R.id.mlnoData);
        hDept = findViewById(R.id.hDept);
        hnoData = findViewById(R.id.hnoData);
        btDept = findViewById(R.id.btDept);
        btnoData = findViewById(R.id.btnoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
        csDept();
        matDept();
        phyDept();
        cheDept();
        zoDept();
        cDept();
        eDept();
        jDept();
        ptDept();
        pDept();
        sDept();
        mlDept();
        hDept();
        btDept();
        prDept();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this, AddTeacher.class));
            }
        });
    }

    private void prDept() {
        dbref = reference.child("Principal");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    prnoData.setVisibility(View.VISIBLE);
                    prDept.setVisibility(View.GONE);
                } else {

                    prnoData.setVisibility(View.GONE);
                    prDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list15.add(data);
                    }
                    prDept.setHasFixedSize(true);
                    prDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list15, UpdateFaculty.this, "Principal");
                    prDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void btDept() {
        dbref = reference.child("Biological Techniques");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    btnoData.setVisibility(View.VISIBLE);
                    btDept.setVisibility(View.GONE);
                } else {

                    btnoData.setVisibility(View.GONE);
                    btDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list14.add(data);
                    }
                    btDept.setHasFixedSize(true);
                    btDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list14, UpdateFaculty.this, "Biological Techniques");
                    btDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void hDept() {
        dbref = reference.child("Hindi");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    hnoData.setVisibility(View.VISIBLE);
                    hDept.setVisibility(View.GONE);
                } else {

                    hnoData.setVisibility(View.GONE);
                   hDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list13.add(data);
                    }
                    hDept.setHasFixedSize(true);
                   hDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list13, UpdateFaculty.this, "Hindi");
                    hDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void mlDept() {
        dbref = reference.child("Malayalam");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    mlnoData.setVisibility(View.VISIBLE);
                    mlDept.setVisibility(View.GONE);
                } else {

                    mlnoData.setVisibility(View.GONE);
                    mlDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list12.add(data);
                    }
                    mlDept.setHasFixedSize(true);
                    mlDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list12, UpdateFaculty.this, "Malayalam");
                    mlDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void sDept() {
        dbref = reference.child("Statistics");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    snoData.setVisibility(View.VISIBLE);
                    sDept.setVisibility(View.GONE);
                } else {

                    snoData.setVisibility(View.GONE);
                    sDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list11.add(data);
                    }
                    sDept.setHasFixedSize(true);
                    sDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list11, UpdateFaculty.this, "Statistics");
                    sDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void pDept() {
        dbref = reference.child("Physical Education");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    pnoData.setVisibility(View.VISIBLE);
                    pDept.setVisibility(View.GONE);
                } else {

                    pnoData.setVisibility(View.GONE);
                    pDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list10.add(data);
                    }
                    pDept.setHasFixedSize(true);
                    pDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list10, UpdateFaculty.this, "Physical Education");
                    pDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ptDept() {
        dbref = reference.child("Political Science");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    ptnoData.setVisibility(View.VISIBLE);
                    jDept.setVisibility(View.GONE);
                } else {

                    ptnoData.setVisibility(View.GONE);
                   ptDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list9.add(data);
                    }
                    ptDept.setHasFixedSize(true);
                    ptDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list9, UpdateFaculty.this, "Political Science");
                   ptDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void jDept() {
        dbref = reference.child("Journalism");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    jnoData.setVisibility(View.VISIBLE);
                    jDept.setVisibility(View.GONE);
                } else {

                    jnoData.setVisibility(View.GONE);
                    jDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    jDept.setHasFixedSize(true);
                    jDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list8, UpdateFaculty.this, "Journalism");
                    jDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void eDept() {
        dbref = reference.child("English");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    enoData.setVisibility(View.VISIBLE);
                    eDept.setVisibility(View.GONE);
                } else {

                    enoData.setVisibility(View.GONE);
                    eDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    eDept.setHasFixedSize(true);
                    eDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list7, UpdateFaculty.this, "English");
                    eDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void cDept() {
        dbref = reference.child("Commerce");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    cnoData.setVisibility(View.VISIBLE);
                    cDept.setVisibility(View.GONE);
                } else {

                    cnoData.setVisibility(View.GONE);
                    cDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                   cDept.setHasFixedSize(true);
                    cDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list6, UpdateFaculty.this, "Commerce");
                    cDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void zoDept() {
        dbref = reference.child("Zoology");
        dbref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    zonoData.setVisibility(View.VISIBLE);
                    zoDept.setVisibility(View.GONE);
                } else {

                    zonoData.setVisibility(View.GONE);
                    zoDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    zoDept.setHasFixedSize(true);
                    zoDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5, UpdateFaculty.this, "Zoology");
                    zoDept.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void csDept() {
        dbref = reference.child("Computer Science");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    CsnoData.setVisibility(View.VISIBLE);
                    csDept.setVisibility(View.GONE);
                } else {

                    CsnoData.setVisibility(View.GONE);
                    csDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDept.setHasFixedSize(true);
                    csDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this, "Computer Science");
                    csDept.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void cheDept() {
        dbref = reference.child("Chemistry");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()) {
                    chenoData.setVisibility(View.VISIBLE);
                    cheDept.setVisibility(View.GONE);
                } else {

                    chenoData.setVisibility(View.GONE);
                    cheDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    cheDept.setHasFixedSize(true);
                    cheDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this, "Chemistry");
                    cheDept.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void phyDept() {
        dbref = reference.child("Physics");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()) {
                    phynoData.setVisibility(View.VISIBLE);
                    phyDept.setVisibility(View.GONE);
                } else {

                    phynoData.setVisibility(View.GONE);
                    phyDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    phyDept.setHasFixedSize(true);
                    phyDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this, "Physics");
                    phyDept.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void matDept() {
        dbref = reference.child("Mathematics");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()) {
                    matnoData.setVisibility(View.VISIBLE);
                    matDept.setVisibility(View.GONE);
                } else {

                    matnoData.setVisibility(View.GONE);
                    matDept.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    matDept.setHasFixedSize(true);
                    matDept.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this, "Mathematics");
                    matDept.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}


