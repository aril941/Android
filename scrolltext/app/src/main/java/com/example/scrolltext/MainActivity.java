package com.example.scrolltext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //initialisasi
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert
        tvText=(TextView)findViewById(R.id.textView4);
        tvText.setText("E-sport Universitas Dian Nuswantoro (Udinus) Semarang menjadi jawara " +
                "di pertandingan PlayerUnknown's Battlegrounds (PUBG) tingkat nasional. " +
                "Predikat jawara tersebut didapatkan setelah mengalahkan berbagai tim di ajang bergengsi " +
                "Tel-U Esports Championship."+
                "\n\n"+
                "Ajang Tel-U Esports Championship mempertandingkan berbagai cabang gim diantaranya PUBG Mobile dan Defense of the Ancients (DotA) 2. Pertandingan PUBG mampu diraih Udinus dengan timnya bernama Universitas Dian Nuswantoro A. Tim tersebut beranggotakan  lima mahasiswa dari berbagai program studi.);"+
                "\n\n"+
                "Mereka yakni Krisna Bhakti Nurmansyah dari S-1 Teknik Informatika, Maulana Kanigara  dari S-1 Teknik informatika , Muhamad Yusuf Al Hasby Prodi D-4 Film dan Televisi,   Oky noor diyansyah  Prodi S-1 Kesehatan Masyarakat dan Sang Jeddah Haji Adam  dari Prodi S-1 Manajemen. Setiap anggota memiliki perannya masing-masing dalam pertandingan PUBG Mobile mulai dari sniper hingga menjadi rusher."+
                "\n\n"+
                "Dalam wawancaranya, Satu diantara tim e-Sport Udinus divisi PUBG Mobile, Krisna Bhakti Nurmansyah mengatakan pertandingan yang mereka ikuti merupakan pertandingan yang kesekian kalinya bagi tim mereka. Sebelumnya mereka juga mampu meraih juara 4 di ajang PUBG Mobile Campus Championship Indonesia 2019. Ungkap Krisna, latihan rutin juga mereka lakukan."+
                "\n\n"+
                "'Kami sering melakukan latihan rutin untuk meningkatkan komunikasi dan kerjasama antar anggota.Karena gim PUBG membutuhkan kerjasama tim yang baik,'” ungkapnya. Ia pun tak memandang remeh setiap lawan yang mereka hadapi,strategi-strategi dalam menghadapi lawan juga mereka susun dengan rapi. Menurut Krisna, bergabung di E-Sport Udinus mampu mendapatkan ilmu dan strategi yang baik dalam menghadapi musuh. Tak hanya itu saja,  pengalaman dari setiap lomba yang mereka ikuti menjadi acuan untuk menjadi lebih baik."+
                "\n\n"+
                "Pertandingan yang mempertemukan tim-tim hebat satu diantaranya Udinus dilaksanakan mulai 7 Juli hingga 30 Agustus lalu. Tim E-Sport Udinus di ajang PUBG Mobile mampu meraih poin sebesar 215 poin. Poin itu  tak terkejar oleh lawan-lawannya dan memiliki selisih sekitar 16 poin dari peringkat dua. Ajang Tel-U Esports Championship di divisi PUBG Mobile diikut 38 tim  dari berbagai perguruan tinggi di Indonesia dan hanya 16 tim yang mampu melaju hingga grand final."+
                "\n\n"+
                "Sementara itu, Pembina Esport Udinus sekaligus Wakil Rektor IV Bidang Riset dan Kerja sama Udinus , Dr Pulung Nurtantio Andono, M.Kom mengaku bangga dengan capaian dari para mahasiswanya di tingkat nasional. Ia berharap capaian tersebut dapat menjadi pemicu untuk mahasiswa lainnya agar terus berprestasi.“Saya ucapkan selamat atas juara yang diraih ini sebuah kebanggaan bagi Udinus. Membuktikan juga bahwa E-Sport Udinus mampu berjaya di tingkat nasional,” tutupnya.");
    }
}