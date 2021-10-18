package ba.unsa.etf.rpr;

public class Sat {
        int sati;
        int minute;
        int sekunda;

        Sat(int s, int m, int sek){
            Postavi(s, m, sek);
        }

        public void Postavi(int s, int m, int sek){
            sati = s;
            minute = m;
            sekunda = sek;
        }

        public void Prethodni(){
            sekunda = sekunda -1;

            if (sekunda==-1){
                sekunda=59;
                minute=minute-1;
            }

            if (minute==-1){
                minute=59;
                sati=sati-1;
            }

            if (sati==-1) sati=23;
        }

        public void Sljedeci(){
            sekunda=sekunda+1;
            if (sekunda==60){
                sekunda=0;
                minute=minute+1;
            }
            if (minute==60){
                minute=0;
                sati=sati+1;
            }
            if (sati==24) sati=0;
        }

        public void PomjeriZa(int pomak){
            if(pomak>0){
                for(int i=0; i<pomak; i++) Sljedeci();
            }
            else for(int i=0;i<-pomak; i++) Prethodni();
        }

        public int DajSate() {
            return sati;
        }
        public int DajMinute(){
            return minute;
        }
        public int DajSekunde(){
            return sekunda;
        }

        void Ispisi(){
            System.out.println(sati + ":" + minute + ":" + sekunda);
        }
    public static void main(String[] args) {
        Sat s= new Sat(15, 30, 45);
        s.Ispisi();
        s.Sljedeci();
        s.Ispisi();
        s.Prethodni();
        s.Ispisi();
        s.Postavi(0, 0,0);
        s.Ispisi();
        s.PomjeriZa(-48);
        s.Ispisi();
    }
}
