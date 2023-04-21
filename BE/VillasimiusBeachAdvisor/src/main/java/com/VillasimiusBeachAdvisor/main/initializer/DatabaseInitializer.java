package com.VillasimiusBeachAdvisor.main.initializer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.VillasimiusBeachAdvisor.main.entity.Spiaggia;
import com.VillasimiusBeachAdvisor.main.service.SpiaggiaService;
import com.VillasimiusBeachAdvisor.main.util.DirezioneVento;

@Component
public class DatabaseInitializer {

    @Autowired
    private SpiaggiaService spiaggiaService;

    public void createSpiagge() {
        Spiaggia spiaggia1 = new Spiaggia();
        spiaggia1.setNome("Punta Molentis");
        spiaggia1.setLatitudine(39.133657);
        spiaggia1.setLongitudine(9.556157);
        spiaggia1.setDescrizione("La spiaggia di Punta Molentis è un angolo di paradiso nella costa dell'Area Marina Protetta di Capo Carbonara, caratterizzata da rocce granitiche, macchia mediterranea, un mare cristallino dai colori intensi.");
        spiaggia1.setImageUrl("../../../../assets/img/spiagge/puntamolentis.jpg");
        spiaggia1.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.MAESTRALE, DirezioneVento.PONENTE));
        spiaggia1.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.SCIROCCO, DirezioneVento.LEVANTE));
        
        spiaggia1.setStabilimentoBalneare(true);
        spiaggia1.setBar(true);
        spiaggia1.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia1);

        Spiaggia spiaggia2 = new Spiaggia();
        spiaggia2.setNome("Manunzas");
        spiaggia2.setLatitudine(39.132795);
        spiaggia2.setLongitudine(9.541897);
        spiaggia2.setDescrizione("La spiaggia di Manunzas offre un'oasi di tranquillità in un paesaggio selvaggio e incontaminato, con un arenile di ciottoli granitici e acque azzurro-blu, ideale per chi cerca serenità nella natura isolata.");
        spiaggia2.setImageUrl("../../../../assets/img/spiagge/manunzas.jpg");
        spiaggia2.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.PONENTE, DirezioneVento.LIBECCIO));
        spiaggia2.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.SCIROCCO, DirezioneVento.LEVANTE));
        
        spiaggia2.setStabilimentoBalneare(true);
        spiaggia2.setBar(true);
        spiaggia2.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia2);
        
        Spiaggia spiaggia3 = new Spiaggia();
        spiaggia3.setNome("Is Traias");
        spiaggia3.setLatitudine(39.130058);
        spiaggia3.setLongitudine(9.534712);
        spiaggia3.setDescrizione("Is Traias è una spiaggetta riparata e suggestiva nella costa meridionale della Sardegna, caratterizzata da sabbia chiara, acque verde-celesti e panorami mozzafiato, ma può essere affollata in alta stagione.");
        spiaggia3.setImageUrl("../../../../assets/img/spiagge/istraias.jpg");
        spiaggia3.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.PONENTE, DirezioneVento.LIBECCIO));
        spiaggia3.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.SCIROCCO, DirezioneVento.GRECALE));
        
        spiaggia3.setStabilimentoBalneare(true);
        spiaggia3.setBar(true);
        spiaggia3.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia3);
        
        Spiaggia spiaggia4 = new Spiaggia();
        spiaggia4.setNome("Simius");
        spiaggia4.setLatitudine(39.127192);
        spiaggia4.setLongitudine(9.529456);
        spiaggia4.setDescrizione("La spiaggia Simius, lunga 1,2 chilometri e considerata la \"spiaggia ufficiale\" di Villasimius, è famosa per la sua sabbia bianca e fine, il mare azzurro e la bellezza paesaggistica, attirando turisti, famiglie e giovani.");
        spiaggia4.setImageUrl("../../../../assets/img/spiagge/simius.jpg");
        spiaggia4.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.LIBECCIO, DirezioneVento.PONENTE));
        spiaggia4.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.SCIROCCO));
        
        spiaggia4.setStabilimentoBalneare(true);
        spiaggia4.setBar(true);
        spiaggia4.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia4);
        
        Spiaggia spiaggia5 = new Spiaggia();
        spiaggia5.setNome("Porto Giunco");
        spiaggia5.setLatitudine(39.115694);
        spiaggia5.setLongitudine(9.519291);
        spiaggia5.setDescrizione("Sabbia bianca e fine, mare verde smeraldo-blu, panorami spettacolari da Capo Carbonara, natura selvaggia e granito rosa. Affollata in alta stagione, ma con spazi per rilassarsi.");
        spiaggia5.setImageUrl("../../../../assets/img/spiagge/portogiunco.jpg");
        spiaggia5.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.LIBECCIO, DirezioneVento.PONENTE));
        spiaggia5.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.SCIROCCO, DirezioneVento.LEVANTE));
        
        spiaggia5.setStabilimentoBalneare(true);
        spiaggia5.setBar(true);
        spiaggia5.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia5);
        
        Spiaggia spiaggia6 = new Spiaggia();
        spiaggia6.setNome("Cala Giunco");
        spiaggia6.setLatitudine(39.111034);
        spiaggia6.setLongitudine(9.520502);
        spiaggia6.setDescrizione("Cala Giunco - descrizione");
        spiaggia6.setImageUrl("../../../../assets/img/spiagge/calagiunco.jpg");
        spiaggia6.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.LEVANTE));
        spiaggia6.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.MAESTRALE, DirezioneVento.PONENTE));
        
        spiaggia6.setStabilimentoBalneare(true);
        spiaggia6.setBar(true);
        spiaggia6.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia6);
        
        Spiaggia spiaggia7 = new Spiaggia();
        spiaggia7.setNome("Cava Usai");
        spiaggia7.setLatitudine(39.105904);
        spiaggia7.setLongitudine(9.518566);
        spiaggia7.setDescrizione("La spiaggia di Capo Carbonara, conosciuta anche come Cava Manna o Cava Usai, è una spiaggetta nascosta vicino a Porto su Forru. Caratterizzata da ciottoli, acque azzurre e fondali rocciosi, è ideale per snorkeling e pesca.");
        spiaggia7.setImageUrl("../../../../assets/img/spiagge/cavausai.jpg");
        spiaggia7.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.MAESTRALE, DirezioneVento.LIBECCIO));
        spiaggia7.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.SCIROCCO, DirezioneVento.LEVANTE));
        
        spiaggia7.setStabilimentoBalneare(true);
        spiaggia7.setBar(true);
        spiaggia7.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia7);
        
        Spiaggia spiaggia8 = new Spiaggia();
        spiaggia8.setNome("Cala Burroni");
        spiaggia8.setLatitudine(39.098239);
        spiaggia8.setLongitudine(9.522281);
        spiaggia8.setDescrizione("Cala Burroni, a Villasimius, è un'incantevole spiaggia sarda con sabbia dorata e acque cristalline. Circondata da scogliere e macchia mediterranea, offre un'atmosfera rilassante e panorami mozzafiato.");
        spiaggia8.setImageUrl("../../../../assets/img/spiagge/calaburroni.jpg");
        spiaggia8.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.LIBECCIO, DirezioneVento.PONENTE));
        spiaggia8.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.SCIROCCO));
        
        spiaggia8.setStabilimentoBalneare(true);
        spiaggia8.setBar(true);
        spiaggia8.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia8);
        
        Spiaggia spiaggia9 = new Spiaggia();
        spiaggia9.setNome("Cala Caterina");
        spiaggia9.setLatitudine(39.107057);
        spiaggia9.setLongitudine(9.507574);
        spiaggia9.setDescrizione("Cala Caterina è una frazione balneare di Villasimius, vicino all'Area Marina Protetta di Capo Carbonara. Offre spiagge incantevoli, vegetazione mediterranea, sport acquatici e siti archeologici.");
        spiaggia9.setImageUrl("../../../../assets/img/spiagge/calacaterina.jpg");
        spiaggia9.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.LEVANTE));
        spiaggia9.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.LIBECCIO, DirezioneVento.PONENTE));
        
        spiaggia9.setStabilimentoBalneare(true);
        spiaggia9.setBar(true);
        spiaggia9.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia9);
        
        Spiaggia spiaggia10 = new Spiaggia();
        spiaggia10.setNome("Santo Stefano");
        spiaggia10.setLatitudine(39.110214);
        spiaggia10.setLongitudine(9.505135);
        spiaggia10.setDescrizione("La spiaggia di Santo Stefano a Villasimius è un angolo di paradiso: acque cristalline, sabbia dorata e scogliere. Perfetta per snorkeling, relax e panorami mozzafiato.");
        spiaggia10.setImageUrl("../../../../assets/img/spiagge/santostefano.jpg");
        spiaggia10.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.SCIROCCO, DirezioneVento.LEVANTE));
        spiaggia10.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.LIBECCIO, DirezioneVento.PONENTE));
        
        spiaggia10.setStabilimentoBalneare(true);
        spiaggia10.setBar(true);
        spiaggia10.setIngressoCani(false);
        
        
        //spiaggiaService.createSpiaggia(spiaggia10);
        
        Spiaggia spiaggia11 = new Spiaggia();
        spiaggia11.setNome("Fortezza Vecchia");
        spiaggia11.setLatitudine(39.116094);
        spiaggia11.setLongitudine(9.505225);
        spiaggia11.setDescrizione("La Fortezza Vecchia di Villasimius è un'incantevole spiaggia sarda con acque cristalline, sabbia dorata e una vista mozzafiato sulla storica fortificazione. Un paradiso per relax e snorkeling.");
        spiaggia11.setImageUrl("../../../../assets/img/spiagge/fortezzavecchia.jpg");
        spiaggia11.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.SCIROCCO, DirezioneVento.LEVANTE));
        spiaggia11.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.MAESTRALE, DirezioneVento.TRAMONTANA));
        
        spiaggia11.setStabilimentoBalneare(true);
        spiaggia11.setBar(true);
        spiaggia11.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia11);
        
        Spiaggia spiaggia12 = new Spiaggia();
        spiaggia12.setNome("Spiaggia del Riso");
        spiaggia12.setLatitudine(39.120383);
        spiaggia12.setLongitudine(9.509363);
        spiaggia12.setDescrizione("La Spiaggia del Riso, famosa per la sabbia dorata e granelli quarzosi, offre un mare verde smeraldo, basso fondale, panorami spettacolari e contrasti cromatici tra vegetazione e scogli.");
        spiaggia12.setImageUrl("../../../../assets/img/spiagge/spiaggiadelriso.jpg");
        spiaggia12.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.LEVANTE));
        spiaggia12.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.MAESTRALE, DirezioneVento.PONENTE));
        
        spiaggia12.setStabilimentoBalneare(true);
        spiaggia12.setBar(true);
        spiaggia12.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia12);
        
        Spiaggia spiaggia13 = new Spiaggia();
        spiaggia13.setNome("Campulongu");
        spiaggia13.setLatitudine(39.128673);
        spiaggia13.setLongitudine(9.506373);
        spiaggia13.setDescrizione("La spiaggia di Campulongu offre un tratto di costa piatta con sabbia chiara e mare verde-azzurro. Nonostante costruzioni turistiche, offre panorami interessanti. Frequentata per servizi e vicinanza a Villasimius.");
        spiaggia13.setImageUrl("../../../../assets/img/spiagge/campulongu.jpg");
        spiaggia13.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.SCIROCCO));
        spiaggia13.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.MAESTRALE, DirezioneVento.LIBECCIO));
        
        spiaggia13.setStabilimentoBalneare(true);
        spiaggia13.setBar(true);
        spiaggia13.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia13);
        
        Spiaggia spiaggia14 = new Spiaggia();
        spiaggia14.setNome("Cuccureddus");
        spiaggia14.setLatitudine(39.132709);
        spiaggia14.setLongitudine(9.496345);
        spiaggia14.setDescrizione("La spiaggia di Cuccureddus offre sabbia bianca, mare turchese e natura incontaminata. Privata di servizi, è ideale per relax e vicino a siti archeologici nuragici e fenicio-punico-romani.");
        spiaggia14.setImageUrl("../../../../assets/img/spiagge/cuccureddus.jpg");
        spiaggia14.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.SCIROCCO));
        spiaggia14.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.PONENTE, DirezioneVento.LIBECCIO));
        
        spiaggia14.setStabilimentoBalneare(true);
        spiaggia14.setBar(true);
        spiaggia14.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia14);
        
        Spiaggia spiaggia15 = new Spiaggia();
        spiaggia15.setNome("Campus");
        spiaggia15.setLatitudine(39.135436);
        spiaggia15.setLongitudine(9.487503);
        spiaggia15.setDescrizione("Campus è una spiaggia nel Golfo di Carbonara con sabbia dorata, mare verde-ceruleo e panorami mozzafiato. Poco edificata, offre natura incontaminata e attrazioni per famiglie in alta stagione.");
        spiaggia15.setImageUrl("../../../../assets/img/spiagge/campus.jpg");
        spiaggia15.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.TRAMONTANA));
        spiaggia15.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.LIBECCIO, DirezioneVento.OSTRO));
        
        spiaggia15.setStabilimentoBalneare(true);
        spiaggia15.setBar(true);
        spiaggia15.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia15);
        
        Spiaggia spiaggia16 = new Spiaggia();
        spiaggia16.setNome("Piscadeddus");
        spiaggia16.setLatitudine(39.132376);
        spiaggia16.setLongitudine(9.472192);
        spiaggia16.setDescrizione("Caletta tranquilla tra Villaggio Mandorlì e Porto Sa Ruxi. Sabbia chiara, scogliere granitiche, mare verde smeraldo e fondale sabbioso. Ideale per relax lontano dalle folle.");
        spiaggia16.setImageUrl("../../../../assets/img/spiagge/piscadeddus.jpg");
        spiaggia16.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.TRAMONTANA));
        spiaggia16.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.LIBECCIO, DirezioneVento.OSTRO));
        
        spiaggia16.setStabilimentoBalneare(true);
        spiaggia16.setBar(true);
        spiaggia16.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia16);
        
        Spiaggia spiaggia17 = new Spiaggia();
        spiaggia17.setNome("Porto sa Ruxi");
        spiaggia17.setLatitudine(39.130243);
        spiaggia17.setLongitudine(9.454759);
        spiaggia17.setDescrizione("Porto Sa Ruxi è una località turistica in provincia del Sud Sardegna, con spiagge incantevoli, fondali turchesi e macchia mediterranea. Vicino a Villasimius, offre servizi e privacy per una vacanza ideale.");
        spiaggia17.setImageUrl("../../../../assets/img/spiagge/portosaruxi.jpg");
        spiaggia17.setOttimaDirezioneVento(Arrays.asList(DirezioneVento.GRECALE, DirezioneVento.TRAMONTANA));
        spiaggia17.setPessimaDirezioneVento(Arrays.asList(DirezioneVento.OSTRO, DirezioneVento.LIBECCIO));
        
        spiaggia17.setStabilimentoBalneare(true);
        spiaggia17.setBar(true);
        spiaggia17.setIngressoCani(false);
        
        //spiaggiaService.createSpiaggia(spiaggia17);
        
    }
}