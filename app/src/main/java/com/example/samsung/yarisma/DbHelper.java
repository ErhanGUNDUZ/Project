package com.example.samsung.yarisma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Samsung on 4.5.2016.
 */
public class DbHelper extends SQLiteOpenHelper {


    public int bulunulansoru = 1;
    private static final int DATABASE_VERSION = 1;

    private static final String VeritabaniAdi = "yarisma";


    //Sorular Tablosu
    private static final String TabloAdi = "soru";

    private static final String SoruNo = "SoruNo";
    private static final String Soru = "Soru";
    private static final String SoruZorluk = "SoruZorluk";
    private static final String Secenek1 = "Scnk1";
    private static final String Secenek2 = "Scnk2";
    private static final String Secenek3 = "Scnk3";
    private static final String Secenek4 = "Scnk4";
    private static final String Cevap = "Cvp";

    //Yarısanlar Tablosuu
    private static final String TabloAdiYarisanlar = "Yarisanlar";

    private static final String YNo = "YNo";
    private static final String YRumuz = "YRumuz";
    private static final String YPuan = "YPuan";

    private SQLiteDatabase dbase;
    int dc;
    String derece=null;


    public DbHelper(Context context) {
        super(context, VeritabaniAdi, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TabloAdi + " ( " + SoruNo + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Soru + " TEXT, " + SoruZorluk + " INTEGER, " + Secenek1 + " TEXT, " + Secenek2 + " TEXT, " + Secenek3 + " TEXT, " + Secenek4 + " TEXT, " + Cevap + " INTEGER );";

        db.execSQL(sql);

        addQuestions();

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TabloAdiYarisanlar + " ( " + YNo + " INTEGER PRIMARY KEY AUTOINCREMENT, " + YRumuz + " TEXT, " + YPuan + " INTEGER);";
        db.execSQL(sql2);



    }


    private void addQuestions() {
        Soruu s1 = new Soruu("2+2=?", 1, "3", "5", "4", "0", 3);
        this.addQuestion(s1);
        Soruu s2 = new Soruu("\" Sakla samanı, gelir zamanı. \" atasözünde vurgulanan konu aşağıdakilerden hangisidir?", 2, "Birikim", "Sabır", "Para", "Emek", 1);
        this.addQuestion(s2);
        Soruu s3 = new Soruu("Aşağıdaki markalardan hangisi notebook üretmez?", 3, "HP", "Sonny", "Fakir", "Samsung", 3);
        this.addQuestion(s3);
        Soruu s4 = new Soruu("Aşağıdakilerden hangisi çok kitap okuyan birisi için söylenir?", 4, "Kitap eşşeği", "Kitap arısı", "Kitap ineği", "Kitap kurdu", 4);
        this.addQuestion(s4);
        Soruu s5 = new Soruu("Hangisinin ışığının üzerinizde parlaması günün saatine göre farklı şekilde yorumlanır?", 2, "Güneş", "Ay", "Yıldız", "Mars", 1);
        this.addQuestion(s5);
        Soruu s6 = new Soruu("Hangisinin klasik olanı elektrikler kesildiğinde de kullanılabilir?", 3, "Çamaşır makinesi", "Ev telefonu", "Termosifon", "Televizyon", 2);
        this.addQuestion(s6);
        Soruu s7 = new Soruu("\" Az kaldı, biraz daha sabret. \" anlamında kullanılan söz aşağıdakilerden hangisidir?", 1, "La Havle", "Ha gayret", "Hoppala", "Vah Vah", 2);
        this.addQuestion(s7);
        Soruu s8 = new Soruu("Ressamlar  imzalarını genellikle resmin neresine atarlar?", 3, "Sağ alt köşe", "Solt alt köşe", "Sağ üst köşe", "Sol üst köşe", 1);
        this.addQuestion(s8);
        Soruu s9 = new Soruu("2014-2015 sezonunda hangisi kendi liginde şampiyon olmamıştır?", 5, "Juventus", "Manchester United", "Barcelona", "Bayern Munich", 2);
        this.addQuestion(s9);
        Soruu s10 = new Soruu("Hangi çiçek aslında yüzlerce küçük çiçeğin toplamıdır?", 6, "Nilüfer", "Menekşe", "Ayçiçeği", "Gelincik", 3);
        this.addQuestion(s10);
        Soruu s11 = new Soruu("Hangisini iplere dizerek kurutarak yıl boyunca kullanırlar?", 3, "Tütün", "Ayçiçeği", "Mısır", "Pamuk", 3);
        this.addQuestion(s11);
        Soruu s12 = new Soruu("Hangi kelime aslında çoğuldur?", 2, "İlaç", "Baharat", "Sayfa", "Kumaş", 2);
        this.addQuestion(s12);
        Soruu s13 = new Soruu("3-(-2)=?", 1, "1", "0", "4", "5", 4);
        this.addQuestion(s13);
        Soruu s14 = new Soruu("\" Atom Karınca \" lakaplı Beşiktaşlı eski futbolcu kimdir?", 5, "Feyyaz UÇAR", "Mehmet ÖZDİLEK", "Rıza ÇALIMBAY", "Metin TEKİN", 3);
        this.addQuestion(s14);
        Soruu s15 = new Soruu("\" Sebahattin ALİ' nin aynı adlı eserindeki \" Kürk Mantolu Madonna \" romanda hangisinin ismidir?", 7, "Heykel", "Tablo", "Cadde", "Kitap", 2);
        this.addQuestion(s15);
        Soruu s16 = new Soruu("Bir izleyici topluluğu önünde yapılan gösteriden sonra toplanan paraya verilen Farsça kökenli isim aşağıdakilerden hangisidir?", 10, "Kapik", "Mangır", "Voli", "Parsa", 4);
        this.addQuestion(s16);
        Soruu s17 = new Soruu("\"Pamuk eller cebe \" diyen biri ne istiyordur?", 1, "Misket", "Mendil", "Para", "Şeker", 3);
        this.addQuestion(s17);
        Soruu s18 = new Soruu("Heredot' a göre Antik Mısır' da kaşlarını tıraş eden kişiler, bu hareketi aşağıdakilerden hangisinin yasını tutmak için yaparlarda?", 15, "firavunların", "Eşlerinin", "Kuşlarının", "Kedilerinin", 4);
        this.addQuestion(s18);
        Soruu s19 = new Soruu("Bilim adamları Utarit' e uzay aracı yollayacaksa hangisine keşif yapılacak demektir?", 14, "Merkür", "Venüs", "Mars", "Jüpiter", 1);
        this.addQuestion(s19);
        Soruu s20 = new Soruu("Halk arasında kullanılan bir söze göre, sütten ağzı yanan yoğurdu nasıl yer?", 1, "Koklayarak", "Sallayarak", "Üfleyerek", "Gözleyerek", 3);
        this.addQuestion(s20);
        Soruu s21 = new Soruu("İran hangi eski devletin modern halidir?", 8, "Osmanlı Devleti", "Babür Devleti", "Pers Devleti", "Arap Devlet", 3);
        this.addQuestion(s21);
        Soruu s22 = new Soruu("Kırmızı gezegen olarak adlandırılan gezegen hangisidir?", 4, "Venüs", "Jüpiter", "Merkür", "Mars", 4);
        this.addQuestion(s22);
        Soruu s23 = new Soruu("Eğer prokaryotik bir canlı fotosentez yapabiliyorsa aşağıdakilerden hangisi hücresinde kesinlikle bulunur?", 13, "Klorofil pigmenti", "Mitokondri", "Endeplazmik retikulum", "Ribozomlar", 1);
        this.addQuestion(s23);
        Soruu s24 = new Soruu("Japon kültüründeki yaygın sanat şekli nedir?", 9, "Rastgele döşeme", "Su rengi", "Kolaj", "Akrilik boyama", 2);
        this.addQuestion(s24);
        Soruu s25 = new Soruu("PSA hangi kanserin markeridir?", 11, "Pankreas", "Perikard", "Periton", "Prostat", 4);
        this.addQuestion(s25);
        Soruu s26 = new Soruu("İneğin kaç tane kalbi vardır?", 3, "2", "1", "3", "4", 2);
        this.addQuestion(s26);
        Soruu s27 = new Soruu("Dünyanın en derin gölü neresidir?", 5, "Hazar Gölü", "Lut Gölü", "Baykal Gölü", "Aral Gölü", 3);
        this.addQuestion(s27);
        Soruu s28 = new Soruu("Maddelerin ısı etkisi ile büyümesine ne denir?", 3, "Genleşme", "Büzülme", "Kaynama", "Yanma", 1);
        this.addQuestion(s28);
        Soruu s29 = new Soruu("Portre ne demektir?", 2, "Saç resmi", "Burun resmi", "Yüz resmi", "Hiçbiri", 3);
        this.addQuestion(s29);
        Soruu s30 = new Soruu("Hangi ikili Karadeniz fıkralarının baş kahramanlarıdır?", 1, "Temel-Dursun", "Sam-Frodo", "Leyla-Mecnun", "Zeki-Metin", 1);
        this.addQuestion(s30);
        Soruu s31 = new Soruu("Bollywood hangi ülkeye aittir?", 3, "Pakistan", "Hindistan", "Macaristan", "Letonya", 2);
        this.addQuestion(s31);
        Soruu s32 = new Soruu("Koksiks insan vücudunda hangisine karşılık gelir?", 13, "El bileğindeki küçük bir kemik", "Uyluk kemiğindeki bir girinti", "Kaburgalar arasındaki kıkırdak", "Kuyruk kalıntısı", 4);
        this.addQuestion(s32);
        Soruu s33 = new Soruu("Facebook kaç yılında kurulmuştur?", 6, "2002", "2007", "2004", "2005", 3);
        this.addQuestion(s33);
        Soruu s34 = new Soruu("Futbolda kaleci ceza sahası dışındayken topu eline alırsa ne olur?", 5, "Gol", "Ofsayt", "Korner", "Penaltı", 4);
        this.addQuestion(s34);
        Soruu s35 = new Soruu("Çizgi filmlerin 1 saniyesi için kaç farklı çizim yapmak gerekir?", 9, "16", "24", "37", "44", 2);
        this.addQuestion(s35);
        Soruu s36 = new Soruu("Hangi teknik üniversitede tıp fakültesi vardır?", 11, "Karadeniz Teknik Fakültesi", "Yıldız Teknik Üniversitesi", "Ortadoğu Teknik Üniversitesi", "İstanbul Teknik Üniversitesi", 1);
        this.addQuestion(s36);
        Soruu s37 = new Soruu("Hangisi hızı arttırırken eşik enerjisini düşürür?", 7, "Katalizör", "İnhibitör", "Sıcaklık", "Derişim", 1);
        this.addQuestion(s37);
        Soruu s38 = new Soruu("Hangisi ilk Türk psikolojik eseridir?", 4, "Eylül", "Ağrı dağı efsanesi", "Yüksekten", "Kına dağı", 1);
        this.addQuestion(s38);
        Soruu s39 = new Soruu("İlk Türk futbol takımı hangisidir?", 8, "Siyah Çoraplılar", "Beşiktaş", "Fenerbahçe", "Galatasaray", 1);
        this.addQuestion(s39);
        Soruu s40 = new Soruu("\"Ulu hakan\" olarakta anılan Osmanlı Sultanı ve Halifesi kimdir?", 15, "||. Abdülhamid", "Abdülmecid", "Vahüdiddin", "|V. Murat", 1);
        this.addQuestion(s40);
        Soruu s41 = new Soruu("Hangi olay sonrası ilk çağ kapanıp orta çağ başlamıştır?", 8, "Kavimler göçü", "Yazının bulunması", "İstanbul' un fethi", "Fransız ihtilali", 1);
        this.addQuestion(s41);
        Soruu s42 = new Soruu("Vücuttaki tuz dengesini ayarlayan hormonun ismi nedir?", 12, "Aldosteron", "Kalsitonin", "ADH", "FSH", 1);
        this.addQuestion(s42);
        Soruu s43 = new Soruu("Atom numarası 1 olan elementin sembolu nedir?", 9, "He", "Sn", "Be", "H", 4);
        this.addQuestion(s43);
        Soruu s44 = new Soruu("Aşağıdakilerden hangisi büyük ölçekli haritadır?", 12, "1/20.000", "1/200.000", "1/300.000", "1/500.000", 1);
        this.addQuestion(s44);
        Soruu s45 = new Soruu("Ülkemizde sarımsak denildiği zaman akla gelen ilk yer neresidir?", 4, "Taşköprü", "Taşova", "Biga", "Cide", 1);
        this.addQuestion(s45);
        Soruu s46 = new Soruu("Karadeniz' de Amazonların yaşadığı rivayet edilen tek adası hangi ilimiz sınırları içerisindedir?", 14, "Giresun", "Ordu", "Trabzon", "Sinop", 1);
        this.addQuestion(s46);
        Soruu s47 = new Soruu("Gitarın en alttaki teline vurduğunuz zaman hangi notayı elde edersiniz?", 9, "Fa", "Do", "Mi", "Re", 3);
        this.addQuestion(s47);
        Soruu s48 = new Soruu("Hangisi voleybol sahasında bulunur?", 2, "Basket potası", "Kale", "Raket", "File", 4);
        this.addQuestion(s48);
        Soruu s49 = new Soruu("Hangi gezegenin bir yılı bir gününden kısadır?", 12, "Venüs", "Mars", "Neptün", "Plüton", 1);
        this.addQuestion(s49);
        Soruu s50 = new Soruu("Kaldıraçların mantığı nedir?", 6, "Az kuvvet çok iş", "Çok kuvvet az iş", "Zamandan kazanmak", "Hepsi", 1);
        this.addQuestion(s50);
        Soruu s51 = new Soruu("Emojinin anlamı nedir?", 1, "Yüz ifadesi", "Amazonda bulunan bir mantar", "Ressamların duyguları ifade etmesi", "Teknolojik sanat eseri", 1);
        this.addQuestion(s51);
        Soruu s52 = new Soruu("Toprağı sürmekte kullanılan demir uçlu tarım aracının adı nedir?", 6, "Yaba", "Orak", "Pulluk", "Tırpan", 3);
        this.addQuestion(s52);
        Soruu s53 = new Soruu("Kendisine \"tavşan dişli\" denen kişilerin hangi dişleri uzun olur?", 1, "Azı dişleri", "Ön dişleri", "Köpek dişleri", "Süt dişleri",2);
        this.addQuestion(s53);
        Soruu s54 = new Soruu("\"Çiçeği burnunda\" sözünün anlamı nedir?", 2, "Yeni", "Heyecanlı", "Sevimli", "İnce",1);
        this.addQuestion(s54);
        Soruu s55 = new Soruu("İki arkadaştan birinin aldığı yeni bir eşyayı diğerinin beğendiğini söylemesi durumunda, karşılaşabileceği komik teklif hangisidir?",3, "Bir tane de sana alalım", "Çalış senin de olur", "Satayım sana", "Teklif var ısrar yok",3);
        this.addQuestion(s55);
        Soruu s56 = new Soruu("13 TL 35 kuruş para üstü almak üzere olan bir müşteri, para üstü olarak 20 TL’lik banknot isterse kasiyere ne kadar vermelidir?",4, "6 TL 35 kuruş", "6 TL 65 kuruş", "7 TL 35 kuruş", "7 TL 65 kuruş",2);
        this.addQuestion(s56);
        Soruu s57 = new Soruu("Satrançta bir taraf karşı tarafı en az kaç hamlede mat edebilir?", 5, "1", "2", "4", "6",2);
        this.addQuestion(s57);
        Soruu s58 = new Soruu("\"Ateş pahası\" bir ürünün hangi özelliğinden bahsederken kullanılan bi sözdür?", 2, "Lezzeti", "Fiyatı", "Tazeliği", "Sıcaklığı",2);
        this.addQuestion(s58);
        Soruu s59 = new Soruu("Bir yerin rakımı, onun nereden itibaren yüksekliğini belirtir?", 4, "En yakın düzlükten", "Dağ eteğinden", "Şehir merkezinden", "Deniz seviyesinden",4);
        this.addQuestion(s59);
        Soruu s60 = new Soruu("Mutfakta musluk altında bulaşık yıkamaya yarayan tekneye ne ad verilir?", 5, "Kümbet", "Davlumbaz", "Eviye", "Sebil",3);
        this.addQuestion(s60);
        Soruu s61 = new Soruu("Hollywood filmlerinde sinirli bir genci rahatlatmak için söylenen klişe sözün Türkçe karşılığı nedir?", 1, "Sakin ol şampiyon", "Avukatımı istiyorum", "Senden utanıyorum", "İtiraz ediyorum",1);
        this.addQuestion(s61);
        Soruu s62 = new Soruu("Binebilmek için el sallanan, ıslık çalınan ve adı bağırılarak söylenen ulaşım aracı hangisidir?", 3, "Dolmuş", "Otobüs", "Tren", "Taksi",4);
        this.addQuestion(s62);
        Soruu s63 = new Soruu("\"Mırlan, sinarit, lipsos\" fiyatlarını soruyorsanız neyin fiyatını alıyorsunuzdur?", 5, "Balık", "Enginar", "Çiçek", "Pirinç",1);
        this.addQuestion(s63);
        Soruu s64 = new Soruu("Hangi sporda \"asist\" olmaz?", 4, "Voleybol", "Basketbol", "Tenis", "Futbol",3);
        this.addQuestion(s64);
        Soruu s65 = new Soruu("Halk arasında kullanılan \"bıldır\" kelimesinin anlamı nedir?", 5, "Geçen gün", "Geçen hafta", "Geçen ay", "Geçen sene",4);
        this.addQuestion(s65);
        Soruu s66 = new Soruu("\"Shire, Gondor ve Rohan\" hangi film ve kitap serisindeki kurgu yerlerdir?", 7, "Harry Potter", "Batman", "Açlık Oyunları", "Yüzüklerin Efendisi",4);
        this.addQuestion(s66);
        Soruu s67 = new Soruu("Hangi futbol kulübünün logosunda kırmızı renk yoktur?", 8, "Trabzonspor", "Bursaspor", "Beşiktaş", "Fenerbahçe",1);
        this.addQuestion(s67);
        Soruu s68 = new Soruu("\"Dönerse senindir, dönmezse\" diye başlayan klişe söz hangisiyle devam eder?", 1, "Zaten hiç senin olmamıştır", "Zaten senindir", "Zaten senin olmalıdır", "Zaten sen istememişsindir",1);
        this.addQuestion(s68);
        Soruu s69 = new Soruu("Trafiğin durma noktasına geldiği durumlar hangisi ile ifade edilir?", 2, "Zincir", "Kilit", "Makas", "Şerit",2);
        this.addQuestion(s69);
        Soruu s70 = new Soruu("\"Yaprak kıpırdamıyor\" sözü hangisinin olduğu durumlarda söylenir?", 3, "Yağmur yağmadığında", "Şimşek çakmadığında", "Rüzgar esmediğinde", "Güneş açmadığında",3);
        this.addQuestion(s70);
        Soruu s71 = new Soruu("Halk arasında kullanılan bir söze göre hangi günler çabuk geçer?", 1, "Sayılı", "Sıralı", "Sakin", "Sıkıcı",1);
        this.addQuestion(s71);
        Soruu s72 = new Soruu("\"Küçücük fıçıcık içi dolu turşucuk\" sözleri hangisine bir örnektir?", 2, "Fıkra", "Atasözü", "Masal", "Bilmece",4);
        this.addQuestion(s72);
        Soruu s73 = new Soruu("Hangi spordaki rakipler, oyun boyunca birbirleriyle karşı karşıya değil genellikle yanyana dururlar?", 5, "Masa tenisi", "Basketbol", "Tenis", "Squash",4);
        this.addQuestion(s73);
        Soruu s74 = new Soruu("İnsan vücudunun hangi bölümüne \"incik\" denir?", 6, "Baldır", "Kaburga", "Boyun", "Uyluk",1);
        this.addQuestion(s74);
        Soruu s75 = new Soruu("Eski kuşaklar hangisi için Arapça kökenli \"seyyare\" kelimesini kullanırlar?", 8, "Manzara", "Gezegen", "Mevsim", "Ufuk",2);
        this.addQuestion(s75);
            Soruu s76 = new Soruu("\"Kesmece bunlar\" tanımı hangi meyve türü için kullanılır?", 2, "Şeftali", "Portakal", "Karpuz", "Kavun",3);
        this.addQuestion(s76);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + TabloAdi);

        db.execSQL("DROP TABLE IF EXISTS " + TabloAdiYarisanlar);

        onCreate(db);

    }


