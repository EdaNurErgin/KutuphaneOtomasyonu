//Burada kisi adinda bir sınıf tanimladim
//Bu sinifi actım cunku:
//Gorevli , Uye ve Kitap sinifinda bu sınıfı kullanacagiz.

class Kisi {
    private String ad; //ad degiskenini String veriyapisiyla tanimladik
    private int id; //id degiskenini int veri yapisiyla tanimladik.

    public Kisi(String ad, int id) {  //Kisi nesnesi String veri yapisinda bir ad ve int veri yapisinda bir id  icerir.
        this.ad = ad; //bu sinifin ad degiskeni bir "ad" a atanmistir.
        this.id = id; //bu sinifin id degiskeni bir "id" a atanmistir.
    }

    public String getAd() {
        return ad;
    }//Ad degiskenini getAd  yaptim cunku bu degisken private olarak tanimlandi.
    // Yani Bu degiskene baska siniflardan ulasilamaz.
    // Fakat bu degiskenin baska siniflardan okunmasini istiyoruz.Bu yüzden
    //get ettik.
    //getAd() seklinde disaridan erisilecek

    public int getId() {
        return id;
    }
}
//Id degiskenini getId yaptim cunku bu degisken private olarak tanimlandi.
// Yani Bu degiskene baska siniflardan ulasilamaz.
// Fakat bu degiskenin baska siniflardan okunmasini istiyoruz.Bu yüzden
//get ettik.
//getId seklinde disaridan erisilecek





