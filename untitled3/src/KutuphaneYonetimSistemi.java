import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Bu sinifi; uye ekleme-cikartma, gorevli ekleme-cıkartma , kitap ekleme-cıkartma , kitap odunc verme-alma
//kutuphanedeki mevcut kitapları-gorevlileri-uyeleri gormek islemlerini duzenlemek icin actim

class KutuphaneYonetimSistemi {

    //static tanımladık cunku kitap ismi aldıgımızda bu ismin bellekte tutulmasini istiyoruz Silinmesini istemiyoruz.
    static List<Kitap> kitaplar = new ArrayList<>();//Kitap sinifi turunda kitap isimleri eklemek icin kitaplar adli listeyi tanimladik.

    //static tanimladik cunku kutuphaneye uye ekledigimizde bu uyenin bellekte tutulmasini istiyoruz
    static List<Uye> uyeler = new ArrayList<>();//Uye sinifi turunda uye isimleri eklemek icin uyeler adli listeyi tanimladik.

    //static tanimladik cunku kutuphane gorevlilerini ekledigimizde bu yeni gorevlinin bellekte tutulmasini istiyoruz
    static List<Gorevli> gorevliler = new ArrayList<>();//Gorevli sinifi turunda gorevli isimleri eklemek icin gorevliler adli listeyi tanimladik.

    //Burada Map yapisi kullandik cunku hangi uyenin hangi kitabi aldigini eslestirmemiz gerek
    //private kullandik cunku bu map'e sadece KutuphaneYonetimSistemi sinifindan ulasılmasini istiyoruz bu sayede dogrudan erisim saglanır ve istemsiz degisimler onlendir
    private static Map<Uye, Kitap> oduncKitaplar = new HashMap<>(); //Uye ve kitap sinifi turunde bir map tanimladik.
    //Bu map sayesinde hangi uyenin hangi kitabi aldigini anlayacagiz.Cunku Uye sinifi ad ve id icerir.Kitap sinifi ise kitap adi ve yazari ismini icerir.Bu ikisi eslestiginde ise
    //Hangi kitabin kimde oldugu belli olur.
    //buraya final ekleyemeyiz eger eklersek bir uye bir kitabi odunc aldiginda ve kitabi iade ettiginde ayni kitabi baska bir kullaniciya odunc veremeyiz



    //Bu method sayesinde kutuphaneye kitap ekleyecegiz.
    //bu method bir deger geri dondurmuyor ve 2 paremetre alıyor :  String turunde kitapAdi ve yazar
    //Bu method erisime acik
    public void kitapEkle(String kitapAdi, String yazar) {
        Kitap yeniKitap = new Kitap(kitapAdi, yazar);//Kitap sinifi turunde yeniKitap degiskeni tanimlanmistir.Kitap sinifi yapici methodu 2 parametre alir ad ve id
        //yeniKitap degiskeni  de bu sayede 2 paremetre degeri icerir.
        //Ozetle verilen kitapAdi ve yazar bilgileri ile yeni bir Kitap nesnesi oluşturuluyor.
        kitaplar.add(yeniKitap);//kitaplar listesine bilgileri atanmis olan yeniKitap nesnesinin icerigi aktariliyor.
        System.out.println(yeniKitap.getAd() +"-"+ yeniKitap.getYazar()+" Adli kitap kutuphaneye eklenmistir");//Eklenen kitap ismi ve yazari ekrana yazdiriliyor

    }
    //kitaplar listesine eklenen kitaplari cikartmak icin bu method tanimlandi.
    //bu method public erisime acık ve bir deger dondurmuyor
    public void kitapCikar(String kitapAdi) {//String turunde 1 parametre alir.Bu parametre kitap nesnesinin bir  bilgisidir.
        Kitap kitap = null; // Kitap sinifi ile yeni tanimlanmis olan kitap nesnesinin ilk degeri null ataniyor
        for (Kitap k : kitaplar) { //kitaplar listesinin degerleri for dongusu ile tek tek taraniyor
            if (k.getAd().equals(kitapAdi)) { //eger kitaplar listesindeki bir deger methodun aldigi kitapAdi degiskenine esit ise
                kitap = k; // kitap nesnesi ,kitaplar listesinde taranmakta olan indexteki kitaba yani k'ya atanir.
                break;//Burada dongu sonlanir ve hemen alttaki if e gecilir
                //ozetle bu donguda bu methoda girilen kitap adi listedeki bir kitap adiyla eslesene kadar devam eder
                //eslestiginde ise dongu biter.
            }
        }

        if (kitap != null) { //eger kitap nesnesinin degeri null degil ise yani yani listede o isimde bir kitap bulunmuşsa:
            if (!kitap.isOduncAlindi()) { //eger kitap odunc alinmadi ise
                kitaplar.remove(kitap); //kitaplar listesinden kitap nesnesi cikarilir
                System.out.println(kitap.getAd() + " adlı kitap kütüphaneden çıkarıldı.");//cikarilan kitabin adi ekrana yazdirilir.
            }
            else {//eger kitap odunc alindi ise ekrana kitap odunc alindigindan kutuphaneden cikarilamaz diye ekrana yazdirilir.

                System.out.println("Bu kitap şu anda ödünç alındığından kütüphaneden çıkarılamaz.");
            }
        }
        else {//eger kitap nesnesinin degeri null ise bu isimde bir kitap bulunamadi diye ekrana yazdirilir.
            System.out.println("Bu isimde bir kitap bulunamadı.");
        }
    }


