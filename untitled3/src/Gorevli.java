//Bu sinifi kutuphanede calisacak gorevlileri gostermek icin actim
class Gorevli extends Kisi {//Gorevli sinifi kisi sinifini miras alir.
    public Gorevli(String gorevliAdi, int gorevliID) { ///Gorevli nesnesi String veri yapisinda  bir gorevliAdi degiskeni ve int veri yapisinda  bir gorevliId degiskeni icerir.

        super(gorevliAdi, gorevliID);
        // super kelimesi ile üst sınıf olan Kisi sınıfının constructor'ı çağrılıyor.
        // super(gorevliAdi, gorevliID); ifadesiyle, Gorevli sınıfı Kisi sınıfının constructor'ını çağırarak
        // ad ve id değerlerini Kisi sınıfına iletiyor ve onun kurucu metodunu kullanarak bu değerleri atıyor.
    }
}