    public void addQuestion(Soruu quest) {

        ContentValues values = new ContentValues();
        values.put(Soru, quest.getSoru());
        values.put(SoruZorluk, quest.getSoruZorluk());
        values.put(Secenek1, quest.getSecenek1());
        values.put(Secenek2, quest.getSecenek2());
        values.put(Secenek3, quest.getSecenek3());
        values.put(Secenek4, quest.getSecenek4());
        values.put(Cevap, quest.getCevap());


        dbase.insert(TabloAdi, null, values);
    }


    public String[] sorucek() {


        String[] cv = new String[15];
        dbase = this.getReadableDatabase();
        String ss;
        String sc1, sc2, sc3, sc4;




        Cursor c1 = dbase.rawQuery("SELECT SoruNo FROM " + TabloAdi + " WHERE " + SoruZorluk + "='" + bulunulansoru + "' ", null);
        int ssayisi = 0;
        ssayisi = c1.getCount();
        int[] sidler = new int[ssayisi + 1];
        int sid = 0;

        if (c1.moveToFirst()) {
            do {
                sidler[sid] = c1.getInt(0);
                sid++;
                c1.moveToNext();
            } while (sid != ssayisi);
        }

        Random rr = new Random();
        int h = 0;
        h = rr.nextInt(ssayisi);

        Cursor c = dbase.rawQuery("SELECT * FROM " + TabloAdi + " WHERE " + SoruNo + "='" + sidler[h] + "' ORDER BY " + SoruNo, null);
        bulunulansoru++;
        if (c.moveToFirst()) {
            ss = c.getString(1);
            cv[1] = ss;
            sc1 = c.getString(3);
            cv[2] = sc1;
            sc2 = c.getString(4);
            cv[3] = sc2;
            sc3 = c.getString(5);
            cv[4] = sc3;
            sc4 = c.getString(6);
            cv[5] = sc4;
            dc = c.getInt(7);
            cv[6] = String.valueOf(dc);
        }

        return cv;

    }