    //Bu method kitaplar listesindeki mevcut kitaplari goruntulemek icin eklenmistir.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void mevcutKitaplariGoruntule() {
        System.out.println("Kütüphanedeki mevcut kitaplar ve ödünç durumu:");
        for (Kitap kitap : kitaplar) {//kitaplar listesindeki degerler tek tek dongu ile taranir
            String durum = kitap.isOduncAlindi() ? "Ödünç Alındı" : "Mevcut";//kitaplar listesinde incelenmekte olan indexteki deger
            //Kitap sinifinin bir icerigi olan isOduncAlindi methodunu cagirarak degerine bakilir.Eger bu method true dondurduyse
            //İncelenmekte olan kitap odunc alindi demektir.
            //Eger false dondururse incelenmekte olan kitap odunc alinmadi demektir.
            System.out.println(kitap.getAd() + " - " + kitap.getYazar() + " - Durum: " + durum);//mevcut kitaplar ekrana yazdirilir
        }
    }

    //Bu method uyeler listesine uye eklemek icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void uyeEkle(String uyeAdi, int uyeID) { // String ve int turunde 2 parametre alir.Bunlar yeniUye nesnesinin icerikleridir

        Uye yeniUye = new Uye(uyeAdi, uyeID);//yeniUye degiskeni Uye sinifindan olusmustur ve Uye sinifinin yapici methodu ad ve id adinda 2 parametre alir.
        uyeler.add(yeniUye);//uyeler listesine yeni uye eklenmistir.
        System.out.println("Üye Adı: " + yeniUye.getAd() + " - Üye ID: " + yeniUye.getId() + " kutuphane uye listesine eklendi");
        //eklenen uye ekrana yazdirilmistir.
    }

    //Bu method uyeler listesinden uye cıkartmak icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void uyeCikar(Uye uye) { //Uye sinifi turunde 1 parametre alir
        if (oduncKitaplar.containsKey(uye)) {// Eğer oduncKitaplar haritasında verilen üyenin bir anahtarı olarak bulunuyorsa
            System.out.println("Üye, ödünç aldığı kitabı iade etmeden çıkarılamaz.");//kutuphaneden cikarilamaz diye ekrana yazdirilir
        } else {
            uyeler.remove(uye); //odunc kitap almadiyse uyeler listesinden cikartilir
            System.out.println("Üye Adı: " + uye.getAd() + " - Üye ID: " + uye.getId() + " kutuphane üye listesinden çıkarıldı");
            //cıkarilan uyenin bilgileri ekrana yazdirilir
        }
    }



    //Bu method mevcut uyeleri goruntulemek icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void mevcutUyeleriGoruntule() {
        System.out.println("Kütüphanedeki mevcut üyeler:");
        for (Uye uye : uyeler) {//uyeler listesinin degerleri for dongusu ile taranir
            System.out.println("Üye Adı: " + uye.getAd() + " - Üye ID: " + uye.getId());//uyeler listesinin elemanlari ekrana yazdirilir.
        }
    }

    //Bu method gorevli eklemek icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void gorevliEkle(String gorevliAdi, int gorevliID) {//String ve int turunde 2 parametre alir
        Gorevli yeniGorevli = new Gorevli(gorevliAdi, gorevliID); //Gorevli sinifindan olusan yeniGorevli nesnesi gorevliAdi ve gorevliID icerir
        gorevliler.add(yeniGorevli);//gorevliler listesine yeni gorevli eklenir.
        System.out.println("Gorevli Adı: " + yeniGorevli.getAd() + " - Gorevli ID: " + yeniGorevli.getId() + " kutuphaneye eklendi");//eklenen gorevlinin bilgileri ekrana yazdirilir.
    }

    //Bu method gorevli cikartmak icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void gorevliCikarB(Gorevli gorevli){//Gorevli sinifi turunde bir parametre alir.
        gorevliler.remove(gorevli);//gorevliler listesinden method cagrildiginda parametresine yazilan gorevli cikartilir.
        System.out.println("Gorevli Adı: " + gorevli.getAd() + " - Gorevli ID: " + gorevli.getId() + " kutuphaneden cikarildi");//cikarilan gorevlinin bilgileri ekrana yazdirilir.
    }


    //Bu method gorevlileri goruntulemek icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void mevcutGorevlileriGoruntule() {
        System.out.println("Kütüphanedeki mevcut görevliler:");
        for (Gorevli gorevli : gorevliler) {//gorevliler listesinin elemanları for dongusu ile tek tek taranir
            System.out.println("Görevli Adı: " + gorevli.getAd() + " - Görevli ID: " + gorevli.getId());//gorevliler listesinin elemanlari ekrana yazdirilir
        }
    }

    //Bu method kitaplari uyelere odunc  verebilmek icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void oduncVer(Uye uye, Kitap kitap) {//Uye sinifi turunde ve Kitap sınıfı türünde 2 parametre alir
        if (!kitap.isOduncAlindi()) {//kitap odunc alinmadi ise yani Kitap sinifinda bulunan isOduncAlindi methodu true dondurmediyse
            kitap.setOduncAlindi(true); // Kitap'ın ödünç alındığı bilgisi true olarak ayarlanır.Bu bilgi degisimi set edilerek yapilir
            oduncKitaplar.put(uye, kitap);//oduncKitaplar map'ine uye-kitap ikilisi eklenir
            System.out.println(kitap.getAd() + " kitabı " + uye.getAd() + " üyesine ödünc verildi.");//hangi uyenin hangi kitabi aldigi yazdirilir.
        }
        else {//isOduncAlindi methodu false dondururse
            System.out.println("Bu kitap zaten ödünc alınmış.");//ekrana kitap odunc alindi yazdirilir
        }
    }

    //Bu method kitaplari uyelerden iade alabilmek icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void kitapIade (Uye uye) {//bu method Uye sinifi turunde 1 parametre alir
        if (oduncKitaplar.containsKey(uye)) {// Eğer oduncKitaplar haritasında (map) belirtilen(Uye sinifindan olusturulan uye degiskeni) Üye'nin bir anahtarı olarak bulunuyorsa
            Kitap alinanKitap = oduncKitaplar.get(uye);// oduncKitaplar haritasından belirtilen Üye'ye ait Kitap nesnesini alır
            // ve bu nesne Kitap sinifi turunde tanimlanan alinanKitap degiskenine atanir.
            oduncKitaplar.remove(uye);//Belirtilen Üye'ye ait ödünç kitap haritadan (oduncKitaplar) kaldırılır.Sadece kitap kaldirilmaz
            //mapte uye ve odunc aldigi kitap bir ikili olarak bulundugu icin ikisi de silinir.
            System.out.println(uye.getAd() +" "+ uye.getId() + " tarafından " + alinanKitap.getAd() + " kitabı kütüphaneye geri bırakıldı.");//iade edilen kitap ekrana yazdirilir
            alinanKitap.setOduncAlindi(false); // İlgili Kitap nesnesinin oduncAlindi özelliği false olarak ayarlandi ve yani kitap artık ödünç alınmadi olarak gorulur
        }
        else {//Eğer oduncKitaplar haritasında (map) belirtilen(Uye sinifindan olusturulan uye degiskeni) Üye'nin bir anahtarı olarak bulunmuyorsa
            System.out.println(uye.getAd() + " için ödünc alınmıs kitap bulunmamaktadır.");//methoda girilen uyenin kitap odunc almadigi ekrana yazdirilir
        }
    }


    //Bu method uyelerde odunc halde bulunan kitapları goruntulemek icin olusturulmustur.
    //Bu method public'tir genel erisime aciktir ve bir deger dondurmez.
    public void oduncDurumuGoster() {
        System.out.println("Şu an uyelerdeki odunc bulunan kitaplar:");
        for (Map.Entry<Uye, Kitap> entry : oduncKitaplar.entrySet()) {//oduncKitaplar map'indeki elemanlari tek tek for dongusu yardimiyla gezeriz
            //bu map hangi uyede hangi kitabin oldugunu gosterir .Yani bir uyenin aldigi anahtar aslinda odunc aldigi kitap olarak  dusunulebilir.
            System.out.println("Üye Adı: " + entry.getKey().getAd() + " - Üye ID: " + entry.getKey().getId() +
                    " - Kitap Adı: " + entry.getValue().getAd()); //hangi uyenin hangi kitabi odunc aldigi ekrana yazdirilir
        }
    }
}