//Bu sinifi kutuphaneye uye olacak bireyleri gostermek icin actim

class Uye extends Kisi { //Uye sinifi kisi sinifini miras alir.
    public Uye(String uyeAdi, int uyeID) {//Uye nesnesi String veri yapisinda  bir uyeAdi degiskeni ve int veri yapisinda  bir uyeId degiskeni icerir.
        super(uyeAdi, uyeID);// Kisi sınıfının constructor'ını çağırır.
    }


}