    public int getdogrucevaplanansorusayisi() {
        return bulunulansoru - 2;
    }

    public int getbulunulansoru() {
        return bulunulansoru;
    }

    public int getdogrucevap() {
        return dc;
    }

     public void SkorKaydet(String rumz, int ypuan) {

        ContentValues cvv=new ContentValues();
        cvv.put(YRumuz,rumz);
        cvv.put(YPuan, ypuan-1);
        //dbase.execSQL("Delete FROM "+TabloAdiYarisanlar); //skorları temizle
        dbase.insertOrThrow(TabloAdiYarisanlar, null, cvv);
    }


    public ArrayList<HashMap<String, String>> getSkorlar() {

        String selectQuery = "SELECT * FROM "+TabloAdiYarisanlar+" ORDER BY "+YPuan+" DESC";
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        ArrayList<HashMap<String, String>> ylist = new ArrayList<HashMap<String, String>>();


        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.clear();
                for(int i=0; i<cursor.getColumnCount();i++)
                {
                    switch (cursor.getInt(2)-1)
                    {
                        case 0:
                            derece="Çaylak";
                            break;
                        case 1:
                            derece="Çaylak";
                            break;
                        case 2:
                            derece="Çaylak";
                            break;
                        case 3:
                            derece="Çaylak";
                            break;
                        case 4:
                            derece="Acemi";
                            break;
                        case 5:
                            derece="Acemi";
                            break;
                        case 6:
                            derece="Acemi";
                            break;
                        case 7:
                            derece="Usta";
                            break;
                        case 8:
                            derece="Usta";
                            break;
                        case 9:
                            derece="Usta";
                            break;
                        case 10:
                            derece="Uzman";
                            break;
                        case 11:
                            derece="Uzman";
                            break;
                        case 12:
                            derece="Deha";
                            break;
                        case 13:
                            derece="Kral";
                            break;
                        default:
                            derece="Çaylak";
                            break;
                    }

                    map.put(cursor.getColumnName(i), cursor.getString(1) + "\n                                                          " + derece);
                    derece=null;
                }
                ylist.add(map);

            } while (cursor.moveToNext());
        }

        return ylist;
    }


}
