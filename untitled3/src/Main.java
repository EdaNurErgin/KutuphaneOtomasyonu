
//HAZİRLAYAN : EDA NUR ERGİN-1220505032
public class Main {
    public static void main(String[] args) {
        KutuphaneYonetimSistemi kys = new KutuphaneYonetimSistemi();
        //KutuphaneYonetimSistemi sinifi icerisindekileri
        //main'de kullanabilmek icin KutuphaneYonetimSistemi turunde bir  kys degiskeni tanimladik.
        //Artık bu sinifin iceriklerini kullanmak icin kys degiskenini kullanacagiz.


        //Burada kutuphanemize KutuphaneYonetimSistemi sinifinda bulunan kitapEkle methodunu cagirarak kitap ekledik.
        kys.kitapEkle("Yagmur Altında", "Yu Hua");
        kys.kitapEkle("Yasamak", "Yu Hua");
        kys.kitapEkle("Kardesimin Hikayesi", "Livaneli");
        kys.kitapEkle("Ruth", "Lou Andreas-Salome");


        //Burada kutuphanemize KutuphaneYonetimSistemi sinifinda bulunan uyeEkle methodunu cagirarak uye ekledik.
        kys.uyeEkle("Elif", 101);
        kys.uyeEkle("Cemile", 102);
        kys.uyeEkle("Eda", 104);
        kys.uyeEkle("Esma", 106);

        //odunc alinan kitap verilmeden uye kutuphaneden cikarilamaz
        kys.oduncVer(KutuphaneYonetimSistemi.uyeler.get(0), KutuphaneYonetimSistemi.kitaplar.get(0));
        kys.uyeCikar(KutuphaneYonetimSistemi.uyeler.get(0));

        //Burada kutuphanemize KutuphaneYonetimSistemi sinifinda bulunan gorevliEkle methodunu cagirarak gorevli ekledik.
        kys.gorevliEkle("Nisa", 201);
        kys.gorevliEkle("Zeynep", 208);


        //Burada kutuphanemize KutuphaneYonetimSistemi sinifinda bulunan oduncVer methodunu cagirarak kitaplari uyelere odunc verdik
        //DİKKAT SAKIN !! uyeler listesini kys ile cagirma cunku uyeler static tanimli bir listedir.Static tanimli bir liste ,tanimlanmis oldugu sinifin adiyla dogrudan  cagrilir .
        kys.oduncVer(KutuphaneYonetimSistemi.uyeler.get(0), KutuphaneYonetimSistemi.kitaplar.get(0));//0.indexteki uye , 0.indexteki kitabi odunc aldi
        kys.oduncVer(KutuphaneYonetimSistemi.uyeler.get(1), KutuphaneYonetimSistemi.kitaplar.get(1));//1.indexteki uye , 1.indexteki kitabi odunc aldi
        kys.oduncVer(KutuphaneYonetimSistemi.uyeler.get(2), KutuphaneYonetimSistemi.kitaplar.get(2));//2.indexteki uye , 2.indexteki kitabi odunc aldi

        //Burada KutuphaneYonetimSistemi sinifinda bulunan oduncDurumuGoster methodu sayesinde odunc verilen kitaplari gorecegiz.
        kys.oduncDurumuGoster();

        //Burada uyeler listesindeki 0.index uyesi odunc aldigi kitabi KutuphaneYonetimSistemi sinifindaki kitapIade methodunu kullanarak kitabini iade ediyor.
        kys.kitapIade(KutuphaneYonetimSistemi.uyeler.get(0));

        //Burada KutuphaneYonetimSistemi sinifinda bulunan oduncDurumuGoster methodu sayesinde odunc verilen kitaplari gorecegiz.
        kys.oduncDurumuGoster();

        //Burada KutuphaneYonetimSistemi sinifinda bulunan kitapCikar methodu kullanilarak kitaplar listesinden kitap cıkartiyoruz.
        kys.kitapCikar("Yagmur Altında");

        //Burada KutuphaneYonetimSistemi sinifinda bulunan mevcutKitaplariGoruntule methodu ile kutuphanedeki mevcut kitaplari goruntuleyecegiz.
        kys.mevcutKitaplariGoruntule();

        //Burada KutuphaneYonetimSistemi sinifinda bulunan uyeler listesine ulasarak 1.indexteki uye cikarilmistir.
        kys.uyeCikar(KutuphaneYonetimSistemi.uyeler.get(1));
        //Burada KutuphaneYonetimSistemi sinifinda bulunan mevcutUyeleriGoruntule methodu ile kutuphanede halen uye halde bulunan kullanicilari goruntuleyecegiz.
        kys.mevcutUyeleriGoruntule();


        ////Burada KutuphaneYonetimSistemi sinifinda bulunan gorevliEkle methodu ile gorevli ekliyoruz.
        kys.gorevliEkle("Melek", 202);
        //Burada KutuphaneYonetimSistemi sinifinda bulunan gorevliler listesine ulasarak 0.indexteki gorevli siliniyor.
        kys.gorevliCikarB(KutuphaneYonetimSistemi.gorevliler.get(0));
        //Burada KutuphaneYonetimSistemi sinifinda bulunan mevcutGorevlileriGoruntule methodu ile kutuphanede halen calisan gorevliler listenelenir
        kys.mevcutGorevlileriGoruntule();



    }
}