
//Bu sinifi kutuphanedeki kitaplari gostermek icin actim
class Kitap extends Kisi {//Kitap sinifi kisi sinifini miras alir.
    private String yazar; //String veri yapisinda yazar degiskeni tanimladik
    private boolean oduncAlindi;//boolean veri yapisinda oduncAlindi degiskeni tanimladik
    //burada kitap adi degiskeni, Kisi sinifindan ad  degiskeni olarak miras alindigi icin ayrica tanimlamasini yapmadik.
    //yazar ve oduncAlindi degiskenleri miras alinmadigi icin yapici sinifta gerekli atamalari yapilacaktir.
    public Kitap(String kitapAdi, String yazar) {
        super(kitapAdi, -1); // Kitapların id'si -1 olarak varsaydik. // Kitapların id'si -1 olarak varsayalım. Super ile Kisi sınıfının constructor'ını çağırdik.
        this.yazar = yazar;//bu sinifin icerdigi yazar degiskeni "yazar"a atanmistir.
        this.oduncAlindi = false; // bu sınıfin oduncAlindi degiskeni "false"a atanmistir.
    }


    //gerekli get etmeleri yapiyoruz.
    //yazar ve oduncAlindi degiskeni private olarak tanimli Yani sadece kendi sinifi icinde bu degiskenlere erisim saglanabilir.
    //Fakat biz bu degiskenleri get ederek diger siniflarda bu degiskenlerin okunmasini saglayacagiz.
    public String getYazar() {

        return yazar; // Kitap sınıfından oluşturulan nesnenin yazar özelliğini döndürür.
    }

    //Bu metodun ismi isOduncAlindi, genellikle bir özellik (property) ya da durum sorgulaması yapar.
    // Bu durumda, oduncAlindi adındaki bir özelliği (property) döndürür.
    // Bu özellik, Kitap sınıfından oluşturulan bir nesnenin oduncAlindi adındaki özelliğidir.
    //Yani bu metodun görevi oduncAlindi adlı özelliği sorgulamak ve değerini döndürmektir.
    // Bu özellik,  bir kitabın ödünç alınıp alınmadığını belirten bir boolean (true/false) değerini temsil eder.
    // Eğer oduncAlindi değeri true ise kitabın ödünç alındığı, false ise ödünç alınmadığı anlamına gelir.
    public boolean isOduncAlindi() {
        return oduncAlindi;// Kitap sınıfından oluşturulan nesnenin oduncAlindi özelliğini döndürür.
    }



    //Burada oduncAlindi degiskenini set ettik cunku oduncAlindi degiskeninin diger siniflarda okunmus olmasi yeterli degil.
    //cunku biz bir kutuphane isletmesi yapiyoruz ve kitaplari odunc vermek zorundayiz.
    //Baska bir sınıftayken kitaplari odunc verdigimizde oduncAlindi degiskenine true degerini atamak zorundayiz .
    //Fakat oduncAlindi degiskeni private olarak tanimli.Bu halde true atamamiz imkansiz.
    // Bundan dolayi biz oduncAlindi degiskenini set ettik bu sayede baska sinifta true degeri atanabilecek.
    public void setOduncAlindi(boolean oduncAlindi) {

        this.oduncAlindi = oduncAlindi; // Kitap sınıfının oduncAlindi özelliğine verilen değeri atar.
    }
}